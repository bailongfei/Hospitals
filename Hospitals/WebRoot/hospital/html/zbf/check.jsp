<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<base href="<%=basePath%>">

<title>My JSP 'check.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.noread {
	background: #D0D0D0;
}

a:hover {
	text-decoration: none
}
</style>
</head>
<body>
	<h2 style="margin-left:20px;">确认检查</h2>
	<br />
	<%-- <form action="check.action" method="post">
        检查Id：<input type="text" name="app.jcId" value="${app.jcId}" readonly class="noread"><br/>
        病人姓名：<input type="text" name="app.patients.patientname" value="${app.patients.patientname}" readonly class="noread"><br/>
        检查部位：<input type="text" name="app.checkPoint" value="${app.checkPoint}" readonly class="noread"><br/>
       检查类型：<select id="checked">
           <c:forEach items="${item }" var="l">
           <option>${l.name }</option>
           
        </c:forEach>
          
       </select><br/>
       检查费用：<input type="text" name="e.depname" value=""><br/>
        提交：<input type="submit" value="提交">
     </form> --%>


	<form role="form" method="post" style="margin-left:5%">
		<div class="form-group">
			<label for="name">检查Id</label> <input type="text"
				class="form-control" value="${app.jcId}" readonly id="jcId"
				class="noread"> <input type="hidden" class="form-control"
				value="${app.patients.id}" id="id" readonly class="noread">
			<label for="name">病人姓名</label> <input type="text"
				class="form-control" value="${app.patients.patientname}" readonly
				class="noread"> <label for="name">检查部位</label> <input
				type="text" class="form-control" value="${app.checkPoint}" readonly
				class="noread"> <label for="name">检查类型</label><br /> <input
				type="text" class="form-control" value="${app.applicationitem.name}"
				readonly class="noread"> <label for="name">检查费用</label> <input
				type="text" class="form-control"
				value="${app.applicationitem.price}" readonly class="noread">
			
		</div>
		<%-- <a href="result.action?app.jcId=${app.jcId}&id=${app.patients.id}&money=">提交</a>  --%>
		<a id="aaa">提交</a>
		<!-- <input type="button" class="btn btn-default" value="提交" id="btn" >  -->
	</form>

</body>
</html>
<script type="text/javascript">
$(function(){
   $.ajax({
      url:"${pageContext.request.contextPath}/findMoney.action",
      data:{"id":${app.patients.id}},
      type:"post",
      dataType:"json",
      success:function(data){
       // alert(data.money);
        var zmoney=data.money;
        var jc=${app.applicationitem.price};
        var re=parseInt(zmoney-jc);
        
        $("#aaa").attr("href","result.action?app.jcId="+${app.jcId}+"&id="+${app.patients.id}+"&money="+re);
          
      }
   });
   
});
/* 
$(document).on("click","#btn",function(){
   
   var money=$("#money").val();
   alert(${app.jcId});
   $.ajax({
       url:"${pageContext.request.contextPath}/result.action",
      data:{"id":${app.patients.id},
          "app":${app.jcId},
          "money":money
      },
      type:"post",
      dataType:"json",
      success:function(data){
        if(data.state>0){
           alert(data.message);
           //window.location.href="${pageContext.request.contextPath}/hospital/html/zbf/result.jsp";
        }
      }
   });
}); */
</script>
