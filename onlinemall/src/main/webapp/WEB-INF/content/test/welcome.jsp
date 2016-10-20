<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>插入成功</title>
<script>
    function redirectToGoods(){
        window.location = "goods";
    }
</script>

</head>
<body onload="redirectToGoods()">
<%--<s:property value="tip"/><br/>
<s:property value="user.name"/>--%>
<br/>
<!--<a href="${pageContext.request.contextPath}/api/logout">登出</a>-->
</body>
</html>