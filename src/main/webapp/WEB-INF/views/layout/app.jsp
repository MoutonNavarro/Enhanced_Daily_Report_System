<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="constants.ForwardConst" %>
<%@ page import="constants.AttributeConst" %>

<c:set var="actTop" value="${ForwardConst.ACT_TOP.getValue()}" />
<c:set var="actEmp" value="${ForwardConst.ACT_EMP.getValue()}" />
<c:set var="actRep" value="${ForwardConst.ACT_REP.getValue()}" />
<c:set var="actAuth" value="${ForwardConst.ACT_AUTH.getValue()}" />

<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commOut" value="${ForwardConst.CMD_LOGOUT.getValue()}" />

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Daily report management system</title>
		<link rel="stylesheet" href="<c:url value='/css/reset.css' />">
		<link rel="stylesheet" href="<c:url value='/css/style.css' />">
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<div id="header_menu">
					<H1><a href="<c:url value='?action=${actTop}&command=${commIdx}' />">Daily report management system</a></H1>&nbsp;&nbsp;&nbsp;
					<c:if test="${sessionScope.login_employee != null}">
						<c:if test="${sessionScope.login_employee.adminFlag == AttributeConst.ROLE_ADMIN.getIntegerValue()}">
							<a href="<c:url value='?action=${actEmp}&command=${commIdx}' />">Manage employee</a>&nbsp;
						</c:if>
						<a href="<c:url value='?action=${actRep}&command=${commIdx}' />">Manage daily report</a>&nbsp;
					</c:if>
				</div>
				<c:if test="${sessionScope.login_employee != null}">
					<div id="employee_name">
						Hi!&nbsp;
						<c:out value="${sessionScope.login_employee.name}" />
						&nbsp;&nbsp;&nbsp;
						<a href="<c:url value='?action=${actAuth}&command=${commOut}' />">Logout</a>
					</div>
				</c:if>
			</div>
			<div id="content">${param.content}</div>
			<c:if test="${sessionScope.login_employee.adminFlag == AttributeConst.ROLE_ADMIN.getIntegerValue()}">
				<div id="debug_area">
					<p><a href="#" onclick="openDebug();" id="debug_menu_open">Open debug menu</a></p>
<div id="debug_menu">
	<ul>
		<li>Change color</li>
		<li>Change background-color</li>
		<li>Change language</li>
		<li>Change time zone</li>
		<li>Play music</li>
	</ul>
</div>
					<script>
						document.getElementById("debug_menu").style.display="none";
						function openDebug(){
							const dm = document.getElementById("debug_menu");
							const dmo = document.getElementById("debug_menu_open");
							if(dm.style.display=="block"){
								dm.style.display = "none";
								dmo.innerText = "Open debug menu";
							}else{
								dm.style.display = "block";
								dmo.innerText = "Close debug menu";
							}
						}
					</script>
				</div>
			</c:if>
			<div id="footer">by Mouton Navarro.</div>
		</div>

	</body>
</html>