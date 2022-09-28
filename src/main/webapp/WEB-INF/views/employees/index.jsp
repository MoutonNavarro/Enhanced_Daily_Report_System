<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="constants.AttributeConst" %>
<%@ page import="constants.ForwardConst" %>

<c:set var="actEmp" value="${ForwardConst.ACT_EMP.getValue()}" />
<c:set var="commShow" value="${ForwardConst.CMD_SHOW.getValue()}" />
<c:set var="commNew" value="${ForwardConst.CMD_NEW.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />

<c:import url="../layout/app.jsp">
	<c:param name="content">
		<c:if test="${flush != null}">
			<div id="flush_success">
				<c:out value="${flush}" />
			</div>
		</c:if>
		<H2>Employee list</H2>
		<table id="employee_list">
			<tbody>
				<tr>
					<th>Employee code</th>
					<th>Name</th>
					<th>Operation</th>
				</tr>
				<c:forEach var="employee" items="${employees}" varStatus="status">
					<tr class="row${status.count % 2}">
						<td><c:out value="${employee.code}" /></td>
						<td><c:out value="${employee.name}" /></td>
						<td>
							<c:choose>
								<c:when test="${employee.deleteFlag == AttributeConst.DEL_FLAG_TRUE.getIntegerValue()}">
								(Terminated)</c:when>
								<c:otherwise>
									<a href="<c:url value='?action=${actEmp}&command=${commShow}&id=${employee.id}' />">Show detail</a>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div id="pagination">
			(All: ${employees_count})<br>
			<c:choose>
				<c:when test="${i == page}">
					<c:out value="${i}" />&nbsp;
				</c:when>
				<c:otherwise>
					<a href="<c:url value='?action=${actEmp}&command=${commIdx}&page=${i}'/>"><c:out value="${i}" /></a>&nbsp;
				</c:otherwise>
			</c:choose>
		</div>
		<p><a href="<c:url value='?action=${actEmp}&command=${commNew}' />">Register new employee</a>
	</c:param>
</c:import>