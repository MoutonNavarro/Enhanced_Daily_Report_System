<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="constants.ForwardConst" %>
<%@ page import="constants.AttributeConst" %>

<c:set var="action" value="${ForwardConst.ACT_EMP.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commUpd" value="${ForwardConst.CMD_UPDATE.getValue()}" />
<c:set var="commDel" value="${ForwardConst.CMD_DESTROY.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
	<c:param name="content">
		<H2>ID: ${employee.id}'s employee information edit page</H2>
		<p>(Please input password only when you change it)</p>
		<form method="POST"
			action="<c:url value='?action=${action}&command=${commUpd}' />">
			<c:import url="_form.jsp" />
		</form>

		<p>
			<a href="#" onclick="confirmDestroy();">DELETE THIS EMPLOYEE INFORMATION</a>
		</p>
		<form method="POST"
			action="<c:url value='?action=${action}&command=${commDel}' />">
			<input type="hidden" name="${AttributeConst.EMP_ID.getValue()}" value="${employee.id}" />
			<input type="hidden" name="${AttributeConst.TOKEN.getValue()}" value="${_token}" />
		</form>
		<script>
			function confirmDestroy(){
				if (confirm("REALLY DELETE THIS EMPLOYEE?")){
					document.forms[1].submit();
				}
			}
		</script>

		<p>
			<a href="<c:url value='?action=${action}&command=${commIdx}}' />">Back to the list</a>
		</p>
	</c:param>
</c:import>