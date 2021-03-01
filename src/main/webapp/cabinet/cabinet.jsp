<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title>Cabinet</title>
    <link rel="stylesheet" href="usable/css/mainStyle.css">
</head>
<body>
<div class="main_div">
<ol>
    <c:if test="${currentStatusId==1}">
        <li>
            <a href="/Hospital_FP/controller?command=toPatienceForAdmin"><div class="href_but green_but">All patiences</div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toDoctorsAndNursesForAdmin"><div class="href_but green_but">All doctors and nurses</div></a>
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
    </c:if>

    <c:if test="${currentStatusId==2}">
        <li>
            <a href="/Hospital_FP/controller?command=toCardRecordsForPatience"><div class="href_but green_but">My card records</div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toWaysForPatience"><div class="href_but green_but">My ways</div></a>
        </li>
    </c:if>
    <c:if test="${currentStatusId==3}">
        <li>
            <a href="/Hospital_FP/controller?command=toPatienceForDoctor"><div class="href_but green_but">All patiences</div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toDoctorsCardRecordsForDoctor"><div class="href_but green_but">My own card records</div></a>
        </li>
    </c:if>
    <c:if test="${currentStatusId==4}">
        <li>
            <a href="/Hospital_FP/controller?command=toPatienceForDoctor"><div class="href_but green_but">All patiences</div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toWaysPatiencesForDoctor"><div class="href_but green_but">My way's patiences</div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toDoctorsCardRecordsForDoctor"><div class="href_but green_but">My own card records</div></a>
        </li>
    </c:if>
    <li>
        <a href="/Hospital_FP/controller?command=logout"><div class="href_but red_but">Logout</div></a>
    </li>
</ol>
<h2>Cabinet</h2>
<hr>
<div class="content_div">
<div class="text_block"><b>S.N.P:</b> ${user.sername} ${user.name} ${user.patronymic}</div>
<div class="text_block"><b>Work:</b> ${user.work.name}</div>
<div class="text_block"><b>Birthday:</b> ${user.birthday}</div>
<div class="text_block"><b>Login:</b> ${user.login}</div> 
        <div class="not_list_button">
            <a href="cabinet/change_login.jsp"><div class="href_but blue_but">Change login</div></a>
        </div>
        <div class="not_list_button">
            <a href="cabinet/change_password.jsp"><div class="href_but blue_but">Change password</div></a>
        </div>
        
<h3>If you want to change some of your personal information - call the administrator.</h3>
</div>
</div>
</body>
</html>
