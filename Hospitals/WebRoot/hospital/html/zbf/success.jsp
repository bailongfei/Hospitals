<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="keywords" content="jquery,ui,easy,easyui,web">
	<meta name="description" content="easyui help you build your web page easily!">
	<title>检查申请单</title>
	<link rel="stylesheet" type="text/css" href="http://www.w3cschool.cc/try/jeasyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="http://www.w3cschool.cc/try/jeasyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="http://www.w3cschool.cc/try/jeasyui/demo/demo.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript" src="http://www.w3cschool.cc/try/jeasyui/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		function doSearch(){
			$('#tt').datagrid('load',{
				itemid: $('#itemid').val(),
				productid: $('#productid').val()
			});
		}
	</script>
</head>
<body>
	<h2>检查申请单</h2>
	<div class="demo-info" style="margin-bottom:10px">
		<div class="demo-tip icon-tip">&nbsp;</div>
		<div>请确认信息后进行检查</div>
	</div>
	
	<table id="tt" class="easyui-datagrid" style="width:700px;height:250px"
			url="datagrid24_getdata.php"
			title="Searching" iconCls="icon-search" toolbar="#tb"
			rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="itemid" width="80">检查 ID</th>
				<th field="productid" width="120">病人 姓名</th>
				<th field="listprice" width="80" align="right">检查部位</th>
				<th field="unitcost" width="80" align="right">主述</th>
				<th field="attr1" width="200">检查目的</th>
				<th field="status" width="60" align="center">操作</th>
			</tr>
		</thead>
		<c:forEach items="${p.list}" var="a">
        <tr>
           <td>${a.jcId }</td>
           <td>${a.patients.patientname }</td>
           <td>  ${a.checkPoint}</td>
           <td>${a.mainInfo}</td>
           <td>${a.goal}</td>
           <td><a href="check.action?app.jcId=${a.jcId }">确认检查</a></td>
        </tr>
           
        </c:forEach>
	</table>
	<!-- <div id="tb" style="padding:3px">
		<span>检查 ID:</span>
		<input id="itemid" style="line-height:26px;border:1px solid #ccc">
		<span>病人 ID:</span>
		<input id="productid" style="line-height:26px;border:1px solid #ccc">
		<a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">Search</a>
	</div> -->
	<form action="page.action" method="post">
    当前页:${p.curPage }/总页数:${p.totalPages}
    <a href="page.action?curPage=${p.first}">首页</a>
    	<a href="page.action?curPage=${p.prev}">上页</a>
    	<a href="page.action?curPage=${p.next}">下页</a>
    	<a href="page.action?curPage=${p.last}">尾页</a>
    	<input type="text" name="curPage" class="num" value="${p.curPage}">
    	<input type="submit" value="Go" >
    	</form>
</body>
</html>
