<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="constants.AttributeConst" %>
<%@ page import="constants.HtmlConst" %>

<c:if test="${errors != null}">
	<div id="flush_error">
		${HtmlConst.TEXT_FORM_ERR.getValue(lang)}<br>
		<c:forEach var="error" items="${errors}">
			*<c:out value="${error}" /><br>
		</c:forEach>
	</div>
</c:if>
<fmt:parseDate value="${report.reportDate}" pattern="yyyy-MM-dd" var="reportDay" type="date" />
<label for="${AttributeConst.REP_DATE.getValue()}">${HtmlConst.TEXT_DATE.getValue(lang)}</label><br>
<input type="date" name="${AttributeConst.REP_DATE.getValue()}" id="${AttributeConst.REP_DATE.getValue()}" value="<fmt:formatDate value='${reportDay}' pattern='yyyy-MM-dd' />" />
<br><br>

<label>${HtmlConst.TEXT_NAME.getValue(lang)}</label><br>
<c:out value="${sessionScope.login_employee.name}" />
<br><br>

<label for="${AttributeConst.REP_TITLE.getValue()}">${HtmlConst.TEXT_TITLE.getValue(lang)}</label><br>
<input type="text" name="${AttributeConst.REP_TITLE.getValue()}" id="${AttributeConst.REP_TITLE.getValue()}" value="${report.title}" />
<br><br>

<label for="${AttributeConst.REP_CONTENT.getValue()}">${HtmlConst.TEXT_CONTENT.getValue(lang)}</label><br>
<textarea name="${AttributeConst.REP_CONTENT.getValue()}" id="${AttributeConst.REP_CONTENT.getValue()}" rows="10" cols="50">${report.content}</textarea>
<br><br>
<input type="hidden" name="${AttributeConst.REP_ID.getValue()}" value="${report.id}" />
<input type="hidden" name="${AttributeConst.TOKEN.getValue()}" value="${_token}" />
<button type="submit">${HtmlConst.TEXT_SUBMIT.getValue(lang)}</button>