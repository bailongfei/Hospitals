<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>
<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    });  
}); 
</script> 
<style >
     .required{
	color:red;
	font-size:150%;
}
</style>
</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录后台管理界面平台</span>    
    <ul>
    <li><a href="#">回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
       <!--登陆图片  -->
       <div style="  margin-left:580px; font-family:STCaiyun;margin-top:60px; ">
    <!-- <span class="systemlogo"></span>  -->
         <h1>医院管理信息系统</h1>
       </div>
    <div class="loginbox">
      <form  id="myForm" action="admin_adminLogin.action" method="post">
    <ul>
    <li><input required="required" name="user.userName" type="text" id="ocName" class="loginuser" value="admin"  onclick="JavaScript:this.value=''"/><span class="required" id="spname">*</span></li>
    <li><input required="required"  name="user.password" type="text" id="ocPass" class="loginpwd" value="密码" onclick="JavaScript:this.value=''"/><span class="required" id="spPass"></span></li>
    <li><input  type="submit" class="loginbtn" value="登录" id="login"   /><label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label></li>
    <!-- onclick="javascript:window.location='index.jsp'" -->
    </ul>
       </form>
    
    </div>
    
    </div>
    <div class="loginbm"></div>
</body>
</html>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript">
  /*  $("#ocName").blur(function(){
    
	  $.ajax({
		  url:"${pageContext.request.contextPath}/admin_adminLogin.action",
	      data:{"user.userName":$("#ocName").val()},
	      type:"post",
	      dataType:"json",
	      success:function(data){
	          
	    	    if(data==true){
	               $("#spname").html("可以登录").css("color","#ff0000");
	             }else{
	               $("#spname").html("用户不存在!").css("color","#0000ff");
	             }
	      }
	  });
  });
  $("#ocPass").blur(function(){
  
	  $.ajax({
		  url:"${pageContext.request.contextPath}/admin_adminLogin.action",
	      data:{"user.password":$("#ocPass").val()},
	      type:"post",
	      dataType:"json",
	      success:function(data){
	    	    if(data==true){
	               $("#spPass").html("可以登录").css("color","#ff0000");
	             }else{
	               $("#spPass").html("用户不存在!").css("color","#0000ff");
	             }
	      }
	  });
  });   */
  /* $("#login").click(function(){
     $.ajax({
        url:"${pageContext.request.contextPath}/admin_adminLogin.action",
	      data:{
	          "user.userName":$("#ocName").val(),
	          "user.password":$("#ocPass").val()
	      },
	      type:"post",
	      dataType:"text",
	      success:function(data){
	           
	    	    if(data){
	    	       $("#spname").html("可以登录").css("color","#ff0000");
	               $("#spPass").html("可以登录").css("color","#ff0000");
	                 window.location.href ="${pageContext.request.contextPath}/hospital/html/index.jsp";
	             }else{
	               $("#spname").html("用户不存在!").css("color","#0000ff");
	               $("#spPass").html("用户不存在!").css("color","#0000ff");
	             }
	      }
     });
  }); */
</script> 
