<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title>Add user</title>
    <link rel="stylesheet" href="/Hospital_FP/usable/css/mainStyle.css">
</head>
<body>
<div class="main_div">
<ol>
	<li>
		<a href="/Hospital_FP/controller?command=toWorksForAdmin"><div class="href_but red_but">Back</div></a>
	</li>
</ol>
<h2>Create new work</h2>
<hr>
<div class="content_div">
<h3>Enter data:</h3>
<p>Name of work:</p>
<form method="POST" action="/Hospital_FP/controller">
		<input type="hidden" name="command" value="createWorkForAdmin">
		<input type="text" name="nameWork" placeholder="Name"><div class="error_field">Error message!</div>
		<br>
	<input class="functional_but blue_but" type="submit" value="Create">
</form>
</div>
</div>
</body>
</html>
