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
        <div id="yi" style="text-align:center;margin-top:10px;"><FONT SIZE="6px" COLOR="#000">IC卡充值<br><br><br></FONT></div>
        <div id="rt" style="padding-left:5%"> <input type="text" class="name" onkeyup="key1()">点击搜索</div>
     
     <!--  <div id="t" style="padding-left:10%;margin-top:10px;">
       <a href="hospital/html/cwh/addic.jsp"><FONT SIZE="5px" color="#000">办理IC卡</FONT></a>
       </div> -->
      
  <div id="er" style="padding-left:5%;margin-top:20px;height:100%">
    <table class="table table-hover">
	<thead>
         <tr class="success">
            <td >充值编号</td>
            <td >姓名</td>
            <td >金额</td>
            <td >手机号</td>
    
            <td colspan="2">操作</td> 
 
         </tr>
         </thead>
         
         <tbody id="myTab"></tbody>
        
     </table>
     </div>
     
     
     <div id="sch_1" style="display: none">
	  <table class="table table-hover">	 	
 		 <tr class="success">
            <td >充值编号</td>
            <td >姓名</td>
            <td >金额</td>
            <td >手机号</td>
           
            <td colspan="2">操作</td>

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
		<label for="firstname" class="col-sm-2 control-label">名字</label>
		<div class="col-sm-10">
			<input type="hidden" id="icid" name="i.icid">
			<input  name="i.name"  type="text" class="form-control"  id="name"  readonly="readonly"><br>
		</div>
	</div>
		<div class="form-group">
		<label for="therename" class="col-sm-2 control-label">金额</label>
		<div class="col-sm-10">
			<input     type="text" class="form-control"  id="money" readonly="readonly"><br>
		</div>
	</div>
	<div class="form-group">
		<label for="fourname" class="col-sm-2 control-label">手机号</label>
		<div class="col-sm-10">
			<input  name="i.iphone"   type="text" class="form-control"  id="phone"  readonly="readonly"><br>
		</div>
	</div>
	<div class="form-group">
		<label for="fivename" class="col-sm-2 control-label">充值金额</label>
		<div class="col-sm-10">
			<input    type="text"  name="i.money"class="form-control"  id="jin" ><br>
		</div>
	</div>
	</form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary"  onclick="updateic()">确认充值</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div> 
      
  
  </body>
</html>
<script>
$(function(){

          $.ajax({
             url:"${pageContext.request.contextPath}/cwh_selectsi.action",
             type:"post",
             dataType:"json",
             success:function(data){
             //每次记载之前先清空当前页面的数据
                 $("#myTab").html('');
                 for(var i=0;i<data.length;i++){
                   var tr="<tr>";
                   tr+="<td>"+data[i].icid+"</td>";
                   tr+="<td>"+data[i].name+"</td>";
                   tr+="<td>"+data[i].money+"</td>";
                   tr+="<td>"+data[i].iphone+"</td>";
                   tr+="<td><input type='button'  class='zhu btn-default' value='注销'></td>"; 
                   tr+="<td><input type='button' data-toggle='modal' data-target='#myModal' value='充值' class='update btn btn-primary'  id="+data[i].icid+" onclick='beforeupdate("+data[i].icid+")'/></td>";
                   tr+="</tr>"; 
                   $("#myTab").append(tr);
                   }
                 
             }
          });
          
})

function beforeupdate(icid){

	$.ajax({
		url:"${pageContext.request.contextPath}/cwh_ICfindById.action",
		data:{"i.icid":icid},
		dataType:"json",
		type:"post",
		success:function(data1){
		
			var i=data1;
			$("#icid").val(i.icid);
			$("#name").val(i.name);
			$("#money").val(i.money);
			$("#phone").val(i.iphone);
			
			
		}
	});
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
			url:"${pageContext.request.contextPath}/cwh_selectname.action",
			type:"post",
			data:{"name":content},
			dataType:"json",
			success:function(data){
				  $("#drue").html('');
                 for(var i=0;i<data.length;i++){
                   var tr="<tr>";
                    tr+="<td>"+data[i].icid+"</td>";
                   tr+="<td>"+data[i].name+"</td>";
                   tr+="<td>"+data[i].money+"</td>";
                   tr+="<td>"+data[i].iphone+"</td>";
                 tr+="<td><a onclick='del("+data[i].icid+")' class='zhu'>注销</a></td>"; 
                    tr+="<td><input type='button' data-toggle='modal' data-target='#myModal' value='充值' class='update btn btn-primary'  id="+data[i].icid+" onclick='beforeupdate("+data[i].icid+")'/></td>";
                   tr+="</tr>"; 
              $("#drue").append(tr);
                   
                   }
			}
	})}}
             
 function updateic(){

	$.ajax({
		url:"${pageContext.request.contextPath}/cwh_updateIccard.action",
		data:$("#fm").serialize(),
		dataType:"text",
		type:"post",
		success:function(){
			alert("修改成功！");
			location.reload();
		}
	})
}
//删除数据
   
     var money;
     $(document).on("click",".zhu",function(){
         money=this;
    var i=$(money).parent().parent().children().eq(2).html();
     var obj=$(money).parent().parent().children().eq(0).html();
        if(i>0){
          alert("不能注销有余额的用户!");
        }else{
             $.ajax({
            url:"${pageContext.request.contextPath}/cwh_delic.action",
            type:"post",
            data:{"icid":obj},
            dataType:"text",
            success:function(data){
            alert("注销成功!");
            location.reload();
              /*  if(data==true){
               alert("删除成功");
                 selectcwh();
               }else{
                  alert("删除失败");
               }
           
      */ }
        });
        }
     });
     
     
    /*  function del(obj){
    
    };  */
 
 /* function addsubmit(){
$.ajax({
 url:"addic.action",
   type:"post",
   data:$("#frm").serialize(),
 dataType:"json",
 success:function(data){
 alert("OK");
 }
});
};
 */
</script>