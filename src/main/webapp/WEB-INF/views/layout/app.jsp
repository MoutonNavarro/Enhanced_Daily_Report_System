<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="constants.ForwardConst" %>
<%@ page import="constants.AttributeConst" %>
<%@ page import="constants.HtmlConst" %>

<c:set var="actTop" value="${ForwardConst.ACT_TOP.getValue()}" />
<c:set var="actEmp" value="${ForwardConst.ACT_EMP.getValue()}" />
<c:set var="actRep" value="${ForwardConst.ACT_REP.getValue()}" />
<c:set var="actAuth" value="${ForwardConst.ACT_AUTH.getValue()}" />
<c:set var="actConf" value="${ForwardConst.ACT_CONFIG.getValue()}" />

<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commOut" value="${ForwardConst.CMD_LOGOUT.getValue()}" />
<c:set var="commEdt" value="${ForwardConst.CMD_EDIT.getValue()}" />

<!DOCTYPE html>
<html lang="${HtmlConst.HTML_LANGUAGE.getValue(lang)}">
	<head>
		<meta charset="UTF-8">
		<title>${HtmlConst.TEXT_HEAD_DAILY_TITLE.getValue(lang)}</title>
		<link rel="stylesheet" href="<c:url value='/css/reset.css' />">
		<link rel="stylesheet" href="<c:url value='/css/style.css' />">
		<c:if test="${sessionScope.login_employee.adminFlag == AttributeConst.ROLE_ADMIN.getIntegerValue()}">	<style type="text/css"><c:import url="/WEB-INF/debug/debug.css" /></style></c:if>

	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<div id="header_menu">
					<H1><a href="<c:url value='?action=${actTop}&command=${commIdx}' />">${HtmlConst.TEXT_HEAD_DAILY.getValue(lang)}</a></H1>&nbsp;&nbsp;&nbsp;
					<c:if test="${sessionScope.login_employee != null}">
						<c:if test="${sessionScope.login_employee.adminFlag == AttributeConst.ROLE_ADMIN.getIntegerValue()}">
							<a href="<c:url value='?action=${actEmp}&command=${commIdx}' />">${HtmlConst.TEXT_HEAD_MNGEMP.getValue(lang)}</a>&nbsp;
						</c:if>
						<a href="<c:url value='?action=${actRep}&command=${commIdx}' />">${HtmlConst.TEXT_HEAD_MNGREP.getValue(lang)}</a>&nbsp;
					</c:if>
				</div>
				<c:if test="${sessionScope.login_employee != null}">
					<div id="employee_name">
						${HtmlConst.TEXT_HEAD_USERNAME_L.getValue(lang)}
						<c:out value="${sessionScope.login_employee.name}" />
						${HtmlConst.TEXT_HEAD_USERNAME_R.getValue(lang)}
						<a href="<c:url value='?action=${actConf}&command=${commEdt}' />">${HtmlConst.TEXT_HEAD_SETTING.getValue(lang)}</a>&nbsp;&nbsp;&nbsp;
						<a href="<c:url value='?action=${actAuth}&command=${commOut}' />">${HtmlConst.TEXT_HEAD_LOGOUT.getValue(lang)}</a>
					</div>
				</c:if>
			</div>
			<div id="content">${param.content}</div>
			<c:if test="${sessionScope.login_employee.adminFlag == AttributeConst.ROLE_ADMIN.getIntegerValue()}">
				<c:import url="/WEB-INF/debug/_main.jsp" />
			</c:if>
			<div id="footer">by Mouton Navarro.</div>
			<c:if test="${sessionScope.login_employee.adminFlag == AttributeConst.ROLE_ADMIN.getIntegerValue()}">
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
			</c:if>
		</div>

	</body>
</html>