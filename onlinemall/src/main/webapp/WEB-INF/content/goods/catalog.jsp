<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>商品类别：${id} <s:property value="catalog"/></title>
</head>
<body>
<table border="1">
<tr>
<th>商品编号</th>
<th>商品名称</th>
<th>商品品牌</th>
<th>商品单价</th>
<th>商品库存</th>
<th>商品单位</th>
</tr>
	<s:iterator value="items">
		<tr>
			<td><s:property value="number"/></td>
			<td><s:property value="name"/></td>
			<td><s:property value="brand"/></td>
			<td><s:property value="price"/></td>
			<td><s:property value="stock"/></td>
			<td><s:property value="unit"/></td>
		</tr>
	</s:iterator>
</table>
</body>
</html>