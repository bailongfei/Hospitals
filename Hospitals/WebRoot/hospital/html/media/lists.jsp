<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>成果管理</title>
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../../js/clientSideApp.js"></script>
<SCRIPT language=JavaScript type=text/JavaScript>
function windowOpen(theURL,winName,features,width,hight,scrollbars,top,left) 
{
  var parameter="top="+top+",left="+left+",width="+width+",height="+hight;
  if(scrollbars=="no")
 {parameter+=",scrollbars=no";}
  else
 {parameter+=",scrollbars=yes";}
  window.open(theURL,winName,parameter);
}
</SCRIPT>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="25" align="center" valign="bottom" class="td06"><table width="98%" border="0" cellspacing="3" cellpadding="0">
      <tr>
        <td width="15"><img src="../../images/index_32.gif" width="9" height="9"></td>
        <td valign="bottom" class="title">门诊挂号</td>
      </tr>
    </table></td>
  </tr>
</table>
<br>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">

  <tr> 

    <td class="td_01"><img src="../../images/arrow_01.gif" width="14" height="14" align="absmiddle">&nbsp;&nbsp;&nbsp;<a href="guahao.jsp" target="mainFrame" class="a14">门诊挂号</a></td>
  </tr>
  <tr> 

    <td class="td_01"><img src="../../images/arrow_01.gif" width="14" height="14" align="absmiddle">&nbsp;&nbsp;&nbsp;<a href="createresulta.jsp" target="mainFrame" class="a14">挂号修改</a></td>
  </tr>
  <tr> 
  
   <td class="td_01"><img src="../../images/arrow_01.gif" width="14" height="14" align="absmiddle">&nbsp;&nbsp;&nbsp;<a href="tuihao.jsp" target="mainFrame" class="a14">门诊退号</a></td>
  </tr>
  <tr> 
  
   <td class="td_01"><img src="../../images/arrow_01.gif" width="14" height="14" align="absmiddle">&nbsp;&nbsp;&nbsp;<a href="guahaochaxun.jsp" target="mainFrame" class="a14">挂号信息查询</a></td>
  </tr>
  <tr> 
</table>
<br>

<br>
</body>
</html>