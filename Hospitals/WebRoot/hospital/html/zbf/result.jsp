<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta charset="utf-8"> 
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
    .noread{
      background:#D0D0D0;
    }
    a:hover{text-decoration:none}
  </style>
  </head>
  <body>
           <h2 style="text-align:center">检查结果打印单</h2><br/>
     

     <form  method="post" id="showDataForm" style="margin-left:15%" >
	  <div class="row">
      <div style="width:100px;float:left;margin-right:20px;">
        <label for="name">检查Id:</label>
        <input type="text" name="result.applicationform.jcId" class="form-control"value="${app.jcId}" readonly class="noread">
      </div>
      <div style="width:100px;float:left;margin-right:20px;">
        <label for="name">病人姓名:</label>
        <input type="text" class="form-control"value="${app.patients.patientname}" readonly class="noread">
      </div>
      <div style="width:100px;float:left;margin-right:20px;">
      <label for="name">性别:</label>
        <input type="text" class="form-control"value="${app.patients.sex}" readonly class="noread">
      </div>
      <div style="width:100px;float:left;margin-right:20px;">
      <label for="name">年龄:</label>
        <input type="text" class="form-control"value="${app.patients.age}" readonly class="noread">
      </div>
      <div style="width:200px;float:left;margin-right:20px;">
      <label for="name">身份证号:</label>
        <input type="text" class="form-control"value="${app.patients.idnumber}" readonly class="noread">
      </div><br/><br/><br/><br/>
      </div>
      <div class="row">
      <div style="width:100px;float:left;margin-right:20px;">
        <label for="name">病人ID:</label>
        <input type="text" class="form-control" name="result.patients.id" value="${app.patients.id}" readonly class="noread">
      </div>
      <div style="width:120px;float:left;margin-right:20px;">
        <label for="name">检查类型</label>
        <input type="text" class="form-control"value="${app.applicationitem.name}" readonly class="noread">
      </div>
      <div style="width:100px;float:left;margin-right:20px;">
        <label for="name">检查部位</label>
        <input type="text" class="form-control"value="${app.checkPoint}" readonly class="noread">
      </div>
      <div style="width:150px;float:left;margin-right:20px;">
      <label for="name">病人主述</label>
        <input type="text" class="form-control"value="${app.mainInfo}" readonly class="noread">
      </div></div><br><br>
      
      
      <div class="form-group">
      <div style="width:800px;">
      <label for="name">标本名称</label>
    <textarea class="form-control" rows="2" name="result.sample"></textarea></div><br/><br/>
    <div style="width:800px;">
    <label for="name">存在隐患</label>
    <textarea class="form-control" rows="3" name="result.trouble"></textarea></div><br/><br/>
    <div style="width:800px;">
    <label for="name">病理诊断</label>
    <textarea class="form-control" rows="3" name="result.diagnose"></textarea></div>
  </div>
<input type="button" class="btn btn-default" onclick="saveReport()" value="提交">&nbsp;
<a href="resultform.action?p.Id=${app.patients.id}">打印</a>
</form>

  </body>
</html>
<script>
  function saveReport() { 
$.ajax({
        url:"${pageContext.request.contextPath}/insert.action",
        data:$("#showDataForm").serialize(),
        dataType:"text",
        type:"post",
        success:function(data){
        alert(data);
        }
        
})
return false; // 必须返回false，否则表单会自己再做一次提交操作，并且页面跳转 
} 
</script>
