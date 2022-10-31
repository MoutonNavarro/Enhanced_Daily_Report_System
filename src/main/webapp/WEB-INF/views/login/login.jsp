<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="constants.AttributeConst" %>
<%@ page import="constants.ForwardConst" %>
<%@ page import="constants.HtmlConst" %>

<c:set var="action" value="${ForwardConst.ACT_AUTH.getValue()}" />
<c:set var="command" value="${ForwardConst.CMD_LOGIN.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
   <c:param name="content">
      <c:if test="${loginError}">
         <div id="flush_error">
            ${HtmlConst.TEXT_LOGIN_ERROR.getValue(lang)}
         </div>
      </c:if>
      <c:if test="${flush != null}">
         <div id="flush_success">
            <c:out value="${flush}" />
         </div>
      </c:if>
      <H2>${HtmlConst.TEXT_LOGIN.getValue(lang)}</H2>
      <form method="POST" action="<c:url value='?action=${action}&command=${command}'/>">
         <label for="${AttributeConst.EMP_CODE.getValue()}">${HtmlConst.TEXT_EMPLOYEE_CODE.getValue(lang)}</label><br>
         <input type="text" name="${AttributeConst.EMP_CODE.getValue()}" id="${AttributeConst.EMP_CODE.getValue()}" value="${code}" />
         <br><br>

         <label for="${AttributeConst.EMP_PASS.getValue()}">${HtmlConst.TEXT_PASSWORD.getValue(lang)}</label><br>
         <input type="password" name="${AttributeConst.EMP_PASS.getValue()}" id="${AttributeConst.EMP_PASS.getValue()}" />
         <br><br>

         <input type="hidden" name="${AttributeConst.TOKEN.getValue()}" value="${_token}" />
         <button type="submit">${HtmlConst.TEXT_DO_LOGIN.getValue(lang)}</button>
      </form>
   </c:param>
</c:import>
