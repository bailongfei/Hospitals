<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>门诊报表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
     <script src="${pageContext.request.contextPath}/js/ichart.1.2.min.js"></script>
    <style type="text/css">
       body {background-color:#eeeeee;}
        .demo{background:white;margin:0 5px;width:250px;height:160px;}
        div h4{color:blue;}
        div h5{color:black;}
        .demo:hover{border:1px black solid;}  
        .demo:hover{width:250px;height:160px;border:none;}  
      .demo:hover{box-shadow: 1px 1px 8px 8px #888888;}
     
    </style>
  </head>
  
  <body>
     <div class="container">
	<div class="row clearfix">
		
		<div   id="chas" class="demo col-md-4 column">
			<center>
			<h4  class="text-center ">
				挂号日报
			</h4>
			<hr>
			<h5 class="text-center ">
			        每日操作员挂号收入报表
			</h5>
			</center>
		</div>
		<div  id="gua2" class="demo col-md-4 column">
			<center>
			<h4 class="text-center ">
				科室报表
			</h4>
			<hr>
			<h5 class="text-center ">
			        科室挂号收入
			</h5>
			</center>
		</div>
		<div   id="gua3" class="demo col-md-4 column" >
		   <center>
			<h4 class="text-center ">
				操作员挂号报表
			</h4>
			<hr>
			<h5 class="text-center ">
			       所有操作员汇总报表
			</h5>
			</center>
		</div>
		
	</div>
</div>


<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal0" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content" style=" width:600px;height:950px; ">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					报表窗口
				</h4>
			</div>
			<div class="modal-body">
			    
			    <form action="">
			    
			         <div style=" margin-bottom:0px; " class="form-group">
		                  <label for="sex" class="col-sm-1 control-label" >日期:</label>
		                 <div class="col-sm-3">
			             <input type="date" class="dates form-control" id="riqi" name="">
		                 </div>
		                 <label for="sex" class="col-sm-1 control-label" >至:</label>
		                 <div class="col-sm-3">
			             <input type="date" class="dates form-control" id="zhi" name="">
		                 </div>
		                 <div id="buttons">
			             <input type="button" id="" class="btn btn-default" value="检索">
		                 </div>
		                
		           </div>
		      </form>
		    <hr>
		    <table class="table table-bordered">
		      <center ><h3 class="guahaos">挂号报表</h3></center>
		       <caption><h5>日期范围:<input readonly="readonly" style=" border:none; " type="text" id="rq"></h5><h5>操作员:${adminUsers}</h5></caption>
		       
		       <thead id="thead">
		         <!-- <th class="success">挂号项目</th>
		         <th class="success">金额</th> -->
		       </thead>
		      <tbody id="tbody">
		         
		      </tbody>
		    </table>
		        <!--图形组建  -->
				  <div id='ichart-render'></div>
				  
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary">
					打印
				</button> 
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>


  </body>
</html>
<script type="text/javascript">

//切换调用一个模态窗
   $(function() {
        $(document).on("click", ".demo", function () {
            var id=this.id;
            $('#myModal0 .modal-header .modal-title').empty().text($(this).children().find("h4").text());
            $('#myModal0 .modal-body .guahaos').empty().text($(this).children().find("h4").text());
            
            
           // $('#myModal0 .modal-body #button input').attr("id"," ");
            $('#myModal0 .modal-body #buttons input').attr("id",id);//动态给id赋值
            $("#myModal0 #thead").empty();
            $('#myModal0 #tbody').empty();
            $('#myModal0 #ichart-render').empty();
            $('#myModal0').modal();
            
        });
    }); 
    //进入时查询当天$(document)//$('#chgs').trigger("click");
  $("#buttons").on("click","#chas",function(){
     var day1=$("#riqi").val();
     var day2=$("#zhi").val();
     var day=day1+"至"+day2;
     $("#rq").val(day);
     $.ajax({
         url:"${pageContext.request.contextPath}/admin_selectChange.action",
         data:{
            "day1":day1,
            "day2":day2
         },
         type:"post",
         dataType:"json",
         success:function(data){
           $("#thead").empty();
            var th="<tr class='success'><th >挂号项目</th>";
                th+="<th >金额</th></tr>";
                $("#thead").append(th);
            $("#tbody").empty();
            var sum=0;
            var sumId=0;
            for(var j=0;j<data.length;j++){
            	var data1=data[j];
            	for(var i=0;i<data1.length;i++){
            		var p=data1[i];
            		var tr="<tr>";
                    tr+="<td >"+p.typeName+"</td>";
                    tr+="<td  class='chg'>"+p.charges+"</td>";
                    tr+="</tr>";
                    $("#tbody").append(tr);
                    
            	}
            	    sumId+=data1[0].sumId;
                     sum+=data1[0].charges;
            }   
             // alert(sum);
                //  alert(sumId);
               
                var tt="<tr>";
                    tt+="<td><h4>合计:</h4></td>";
                    tt+="<td ><h4>"+sum+"</h4></td>";
                    tt+="</tr>";
                    tt+="<tr >";
                    tt+="<td colspan='2'><h5>挂号人数:"+sumId+"</h5></td>";
                    
                    tt+="</tr>";
                $("#tbody").append(tt);
                
                //饼状图报表   
     var chart = iChart.create({
            render:"ichart-render",
            width:565,
            height:300,
            background_color:"#fefefe",
            gradient:false,
            color_factor:0.2,
            border:{
                  color:"BCBCBC",
                  width:1
            },
            align:"center",
            offsetx:0,
            offsety:0,
            sub_option:{
                  border:{
                        color:"#BCBCBC",
                        width:1
                  },
                  label:{
                        fontweight:500,
                        fontsize:11,
                        color:"#4572a7",
                        sign:"square",
                        sign_size:12,
                        border:{
                              color:"#BCBCBC",
                              width:1
                        },
                        background_color:"#fefefe"
                  }
            },
            shadow:true,
            shadow_color:"#666666",
            shadow_blur:2,
            showpercent:false,
            column_width:"70%",
            bar_height:"70%",
            radius:"90%",
            title:{
                  text:"挂号图表",
                  color:"#111111",
                  fontsize:20,
                  textAlign:"center",
                  font:"微软雅黑",
                  height:30,
                  offsetx:0,
                  offsety:0
            },
            subtitle:{
                  text:"报表",
                  color:"#111111",
                  fontsize:16,
                  textAlign:"center",
                  font:"微软雅黑",
                  height:20,
                  offsetx:0,
                  offsety:0
            },
            footnote:{
                  text:"报表图",
                  fontsize:12,
                  color:"#111111",
                  textAlign:"right",
                  font:"微软雅黑",
                  height:20,
                  offsetx:0,
                  offsety:0
            },
            legend:{
                  enable:false,
                  background_color:"#fefefe",
                  color:"#333333",
                  fontsize:12,
                  border:{
                        color:"#BCBCBC",
                        width:1
                  },
                  column:1,
                  align:"right",
                  valign:"center",
                  offsetx:0,
                  offsety:0
            },
            coordinate:{
                  width:"80%",
                  height:"84%",
                  background_color:"#ffffff",
                  axis:{
                        color:"#a5acb8",
                        width:[1,"",1,""]
                  },
                  grid_color:"#d9d9d9",
                  label:{
                        fontweight:500,
                        color:"#666666",
                        fontsize:11
                  }
            },
            label:{
                  fontweight:500,
                  color:"#666666",
                  fontsize:11
            },
            type:"pie2d",
            data:[
                  {
                  name:$("#tbody tr td:eq(0)").html(),
                  value:$("#tbody tr td:eq(1)").html(),
                  color:"#4572a7"
            },{
                  name:$("#tbody tr td:eq(2)").html(),
                  value:$("#tbody tr td:eq(3)").html(),
                  color:"#ad4561"
            },{
                  name:$("#tbody tr td:eq(4)").html(),
                  value:$("#tbody tr td:eq(5)").html(),
                  color:"#89a54e"
            }
            ]
      });
      ////调用绘图方法开始绘图
      
      chart.draw();
     
 
                
         }
         
     });
      	
  }); 
   
   $("#buttons").on("click","#gua2",function(){
        
        var day1=$("#riqi").val();
     var day2=$("#zhi").val();
     var day=day1+"至"+day2;
     $("#rq").val(day);
     $.ajax({
         url:"${pageContext.request.contextPath}/admin_selectKeshi.action",
         data:{
            "day1":day1,
            "day2":day2
         },
         type:"post",
         dataType:"json",
         success:function(data){
            $("#thead").empty();
            var th="<tr class='success'><th >挂号科室</th>";
                th+="<th >科室医生</th>";
                th+="<th >费用</th></tr>";
                $("#thead").append(th);
            $("#tbody").empty();
            var sum=0;
            //var sumId=0;
            for(var j=0;j<data.length;j++){
            	var data1=data[j];
            	for(var i=0;i<data1.length;i++){
            		var p=data1[i];
            		var tr="<tr>";
                    tr+="<td>"+p.typeName+"</td>";
                    tr+="<td>"+p.stuffname+"</td>";
                    tr+="<td class='chg'>"+p.charges+"</td>";
                    tr+="</tr>";
                    $("#tbody").append(tr);
                   
            	}
            	    //sumId+=data1[0].sumId;
                     sum+=data1[0].charges;
            }   
           	
                var tt="<tr>";
                    tt+="<td colspan='2'><h4>合计:</h4></td>";
                    tt+="<td ><h4>"+sum+"</h4></td>";
                    tt+="</tr>";
                    /* tt+="<tr >";
                    tt+="<td colspan='3'><h5>挂号人数:"+sumId+"</h5></td>";
                    tt+="</tr>"; */
                $("#tbody").append(tt);
              
          //数状报表图      
                var data = [
						{name :$("#tbody tr td:eq(0)").html(),value :$("#tbody tr td:eq(2)").html(),color : '#4572a7'},
						{name :$("#tbody tr td:eq(3)").html(),value :$("#tbody tr td:eq(5)").html(),color : '#aa4643'},
						{name :$("#tbody tr td:eq(6)").html(),value :$("#tbody tr td:eq(8)").html(),color : '#89a54e'}
						
					];
	
			var chart = new iChart.Column2D({
				render : 'ichart-render',
				data : data,
				title : {
					text : '科室报表',
					color : '#3e576f'
				},
				subtitle : {
					text : '报表',
					color : '#6d869f'
				},
				footnote : {
					text : '报表图',
					color : '#909090',
					fontsize : 11,
					padding : '0 38'
				},
				width : 575,
				height : 350,
				label : {
					fontsize:11,
					color : '#666666'
				},
				animation : true,//开启过渡动画
				animation_duration:900,//900ms完成动画
				shadow : true,
				shadow_blur : 2,
				shadow_color : '#aaaaaa',
				shadow_offsetx : 1,
				shadow_offsety : 0,
				column_width : 62,
				sub_option : {
					listeners : {
						parseText : function(r, t) {
							return t + "$";
						}
					},
					label : {
						fontsize:11,
						fontweight:600,
						color : '#4572a7'
					},
					border : {
						width : 2,
						color : '#ffffff'
					}
				},
				coordinate : {
					background_color : null,
					grid_color : '#c0c0c0',
					width : 500,
					axis : {
						color : '#c0d0e0',
						width : [0, 0, 1, 0]
					},
					scale : [{
						position : 'right',
						start_scale : 0,
						end_scale : 600,
						scale_space : 100,
						scale_enable : false,
						label : {
							fontsize:11,
							color : '#666666'
						}
					}]
				}
			});
			
			/**
			 *利用自定义组件构造左侧说明文本。
			 */
			chart.plugin(new iChart.Custom({
					drawFn:function(){
						/**
						 *计算位置
						 */	
						var coo = chart.getCoordinate(),
							x = coo.get('originx'),
							y = coo.get('originy'),
							H = coo.height;
						/**
						 *在左侧的位置，设置逆时针90度的旋转，渲染文字。
						 */
						chart.target.textAlign('center')
						.textBaseline('middle')
						.textFont('700 15px Verdana')
						.fillText('科室挂号收入',x-20,y+H/2,false,'#6d869f', false,false,false,-90);
						
					}
			}));
			
			chart.draw();
                
         }
     
     });
     
     
   });
   
    $("#buttons").on("click","#gua3",function(){
        alert("gua3");
     var day1=$("#riqi").val();
     var day2=$("#zhi").val();
     var day=day1+"至"+day2;
     $("#rq").val(day);
     $.ajax({
         url:"${pageContext.request.contextPath}/admin_selectCaozhuo.action",
         data:{
            "day1":day1,
            "day2":day2
         },
         type:"post",
         dataType:"json",
         success:function(data){
            $("#thead").empty();
            var th="<tr class='success'><th >操作员</th>";
                th+="<th >挂号费</th>";
                th+="<th >诊疗费</th>";
                th+="<th >合计:</th></tr>";
                $("#thead").append(th);
            $("#tbody").empty();
            var sum=0;
            var sumId=0;
            for(var j=0;j<data.length;j++){
            	var data1=data[j];
            	for(var i=0;i<data1.length;i++){
            		var p=data1[i];
            		var tr="<tr>";
                    tr+="<td>"+p.typeName+"</td>";
                    tr+="<td class='chg'>"+p.charges+"</td>";
                    tr+="</tr>";
                    $("#tbody").append(tr);
                   
            	}
            	    sumId+=data1[0].sumId;
                     sum+=data1[0].charges;
            }   
           	
                var tt="<tr>";
                    tt+="<td><h4>合计:</h4></td>";
                    tt+="<td ><h4>"+sum+"</h4></td>";
                    tt+="</tr>";
                    tt+="<tr >";
                    tt+="<td colspan='3'><h5>挂号人数:"+sumId+"</h5></td>";
                    tt+="</tr>";
                $("#tbody").append(tt);
         }
     
     });
     
     
   });
  
 //获取日期
   var now = new Date();
   var day = ("0" + now.getDate()).slice(-2);//格式化日，如果小于9，前面补0
   var month = ("0" + (now.getMonth() + 1)).slice(-2);
   var today = now.getFullYear()+"-"+(month)+"-"+(day) ;
   $("#riqi").val(today);
   $("#zhi").val(today);
 

 
 
</script>

