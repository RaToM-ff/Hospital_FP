<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title>All doctors</title>
    <script type="text/javascript" src="usable/js/selector.js"></script>
    <link rel="stylesheet" href="usable/css/mainStyle.css">
</head>
<body id="main_body" hidden>
	<div class="main_div">
		<div class="not_list_button">
		<a href="/Hospital_FP/controller?command=toPatienceForAdmin&filter=sername"><div class="href_but red_but">Back</div></a>
	</div>
	<h2>All doctors</h2>
	<hr>
	<div class="content_div">
	<h3>Selected patience: <i>${patience.sername} ${patience.name} ${patience.patronymic}</i></h3>
	<h3>Select doctor for create way</h3>
	<form method="POST" action="/Hospital_FP/controller">
		<input type="hidden" name="patienceId" value="${patienceId}">
		<input type="hidden" name="command" value="toSetDoctorForWayForAdmin">

    <p><b>Sorted by:</b>
	    <select name="filter" id="filter" filterValue="${filter}" onchange="form.submit();">
	  		<option id="filter_sername" value="sername">Alphabet</option>
	  		<option id="filter_work_name" value="work_name">Profession</option>
	  		<option id="filter_ActivePatience" value="ActivePatience">Active patience</option>
	  		<option id="filter_CompletePatience" value="CompletePatience">Complete paciente</option>
		</select>
    </p>
	</form>
	<table border="1">
	    <tr>
	        <td>S.N.P</td>
	        <td>Birthday</td>
	        <td>Profession</td>
	        <td>Active patience</td>
	        <td>Complete patience</td>
	        <td>To do</td>
	    </tr>
	    <c:forEach var="doctor" items="${doctors}">
	        <tr>
	            <td>${doctor.sername} ${doctor.name} ${doctor.patronymic}</td>
	            <td>${doctor.birthday}</td>
	            <td>${doctor.work.name}</td>
	            <td>${doctor.activePatience}</td>
	            <td>${doctor.completePatience}</td>
	            <td>
	            	<form method="POST" action="/Hospital_FP/controller">
	    				<input type="hidden" name="command" value="createNewWay">
	    				<input type="hidden" name="patienceId" value="${patienceId}">
	    				<input type="hidden" name="doctorId" value="${doctor.id}">
	            		<input type="submit" class="table_but blue_but" value="Set way">
	            	</form>
	            </td>
	        </tr>
	    </c:forEach>
	</table>
</body>
</html>
