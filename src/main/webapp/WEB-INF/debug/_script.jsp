<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>

function openChangeColor(){
	const dcc = document.getElementById("debug_changeColor");
	if(dcc.style.display=="block"){
		dcc.style.display = "none";
	}else{
		dcc.style.display = "block";
	}
}
function openChangeBackground(){
	const dcb = document.getElementById("debug_changeBackground");
	if(dcb.style.display=="block"){
		dcb.style.display = "none";
	}else{
		dcb.style.display = "block";
	}
}
function openChangeLanguage(){
	const dcl = document.getElementById("debug_changeLanguage");
	if(dcl.style.display=="block"){
		dcl.style.display = "none";
	}else{
		dcl.style.display = "block";
	}
}
function openChangeTimeZone(){
	const dct = document.getElementById("debug_changeTimeZone");
	if(dct.style.display=="block"){
		dct.style.display = "none";
	}else{
		dct.style.display = "block";
	}
}
function openPlayMusic(){
	const dpm = document.getElementById("debug_playMusic");
	if(dpm.style.display=="block"){
		dpm.style.display = "none";
	}else{
		dpm.style.display = "block";
	}
}

	</script>