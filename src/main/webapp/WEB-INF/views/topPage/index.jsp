<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="constants.ForwardConst" %>
<%@ page import="constants.HtmlConst" %>
<%@ page import="constants.FormatConst" %>

<c:set var="actTop" value="${ForwardConst.ACT_TOP.getValue()}" />
<c:set var="actEmp" value="${ForwardConst.ACT_EMP.getValue()}" />
<c:set var="actRep" value="${ForwardConst.ACT_REP.getValue()}" />

<c:set var="commShow" value="${ForwardConst.CMD_SHOW.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commNew" value="${ForwardConst.CMD_NEW.getValue()}" />

<c:import url="../layout/app.jsp">
	<c:param name="content">
		<c:if test="${flush != null}">
			<div id="flush_success">
				<c:out value="${flush}" />
			</div>
		</c:if>
		<H2>${HtmlConst.TEXT_HEAD_DAILY.getValue(lang)}</H2>
		<H3>${HtmlConst.TEXT_REP_MINE.getValue(lang)}</H3>
		<table id="report_list">
			<tbody>
				<tr>
					<th class="report_name">${HtmlConst.TEXT_NAME.getValue(lang)}</th>
					<th class="report_date">${HtmlConst.TEXT_DATE.getValue(lang)}</th>
					<th class="report_title">${HtmlConst.TEXT_TITLE.getValue(lang)}</th>
					<th class="report_action">${HtmlConst.TEXT_ACTION.getValue(lang)}</th>
				</tr>
				<c:forEach var="report" items="${reports}" varStatus="status">
					<fmt:parseDate value="${report.reportDate}" pattern="yyyy-MM-dd" var="reportDay" type="date" />
					<tr class="row${status.count % 2}"<c:if test="${report.configure.user_color != ''}"> style="color:<c:out value='${report.configure.user_color}' />;"</c:if>>
						<td class="report_name"><c:out value="${report.employee.name}" /></td>
						<td class="report_date"><fmt:formatDate value="${reportDay}" pattern="${FormatConst.DATE_FORMAT.getFormat(lang)}" /></td>
						<td class="report_title">${report.title}</td>
						<td class="report_action"><a href="<c:url value='?action=${actRep}&command=${commShow}&id=${report.id}' />">${HtmlConst.TEXT_SEEDETAIL.getValue(lang)}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div id="pagination">
			${HtmlConst.TEXT_REP_NUMBER_OF_ALL_ITEMS_L.getValue(lang)}${reports_count}${HtmlConst.TEXT_REP_NUMBER_OF_ALL_ITEMS_R.getValue(lang)}<br>
			<c:forEach var="i" begin="1" end="${((reports_count - 1) / maxRow) + 1}" step="1">
				<c:choose>
					<c:when test="${i == page}">
						<c:out value="${i}" />&nbsp;
					</c:when>
					<c:otherwise>
						<a href="<c:url value='?action=${actTop}&command=${commIdx}&page=${i}' />"><c:out value="${i}" /></a>&nbsp;
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
		<p><a href="<c:url value='?action=${actRep}&command=${commNew}' />">${HtmlConst.TEXT_REP_SUBMIT_NEW.getValue(lang)}</a></p>
	</c:param>
</c:import>