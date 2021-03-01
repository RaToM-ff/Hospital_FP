<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title>Chage works</title>
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
			<a href="/Hospital_FP/controller?command=backToCabinetCommand"><div class="href_but green_but">To the cabinet</div></a>
        </li>
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
        	<a href="/Hospital_FP/controller?command=logout"><div class="href_but red_but">Logout</div></a>
    	</li>
    </ol>
	<h2>Chage works</h2>
	<hr>
    <div class="content_div">
    	<div class="not_list_button">
    <a href="admin/add_work.jsp"><div class="href_but green_but">Create new work</div></a>
</div>
	<h3>Select work:</h3>
	<form method="POST" action="/Hospital_FP/controller">
		<input type="hidden" name="command" value="toPatienceForAdmin">
	    <select  onchange="selectWork(this.value)" >
	    	<c:forEach var="work" items="${works}">
	    		<option id="dropList${work.id}" value="${work.id}">${work.name}</option>
	    	</c:forEach>
		</select>
	</form>
	<form>
		<input type="hidden" name="command" value="changeWorkByAdmin">
		<input type="hidden" name="idWork" id="idSelectedWork" value="">
		<input type="text" disabled name="nameWork" id="nameSelectedWork" value="">
	    <input class="functional_but blue_but" type="submit" disabled id="acceptBut" value="Change">
	</form>
</div>
</div>
</body>
</html>
