<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="constants.ForwardConst" %>
<%@ page import="constants.AttributeConst" %>

<c:set var="actTop" value="${ForwardConst.ACT_TOP.getValue()}" />
<c:set var="actEmp" value="${ForwardConst.ACT_EMP.getValue()}" />
<c:set var="actRep" value="${ForwardConst.ACT_REP.getValue()}" />
<c:set var="actAuth" value="${ForwardConst.ACT_AUTH.getValue()}" />
<c:set var="actConf" value="${ForwardConst.ACT_CONFIG.getValue()}" />

<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commOut" value="${ForwardConst.CMD_LOGOUT.getValue()}" />
<c:set var="commEdt" value="${ForwardConst.CMD_EDIT.getValue()}" />

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Daily report management system</title>
		<link rel="stylesheet" href="<c:url value='/css/reset.css' />">
		<link rel="stylesheet" href="<c:url value='/css/style.css' />">
		<c:if test="${sessionScope.login_employee.adminFlag == AttributeConst.ROLE_ADMIN.getIntegerValue()}">	<style type="text/css"><c:import url="/WEB-INF/debug/debug.css" /></style></c:if>

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
				<c:import url="/WEB-INF/debug/_main.jsp" />
			</c:if>
			<div id="footer">by Mouton Navarro.</div>
			<a href="<c:url value='?action=${actConf}&command=${commEdt}' />" >Setting</a>
			<c:if test="${sessionScope.configure != null}">
				<p>Your current configure</p>
				<ul>
					<li>Foreground color: <c:out value="${sessionScope.configure.user_color}" /></li>
					<li>Background colour: <c:out value="${sessionScope.configure.user_background}" /></li>
					<li>Language: <c:out value="${sessionScope.configure.language}" /></li>
					<c:if test="false"><li>time zone: <c:out value="${sessionScope.configure.time_zone}" /></li></c:if>
				</ul>
			</c:if>
		</div>

	</body>
</html>