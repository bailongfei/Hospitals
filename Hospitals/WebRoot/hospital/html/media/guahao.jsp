<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>提交代申报</title>
<link href="../../css/style.css" rel="stylesheet" type="text/css">
 
 <style >
     .required{
	color:red;
	font-size:120%;
}
</style>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<center>

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
  
  
   <form   id="stockForm" onsubmit="return checkName()">
    <table width="95%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="90" height="24" class="td_form01">挂号日期:</td>
        <td class="td_form02">
        <input type="text" id="dates" name="clinicregister.presentTime" class="input" readonly="readonly"/>
        </td>
        <td width="90" class="td_form01">流水号:</td>
        <td class="td_form02">
		<input type="text" id="serialNumber" name="clinicregister.serialNumber" readonly="readonly"/>
		 
	    </td> 
      </tr>
      <tr>
        <td width="90" height="24" class="td_form01">姓名:</td>
        <td class="td_form02">
        <input type="text" id="name" name="clinicregister.patients.patientname" class="input" />
        <span class="required" id="sp1">*</span>
        </td>
        <td width="90" class="td_form01">性别</td>
        <td class="td_form02">
		<input type="radio" value="男" checked="checked" name="clinicregister.patients.sex"/>男
		<input type="radio" value="女" name="clinicregister.patients.sex"/>女&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" value="未就诊" checked="checked" name="clinicregister.patients.status"/>状态未诊
	    </td>
      </tr>
      
      <tr>
        <td width="90" height="24" class="td_form01">身份证号:</td>
        <td class="td_form02">
        <input name="clinicregister.patients.idnumber" type="text" id="card" class="input" onkeyup="getAge()"/>
        <span class="required" id="sp2">*</span>
        </td>
        <td width="90" class="td_form01">年龄:</td>
        <td class="td_form02">
		<input type="text" name="clinicregister.patients.age" id="age" />
	    <span id="sp3"></span>
	    </td> 
      </tr>
      
    </table>    
   
    <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">

       <tr>
        <td width="90" class="td_form01">手机号</td>
        <td class="td_form02">
        <input type="text" name="clinicregister.iphone" id="phone" class="input"/>
        <span class="required" id="sp4">*</span>
        </td>
      </tr> 
      <tr>
        <td class="td_form01">挂号科室</td>
        <td class="td_form02">
           <select id="selea" class="sel" name="clinicregister.office.officeId">  
           </select>
         </td>
      </tr>
      <tr>
        <td class="td_form01">选医生挂号</td>
        <td class="td_form02">
        <select id="seleb" class="sel" name="clinicregister.stuff.stuffid2">
            
        </select>
        
        </td>
      </tr>
      <tr>
        <td class="td_form01">挂号类型</td>
        <td class="td_form02">
        <select id="selec" class="sel" name="clinicregister.registeredtype.ghId">
        </select>
        </td>
      </tr>
    </table>
    <table width="95%" border="0" cellspacing="0" cellpadding="0">
       <tr>
        <td width="90" height="24" class="td_form01">门诊费:</td>
        <td class="td_form02">
        <input type="text" id="fy"  name="clinicregister.charge.charge" class="input" />
        <span class="cl"></span>
        <!-- <input type="hidden"  name="clinicregister.charge.id" /> -->
        </td>
        <td width="90" class="td_form01">应收费:</td>
        <td class="td_form02">
		<input type="text" id="ys" readonly="readonly" name="clinicregister.charge.chargeable"/>
	    </td> 
      </tr>
      <tr>
        <td width="90" height="24" class="td_form01">实收费:</td>
        <td class="td_form02"><input type="text" id="ss" name="clinicregister.charge.realCharge" class="input" />
         <span class="cls"></span>
        </td>
        
        <td width="90" class="td_form01">(+找零)/(-欠):</td>
        <td class="td_form02">
		<input type="text" id="zl" readonly="readonly" name="clinicregister.charge.changes"/>
		
	    </td> 
      </tr>
    </table>
       <input style=" border:0px;" align="center" type="text" id="tt" readonly="readonly"/>
       <input align="center" type="button" id="add" value="提交">
       <input align="center" type="button" id="fanhiu" value="返回" >
       <!-- onclick="window.open('lists.jsp')" -->
  </form>
  
</center>
</body>
</html>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript">
  $("#fy").blur(function(){
      var f=$("#fy").val();
      $("#ys").val(f);
  });
  $("#ss").blur(function(){
       var f=$("#fy").val();
       $("#ys").val(f);
       var sou=$("#ss").val();
       var zling=parseFloat(sou-f);
       $("#zl").val(zling);
  });
   $(document).ready(function(){
         
         findoff();
  }); 
  
  function findoff(){
  
       $.ajax({
          url:"${pageContext.request.contextPath}/ps_findOk.action",
          dataType:"json",
          type:"post",
          success:function(data){
             $("#selea").append("<option value='-1'>--------请选择--------</option>");
            for(var i=0;i<data.length;i++){
               var off=data[i];
               $("#selea").append("<option value='"+off.officeId+"'>"+off.officeName+"</option>");
            }  
          }
       }); 
       $.ajax({
          url:"${pageContext.request.contextPath}/ps_findStuff.action",
          dataType:"json",
          type:"post",
          success:function(data){
            $("#seleb").append("<option value='-1'>--------请选择--------</option>");
            for(var i=0;i<data.length;i++){
               var off=data[i];
               
               $("#seleb").append("<option value='"+off.stuffid2+"'>"+off.stuffname+"</option>");
            }  
          }
       }); 
       $.ajax({
          url:"${pageContext.request.contextPath}/ps_findRdy.action",
          dataType:"json",
          type:"post",
          beforeSend:function(){$("#tt").html("数据加载中。。。")},
          success:function(data){
            $("#selec").append("<option value='-1'>--------请选择--------</option>");
            for(var i=0;i<data.length;i++){
               var off=data[i];
               $("#selec").append("<option value='"+off.ghId+"'>"+off.typeName+"</option>");
            }  
          }
       }); 
   
  }
  
  $("#add").click(function(){
     var check=aaa()&&bbb()&&ccc()&&ddd()&&eee()&&fff();
     if(check){ 
              $.ajax({
        url:"${pageContext.request.contextPath}/ps_addOrupdate.action",
        data:$("#stockForm").serialize(),
          dataType:"json",
          type:"post",
          success:function(data){
            if(data.state>0){
                alert(data.message);
              
            }
            /*  $("#stockForm").reset(); */
            $("#stockForm input[type=text],input[text=hidden]").val("");
              getDate();
              getId();
             /* resetAll(); */
          }
      });
     }else{
       alert("提交失败!");
     }  
       
  });
  $(function(){
    getDate();
    getId();
    
});
    function getId(){
    $.ajax({
       url:"${pageContext.request.contextPath}/ps_getNewId.action",
       dataType:"json",
       type:"post",
       success:function(data){
          $("#serialNumber").val(data);
       }
    });
 };
    
$("#fanhiu").click(function(){
    window.location.href="lists.jsp";
});

function resetAll(){
     $("#stockForm").find('input[type=text],input[type=hidden]').each(function() {
         $(this).val('');
     });
 };
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
 //获取日期
   function getDate(){
    var d=new Date();
    var day=d.getDate();
    var month=d.getMonth()+1;
    var year=d.getFullYear();
    var rq=(year+"-"+month+"-"+day); 
    $("#dates").val(rq);
    };
    
 //表单验证

 $("#name").blur(function(){
    aaa();
 });
 function aaa(){
    var name=$("#name").val();
    var reg=/^[\u4E00-\u9FA5A-Za-z0-9_]+$/;
    if(reg.test(name)){
      $("#sp1").html("√").css("color","green");
      return true;
    }else{
      $("#sp1").html("姓名必须填写").css("color","red");
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
       $("#sp2").html("√").css("color","green");
       return true;
    }else{
      $("#sp2").html("证件格式错误").css("color","red");
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
       $("#sp3").html("√").css("color","green");
       return true;
    }else{
       $("#sp3").html("年龄格式错误").css("color","red");
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
       $("#sp4").html("√").css("color","green");
       return true;
    }else{
       $("#sp4").html("手机号必须为11位").css("color","red");
       return false;
    }
 }
 $("#fy").blur(function(){
    eee();
 });
 function eee(){
    var age=$("#fy").val();
    var sp=/^[1-9]{1}[\d]*$/;
    if(sp.test(age)){
       $(".cl").html("√").css("color","green");
       return true;
    }else{
       $(".cl").html("请输入数字").css("color","red");
       return false;
    }
 }
 $("#ss").blur(function(){fff();});
 function fff(){
    var age=$("#ss").val();
    var sp=/^[1-9]{1}[\d]*$/;
    if(sp.test(age)){
       $(".cls").html("√").css("color","green");
       return true;
    }else{
       $(".cls").html("请输入数字").css("color","red");
       return false;
    }
 }

/*  //提交表单条件
    function checkName(){
    alert("提交？？？");
    var check=$("input").blur();
    return check;
 }; */
   

 
 
</script>
