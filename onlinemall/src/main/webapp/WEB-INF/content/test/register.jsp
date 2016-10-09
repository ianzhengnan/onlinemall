<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
</head>
<body>

<s:property value="tip"/><br/>

<s:form method="post" action="%{#request.contextPath}/api/signup" theme="simple">
	<label for="name">Name:</label>
	<s:textfield id="name" name="user.name"/><br/>
	<label for="password">Password:</label>
	<s:textfield id="password" name="user.password"/><br/>
	<label for="tel">Tel:</label>
	<s:textfield id="tel" name="user.tel"/><br/>
	<label for="email">Email:</label>
	<s:textfield id="email" name="user.email"/><br/>
	<s:submit value="注册" />
</s:form>
</body>
</html>