<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'yonghu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap-theme.min.css">
	
   <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script
	src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
  <style type="text/css">
     tbody select{
         width: 150px;
         height:28px;
     } 
     tbody input{
         width: 150px;
          height:28px;
     } 
  </style>
  
  </head>
  
  <body>
   <form action="" id="myForm">
   <table class="table table-hover">
  <caption>员工维护&nbsp;&nbsp;<input type="button" value="增加用户" class="btn btn-success btn-sm" id="addHang"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="保存用户" class="btn btn-success btn-sm" id="saveYonghu"/>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input  type="button" onclick='history.back()' value="退出" class="btn btn-success btn-sm" id="tui"/>
  </caption>
  
  <thead>
    <tr class="success">
      <th>员工代码</th>
      <th>员工姓名</th>
      <th>性别</th>
      <th>证号</th>
      <th>角色</th>
      <th>科室</th>
      <th>职务</th>
      <th>职位</th>
      <th>类型</th>
    
    </tr>
  </thead>
  <tbody id="tbody">
    <tr>
        <td>
        <input type='text' class='stuId' readonly="readonly"  name='list[0].stuffid2'>
        <input type='hidden' class='stuId' readonly="readonly"  name='list2[0].stuff.stuffid2'>
        </td>
        <td>
        <input type='text'  class='stuffnames' placeholder='请输入员工姓名' name='list[0].stuffname'>
        <input type='hidden'  class='userNames' name='list2[0].userName'>
        </td>
        <td>
         <select name='list[0].sex3'>
           <option value='男'>男</option>
           <option value='女'>女</option>
         </select>
        </td>
        <td>
        <input type='text' class='idCard' placeholder='请输入证号' name='list[0].idcard'>
        <input type='hidden' class='icCard'  name='list2[0].password'>
        </td>
        <td><select id="selea"  name='list2[0].roles.rolesId'></select></td>
        <td><select id="seleb"  name='list[0].office.officeId'></select></td>
        <td><select id="selec"  name='list[0].position.positionid'></select></td>
        <td><select id="seled"  name='list[0].jobtitle.jobTitleId'></select></td>
        <td><select id="selee"  name='list[0].stufftype.stuffTypeId'></select></td>
        
   </tr>
  </tbody>
</table>

</form>

  </body>
</html>
<script>
    
    var i=1;
    var stuId;
    $(".table").on("click","#addHang",function(){
         var tr="<tr class='tr'>"
        +"<td class='idc'><input type='text'  class='stuId' readonly='readonly'  name='list["+i+"].stuffid2'><input type='hidden' class='stuId' readonly='readonly'  name='list2["+i+"].stuff.stuffid2'></td>"
        +"<td><input type='text' class='stuffnames' placeholder='请输入员工姓名' name='list["+i+"].stuffname'><input type='hidden' class='userNames' name='list2["+i+"].userName'></td>"
        +"<td><select name='list["+i+"].sex3'><option value='男'>男</option><option value='女'>女</option></select></td>"
        +"<td><input type='text' class='idCard' placeholder='请输入证号' name='list["+i+"].idcard'><input type='hidden' class='icCard' name='list2["+i+"].password'></td>"
        +"<td><select id='selea'  name='list2["+i+"].roles.rolesId'></select></td>"
        +"<td><select id='seleb'  name='list["+i+"].office.officeId'></select></td>"
        +"<td><select id='selec'  name='list["+i+"].position.positionid'></select></td>"
        +"<td><select id='seled'  name='list["+i+"].jobtitle.jobTitleId'></select></td>"
        +"<td><select id='selee'  name='list["+i+"].stufftype.stuffTypeId'></select></td>"
        +"</tr>"
        $("#tbody").append(tr);
        
        
        var id=$(".stuId").val();
        var ids=parseFloat(id)+parseFloat(i);
        stuId=this;
        //$("#tbody .tr .stuId").val(ids);
        //$("#tbody .tr .stuId").attr("value",ids);
        //$(stuId).parent().children().eq().val(ids);
        //$(stuId).parent().parent().find(".stuId").val(ids);
        //$(stuId).parent().siblings("tbody").eq(parseInt(i)-1).children().next().children(".idc").children().val(ids);
        $(stuId).parent().siblings("#tbody").children().eq(i).children().eq(0).children().val(ids);
        
        
        i++;//行号增加
    });
  
      
     $(function(){
     
          $.ajax({
          url:"${pageContext.request.contextPath}/ps_getStuId.action",
          dataType:"json",
          type:"post",
          success:function(data){
            
             $(".stuId").val(data);
          }
        });
    
        $.ajax({
          url:"${pageContext.request.contextPath}/ps_selectRolesAll.action",
          //data:$("#myForm").serialize(),
          dataType:"json",
          type:"post",
          success:function(data){
              /* $("#selea").append("<option value='-1'>-----请选择角色----</option>"); */
            for(var i=0;i<data.length;i++){
               var off=data[i];
               $("#selea").append("<option value='"+off.rolesId+"'>"+off.rolesName+"</option>");
            }  
          }
        });
        
        $.ajax({
          url:"${pageContext.request.contextPath}/ps_findOk.action",
          //data:$("#myForm").serialize(),
          dataType:"json",
          type:"post",
          success:function(data){
              
            for(var i=0;i<data.length;i++){
               var off=data[i];
               $("#seleb").append("<option value='"+off.officeId+"'>"+off.officeName+"</option>");
            }  
          }
        });
        
        $.ajax({
          url:"${pageContext.request.contextPath}/ps_findPosition.action",
          //data:$("#myForm").serialize(),
          dataType:"json",
          type:"post",
          success:function(data){
             
            for(var i=0;i<data.length;i++){
               var off=data[i];
               $("#selec").append("<option value='"+off.positionid+"'>"+off.positionname+"</option>");
            }  
          }
        });
        
        $.ajax({
          url:"${pageContext.request.contextPath}/ps_findJobtitle.action",
          //data:$("#myForm").serialize(),
          dataType:"json",
          type:"post",
          success:function(data){
             
            for(var i=0;i<data.length;i++){
               var off=data[i];
               $("#seled").append("<option value='"+off.jobTitleId+"'>"+off.jobTitleName+"</option>");
            }  
          }
        });
        
        $.ajax({
          url:"${pageContext.request.contextPath}/ps_findStufftype.action",
          //data:$("#myForm").serialize(),
          dataType:"json",
          type:"post",
          success:function(data){
              
            for(var i=0;i<data.length;i++){
               var off=data[i];
               $("#selee").append("<option value='"+off.stuffTypeId+"'>"+off.stuffTypeName+"</option>");
            }  
          }
        });
        
    }); 
  
    $("#addHang").click(function(){
     
       $.ajax({
          url:"${pageContext.request.contextPath}/ps_selectRolesAll.action",
          //data:$("#myForm").serialize(),
          dataType:"json",
          type:"post",
          success:function(data){
             $("#tbody #selea").empty();
              
            for(var i=0;i<data.length;i++){
               var off=data[i];
               $("#tbody #selea").append("<option value='"+off.rolesId+"'>"+off.rolesName+"</option>");
            }  
          }
        });
        
        $.ajax({
          url:"${pageContext.request.contextPath}/ps_findOk.action",
          //data:$("#myForm").serialize(),
          dataType:"json",
          type:"post",
          success:function(data){
              $("#tbody #seleb").empty();
              
            for(var i=0;i<data.length;i++){
               var off=data[i];
               $("#tbody #seleb").append("<option value='"+off.officeId+"'>"+off.officeName+"</option>");
            }  
          }
        });
        
         $.ajax({
          url:"${pageContext.request.contextPath}/ps_findPosition.action",
          //data:$("#myForm").serialize(),
          dataType:"json",
          type:"post",
          success:function(data){
              $("#tbody #selec").empty();
              
            for(var i=0;i<data.length;i++){
               var off=data[i];
               $("#tbody #selec").append("<option value='"+off.positionid+"'>"+off.positionname+"</option>");
            }  
          }
        });
        
         $.ajax({
          url:"${pageContext.request.contextPath}/ps_findJobtitle.action",
          //data:$("#myForm").serialize(),
          dataType:"json",
          type:"post",
          success:function(data){
              $("#tbody #seled").empty();
              
            for(var i=0;i<data.length;i++){
               var off=data[i];
               $("#tbody #seled").append("<option value='"+off.jobTitleId+"'>"+off.jobTitleName+"</option>");
            }  
          }
        });
        
        
        $.ajax({
          url:"${pageContext.request.contextPath}/ps_findStufftype.action",
          //data:$("#myForm").serialize(),
          dataType:"json",
          type:"post",
          success:function(data){
             $("#tbody #selee").empty();
              $("#tbody #selee").append("<option value='-1'>---请选择员工类型--</option>");
            for(var i=0;i<data.length;i++){
               var off=data[i];
               $("#tbody #selee").append("<option value='"+off.stuffTypeId+"'>"+off.stuffTypeName+"</option>");
            }  
          }
        });
        
    });
    //提交表单数据
    $("#saveYonghu").click(function(){
      var check=aaa()&&bbb();
      if(check){
              $.ajax({
            url:"${pageContext.request.contextPath}/ps_addStuff.action",
            data:$("#myForm").serialize(),
            dataType:"json",
            type:"post",
            success:function(data){
             //$("#tbody .tr").empty();
             document.location.reload();//当前页面 刷新
              if(data.state>0){
                alert(data.message);
              
              }else{"提交失败!"}
              
            }
         });
      }else{
         alert("提交失败!");
      }
         
    });
    
     //员工登陆号
    
    var stuname;
     $("#tbody").on("blur",".stuffnames",function(){
     stuname=this;
       var name=$(stuname).parent().children().eq(0).val();
       aaa();
       $(stuname).parent().children().eq(1).val(name);
       
    }); 
    
    
    //截取身份号后六位
    var card;
    $("#tbody").on("blur",".idCard",function(){
       card=this;
       var idCard=$(card).parent().children().eq(0).val();
       bbb();
       var icsCard=idCard.substring(12,18);
       $(card).parent().children().eq(1).val(icsCard);
       
    });
    
     function aaa(){
    var name=$(stuname).parent().children().eq(0).val();
    var reg=/^[\u4E00-\u9FA5A-Za-z0-9_]+$/;
    if(reg.test(name)){
      /* $("#sp1").html("√").css("color","green"); */
      return true;
    }else{
      alert("请输入正确的姓名格式!");
      /* $("#sp1").html("姓名必须填写").css("color","red"); */
      return false;
    }
 }
    
    function bbb(){
   var cards=$(card).parent().children().eq(0).val();
    var sp=/^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
    if(sp.test(cards)){
       /* $("#sp2").html("√").css("color","green"); */
       return true;
    }else{
       alert("请输入正确的证件格式");
      //$("#sp2").html("证件格式").css("color","red");
       return false;
    }
 }
    
  
 
   /* $(function(){
   
     $("#addHang").click(function(){
        alert("addHang");
     });
   }); */
   
</script>