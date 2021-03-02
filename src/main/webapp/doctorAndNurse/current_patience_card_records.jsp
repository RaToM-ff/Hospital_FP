<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename='property'/>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title>All card records for patience</title>
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
    <div class="href_but red_but">Back</div></a>
</div>

	<h2>All card records for patience: <i>${patienceData.sername} ${patienceData.name} ${patienceData.patronymic}</i></h2>
	<div style="text-align: right;">
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=ru_RU">RU</a>
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=en_US">EN</a>
    </div>
	<hr>
	<div class="content_div">
	<c:if test="${empty null_p}">
	<h3>List of card records</h3>
    <form method="POST" action="/Hospital_FP/controller">
		<input type="hidden" name="command" value="toCardRecordsCurrentPatienceForDoctor">
		<input type="hidden" name="patienceId" value="${patienceId}">
		<input type="hidden" name="forBackButton" value="${forBackButton}">
		<p><b>Sorted by:</b>
		    <select name="filter" id="filter" filterValue="${filter}" onchange="form.submit();">
		  		<option id="filter_doctorsSername" value="doctorsSername">Setter alphabet</option>
		  		<option id="filter_work_name" value="work_name">Profession</option>
		  		<option id="filter_date_of_set" value="date_of_set">Date of set</option>
			</select>
	    </p>
	</form>
	<table>
	    <tr>
	        <td>Setter S.N.P</td>
	        <td>Profession</td>
	        <td>Procedures</td>
	        <td>Medicines</td>
	        <td>Operations</td>
	        <td>Diagnosis</td>
	        <td>Date of set</td>
	        <td>To do</td>
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
			            	<input class="table_but blue_but" type="submit" value="Edit card record">
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
