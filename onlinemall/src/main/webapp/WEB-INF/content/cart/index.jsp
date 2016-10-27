<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
</head>
<body>

<table border="1">
    <th>商品名称</th>
    <th>商品数量</th>
    <th colspan="2">操作</th>

<s:iterator value="disItems">
    <tr>
        <td><s:property value="goods.name"/></td>
        <td><s:property value="quantity"/></td>
        <td><a href="/cartAction?id=<s:property value='goods.uuid'/>&method=add">增加</a></td>
        <td><a href="/cartAction?id=<s:property value='goods.uuid'/>&method=remove">减少</a></td>
    </tr>
</s:iterator>
</table>
<br/>
<a href="/api/goods">返回</a>
</body>
</html>