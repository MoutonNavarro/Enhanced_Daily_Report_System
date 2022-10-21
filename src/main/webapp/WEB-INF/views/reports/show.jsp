<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="constants.ForwardConst" %>
<%@ page import="constants.AttributeConst" %>

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
		<H2>Daily report detail page</H2>

		<table>
			<tbody<c:if test="${report.configure.user_color != ''}"> style="color:<c:out value='${report.configure.user_color}' />;"</c:if>>
				<tr>
					<th>Name</th>
					<td><c:out value="${report.employee.name}" /></td>
				</tr>
				<tr>
					<th>Date</th>
					<fmt:parseDate value="${report.reportDate}" pattern="yyyy-MM-dd" var="reportDay" type="date" />
					<td><fmt:formatDate value='${reportDay}' pattern='MM/dd/yyyy' /></td>
				</tr>
				<tr>
					<th>Content</th>
					<td><pre><c:out value="${report.content}" /></pre></td>
				</tr>
				<tr>
					<th>Date registered</th>
					<fmt:parseDate value="${report.createdAt}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="createDay" type="date" />
					<td><fmt:formatDate value="${createDay}" pattern="MM/dd/yyyy HH:mm:ss" /></td>
				</tr>
				<tr>
					<th>Date updated</th>
					<fmt:parseDate value="${report.updatedAt}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="updateDay" type="date" />
					<td><fmt:formatDate value="${updateDay}" pattern="MM/dd/yyyy HH:mm:ss" /></td>
				</tr>
			</tbody>
		</table>

		<form method="POST" action="<c:choose><c:when test='${is_clapped}'><c:url value='?action=${actClap}&command=${commUndoReact}' /></c:when><c:otherwise><c:url value='?action=${actClap}&command=${commDoReact}' /></c:otherwise></c:choose>">
			<input type="hidden" name="${AttributeConst.REP_ID.getValue()}" value="${report.id}" />
			<input type="hidden" name="${AttributeConst.TOKEN.getValue()}" value="${_token}" />
			<button type="submit"><c:choose><c:when test='${is_clapped}'>You clapped</c:when><c:otherwise>Clap</c:otherwise></c:choose> (${clap_count})</button>
		</form>
		<c:if test="${clap_count > 0}">
			<p>Clappes:&nbsp;
			<c:forEach var="clap" items="${claps}">
				[${clap.employee_name}]&nbsp;&nbsp;
			</c:forEach></p>
		</c:if>
		<c:if test="${sessionScope.login_employee.id == report.employee.id}">
			<p>
				<a href="<c:url value='?action=${actRep}&command=${commEdt}&id=${report.id}' />">Edit this report</a>
			</p>
		</c:if>

		<p>
			<a href="<c:url value='?action=${actRep}&command=${commIdx}' />">Back to the list</a>
		</p>
	</c:param>
</c:import>
