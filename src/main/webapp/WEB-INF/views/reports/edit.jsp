<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="constants.ForwardConst" %>
<%@ page import="constants.HtmlConst" %>

<c:set var="actRep" value="${ForwardConst.ACT_REP.getValue()}" />
<c:set var="commUpd" value="${ForwardConst.CMD_UPDATE.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
   <c:param name="content">
      <H2>${HtmlConst.TEXT_REP_EDIT_PAGE.getValue(lang)}</H2>
      <form method="POST" action="<c:url value='?action=${actRep}&command=${commUpd}' />">
         <c:import url="_form.jsp" />
      </form>

      <p>
         <a href="<c:url value='?action=Report&command=index' />">${HtmlConst.TEXT_REP_BACK_LIST.getValue(lang)}</a>
      </p>
   </c:param>
</c:import>
