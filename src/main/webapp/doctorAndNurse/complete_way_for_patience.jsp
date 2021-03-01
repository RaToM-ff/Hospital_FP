<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title>Complete the way</title>
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
<h2>Complete the way</h2>
<hr>
<div class="content_div">
<h3>Way information:</h3>
<div class="text_block">
    <p><b>Patience:</b></p>
        <p>${way.patience.sername} ${way.patience.name} ${way.patience.patronymic}</p>
    <p><b>Doctor:</b></p>
        <p>${way.doctor.work.name}: ${way.doctor.sername} ${way.doctor.name} ${way.doctor.patronymic}</p>
    <p><b>Date of come:</b></p>
        <p>${way.date_come}</p>
</div>
<h3>Add next data:</h3>
<div class="text_block">
<form method="POST" action="/Hospital_FP/controller" enctype="multipart/form-data">
    <input type="hidden" name="command" value="completeWayForDoctor">
    <input type="hidden" name="finishWayId" value="${way.id}">
    <p><b>Diagnosis:</b></p>
        <input type="textbox" name="diagnosisFinishWay" value="${way.diagnosis}">
    <p><b>Document:</b></p>
        <input type="file" name="documentWayUpload" accept=".pdf" size="50" />
        <br>
    <input class="functional_but blue_but" type="submit" value="Close">
</form>
</div>
</div>
</div>
</body>
</html>