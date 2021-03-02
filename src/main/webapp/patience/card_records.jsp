<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename='property'/>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title><fmt:message key='ALL_CARD_RECORDS'/></title>
    <link rel="stylesheet" href="usable/css/mainStyle.css">
</head>
<body>
<div class="main_div">
<ol>
    <li>
        <a href="/Hospital_FP/controller?command=backToCabinetCommand"><div class="href_but green_but"><fmt:message key='TO_THE_CABINET'/></div></a>
    </li>
    <li>
        <a href="/Hospital_FP/controller?command=toWaysForPatience"><div class="href_but green_but"><fmt:message key='ALL_WAYS'/></div></a>
    </li>
    <li>
        <a href="/Hospital_FP/controller?command=logout"><div class="href_but red_but"><fmt:message key='LOGOUT'/></div></a>
    </li>
</ol>
<h2><fmt:message key='ALL_CARD_RECORDS'/></h2>
<div style="text-align: right;">
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=ru_RU">RU</a>
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=en_US">EN</a>
    </div>
<hr>
<div class="content_div">
<c:if test="${empty null_p}">
<h3><fmt:message key='YOUR_CARD_RECORDS'/></h3>
<table>
    <tr>
        <td><fmt:message key='SNP'/></td>
        <td><fmt:message key='PROFESSION'/></td>
        <td><fmt:message key='PROCEDURES'/></td>
        <td><fmt:message key='MEDICINES'/></td>
        <td><fmt:message key='OPERATIONS'/></td>
        <td><fmt:message key='DIAGNOSIS'/></td>
        <td><fmt:message key='DATE_OF_SET'/></td>
    </tr>
    <c:forEach var="patienceCardRecord" items="${patienceCardRecords}">
        <tr>
            <td>${patienceCardRecord.doctor.sername} ${patienceCardRecord.doctor.name} ${patienceCardRecord.doctor.patronymic}</td>
            <td>${patienceCardRecord.doctor.work.name}</td>
            <td>${patienceCardRecord.procedures}</td>
            <td>${patienceCardRecord.medicines}</td>
            <td>${patienceCardRecord.operations}</td>
            <td>${patienceCardRecord.diagnosis}</td>
            <td>${patienceCardRecord.date_of_set}</td>
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
