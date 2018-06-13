<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addic.jsp' starting page</title>
    
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
   <style >
     .required{
	color:red;
	font-size:120%;
}
</style>
  </head>
    <!-- <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script> -->
  <body>
    <div id="bbig" style="background-color:#e6f2fb;height:100%">
  
          <div id="yi" style="text-align:center;margin-top:5px;"><FONT SIZE="6px" COLOR="#000">办理IC卡<br><br><br></FONT></div>
 <div id="fj" style="padding-left:10%">
  <a href="hospital/html/cwh/wk.jsp"><FONT SIZE="4px">返回查询</FONT></a></div> 
  <form id="frm" class="form-horizontal" role="form" style="margin-top:20px;padding-left:16%">
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label"><FONT SIZE="4px">姓名</FONT></label>
		<div class="col-sm-10" style="width:60%">
			<input type="text"  name="i.name"  class="form-control" id="firstname" 
				   placeholder="请输入名字"><span class="required" id="sp1">*</span>
		</div>
	</div>
	<div class="form-group">
		<label for="twoname" class="col-sm-2 control-label"><FONT SIZE="4px">金额</FONT></label>
		<div class="col-sm-10" style="width:60%">
			<input type="text"  name="i.money"  class="form-control" id="jine" 
				   placeholder="请输入金额"><span class="required" id="sp2">*</span>
		</div>
	</div>
	
	
	<!-- <div class="form-group">
		<label for="tenname" class="col-sm-2 control-label"><FONT SIZE="4px">患者姓名</FONT></label>
		<div class="col-sm-10" style="width:60%">
			<input type="text"  name="p.patientname"  class="form-control" id="lastname" 
				   placeholder="请输入患者姓名"><span class="required" id="sp4">*</span>
		</div>
	</div> -->
	
	<div class="form-group">
		<label for="fourname" class="col-sm-2 control-label"><FONT SIZE="4px">性别</FONT></label>
		<div class="col-sm-10" style="width:60%">
		<input  name="i.sex"  type="radio"  value="男" >男
					<input  name="i.sex"  type="radio" value="女" >女<br>
		
			<!-- <input type="text"  name="p.sex"  class="form-control" id="firstname" 
				   placeholder="请输入性别"> -->
		</div>
	</div>
	<div class="form-group">
		<label for="sexname" class="col-sm-2 control-label"><FONT SIZE="4px">身份证</FONT></label>
		<div class="col-sm-10" style="width:60%">
			<input type="text"  name="i.card"  class="form-control" id="card" 
				   placeholder="请输入身份证" onkeyup="getAge()"><span class="required" id="sp5">*</span>
		</div>
	</div>
	<div class="form-group">
		<label for="fivename" class="col-sm-2 control-label"><FONT SIZE="4px">年龄</FONT></label>
		<div class="col-sm-10" style="width:60%">
			<input type="text"  name="p.age" readonly="readonly"  class="form-control" id="age" 
				   placeholder="请输入年龄"><span  class="required" id="sp6">*</span>
		</div>
	</div>
	
	<div class="form-group">
		<label for="therename" class="col-sm-2 control-label"><FONT SIZE="4px">手机号</FONT></label>
		<div class="col-sm-10" style="width:60%">
			<input type="text"  name="i.iphone"  class="form-control" id="phone" 
				   placeholder="请输入手机号"><span class="required" id="sp3">*</span>
		</div>
	</div>
	
	<div class="form-group" style="padding-left:40%">
		<div class="col-sm-offset-2 col-sm-10" style="width:20%">
<div><a onclick="addsubmit()" class="btn btn-success">提交</a>
   
   </div>		</div>
	</div>
</form>
  
  
   </div></div>
  </body>
</html>
<script>
function addsubmit(){
var jg=aaa()&&bbb()&&ccc()&&ddd()&&eee()&&fff();
if(jg){
$.ajax({ 
 url:"${pageContext.request.contextPath}/cwh_addic.action",
   type:"post",
   data:$("#frm").serialize(),
 dataType:"json",
 success:function(data){
 
 alert("录入成功！");
 $("#frm input").val("");
 }
});
}else{
   alert("提交失败!");
}
};

//表单验证

 $("#firstname").blur(function(){
    aaa();
 });
 function aaa(){
    var name=$("#firstname").val();
    var reg=/^[\u4E00-\u9FA5A-Za-z0-9_]+$/;
    if(reg.test(name)){
      $("#sp1").html("√").css("color","green");
      return true;
    }else{
      $("#sp1").html("姓名必须填写").css("color","red");
      return false;
    }
 }
   
$("#lastname").blur(function(){
    eee();
 });
 function eee(){
    var name=$("#lastname").val();
    var reg=/^[\u4E00-\u9FA5A-Za-z0-9_]+$/;
    if(reg.test(name)){
      $("#sp4").html("√").css("color","green");
      return true;
    }else{
      $("#sp4").html("姓名必须填写").css("color","red");
      return false;
    }
 }
 
 $("#card").blur(function(){
    bbb();
 });
 function bbb(){
   var card=$("#card").val();
    var sp=/^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
    if(sp.test(card)){
       $("#sp5").html("√").css("color","green");
       return true;
    }else{
      $("#sp5").html("证件格式错误").css("color","red");
       return false;
    }
 }

 $("#age").blur(function(){
    ccc();
 }); 
 function ccc(){
    var age=$("#age").val();
    var sp=/^(?:[1-9][0-9]?|1[01][0-9]|120)$/;//年龄1-120
    var ssp=/^(1[89]|[2-8][0-9]|90)$/;//18-90
     var sssp=/^\+?[1-9][0-9]*$"/;
    if(sp.test(age)){
       $("#sp6").html("√").css("color","green");
       return true;
    }else{
       $("#sp6").html("年龄格式错误").css("color","red");
       return false;
    }
 }
 $("#phone").blur(function(){
    ddd();
 });
 function ddd(){
     var phone=$("#phone").val();
    /* var sp=/^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/; */
    var sp=/^1[3|4|5|7|8][0-9]{9}$/;
    if(sp.test(phone)){
       $("#sp3").html("√").css("color","green");
       return true;
    }else{
       $("#sp3").html("手机号必须为11位").css("color","red");
       return false;
    }
 }
 
 $("#jine").blur(function(){
 
 fff();
 
 });
 function fff(){
    var age=$("#jine").val();
    var sp=/^[1-9]{1}[\d]*$/;
    if(sp.test(age)){
       $("#sp2").html("√").css("color","green");
       return true;
    }else{
       $("#sp2").html("请输入数字").css("color","red");
       return false;
    }
 }
//计算年龄
 function getAge(){
    var card=$("#card").val();
    /* if(card==""||card.length!=18){
      alert('请输入18位正确身份证号');
      return false;
    } */
    var date=new Date();
    var year=date.getFullYear();
    var birthday_year=parseInt(card.substr(6,4));
    var userage=(year-birthday_year);
    $("#age").val(userage);
    return false;
    
 };
</script>
