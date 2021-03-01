<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title>Change or delete card record</title>
    <link rel="stylesheet" href="usable/css/mainStyle.css">
</head>
<body>
<div class="main_div">
    <div class="not_list_button">
    <c:if test="${forBackButton==0}">
        <a href="/Hospital_FP/controller?command=toPatienceForDoctor">
    </c:if>
    <c:if test="${forBackButton==1}">
        <a href="/Hospital_FP/controller?command=toWaysPatiencesForDoctor">
    </c:if>
    <div class="href_but red_but">Back</div></a>
</div>
<h2>Create card record for <i>${patience.sername} ${patience.name} ${patience.patronymic}</i></h2>
<hr>
<div class="content_div">
<h3>Change data:</h3>
<div class="text_block">
<form method="POST" action="/Hospital_FP/controller">
		<input type="hidden" name="command" value="createCardRecordForDoctor">
        <input type="hidden" name="patienceId" value="${patience.id}">
        <input type="hidden" name="doctorId" value="${doctorId}">
	<p><b>Procedures:</b></p>
		<input type="text" name="procedures" placeholder="Procedures">
	<p><b>Medicines:</b></p>
		<input type="text" name="medicines" placeholder="Medicines">
    <c:if test="${statusId==4}">
        <p><b>Operations:</b></p>
        	<input type="text" name="operations" placeholder="Operations">
        <p><b>Diagnosis:</b></p>
        	<input type="text" name="diagnosis" placeholder="Diagnosis">
            <input type="hidden" name="forDoctor" value="true">
    </c:if>
    <c:if test="${statusId==3}">
            <input type="hidden" name="forDoctor">
    </c:if>
    <br>
        <input type="submit" class="functional_but blue_but" value="Create card record" />
</form>
</div>
</div>
</div>
</body>
</html>