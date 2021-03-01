<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title>All doctors and nurses</title>
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
	    <a href="/Hospital_FP/controller?command=toPatienceForAdmin"><div class="href_but green_but">All patiences</div></a>
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

<h2>All doctors and nurses</h2>
<hr>
<div class="content_div">
		<h3>List of doctors and nurses</h3>
		<div class="not_list_button">
	    	<a href="/Hospital_FP/controller?command=toAddNewUserForAdmin&statusAddUser=3"><div class="href_but blue_but">Create new nurse</div></a>
	    </div>
	    <div class="not_list_button">
	    	<a href="/Hospital_FP/controller?command=toAddNewUserForAdmin&statusAddUser=4"><div class="href_but blue_but">Create new doctor</div></a>
		</div>
		<form method="POST" action="/Hospital_FP/controller">
			<input type="hidden" name="command" value="toDoctorsAndNursesForAdmin">
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
		    <c:forEach var="doctorOrNurse" items="${doctorsAndNurses}">
		        <tr>
		            <td>${doctorOrNurse.sername} ${doctorOrNurse.name} ${doctorOrNurse.patronymic}</td>
		            <td>${doctorOrNurse.birthday}</td>
		            <td>${doctorOrNurse.work.name}</td>
		            <td>${doctorOrNurse.completePatience}</td>
		            <td>${doctorOrNurse.activePatience}</td>
		            <td>
		            	<form method="POST" action="/Hospital_FP/controller">
		    				<input type="hidden" name="command" value="toChangeUserForAdmin">
		    				<input type="hidden" name="doctorOldWork" value="${doctorOrNurse.work.id}">
		    				<input type="hidden" name="changeUserId" value="${doctorOrNurse.id}">
		            		<input type="submit" class="table_but blue_but" value="Edit or delete user">
		            	</form>
		            </td>
		        </tr>
		    </c:forEach>
		</table>
</body>
</html>
