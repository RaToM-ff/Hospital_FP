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
    <c:if test="${forBackButton==2}">
        <a href="/Hospital_FP/controller?command=toDoctorsCardRecordsForDoctor">
    </c:if>
    <div class="href_but red_but">Back</div></a>
</div>
<h2>Change or delete card record for <i>${racordWay.patience.sername} ${racordWay.patience.name} ${racordWay.patience.patronymic}</i></h2>
<hr>
<div class="content_div">
<h3>Change data:</h3>
<div class="text_block">
<form method="POST" action="/Hospital_FP/controller">
		<input type="hidden" name="command" value="changeCardRecordForDoctor">
        <input type="hidden" name="cardRecordId" value="${cardRecord.id}">
        <input type="hidden" name="patienceId" value="${cardRecord.patience.id}">
        <input type="hidden" name="doctorId" value="${cardRecord.doctor.id}">
	<p><b>Procedures:</b></p>
		<input type="text" name="procedures" placeholder="Procedures" value="${cardRecord.procedures}">
	<p><b>Medicines:</b></p>
		<input type="text" name="medicines" placeholder="Medicines" value="${cardRecord.medicines}">
    <c:if test="${statusId==4}">
        <p><b>Operations:</b></p>
            <input type="text" name="operations" placeholder="Operations" value="${cardRecord.operations}">
        <p><b>Diagnosis:</b></p>
            <input type="text" name="diagnosis" placeholder="Diagnosis" value="${cardRecord.diagnosis}">
            <input type="hidden" name="forDoctor" value="true">
    </c:if>
    <c:if test="${statusId==3}">
            <input type="hidden" name="forDoctor">
    </c:if>
    <br>
        <input type="submit" class="functional_but blue_but" value="Change card record" />
</form>
</div>
<div class="text_block">
<form>
    <input type="hidden" name="deleteCardRecordId" value="${cardRecord.id}">
    <input type="hidden" name="command" value="deleteCardRecordForDoctor">
    <h3>Delete card record:</h3>
    <p><b>Accept delete this card record:</b>
        <input type="checkbox"  onchange="document.getElementById('deleteCardRecord').disabled = !this.checked; if(!this.checked) {document.getElementById('deleteCardRecord').removeAttribute('class')} else {document.getElementById('deleteCardRecord').setAttribute('class','functional_but blue_but')}" />
    </p>
    <input type="submit"  disabled id="deleteCardRecord" value="Delete card record">
</form>
</div>
</div>
</div>
</body>
</html>
