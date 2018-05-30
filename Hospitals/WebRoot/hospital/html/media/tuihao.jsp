<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>查询结果</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css">
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap-theme.min.css">
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css">
   <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
  
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../../js/check.js"></script>
<script language="javascript" src="../../js/checkAll.js"></script>
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
<script type="text/javascript">
  function findKey(){
       $.ajax({
          url:"${pageContext.request.contextPath}/ps_findByKey.action",
          data:{"patients.patientname":$("#uname").val()},
          dataType:"text",
          type:"post",
          success:function(data){
            var result=data;
            //将字符串分割成数组。
            var srr=result.split(",");
            var str="";
            for(var i=0;i<srr.length;i++){
              str+="<div class='btn btn-primary' data-toggle='modal' data-target='#myModal' onclick='dianji(this)'>"+srr[i]+"</div>";
           }
           $("#result").html(str);
          }
       });
     };
     function dianji(obj){
      var name=obj.innerHTML;
          $("#uname").val(obj.innerHTML);
          findAll();
         $.ajax({
             url:"${pageContext.request.contextPath}/ps_findByName.action",
             data:{"patients.patientname":name},
             type:"post",
             dataType:"json",
             success:function(data){
                $("#bodyName").html("");
                  var obj=data;
                  var tr="<tr>";
          tr+="<td class='td07'>"+obj.serialNumber+"</td>";
          tr+="<td class='td07'>"+obj.patientname+"</td>";
          tr+="<td class='td07'>"+obj.sex+"</td>";
          tr+="<td class='td07' >"+obj.age+"</td>";
          tr+="<td class='td07'>"+obj.stuffname+"</td>";
          tr+="<td class='td07'>"+obj.typeName+"</td>";
          tr+="<td class='td07'>"+obj.officeName+"</td>";
          tr+="<td class='td07'>"+obj.presentTime+"</td>";
          tr+="<td class='td07'>"+obj.charge+"</td>";
          tr+="<td class='td07'>"+obj.charge+"</td>";
          tr+="<td class='td07'><input target='_blank'  type='button' value='退号' size='' title="+obj.sfId+"  name="+obj.registerId+" id="+obj.id+" class='delete btn btn-default' />"
          tr+="</tr>"; 
            $("#bodyName").append(tr);//追加行
               
             }
         }); 
     };
  $(document).ready(function(){
  $("#uname").focus(function(){
    $("#font").show();
  });
  $("#uname").blur(function(){
    $("#font").hide();
  });
  });
  $(function(){$("#font").hide();});
  
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="25" align="center" valign="bottom" class="td06"><table width="98%" border="0" cellspacing="3" cellpadding="0">
      <tr>
        <td width="15"><img src="../../images/index_32.gif" width="9" height="9"></td>
        <td valign="bottom" class="title">门诊退号</td>
      </tr>
    </table></td>
  </tr>
</table>
<br>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td class="td_page">
    <form action="">
    <input type="submit" class="td07" value="姓名查询:" >
        
     <input type="text" id="uname" onkeyup="findKey()" /><span><i id="font" class="fa fa-spinner fa-pulse fa-2x"></i></span><br/>
       <div id="result"></div>
      </form>       
     </td>
  </tr>
</table>
<br>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01">
                <thead>
                     <tr>
                         <th class="td_top">门诊编号</th>
                         <th class="td_top">姓名</th>
                         <th class="td_top">性别</th>
                         <th class="td_top">年龄</th>
                         <th class="td_top">主治医生</th>
                         <th class="td_top">挂号类型</th>
                         <th class="td_top">挂号科室</th>
                         <th class="td_top">挂号时间</th>
                         <th class="td_top">实收:挂号/诊疗费</th>
                         <th class="td_top">应退费</th>
                         <th class="td_top">退号</th>
                     </tr>
                   </thead>
                 <tbody  id="tbody">
                      
                 </tbody>
  
</table>
<ul class="pager" >
 	<li>
 	当前页:<span id="curPage"></span>总页数:<span id="totalPages"></span>
 	</li>
 	<li><a  id="first" onclick="changePage(this)">首页</a></li>
 	<li><a  id="prev" onclick="changePage(this)">上一页</a></li>
 	<li><a  id="next" onclick="changePage(this)">下一页</a></li>
 	<li><a  id="last"  onclick="changePage(this)">尾页</a></li>
 	<li><input type="number"  id="txtCurPage"   min="1" max="10"></input><input type="button" class="btn btn-default" value="go" onclick="gotoPage()"/></li>
  </ul>
  
  <!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg "><!--modal-sm  -->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					患者挂号信息
				</h4>
			</div>
			<div id="_modalDialog_body" class="modal-body">
			 <!--     设置这个div的大小，超出部分显示滚动条  
        <div id="selectTree" class="ztree" style="height:300px;overflow:auto; ">   
        </div>   -->
				<table class="table" >
                  <thead>
                     <tr>
                         <th class="td_top">门诊编号</th>
                         <th class="td_top">姓名</th>
                         <th class="td_top">性别</th>
                         <th class="td_top">年龄</th>
                         <th class="td_top">主治医生</th>
                         <th class="td_top">挂号类型</th>
                         <th class="td_top">挂号科室</th>
                         <th class="td_top">挂号时间</th>
                         <th class="td_top">实收费</th>
                         <th class="td_top">应退费</th>
                         <th class="td_top">退号</th>
                     </tr>
                   </thead>
                 <tbody id="bodyName">
                      
                 </tbody>
                 </table>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
</body>
</html>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
   findAll(1);
});
function findAll(curPage){
  var url="${pageContext.request.contextPath}/ps_findAll.action";
  $.ajax({
      url:url,
      data:{"curPage":curPage},
      dataType:"json",
      type:"post",
      ansy:false,
      success:function(data){
        $("#tbody").html("");//清空内容数据
        var ary=data.list;
        for(var i=0;i<ary.length;i++){
          var obj=ary[i];//获取当前对象
          var tr="<tr>";
          tr+="<td class='td07'>"+obj.serialNumber+"</td>";
          tr+="<td class='td07'>"+obj.patientname+"</td>";
          tr+="<td class='td07'>"+obj.sex+"</td>";
          tr+="<td class='td07'>"+obj.age+"</td>";
          tr+="<td class='td07'>"+obj.stuffname+"</td>";
          tr+="<td class='td07'>"+obj.typeName+"</td>";
          tr+="<td class='td07'>"+obj.officeName+"</td>";
          tr+="<td class='td07'>"+transferTime(obj.presentTime)+"</td>";
          tr+="<td class='td07'>"+obj.charge+"</td>";
          tr+="<td class='td07'>"+obj.charge+"</td>";
          tr+="<td class='td07'><input target='_blank'  type='button' value='退号' size='' title="+obj.sfId+"  name="+obj.registerId+" id="+obj.id+" class='delete btn btn-default' />"
          tr+="</tr>"; 
          $("#tbody").append(tr);//追加行
        }
        //重新初始化分页链接
        $("#curPage").html(data.curPage);
		$("#totalPages").html(data.totalPages);
        $("#first").attr("data",data.first);
		$("#prev").attr("data",data.prev);
		$("#next").attr("data",data.next);
		$("#last").attr("data",data.last);
		$("#txtCurPage").val(data.curPage).attr("max",data.last);
      }
  });
}
//改变页面
function changePage(obj){
    var page=$(obj).attr("data");//取出data属性值
    findAll(page);
}
//跳转到指定页面
	function gotoPage(page){
		var page=$("#txtCurPage").val();
		findAll(page);
	}
$("#tbody").on("click",".delete",function(){
      var registerId=this.name;
      var patientsId=this.id;
      var sfId=this.title;
      alert(sfId);
     $.ajax({
        url:"${pageContext.request.contextPath}/ps_delete.action",
        data:{"clinicregister.registerId":registerId,
             "patients.id":patientsId,
               "charge.sfId":sfId
             },
        type:"post",
        dataType:"json",
        success:function(data){
           if(data.state>0){
             alert(data.message);
              findAll(data.curPage);
           }
        }
     });
  });
  $("#bodyName").on("click",".delete",function(){
     var patientsId=this.id;
     $.ajax({
        url:"${pageContext.request.contextPath}/ps_delete.action",
        data:{"patients.id":patientsId},
        type:"post",
        dataType:"json",
        success:function(data){
           if(data.state>0){
             alert(data.message);
              findAll(data.curPage);
           }
        }
     });
  });
  
  //改变时间
       function transferTime(presentTime) {
       //将json串的一串数字进行解析
       var jsonDate = new Date(parseInt(presentTime));
       
       //为Date对象添加一个新属性，主要是将解析到的时间数据转换为我们熟悉的“yyyy-MM-dd hh:mm:ss”样式
       Date.prototype.format = function(format) {
       var o = {

       //获得解析出来数据的相应信息，可参考js官方文档里面Date对象所具备的方法

       "y+" : this.getFullYear(),//得到对应的年信息
       "M+" : this.getMonth() + 1, //得到对应的月信息，得到的数字范围是0~11，所以要加一
       "d+" : this.getDate(), //得到对应的日信息
       "h+" : this.getHours(), //得到对应的小时信息 
       "m+" : this.getMinutes(), //得到对应的分钟信息
       "s+" : this.getSeconds(), //得到对应的秒信息
 
   }

     //将年转换为完整的年形式
    if (/(y+)/.test(format)) {
   format = format.replace(RegExp.$1,
   (this.getFullYear() + "")
  .substr(4 - RegExp.$1.length));
   }

   //连接得到的年月日 时分秒信息
   for ( var k in o) {
  if (new RegExp("(" + k + ")").test(format)) {
  format = format.replace(RegExp.$1,
  RegExp.$1.length == 1 ? o[k] : ("00" + o[k])
 .substr(("" + o[k]).length));
  }
 }
 return format;
 }
var newDate = jsonDate.format("yyyy-MM-dd hh:mm:ss");
return newDate;
}   
</script>	
