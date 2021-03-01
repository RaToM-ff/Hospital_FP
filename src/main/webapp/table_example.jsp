<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title>PageName</title>
</head>
<body>
<h2>Table example</h2>
<table border="1">
    <tr>
        <td>№</td>
        <td>Name</td>
        <td>Surname</td>
        <td>Patronymic</td>
        <td>Status</td>
        <td>Work</td>
        <td>Birthday</td>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.sername}</td>
            <td>${user.patronymic}</td>
            <td>${user.status.statusName}</td>
            <td>${user.work.name}</td>
            <td>${user.birthday}</td>
            <td>
                            <form method="POST" action="/Hospital_FP/controller">
                                <input type="hidden" name="command" value="com">
                            	<input type="submit" name="id" value="${patienceCardRecord.id}">
                            </form>
                        </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
