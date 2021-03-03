<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename='property'/>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title><fmt:message key='ADD_WORK_UPPER_F'/></title>
    <link rel="stylesheet" href="/Hospital_FP/usable/css/mainStyle.css">
</head>
<body>
<div class="main_div">
<ol>
	<li>
		<a href="/Hospital_FP/controller?command=toWorksForAdmin"><div class="href_but red_but"><fmt:message key='BACK_UPPER_F'/></div></a>
	</li>
</ol>
<h2><fmt:message key='CREATE_NEW_WORK'/></h2>
<div style="text-align: right;">
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=ru_RU">RU</a>
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=en_US">EN</a>
    </div>
<hr>
<div class="content_div">
<h3><fmt:message key='ENTER_DATA_UPPER_F'/>:</h3>
<p><fmt:message key='NAME_OF_WORK'/>:</p>
<form method="POST" action="/Hospital_FP/controller">
		<input type="hidden" name="command" value="createWorkForAdmin">
		<input type="text" name="nameWork"s>
<c:if test="${not empty errors.work_name}">
		<div class="error_field"><fmt:message key='${errors.work_name}'/></div>
</c:if>
		<br>
	<input class="functional_but blue_but" type="submit" value="<fmt:message key='CREATE_BUTTON'/>">
</form>
</div>
</div>
</body>
</html>
