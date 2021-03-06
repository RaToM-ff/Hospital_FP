<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename='property'/>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title><fmt:message key='ADD_USER_UPPER_F'/></title>
    <link rel="stylesheet" href="usable/css/mainStyle.css">
</head>
<body>
<div class="main_div">
    <div class="not_list_button">
        <c:if test="${statusAddUser=='1'}">
            <a href="/Hospital_FP/controller?command=toAdminsForAdmin">
                    <div class="href_but red_but">
                        <fmt:message key='BACK_UPPER_F'/>
                    </div>
            </a>
        </c:if>
        <c:if test="${statusAddUser=='2'}">
                <a href="/Hospital_FP/controller?command=toPatienceForAdmin"><div class="href_but red_but"><fmt:message key='BACK_UPPER_F'/></div></a>
        </c:if>
        <c:if test="${statusAddUser=='3'||statusAddUser=='4'}">
                <a href="/Hospital_FP/controller?command=toDoctorsAndNursesForAdmin"><div class="href_but red_but"><fmt:message key='BACK_UPPER_F'/></div></a>
        </c:if>
    </div>
<h2><fmt:message key='CREATE_NEW_UPPER_F'/> 
	<c:if test="${statusAddUser=='1'}">
    	<i><fmt:message key='ADMIN_UPPER_F'/></i>
    </c:if>
    <c:if test="${statusAddUser=='2'}">
    	<i><fmt:message key='PATIENCE_UPPER_F'/></i>
    </c:if>
    <c:if test="${statusAddUser=='3'}">
    	<i><fmt:message key='NURSE_UPPER_F'/></i>
    </c:if>
    <c:if test="${statusAddUser=='4'}">
    	<i><fmt:message key='DOCTOR_UPPER_F'/></i>
    </c:if>
</h2>




    <div style="text-align: right;">
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=ru_RU">RU</a>
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=en_US">EN</a>
    </div>




<hr>
<div class="content_div">
    <h3><fmt:message key='EDIT_DATA_UPPER_F'/>:</h3>
    <div class="text_block">
        <form method="POST" action="/Hospital_FP/controller">
        		<input type="hidden" name="command" value="createNewUser">
        	<p><fmt:message key='LOGIN_UPPER_F'/>:</p>
        		<input type="text" name="login" value="${user.login}">
<c:if test="${not empty errors.login}">
            <div class="error_field"><fmt:message key='${errors.login}'/></div>
</c:if>
        	<p><fmt:message key='PASSWORD_UPPER_F'/>:</p>
        		<input type="text" name="password">
<c:if test="${not empty errors.password}">
                <div class="error_field"><fmt:message key='${errors.password}'/></div>
</c:if>
        	<p><fmt:message key='NAME_UPPER_F'/>:</p>
        		<input type="text" name="name" value="${user.name}">
<c:if test="${not empty errors.name}">
                <div class="error_field"><fmt:message key='${errors.name}'/></div>
</c:if>
            <p><fmt:message key='SERNAME_UPPER_F'/>:</p>
            	<input type="text" name="sername" value="${user.sername}">
<c:if test="${not empty errors.sername}">
                <div class="error_field"><fmt:message key='${errors.sername}'/></div>
</c:if>
            <p><fmt:message key='PATRONYMIC_UPPER_F'/>:</p>
            	<input type="text" name="patronymic" value="${user.patronymic}">
<c:if test="${not empty errors.patronymic}">
                <div class="error_field"><fmt:message key='${errors.patronymic}'/></div>
</c:if>
                <c:if test="${statusAddUser=='1'}">
                    <input type="hidden" name="statusAddUser" value="1">
                    <input type="hidden" name="workIdAddUser"value="1">
                </c:if>
                <c:if test="${statusAddUser=='2'}">
                    <input type="hidden" name="statusAddUser" value="2">
                    <input type="hidden" name="workIdAddUser"value="2">
                </c:if>
                <c:if test="${statusAddUser=='3'}">
                    <input type="hidden" name="statusAddUser" value="3">
                    <input type="hidden" name="workIdAddUser"value="3">
                </c:if>
                <c:if test="${statusAddUser=='4'}">
                    <input type="hidden" name="statusAddUser" value="4">
                    <p><fmt:message key='SELECT_DOCTORS_WORK_UPPER_F'/>:</p>
                <select class="href_but red_but" name="workIdAddUser">
                    <c:forEach var="work" items="${worksForDoctor}">
                        <option id="dropList${work.id}" value="${work.id}">${work.name}</option>
                    </c:forEach>
                </select>
                </c:if>
            <p><fmt:message key='BIRTHDAY_UPPER_F'/>:</p>
            	<input type="date" id="start" name="birthday" value="${dateToday}" min="1910-01-01" max="${dateToday}">
<c:if test="${not empty errors.birthday}">
                <div class="error_field"><fmt:message key='${errors.birthday}'/></div>
</c:if>
                <br>
        	<input class="functional_but blue_but" type="submit" value="<fmt:message key='CREATE_BUTTON'/>">
        </form>
    </div>
    </div>
</div>
</body>
</html>
