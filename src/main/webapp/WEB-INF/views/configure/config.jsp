<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="constants.ForwardConst" %>
<%@ page import="constants.AttributeConst" %>

<c:set var="action" value="${ForwardConst.ACT_CONFIG.getValue()}" />
<c:set var="actTop" value="${ForwardConst.ACT_TOP.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commUpd" value="${ForwardConst.CMD_UPDATE.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
	<c:param name="content">
		<H2>Setting page</H2>
		<form method="POST"
			action="<c:url value='?action=${action}&command=${commUpd}' />">

<label for="${AttributeConst.CONFIG_COLOR.getValue()}">Foreground color</label><br>
<select name="${AttributeConst.CONFIG_COLOR.getValue()}" id="${AttributeConst.CONFIG_COLOR.getValue()}" >
	<option value="Default"<c:if test="${configure.user_color == 'Default'}"> selected</c:if> >Default</option>
	<option value="Pink" style="color:pink;"<c:if test="${configure.user_color == 'Pink'}"> selected</c:if> >Pink</option>
	<option value="Yellow" style="color:Yellow;"<c:if test="${configure.user_color == 'Yellow'}"> selected</c:if> >Yellow</option>
	<option value="Green" style="color:Green;"<c:if test="${configure.user_color == 'Green'}"> selected</c:if> >Green</option>
	<option value="Blue" style="color:Blue;"<c:if test="${configure.user_color == 'Blue'}"> selected</c:if> >Blue</option>
	<option value="Red" style="color:red;"<c:if test="${configure.user_color == 'Red'}"> selected</c:if> >Red</option>
	<option value="Black" style="color:Black;"<c:if test="${configure.user_color == 'Black'}"> selected</c:if> >Black</option>
	<option value="Sibyas" style="color:#A54200;"<c:if test="${configure.user_color == 'Sibuyas'}"> selected</c:if> >Sibuyas</option>
	<option value="Berde" style="color:#31572A;"<c:if test="${configure.user_color == 'Berde'}"> selected</c:if> >Berde</option>
	<option value="Asul" style="color:#5E4266;"<c:if test="${configure.user_color == 'Asul'}"> selected</c:if> >Asul</option>
	<option value="Kulay Rosas" style="color:#FF3B60;"<c:if test="${configure.user_color == 'Kulay Rosas'}"> selected</c:if> >Kulay Rosas</option>
	<option value="Kulay Ube" style="color:#36425C;"<c:if test="${configure.user_color == 'Kulay Ube'}"> selected</c:if> >Kulay Ube</option>
</select>
<br><br>

<c:if test="${false}">
	<input type="text" name="${AttributeConst.CONFIG_COLOR.getValue()}" id="${AttributeConst.CONFIG_COLOR.getValue()}" value="${configure.user_color}" />
	<br><br>

	<label for="${AttributeConst.CONFIG_BG.getValue()}">Background colour</label><br>
	<input type="text" name="${AttributeConst.CONFIG_BG.getValue()}" id="${AttributeConst.CONFIG_BG.getValue()}" value="${configure.user_background}" />
	<br><br>

	<label for="${AttributeConst.CONFIG_LANGUAGE.getValue()}">Language</label><br>
	<input type="text" name="${AttributeConst.CONFIG_LANGUAGE.getValue()}" id="${AttributeConst.CONFIG_LANGUAGE.getValue()}" value="${configure.language}" />
	<br><br>

	<input type="hidden" name="${AttributeConst.CONFIG_TIMEZONE.getValue()}" value="${configure.time_zone}" />
</c:if>

<input type="hidden" name="${AttributeConst.TOKEN.getValue()}" value="${_token}" />
<button type="submit">Submit</button>		</form>

		<p>
			<a href="<c:url value='?action=${actTop}&command=${commIdx}' />">Go to top page</a>
		</p>
	</c:param>
</c:import>