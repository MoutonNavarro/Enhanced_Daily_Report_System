<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="constants.ForwardConst" %>
<%@ page import="constants.AttributeConst" %>
<%@ page import="constants.HtmlConst" %>
<%@ page import="constants.FormatConst" %>

<c:set var="actEmp" value="${ForwardConst.ACT_EMP.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commEdit" value="${ForwardConst.CMD_EDIT.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
	<c:param name="content">
		<H2>${HtmlConst.TEXT_EMP_SHOW_PAGE_L.getValue(lang)}${employee.id}${HtmlConst.TEXT_EMP_SHOW_PAGE_R.getValue(lang)}</H2>

		<table>
			<tbody>
				<tr>
					<th>${HtmlConst.TEXT_EMPLOYEE_CODE.getValue(lang)}</th>
					<td><c:out value="${employee.code}" /></td>
				</tr>
				<tr>
					<th>${HtmlConst.TEXT_NAME.getValue(lang)}</th>
					<td><c:out value="${employee.name}" /></td>
				</tr>
				<tr>
					<th>${HtmlConst.TEXT_PRIVILEGES.getValue(lang)}</th>
					<td><c:choose>
						<c:when test="${employee.adminFlag == AttributeConst.ROLE_ADMIN.getIntegerValue()}">${HtmlConst.TEXT_EMP_ADMIN.getValue(lang)}</c:when>
						<c:otherwise>${HtmlConst.TEXT_EMP_GENERAL.getValue(lang)}</c:otherwise>
					</c:choose></td>
				</tr>
				<tr>
					<th>${HtmlConst.TEXT_DATE_REGISTERED.getValue(lang)}</th>
					<fmt:parseDate value="${employee.createdAt}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="createDay" type="date" />
					<td><fmt:formatDate value="${createDay}" pattern="${FormatConst.TIME_FORMAT.getFormat(lang)}" /></td>
				</tr>
				<tr>
					<th>${HtmlConst.TEXT_DATE_UPDATED.getValue(lang)}</th>
					<fmt:parseDate value="${employee.updatedAt}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="updateDay" type="date" />
					<td><fmt:formatDate value="${updateDay}" pattern="${FormatConst.TIME_FORMAT.getFormat(lang)}" /></td>
				</tr>
			</tbody>
		</table>

		<p>
			<a href="<c:url value='?action=${actEmp}&command=${commEdit}&id=${employee.id}' />">${HtmlConst.TEXT_EMP_EDIT.getValue(lang)}</a>
		</p>

		<p>
			<a href="<c:url value='?action=${actEmp}&command=${commIdx}' />">Back to list</a>
		</p>
	</c:param>
</c:import>