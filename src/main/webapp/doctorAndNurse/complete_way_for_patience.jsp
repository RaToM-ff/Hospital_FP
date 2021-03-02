<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename='property'/>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title><fmt:message key='COMPLETE_THE_WAY'/></title>
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
    <div class="href_but red_but"><fmt:message key='BACK_UPPER_F'/></div></a>
</div>
<h2><fmt:message key='COMPLETE_THE_WAY'/></h2>
<div style="text-align: right;">
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=ru_RU">RU</a>
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=en_US">EN</a>
    </div>
<hr>
<div class="content_div">
<h3><fmt:message key='WAY_INFORMATION'/>:</h3>
<div class="text_block">
    <p><b><fmt:message key='PATIENCE_UPPER_F'/>:</b></p>
        <p>${way.patience.sername} ${way.patience.name} ${way.patience.patronymic}</p>
    <p><b><fmt:message key='DOCTOR'/>:</b></p>
        <p>${way.doctor.work.name}: ${way.doctor.sername} ${way.doctor.name} ${way.doctor.patronymic}</p>
    <p><b><fmt:message key='DATE_OF_COME'/>:</b></p>
        <p>${way.date_come}</p>
</div>
<h3><fmt:message key='ADD_NEXT_DATA'/>:</h3>
<div class="text_block">
<form method="POST" action="/Hospital_FP/controller" enctype="multipart/form-data">
    <input type="hidden" name="command" value="completeWayForDoctor">
    <input type="hidden" name="completeWayId" value="${way.id}">
    <input type="hidden" name="forBackButton" value="${forBackButton}">
    <p><b><fmt:message key='DIAGNOSIS'/>:</b></p>
        <input type="textbox" name="diagnosisFinishWay" value="${way.diagnosis}"><div class="error_field">${errors.diagnosis}</div>
    <p><b><fmt:message key='DOCUMENT'/>:</b></p>
        <input type="hidden" id="fileFlag" name="fileWasUploading" value="no">
            <div class="not_list_button">
            <input type="file" class="href_but blue_but" name="documentWayUpload" onchange="if(this.value==''){document.getElementById('fileFlag').value = 'no'} else {document.getElementById('fileFlag').value = 'yes'}" accept=".pdf" size="50" value="" /></div><div class="error_field">${errors.document_way}</div>
        <br>
    <input class="functional_but blue_but" type="submit" value="<fmt:message key='CLOSE'/>">
</form>
</div>
</div>
</div>
</body>
</html>