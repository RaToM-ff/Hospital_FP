<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title>All patiences ways</title>
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
    <div class="href_but red_but">Back</div></a>
</div>
<h2>All ways for patience: <i>${patienceData.sername} ${patienceData.name} ${patienceData.patronymic}</i></h2>
<hr>
<div class="content_div">
	<h3>List of ways patience:</h3>
    <form method="POST" action="/Hospital_FP/controller">
		<input type="hidden" name="command" value="toAllPatienceWayForDoctor">
		<input type="hidden" name="patienceId" value="${patienceId}">
		<input type="hidden" name="forBackButton" value="${forBackButton}">
		<p><b>Sorted by:</b>
		    <select name="filter" id="filter" filterValue="${filter}" onchange="form.submit();">
		  		<option id="filter_doctorsSername" value="doctorsSername">Doctor's alphabet</option>
		  		<option id="filter_patiencesSername" value="patiencesSername">Patience's alphabet</option>
		  		<option id="filter_work_name" value="work_name">Profession</option>
		  		<option id="filter_date_come" value="date_come">Date of come</option>
		  		<option id="filter_date_out" value="date_out">Date of out</option>
			</select>
	    </p>
	</form>
	<table>
	    <tr>
	        <td>Doctor's S.N.P</td>
	        <td>Profession</td>
	        <td>Diagnosis</td>
	        <td>Document</td>
	        <td>Date of come</td>
	        <td>Date of out</td>
	    </tr>
	    <c:forEach var="way" items="${ways}">
	        <tr>
	            <td>${way.doctor.sername} ${way.doctor.name} ${way.doctor.patronymic}</td>
	            <td>${way.doctor.work.name}</td>
	            <td>${way.diagnosis}</td>
	            <td>
	            	<c:if test="${not empty way.documentWay}">
	            	<div class="not_list_button">
            			<a href="${way.documentWay}" target="_blank"><div class="table_but blue_but">Open</div></a>
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
