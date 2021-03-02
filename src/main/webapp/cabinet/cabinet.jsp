<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename='property'/>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title><fmt:message key='CABINET'/></title>
    <link rel="stylesheet" href="usable/css/mainStyle.css">
</head>
<body>
<div class="main_div">
<ol>
    <c:if test="${currentStatusId==1}">
        <li>
            <a href="/Hospital_FP/controller?command=toPatienceForAdmin"><div class="href_but green_but"><fmt:message key='ALL_PATIENCES'/></div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toDoctorsAndNursesForAdmin"><div class="href_but green_but"><fmt:message key='ALL_DOCTORS_AND_NURSES'/></div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toWaysForAdmin"><div class="href_but green_but"><fmt:message key='ALL_WAYS'/></div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toAdminsForAdmin"><div class="href_but green_but"><fmt:message key='ALL_ADMINS'/></div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toWorksForAdmin"><div class="href_but green_but"><fmt:message key='CHENGE_OR_ADD_WORK'/></div></a>
        </li>
    </c:if>

    <c:if test="${currentStatusId==2}">
        <li>
            <a href="/Hospital_FP/controller?command=toCardRecordsForPatience"><div class="href_but green_but"><fmt:message key='MY_CARD_RECORDS'/></div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toWaysForPatience"><div class="href_but green_but"><fmt:message key='MY_WAYS'/></div></a>
        </li>
    </c:if>
    <c:if test="${currentStatusId==3}">
        <li>
            <a href="/Hospital_FP/controller?command=toPatienceForDoctor"><div class="href_but green_but"><fmt:message key='ALL_PATIENCES'/></div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toDoctorsCardRecordsForDoctor"><div class="href_but green_but"><fmt:message key='MY_OWN_CARD_RECORDS'/></div></a>
        </li>
    </c:if>
    <c:if test="${currentStatusId==4}">
        <li>
            <a href="/Hospital_FP/controller?command=toPatienceForDoctor"><div class="href_but green_but"><fmt:message key='ALL_PATIENCES'/></div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toWaysPatiencesForDoctor"><div class="href_but green_but"><fmt:message key='MY_WAYS_PATIENCES'/></div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toDoctorsCardRecordsForDoctor"><div class="href_but green_but"><fmt:message key='MY_OWN_CARD_RECORDS'/></div></a>
        </li>
    </c:if>
    <li>
        <a href="/Hospital_FP/controller?command=logout"><div class="href_but red_but"><fmt:message key='LOGOUT'/></div></a>
    </li>
</ol>
<h2><fmt:message key='CABINET'/></h2>
<div style="text-align: right;">
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=ru_RU">RU</a>
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=en_US">EN</a>
    </div>
<hr>
<div class="content_div">
<div class="text_block"><b><fmt:message key='SNP'/>:</b> ${user.sername} ${user.name} ${user.patronymic}</div>
<div class="text_block"><b><fmt:message key='WORK'/>:</b> ${user.work.name}</div>
<div class="text_block"><b><fmt:message key='BIRTHDAY_UPPER_F'/>:</b> ${user.birthday}</div>
<div class="text_block"><b><fmt:message key='LOGIN_UPPER_F'/>:</b> ${user.login}</div> 
        <div class="not_list_button">
            <a href="cabinet/change_login.jsp"><div class="href_but blue_but"><fmt:message key='CHANGE_LOGIN'/></div></a>
        </div>
        <div class="not_list_button">
            <a href="cabinet/change_password.jsp"><div class="href_but blue_but"><fmt:message key='CHANGE_PASSWORD'/></div></a>
        </div>
        
<h3><fmt:message key='CABINET_MESSAGE'/></h3>
</div>
</div>
</body>
</html>
