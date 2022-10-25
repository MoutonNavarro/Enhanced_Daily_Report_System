<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="constants.ForwardConst" %>
<%@ page import="constants.AttributeConst" %>
<%@ page import="constants.HtmlConst" %>

<c:set var="action" value="${ForwardConst.ACT_EMP.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commUpd" value="${ForwardConst.CMD_UPDATE.getValue()}" />
<c:set var="commDel" value="${ForwardConst.CMD_DESTROY.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
	<c:param name="content">
		<H2>${HtmlConst.TEXT_EMP_EDIT_PAGE_L.getValue(lang)}${employee.id}${HtmlConst.TEXT_EMP_EDIT_PAGE_R.getValue(lang)}</H2>
		<p>${HtmlConst.TEXT_EMP_EDIT_NOTE_PASSWORD.getValue(lang)}</p>
		<form method="POST"
			action="<c:url value='?action=${action}&command=${commUpd}' />">
			<c:import url="_form.jsp" />
		</form>

		<p>
			<a href="#" onclick="confirmDestroy();">${HtmlConst.TEXT_EMP_DELETE.getValue(lang)}</a>
		</p>
		<form method="POST"
			action="<c:url value='?action=${action}&command=${commDel}' />">
			<input type="hidden" name="${AttributeConst.EMP_ID.getValue()}" value="${employee.id}" />
			<input type="hidden" name="${AttributeConst.TOKEN.getValue()}" value="${_token}" />
		</form>
		<script>
		var message = "<%= constants.HtmlConst.TEXT_EMP_DELETE_CONFIRM.getValue((constants.LanguageClassConst)request.getSession().getAttribute("lang")) %>"
			function confirmDestroy(){
				if (confirm(message)){
					document.forms[1].submit();
				}
			}
		</script>

		<p>
			<a href="<c:url value='?action=${action}&command=${commIdx}' />">${HtmlConst.TEXT_EMP_BACK_LIST.getValue(lang)}</a>
		</p>
	</c:param>
</c:import>