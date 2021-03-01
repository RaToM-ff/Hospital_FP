<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title>Change or delete user</title>
    <link rel="stylesheet" href="usable/css/mainStyle.css">
    <script type="text/javascript">
        window.onload = function() {
            if(document.getElementById("dropList"+'${oldWorkForDoctor}') != null) {
                document.getElementById("dropList"+'${oldWorkForDoctor}').selected = "selected";;
            }
            document.getElementById("main_body").removeAttribute("hidden");
        };
    </script>
</head>
<body id="main_body" hidden>
    <div class="main_div">
        <div class="not_list_button">
        <c:if test="${statusChangeUser=='1'}">
        <a href="/Hospital_FP/controller?command=toAdminsForAdmin"><div class="href_but red_but not_list_button">Back</div></a>
    </c:if>
    <c:if test="${statusChangeUser=='2'}">
        <a href="/Hospital_FP/controller?command=toPatienceForAdmin"><div class="href_but red_but">Back</div></a>
    </c:if>
    <c:if test="${statusChangeUser=='3'||statusChangeUser=='4'}">
        <a href="/Hospital_FP/controller?command=toDoctorsAndNursesForAdmin"><div class="href_but red_but">Back</div></a>
    </c:if>
</div>
<h2>Change 
	<c:if test="${statusChangeUser=='1'}">
    	<i>Admin</i>
    </c:if>
    <c:if test="${statusChangeUser=='2'}">
    	<i>Patience</i>
    </c:if>
    <c:if test="${statusChangeUser=='3'}">
    	<i>Nurse</i>
    </c:if>
    <c:if test="${statusChangeUser=='4'}">
    	<i>Doctor</i>
    </c:if>
</h2>
<hr>
<div class="content_div">
<h3>Change data:</h3>
<div class="text_block">
<form method="POST" action="/Hospital_FP/controller">
		<input type="hidden" name="command" value="changeUserByAdmin">
	<p><b>Login:</b></p>
		<input type="text" name="login" placeholder="Login" value="${login}">
    <p><b>Generate new password:</b>
        <input type="checkbox" name="password" value="checked" />
        </p>
	<p><b>Name:</b></p>
		<input type="text" name="name" placeholder="Name" value="${name}">
    <p><b>Sername:</b></p>
    	<input type="text" name="sername" placeholder="Sername" value="${sername}">
    <p><b>Patronymic:</b></p>
    	<input type="text" name="patronymic" placeholder="Patronymic" value="${patronymic}">
        <c:if test="${statusIdChangeUser=='1'}">
            <input type="hidden" name="statusIdChangeUser" value="1">
            <input type="hidden" name="workIdChangeUser"value="1">
        </c:if>
        <c:if test="${statusIdChangeUser=='2'}">
            <input type="hidden" name="statusIdChangeUser" value="2">
            <input type="hidden" name="workIdChangeUser"value="2">
        </c:if>
        <c:if test="${statusIdChangeUser=='3'}">
            <input type="hidden" name="statusIdChangeUser" value="3">
            <input type="hidden" name="workIdChangeUser"value="3">
        </c:if>
        <c:if test="${statusIdChangeUser=='4'}">
            <input type="hidden" name="statusIdChangeUser" value="4">
            <p><b>Select doctor's spetialization:</b></p>
        <select name="workIdChangeUser">
            <c:forEach var="work" items="${worksForDoctor}">
                <option id="dropList${work.id}" value="${work.id}">${work.name}</option>
            </c:forEach>
        </select>
        </c:if>
    <p><b>Birthday:</b></p>
    	<input type="date" id="start" name="birthday" value="${birthday}" min="1910-01-01" max="${dateToday}">
    	<input type="hidden" name="changeUserId" value="${changeUserId}">
        <br>
	    <input class="functional_but blue_but" type="submit" value="Change">
</form>
</div>
<h3>Delete user:</h3>
<div class="text_block">
<form>
    <p><b>Accept delete this user:</b>
        <input type="checkbox"  onchange="document.getElementById('deleteUser').disabled = !this.checked; if(!this.checked) {document.getElementById('deleteUser').removeAttribute('class')} else {document.getElementById('deleteUser').setAttribute('class','functional_but blue_but')}" />
    </p>
    <input type="submit" class="" disabled id="deleteUser" value="Delete user" />
    <input type="hidden" name="changeUserId" value="${changeUserId}">
    <input type="hidden" name="command" value="deleteUser">
</form>
</div>
</div>
</div>
</body>
</html>
