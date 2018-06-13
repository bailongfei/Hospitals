<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div id="father" ><FONT SIZE="6px" COLOR="#7A7A7A">门诊挂号</FONT></div>
  
  <div id="cha" style="background-color:#90b8d6;margin-top:2px;">
  <a href="hospital/html/cwh/wk.jsp" style="padding-left:5%;text-decoration:none;">办理IC卡</a>
 </div>
 <div id="er" style="background-color:#90b8d6;margin-top:2px;">
  <a href="hospital/html/cwh/selectcwh.jsp" style="padding-left:5%;text-decoration:none;">充值IC卡</a>
 </div>
  </body>
</html>
