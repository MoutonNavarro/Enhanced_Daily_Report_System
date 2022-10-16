<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="constants.ForwardConst" %>
<%@ page import="constants.AttributeConst" %>
<%@ page import="colors.ColorNameEnum" %>

<c:set var="action" value="${ForwardConst.ACT_CONFIG.getValue()}" />
<c:set var="actTop" value="${ForwardConst.ACT_TOP.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commUpd" value="${ForwardConst.CMD_UPDATE.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
	<c:param name="content">
		<H2>Setting page</H2>
		<form method="POST"
			action="<c:url value='?action=${action}&command=${commUpd}' />">

<label for="${AttributeConst.CONFIG_COLOR.getValue()}">Foreground color</label><br>
<select name="${AttributeConst.CONFIG_COLOR.getValue()}" id="${AttributeConst.CONFIG_COLOR.getValue()}" >
	<option value="${ColorNameEnum.DEFAULT.getName()}"<c:if test="${configure.user_color == ColorNameEnum.DEFAULT.getName()}"> selected</c:if>>${ColorNameEnum.DEFAULT.getName()}</option>
	<option value="${ColorNameEnum.PINK.getName()}" style="color:${ColorNameEnum.PINK.getCode()};"<c:if test="${configure.user_color == ColorNameEnum.PINK.getName()}"> selected</c:if>>${ColorNameEnum.PINK.getName()}</option>
	<option value="${ColorNameEnum.YELLOW.getName()}" style="color:${ColorNameEnum.YELLOW.getCode()};"<c:if test="${configure.user_color == ColorNameEnum.YELLOW.getName()}"> selected</c:if>>${ColorNameEnum.YELLOW.getName()}</option>
	<option value="${ColorNameEnum.GREEN.getName()}" style="color:${ColorNameEnum.GREEN.getCode()};"<c:if test="${configure.user_color == ColorNameEnum.GREEN.getName()}"> selected</c:if>>${ColorNameEnum.GREEN.getName()}</option>
	<option value="${ColorNameEnum.BLUE.getName()}" style="color:${ColorNameEnum.BLUE.getCode()};"<c:if test="${configure.user_color == ColorNameEnum.BLUE.getName()}"> selected</c:if>>${ColorNameEnum.BLUE.getName()}</option>
	<option value="${ColorNameEnum.RED.getName()}" style="color:${ColorNameEnum.RED.getCode()};"<c:if test="${configure.user_color == ColorNameEnum.RED.getName()}"> selected</c:if>>${ColorNameEnum.RED.getName()}</option>
	<option value="${ColorNameEnum.BLACK.getName()}" style="color:${ColorNameEnum.BLACK.getCode()};"<c:if test="${configure.user_color == ColorNameEnum.BLACK.getName()}"> selected</c:if>>${ColorNameEnum.BLACK.getName()}</option>
	<option value="${ColorNameEnum.SIBUYAS.getName()}" style="color:${ColorNameEnum.SIBUYAS.getCode()};"<c:if test="${configure.user_color == ColorNameEnum.SIBUYAS.getName()}"> selected</c:if>>${ColorNameEnum.SIBUYAS.getName()}</option>
	<option value="${ColorNameEnum.BERDE.getName()}" style="color:${ColorNameEnum.BERDE.getCode()};"<c:if test="${configure.user_color == ColorNameEnum.BERDE.getName()}"> selected</c:if>>${ColorNameEnum.BERDE.getName()}</option>
	<option value="${ColorNameEnum.ASUL.getName()}" style="color:${ColorNameEnum.ASUL.getCode()};"<c:if test="${configure.user_color == ColorNameEnum.ASUL.getName()}"> selected</c:if>>${ColorNameEnum.ASUL.getName()}</option>
	<option value="${ColorNameEnum.KULAY_ROSAS.getName()}" style="color:${ColorNameEnum.KULAY_ROSAS.getCode()};"<c:if test="${configure.user_color == ColorNameEnum.KULAY_ROSAS.getName()}"> selected</c:if>>${ColorNameEnum.KULAY_ROSAS.getName()}</option>
	<option value="${ColorNameEnum.KULAY_UBE.getName()}" style="color:${ColorNameEnum.KULAY_UBE.getCode()};"<c:if test="${configure.user_color == ColorNameEnum.KULAY_UBE.getName()}"> selected</c:if>>${ColorNameEnum.KULAY_UBE.getName()}</option>
</select>
<br><br>

<input type="hidden" name="${AttributeConst.TOKEN.getValue()}" value="${_token}" />
<button type="submit">Submit</button>		</form>

		<p>
			<a href="<c:url value='?action=${actTop}&command=${commIdx}' />">Go to top page</a>
		</p>
	</c:param>
</c:import>