<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="constants.HtmlConst" %>


<c:import url="../layout/app.jsp">
	<c:param name="content">
		<H2>${HtmlConst.TEXT_UNKNOWN.getValue(lang)}</H2>
	</c:param>
</c:import>
