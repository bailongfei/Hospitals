<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'paiban.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript"  src="js/jquery-2.1.1.min.js"></script>
	<meta charset="utf-8"> 
	<title>Bootstrap 实例 - 悬停表格</title>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<title>Bootstrap 实例 - 默认的分页</title>
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
	*{text-align: center;font-family: "微软雅黑";}
	table{border: 0px solid #999; border-collapse:collapse; text-align: center;}
	table tr{border: 1px solid #999; border-collapse:collapse;}
	table td{border: 1px solid #999; border-collapse:collapse;}
	select{border:0px;}
	.icinput{display: none;}
	.biaoti{width: 100%;height: 40px;background-color: #6CA6CD;border:0px;border-bottom:1px solid #333;
	color:#fff;border-radius: 40px 40px 0 0;font-size: 25px;font-weight: 100;}
</style>
  </head>
  <body>
  <div  style="position: absolute;height:800px;width:1200px;margin-left: 70px;">
  <div  style="position: absolute;height:100px;width:1200px;border:1px #6CA6CD solid;background:#F8F8F8;top: 50px;border-radius: 40px 40px 0 0;">
 
<input  class="biaoti" value="  排班管理">
  <div  style="position: absolute;left: 80px;top: 57px;font-size: 20px;font-weight:100;color:#1874CD;">
 
		 <a href="findByPages.action?sx=1">上周</a>&nbsp;&nbsp;
		 <a href="findByPages.action?sx=0">本周</a>&nbsp;&nbsp;
		 <a href="findByPages.action?sx=2">下周</a>
		
  </div>
  <div style="position: absolute;left: 820px;top: 55px;font-size: 20px;font-weight:100;color:#1874CD;">
    <form method="post" action="findByPages.action">
        <span style="font-size: 20px;font-weight:100;">角色名字</span> 
	     <input type="text"  name="stuffname"   placeholder="请输入角色名字" >
		 <input type="submit"  value="查询" >
		 </form>
		 </div>
		 </div> <div style="position: absolute;top: 150px">
       <table  class="table table-hover">
        <tr style="height: 50px;background-color: #f9f9f9" id="timtr">
        <td>照片</td>
          <td>姓名</td>
         </tr>
        
         <tbody id="mytab"></tbody>
        <tr style="height: 30px;border:0px; "></tr>
	    <tr style="border:0px; height: 40px;">
		    <td  colspan="4" style="border:0px;">  
			   
		   <ul class="pagination">
	<li><a   class="one">&laquo;</a></li>
	<li><a   class="shang">上一页</a></li>
	<li><a class="one">1</a></li>
	<li><a class="two">2</a></li>
	<li><a  class="xia">下一页</a></li>
	<li><a  class="xia">&raquo;</a></li>
</ul>
	 </td>
	 
	    </tr>
    </table>
  </div>
  </div>
  </body>
</html>
<script type="text/javascript">
	$(".shang").click(function(){
		var currPage=${stuff}.currPage-1;
		var url='findByPages.action?pageEntity.currPage='+currPage;
		//跳转url
		window.location.href=url;
	});
	$(".one").click(function(){
		var currPage=1;
		var url='findByPages.action?pageEntity.currPage='+currPage;
		window.location.href=url;
	});
	$(".two").click(function(){
		var currPage=2;
		var url='findByPages.action?pageEntity.currPage='+currPage;
		window.location.href=url;
	});
	$(".xia").click(function(){
		var currPage=${stuff}.currPage+1;
		var url='findByPages.action?pageEntity.currPage='+currPage;
		window.location.href=url;
	});

			$("#btnQuery").click(function(){
         var key=$("#keystuffname").val();//获取要查询的参数的 值
		var postData={"pager.curPage":curPage};//默认情况下只传递当前页码值
		alert(ccsds);
		if($.stuff(key).length>0){//如果查询的关键字不为空
			postData["stuff.stuffname"]=key;//给对象属性赋值
		}  
	
			time();
		men();
	});

	
	$(function(){ 
		time();
		men();
	});
	
	function time(){
          var td=""
          for(var i=0;i<Object.keys(${time}).length;i++){
          	td+="<td style='width:150px;'>";
          	td+=${time}[i].datet;
          	td+="</td>";
          }
          $("#timtr").append(td);
     } 
     function men(){
          var tr=""
          for(var i=0;i<Object.keys(${stuff}.list).length;i++){
          	tr+="<tr style='height:60px;'>";
          	tr+="<td style='width:100px;'>";
          	
          	tr+="<img src='"+${stuff}.list[i].photo+"'' style='height:60px;width:60px'>"; 
          	tr+="</td>";
          	tr+="<td style='width:150px;'>";
          	tr+=${stuff}.list[i].stuffname;
          	tr+="</td>" ;
          	 
          for(var int=0;int<Object.keys(${time}).length;int++){
          
        var bt=true;
        var bd=true;
          	tr+="<td style='width:80px;'>";
       for(var int1=0;int1<Object.keys(${item}).length;int1++){
          	if(${time}[int].datet==${item}[int1].week&&${stuff}.list[i].stuffid2==${item}[int1].stuffid2){
          		if(bt){
          		
          		}
	          		tr+=	"<select  class='additem' >"
		          		for(var int2=0;int2<Object.keys(${type}).length;int2++){
			          		 if(${item}[int1].ptid==${type}[int2].ptid){
			          			tr+=	"<option value='"+${type}[int2].ptid+"'>"+${type}[int2].SName+"</option>"
			          		}else{
			          		} 
		          		}
		          		for(var int2=0;int2<Object.keys(${type}).length;int2++){
			          		 if(${item}[int1].ptid==${type}[int2].ptid){
			          		}else{
			          			tr+=	"<option value='"+${type}[int2].ptid+"'>"+${type}[int2].SName+"</option>"
			          		} 
		          		}
	          	 	tr+=	"</select><input class='icinput' value='"+${stuff}.list[i].stuffid2+"'>"
	          	 	tr+=	"<input class='icinput' value='"+${time}[int].datet+"'>"
	          	 	bd=false;
	        	
          	}
          	}
          for(var int1=0;int1<Object.keys(${item}).length;int1++){
          	if(${time}[int].datet!=${item}[int1].week&&${stuff}.list[i].stuffid2==${item}[int1].stuffid2){
          			
          			if(bt){
          				if(bd){
          					tr+=	"<select class='additem' >"
		          			 tr+=	"<option></option>"
		          		for(var int2=0;int2<Object.keys(${type}).length;int2++){
			          		 tr+=	"<option value='"+${type}[int2].ptid+"'>"+${type}[int2].SName+"</option>"
		          		}
	          	 		tr+=	"</select><input class='icinput' value='"+${stuff}.list[i].stuffid2+"'>"
	          	 		tr+=	"<input class='icinput' value='"+${time}[int].datet+"'>"
	          	 		bt=false;
          				};
	          			
          			}
          			
          	}
          	}
          	var b=true;
          		for(var int3=0;int3<Object.keys(${item}).length;int3++){
          				if(${stuff}.list[i].stuffid2==${item}[int3].stuffid2){
          					b=false;
          				}
	          	}
	          	if(b){
	          		tr+=	"<select>"
	          			 tr+=	"<option></option>"
	          		for(var int2=0;int2<Object.keys(${type}).length;int2++){
		          		 tr+=	"<option value='"+${type}[int2].ptid+"'>"+${type}[int2].SName+"</option>"
	          		}
          	 		tr+=	"</select><input class='icinput' value='"+${stuff}.list[i].stuffid2+"'>"
	          	 	tr+=	"<input class='icinput' value='"+${time}[int].datet+"'>"
	          	} 
          	tr+="</td>";
          }
          
          	tr+="</tr>";
          }
          $("#mytab").append(tr);
     } 
     $(document).on('change', '.additem', function(){
			/* alert($(this).val());//ptid
			alert($(this).next().val());//stuffid2
			alert($(this).next().next().val());//week */
			
			var ptid=$(this).val();
			var stuffid2=$(this).next().val();
			var week=$(this).next().next().val();
			alert(week+"操作成功!");
			  $.ajax({
		             url:"additem.action",
		             type:"post",
		             data:{"ptid":ptid,
		                      "stuffid2":stuffid2,
		                       "week":week},
           		});
           		
           		
		});
     
   
     
</script>


 