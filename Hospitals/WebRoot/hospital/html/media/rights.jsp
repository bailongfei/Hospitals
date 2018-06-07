<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!doctype html>
<html>
<head>
<base href="<%=basePath%>">

<title>角色管理页面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap-theme.min.css">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/zTree_v3/css/demo.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/zTree_v3/css/zTreeStyle/zTreeStyle.css">

<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script
	src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/js/zTree_v3/js/jquery.ztree.all.min.js"></script>

<script>
	//查询所有并分页
	function findAll(curPage) {
		//请求的页面地址
		var url = "${pageContext.request.contextPath}/admin_findAllRoles.action"
		$.ajax({
			url : url,
			data : {
				"curPage" : curPage
			},
			dataType : "json",
			type : "post",
			ansy : false,
			success : function(data) {
				$("#tbody").html(""); //清空内容数据
				var ary = data.list;
				for (var i = 0; i < ary.length; i++) {
					var obj = ary[i]; //获取当前对象
					var tr = "<tr>";
					tr += "<td>" + obj.rolesId + "</td>";
					tr += "<td>" + obj.rolesName + "</td>";
					tr += "<td>" + obj.rolesdescribe + "</td>";
					tr += "<td><input data-toggle='modal' data-target='#myModal' type='button' value='修改' id=" + obj.rolesId + " class='update btn btn-default' /></td>"
					tr += "<td><input type='button' value='删除' id=" + obj.rolesId + " class='delete btn btn-default'/></td>";
					tr += "<td><input data-toggle='modal' data-target='#perModal'  type='button' value='分配权限' id=" + obj.rolesId + " class='grant btn btn-default'/></td>";
					tr += "</tr>";
					$("#tbody").append(tr); //追加行
				}
				//重新初始化分页链接
				$("#curPage").html(data.curPage);
				$("#totalPages").html(data.totalPages);
				$("#first").attr("data", data.first);
				$("#prev").attr("data", data.prev);
				$("#next").attr("data", data.next);
				$("#last").attr("data", data.last);
				$("#txtCurPage").val(data.curPage).attr("max", data.last);
			}
		});
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


	//页面加载触发
	$(function() {
		findAll(1);
		$("#save").click(function() {
			$.ajax({
				url : "${pageContext.request.contextPath}/admin_saveOrUpdate.action",
				data : {
					"roles.rolesId" : $("#rolesId").val(),
					"roles.rolesName" : $("#rolesName").val(),
					"roles.rolesdescribe" : $("#rolesdescribe").val()
				},
				dataType : "json",
				type : "post",
				success : function(data) {
					console.log(data);
					if (data.state > 0) {
						findAll(data.last);
						alert(data.message);
						//清空数据
						$("#rolesId").val("");
						$("#rolesName").val("");
						$("#rolesdescribe").val("");
					}
				}
			});
		});
	});

	$(function(){
//动态绑定单击事件
  $("#tbody").on("click",".update",function(){
    
     var patientsId=this.id;
     $.ajax({
        url:"${pageContext.request.contextPath}/admin_findById.action",
        data:{"roles.rolesId":patientsId},
        dataType:"json",
        type:"post",
        success:function(data){
          $("#rolesId").val(data.rolesId);
          $("#rolesName").val(data.rolesName);
          $("#rolesdescribe").val(data.rolesdescribe);
          findAll($("#curPage").html());//加载数据
        }
     });
  });
  $("#tbody").on("click",".delete",function(){
     var patientsId=this.id;
     $.ajax({
        url:"${pageContext.request.contextPath}/admin_deleteRoles.action",
        data:{"roles.rolesId":patientsId},
        type:"post",
        dataType:"json",
        success:function(data){
           if(data.state>0){
             alert(data.message);
              findAll(data.curPage);
           }
        }
     });
  });
});

</script>
</head>

<body>
	<div class="container">


		
		<!-- 模态框弹出录入内容 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="modalTitle1" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">
							&times;
							<!-- 关闭按钮 -->
						</button>
						<h4 class="modal-title" id="modalTitle1">录入角色</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal" role="form" id="roleForm">
							<div class="form-group">
								<label for="roleName" class="col-sm-2 control-label">角色名字</label>
								<div class="col-sm-4">
									<input type="hidden" class="form-control" id="rolesId"
										placeholder="请输入角色编号"> <input type="text"
										class="form-control" id="rolesName" placeholder="请输入角色名字">
								</div>
							</div>

							<div class="form-group">
								<label for="description" class="col-sm-2 control-label">角色描述</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="rolesdescribe"
										placeholder="请输入角色描述 ">
								</div>
							</div>
						</form>

					</div>
					<div class="modal-footer">
						<button type="button" id="save" data-toggle='modal'
							data-target='#myModal' class="btn btn-primary">保存</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>

		<hr />
		<table class="table table-hover">
			<caption>角色列表</caption>
			<thead>
				<tr class="success">
					<th>编号</th>
					<th>名称</th>
					<th>描述</th>
					<th >操作</th>
					<th colspan="2">
					   <button class="btn btn-success btn-sm" data-toggle="modal" data-target="#myModal">角色录入操作</button>
					</th>
				</tr>
			</thead>
			<tbody id="tbody">

			</tbody>
		</table>

		<ul class="pager">
			<li>当前页:<span id="curPage"></span>总页数:<span id="totalPages"></span>
			</li>
			<li><a id="first" onclick="changePage(this)">首页</a></li>
			<li><a id="prev" onclick="changePage(this)">上一页</a></li>
			<li><a id="next" onclick="changePage(this)">下一页</a></li>
			<li><a id="last" onclick="changePage(this)">尾页</a></li>
			<li><input type="number" id="txtCurPage" min="1" max="10"></input><input
				type="button" value="go" onclick="gotoPage()" /></li>
		</ul>

		<!-- 模态框 -->
		<div class="modal fade" id="perModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabel">权限分配</h4>
					</div>
					<div class="modal-body" id="roleList">
						<ul id="tree" class="ztree"></ul>
						<input type="hidden" id="hidRoleId" readonly="readonly"/>
					</div>
					<div class="modal-footer">
						<button class="btn btn-default" data-dismiss="modal">关闭</button>
						<button class="btn btn-primary" id="saveRight">保存</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<script>
/*分配功能*/
$("#tbody").on("click",".grant",function(){
    var roleId=this.id;
    $("#hidRoleId").val(roleId);
    createTree(roleId);
});
var zTree;
//创建树型结构
function createTree(roleId) {
 var setting = {
   check:{
     enable:true
   },
   view: {
     dblClickExpand: true,
     expandSpeed: ""
   },
   //异步加载
   async: {
     enable: true,//设置是否异步加载
     url:"${pageContext.request.contextPath}/roles_findAllModules.action", //设置异步获取节点的 URL 地址
     otherParam: [ "roles.rolesId",roleId]
   },
   data: {
     simpleData: {
       enable: true,
       pIdKey: "parentid",
       idKey: "modulesId"
     },
     key: {
       checked: "checked",
       name:"modulesText"
     }
   },
   callback: {
     onAsyncSuccess: zTreeOnAsyncSuccess 
   } 
 };

 //初始化  
 zTree = $.fn.zTree.init($("#tree"), setting);  
 zTree.expandAll(true);
 /* // 展开全部节点
var treeObj = $.fn.zTree.getZTreeObj("tree");
treeObj.expandAll(true); */
}
/* 异步加载无法展开tree 默认展开一级菜单 */
var firstAsyncSuccessFlag = 0;
function zTreeOnAsyncSuccess(event, treeId, msg) { 
if (firstAsyncSuccessFlag == 0) { 
    try { 
        //调用默认展开第一个结点 
        var selectedNode = zTree.getSelectedNodes(); 
        var nodes = zTree.getNodes(); 
        zTree.expandNode(nodes[0], true); 
        var childNodes = zTree.transformToArray(nodes[0]); 
        zTree.expandNode(childNodes[1], true); 
        zTree.selectNode(childNodes[1]); 
        var childNodes1 = zTree.transformToArray(childNodes[1]); 
        zTree.checkNode(childNodes1[1], true, true); 
        firstAsyncSuccessFlag = 1; 
     } catch (err) { 
    	 console.log(err.message);
     } 
  } 
}

//保存修改后的权限数据
$("#saveRight").click(function(){
	        var nodes = zTree.getCheckedNodes();//获取所有选中的节点集合
		    var ids = [];
		    for(var i=0,l=nodes.length;i<l;i++){
		      ids[ids.length] = nodes[i].modulesId;//存入菜单编号
		    }
		    var idstr=ids.join(",");//拼接成字符串
	        $.ajax({
		        url:"${pageContext.request.contextPath}/roles_allotRight.action",
		        data:{"roles.rolesId":$("#hidRoleId").val(),"menuIds":idstr},
		        dataType:"json", 
		        type:"post",
		        success:function(data){
		            alert(data.message);
		        }
	         });
	     });

</script>
