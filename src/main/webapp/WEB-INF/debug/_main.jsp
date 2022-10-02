<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="debug_area">
	<p><a href="#" onclick="openDebug();" id="debug_menu_open">Open debug menu</a></p>
		<div id="debug_menu">
				<p><a href="#" onclick="openChangeColor();" id="open_change_color" >Change color</a></p>
<div id="debug_changeColor" style="display:none">
	<c:import url="/WEB-INF/debug/_changeColor.jsp" />
</div>
				<p><a href="#" onclick="openChangeBackground();" id="open_change_bgcolor">Change background-color</a></p>
<div id="debug_changeBackground" style="display:none">
	<c:import url="/WEB-INF/debug/_changeBackground.jsp" />
</div>
				<p><a href="#" onclick="openChangeLanguage();" id="open_change_language">Change language</a></p>
<div id="debug_changeLanguage" style="display:none">
	<p>[Locked]We must implements the function of the language setting</p>
</div>
				<p><a href="#" onclick="openChangeTimeZone();" id="open_change_time_zone">Change time zone</a></p>
<div id="debug_changeTimeZone" style="display:none">
	<p>[Locked]We must implements the function of the time zone setting</p>
</div>
				<p><a href="#" onclick="openPlayMusic();" id="open_play_music">Play music</a></p>
<div id="debug_playMusic" style="display:none">
	<p>Not available</p>
</div>
		</div>
		<c:import url='/WEB-INF/debug/_script.jsp' />
		<script>
			document.getElementById("debug_menu").style.display="none";
			function openDebug(){
				const dm = document.getElementById("debug_menu");
				const dmo = document.getElementById("debug_menu_open");
				if(dm.style.display=="block"){
					dm.style.display = "none";
					dmo.innerText = "Open debug menu";
				}else{
					dm.style.display = "block";
					dmo.innerText = "Close debug menu";
				}
			}
		</script>

</div>