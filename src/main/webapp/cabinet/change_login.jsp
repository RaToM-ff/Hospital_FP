<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title>Change login</title>
    <link rel="stylesheet" href="/Hospital_FP/usable/css/mainStyle.css">
</head>
<body>
<div class="main_div">
<div class="not_list_button">
<a href="/Hospital_FP/controller?command=backToCabinetCommand"><div class="href_but red_but">Back</div></a>
</div>
<h2>Change login</h2>
<hr>
<div class="content_div">
<div class="text_block">
<h3>Enter new login:</h3>
<form method="POST" action="/Hospital_FP/controller">
    <input type="hidden" name="command" value="changeLogin">
    <input type="login" name="login" placeholder="Enter new login">
    <br>
	<input type="submit" class="functional_but blue_but" value="Change">
</form>
</div>
</div>
</div>
</body>
</html>
