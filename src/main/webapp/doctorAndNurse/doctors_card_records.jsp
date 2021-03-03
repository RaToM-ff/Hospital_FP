<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename='property'/>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title><fmt:message key='ALL_YOUR_CARD_RECORDS'/></title>
    <script type="text/javascript" src="usable/js/selector.js"></script>
    <link rel="stylesheet" href="usable/css/mainStyle.css">
</head>
<body id="main_body" hidden>
<div class="main_div">
<ol>
	<c:if test="${currentStatusId==3}">
        <li>
            <a href="/Hospital_FP/controller?command=backToCabinetCommand"><div class="href_but green_but"><fmt:message key='TO_THE_CABINET'/></div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toPatienceForDoctor"><div class="href_but green_but"><fmt:message key='ALL_PATIENCES'/></div></a>
        </li>
    </c:if>
    <c:if test="${currentStatusId==4}">
        <li>
            <a href="/Hospital_FP/controller?command=backToCabinetCommand"><div class="href_but green_but"><fmt:message key='TO_THE_CABINET'/></div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toPatienceForDoctor"><div class="href_but green_but"><fmt:message key='ALL_PATIENCES'/></div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toWaysPatiencesForDoctor"><div class="href_but green_but"><fmt:message key='MY_WAYS_PATIENCES'/></div></a>
        </li>
    </c:if>
    <li>
        <a href="/Hospital_FP/controller?command=logout"><div class="href_but red_but"><fmt:message key='LOGOUT'/></div></a>
    </li>
</ol>
	<h2><fmt:message key='ALL_YOUR_CARD_RECORDS'/></h2>
	<div style="text-align: right;">
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=ru_RU">RU</a>
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=en_US">EN</a>
    </div>
<hr>
<div class="content_div">
	<c:if test="${empty null_p}">
	<h3><fmt:message key='LIST_OF_CARD_RECORDS'/>:</h3>
    <form method="POST" action="/Hospital_FP/controller">
		<input type="hidden" name="command" value="toDoctorsCardRecordsForDoctor">
		<p><b><fmt:message key='SORTED_BY'/>:</b>
		    <select  class="href_but red_but" name="filter" id="filter" filterValue="${filter}" onchange="form.submit();">
		  		<option id="filter_patiencesSername" value="patiencesSername"><fmt:message key='PATIENCES_SNP'/></option>
		  		<option id="filter_date_of_set" value="date_of_set"><fmt:message key='DATE_OF_SET'/></option>
			</select>
	    </p>
	</form>
	<table border="1">
	    <tr>
	        <td><fmt:message key='PATIENCES_SNP'/></td>
	        <td><fmt:message key='PROCEDURES'/></td>
	        <td><fmt:message key='MEDICINES'/></td>
	        <td><fmt:message key='OPERATIONS'/></td>
	        <td><fmt:message key='DIAGNOSIS'/></td>
	        <td><fmt:message key='DATE_OF_SET'/></td>
	        <td><fmt:message key='TO_DO'/></td>
	    </tr>
	    <c:forEach var="cardRecord" items="${cardRecords}">
	        <tr>
	            <td>${cardRecord.patience.sername} ${cardRecord.patience.name} ${cardRecord.patience.patronymic}</td>
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
			    			<input type="hidden" name="forBackButton" value="2">
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
		<h3 id="filter_patiencesSername"><fmt:message key='${null_p}'/></h3>
	</c:if>
</div>
</div>
</body>
</html>
