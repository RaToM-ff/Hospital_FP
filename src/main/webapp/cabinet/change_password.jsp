<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename='property'/>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title><fmt:message key='CHANGE_PASSWORD'/></title>
    <link rel="stylesheet" href="/Hospital_FP/usable/css/mainStyle.css">
</head>
<body>
<div class="main_div">
<div class="not_list_button">
<a href="/Hospital_FP/controller?command=backToCabinetCommand"><div class="href_but red_but"><fmt:message key='BACK_UPPER_F'/></div></a>
</div>
<h2><fmt:message key='CHANGE_PASSWORD'/></h2>
<div style="text-align: right;">
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=ru_RU">RU</a>
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=en_US">EN</a>
    </div>
<hr>
<div class="content_div">
<div class="text_block">
<form method="POST" action="/Hospital_FP/controller">
    <input type="hidden" name="command" value="changePasswordByUser">
    <p><b><fmt:message key='ENTER_OLD_PASSWORD'/>:</b></p>
    <input type="password" name="oldPassword"><div class="error_field">${errors.oldPassword}</div>
    <p><b><fmt:message key='ENTER_NEW_PASSWORD'/>:</b></p>
	<input type="password" name="newPassword1"><div class="error_field">${errors.newPassword1}</div>
    <p><b><fmt:message key='REPEAT_NEW_PASSWORD'/>:</b></p>
	<input type="password" name="newPassword2"><div class="error_field">${errors.newPassword2}</div>
    <br/>
	<input type="submit" class="functional_but blue_but" value="<fmt:message key='CHANGE'/>">
	<c:if test="${not empty errorMessage}">
    	<h3>${errorMessage}</h3>
    </c:if>
</form>
</div>
</div>
</div>
</body>
</html>
