<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="constants.ForwardConst" %>
<%@ page import="constants.AttributeConst" %>

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
<input type="text" name="${AttributeConst.CONFIG_COLOR.getValue()}" id="${AttributeConst.CONFIG_COLOR.getValue()}" value="${configure.color}" />
<br><br>

<label for="${AttributeConst.CONFIG_BG.getValue()}">Background colour</label><br>
<input type="text" name="${AttributeConst.CONFIG_BG.getValue()}" id="${AttributeConst.CONFIG_BG.getValue()}" value="${configure.backgroundColor}" />
<br><br>

<label for="${AttributeConst.CONFIG_LANGUAGE.getValue()}">Language</label><br>
<input type="text" name="${AttributeConst.CONFIG_LANGUAGE.getValue()}" id="${AttributeConst.CONFIG_LANGUAGE.getValue()}" value="${configure.language}" />
<br><br>

<input type="hidden" name="${AttributeConst.CONFIG_TIMEZONE.getValue()}" value="${configure.timezone}" />

<input type="hidden" name="${AttributeConst.TOKEN.getValue()}" value="${_token}" />
<button type="submit">Submit</button>		</form>

		<p>
			<a href="<c:url value='?action=${actTop}&command=${commIdx}}' />">Go to top page</a>
		</p>
	</c:param>
</c:import>