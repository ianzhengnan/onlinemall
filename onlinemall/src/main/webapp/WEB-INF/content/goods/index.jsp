<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>全部商品</title>

<script>
	function goToCatalog(catalog) {
		var cat = encodeURI(catalog);
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("GET", "goods/"+cat, true);
		xmlHttp.send();
	}
	
	function onFistPagePressed(){
		window.location = "?page=0";
	}
	
	function onPreviousPressed(page){
		var pg = parseInt(page) - 1;
		if (pg < 0) {
			pg = 0;
		}
		window.location = "?page="+pg;
	}
	
	function onNextPressed(page){
		var pg = parseInt(page) + 1;
		if (pg > ${totalPage} - 1) {
			pg = ${totalPage} - 1;
		}
		window.location = "?page="+pg;
	}
	
	function onLastPagePressed(){
		
		var pg = ${totalPage} - 1;
		window.location = "?page="+pg;
	}

</script>

</head>
<body>
<table border="1">
<tr>
<th>商品编号</th>
<th>商品名称</th>
<th>商品类别</th>
<th>商品品牌</th>
<th>商品单价</th>
<th>商品库存</th>
<th>商品单位</th>
</tr>
	<s:iterator value="items">
		<tr>
			<td><s:property value="number"/></td>
			<td><s:property value="name"/></td>
			<td><a href="goods/<s:property value="category"/>"><s:property value="category"/></a></td>
			<td><s:property value="brand"/></td>
			<td><s:property value="price"/></td>
			<td><s:property value="stock"/></td>
			<td><s:property value="unit"/></td>
		</tr>
	</s:iterator>
	<tr>
		<td><button onclick="onFistPagePressed()">首页</button></td>
		<td><button onclick="onPreviousPressed('${page}')">上一页</button></td>
		<td><button onclick="onNextPressed('${page}')">下一页</button></td>
		<td><button onclick="onLastPagePressed()">最后</button></td>
	</tr>
</table>

<%-- <s:form method="get" action="../cartAction">
	<s:hidden name="goods" value="xxxx"/>
	<s:submit value="test" />
</s:form> --%>

<a href="../cartAction?id=${items[0].uuid}&method=add">test</a>
<br/>
<a href="${pageContext.request.contextPath}/api/logout">登出</a>

</body>
</html>