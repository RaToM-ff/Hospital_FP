<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename='property'/>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title><fmt:message key='CHANGE_LOGIN'/></title>
    <link rel="stylesheet" href="/Hospital_FP/usable/css/mainStyle.css">
</head>
<body>
<div class="main_div">
<div class="not_list_button">
<a href="/Hospital_FP/controller?command=backToCabinetCommand"><div class="href_but red_but"><fmt:message key='BACK_UPPER_F'/></div></a>
</div>
<h2><fmt:message key='CHANGE_LOGIN'/></h2>
<div style="text-align: right;">
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=ru_RU">RU</a>
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=en_US">EN</a>
    </div>
<hr>
<div class="content_div">
<div class="text_block">
<h3><fmt:message key='ENTER_NEW_LOGIN'/>:</h3>
<form method="POST" action="/Hospital_FP/controller">
    <input type="hidden" name="command" value="changeLogin">
    <input type="login" name="login" value="${login}"><div class="error_field">${errors.login}</div>
    <br>
	<input type="submit" class="functional_but blue_but" value="<fmt:message key='CHANGE'/>">
</form>
</div>
</div>
</div>
</body>
</html>
