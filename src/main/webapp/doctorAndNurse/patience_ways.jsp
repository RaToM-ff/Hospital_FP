<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename='property'/>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title><fmt:message key='ALL_PATIENCE_WAYS'/></title>
    <script type="text/javascript" src="usable/js/selector.js"></script>
    <link rel="stylesheet" href="usable/css/mainStyle.css">
</head>
<body id="main_body" hidden>
	<div class="main_div">
    <div class="not_list_button">
    <c:if test="${forBackButton==0}">
        <a href="/Hospital_FP/controller?command=toPatienceForDoctor">
    </c:if>
    <c:if test="${forBackButton==1}">
        <a href="/Hospital_FP/controller?command=toWaysPatiencesForDoctor">
    </c:if>
    <div class="href_but red_but"><fmt:message key='BACK_UPPER_F'/></div></a>
</div>
<h2><fmt:message key='ALL_WAYS_FOR_PATIENCE'/>: <i>${patienceData.sername} ${patienceData.name} ${patienceData.patronymic}</i></h2>
<div style="text-align: right;">
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=ru_RU">RU</a>
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=en_US">EN</a>
    </div>
<hr>
<div class="content_div">
	<h3><fmt:message key='LIST_OF_WAYS'/>:</h3>
    <form method="POST" action="/Hospital_FP/controller">
		<input type="hidden" name="command" value="toAllPatienceWayForDoctor">
		<input type="hidden" name="patienceId" value="${patienceId}">
		<input type="hidden" name="forBackButton" value="${forBackButton}">
		<p><b><fmt:message key='SORTED_BY'/>:</b>
		    <select  class="href_but red_but" name="filter" id="filter" filterValue="${filter}" onchange="form.submit();">
		  		<option id="filter_doctorsSername" value="doctorsSername"><fmt:message key='DOCTORS_ALPHABET'/></option>
		  		<option id="filter_patiencesSername" value="patiencesSername"><fmt:message key='PATIENCES_ALPHABET'/></option>
		  		<option id="filter_work_name" value="work_name"><fmt:message key='PROFESSION'/></option>
		  		<option id="filter_date_come" value="date_come"><fmt:message key='DATE_OF_COME'/></option>
		  		<option id="filter_date_out" value="date_out"><fmt:message key='DATE_OF_OUT'/></option>
			</select>
	    </p>
	</form>
	<table>
	    <tr>
	        <td><fmt:message key='DOCTORS_SNP'/></td>
	        <td><fmt:message key='PROFESSION'/>Profession</td>
	        <td><fmt:message key='DIAGNOSIS'/></td>
	        <td><fmt:message key='DOCUMENT'/></td>
	        <td><fmt:message key='DATE_OF_COME'/></td>
	        <td><fmt:message key='DATE_OF_OUT'/></td>
	    </tr>
	    <c:forEach var="way" items="${ways}">
	        <tr>
	            <td>${way.doctor.sername} ${way.doctor.name} ${way.doctor.patronymic}</td>
	            <td>${way.doctor.work.name}</td>
	            <td>${way.diagnosis}</td>
	            <td>
	            	<c:if test="${not empty way.documentWay}">
	            	<div class="not_list_button">
            			<a href="${way.documentWay}" target="_blank"><div class="table_but blue_but"><fmt:message key='OPEN'/></div></a>
        			</div>
        			</c:if>
	            </td>
	            <td>${way.date_come}</td>
	            <td>${way.date_out}</td>
	        </tr>
	    </c:forEach>
	</table>
</body>
</html>
