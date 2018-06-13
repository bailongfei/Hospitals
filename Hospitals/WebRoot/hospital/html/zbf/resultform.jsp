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
           <h2 style="text-align:center">检查结果单</h2><br/><hr align=center width=800 color=#000000 SIZE=3>
     
     
     <form role="form"  method="post" style="margin-left:20%">
	        <div  style="width:100px;float:left;">
        <label for="name">病人ID:</label>
        <span >${result.id}</span>
      </div>
      <div style="width:200px;float:left;">
        <label for="name">病人姓名:</label>
        <span>${result.patientname}</span>
      </div>
      <div style="width:100px;float:left;">
      <label for="name">性别:</label>
        <span>${result.sex}</span>
      </div>
      <div style="width:100px;float:left;">
      <label for="name">年龄:</label>
        <span>${result.age}</span>
      </div><br/><br/><br/>
      <div style="width:200px;float:left;">
      <label for="name">身份证号:</label>
        <span>${result.idnumber}</span>
      </div>
      <div style="width:100px;float:left;">
      <label for="name">检查部位:</label>
        <c:forEach items="${result.applicationforms}" var="result">
            <span>${result.checkPoint }</span>
        </c:forEach>
      </div><br/><br/><br/><br/><hr style="margin-right:600px;width:800px;">
      <label for="name" style="margin-left:30px;">标本名称：</label>
      <c:forEach items="${result.applicationresults}" var="result">    
    <span  class="result" rows="2" name="sample">${result.sample }</span>
      </c:forEach><br/><br/><br/>
      
      <label for="name" style="margin-left:30px;">存在隐患：</label>
         <c:forEach items="${result.applicationresults}" var="result">
     <span class="result" rows="2" name="sample">${result.trouble }</span>
   </c:forEach><br/><br/><br/>
      <label for="name" style="margin-left:30px;">病理诊断：</label>
         <c:forEach items="${result.applicationresults}" var="result">
    <span class="result" rows="2" name="sample">${result.diagnose }</span>
    </c:forEach>
      
  <hr style="margin-right:600px;width:800px;">
  <span style="font-family:'微软雅黑';font-size:10px;margin-left:50px;">注:病理报告系重要诊断文件，请妥善保管</span><br/><br/><br/>
  <input type="button" name="print" value="打印" onclick="window.print()">
</form>
  </body>
</html>
<script>
  
</script>
