<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'wk.jsp' starting page</title>
    
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
  
  <!-- <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script> -->
  <body>
  <div id="bg" >
        <div id="yi" style="text-align:center;margin-top:5px;"><FONT SIZE="6px" COLOR="#000">IC卡办理记录<br><br><br></FONT></div>
       <div id="rt" style="padding-left:5%"> <input type="text" class="name" onkeyup="key1()">搜索</div>
     
       <div id="t" style="padding-left:10%;margin-top:10px;">
       <a href="hospital/html/cwh/addic.jsp"><FONT SIZE="5px" color="#000">办理IC卡</FONT></a>
       </div>
      
  <div id="er" style="padding-left:5%;margin-top:20px;height:100%">
    <table class="table table-hover">
	<thead>
         <tr class="success">
            <td >办理编号</td>
            <td >办卡人姓名</td>
             <td >性别</td>
            <td >金额</td>
            <td >手机号</td>
           <!--  <td >患者姓名</td> -->
           
            <!-- <td >年龄</td> -->
            <td >身份证号</td>
            <td >操作</td>
 
         </tr>
         </thead>
         
         <tbody id="myTab"></tbody>
        
     </table>
     </div>
     
     
     <div id="sch_1" style="display: none">
	  <table class="table table-hover">	 	
 		 <tr class="success">
            <td >办理编号</td>
            <td >办卡人姓名</td>
            <td >性别</td>
            <td >金额</td>
            <td >手机号</td> 
           <!--  <td >年龄</td> -->
            <td >身份证号</td>
            <td >操作</td>

         </tr>
 	  	<tbody id="drue">
 	  		
 	  	</tbody>
 	  </table>
 	</div>
 	
     
    
 <!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">个人信息</h4>
            </div>
            <div class="modal-body">
            <form action=""  id="fm">
            	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">办卡名字</label>
		<div class="col-sm-10">
			<input type="hidden" id="icid" name="i.icid">
			<input  name="i.name"  type="text" class="form-control"  id="name" ><br>
<!-- 						<input type="hidden" id="icid" name="i.patients.patientname">
 -->			
		</div>
	</div>
		<div class="form-group">
		<label for="therename" class="col-sm-2 control-label">金额</label>
		<div class="col-sm-10">
			<input  name="i.money"   type="text" class="form-control"  id="money" ><br>
		</div>
	</div>
	<div class="form-group">
		<label for="fourname" class="col-sm-2 control-label">手机号</label>
		<div class="col-sm-10">
			<input  name="i.iphone"   type="text" class="form-control"  id="phone" ><br>
		</div>
	</div>
	<!-- <div class="form-group">
		<label for="tenname" class="col-sm-2 control-label">患者姓名</label>
		<div class="col-sm-10">
		
			<input  name="i.patients.patientname"   type="text" class="form-control"  id="pname" ><br>
		</div>
	</div> -->
	<div class="form-group">
		<label for="fivename" class="col-sm-2 control-label">性别</label>
		<div class="col-sm-10">
		
			<input  name="i.sex"   type="text" class="form-control"  id="sex" ><br>
		</div>
	</div>
	<!-- <div class="form-group">
		<label for="fivename" class="col-sm-2 control-label">年龄</label>
		<div class="col-sm-10">
			<input  name="i.patients.age"   type="text" class="form-control"  id="age" ><br>
		</div>
	</div> -->
	<div class="form-group">
		<label for="fivename" class="col-sm-2 control-label">身份证</label>
		<div class="col-sm-10">
			<input  name="i.card"   type="text" class="form-control"  id="idcard" ><br>
		</div>
	</div>
	
	</form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary"  onclick="updateic()">提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div> 
     
  </div>
  </body>
</html>
<script>
$(function(){

          $.ajax({
             url:"${pageContext.request.contextPath}/cwh_selectic.action",
             type:"post",
             dataType:"json",
             success:function(data){
             //每次记载之前先清空当前页面的数据
                 $("#myTab").html('');
                 for(var i=0;i<data.length;i++){
                   var tr="<tr>";
                   tr+="<td>"+data[i].icid+"</td>";
                   tr+="<td>"+data[i].name+"</td>";
                   tr+="<td>"+data[i].sex+"</td>";
                   tr+="<td>"+data[i].money+"</td>";
                   tr+="<td>"+data[i].iphone+"</td>";
                   /* tr+="<td>"+data[i].patientname+"</td>"; */
                   
                   /* tr+="<td>"+data[i].age+"</td>"; */
                   tr+="<td>"+data[i].card+"</td>";
                   /* tr+="<td><a onclick='del("+data[i].icid+")'>删除</a></td>"; */
                   tr+="<td><input type='button' data-toggle='modal' data-target='#myModal' value='补卡' class='update btn btn-primary'  id="+data[i].icid+" onclick='beforeupdate("+data[i].icid+")'/></td>";
                   tr+="</tr>"; 
                   $("#myTab").append(tr);
                   }
                 
             }
          });
          
})
 //删除数据

  /*   function del(obj){
        $.ajax({
            url:"delic.action",
            type:"post",
            data:{"icid":obj},
            dataType:"text",
            success:function(data){
               if(data==true){
               alert("删除成功");
                 wk();
               }else{
                  alert("删除失败");
               }
            }
     
        });
    } 
 */       
function addsubmit(){
$.ajax({
 url:"${pageContext.request.contextPath}/cwh_addic.action",
   type:"post",
   data:$("#frm").serialize(),
 dataType:"json",
 success:function(data){
 alert("OK");
 }
});
};

function beforeupdate(icid){

	$.ajax({
		url:"${pageContext.request.contextPath}/cwh_selectbyid.action",
		data:{"i.icid":icid},
		dataType:"json",
		type:"post",
		success:function(data1){
		
			var i=data1;
			$("#icid").val(i.icid);
			$("#name").val(i.name);
			$("#money").val(i.money);
			$("#phone").val(i.iphone);
			//$("#pname").val(i.patientname);
			$("#sex").val(i.sex);
			//$("#age").val(i.age);
			$("#idcard").val(i.card)
			
		}
	});
}
function updateic(){

	$.ajax({
		url:"${pageContext.request.contextPath}/cwh_updatec.action",
		data:$("#fm").serialize(),
		dataType:"text",
		type:"post",
		success:function(){
			alert("修改成功！");
			location.reload();
		}
	})
}
function key1(){
		
		//判断搜索框是否为空
		var content = $(".name").val();
		if(content==""){
			
			$("#sch_1").css("display","none");
			$("#er").css("display","block");
			return ;
		}
		if(content!=""){
		
			
			$("#sch_1").css("display","block");
			$("#er").css("display","none");
			$.ajax({
			url:"${pageContext.request.contextPath}/cwh_selname.action",
			type:"post",
			data:{"name":content},
			dataType:"json",
			success:function(data){
				  $("#drue").html('');
                 for(var i=0;i<data.length;i++){
                   var tr="<tr>";
                    tr+="<td>"+data[i].icid+"</td>";
                   tr+="<td>"+data[i].name+"</td>";
                   tr+="<td>"+data[i].sex+"</td>";
                   tr+="<td>"+data[i].money+"</td>";
                   tr+="<td>"+data[i].iphone+"</td>";
                   /* tr+="<td>"+data[i].patientname+"</td>"; */

                   
                   /* tr+="<td>"+data[i].age+"</td>"; */
                   tr+="<td>"+data[i].card+"</td>";
                    tr+="<td><input type='button' data-toggle='modal' data-target='#myModal' value='补卡' class='update btn btn-primary'  id="+data[i].icid+" onclick='beforeupdate("+data[i].icid+")'/></td>";
                   tr+="</tr>"; 
              $("#drue").append(tr);
                   
                   }
			}
	})}}
             

</script>