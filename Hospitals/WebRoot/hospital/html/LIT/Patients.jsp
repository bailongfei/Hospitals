<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE>
<html>
<head>
<title>医生工作平台</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap-theme.min.css">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/zTree_v3/css/demo.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/zTree_v3/css/zTreeStyle/zTreeStyle.css">

<script
	src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script
	src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/js/zTree_v3/js/jquery.ztree.all.min.js"></script>
<style type="text/css">
.center_table tr td {
	
}

#pmodal {
	display: none;
}

.div-hidden {
	display: none;
}

.nav-pills li a {
	font-size: medium;
	font-weight: bold;
	font-family: serif;
	text-decoration: none;
}

#page-title {
	font-size: 30px;
	margin-left: 40%;
}

.lopCount {
	border: none;
}

.pager-li {
	cursor: hand;
}
</style>
<script type="text/javascript">
	$(function() {
		$("[data-toggle='tooltip']").tooltip();
	});
	$(function() {
		$("#pmodal").click();
		$.ajax({
			url : "${pageContext.request.contextPath}/patients_find.action",
			dataType : "json",
			type : "post",
			success : function(data) {
				var ary = data;

				for (var i = 0; i < ary.length; i++) {
					var obj = ary[i]; //获取当前对象
					var tr = "<tr>";
					tr += "<td>" + obj.id + "</td>";
					tr += "<td>" + obj.name + "</td>";
					tr += "<td>" + obj.sex + "</td>";
					tr += "<td>" + obj.age + "</td>";
					tr += "<td>" + obj.status + "</td>";
					tr += "<td class='div-hidden'>" + obj.idnumber + "</td>";
					tr += "</tr>";
					$("#tbody").append(tr); //追加行
				}
				;
				$("#tbody tr").click(function() {
					$("#close-modal").click();
					for (var i = 0; i < $(this).children().length; i++) {
						$("#patient" + i).val($(this).children().eq(i).html());
					}
					;
					$("#patientid").val($("#patient0").val());
					$(".p_name").val($("#patient1").val());
					$(".p_sex").val($("#patient2").val());
					$(".p_age").val($("#patient3").val());
					$("#mr_pid").val($("#patient0").val());
				})
			}
		})
	});

	/* ------------------------------------------------ */
</script>
<script type="text/javascript">
	/*更改病人就诊状态  */
	function updateStatus() {
		$.ajax({
			url : "${pageContext.request.contextPath}/patients_updateStatus.action",
			data : {
				"p.id" : $("#patient0").val(),
				"p.patientname" : $("#patient1").val(),
				"p.sex" : $("#patient2").val(),
				"p.age" : $("#patient3").val(),
				"p.status" : "就诊中", //更改就诊状态
				"p.idnumber" : $("#patient5").val(),
			},
			dataType : "text",
			type : "post",
			success : function(data) {}
		});
	}
	/*录入病人详细信息表 */
	function savaPatientDetail() {
		$.ajax({
			url : "${pageContext.request.contextPath}/patients_addDetail.action",
			data : $("#patientFormDetail").serialize(),
			dataType : "text",
			type : "post",
			success : function(data) {
				alert("录入成功");
			}
		});
	}
	/*录入病历  */
	function addMedicalRecord() {
		$.ajax({
			url : "${pageContext.request.contextPath}/patients_addMedicalRecord.action",
			data : $("#MRFormDetail").serialize(),
			dataType : "text",
			type : "post",
			success : function(data) {
				alert("病历录入成功");
			}
		});
	}
	/* 查询治疗类目 */
	var zjm; //声明对象获取当前操作的助记码对象
	$(document).on("keyup", ".tmzjm", function() {
		$(".patientids").val($("#patient0").val());
		$(".states").val("未付款");
		zjm = this;
		$.ajax({
			url : "${pageContext.request.contextPath}/patients_findTreatment.action",
			data : {
				"t.zjm" : $(this).val()
			},
			dataType : "json",
			type : "post",
			success : function(data) {
				$("#treatment").html("");
				var ary = data;
				for (var i = 0; i < ary.length; i++) {
					var obj = ary[i]; //获取当前对象
					var tr = "<tr>";
					tr += "<td>" + obj.zjm + "</td>";
					tr += "<td>" + obj.name + "</td>";
					tr += "<td>" + obj.monad + "</td>";
					tr += "<td>" + obj.count + "</td>";
					tr += "<td>" + obj.price + "</td>";
					tr += "</tr>";
					$("#treatment").append(tr); //追加行
				}
				;

				/*选择治疗项目*/
				$("#treatment tr").click(function() {
					/* for (var i = 0; i < $(this).children().length; i++) {
						$("#Treatbody tr td").children().eq(i).val($(this).children().eq(i).html());
					} */
					for (var i = 0; i < $(this).children().length; i++) {
						$(zjm).parent().parent().children().eq(i).children().val($(this).children().eq(i).html());
					}
					/*  金额计算*/
					$(".countMoney").val($(".count").val() * $(".price").val());
				});
			}
		});
	});
	/* ---------------- */
	/* ----处置--增加行input进行治疗表添加-- */
	var j = 1;
	function addtr() {
		var tr = "<tr>";
		tr += "<td><input type='text' class='tmzjm form-control'/></td>"
		tr += "	<td><input type='text' class='form-control' name='list[" + j + "].cureName'  readonly='readonly'/></td>"
		tr += "<td><input type='text' class='form-control' name='list[" + j + "].monad' readonly='readonly'/></td>"
		tr += "<td><input type='text' name='list[" + j + "].count' class='count form-control'/></td>"
		tr += "<td><input type='text' name='list[" + j + "].price' class='price form-control' readonly='readonly'/></td>"
		tr += "<td><input type='text' name='list[" + j + "].countMoney' class='countMoney form-control' readonly='readonly'/></td>"
		tr += "<td class='div-hidden states'><input type='text' name='list[" + j + "].state' readonly='readonly'/></td>"
		tr += "<td class='div-hidden'><input type='text' name='list[" + j + "].cureId'  readonly='readonly'/></td>"
		tr += "<td class='div-hidden patientids'><input type='text' class='patientids' name='list[" + j + "].patients.id' readonly='readonly'/></td>"
		tr += "</tr>";
		$("#Treatbody").append(tr);
		j++;
           
	}
	/*处方输入框增加  */
	var k = 1;
	function addtr1() {
		var tr = "<tr>";
		tr += "<td><input type='text' class='drugzjm form-control'/></td>"
		tr += "<td><input type='text' class='form-control'  readonly='readonly'/></td>"
		tr += "<td><input type='text' class='form-control' name='lopList[" + k + "].gg' readonly='readonly'/></td>"
		tr += "<td><input type='text' name='lopList[" + k + "].dw' class='form-control' readonly='readonly'/></td>"
		tr += "<td><input type='text' class='form-control' readonly='readonly'/></td>"
		tr += "<td><input type='text' name='lopList[" + k + "].dj' class='form-control' readonly='readonly'/></td>"
		tr += "<td><input type='text' class='form-control' name='lopList[" + k + "].drug.did' readonly='readonly'/></td>"
		tr += "<td><input type='text' class='form-control' name='lopList[" + k + "].sl' value='1'/></td>"
		tr += "<td><input type='text' class='form-control' name='lopList[" + k + "].je'  readonly='readonly'/></td>"
		tr += "</tr>";
		$("#PrescribeBody").append(tr);
		k++;

	}
	//添加处方、处方详情
	function addPrescribe() {
		$.ajax({
			url : "${pageContext.request.contextPath}/patients_addPrescribe.action",
			data : $("#PrescribeForm").serialize(),
			dataType : "text",
			type : "post",
			success : function(data1) {
				alert("添加成功");
				//Treatbody PrescribeBody
				
				$("PrescribeBody").html("");
			}
		})
	}
	/* ************************已开处方处置相关****************************** */
	/* 查询处方明细 */
	function findlop() {
		$.ajax({
			url : "${pageContext.request.contextPath}/patients_findLop.action",
			data : {
				"pid" : $("#patient0").val()
			},
			dataType : "json",
			type : "post",
			success : function(data) {
				$("#lopBody").html("");
				var ary = data;
				for (var i = 0; i < ary.length; i++) {
					var obj = ary[i]; //获取当前对象
					var tr = "<tr>";
					tr += "<td class='div-hidden'>" + obj.lid + "</td>";
					tr += "<td class='div-hidden'>" + obj.did + "</td>";
					tr += "<td>" + obj.dname + "</td>";
					tr += "<td>" + obj.gg + "</td>";
					tr += "<td>" + obj.dw + "</td>";
					tr += "<td style='width:2px'><input type='number' class='lopCount' readonly='readonly' value='" + obj.sl + "'/></td>";
					tr += "<td><button type='button' class='btn btn-default btn-sm bt_trash'><span class='glyphicon glyphicon-trash'></span></button></td>";
					tr += "<td><button type='button' class='btn btn-default btn-sm bt-pencil'><span class='glyphicon glyphicon-pencil'></span></button></td>";
					tr += "<td><button type='button' class='btn btn-default btn-sm bt-disk'><span class='glyphicon glyphicon-floppy-disk'></span></button></td>";
					tr += "</tr>";
					$("#lopBody").append(tr); //追加行
				}
			}
		})
	}
	/*绑定按钮事件  */
	/* 删除处方明细某一条 */
	var trash;
	$(document).on("click", ".bt_trash", function() {
		trash = this;
		$.ajax({
			url : "${pageContext.request.contextPath}/patients_deleteLop.action",
			data : {
				"lop.lid" : $(trash).parent().parent().children().eq(0).html()
			},
			dataType : "text",
			type : "post",
			success : function() {
				findlop();
			}
		})
	})
	/* 修改按钮 */
	var pencil;
	$(document).on("click", ".bt-pencil", function() {
		pencil = this;
		//alert($(pencil).parent().parent().children().eq(0).html());
		/* 删除属性 */
		$(pencil).parent().parent().children().eq(5).children().removeAttr("readonly");
		/* 设置样式 */
		$(pencil).parent().parent().children().eq(5).children().css("border", "1px solid red");
	})
	var disk;
	/*保存按钮  */
	$(document).on("click", ".bt-disk", function() {
		disk = this;
		/* 添加属性 */
		$(disk).parent().parent().children().eq(5).children().attr("readonly", "readonly");
		/* 设置样式 */
		$(disk).parent().parent().children().eq(5).children().css("border", "none");
		$.ajax({
			url : "${pageContext.request.contextPath}/patients_updateLop.action",
			data : {
				"lop.lid" : $(disk).parent().parent().children().eq(0).html(),
				"lop.sl" : $(disk).parent().parent().children().eq(5).children().val()
			},
			dataType : "text",
			type : "post",
			success : function() {
				alert("修改成功");
				findlop();
			}
		})
	})
	/*检查申请查询  */
	function findApplication() {
		//alert("查询检查申请" + $("#patient0").val());
		$.ajax({
			url : "${pageContext.request.contextPath}/patients_findApplication.action",
			data : {
				"patientsid" : $("#patient0").val()
			},
			dataType : "json",
			type : "post",
			success : function(data) {
				$("#applicationBody").html("");
				var ary = data;
				for (var i = 0; i < ary.length; i++) {
					var obj = ary[i];
					var tr = "<tr>";
					tr += "<td class='div-hidden'>" + obj.jcid + "</td>";
					tr += "<td class='div-hidden'>" + obj.pid + "</td>";
					tr += "<td class='div-hidden'>" + obj.aid + "</td>";
					tr += "<td>" + obj.aname + "</td>";
					tr += "<td>" + obj.point + "</td>";
					tr += "<td>" + obj.info + "</td>";
					tr += "<td>" + obj.goal + "</td>";
					tr += "<td>" + obj.state + "</td>";
					tr += "</tr>";
					$("#applicationBody").append(tr);
				}
			}
		})
	}
	/*检验申请查询  */
	function findInspection() {
		//alert("查询检查申请" + $("#patient0").val());
		$.ajax({
			url : "${pageContext.request.contextPath}/patients_findInspection.action",
			data : {
				"patientsid" : $("#patient0").val()
			},
			dataType : "json",
			type : "post",
			success : function(data) {
				$("#inspectionBody").html("");
				var ary = data;
				for (var i = 0; i < ary.length; i++) {
					var obj = ary[i];
					var tr = "<tr>";
					tr += "<td class='div-hidden'>" + obj.jcid + "</td>";
					tr += "<td class='div-hidden'>" + obj.pid + "</td>";
					tr += "<td class='div-hidden'>" + obj.aid + "</td>";
					tr += "<td>" + obj.aname + "</td>";
					tr += "<td>" + obj.point + "</td>";
					tr += "<td>" + obj.info + "</td>";
					tr += "<td>" + obj.goal + "</td>";
					tr += "<td>" + obj.state + "</td>";
					tr += "</tr>";
					$("#inspectionBody").append(tr);
				}
			}
		})
	}

	/**********************************************************************/
	/**********************************************************************/
	/**********************************************************************/
	/* 添加治疗表 */
	function addCure() {
		//alert("点击了");
		$.ajax({
			url : "${pageContext.request.contextPath}/patients_addCure.action",
			data : $("#cureForm").serialize(),
			dataType : "text",
			type : "post",
			success : function(data1) {
				/* alert(data1);
				alert($("#cureForm").serialize()); */
				alert("添加治疗成功");
			}
		})
	}

	/* 处方--药品查询 */
	var drugzjm;
	$(document).on("keyup", ".drugzjm", function() {
		//患者id赋值
		$(".ppatientids").val($("#patient0").val());
		drugzjm = this;
		findAll(1);

	})
	function findAll(curPage) {
		//alert(curPage);

		$.ajax({
			url : "${pageContext.request.contextPath}/patients_findDrugs.action",
			data : {
				"drug.zhuji" : $(drugzjm).val(),
				"pager.curPage" : curPage
			},
			dataType : "json",
			type : "post",
			success : function(data) {
				$("#DrugBody").html("");
				var ary = data.list;
				for (var i = 0; i < ary.length; i++) {
					var obj = ary[i];
					var tr = "<tr>";
					tr += "<td>" + obj.zhuji + "</td>"; //助记码

					tr += "<td>" + obj.dName + "</td>"; //药品名称
					/* tr += "<td>" + obj.spec + "</td>"; */ //药品规格
					tr += "<td>" + obj.duName + "</td>"; //剂量单位
					tr += "<td>" + obj.dfName + "</td>"; //剂型名称
					tr += "<td>" + obj.aName + "</td>"; //地址
					tr += "<td>" + obj.price + "</td>"; //价钱
					tr += "<td class='div-hidden'>" + obj.did + "</td>"; //药品id
					tr += "</tr>";
					$("#DrugBody").append(tr); //追加行
				}
				/* 选择药品 */
				$("#DrugBody tr").click(function() {
					for (var i = 0; i < $(this).children().length; i++) {
						$(drugzjm).parent().parent().children().eq(i).children().val($(this).children().eq(i).html());
					}
				})
				$("#curPage").html(data.curPage);
				$("#totalPages").html(data.totalPages);
				$("#first").attr("data", data.first);
				$("#prev").attr("data", data.prev);
				$("#next").attr("data", data.next);
				$("#last").attr("data", data.last);
				$("#txtCurPage").val(data.curPage).attr("max", data.last)
			}
		})
	}
	//改变页面
	function changePage(obj) {
		var page = $(obj).attr("data"); //取出data属性值
		findAll(page);
	}
	//跳转到指定页面
	function gotoPage(page) {
		var page = $("#txtCurPage").val();
		findAll(page);
	}
	/*  */
	/*查询检查项目*/
	function selectAppItem() {
		$.ajax({
			url : "${pageContext.request.contextPath}/patients_findAppItem.action",
			dataType : "json",
			type : "post",
			success : function(data) {
				$("#selectAppItem").html("");
				$("#selectAppItem").append("<option value='0'>--请选择检查项目--</option>");
				for (var i = 0; i < data.length; i++) {
					$("#selectAppItem").append("<option value='" + data[i].jcxId + "' class='appName'>" + data[i].name + "</option>");
				}
				;
				$("#selectAppItem").change(function() {
					$.ajax({
						url : "${pageContext.request.contextPath}/patients_findAppItemInfo.action",
						data : {
							"jcxId" : $("#selectAppItem").val()
						},
						dataType : "json",
						type : "post",
						success : function(data) {
							$("#appItemInfosth").children().eq(0).remove();
							$("#appItemInfos").html("");
							var ary = data;
							for (var i = 0; i < ary.length; i++) {
								var obj = ary[i];
								var tr = "<tr>";
								//tr+="<td><input type='checkbox' name='checkItem'/></td>";
								tr += "<td class='appAid'><input type='text' value='" + obj.aid + "'/></td>";
								tr += "<td>" + obj.aname + "</td>";
								tr += "<td>" + obj.jcxId + "</td>";
								tr += "<td>" + obj.count + "</td>";
								tr += "<td>" + obj.price + "</td>";
								tr += "</tr>";
								$("#appItemInfos").append(tr);

							}

							$(function() {
								function initTableCheckbox() {
									var $thr = $('.table-appAndIns thead tr');
									var $checkAllTh = $('<th><input type="checkbox" id="checkAll" name="checkAll" /></th>');
									/*将全选/反选复选框添加到表头最前，即增加一列*/
									$thr.prepend($checkAllTh);
									/*“全选/反选”复选框*/
									var $checkAll = $thr.find('input');
									$checkAll.click(function(event) {
										/*将所有行的选中状态设成全选框的选中状态*/
										$tbr.find('input').prop('checked', $(this).prop('checked'));
										/*并调整所有选中行的CSS样式*/
										if ($(this).prop('checked')) {
											//alert("选中");
											$tbr.find('input').parent().parent().addClass('warning');
										} else {
											//alert("没选中");
											$tbr.find('input').parent().parent().removeClass('warning');
										}
										/*阻止向上冒泡，以防再次触发点击操作*/
										event.stopPropagation();
									});

									/*点击全选框所在单元格时也触发全选框的点击操作*/
									$checkAllTh.click(function() {
										$(this).find('input').click();
									});
									var $tbr = $('.table-appAndIns tbody tr');
									var $checkItemTd = $('<td><input type="checkbox" name="checkItem"/></td>');
									/*每一行都在最前面插入一个选中复选框的单元格*/
									$tbr.prepend($checkItemTd);
									/*点击每一行的选中复选框时*/
									$tbr.find('input').click(function(event) {
										/*调整选中行的CSS样式*/
										if ($(this).prop('checked')) {
											//alert("选中");
											$(this).parent().parent().children().eq(1).children().eq(0).attr("name", "appList");
										} else {
											//alert("没选中");
											$(this).parent().parent().children().eq(1).children().eq(0).removeAttr("name");
										}
										$(this).parent().parent().toggleClass('warning');
										/*如果已经被选中行的行数等于表格的数据行数，将全选框设为选中状态，否则设为未选中状态*/
										$checkAll.prop('checked', $tbr.find('input:checked').length == $tbr.length ? true : false);
										/*阻止向上冒泡，以防再次触发点击操作*/
										event.stopPropagation();
									});

									/*点击每一行时也触发该行的选中操作*/
									$tbr.click(function() {
										$(this).find('input').click();
									});


								}
								initTableCheckbox();
							});

						}
					})
				});

			}
		})
	}
	/* 判断 */
	/* $("#appItemInfos").on("click", ".ifcheck", function() {
		alert("点击了");
		if ($(".appcheckbox").attr("checked")) {
			alert("yes");
		} else {
			alert("no");
		}
	}) */
	/*添加申请检查表  */
	function addAppItem() {
		$(".appState").val("待检查");
		$(".patientids").val($("#patient0").val());
		$.ajax({
			url : "${pageContext.request.contextPath}/patients_addAppItem.action",
			/* data : {
				"applicationform.patients.id" : $(".patientids").val(),
				"applicationform.applicationitem.jcxId" : $("#selectAppItem").val(),
				"applicationform.checkPoint" : $(".checkPoint").val(),
				"applicationform.mainInfo" : $(".mainInfo").val(),
				"applicationform.goal" : $(".goal").val(),
				"applicationform.state" : $(".appState").val(),
				"appList":$(checkboxs).val()
			}, */
			data : $("#appForm").serialize(),
			dataType : "text",
			type : "post",
			success : function() {
				//添加成功后清空input数据，并且把select变为默认值1；
				alert("添加检查申请成功");
				$("#selectAppItem").val(1),
				$(".checkPoint").val(""),
				$(".mainInfo").val(""),
				$(".goal").val("")
			}
		})
	}
	/* 添加检验申请表 */
	/*计算金额  */
	$(document).on("focus", ".count"), function() {
		alert("计算");
		$(".countMoney").val(($(".count").val() * $(".price").val()));
	}
	/* 检验类目查询 */
	function selectInsItem() {
		$.ajax({
			url : "${pageContext.request.contextPath}/patients_findInsItem.action",
			dataType : "json",
			type : "post",
			success : function(data) {
				$("#selectInsItem").html("");
				$("#selectInsItem").append("<option value='0'>--请选择检验项目--</option>");
				for (var i = 0; i < data.length; i++) {
					$("#selectInsItem").append("<option value='" + data[i].jyxId + "' class='iappName'>" + data[i].name + "</option>");
				}
				$("#selectInsItem").change(function() {
					$.ajax({
						url : "${pageContext.request.contextPath}/patients_findInsItemInfo.action",
						data : {
							"jyxId" : $("#selectInsItem").val()
						},
						dataType : "json",
						type : "post",
						success : function(data) {
							$("#InsItemInfosth").children().eq(0).remove();
							$("#InsItemInfos").html("");
							var ary = data;
							for (var i = 0; i < ary.length; i++) {
								var obj = ary[i];
								var tr = "<tr>";
								//tr+="<td><input type='checkbox' name='checkItem'/></td>";
								//tr += "<td class='appAid'>" + obj.iid + "</td>";
								tr += "<td class='insiid'><input type='text' value='" + obj.iid + "'/></td>";
								tr += "<td>" + obj.iname + "</td>";
								tr += "<td>" + obj.jyxId + "</td>";
								tr += "<td>" + obj.count + "</td>";
								tr += "<td>" + obj.price + "</td>";
								tr += "</tr>";
								$("#InsItemInfos").append(tr);

							}
							$(function() {
								function initTableCheckbox1() {
									var $thr = $('.table-appAndIns1 thead tr');
									var $checkAllTh = $('<th><input type="checkbox" id="checkAll1" name="checkAll"/></th>');
									/*将全选/反选复选框添加到表头最前，即增加一列*/
									$thr.prepend($checkAllTh);
									/*“全选/反选”复选框*/
									var $checkAll = $thr.find('input');
									$checkAll.click(function(event) {
										/*将所有行的选中状态设成全选框的选中状态*/
										$tbr.find('input').prop('checked', $(this).prop('checked'));
										/*并调整所有选中行的CSS样式*/
										if ($(this).prop('checked')) {
											$tbr.find('input').parent().parent().addClass('warning');
										} else {
											$tbr.find('input').parent().parent().removeClass('warning');
										}
										/*阻止向上冒泡，以防再次触发点击操作*/
										event.stopPropagation();
									});
									/*点击全选框所在单元格时也触发全选框的点击操作*/
									$checkAllTh.click(function() {
										$(this).find('input').click();
									});
									var $tbr = $('.table-appAndIns1 tbody tr');
									var $checkItemTd = $('<td><input type="checkbox" name="checkItem"/></td>');
									/*每一行都在最前面插入一个选中复选框的单元格*/
									$tbr.prepend($checkItemTd);
									/*点击每一行的选中复选框时*/
									$tbr.find('input').click(function(event) {
										/*调整选中行的CSS样式*/
										if ($(this).prop('checked')) {
											$(this).parent().parent().children().eq(1).children().eq(0).attr("name", "insList");
										} else {
											$(this).parent().parent().children().eq(1).children().eq(0).removeAttr("name");
										}
										$(this).parent().parent().toggleClass('warning');
										/*如果已经被选中行的行数等于表格的数据行数，将全选框设为选中状态，否则设为未选中状态*/
										$checkAll.prop('checked', $tbr.find('input:checked').length == $tbr.length ? true : false);
										/*阻止向上冒泡，以防再次触发点击操作*/
										event.stopPropagation();
									});

									/*点击每一行时也触发该行的选中操作*/
									$tbr.click(function() {
										$(this).find('input').click();
									});
								}
								initTableCheckbox1();
							});
						}
					})

				});
			}
		})
	}

	/*添加申请检验表  */
	function addInsItem() {
		$(".iappState").val("待检验");
		$(".ipatientids").val($("#patient0").val());
		$.ajax({
			url : "${pageContext.request.contextPath}/patients_addInsItem.action",
			/* data : {
				"inspection.patients.id" : $(".ipatientids").val(),
				"inspection.inspectionitem.jyxId" : $("#selectInsItem").val(),
				"inspection.checkPoint" : $(".icheckPoint").val(),
				"inspection.maininfo" : $(".imainInfo").val(),
				"inspection.goal" : $(".igoal").val(),
				"inspection.state" : $(".iappState").val()
			}, */
			data : $("#insForm").serialize(),
			dataType : "text",
			type : "post",
			success : function() {
				//添加成功后清空input数据，并且把select变为默认值1；
				alert("添加检验申请成功");
				$("#selectInsItem").val(1),
				$(".icheckPoint").val(""),
				$(".imainInfo").val(""),
				$(".igoal").val("")
			}
		})
	}
</script>
</head>
<body>
	<div class="alert alert-success alert-dismissable">
			<span id="page-title">坐诊医生工作平台</span>
   </div>
	<button class="btn btn-primary btn-lg" id="pmodal" data-toggle="modal"
		data-target="#myModal"></button>

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close div-hidden" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">排队患者列表</h4>
				</div>
				<div class="modal-body">
					<table class="table table-hover">
						<caption>请选择患者进行诊疗</caption>
						<thead>
							<tr>
								<th>患者编号</th>
								<th>患者姓名</th>
								<th>性别</th>
								<th>年龄</th>
								<th>就诊状态</th>
							</tr>
						</thead>
						<tbody id="tbody">

						</tbody>
					</table>
				</div>
				<div class="modal-footer div-hidden">
					<button type="button" class="btn btn-default" data-dismiss="modal"
						id="close-modal">关闭</button>
					<button type="button" class="btn btn-primary">提交更改</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<!------------------------导航栏------------------------- -->
	<div class="container">
		<!-- <h2>动态标签</h2>
  <p><strong>提示:</strong> 与 .tab-pane 和 data-toggle="tab" (data-toggle="pill" ) 一同使用, 设置标签页对应的内容随标签的切换而更改。</p> -->
		<ul class="nav-justified nav nav-pills">
			<li class="active"><a data-toggle="tab" href="#home">病人信息</a></li>
			<li><a data-toggle="tab" href="#menu1">书写病历</a></li>
			<li><a data-toggle="tab" href="#menu2">处置</a></li>
			<li><a data-toggle="tab" href="#menu3">处方</a></li>
			<li><a data-toggle="tab" href="#menu4" onclick="selectAppItem()">检查申请</a></li>
			<li><a data-toggle="tab" href="#menu5" onclick="selectInsItem()">检验申请</a></li>
			<li><a data-toggle="tab" href="#menu6">已开处方处置</a></li>
		</ul>
		<br>
		<div class="tab-content">
			<div id="home" class="tab-pane fade in active">
				<!--  ------------------------网格系统--------------------->
				<div class="container">
					<form class="bs-example bs-example-form" role="form"
						id="patientForm">
						<div class="row">
							<div class="col-md-3 div-hidden">
								<div class="input-group">
									<span class="input-group-addon">患者ID</span> <input type="text"
										class="form-control" id="patient0" placeholder="请输入患者姓名">
								</div>
							</div>
							<div class="col-md-3">
								<div class="input-group">
									<span class="input-group-addon">患者姓名</span> <input type="text"
										class="form-control" id="patient1" placeholder="请输入患者姓名">
								</div>
							</div>
							<div class="col-md-3">
								<div class="input-group">
									<span class="input-group-addon">性别</span> <input type="text"
										class="form-control" id="patient2" placeholder="请输入患者性别">
								</div>
							</div>
							<div class="col-md-3">
								<div class="input-group">
									<span class="input-group-addon">年龄</span> <input type="text"
										class="form-control" id="patient3" placeholder="请输入患者年龄">
								</div>
							</div>
							<div class="col-md-3 div-hidden">
								<div class="input-group">
									<span class="input-group-addon">就诊状态</span> <input type="text"
										class="form-control" id="patient4" placeholder="请输入患者年龄">
								</div>
							</div>
							<div class="col-md-3 div-hidden">
								<div class="input-group">
									<span class="input-group-addon">身份证号</span> <input type="text"
										class="form-control" id="patient5" placeholder="请输入患者身份证号码">
								</div>
							</div>
							<div class="col-md-3">
								<div class="input-group">
									<input type="button"
										class="btn btn-primary  data-toggle='tooltip' data-placement='right'"
										onclick="updateStatus()" title="1111" value="确认患者信息">

								</div>
							</div>
						</div>
					</form>
				</div>
				<hr>

				<!--------------------------网格2------------------------------------------->
				<div class="container">
					<form class="bs-example bs-example-form" role="form"
						id="patientFormDetail">
						<div class="row">
							<div class="col-md-3 div-hidden">
								<div class="input-group">
									<span class="input-group-addon">患者详情ID</span> <input
										type="text" class="form-control" name="pd.patientId"
										placeholder="请输入患者详情ID">
								</div>
							</div>
							<div class="col-md-3 div-hidden">
								<div class="input-group">
									<span class="input-group-addon">患者ID</span> <input type="text"
										class="form-control" name="pd.patients.id"
										placeholder="请输入患者ID名" id="patientid">
								</div>
							</div>
							<div class="col-md-6">
								<div class="input-group">
									<span class="input-group-addon">患者性质</span> <input type="text"
										class="form-control" name="pd.patientType"
										placeholder="请输入患者性质">
								</div>
							</div>
							<div class="col-md-3">
								<div class="input-group">
									<span class="input-group-addon">手机号</span> <input type="text"
										class="form-control" name="pd.phone" placeholder="请输入患者手机号">
								</div>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-3">
								<div class="input-group">
									<span class="input-group-addon">民族</span> <input type="text"
										class="form-control" name="pd.nation" placeholder="请输入患者民族">
								</div>
							</div>
							<div class="col-md-3">
								<div class="input-group">
									<span class="input-group-addon">婚姻</span> <input type="text"
										class="form-control" name="pd.marry" placeholder="请输入患者婚姻状态">
								</div>
							</div>
							<div class="col-md-3">
								<div class="input-group">
									<span class="input-group-addon">血型</span> <input type="text"
										class="form-control" name="pd.blood" placeholder="请输入患者血型">
								</div>
							</div>
							<div class="col-md-3">
								<div class="input-group">
									<span class="input-group-addon">职业</span> <input type="text"
										class="form-control" name="pd.job" placeholder="请输入患者职业">
								</div>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-6">
								<div class="input-group">
									<span class="input-group-addon">家庭住址</span> <input type="text"
										class="form-control" name="pd.homeAddress"
										placeholder="请输入患者家庭住址">
								</div>
							</div>
							<div class="col-md-6">
								<div class="input-group">
									<span class="input-group-addon">工作地址</span> <input type="text"
										class="form-control" name="pd.workAddress"
										placeholder="请输入患者工作住址">
								</div>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-4">
								<div class="input-group">
									<span class="input-group-addon">患者来源</span> <input type="text"
										class="form-control" name="pd.sources" placeholder="请输入患者来源">
								</div>
							</div>
							<div class="col-md-4">
								<div class="input-group">
									<span class="input-group-addon">过敏药物</span> <input type="text"
										class="form-control" name="pd.allergic"
										placeholder="请输入患者过敏药物">
								</div>
							</div>
							<div class="col-md-4">
								<div class="input-group">
									<span class="input-group-addon">病案号</span> <input type="text"
										class="form-control" name="pd.medicalRecord"
										placeholder="复诊病人请输入病案号">
								</div>
							</div>
						</div>
						<br> <br>
						<div class="row">
							<div class="col-md-5"></div>
							<div class="col-md-2">
								<button type="button" class="btn btn-primary"
									onclick="savaPatientDetail()">提 交 患 者 信 息</button>
								<!-- <input type="button" class="btn btn-primary" class="form-control" value="提交患者信息"> -->
							</div>
							<div class="col-md-5"></div>

						</div>
					</form>
				</div>
			</div>
			<div id="menu1" class="tab-pane fade">
				<div class="container">
					<div class="row">
						<div class="col-md-4">
							<div class="input-group">
								<span class="input-group-addon">患者姓名</span> <input type="text"
									class="form-control p_name" placeholder="请输入患者姓名" disabled>
							</div>
						</div>
						<div class="col-md-4">
							<div class="input-group">
								<span class="input-group-addon">性别</span> <input type="text"
									class="form-control p_sex" placeholder="请输入患者性别"
									readonly="readonly">
							</div>
						</div>
						<div class="col-md-4">
							<div class="input-group">
								<span class="input-group-addon">年龄</span> <input type="text"
									class="form-control p_age" placeholder="请输入患者年龄"
									readonly="readonly">
							</div>
						</div>
					</div>
					<hr>
					<form class="bs-example bs-example-form" role="form"
						id="MRFormDetail">
						<div class="row">

							<div class="col-md-12">
								<div class="input-group">
									<span class="input-group-addon">病人主诉</span> <input type="text"
										class="form-control" name="mr.zhushu"
										placeholder="请输入患者自身描述身体的不适之项">
								</div>
								<div class="input-group div-hidden">
									<span class="input-group-addon">患者id</span> <input type="text"
										class="form-control" name="mr.patients.id"
										placeholder="请输入患者id" id="mr_pid">
								</div>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-4 ">
								<div class="input-group">
									<span class="input-group-addon">既往史</span> <input type="text"
										class="form-control" name="mr.bingshi" placeholder="请输入患者以往病史">
								</div>
							</div>
							<div class="col-md-4 ">
								<div class="input-group">
									<span class="input-group-addon">过敏史</span> <input type="text"
										class="form-control" name="mr.guomins"
										placeholder="请输入患者以往过敏药物">
								</div>
							</div>
							<div class="col-md-4 ">
								<div class="input-group">
									<span class="input-group-addon">家族史</span> <input type="text"
										class="form-control" name="mr.jiazhus"
										placeholder="请输入患者家庭遗传病史">
								</div>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-12">
								<div class="input-group">
									<span class="input-group-addon">现病史</span> <input type="text"
										class="form-control" name="mr.xianbins"
										placeholder="请输入患者现在病症详情">
								</div>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-12">
								<div class="input-group">
									<span class="input-group-addon">体征</span> <input type="text"
										class="form-control" name="mr.tizheng"
										placeholder="请输入患者的身高体重等...">
								</div>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-12">
								<div class="input-group">
									<span class="input-group-addon">处理</span> <input type="text"
										class="form-control" name="mr.chuli"
										placeholder="请输入将要进行对患者医治策略概述">
								</div>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-12">
								<div class="input-group">
									<span class="input-group-addon">治疗建议</span> <input type="text"
										class="form-control" name="mr.curesuggest"
										placeholder="请输入治疗建议">
								</div>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-12">
								<div class="input-group">
									<span class="input-group-addon">就诊时间</span> <input type="date"
										class="form-control" name="mr.visitTime3"
										placeholder="请输入建议患者下次复诊时间">
								</div>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-5"></div>
							<div class="col-md-2">
								<button type="button" class="btn btn-primary"
									onclick="addMedicalRecord()">提 交 患 者 信 息</button>
								<!-- <input type="button" class="btn btn-primary" class="form-control" value="提交病历信息"> -->
							</div>
							<div class="col-md-5"></div>

						</div>
					</form>

				</div>
			</div>
			<!-- 菜单 处置-->
			<div id="menu2" class="tab-pane fade">
				<div class="container">
					<div class="row">
						<div class="col-md-4">
							<div class="input-group">
								<span class="input-group-addon">患者姓名</span> <input type="text"
									class="form-control p_name" placeholder="请输入患者姓名"
									readonly="readonly">
							</div>
						</div>
						<div class="col-md-4">
							<div class="input-group">
								<span class="input-group-addon">性别</span> <input type="text"
									class="form-control p_sex" placeholder="请输入患者性别"
									readonly="readonly">
							</div>
						</div>
						<div class="col-md-4">
							<div class="input-group">
								<span class="input-group-addon">年龄</span> <input type="text"
									class="form-control p_age" placeholder="请输入患者年龄"
									readonly="readonly">
							</div>
						</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-md-5"></div>
						<div class="col-md-2">
							<button type="button" class="btn btn-primary" onclick="addtr()">增加一行</button>
						</div>
						<div class="col-md-5"></div>

					</div>
					<form id="cureForm">
						<table class="table table-bordered">
							<caption>边框表格布局</caption>
							<thead>
								<tr>
									<th>助记码</th>
									<th>项目名称</th>
									<th>计量单位</th>
									<th>数量</th>
									<th>单价</th>
									<th>金额</th>
								</tr>
							</thead>

							<tbody id="Treatbody">

								<tr>
									<td><input type="text" class="tmzjm form-control" /></td>
									<td><input type="text" class="form-control"
										name="list[0].cureName" id="cureName1" readonly="readonly" /></td>
									<td><input type="text" class="form-control"
										name="list[0].monad" id="monad1" readonly="readonly" /></td>
									<td><input type="text" name="list[0].count"
										class="count form-control" id="count1"></td>
									<td><input type="text" name="list[0].price"
										class="price form-control" id="price1" readonly="readonly" /></td>
									<td><input type="text" name="list[0].countMoney"
										class="countMoney form-control" id="countMoney1"
										readonly="readonly" /></td>
									<td class="div-hidden"><input type="text"
										name="list[0].state" class="state" id="state1"
										readonly="readonly" /></td>
									<td class="div-hidden"><input type="text"
										name="list[0].cureId" id="cureId1" readonly="readonly" /></td>
									<td class="div-hidden"><input type="text"
										name="list[0].patients.id" class="patientids" id="patientsid1"
										readonly="readonly" /></td>

								</tr>

							</tbody>

						</table>
					</form>
					<div class="row">
						<div class="col-md-5"></div>
						<div class="col-md-2">
							<input type="button" value="提交" class="btn btn-primary" onclick="addCure()" />
						</div>
						<div class="col-md-5"></div>

					</div>

					<!--治疗类目表  -->
					<table class="table table-bordered">

						<thead>
							<tr>
								<th>助记码</th>
								<th>项目名称</th>
								<th>计量单位</th>
								<th>数量</th>
								<th>单价</th>
							</tr>
						</thead>
						<tbody id="treatment">


						</tbody>
					</table>
				</div>
			</div>
			<div id="menu3" class="tab-pane fade">
				<div class="container">
					<div class="row">
						<div class="col-md-4">
							<div class="input-group">
								<span class="input-group-addon">患者姓名</span> <input type="text"
									class="form-control p_name" placeholder="请输入患者姓名"
									readonly="readonly">
							</div>
						</div>
						<div class="col-md-4">
							<div class="input-group">
								<span class="input-group-addon">性别</span> <input type="text"
									class="form-control p_sex" placeholder="请输入患者性别"
									readonly="readonly">
							</div>
						</div>
						<div class="col-md-4">
							<div class="input-group">
								<span class="input-group-addon">年龄</span> <input type="text"
									class="form-control p_age" placeholder="请输入患者年龄"
									readonly="readonly">
							</div>
						</div>
					</div>
					<hr>
					<!-- 处方 -->
					<div class="row">
						<div class="col-md-5"></div>
						<div class="col-md-2">
							<button type="button" class="btn btn-primary" onclick="addtr1()">增加一行</button>
						</div>
						<div class="col-md-5"></div>

					</div>
					<form class="bs-example bs-example-form" role="form"
						id="PrescribeForm">
						<table class="table table-bordered">
							<caption>边框表格布局</caption>
							<thead>
								<tr>
									<th>助记码</th>
									<th>药品名称</th>
									<th>剂量单位</th>
									<th>剂量名称</th>
									<th>地址</th>
									<th>单价</th>
									<th>药品id</th>
									<th>数量</th>
									<th>金额</th>
								</tr>
							</thead>

							<tbody id="PrescribeBody">
								<tr>
									<!-- 助记码 -->
									<td><input type="text" class="form-control drugzjm" /></td>
									<!--药品名称  -->
									<td><input type="text" class="form-control"
										readonly="readonly" /></td>
									<!-- 剂量单位 -->
									<td><input type="text" class="form-control"
										name="lopList[0].gg" readonly="readonly" /></td>
									<!-- 剂型名称 -->
									<td><input type="text" class="form-control"
										name="lopList[0].dw" readonly="readonly" /></td>
									<!-- 产地 -->
									<td><input type="text" class="form-control"
										readonly="readonly" /></td>
									<!-- 单价 -->
									<td><input type="text" class="form-control"
										name="lopList[0].dj" readonly="readonly" /></td>

									<!-- 药品ID -->
									<td><input type="text" class="form-control"
										name="lopList[0].drug.did" readonly="readonly" /></td>

									<!-- 数量 -->
									<td><input type="text" class="form-control"
										name="lopList[0].sl" value="1" /></td>

									<!-- 金额 -->
									<td class=""><input class="form-control" type="text"
										name="lopList[0].je" readonly="readonly" /></td>

									<!-- 患者id -->
									<td class="div-hidden"><input
										class="form-control ppatientids" type="text"
										name="prescribe.patients.id" readonly="readonly" /></td>
								</tr>

							</tbody>
						</table>
						<div class="row">
							<div class="col-md-5"></div>
							<div class="col-md-2">
								<button type="button" class="btn btn-primary"
									onclick="addPrescribe()">确认方案</button>
								<!-- <input type="button" class="btn btn-primary" class="form-control" value="提交病历信息"> -->
							</div>
							<div class="col-md-5"></div>

						</div>
					</form>
					<!--药品总表查询动态显示  -->
					<table class="table table-bordered">

						<thead>
							<tr>
								<th>助记码</th>
								<th>药品名称</th>
								<th>药品规格</th>
								<th>剂型</th>
								<th>产地</th>
								<th>单价</th>
							</tr>
						</thead>
						<tbody id="DrugBody">


						</tbody>
					</table>
					<ul class="pager">
						<li>当前页:<span id="curPage"></span>总页数:<span id="totalPages"></span>
						</li>
						<li class="pager-li"><a id="first" onclick="changePage(this)">首页</a></li>
						<li class="pager-li"><a id="prev" onclick="changePage(this)">上一页</a></li>
						<li class="pager-li"><a id="next" onclick="changePage(this)">下一页</a></li>
						<li class="pager-li"><a id="last" onclick="changePage(this)">尾页</a></li>
						<li class="pager-li"><input type="number" id="txtCurPage"
							min="1" max="10"></input><input type="button" value="go"
							onclick="gotoPage()" /></li>
					</ul>
				</div>
			</div>
			<div id="menu4" class="tab-pane fade">
				<div class="container">
					<div class="row">
						<div class="col-md-4">
							<div class="input-group">
								<span class="input-group-addon">患者姓名</span> <input type="text"
									class="form-control p_name" placeholder="请输入患者姓名"
									readonly="readonly">
							</div>
						</div>
						<div class="col-md-4">
							<div class="input-group">
								<span class="input-group-addon">性别</span> <input type="text"
									class="form-control p_sex" placeholder="请输入患者性别"
									readonly="readonly">
							</div>
						</div>
						<div class="col-md-4">
							<div class="input-group">
								<span class="input-group-addon">年龄</span> <input type="text"
									class="form-control p_age" placeholder="请输入患者年龄"
									readonly="readonly">
							</div>
						</div>
					</div>
					<hr>
					<!-- 表单！！！！！！！！！！！！ -->
					<form action="" id="appForm">
						<div class="row">
							<div class="col-md-2">
								<div class="form-group">
									<!-- <span class="input-group-addon">检验科室</span> -->
									<select class="form-control" id="selectAppItem"
										name="applicationform.applicationitem.jcxId">
									</select>
								</div>
							</div>
							<div class="col-md-4">
								<div class="input-group">
									<span class="input-group-addon">检查部位</span> <input type="text"
										class="form-control checkPoint" placeholder="请输入检查部位"
										name="applicationform.checkPoint">
								</div>
							</div>
							<div class="col-md-4 div-hidden">
								<div class="input-group">
									<span class="input-group-addon">患者id</span> <input type="text"
										class="form-control patientids" placeholder="请输入id"
										name="applicationform.patients.id">
								</div>
							</div>
							<div class="col-md-4 div-hidden">
								<div class="input-group">
									<span class="input-group-addon">状态</span> <input type="text"
										class="form-control appState" placeholder="请输入状态"
										name="applicationform.state">
								</div>
							</div>

						</div>
						<!-- 表格 -->
						<div class="row">
							<!-- ********************************************************************************************************** -->
							<div class="panel-group">
								<div class="panel panel-primary">
									<div class="panel-heading">列表</div>
									<div class="panel-body">
										<!-- <div class="list-op" id="list_op">  
                        <button type="button" class="btn btn-default btn-sm">  
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增  
                        </button>  
                        <button type="button" class="btn btn-default btn-sm">  
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改  
                        </button>  
                        <button type="button" class="btn btn-default btn-sm">  
                            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除  
                        </button>  
                    </div>  -->
									</div>
									<table class="table table-bordered table-hover table-appAndIns">
										<thead>
											<tr class="success" id="appItemInfosth">
												<th></th>
												<th>项目编号</th>
												<th>项目名称</th>
												<th>父级编号</th>
												<th>数量</th>
												<th>价格</th>
											</tr>
										</thead>
										<tbody id="appItemInfos">
											<tr>
												<td>请点击下拉框选择检查选项</td>

											</tr>
										</tbody>
									</table>
									<div class="panel-footer">
										<!-- <nav>
										<ul class="pagination pagination-sm">
											<li class="disabled"><a href="#" aria-label="Previous">
													<span aria-hidden="true">«</span>
											</a></li>
											<li class="active"><a href="#">1</a></li>
											<li><a href="#">2</a></li>
											<li><a href="#">3</a></li>
											<li><a href="#">4</a></li>
											<li><a href="#">5</a></li>
											<li><a href="#" aria-label="Next"> <span
													aria-hidden="true">»</span>
											</a></li>
										</ul>
									</nav> -->
									</div>
									<!-- end of panel-footer -->
								</div>
								<!-- end of panel -->
							</div>
							<!-- ********************************************************************************************************** -->

						</div>

						<div class="row">
							<div class="col-md-12">
								<div class="input-group">
									<span class="input-group-addon">主诉</span> <input type="text"
										class="form-control mainInfo" placeholder="请输入患者主诉"
										name="applicationform.mainInfo" />
								</div>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-12">
								<div class="input-group">
									<span class="input-group-addon">检查目的</span>
									<textarea class="form-control goal" rows="3"
										placeholder="请输入患者检查目的" name="applicationform.goal"></textarea>
								</div>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-5"></div>
							<div class="col-md-2">
								<button type="button" class="btn btn-primary"
									onclick="addAppItem()">提交检查申请</button>
							</div>
							<div class="col-md-5"></div>

						</div>
					</form>

				</div>
				<!-- fen -->

				<!--fen  -->

			</div>
			<div id="menu5" class="tab-pane fade">
				<div class="container">
					<div class="row">
						<div class="col-md-4">
							<div class="input-group">
								<span class="input-group-addon">患者姓名</span> <input type="text"
									class="form-control p_name" placeholder="请输入患者姓名"
									readonly="readonly">
							</div>
						</div>
						<div class="col-md-4">
							<div class="input-group">
								<span class="input-group-addon">性别</span> <input type="text"
									class="form-control p_sex" placeholder="请输入患者性别"
									readonly="readonly">
							</div>
						</div>
						<div class="col-md-4">
							<div class="input-group">
								<span class="input-group-addon">年龄</span> <input type="text"
									class="form-control p_age" placeholder="请输入患者年龄"
									readonly="readonly">
							</div>
						</div>
					</div>
					<hr>
					<form action="" id="insForm">
						<div class="row">
							<div class="col-md-2">
								<div class="form-group">
									<!-- <span class="input-group-addon">检验科室</span> -->
									<select class="form-control" id="selectInsItem" name="inspection.inspectionitem.jyxId">
									</select>
								</div>
							</div>
							<div class="col-md-4">
								<div class="input-group">
									<span class="input-group-addon">检验部位</span> <input type="text"
										class="form-control icheckPoint" placeholder="请输入检验部位" name="inspection.checkPoint">
								</div>
							</div>
							<div class="col-md-4 div-hidden">
								<div class="input-group">
									<span class="input-group-addon">患者id</span> <input type="text"
										class="form-control ipatientids" placeholder="请输入id" name="inspection.patients.id">
								</div>
							</div>
							<div class="col-md-4 div-hidden">
								<div class="input-group">
									<span class="input-group-addon">状态</span> <input type="text"
										class="form-control iappState" placeholder="请输入状态" name="inspection.state">
								</div>
							</div>

						</div>
						<div class="row">
							<!-- ********************************************************************************************************** -->
							<div class="panel-group">
								<div class="panel panel-primary">
									<div class="panel-heading">列表</div>
									<div class="panel-body">
										<!-- <div class="list-op" id="list_op">  
                        <button type="button" class="btn btn-default btn-sm">  
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增  
                        </button>  
                        <button type="button" class="btn btn-default btn-sm">  
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改  
                        </button>  
                        <button type="button" class="btn btn-default btn-sm">  
                            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除  
                        </button>  
                    </div>  -->
									</div>
									<table
										class="table table-bordered table-hover table-appAndIns1">
										<thead>
											<tr class="success" id="InsItemInfosth">
												<th></th>
												<th>项目编号</th>
												<th>项目名称</th>
												<th>父级编号</th>
												<th>数量</th>
												<th>价格</th>
											</tr>
										</thead>
										<tbody id="InsItemInfos">
											<tr>
												<td>请点击下拉框选择检查选项</td>

											</tr>
										</tbody>
									</table>
									<div class="panel-footer">
										<!-- <nav>
										<ul class="pagination pagination-sm">
											<li class="disabled"><a href="#" aria-label="Previous">
													<span aria-hidden="true">«</span>
											</a></li>
											<li class="active"><a href="#">1</a></li>
											<li><a href="#">2</a></li>
											<li><a href="#">3</a></li>
											<li><a href="#">4</a></li>
											<li><a href="#">5</a></li>
											<li><a href="#" aria-label="Next"> <span
													aria-hidden="true">»</span>
											</a></li>
										</ul>
									</nav> -->
									</div>
									<!-- end of panel-footer -->
								</div>
								<!-- end of panel -->
							</div>
							<!-- ********************************************************************************************************** -->

						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="input-group">
									<span class="input-group-addon">主诉</span> <input type="text"
										class="form-control imainInfo" placeholder="请输入患者主诉"
										name="inspection.maininfo"/>
								</div>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-12">
								<div class="input-group">
									<span class="input-group-addon">检验目的</span>
									<textarea class="form-control igoal" rows="3"
										placeholder="请输入患者检验目的" name="inspection.goal"></textarea>
								</div>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-5"></div>
							<div class="col-md-2">
								<button type="button" class="btn btn-primary"
									onclick="addInsItem()">提交检验申请</button>
							</div>
							<div class="col-md-5"></div>

						</div>
					</form>
				</div>
			</div>
			<div id="menu6" class="tab-pane fade">
				<div class="container">
					<div class="row">
						<div class="col-md-4">
							<div class="input-group">
								<span class="input-group-addon">患者姓名</span> <input type="text"
									class="form-control p_name" placeholder="请输入患者姓名"
									readonly="readonly">
							</div>
						</div>
						<div class="col-md-4">
							<div class="input-group">
								<span class="input-group-addon">性别</span> <input type="text"
									class="form-control p_sex" placeholder="请输入患者性别"
									readonly="readonly">
							</div>
						</div>
						<div class="col-md-4">
							<div class="input-group">
								<span class="input-group-addon">年龄</span> <input type="text"
									class="form-control p_age" placeholder="请输入患者年龄"
									readonly="readonly">
							</div>
						</div>
					</div>
					<hr>
				</div>
				<!-- 隐藏 -->
				<div class="panel-group" id="accordion">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapseOne" onclick="findlop()"> 已开处方管理 </a>
							</h4>
						</div>
						<div id="collapseOne" class="panel-collapse collapse in">
							<div class="panel-body">
								<table class="table table-bordered">
									<!-- 表格 -->
									<caption>边框表格布局</caption>
									<thead>
										<tr>
											<th>药品名称</th>
											<th>剂量单位</th>
											<th>剂型名称</th>
											<th>数量</th>
										</tr>
									</thead>
									<tbody id="lopBody">

									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="panel panel-success">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapseTwo" onclick="findApplication()"> 检查申请单 </a>
							</h4>
						</div>
						<div id="collapseTwo" class="panel-collapse collapse">
							<div class="panel-body">
								<table class="table table-bordered">
									<!-- 表格 -->
									<caption>边框表格布局</caption>
									<thead>
										<tr>
											<th>检查项目</th>
											<th>检查部位</th>
											<th>患者主诉</th>
											<th>检查目的</th>
											<th>检查状态</th>
										</tr>
									</thead>
									<tbody id="applicationBody">

									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="panel panel-info">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapseThree" onclick="findInspection()"> 检验申请单 </a>
							</h4>
						</div>
						<div id="collapseThree" class="panel-collapse collapse">
							<div class="panel-body">
								<table class="table table-bordered">
									<!-- 表格 -->
									<caption>边框表格布局</caption>
									<thead>
										<tr>
											<th>检验项目</th>
											<th>检验部位</th>
											<th>患者主诉</th>
											<th>检查目的</th>
											<th>检验状态</th>
										</tr>
									</thead>
									<tbody id="inspectionBody">

									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="panel panel-warning">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapseFour"> 待定 </a>
							</h4>
						</div>
						<div id="collapseFour" class="panel-collapse collapse">
							<div class="panel-body">Nihil anim keffiyeh helvetica,
								craft beer labore wes anderson cred nesciunt sapiente ea
								proident. Ad vegan excepteur butcher vice lomo.</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	/* 手风琴默认开关 */
	$(function() {
		$('#collapseFour').collapse({
			toggle : false
		})
	});
	$(function() {
		$('#collapseTwo').collapse('hide')
	});
	$(function() {
		$('#collapseThree').collapse('hide')
	});
	$(function() {
		$('#collapseOne').collapse('hide')
	});
</script>
<!-- 
<script>
	/* 复选表格 */
	$(function() {
		function initTableCheckbox() {
			var $thr = $('.table-appAndIns thead tr');
			var $checkAllTh = $('<th><input type="checkbox" id="checkAll" name="checkAll" /></th>');
			/*将全选/反选复选框添加到表头最前，即增加一列*/
			$thr.prepend($checkAllTh);
			/*“全选/反选”复选框*/
			var $checkAll = $thr.find('input');
			$checkAll.click(function(event) {
				/*将所有行的选中状态设成全选框的选中状态*/
				$tbr.find('input').prop('checked', $(this).prop('checked'));
				/*并调整所有选中行的CSS样式*/
				if ($(this).prop('checked')) {
					$tbr.find('input').parent().parent().addClass('warning');
				} else {
					$tbr.find('input').parent().parent().removeClass('warning');
				}
				/*阻止向上冒泡，以防再次触发点击操作*/
				event.stopPropagation();
			});
			/*点击全选框所在单元格时也触发全选框的点击操作*/
			$checkAllTh.click(function() {
				$(this).find('input').click();
			});
			var $tbr = $('.table-appAndIns tbody tr');
			var $checkItemTd = $('<td><input type="checkbox" name="checkItem" /></td>');
			/*每一行都在最前面插入一个选中复选框的单元格*/
			$tbr.prepend($checkItemTd);
			$tbr.append($checkItemTd);
			/*点击每一行的选中复选框时*/
			$tbr.find('input').click(function(event) {
				/*调整选中行的CSS样式*/
				$(this).parent().parent().toggleClass('warning');
				/*如果已经被选中行的行数等于表格的数据行数，将全选框设为选中状态，否则设为未选中状态*/
				$checkAll.prop('checked', $tbr.find('input:checked').length == $tbr.length ? true : false);
				/*阻止向上冒泡，以防再次触发点击操作*/
				event.stopPropagation();
			});
			
			/*点击每一行时也触发该行的选中操作*/
			$tbr.click(function() {
				$(this).find('input').click();
			});
			
			
		}
		initTableCheckbox();
	});
</script>
 -->
</html>
