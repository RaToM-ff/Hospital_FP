<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename='property'/>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title><fmt:message key='CHANGE_OD_DELETE_USER'/></title>
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
        <c:if test="${user.status.id=='1'}">
        <a href="/Hospital_FP/controller?command=toAdminsForAdmin"><div class="href_but red_but not_list_button"><fmt:message key='BACK_UPPER_F'/></div></a>
    </c:if>
    <c:if test="${user.status.id=='2'}">
        <a href="/Hospital_FP/controller?command=toPatienceForAdmin"><div class="href_but red_but"><fmt:message key='BACK_UPPER_F'/></div></a>
    </c:if>
    <c:if test="${user.status.id=='3'||user.status.id=='4'}">
        <a href="/Hospital_FP/controller?command=toDoctorsAndNursesForAdmin"><div class="href_but red_but"><fmt:message key='BACK_UPPER_F'/></div></a>
    </c:if>
</div>
<h2><fmt:message key='CHANGE'/> 
	<c:if test="${user.status.id=='1'}">
    	<i><fmt:message key='ADMIN'/></i>
    </c:if>
    <c:if test="${user.status.id=='2'}">
    	<i><fmt:message key='PATIENCE'/></i>
    </c:if>
    <c:if test="${user.status.id=='3'}">
    	<i><fmt:message key='NERCE'/></i>
    </c:if>
    <c:if test="${user.status.id=='4'}">
    	<i><fmt:message key='DOCTOR'/></i>
    </c:if>
</h2>
<div style="text-align: right;">
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=ru_RU">RU</a>
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=en_US">EN</a>
    </div>
<hr>
<div class="content_div">
<h3><fmt:message key='CHANGE_DATA'/>:</h3>
<div class="text_block">
<form method="POST" action="/Hospital_FP/controller">
		<input type="hidden" name="command" value="changeUserByAdmin">
	<p><b><fmt:message key='LOGIN_UPPER_F'/>:</b></p>
		<input type="text" name="login" value="${user.login}"><div class="error_field">${errors.login}</div>
    <p><b><fmt:message key='GENERATE_NEW_PASSWORD'/>:</b>
        <input type="checkbox" name="password" value="checked" />
        </p>
	<p><b><fmt:message key='NAME_UPPER_F'/>:</b></p>
		<input type="text" name="name" value="${user.name}"><div class="error_field">${errors.name}</div>
    <p><b><fmt:message key='SERNAME_UPPER_F'/>:</b></p>
    	<input type="text" name="sername" value="${user.sername}">
        <div class="error_field">${errors.sername}</div>
    <p><b><fmt:message key='PATRONYMIC_UPPER_F'/>:</b></p>
    	<input type="text" name="patronymic" value="${user.patronymic}"><div class="error_field">${errors.patronymic}</div>
        <c:if test="${user.status.id=='1'}">
            <input type="hidden" name="statusIdChangeUser" value="1">
            <input type="hidden" name="workIdChangeUser"value="1">
        </c:if>
        <c:if test="${user.status.id=='2'}">
            <input type="hidden" name="statusIdChangeUser" value="2">
            <input type="hidden" name="workIdChangeUser"value="2">
        </c:if>
        <c:if test="${user.status.id=='3'}">
            <input type="hidden" name="statusIdChangeUser" value="3">
            <input type="hidden" name="workIdChangeUser"value="3">
        </c:if>
        <c:if test="${user.status.id=='4'}">
            <input type="hidden" name="statusIdChangeUser" value="4">
            <p><b><fmt:message key='SELECT_DOCTORS_SPETIALIZATION'/>:</b></p>
        <select  class="href_but red_but" name="workIdChangeUser">
            <c:forEach var="work" items="${worksForDoctor}">
                <option id="dropList${work.id}" value="${work.id}">${work.name}</option>
            </c:forEach>
        </select>
        </c:if>
    <p><b><fmt:message key='BIRTHDAY_UPPER_F'/>:</b></p>
    	<input type="date" id="start" name="birthday" value="${user.birthday}" min="1910-01-01" max="${dateToday}"><div class="error_field">${errors.birthday}</div>
    	<input type="hidden" name="changeUserId" value="${user.id}">
        <br>
	    <input class="functional_but blue_but" type="submit" value="Change">
</form>
</div>
<h3><fmt:message key='DELETE_USER'/>:</h3>
<div class="text_block">
<form>
    <p><b><fmt:message key='ACCEPT_DELETE_THIS_USER'/>:</b>
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
