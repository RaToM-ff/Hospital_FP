<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename='property'/>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title><fmt:message key='ALL_DOCTORS'/></title>
    <script type="text/javascript" src="usable/js/selector.js"></script>
    <link rel="stylesheet" href="usable/css/mainStyle.css">
</head>
<body id="main_body" hidden>
	<div class="main_div">
		<div class="not_list_button">
		<a href="/Hospital_FP/controller?command=toPatienceForAdmin&filter=sername"><div class="href_but red_but"><fmt:message key='BACK_UPPER_F'/></div></a>
	</div>
	<h2><fmt:message key='ALL_DOCTORS'/></h2>
	<div style="text-align: right;">
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=ru_RU">RU</a>
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=en_US">EN</a>
    </div>
	<hr>
	<div class="content_div">
	<h3><fmt:message key='SELECTED_PATIECNE'/>: <i>${patience.sername} ${patience.name} ${patience.patronymic}</i></h3>
	<h3>Select doctor for create way</h3>
	<form method="POST" action="/Hospital_FP/controller">
		<input type="hidden" name="patienceId" value="${patienceId}">
		<input type="hidden" name="command" value="toSetDoctorForWayForAdmin">

    <p><b><fmt:message key='SORTED_BY'/>:</b>
	    <select  class="href_but red_but" name="filter" id="filter" filterValue="${filter}" onchange="form.submit();">
	  		<option id="filter_sername" value="sername"><fmt:message key='ALPHABET'/></option>
	  		<option id="filter_work_name" value="work_name"><fmt:message key='PROFESSION'/></option>
	  		<option id="filter_ActivePatience" value="ActivePatience"><fmt:message key='ACTIVE_PATIENCE'/></option>
	  		<option id="filter_CompletePatience" value="CompletePatience"><fmt:message key='COMPLETE_PATIENCE'/></option>
		</select>
    </p>
	</form>
	<table border="1">
	    <tr>
	        <td><fmt:message key='SNP'/></td>
	        <td><fmt:message key='BIRTHDAY_UPPER_F'/></td>
	        <td><fmt:message key='PROFESSION'/></td>
	        <td><fmt:message key='ACTIVE_PATIENCE'/></td>
	        <td><fmt:message key='COMPLETE_PATIENCE'/></td>
	        <td><fmt:message key='TO_DO'/></td>
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
	            		<input type="submit" class="table_but blue_but" value="<fmt:message key='SET_WAY'/>">
	            	</form>
	            </td>
	        </tr>
	    </c:forEach>
	</table>
</body>
</html>
