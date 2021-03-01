<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title>PageName</title>
    <link rel="stylesheet" href="/Hospital_FP/usable/css/mainStyle.css">
</head>
<body>
<div class="main_div">
<div class="not_list_button">
<a href="/Hospital_FP/controller?command=backToCabinetCommand"><div class="href_but red_but">Back</div></a>
</div>
<h2>Change password</h2>
<hr>
<div class="content_div">
<div class="text_block">
<form method="POST" action="/Hospital_FP/controller">
    <input type="hidden" name="command" value="changePasswordByUser">
    <p><b>Enter old password:</b></p>
    <input type="password" name="oldPassword" placeholder="Enter old password">
    <p><b>Enter new password:</b></p>
	<input type="password" name="newPassword1" placeholder="Enter new password">
    <p><b>Repeat new password:</b></p>
	<input type="password" name="newPassword2" placeholder="Repeat password"><br/>
	<input type="submit" class="functional_but blue_but" value="Change">
	<c:if test="${not empty errorMessage}">
    	<h3>${errorMessage}</h3>
    </c:if>
</form>
</div>
</div>
</div>
</body>
</html>
