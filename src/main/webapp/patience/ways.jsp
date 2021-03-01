<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title>All your ways</title>
    <link rel="stylesheet" href="usable/css/mainStyle.css">
</head>
<body>
<div class="main_div">
    <ol>
        <li>
            <a href="/Hospital_FP/controller?command=backToCabinetCommand"><div class="href_but green_but">To the cabinet</div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toCardRecordsForPatience"><div class="href_but green_but">My card records</div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=logout"><div class="href_but red_but">Logout</div></a>
        </li>
    </ol>
    <h2>All your ways</h2>
    <hr>
    <div class="content_div">
        <h3>Finish ways</h3>
        <table>
            <tr>
                <td>Doctor</td>
                <td>Profession</td>
                <td>Diagnosis</td>
                <td>Document</td>
                <td>Date of come</td>
                <td>Date of out</td>
            </tr>
            <c:forEach var="patienceWay" items="${patienceWaysFinish}">
                <tr>
                    <td>${patienceWay.doctor.sername} ${patienceWay.doctor.name} ${patienceWay.doctor.patronymic}</td>
                    <td>${patienceWay.doctor.work.name}</td>
                    <td>${patienceWay.diagnosis}</td>
                    <td>
                        <a href="${patienceWay.documentWay}" target="_blank">
                        <div class="table_but blue_but">Open</div>
                        </a>
                    </td>
                    <td>${patienceWay.date_come}</td>
                    <td>${patienceWay.date_out}</td>
                </tr>
            </c:forEach>
        </table>
        <h3>Not finish ways</h3>
        <table>
            <tr>
                <td>Doctor</td>
                <td>Profession</td>
                <td>Date of come</td>
            </tr>
            <c:forEach var="patienceWay" items="${patienceWaysNotFinish}">
                <tr>
                    <td>${patienceWay.doctor.sername} ${patienceWay.doctor.name} ${patienceWay.doctor.patronymic}</td>
                    <td>${patienceWay.doctor.work.name}</td>
                    <td>${patienceWay.date_come}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
