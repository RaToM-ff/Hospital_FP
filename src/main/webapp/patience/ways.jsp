<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename='property'/>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title><fmt:message key='ALL_YOUR_WAYS'/></title>
    <link rel="stylesheet" href="usable/css/mainStyle.css">
</head>
<body>
<div class="main_div">
    <ol>
        <li>
            <a href="/Hospital_FP/controller?command=backToCabinetCommand"><div class="href_but green_but"><fmt:message key='TO_THE_CABINET'/></div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toCardRecordsForPatience"><div class="href_but green_but"><fmt:message key='MY_CARD_RECORDS'/></div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=logout"><div class="href_but red_but"><fmt:message key='LOGOUT'/></div></a>
        </li>
    </ol>
    <h2><fmt:message key='ALL_YOUR_WAYS'/></h2>
    <div style="text-align: right;">
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=ru_RU">RU</a>
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=en_US">EN</a>
    </div>
    <hr>
    <div class="content_div">
        
<c:if test="${empty null_p}">
        <h3><fmt:message key='FINISHED_WAYS'/></h3>
        <table>
            <tr>
                <td><fmt:message key='DOCTOR_UPPER_F'/></td>
                <td><fmt:message key='PROFESSION'/></td>
                <td><fmt:message key='DIAGNOSIS'/></td>
                <td><fmt:message key='DOCUMENT'/></td>
                <td><fmt:message key='DATE_OF_COME'/></td>
                <td><fmt:message key='DATE_OF_OUT'/></td>
            </tr>
            <c:forEach var="patienceWay" items="${patienceWaysFinish}">
                <tr>
                    <td>${patienceWay.doctor.sername} ${patienceWay.doctor.name} ${patienceWay.doctor.patronymic}</td>
                    <td>${patienceWay.doctor.work.name}</td>
                    <td>${patienceWay.diagnosis}</td>
                    <td>
                        <a href="${patienceWay.documentWay}" target="_blank">
                        <div class="table_but blue_but"><fmt:message key='OPEN'/></div>
                        </a>
                    </td>
                    <td>${patienceWay.date_come}</td>
                    <td>${patienceWay.date_out}</td>
                </tr>
            </c:forEach>
        </table>
        <h3><fmt:message key=''/>Not finish ways</h3>
        <table>
            <tr>
                <td><fmt:message key='DOCTOR_UPPER_F'/></td>
                <td><fmt:message key='PROFESSION'/></td>
                <td><fmt:message key='DATE_OF_COME'/></td>
            </tr>
            <c:forEach var="patienceWay" items="${patienceWaysNotFinish}">
                <tr>
                    <td>${patienceWay.doctor.sername} ${patienceWay.doctor.name} ${patienceWay.doctor.patronymic}</td>
                    <td>${patienceWay.doctor.work.name}</td>
                    <td>${patienceWay.date_come}</td>
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
