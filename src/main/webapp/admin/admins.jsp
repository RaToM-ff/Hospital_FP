<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename='property'/>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title><fmt:message key='ALL_ADMINS_UPPER_F'/></title>
    <script type="text/javascript" src="usable/js/selector.js"></script>
    <link rel="stylesheet" href="usable/css/mainStyle.css">
</head>
<body id="main_body" hidden>
	<div class="main_div">
		<ol>
		<li>
			<a href="/Hospital_FP/controller?command=backToCabinetCommand"><div class="href_but green_but"><fmt:message key='TO_THE_CABINET'/></div></a>
        </li>
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
            <a href="/Hospital_FP/controller?command=toWorksForAdmin"><div class="href_but green_but"><fmt:message key='CHENGE_OR_ADD_WORK'/></div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=logout"><div class="href_but red_but"><fmt:message key='LOGOUT'/></div></a>
        </li>
    </ol>
	<h2><fmt:message key='ALL_ADMINS_UPPER_F'/></h2>
	<div style="text-align: right;">
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=ru_RU">RU</a>
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=en_US">EN</a>
    </div>
	<hr>
	<h3><fmt:message key='LIST_OF_AFMINS'/></h3>
	<div class="not_list_button">
    	<a href="/Hospital_FP/controller?command=toAddNewUserForAdmin&statusAddUser=1"><div class="href_but blue_but"><fmt:message key='CREATE_NEW_ADMIN'/></div></a>
    </div>
	<form method="POST" action="/Hospital_FP/controller">
		<input type="hidden" name="command" value="toAdminsForAdmin">
		<p><b><fmt:message key='SORTED_BY'/>:</b>
	    <select name="filter" id="filter" filterValue="${filter}" onchange="form.submit();">
	  		<option id="filter_sername" value="sername"><fmt:message key='ALPHABET'/></option>
	  		<option id="filter_birthday" value="birthday"><fmt:message key='BIRTHDAY_UPPER_F'/></option>
		</select>
		</p>
	</form>

	<table border="1">
	    <tr>
	        <td><fmt:message key='SNP'/></td>
	        <td><fmt:message key='BIRTHDAY_UPPER_F'/></td>
	        <td><fmt:message key='TO_DO'/></td>
	    </tr>
	    <c:forEach var="admin" items="${admins}">
	        <tr>
	            <td>${admin.sername} ${admin.name} ${admin.patronymic}</td>
	            <td>${admin.birthday}</td>
	            <td>
	            	<form method="POST" action="/Hospital_FP/controller">
	    				<input type="hidden" name="command" value="toChangeUserForAdmin">
	    				<input type="hidden" name="changeUserId" value="${admin.id}">
	            		<input type="submit" class="table_but blue_but" value="<fmt:message key='EDIT_OR_DELETE_USER'/>">
	            	</form>
	            </td>
	        </tr>
	    </c:forEach>
	</table>
</body>
</html>
