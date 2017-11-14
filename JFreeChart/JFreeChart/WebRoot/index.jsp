<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>JFreeChart 示例</title>

	<style type="text/css">
		h3{margin-top: 50px;}
		.main_div{margin-left:auto;margin-right: auto;width: 400px;height: 100px;margin-top: 20px;}
		.main_div ul{list-style: none;}
		.main_div li{float: left;}
		button{background-color:yellow;width: 90px;height:30px;}
	</style>
	
	<script type="text/javascript">
		function chart(type){
			window.location.href = "<%=basePath%>chart?type=" + type;
		}
	</script>
  </head>
  
  <body>
  	<h3 align="center">JFreeChart 示例</h3>
  	<div class="main_div">
  		<ul>
  			<li><button onclick="chart('barchart');">柱状图</button></li>
  			<li><button onclick="chart('stackedbarchart')">堆栈柱状图</button></li>
  			<li><button onclick="chart('piechart');">饼图</button></li>
  			<li><button onclick="chart('linechart');">折线图</button></li>
  		</ul>
  	</div>
  	<div style="margin-left: auto;margin-right: auto;width: 800px;height: 400px;">
  		<%if(request.getAttribute("imgurl") != null){ %>
  		<img alt='' src='<%=request.getAttribute("imgurl") %>'>
  		<%} %>
  	</div>
  </body>
</html>
