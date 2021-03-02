<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename='property'/>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title><fmt:message key='CHANGE_WORKS'/></title>
    <link rel="stylesheet" href="usable/css/mainStyle.css">
    <script type="text/javascript">
		function selectWork(value) {
			let name = document.getElementById('dropList'+value).innerHTML;
			document.getElementById('idSelectedWork').value = value;
			document.getElementById('nameSelectedWork').value = name;
			document.getElementById('nameSelectedWork').disabled = false;
			document.getElementById('acceptBut').disabled = false;
		};
	</script>
</head>
<body>
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
            <a href="/Hospital_FP/controller?command=toAdminsForAdmin"><div class="href_but green_but"><fmt:message key='ALL_ADMINS'/></div></a>
        </li>
        <li>
        	<a href="/Hospital_FP/controller?command=logout"><div class="href_but red_but"><fmt:message key='LOGOUT'/></div></a>
    	</li>
    </ol>
	<h2><fmt:message key='CHANGE_WORK'/></h2>
	<div style="text-align: right;">
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=ru_RU">RU</a>
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=en_US">EN</a>
    </div>
	<hr>
    <div class="content_div">
    	<div class="not_list_button">
    <a href="admin/add_work.jsp"><div class="href_but green_but"><fmt:message key='CREATE_NEW_WORK'/></div></a>
</div>
	<h3><fmt:message key='SELECT_WORK'/>:</h3>
	<form method="POST" action="/Hospital_FP/controller">
		<input type="hidden" name="command" value="toPatienceForAdmin">
	    <select  onchange="selectWork(this.value)" >
	    	<c:forEach var="work" items="${works}">
	    		<option id="dropList${work.id}" value="${work.id}">${work.name}</option>
	    	</c:forEach>
		</select>
	</form>
	<br>
	<form>
		<input type="hidden" name="command" value="changeWorkByAdmin">
		<input type="hidden" name="idWork" id="idSelectedWork" value="">
		<input type="text" disabled name="nameWork" id="nameSelectedWork" value=""><div class="error_field">${errors.work_name}</div>
		<br>
	    <input class="functional_but blue_but" type="submit" disabled id="acceptBut" value="Change">
	</form>
</div>
</div>
</body>
</html>
