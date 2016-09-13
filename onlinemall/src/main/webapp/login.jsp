<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
</head>
<body>
<h2>请输入用户名和密码：</h2>
<s:if test="tip!=null">
<div class="error">
	<s:property value="tip"/> 
</div>
</s:if>

<div style="text-align:center">
	<s:form action="loginAction">
		<s:textfield name="user.name" label="用户名"/>
		<s:textfield name="user.password" type="password" label="密码"/>
		<tr><td colspan="2">
		<s:submit value="登录" theme="simple"/>
		<s:reset value="重填" theme="simple"/>
		</td></tr>
	</s:form>
</div>
</body>
</html>