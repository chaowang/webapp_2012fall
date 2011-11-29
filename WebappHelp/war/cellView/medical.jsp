<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<HTML>
<HEAD>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta http-equiv="imagetoolbar" content="no">

</HEAD>
<BODY>
<div style="top: 20px; left:20px; right:20px; bottom:20px; position: absolute">
	<div style="top: 0px; left: 0px; right:0px; bottom:0px; height:100px; ">
		<center> <img src="medical_files/u4_original.png"/> </center>
	</div>	
	<div style="top: 120px; left:0px; right:0px; bottom:0px; background-color: ${color}; position:absolute;">
		<div style="left:0px; right: 0px; top: 50%; height: 10em; margin-top:-5em; position: absolute;">
			<center><span style="color: white; font-family: Century Gothic;"> ${category} Emergency Message</span><center>
			<center><span style="font-size: 30px; color: white; font-family: Century Gothic;">SENT!</span><center>
		</div>
	</div>
</div>

</DIV>
</BODY>