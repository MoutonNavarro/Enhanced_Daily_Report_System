<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<p><a href="#" onclick="changeColor('Pink');">Pink</a></p>
<p><a href="#" onclick="changeColor('Yellow');">Yellow</a></p>
<p><a href="#" onclick="changeColor('Green');">Green</a></p>
<p><a href="#" onclick="changeColor('Blue');">Blue</a></p>
<p><a href="#" onclick="changeColor('Red');">Red</a></p>
<p><a href="#" onclick="changeColor('Black');">Black</a></p>
<p><a href="#" onclick="changeColor('#A54200');">Sibuyas</a></p>
<p><a href="#" onclick="changeColor('#31572A');">Berde</a></p>
<p><a href="#" onclick="changeColor('#5E4266');">Asul</a></p>
<p><a href="#" onclick="changeColor('#FF3B60');">Kulay Rosas</a></p>
<p><a href="#" onclick="changeColor('#36425C');">Kulay Ube</a></p>
<p><a href="#" onclick="resetColor();">reset</a></p>
<script>
function changeColor(color){
	content.style.color = color;
}
function resetColor(){
	content.style.color = "";
}


</script>