<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="constants.AttributeConst" %>
<%@ page import="constants.ForwardConst" %>
<%@ page import="constants.HtmlConst" %>

<c:set var="action" value="${ForwardConst.ACT_EMP.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />

<c:if test="${errors != null}">
   <div id="flush_error">
      ${HtmlConst.TEXT_FORM_ERR.getValue(lang)}<br>
      <c:forEach var="error" items="${errors}">
         *<c:out value="${error}" /><br>
      </c:forEach>
   </div>
</c:if>

<label for="${AttributeConst.EMP_CODE.getValue()}">${HtmlConst.TEXT_EMPLOYEE_CODE.getValue(lang)}</label><br>
<input type="text" name="${AttributeConst.EMP_CODE.getValue()}" id="${AttributeConst.EMP_CODE.getValue()}" value="${employee.code}" />
<br><br>

<label for="${AttributeConst.EMP_NAME.getValue()}">${HtmlConst.TEXT_NAME.getValue(lang)}</label><br>
<input type="text" name="${AttributeConst.EMP_NAME.getValue()}" id="${AttributeConst.EMP_NAME.getValue()}" value="${employee.name}" />
<br><br>

<label for="${AttributeConst.EMP_PASS.getValue()}">${HtmlConst.TEXT_PASSWORD.getValue(lang)}</label><br>
<input type="password" name="${AttributeConst.EMP_PASS.getValue()}" id="${AttributeConst.EMP_PASS.getValue()}" />
<br><br>

<label for="${AttributeConst.EMP_ADMIN_FLG.getValue()}">${HtmlConst.TEXT_EMP_ADMIN_RIGHT.getValue(lang)}</label><br>
<select name="${AttributeConst.EMP_ADMIN_FLG.getValue()}" id="${AttributeConst.EMP_ADMIN_FLG.getValue()}">
   <c:choose>
      <c:when test="${employee.id != login_employee.id}">
         <option value="${AttributeConst.ROLE_GENERAL.getIntegerValue()}"<c:if test="${employee.adminFlag == AttributeConst.ROLE_GENERAL.getIntegerValue()}"> selected</c:if>>${HtmlConst.TEXT_EMP_GENERAL.getValue(lang)}</option>
         <option value="${AttributeConst.ROLE_ADMIN.getIntegerValue()}"<c:if test="${employee.adminFlag == AttributeConst.ROLE_ADMIN.getIntegerValue()}"> selected</c:if>>${HtmlConst.TEXT_EMP_ADMIN.getValue(lang)}</option>
      </c:when>
      <c:otherwise>
         <option value="${AttributeConst.ROLE_ADMIN.getIntegerValue()}" disabled>${HtmlConst.TEXT_EMP_GENERAL_LOCK.getValue(lang)}</option>
         <option value="${AttributeConst.ROLE_ADMIN.getIntegerValue()}" selected>${HtmlConst.TEXT_EMP_ADMIN_ONLY.getValue(lang)}</option>
      </c:otherwise>
   </c:choose>
</select>
<br><br>
<input type="hidden" name="${AttributeConst.EMP_ID.getValue()}" value="${employee.id}" />
<input type="hidden" name="${AttributeConst.TOKEN.getValue()}" value="${_token}" />
<button type="submit">${HtmlConst.TEXT_SEND.getValue(lang)}</button>
