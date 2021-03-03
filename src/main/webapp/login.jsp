<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename='property'/>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title><fmt:message key='SING_IN'/></title>
    <link rel="stylesheet" href="usable/css/mainStyle.css">
</head>
<body>
<div class="main_div">
    <h2><fmt:message key='WELCOME_MESSAGE'/></h2>
    <div style="text-align: right;">
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=ru_RU&fromPage=login">RU</a>
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=en_US&fromPage=login">EN</a>
    </div>
    <hr>
<div class="content_div">
<h3><fmt:message key='SING_IN_PLEASE'/></h3>
<div class="text_block">
<form method="POST" action="/Hospital_FP/controller">
    <input type="hidden" name="command" value="login">
    <p><b><fmt:message key='LOGIN_UPPER_F'/>:</b></p>
	<input type="text" name="login" value="${oldLogin}">
<c:if test="${not empty errors.login}">
    <div class="error_field"><fmt:message key='${errors.login}'/></div>
</c:if>
	<p><b><fmt:message key='PASSWORD_UPPER_F'/>:</b></p>
	<input type="password" name="password">
<c:if test="${not empty errors.password}">
    <div class="error_field"><fmt:message key='${errors.password}'/></div>
</c:if>
    <br>
    <input class="functional_but blue_but" type="submit" value="<fmt:message key='SING_IN'/>">
    <p>
<c:if test="${not empty errorMessage}">
    <div class="error_field"><fmt:message key='${errorMessage}'/></div>
</c:if>
    </p>
</form>
</div>
</div>
</div>
</body>
</html>
