<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="constants.ForwardConst" %>
<%@ page import="constants.AttributeConst" %>
<%@ page import="constants.HtmlConst" %>

<c:set var="actRep" value="${ForwardConst.ACT_REP.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commEdt" value="${ForwardConst.CMD_EDIT.getValue()}" />
<c:set var="actClap" value="${ForwardConst.ACT_CLAP.getValue()}" />
<c:set var="commDoReact" value="${ForwardConst.CMD_DO_REACTION.getValue()}" />
<c:set var="commUndoReact" value="${ForwardConst.CMD_UNDO_REACTION.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
	<c:param name="content">
		<c:if test="${flush != null}">
			<div id="flush_success">
				<c:out value="${flush}" />
			</div>
		</c:if>
		<c:if test="${errors != null}">
			<div id="flush_error">
				<c:forEach var="error" items="${errors}">
					*<c:out value="${error}" /><br>
				</c:forEach>
			</div>
		</c:if>
		<H2>${HtmlConst.TEXT_REP_SHOW_PAGE.getValue(lang)}</H2>

		<table>
			<tbody<c:if test="${report.configure.user_color != ''}"> style="color:<c:out value='${report.configure.user_color}' />;"</c:if>>
				<tr>
					<th>${HtmlConst.TEXT_NAME.getValue(lang)}</th>
					<td><c:out value="${report.employee.name}" /></td>
				</tr>
				<tr>
					<th>${HtmlConst.TEXT_DATE.getValue(lang)}</th>
					<fmt:parseDate value="${report.reportDate}" pattern="yyyy-MM-dd" var="reportDay" type="date" />
					<td><fmt:formatDate value='${reportDay}' pattern='MM/dd/yyyy' /></td>
				</tr>
				<tr>
					<th>${HtmlConst.TEXT_CONTENT.getValue(lang)}</th>
					<td><pre><c:out value="${report.content}" /></pre></td>
				</tr>
				<tr>
					<th>${HtmlConst.TEXT_DATE_REGISTERED.getValue(lang)}</th>
					<fmt:parseDate value="${report.createdAt}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="createDay" type="date" />
					<td><fmt:formatDate value="${createDay}" pattern="MM/dd/yyyy HH:mm:ss" /></td>
				</tr>
				<tr>
					<th>${HtmlConst.TEXT_DATE_UPDATED.getValue(lang)}</th>
					<fmt:parseDate value="${report.updatedAt}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="updateDay" type="date" />
					<td><fmt:formatDate value="${updateDay}" pattern="MM/dd/yyyy HH:mm:ss" /></td>
				</tr>
			</tbody>
		</table>

		<form method="POST" action="<c:choose><c:when test='${is_clapped}'><c:url value='?action=${actClap}&command=${commUndoReact}' /></c:when><c:otherwise><c:url value='?action=${actClap}&command=${commDoReact}' /></c:otherwise></c:choose>">
			<input type="hidden" name="${AttributeConst.REP_ID.getValue()}" value="${report.id}" />
			<input type="hidden" name="${AttributeConst.TOKEN.getValue()}" value="${_token}" />
			<button type="submit"><c:choose><c:when test='${is_clapped}'>${HtmlConst.TEXT_REP_CLAPPED.getValue(lang)}</c:when><c:otherwise>${HtmlConst.TEXT_REP_CLAP.getValue(lang)}</c:otherwise></c:choose> (${clap_count})</button>
		</form>
		<c:if test="${clap_count > 0}">
			<p>${HtmlConst.TEXT_REP_CLAPPED_EMPLOYEES.getValue(lang)}
			<c:forEach var="clap" items="${claps}">
				${HtmlConst.TEXT_REP_CLAPPED_EMPLOYEE_L.getValue(lang)}${clap.employee_name}${HtmlConst.TEXT_REP_CLAPPED_EMPLOYEE_R.getValue(lang)}
			</c:forEach></p>
		</c:if>
		<c:if test="${sessionScope.login_employee.id == report.employee.id}">
			<p>
				<a href="<c:url value='?action=${actRep}&command=${commEdt}&id=${report.id}' />">${HtmlConst.TEXT_REP_EDIT.getValue(lang)}</a>
			</p>
		</c:if>

		<p>
			<a href="<c:url value='?action=${actRep}&command=${commIdx}' />">${HtmlConst.TEXT_REP_BACK_LIST.getValue(lang)}</a>
		</p>
	</c:param>
</c:import>
