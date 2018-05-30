<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'leftss.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css">
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
  </head>
  
  <body>
  
    <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="panel-group" id="panel-759719">
			   
		 <c:forEach items="${list}" var="li">
        <!-- 判断父节点是否为root -->
        <c:if test="${li.parentid=='ROOT'}">
				<div class="panel panel-default">
					<div class="panel-heading">
					<!--若为ROOT则表示给节点为父级节点，显示出来（因为ROOT是数据库建表时定义的数据。）  -->
						 <a class="btn btn-primary btn-lg btn-block panel-title collapsed"  href="#${li.modulesId}" data-toggle="collapse" data-parent="#panel-759719">${li.modulesText}</a>
					</div>
					<div class="panel-collapse collapse" id="${li.modulesId}">
					    <c:forEach items="${list}" var="li2">
                         <!--判断子点是否和父级节点的模块ID相同，显示出来二级菜单  -->
                         <c:if test="${li2.parentid==li.modulesId}">
                         
						 <div class="panel-body">
						  <center>
							<a href="${pageContext.request.contextPath}/hospital/html/${li2.modulesUrl}" target="mainFrame" class="btn btn-info">${li2.modulesText}</a>
						   </center>
						</div> 
					           
						 </c:if>
    	                 </c:forEach>  
					</div>
				</div>
			 </c:if>
        </c:forEach>	
				
				
				
			</div>
		</div>
	</div>
</div>

  </body>
</html>
