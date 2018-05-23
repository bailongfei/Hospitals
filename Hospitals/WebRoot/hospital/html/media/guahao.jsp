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
 <!-- <script type="text/javascript">
   $(document).ready(function(){
      alert("111");
   });
 </script> -->
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
  
  
   <form action=""  id="stockForm">
    <table width="95%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="90" height="24" class="td_form01">挂号日期:</td>
        <td class="td_form02"><input type="data" name="clinicregister.presentTime" class="input" /></td>
        <td width="90" class="td_form01">流水号:</td>
        <td class="td_form02">
		<input type="text" name="clinicregister.serialNumber"/>
		
	    </td> 
      </tr>
      <tr>
        <td width="90" height="24" class="td_form01">姓名:</td>
        <td class="td_form02"><input type="text" name="clinicregister.patients.patientname" class="input" /></td>
        <td width="90" class="td_form01">性别</td>
        <td class="td_form02">
		<input type="radio" value="男" checked="checked" name="clinicregister.patients.sex"/>男
		<input type="radio" value="女" name="clinicregister.patients.sex"/>女
	    </td>
      </tr>
      
      <tr>
        <td width="90" height="24" class="td_form01">年龄:</td>
        <td class="td_form02"><input type="text" name="clinicregister.patients.age" class="input" /></td>
        <td width="90" class="td_form01">手机号:</td>
        <td class="td_form02">
		<input type="text" name="clinicregister.iphone"/>
		
	    </td> 
      </tr>
      
    </table>    
   
    <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">

       <tr>
        <td width="90" class="td_form01">证件号</td>
        <td class="td_form02"><input name="clinicregister.patients.idnumber" type="text" class="input" ></td>
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
        <td class="td_form02"><input type="text" id="fy" name="clinicregister.charge.charge" class="input" /></td>
        <td width="90" class="td_form01">应收费:</td>
        <td class="td_form02">
		<input type="text" id="ys" readonly="readonly" name="clinicregister.charge.chargeable"/>
	    </td> 
      </tr>
      <tr>
        <td width="90" height="24" class="td_form01">实收费:</td>
        <td class="td_form02"><input type="text" id="ss" name="clinicregister.charge.realCharge" class="input" /></td>
        <td width="90" class="td_form01">(+找零)/(-欠):</td>
        <td class="td_form02">
		<input type="text" id="zl" readonly="readonly" name="clinicregister.charge.changes"/>
		
	    </td> 
      </tr>
    </table>
   
       <input align="center" type="button" id="add" value="提交">
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
             $("#selea").append("<option value=''>--------请选择--------</option>");
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
            for(var i=0;i<data.length;i++){
               var off=data[i];
               $("#seleb").append("<option value=''>--------请选择--------</option>");
               $("#seleb").append("<option value='"+off.stuffid2+"'>"+off.stuffname+"</option>");
            }  
          }
       }); 
       $.ajax({
          url:"${pageContext.request.contextPath}/ps_findRdy.action",
          dataType:"json",
          type:"post",
          success:function(data){
            $("#selec").append("<option value=''>--------请选择--------</option>");
            for(var i=0;i<data.length;i++){
               var off=data[i];
               $("#selec").append("<option value='"+off.ghId+"'>"+off.typeName+"</option>");
            }  
          }
       }); 
   
  }
  
  $("#add").click(function(){
      $.ajax({
        url:"${pageContext.request.contextPath}/ps_addOrupdate.action",
        data:$("#stockForm").serialize(),
          dataType:"json",
          type:"post",
          success:function(data){
            if(data.state>0){
                alert(data.message);
            }
          }
      });
  });
</script>
