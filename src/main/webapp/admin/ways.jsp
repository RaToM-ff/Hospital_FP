<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title>All ways</title>
    <script type="text/javascript" src="usable/js/selector.js"></script>
    <script type="text/javascript">
    	function butVisForDelete(check, id){
    		if (check) {
				document.getElementById('deleteWay'+id).type = 'submit';
    		} else {
				document.getElementById('deleteWay'+id).type = 'hidden';
    		}
    	};

    	function butVisForReopen(check, id){
    		if (check) {
				document.getElementById('reopenWay'+id).type = 'submit';
    		} else {
				document.getElementById('reopenWay'+id).type = 'hidden';
    		}
    	};
    </script>
    <link rel="stylesheet" href="usable/css/mainStyle.css">
</head>
<body id="main_body" hidden>
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
            <a href="/Hospital_FP/controller?command=toAdminsForAdmin"><div class="href_but green_but">All admins</div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toWorksForAdmin"><div class="href_but green_but">Change or add wokr</div></a>
        </li>
        <li>
        	<a href="/Hospital_FP/controller?command=logout"><div class="href_but red_but">Logout</div></a>
    	</li>
    </ol>
	<h2>All ways</h2>
	<hr>
	<div class="content_div" style="width: 85%">
	<h3>List of ways</h3>
    <form method="POST" action="/Hospital_FP/controller">
		<input type="hidden" name="command" value="toWaysForAdmin">
		<p>Sorted by:
		    <select name="filter" id="filter" filterValue="${filter}" onchange="form.submit();">
		  		<option id="filter_doctorsSername" value="doctorsSername">Doctor's alphabet</option>
		  		<option id="filter_patiencesSername" value="patiencesSername">Patience's alphabet</option>
		  		<option id="filter_work_name" value="work_name">Profession</option>
		  		<option id="filter_date_come" value="date_come">Date of come</option>
		  		<option id="filter_date_out" value="date_out">Date of out</option>
			</select>
	    </p>
	</form>
	<table>
	    <tr>
	        <td>Patience's S.N.P</td>
	        <td>Doctor's S.N.P</td>
	        <td>Profession</td>
	        <td>Diagnosis</td>
	        <td>Document</td>
	        <td>Date of come</td>
	        <td>Date of out</td>
	        <td>To do</td>
	    </tr>
	    <c:forEach var="way" items="${ways}">
	        <tr>
	            <td>${way.patience.sername} ${way.patience.name} ${way.patience.patronymic}</td>
	            <td>${way.doctor.sername} ${way.doctor.name} ${way.doctor.patronymic}</td>
	            <td>${way.doctor.work.name}</td>
	            <td>${way.diagnosis}</td>
	            <td>
	            	<c:if test="${not empty way.documentWay}">
	            	<div class="not_list_button">
            			<a href="${way.documentWay}" target="_blank"><div class="table_but blue_but">Open</div></a>
        			</div>
        			</c:if>
    			</td>
	            <td>${way.date_come}</td>
	            <td>${way.date_out}</td>
	            <td>
	            	<form method="POST" action="/Hospital_FP/controller">
	    				<input type="hidden" name="command" value="toChangeWayForAdmin">
	    				<input type="hidden" name="changeWayId" value="${way.id}">
	            		<input type="submit" class="table_but blue_but" value="Edit way">
	            	</form>
	            	<c:if test="${not empty way.date_out}">
						<form method="POST" action="/Hospital_FP/controller">
		    				<input type="hidden" name="command" value="reopenWayForAdmin">
		    				<p>Reopen:
		    				<input type="hidden" name="reopenWayId" value="${way.id}">
		    				<input type="checkbox"  onchange="butVisForReopen(this.checked, ${way.id})" />
		            		</p>
		            		<input type="hidden" class="table_but red_but" id="reopenWay${way.id}" value="Reopen">
		            	</form>
					</c:if>
					<c:if test="${empty way.date_out}">
						<form method="POST" action="/Hospital_FP/controller">
		    				<input type="hidden" name="command" value="deleteWayForAdmin">
		    				<p>Delete:
		    				<input type="hidden" name="deleteWayId" value="${way.id}">
		    				<input type="checkbox"  onchange="butVisForDelete(this.checked, ${way.id})" />
		            		</p>
		            		<input type="hidden" class="table_but red_but" id="deleteWay${way.id}" value="Delete">
		            	</form>
					</c:if>
	            </td>
	        </tr>
	    </c:forEach>
	</table>
</div>
</div>
</body>
</html>
