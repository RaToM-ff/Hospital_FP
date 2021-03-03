<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename='property'/>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title><fmt:message key='SUCCESS'/></title>
    <link rel="stylesheet" href="usable/css/mainStyle.css">
</head>
<body>
<div class="main_div">
<h2><fmt:message key='SUCCESS'/></h2>
<hr>
<div class="content_div">
    <h3><fmt:message key='${message}'/>. ${newPass}</h3>
    <div class="not_list_button">
    	<a href="/Hospital_FP/controller?command=backToCabinetCommand"><div class="href_but green_but"><fmt:message key='TO_THE_CABINET'/></div></a>
	</div>
</div>
</div>
</body>
</html>
