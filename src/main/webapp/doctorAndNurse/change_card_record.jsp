<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename='property'/>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title><fmt:message key='CHANGE_OR_DELETE_CARD_RECORD'/></title>
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
<h2><fmt:message key='CHANGE_OR_DELETE_CARD_RECORD_FOR'/> <i>${racordWay.patience.sername} ${racordWay.patience.name} ${racordWay.patience.patronymic}</i></h2>
<div style="text-align: right;">
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=ru_RU">RU</a>
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=en_US">EN</a>
    </div>
<hr>
<div class="content_div">
<h3><fmt:message key='CHANGE_DATA'/>:</h3>
<div class="text_block">
<form method="POST" action="/Hospital_FP/controller">
		<input type="hidden" name="command" value="changeCardRecordForDoctor">
        <input type="hidden" name="forBackButton" value="${forBackButton}">
        <input type="hidden" name="cardRecordId" value="${cardRecord.id}">
        <input type="hidden" name="patienceId" value="${cardRecord.patience.id}">
        <input type="hidden" name="doctorId" value="${cardRecord.doctor.id}">
	<p><b><fmt:message key='PROCEDURES'/>:</b></p>
		<input type="text" name="procedures" value="${cardRecord.procedures}">
<c:if test="${not empty errors.procedures}">
        <div class="error_field"><fmt:message key='${errors.procedures}'/></div>
</c:if>
	<p><b><fmt:message key='MEDICINES'/>:</b></p>
		<input type="text" name="medicines" value="${cardRecord.medicines}">
<c:if test="${not empty errors.medicines}">
        <div class="error_field"><fmt:message key='${errors.medicines}'/></div>
</c:if>
    <c:if test="${statusId==4}">
        <p><b><fmt:message key='OPERATIONS'/>:</b></p>
            <input type="text" name="operations" value="${cardRecord.operations}">
<c:if test="${not empty errors.operations}">
            <div class="error_field"><fmt:message key='${errors.operations}'/></div>
</c:if>
        <p><b><fmt:message key='DIAGNOSIS'/>:</b></p>
            <input type="text" name="diagnosis" value="${cardRecord.diagnosis}">
<c:if test="${not empty errors.diagnosis}">
            <div class="error_field"><fmt:message key='${errors.diagnosis}'/></div>
</c:if>
            <input type="hidden" name="forDoctor" value="true">
    </c:if>
    <c:if test="${statusId==3}">
            <input type="hidden" name="forDoctor">
    </c:if>
    <br>
        <input type="submit" class="functional_but blue_but" value="<fmt:message key='CHANGE_CARD_RECORD'/>" />
</form>
</div>
<div class="text_block">
<form>
    <input type="hidden" name="deleteCardRecordId" value="${cardRecord.id}">
    <input type="hidden" name="command" value="deleteCardRecordForDoctor">
    <h3><fmt:message key='DELETE_CARD_RECORD'/>:</h3>
    <p><b><fmt:message key='ACCEPT_DELETE_CARD_RECORD'/>:</b>
        <input type="checkbox"  onchange="document.getElementById('deleteCardRecord').disabled = !this.checked; if(!this.checked) {document.getElementById('deleteCardRecord').removeAttribute('class')} else {document.getElementById('deleteCardRecord').setAttribute('class','functional_but blue_but')}" />
    </p>
    <input type="submit"  disabled id="deleteCardRecord" value="<fmt:message key='DELETE_CARD_RECORD'/>">
</form>
</div>
</div>
</div>
</body>
</html>
