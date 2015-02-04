<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>康源PKS统计挖掘系统</title>
	<link rel="stylesheet" type="text/css" href="CSS/global.css">
	<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="js/jquery-extend.js"></script>
	<script type="text/javascript" src="js/highcharts.js"></script>
	<script type="text/javascript" src="js/exporting.js"></script>
	<script type="text/javascript" src="js/util.js"></script>
  </head>
  <body>
 	 <!--顶部导航-->
	<div class="Tray">
		<div class="tray">
			<a href="index.jsp" title="康源PKS统计挖掘系统" class="logo">康源PKS统计挖掘系统</a>
			<ul class="nav">
				<li>
					<a>统计分析</a>				</li>
				<li>
					<a>数据挖掘</a>				</li>
				<li>
					<a>报表导出</a>				</li>
			</ul>
			<ul class="nav nav2">
				<li>欢迎您！<a>username</a></li>
				<li>username@zju.edu.cn</li>   		
			</ul>			
		</div>		
	</div>
	<!--工具栏-->
	<div class="Toolbar Toolbar2">
		<div class="toolbar">
			<ul class="tools">
			  <!--暂不显示此项功能  
				<li class="tool">
					<button  id="argAverageBtn" title="参数均值" onclick="argAverage()">
						<i class="i i1"></i>
					</button>	
				</li>
				-->
				<li class="tool">
					<button  id="qualityAverageBtn" title="质量均值" onclick="qualityAverage()">
						<i class="i i1"></i>
					</button>	
				</li>			
			</ul>
			<ul class="tools2">
				<li class="tool toolB">
					<form>
							<button type="submit" title="搜索" class="searchBtn"></button>  
							<input type="text" class="txt" placeholder="输入搜索内容">
					</form>
				
				</li>
			</ul>					
		</div>
	</div> 
	<div id="Bdy">
		<div class="bdy">
			<div class="main">
				<!-- 参数均值分析模块：指定干膏范围，查看各参数的均值 -->
				<div id="argAverageDiv" class="noDis">
					<!-- 板块介绍部分 -->
					<div class="intro" >
						<dl>
							<dt csstxt="栀子萃取数据分析" class="file-gnm">
								<i class="i iB i2"></i>
							</dt>
							<dd>请选择干膏范围：
								<select id="minDryConcreteWeight" name="minDryConcreteWeight"></select>
								-
								<select id="maxDryConcreteWeight"name="maxDryConcreteWeight"></select>
							</dd>
							<dd>请选择含量范围：
								<select id="minContent" name="minContent"></select>
								-
								<select id="maxContent"name="maxContent"></select>
							</dd>
						</dl>
						<button type="button" onclick="contentAverageAnalysis()" class="orange-btn w200 mt-50 floatRight" >参数均值分析</button>
					</div>
					<!-- 图表展示 -->
					<div id="containerAverage1" class="container"></div>
					<div id="containerAverage2" class="container"></div>
				</div>
				
				<!-- 质量均值分析模块 ：分析某一时间段的（干膏/含量/浸膏量）均值，表示离异点，以及形成这些离异点的原因-->
				<div id=qualityAverageDiv class="noDis">
					<div class="intro">
						<dl>
							<dt csstxt="（干膏/含量/浸膏量）均值分析" class="file-gnm">
								<i class="i iB i2"></i>
							</dt>
							<dd>请选择工段范围：
								<select id="minBatchNo" name="minBatchNo"></select>
								-
								<select id="maxBatchNo"name="maxBatchNo"></select>
							</dd>
							<dd><br/></dd>
						</dl>
						<button type="button" onclick="qualityAverageAnalysis()" class="orange-btn w200 mt-50 floatRight" >质量均值分析</button>
					</div>	
					<div id="containerQuality" class="container"></div>	
					<div id="containerAvgRelatedToDryconcreteweights" class="container"></div>
					<div id="containerAvgRelatedToContents" class="container"></div>
					<div id="containerSections" class="container"></div>		
					<div id="chartInfo" class="chartInfo">
									
						<c:forEach items="${returnData.sections}" var="item">
									<tr>
										<td>${item.key}:</td>
										<td>${item.value}</td>										
									</tr>
						</c:forEach>
					
					
					
					</div>
				</div>
			</div>
		</div>
	</div>
	<input type="hidden" value="<%=basePath%>" id=basePath>
	</body>
 	<!-- 参数均值分析模块相关js -->
  	<script language="JavaScript" type="text/javascript">
		//参数均值分析按钮点击后的初始化：显示干膏和含量的下拉列表。显示栀子萃取数据div.
	  	function argAverage(){
			var dryConcreteWeights=null;
			var contents=null;
			var basePath=$("#basePath").val();
	  		var url=basePath+"GardeniaExtration/getDryConcreteWeights.htm";
	  		dryConcreteWeights=getJSON(url);
	  		url=basePath+"GardeniaExtration/getContents.htm";
	  		contents=getJSON(url);
	  		var minDryConcreteWeightSelector=$("#minDryConcreteWeight");
	  		var maxDryConcreteWeightSelector=$("#maxDryConcreteWeight");
	  		bindDataToSelector(dryConcreteWeights,dryConcreteWeights,minDryConcreteWeightSelector);
	  		bindDataToSelector(dryConcreteWeights,dryConcreteWeights,maxDryConcreteWeightSelector);
	  		var minContentSelector=$("#minContent");
	  		var maxContentSelector=$("#maxContent");
	  		bindDataToSelector(contents,contents,minContentSelector);
	  		bindDataToSelector(contents,contents,maxContentSelector);
	  		$("#qualityAverageDiv").attr("class","noDis");
	  		$("#argAverageDiv").attr("class","dis");
	  	};
  </script>
	<script language="JavaScript" type="text/javascript">
		//指定干膏和含量范围的均值分析
		function contentAverageAnalysis(){
			var basePath=$("#basePath").val();
			var minDryConcreteWeight=$("#minDryConcreteWeight option:selected").val();
			var maxDryConcreteWeight=$("#maxDryConcreteWeight option:selected").val();
			var minContent=$("#minContent option:selected").val();
			var maxContent=$("#maxContent option:selected").val();
	  		var url=basePath+"GardeniaExtration/contentAverageAnalysis.json";
	  		var returnField1=new Array();
	  		var returnVal1=new Array();
	  		var returnField2=new Array();
	  		var returnVal2=new Array();
	  		//异步获取均值
	  		$.ajax({
				type : 'post',
				url:url,
				dataType:'json',
				data:{"minDryConcreteWeight":minDryConcreteWeight,"maxDryConcreteWeight":maxDryConcreteWeight,"minContent":minContent,"maxContent":maxContent},
				async:true,
				success : function(data) {
					if(null!=data && 0!=data.length){
						//绘图数据准备
						AveragePrepared(returnField1,returnField2,returnVal1,returnVal2,data);
						//绘制图表
						drawHighcharts2(containerAverage1,returnField1,returnVal1);
						drawHighcharts2(containerAverage2,returnField2,returnVal2);
					}
				},
				error : function(data) {
					alert("指定干膏和含量范围的均值分析失败，请联系管理员！");
				}
			},'json');
		};
  	</script>
  	<script language="JavaScript" type="text/javascript">
  	//栀子选定干膏与含量范围的均值分析绘图函数,待优化，勿参考
  	function drawHighcharts2(container,returnField,returnVal){
							var averageChart=new Highcharts.Chart({
								
								chart:{
									renderTo:container,
									type:'column'
								},
								title:{
									text:'栀子选定干膏与含量范围的均值分析结果',
									style:{
										  color: '#64B9C9',
										  fontSize: '18px',
										  fontFamily:'微软雅黑'
										}
								},
								subtitle:{
									text:'Source:www.kanion.com'
								},
								credits:{
								     enabled:false // 禁用版权信息
								},
								xAxis:{
									categories:returnField
								},
								yAxis:{
									min:-2
								},
								series: [{
						            name: 'averages',
						            data: returnVal,
						            color:'#FF8633'
						        }]
							});
				return averageChart;
		};
		//绘图数据准备
		function AveragePrepared(returnField1,returnField2,returnVal1,returnVal2,data){
			returnField2.push("浓缩浸膏重量(千克)");
			returnField1.push("原始pH值");
			returnField2.push("加入1:1盐酸量(毫升)");
			returnField1.push("调酸后pH值");
			returnField1.push("热处理时间(h)");
			returnField2.push("浸膏重量(千克)");
			returnField1.push("萃取环境温度(℃)");
			returnField2.push("回收正丁醇使用量(千克)");
			returnField1.push("回收过程最高温度(℃)");
			returnField1.push("回收过程最低真空度(十千帕）");
			returnField1.push("刮板浓缩过程最高温度(℃)");
			returnField1.push("刮板浓缩过程最低真空度(十千帕)");
			returnField1.push("刮板总时间(h)");
			returnField2.push("湿膏");
			returnField1.push("干燥最高温度(℃)");
			returnField1.push("干燥时间(h)");
			
			returnVal2.push(data.concentrationExtractionWeight);
			returnVal1.push(data.originalPH);
			returnVal2.push(data.HCLVolume);
			returnVal1.push(data.PHWithHCL);
			returnVal1.push(data.heatTreatmentTime);
			returnVal2.push(data.extractionWeight);
			returnVal1.push(data.extractionTempreture);
			returnVal2.push(data.cyclingButanol);
			returnVal1.push(data.cyclingMaxTempreture);
			returnVal1.push(data.cyclingMinKPA*100);
			returnVal1.push(data.scraperEnrichmentMaxTempreture);
			returnVal1.push(data.scraperEnrichmentMinKPA*100);
			returnVal1.push(data.scraperTotleTime);
			returnVal2.push(data.wetConcreteWeight);
			returnVal1.push(data.dryMaxTempreture);
			returnVal1.push(data.dryTime);
		}
		
	</script>
	<!-- 质量均值分析相关js模块 -->
	<script language="JavaScript" type="text/javascript">
		//质量均值分析按钮点击后的初始化：显示批次范围列表。
		function qualityAverage(){
			var basePath=$("#basePath").val();
			var url=basePath+"GardeniaExtration/getBatchNos.htm";
			var batchNos=getJSON(url);
			var minBatchNoSelector=$("#minBatchNo");
			var maxBatchNoSelector=$("#maxBatchNo");
			bindDataToSelector(batchNos,batchNos,minBatchNoSelector);
			bindDataToSelector(batchNos,batchNos,maxBatchNoSelector);
			$("#argAverageDiv").attr("class","noDis");
			$("#qualityAverageDiv").attr("class","dis");
		};
		var returnData;
		function qualityAverageAnalysis(){
			var basePath=$("#basePath").val();
			var minBatchNo=$("#minBatchNo option:selected").val();
			var maxBatchNo=$("#maxBatchNo option:selected").val();
	  		var url=basePath+"GardeniaExtration/qualityAverageAnalysis.json";
	  		var data={};
	  		data["minBatchNo"]=minBatchNo;
	  		data["maxBatchNo"]=maxBatchNo;
	  		returnData=getJSON(url,data);
	  		drawHighcharts($('#containerQuality'),returnData.avgChart);	
	  		drawHighcharts($('#containerAvgRelatedToDryconcreteweights'),returnData.avgRelatedToDryconcreteweightsChart);
	  		drawHighcharts($('#containerAvgRelatedToContents'),returnData.avgRelatedToContentsChart);
	  		drawHighcharts($('#containerSections'),returnData.normalChart);
	  		
	
		};
	</script>
</html>
