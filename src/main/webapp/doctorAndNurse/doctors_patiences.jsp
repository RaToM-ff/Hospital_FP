<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename='property'/>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title>My way's patiences</title>
    <script type="text/javascript" src="usable/js/selector.js"></script>
    <link rel="stylesheet" href="usable/css/mainStyle.css">
</head>
<body id="main_body" hidden>
<div class="main_div">
	<ol>
        <li>
            <a href="/Hospital_FP/controller?command=backToCabinetCommand"><div class="href_but green_but">To the cabinet</div></a>
        </li>
		<li>
            <a href="/Hospital_FP/controller?command=toPatienceForDoctor"><div class="href_but green_but">All patiences</div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toDoctorsCardRecordsForDoctor"><div class="href_but green_but">My own card records</div></a>
        </li>
        <li>
        	<a href="/Hospital_FP/controller?command=logout"><div class="href_but red_but">Logout</div></a>
    	</li>
	</ol>
	<h2>My way's patiences</h2>
	<div style="text-align: right;">
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=ru_RU">RU</a>
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=en_US">EN</a>
    </div>
<hr>
<div class="content_div">
	<c:if test="${empty null_p}">
		<h3>List of patiences</h3>
		<form method="POST" action="/Hospital_FP/controller">
			<p><b>Sorted by:</b>
				<input type="hidden" name="command" value="toWaysPatiencesForDoctor">
			    <select name="filter" id="filter" filterValue="${filter}" onchange="form.submit();">
			  		<option id="filter_sername" value="sername">Alphabet</option>
			  		<option id="filter_birthday" value="birthday">Birthday</option>
				</select>
		    </p>
		</form>
		<table>
		    <tr>
		        <td>S.N.P</td>
		        <td>Birthday</td>
		        <td>To do</td>
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
		            		<input type="submit" class="table_but blue_but" value="All ways">
	            		</form>
		            	<form style="display: inline-block;" method="POST" action="/Hospital_FP/controller">
		    				<input type="hidden" name="command" value="toCompleteWayForDoctor">
		    				<input type="hidden" name="completeWayId" value="${patience.idWay}">
		    				<input type="hidden" name="forBackButton" value="1">
		            		<input type="submit" class="table_but green_but" value="Complete this way">
		            	</form>
		            	<form style="display: inline-block;" method="POST" action="/Hospital_FP/controller">
		    				<input type="hidden" name="command" value="toCardRecordsCurrentPatienceForDoctor">
		    				<input type="hidden" name="patienceId" value="${patience.id}">
		    				<input type="hidden" name="forBackButton" value="1">
		            		<input type="submit" class="table_but blue_but" value="Card records">
		            	</form>
		            	<form style="display: inline-block;" method="POST" action="/Hospital_FP/controller">
		    				<input type="hidden" name="command" value="toCreateCardRecordForDoctor">
		    				<input type="hidden" name="patienceId" value="${patience.id}">
		    				<input type="hidden" name="forBackButton" value="1">
		            		<input type="submit" class="table_but green_but" value="Create card record">
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
