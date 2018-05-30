<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'infos.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!--绝对路径  -->
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap-theme.min.css">
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css">
	<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/zTree_v3/css/demo.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/zTree_v3/css/zTreeStyle/zTreeStyle.css"> --%>
   
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
	<%-- <script src="${pageContext.request.contextPath}/js/zTree_v3/js/jquery.ztree.all.min.js"></script> --%>
  </head>
  
  <body>
  <hr>
  <tale>
    <tr>
      <td><input type="hidden" name="" ></td>
      <td>输入编号:<input type="text" name="" ></td>
      <td>科室名称:<input type="text" name="" ></td>
      <td><input type="submit" class="btn btn-default" value="查询" ></td>
    </tr>
  </tale>
  <hr>
  
  <!--详情录入  -->
  <div class="container">
	<button  data-toggle="modal" data-target="#myModal" class="btn btn-default">
	详情录入
	</button>
	<!-- 模态框弹出录入内容 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="modalTitle1" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times; <!-- 关闭按钮 -->
				</button>
				<h4 class="modal-title" id="modalTitle1">
					详情录入
				</h4>
			</div>
			<div class="modal-body">
  <form class="form-horizontal"  role="form" id="roleForm">
	<div class="form-group">
		<label for="patientname" class="col-sm-2 control-label">姓名:</label>
		<div class="col-sm-4">
			<input type="hidden" class="form-control" id="id"   placeholder="请输入编号" >
			<input type="text" class="form-control" id="patientname"   placeholder="请输入名字" >
		</div>
	</div>
	
	<div class="form-group">
		<label for="sex" class="col-sm-2 control-label">性别:</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" id="sex"   placeholder="请输入性别 ">
		</div>
	</div>
	
	<div class="form-group">
		<label for="age" class="col-sm-2 control-label">年龄:</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" id="age"   placeholder="请输入年龄 ">
		</div>
	</div>
	 
	 <div class="form-group">
		<label for="idnumber" class="col-sm-2 control-label">手机号:</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" id="idnumber"   placeholder="请输入手机号">
		</div>
	</div>
	
	</form>

			</div>
			<div class="modal-footer">
				<button type="button" id="save" data-toggle='modal' data-target='#myModal' class="btn btn-primary">保存</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
	</div>
  <hr>
  
    <table class="table" >
 <!-- <caption class="td07"><a href="moreapplicationlist_1.htm" target="_blank">&nbsp;&nbsp;详情</a></caption>  -->
  <thead>
    <tr>
      <th class="td_top">门诊编号</th>
      <th class="td_top">主治医生</th>
      <th class="td_top">挂号时间</th>
      <th class="td_top">挂号科室</th>
      <th nowrap class="td_top">操作</th>
    </tr>
  </thead>
  <tbody id="tbody">

  </tbody>
  
</table>

<ul class="pager" >
 	<li>
 	当前页:<span id="curPage"></span>总页数:<span id="totalPages"></span>
 	</li>
 	<li><a  id="first" onclick="changePage(this)">首页</a></li>
 	<li><a  id="prev" onclick="changePage(this)">上一页</a></li>
 	<li><a  id="next" onclick="changePage(this)">下一页</a></li>
 	<li><a  id="last"  onclick="changePage(this)">尾页</a></li>
 	<li><input type="number"  id="txtCurPage"  min="1" max="10"></input><input type="button" class="btn btn-default" value="go" onclick="gotoPage()"/></li>
  </ul>
  </body>
</html>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
   findAll(1);
});
function findAll(curPage){
  var url="${pageContext.request.contextPath}/ps_findAll.action";
  $.ajax({
      url:url,
      data:{"curPage":curPage},
      dataType:"json",
      type:"post",
      ansy:false,
      success:function(data){
        $("#tbody").html("");//清空内容数据
        var ary=data.list;
        for(var i=0;i<ary.length;i++){
          var obj=ary[i];//获取当前对象
          var tr="<tr>";
          tr+="<td>"+obj.patientname+"</td>";
          tr+="<td>"+obj.sex+"</td>";
          tr+="<td>"+obj.age+"</td>";
          tr+="<td>"+obj.idnumber+"</td>";
          /* tr+="<td>"+obj.patientId+"</td>";
          tr+="<td>"+obj.patientType+"</td>"; */
          tr+="<td><input type='button' data-toggle='modal' data-target='#myModal' value='修改' id="+obj.id+" class='update btn btn-default'/></td>";
          tr+="<td><input type='button' class='delete btn btn-default' value='删除' id="+obj.id+" /></td>";
          /* tr+="<td><input type='button'  value='分配权限' id="+obj.id+"/></td>";  */
          tr+="</tr>"; 
          $("#tbody").append(tr);//追加行
        }
        //重新初始化分页链接
        $("#curPage").html(data.curPage);
		$("#totalPages").html(data.totalPages);
        $("#first").attr("data",data.first);
		$("#prev").attr("data",data.prev);
		$("#next").attr("data",data.next);
		$("#last").attr("data",data.last);
		$("#txtCurPage").val(data.curPage).attr("max",data.last);
      }
  });
}
//改变页面
function changePage(obj){
    var page=$(obj).attr("data");//取出data属性值
    findAll(page);
}
//跳转到指定页面
	function gotoPage(page){
		var page=$("#txtCurPage").val();
		findAll(page);
	}
//保存录入
$(function(){


$("#save").click(function(){
  $.ajax({
    url:"${pageContext.request.contextPath}/ps_saveOrUpdate.action",
    data:{
       "patients.id":$("#id").val(),
       "patients.patientname":$("#patientname").val(),
       "patients.sex":$("#sex").val(),
       "patients.age":$("#age").val(),
       "patients.idnumber":$("#idnumber").val()
    },
    dataType:"json",
    type:"post",
    success:function(data){
     console.log(data);
     if(data.state>0){
        findAll(data.last);
        alert(data.message); 
        //清空数据
        $("#id").val("");
        $("#patientname").val("");
        $("#sex").val("");
        $("#age").val("");
        $("#idnumber").val("");
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
        url:"${pageContext.request.contextPath}/ps_findById.action",
        data:{"patients.id":patientsId},
        dataType:"json",
        type:"post",
        success:function(data){
          $("#id").val(data.id);
          $("#patientname").val(data.patientname);
          $("#sex").val(data.sex);
          $("#age").val(data.age);
          $("#idnumber").val(data.idnumber);
          findAll($("#curPage").html());//加载数据
        }
     });
  });
  $("#tbody").on("click",".delete",function(){
     var patientsId=this.id;
     $.ajax({
        url:"${pageContext.request.contextPath}/ps_delete.action",
        data:{"patients.id":patientsId},
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

