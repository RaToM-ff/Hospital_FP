<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename='property'/>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title><fmt:message key='CHANGE_WAY'/></title>
    <link rel="stylesheet" href="usable/css/mainStyle.css">
    <script type="text/javascript">
        window.onload = function() {
            if (document.getElementById("dropListPatience"+'${way.patience.id}')!=null) {
                document.getElementById("dropListPatience"+'${way.patience.id}').selected = "selected";
            document.getElementById("dropListDoctor"+'${way.doctor.id}').selected = "selected";
        }
            document.getElementById("main_body").removeAttribute("hidden");
        };
    </script>
</head>
<body id="main_body" hidden>
<div class="main_div">
    <div class="not_list_button">
        <a href="/Hospital_FP/controller?command=toWaysForAdmin"><div class="href_but red_but"><fmt:message key='BACK_UPPER_F'/></div></a>
    </div>
<h2><fmt:message key=''/>Change way</h2>
<div style="text-align: right;">
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=ru_RU">RU</a>
        <a class="href_but blue_but" href="/Hospital_FP/controller?command=changeLanguage&setLanguage=en_US">EN</a>
    </div>
<hr>
<div class="content_div">
<h3><fmt:message key='CHANGE_DATA'/>:</h3>
<form method="POST" action="/Hospital_FP/controller" enctype="multipart/form-data">
		<input type="hidden" name="command" value="changeWayForAdmin">
        <input type="hidden" name="changeWayId" value="${way.id}">
	<div class="text_block"><p><b><fmt:message key=''/>Patience:</b>
        <c:if test="${empty way.date_out}">
        </p>
            <select name="patienceChangeWay" size="7">
                <c:forEach var="patience" items="${patiences}">
                    <option id="dropListPatience${patience.id}" value="${patience.id}">${patience.sername} ${patience.name} ${patience.patronymic}</option>
                </c:forEach>
            </select>
        </c:if>
        <c:if test="${not empty way.date_out}">
            ${way.patience.sername} ${way.patience.name} ${way.patience.patronymic}</p>
        </c:if>
        </div>
	<div class="text_block">
        <p><b><fmt:message key='DOCTOR'/>:</b>
		<c:if test="${empty way.date_out}">
        </p>
        <select name="doctorChangeWay"  size="7">
                <c:forEach var="doctor" items="${doctors}">
                    <option id="dropListDoctor${doctor.id}" value="${doctor.id}"> ${doctor.work.name}: ${doctor.sername} ${doctor.name} ${doctor.patronymic}</option>
                </c:forEach>
            </select>
        </c:if>
        <c:if test="${not empty way.date_out}">
            ${way.doctor.work.name}: ${way.doctor.sername} ${way.doctor.name} ${way.doctor.patronymic}</p>
        </c:if>
    </div>
    <div class="text_block">
        <p><b><fmt:message key='DATE_OF_COME'/>:</b>
        <c:if test="${empty way.date_out}">
        </p>
            <input type="date" id="start" name="dateComeChangeWay" value="${way.date_come}" min="1910-01-01" max="${dateToday}"><div class="error_field">${errors.date_come}</div>
        </c:if>
        <c:if test="${not empty way.date_out}">
            ${way.date_come}</p>
        </c:if>
    </div>

    <c:if test="${not empty way.date_out}">
    <div class="text_block">
        <input type="hidden" name="changeFinishFlag" value="true">
        <p><b><fmt:message key='DIAGNOSIS'/>:</b></p>
            <input type="textbox" name="diagnosisChangeWay" value="${way.diagnosis}"><div class="error_field">${errors.diagnosis}</div>
        <p><b><fmt:message key='DOCUMENT'/>:</b></p>
        <div class="not_list_button">
            <a href="${way.documentWay}" target="_blank"><div class="href_but blue_but"><fmt:message key='OPEN_FILE'/></div></a>
        </div>
            <input type="hidden" id="fileFlag" name="fileWasUploading" value="no">
            <div class="not_list_button">
            <input type="file" class="href_but blue_but" name="documentWayUpload" onchange="if(this.value==''){document.getElementById('fileFlag').value = 'no'} else {document.getElementById('fileFlag').value = 'yes'}" accept=".pdf" size="50" value="" /></div><div class="error_field">${errors.document_way}</div>
        <p><b><fmt:message key='DATE_OF_OUT'/>:</b></p>
            <input type="date" id="start" name="dateOutChangeWay" value="${way.date_out}" min="${way.date_come}" max="${dateToday}"><div class="error_field">${errors.date_out}</div>
    </div>
    </c:if>
	    <input class="functional_but blue_but" type="submit" value="Change">
</form>
</div>
</div>
</body>
</html>