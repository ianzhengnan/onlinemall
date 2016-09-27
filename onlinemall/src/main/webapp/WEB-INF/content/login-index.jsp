<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
<s:property value="tip"/><br/>

<s:form method="post" action="%{#request.contextPath}/api/login" theme="simple">
	<label for="name">Name:</label>
	<s:textfield id="name" name="user.name"/><br/>
	<label for="password">Password:</label>
	<s:textfield id="password" name="user.password"/><br/>
	<s:submit value="登录" />
</s:form>
</body>
</html>