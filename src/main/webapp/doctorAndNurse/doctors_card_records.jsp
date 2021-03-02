<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename='property'/>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title>All your card records</title>
    <script type="text/javascript" src="usable/js/selector.js"></script>
    <link rel="stylesheet" href="usable/css/mainStyle.css">
</head>
<body id="main_body" hidden>
<div class="main_div">
<ol>
	<c:if test="${currentStatusId==3}">
        <li>
            <a href="/Hospital_FP/controller?command=backToCabinetCommand"><div class="href_but green_but">To the cabinet</div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toPatienceForDoctor"><div class="href_but green_but">All patiences</div></a>
        </li>
    </c:if>
    <c:if test="${currentStatusId==4}">
        <li>
            <a href="/Hospital_FP/controller?command=backToCabinetCommand"><div class="href_but green_but">To the cabinet</div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toPatienceForDoctor"><div class="href_but green_but">All patiences</div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toWaysPatiencesForDoctor"><div class="href_but green_but">My way's patiences</div></a>
        </li>
    </c:if>
    <li>
        <a href="/Hospital_FP/controller?command=logout"><div class="href_but red_but">Logout</div></a>
    </li>
</ol>
	<h2>All your records</h2>
	<div style="text-align: right;">
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=ru_RU">RU</a>
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=en_US">EN</a>
    </div>
<hr>
<div class="content_div">
	<c:if test="${empty null_p}">
	<h3>List of card records:</h3>
    <form method="POST" action="/Hospital_FP/controller">
		<input type="hidden" name="command" value="toDoctorsCardRecordsForDoctor">
		<p><b>Sorted by:</b>
		    <select name="filter" id="filter" filterValue="${filter}" onchange="form.submit();">
		  		<option id="filter_patiencesSername" value="patiencesSername">Patience's alphabet</option>
		  		<option id="filter_date_of_set" value="date_of_set">Date of set</option>
			</select>
	    </p>
	</form>
	<table border="1">
	    <tr>
	        <td>Patience's S.N.P</td>
	        <td>Procedures</td>
	        <td>Medicines</td>
	        <td>Operations</td>
	        <td>Diagnosis</td>
	        <td>Date of set</td>
	        <td>To do</td>
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
		<h3 id="filter_patiencesSername">${null_p}</h3>
	</c:if>
</div>
</div>
</body>
</html>
