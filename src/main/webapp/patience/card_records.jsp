<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title>All card records</title>
    <link rel="stylesheet" href="usable/css/mainStyle.css">
</head>
<body>
<div class="main_div">
<ol>
    <li>
        <a href="/Hospital_FP/controller?command=backToCabinetCommand"><div class="href_but green_but">To the cabinet</div></a>
    </li>
    <li>
        <a href="/Hospital_FP/controller?command=toWaysForPatience"><div class="href_but green_but">My ways</div></a>
    </li>
    <li>
        <a href="/Hospital_FP/controller?command=logout"><div class="href_but red_but">Logout</div></a>
    </li>
</ol>
<h2>All card records</h2>
<div class="content_div">
<h3>Yor card records</h3>
<table>
    <tr>
        <td>S.N.P</td>
        <td>Profession</td>
        <td>Procedures</td>
        <td>Medicines</td>
        <td>Operations</td>
        <td>Diagnosis</td>
        <td>Date of set</td>
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
</div>
</div>
</body>
</html>
