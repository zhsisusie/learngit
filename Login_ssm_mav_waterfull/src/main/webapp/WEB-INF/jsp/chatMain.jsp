<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>聊天室</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/chatMain.js"></script>
</head>
<body>
	<div id="divMain">
		<div class="divTop">
			<div class="divL">
				<h3>大家的聊天室</h3>
				<div class="divShow" id="divContent"></div>
			</div>
			<div class="divR">
				<h3>当前在线人员</h3>
				<div class="divShow" id="divOnLine"></div>
			</div>
		</div>
		<div class="divBot">
			<table cellpadding="0" cellspacing="0">
				<tr>
					<td colspan="2" id="divFace" class="pb"></td>
				</tr>
				<tr>
					<td><textarea rows="3" cols="64" id="txtContent"></textarea></td>
					<td class="pl"><input type="button" id="btnSend" value="发送"
						class="btn"> </input></td>
				</tr>
				<tr>
					<td colspan="2" class="pt">发送内容不能为空</td>
					<!-- colspan规定单元格可以横跨的列数 -->
				</tr>
			</table>
		</div>
		<span id="divMsg" class="clsTip">正在发送数据。。。</span>
		<!-- span标签被用来组合文档中的行内元素。 -->
	</div>
</body>
</html>