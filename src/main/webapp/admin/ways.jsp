<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename='property'/>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title><fmt:message key='ALL_WAYS'/></title>
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
			<a href="/Hospital_FP/controller?command=backToCabinetCommand"><div class="href_but green_but"><fmt:message key='TO_THE_CABINET'/></div></a>
        </li>
		<li>
            <a href="/Hospital_FP/controller?command=toPatienceForAdmin"><div class="href_but green_but"><fmt:message key='ALL_PATIENCES'/></div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toDoctorsAndNursesForAdmin"><div class="href_but green_but"><fmt:message key='ALL_DOCTORS_AND_NURSES'/></div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toAdminsForAdmin"><div class="href_but green_but"><fmt:message key='ALL_ADMINS'/></div></a>
        </li>
        <li>
            <a href="/Hospital_FP/controller?command=toWorksForAdmin"><div class="href_but green_but"><fmt:message key='CHENGE_OR_ADD_WORK'/></div></a>
        </li>
        <li>
        	<a href="/Hospital_FP/controller?command=logout"><div class="href_but red_but"><fmt:message key='LOGOUT'/></div></a>
    	</li>
    </ol>
	<h2><fmt:message key='ALL_WAYS'/></h2>
	<div style="text-align: right;">
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=ru_RU">RU</a>
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=en_US">EN</a>
    </div>
	<hr>
	<div class="content_div" style="width: 85%">
	<h3><fmt:message key='LIST_OF_WAYS'/></h3>
    <form method="POST" action="/Hospital_FP/controller">
		<input type="hidden" name="command" value="toWaysForAdmin">
		<p><b><fmt:message key='SORTED_BY'/>:</b>
		    <select  class="href_but red_but" class="href_but red_but" name="filter" id="filter" filterValue="${filter}" onchange="form.submit();">
		  		<option id="filter_doctorsSername" value="doctorsSername"><fmt:message key='DOCTORS_ALPHABET'/></option>
		  		<option id="filter_patiencesSername" value="patiencesSername"><fmt:message key='PATIENCES_ALPHABET'/></option>
		  		<option id="filter_work_name" value="work_name"><fmt:message key='PROFESSION'/></option>
		  		<option id="filter_date_come" value="date_come"><fmt:message key='DATE_OF_COME'/></option>
		  		<option id="filter_date_out" value="date_out"><fmt:message key='DATE_OF_OUT'/></option>
			</select>
	    </p>
	</form>
	<table>
	    <tr>
	        <td><fmt:message key='PATIENCES_SNP'/></td>
	        <td><fmt:message key='DOCTORS_SNP'/></td>
	        <td><fmt:message key='PROFESSION'/></td>
	        <td><fmt:message key='DIAGNOSIS'/></td>
	        <td><fmt:message key='DOCUMENT'/></td>
	        <td><fmt:message key='DATE_OF_COME'/></td>
	        <td><fmt:message key='DATE_OF_OUT'/></td>
	        <td><fmt:message key='TO_DO'/></td>
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
            			<a href="${way.documentWay}" target="_blank"><div class="table_but blue_but"><fmt:message key='OPEN'/></div></a>
        			</div>
        			</c:if>
    			</td>
	            <td>${way.date_come}</td>
	            <td>${way.date_out}</td>
	            <td>
	            	<form method="POST" action="/Hospital_FP/controller">
	    				<input type="hidden" name="command" value="toChangeWayForAdmin">
	    				<input type="hidden" name="changeWayId" value="${way.id}">
	            		<input type="submit" class="table_but blue_but" value="<fmt:message key='EDIT_WAY'/>">
	            	</form>
	            	<c:if test="${not empty way.date_out}">
						<form method="POST" action="/Hospital_FP/controller">
		    				<input type="hidden" name="command" value="reopenWayForAdmin">
		    				<p><fmt:message key='REOPEN'/>:
		    				<input type="hidden" name="reopenWayId" value="${way.id}">
		    				<input type="checkbox"  onchange="butVisForReopen(this.checked, ${way.id})" />
		            		</p>
		            		<input type="hidden" class="table_but red_but" id="reopenWay${way.id}" value="<fmt:message key='REOPEN'/>">
		            	</form>
					</c:if>
					<c:if test="${empty way.date_out}">
						<form method="POST" action="/Hospital_FP/controller">
		    				<input type="hidden" name="command" value="deleteWayForAdmin">
		    				<p><fmt:message key='DELETE'/>:
		    				<input type="hidden" name="deleteWayId" value="${way.id}">
		    				<input type="checkbox"  onchange="butVisForDelete(this.checked, ${way.id})" />
		            		</p>
		            		<input type="hidden" class="table_but red_but" id="deleteWay${way.id}" value="<fmt:message key='DELETE'/>">
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
