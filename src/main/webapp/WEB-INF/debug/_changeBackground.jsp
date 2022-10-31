<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<p><a href="#" onclick="changeBackground('Pink');">Pink</a></p>
<p><a href="#" onclick="changeBackground('Yellow');">Yellow</a></p>
<p><a href="#" onclick="changeBackground('Green');">Green</a></p>
<p><a href="#" onclick="changeBackground('Blue');">Blue</a></p>
<p><a href="#" onclick="changeBackground('Red');">Red</a></p>
<p><a href="#" onclick="changeBackground('White');">White</a></p>
<p><a href="#" onclick="changeBackground('#FF4A00');">Sibuyas</a></p>
<p><a href="#" onclick="changeBackground('#5BFF22');">Berde</a></p>
<p><a href="#" onclick="changeBackground('#009FFF');">Asul</a></p>
<p><a href="#" onclick="changeBackground('#FF8FFF');">Kulay Rosas</a></p>
<p><a href="#" onclick="changeBackground('#8C4BDE');">Kulay Ube</a></p>
<p><a href="#" onclick="changeBackground('');">reset</a></p>
<script>
function changeBackground(color){
   content.style.backgroundColor = color;
}
function resetBackground(){
   content.style.backgroundColor = '';
}


</script>
