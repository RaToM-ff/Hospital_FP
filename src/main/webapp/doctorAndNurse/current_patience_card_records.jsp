<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename='property'/>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title><fmt:message key='ALLCARD_RECORDS_FOR_PATIENCE'/></title>
    <script type="text/javascript" src="usable/js/selector.js"></script>
    <link rel="stylesheet" href="usable/css/mainStyle.css">
</head>
<body  id="main_body" hidden>
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

	<h2><fmt:message key='ALLCARD_RECORDS_FOR_PATIENCE'/>: <i>${patienceData.sername} ${patienceData.name} ${patienceData.patronymic}</i></h2>
	<div style="text-align: right;">
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=ru_RU">RU</a>
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=en_US">EN</a>
    </div>
	<hr>
	<div class="content_div">
	<c:if test="${empty null_p}">
	<h3><fmt:message key='LIST_OF_CARD_RECORDS'/></h3>
    <form method="POST" action="/Hospital_FP/controller">
		<input type="hidden" name="command" value="toCardRecordsCurrentPatienceForDoctor">
		<input type="hidden" name="patienceId" value="${patienceId}">
		<input type="hidden" name="forBackButton" value="${forBackButton}">
		<p><b><fmt:message key='SORTED_BY'/>:</b>
		    <select  class="href_but red_but" name="filter" id="filter" filterValue="${filter}" onchange="form.submit();">
		  		<option id="filter_doctorsSername" value="doctorsSername"><fmt:message key='SETTER_SNP'/></option>
		  		<option id="filter_work_name" value="work_name"><fmt:message key='PROFESSION'/></option>
		  		<option id="filter_date_of_set" value="date_of_set"><fmt:message key='DATE_OF_SET'/></option>
			</select>
	    </p>
	</form>
	<table>
	    <tr>
	        <td><fmt:message key='SETTER_SNP'/></td>
	        <td><fmt:message key='PROFESSION'/></td>
	        <td><fmt:message key='PROCEDURES'/></td>
	        <td><fmt:message key='MEDICINES'/></td>
	        <td><fmt:message key='OPERATIONS'/></td>
	        <td><fmt:message key='DIAGNOSIS'/></td>
	        <td><fmt:message key='DATE_OF_SET'/></td>
	        <td><fmt:message key='TO_DO'/></td>
	    </tr>
	    <c:forEach var="cardRecord" items="${cardRecords}">
	        <tr>
	            <td>${cardRecord.doctor.sername} ${cardRecord.doctor.name} ${cardRecord.doctor.patronymic}</td>
	            <td>${cardRecord.doctor.work.name}</td>
	            <td>${cardRecord.procedures}</td>
	            <td>${cardRecord.medicines}</td>
	            <td>${cardRecord.operations}</td>
	            <td>${cardRecord.diagnosis}</td>
	            <td>${cardRecord.date_of_set}</td>
	            <td>
	    			<c:if test="${cardRecord.doctor.id==doctorId}">
		            	<form method="POST" action="/Hospital_FP/controller">
			    			<input type="hidden" name="command" value="toChangeCardRecordForDoctor">
			    			<input type="hidden" name="cardRecordId" value="${cardRecord.id}">
			    			<input type="hidden" name="forBackButton" value="1">
			            	<input class="table_but blue_but" type="submit" value="<fmt:message key='EDIT_CARD_RECORD'/>">
			            </form>
		            </c:if>
		        </td>
	        </tr>
	    </c:forEach>
	</table>
	</c:if>
	<c:if test="${not empty null_p}">
	<p id="filter" filterValue="${filter}"></p>
		<h3 id="filter_work_name">${null_p}</h3>
	</c:if>
</div>
</div>
</body>
</html>
