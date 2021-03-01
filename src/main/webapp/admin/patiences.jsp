<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title>All patiences</title>
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
            <a href="/Hospital_FP/controller?command=toDoctorsAndNursesForAdmin"><div class="href_but green_but">All doctors and nurses</div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toWaysForAdmin"><div class="href_but green_but">All ways</div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toAdminsForAdmin"><div class="href_but green_but">All admins</div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toWorksForAdmin"><div class="href_but green_but">Change or add wokr</div></a>
        </li>
        <li>
        <a href="/Hospital_FP/controller?command=logout"><div class="href_but red_but">Logout</div></a>
    </li>
    </ol>
	<h2>All patiences</h2>
    <hr>
    <div class="content_div">
    	<div class="not_list_button">
	    <a href="/Hospital_FP/controller?command=toAddNewUserForAdmin&statusAddUser=2"><div class="href_but blue_but">Create new patience</div></a>
		</div>
		<h3>List of patiences</h3>
		<form method="POST" action="/Hospital_FP/controller">
			<input type="hidden" name="command" value="toPatienceForAdmin">
		<p><b>Sorted by:</b>
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
			    				<input type="hidden" name="command" value="toSetDoctorForWayForAdmin">
			    				<input type="hidden" name="patienceId" value="${patience.id}">
			            		<input type="submit" class="table_but green_but" value="Create way">
			            	</form>
			            	<form style="display: inline-block;" method="POST" action="/Hospital_FP/controller">
			    				<input type="hidden" name="command" value="toChangeUserForAdmin">
			    				<input type="hidden" name="changeUserId" value="${patience.id}">
			            		<input type="submit" class="table_but blue_but" value="Edit or delete user">
			            	</form>
			            </td>
			        </tr>
			    </c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
