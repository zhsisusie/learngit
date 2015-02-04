//绑定数据到下拉列表
function bindDataToSelector(name, data, selector) {
	for ( var i = 0; i < data.length; i++) {
		selector.append('<option value="' + name[i] + '">' + data[i] + '</option>');
	}
};
//使用json获取数据，非异步方式，不传递参数
function getJSON(url) {
	var returnData = null;
	$.ajax({
		type : 'post',
		url : url,
		dataType : 'json',
		async : false,
		success : function(data) {
			returnData = data;
		},
		error : function(data) {
			returnData="JSON数据获取失败！";
		}
	}, 'json');
	return returnData;
};
//以post形式传递数据的json数据获取函数，非异步
function getJSON(url,data){
	var returnData=null;
	$.ajax({
		type : 'post',
		url:url,
		dataType:'json',
		data:data,
		async:false,
		success : function(data) {
			returnData=data;
		},
		error : function(data) {
			alert("JSON数据获取失败，请联系管理员！");
		}
	},'json');
	return returnData;
};


//绘图
function drawHighcharts(container,data){
	container.highcharts({
		chart:data.chart,
		title:data.title,
		subtitle:data.subtitle,
		credits:{
		     enabled:false // 禁用版权信息
		},
		xAxis:data.xAxis,
		yAxis:data.yAxis,
		tooltip:data.tooltip,
		legend:data.legend,
		series:data.series		
	});
};