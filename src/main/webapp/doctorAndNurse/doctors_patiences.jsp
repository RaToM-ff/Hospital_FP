<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename='property'/>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title><fmt:message key='MY_WAYS_PATIENCES'/></title>
    <script type="text/javascript" src="usable/js/selector.js"></script>
    <link rel="stylesheet" href="usable/css/mainStyle.css">
</head>
<body id="main_body" hidden>
<div class="main_div">
	<ol>
        <li>
            <a href="/Hospital_FP/controller?command=backToCabinetCommand"><div class="href_but green_but"><fmt:message key='TO_THE_CABINET'/></div></a>
        </li>
		<li>
            <a href="/Hospital_FP/controller?command=toPatienceForDoctor"><div class="href_but green_but"><fmt:message key='ALL_PATIENCES'/></div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toDoctorsCardRecordsForDoctor"><div class="href_but green_but"><fmt:message key='MY_OWN_CARD_RECORDS'/></div></a>
        </li>
        <li>
        	<a href="/Hospital_FP/controller?command=logout"><div class="href_but red_but"><fmt:message key='LOGOUT'/></div></a>
    	</li>
	</ol>
	<h2><fmt:message key='MY_WAYS_PATIENCES'/></h2>
	<div style="text-align: right;">
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=ru_RU">RU</a>
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=en_US">EN</a>
    </div>
<hr>
<div class="content_div">
	<c:if test="${empty null_p}">
		<h3><fmt:message key='LIST_OF_PATIENCES'/></h3>
		<form method="POST" action="/Hospital_FP/controller">
			<p><b><fmt:message key='SORTED_BY'/>:</b>
				<input type="hidden" name="command" value="toWaysPatiencesForDoctor">
			    <select  class="href_but red_but" name="filter" id="filter" filterValue="${filter}" onchange="form.submit();">
			  		<option id="filter_sername" value="sername"><fmt:message key='ALPHABET'/></option>
			  		<option id="filter_birthday" value="birthday"><fmt:message key='BIRTHDAY_UPPER_F'/></option>
				</select>
		    </p>
		</form>
		<table>
		    <tr>
		        <td><fmt:message key='SNP'/></td>
		        <td><fmt:message key='BIRTHDAY_UPPER_F'/></td>
		        <td><fmt:message key='TO_DO'/></td>
		    </tr>
		    <c:forEach var="patience" items="${patiences}">
		        <tr>
		            <td>${patience.sername} ${patience.name} ${patience.patronymic}</td>
		            <td>${patience.birthday}</td>
		            <td>
		            	<form style="display: inline-block;" method="POST" action="/Hospital_FP/controller">
		    				<input type="hidden" name="command" value="toAllPatienceWayForDoctor">
		    				<input type="hidden" name="patienceId" value="${patience.id}">
		    				<input type="hidden" name="forBackButton" value="1">
		            		<input type="submit" class="table_but blue_but" value="<fmt:message key='ALL_WAYS'/>">
	            		</form>
		            	<form style="display: inline-block;" method="POST" action="/Hospital_FP/controller">
		    				<input type="hidden" name="command" value="toCompleteWayForDoctor">
		    				<input type="hidden" name="completeWayId" value="${patience.idWay}">
		    				<input type="hidden" name="forBackButton" value="1">
		            		<input type="submit" class="table_but green_but" value="<fmt:message key='COMPLETE_THE_WAY'/>">
		            	</form>
		            	<form style="display: inline-block;" method="POST" action="/Hospital_FP/controller">
		    				<input type="hidden" name="command" value="toCardRecordsCurrentPatienceForDoctor">
		    				<input type="hidden" name="patienceId" value="${patience.id}">
		    				<input type="hidden" name="forBackButton" value="1">
		            		<input type="submit" class="table_but blue_but" value="<fmt:message key='CARD_RECORDS'/>">
		            	</form>
		            	<form style="display: inline-block;" method="POST" action="/Hospital_FP/controller">
		    				<input type="hidden" name="command" value="toCreateCardRecordForDoctor">
		    				<input type="hidden" name="patienceId" value="${patience.id}">
		    				<input type="hidden" name="forBackButton" value="1">
		            		<input type="submit" class="table_but green_but" value="<fmt:message key='CREATE_CARD_RECORD'/>">
		            	</form>
		            </td>
		        </tr>
		    </c:forEach>
		</table>
	</c:if>
	<c:if test="${not empty null_p}">
	<p id="filter" filterValue="${filter}"></p>
		<h3 id="filter_sername">${null_p}</h3>
	</c:if>
</div>
</div>
</body>
</html>
