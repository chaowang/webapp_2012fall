

<HTML><HEAD>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<%@ page import="webapp.help.utility.Category" %>

<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta http-equiv="imagetoolbar" content="no">
<link href="view/resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet">
<link href="view/resources/css/axure_rp_page.css" type="text/css" rel="stylesheet">
<link href="view/add_files/axurerp_pagespecificstyles.css" type="text/css" rel="stylesheet">
<!--[if IE 6]>
<link href="view/add_files/axurerp_pagespecificstyles_ie6.css" type="text/css" rel="stylesheet">
<![endif]-->
<SCRIPT src="view/resources/scripts/jquery-1.4.2.min.js"></SCRIPT>
<SCRIPT src="view/resources/scripts/jquery-ui-1.8.10.custom.min.js"></SCRIPT>
<SCRIPT src="view/resources/scripts/axurerp_beforepagescript.js"></SCRIPT>
<SCRIPT src="view/resources/scripts/messagecenter.js"></SCRIPT>
</HEAD>
<BODY>
<DIV class="main_container">

<DIV id=u0_container class="u0_container">
<DIV id="u0_img" class="u0_original"></DIV>
<DIV id=u1 class="u1" >
<DIV id=u1_rtf><p style="text-align:center;"><span style="font-family:Century Gothic;font-size:18px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">Fire</span></p></DIV></DIV>
</DIV>
<IMG id=u0 src="view/resources/images/transparent.gif" class="u0"    >

<DIV id=u2_container class="u2_container">
<DIV id="u2_img" class="u2_original"></DIV>
<DIV id=u3 class="u3" >
<DIV id=u3_rtf><p style="text-align:center;"><span style="font-family:Century Gothic;font-size:18px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">Car</span></p></DIV></DIV>
</DIV>
<IMG id=u2 src="view/resources/images/transparent.gif" class="u2"    >

<DIV id=u4_container class="u4_container">
<DIV id="u4_img" class="u4_original"></DIV>
<DIV id=u5 class="u5" >
<DIV id=u5_rtf>&nbsp;</DIV></DIV>
</DIV>
<IMG id=u4 src="view/resources/images/transparent.gif" class="u4"    >

<DIV id=u6_container class="u6_container">
<DIV id="u6_img" class="u6_original"></DIV>
<DIV id=u7 class="u7" >
<DIV id=u7_rtf><p style="text-align:center;"><span style="font-family:Century Gothic;font-size:18px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">Medical</span></p></DIV></DIV>
</DIV>
<IMG id=u6 src="view/resources/images/transparent.gif" class="u6"    >

<DIV id=u8_container class="u8_container">
<DIV id="u8_img" class="u8_original"></DIV>
<DIV id=u9 class="u9" >
<DIV id=u9_rtf><p style="text-align:center;"><span style="font-family:Century Gothic;font-size:18px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">General</span></p></DIV></DIV>
</DIV>
<IMG id=u8 src="view/resources/images/transparent.gif" class="u8"    >

<DIV id=u10 class="u10" >
<DIV id=u10_rtf><p style="text-align:left;"><span style="font-family:Century Gothic;font-size:16px;font-weight:normal;font-style:normal;text-decoration:underline;color:#4BACC6;">Logout</span></p></DIV></DIV>
<DIV id=u11_container class="u11_container">
<DIV id="u11_img" class="u11_original"></DIV>
<DIV id=u12 class="u12" >
<DIV id=u12_rtf>&nbsp;</DIV></DIV>
</DIV>
<IMG id=u11 src="view/resources/images/transparent.gif" class="u11"    >
<jsp:include page="error-list.jsp" />
<form action="editContact.do" method="post">
<INPUT id=u18 type=text name="name"  value="${contact.name}" class="u18"     >

<INPUT id=u13 type=text name="email" value="${contact.email}" class="u13"     >

<INPUT id=u14 type=text name="phone"  value="${contact.phone}" class="u14"     >

<INPUT id=u15 type=text name="msg"  value="${contact.message}" class="u15"     >


 <SELECT id=u19 class="u19" name="category">
				<c:choose>
					<c:when test="${contact.category == 'GENERAL'}">

					<OPTION selected value="GENERAL">GENERAL</OPTION>
					<OPTION  value="MEDICAL">MEDICAL</OPTION>
					<OPTION  value="CAR">CAR</OPTION>
					<OPTION  value="FIRE">FIRE</OPTION>
					</c:when>
					<c:when test="${contact.category == 'MEDICAL'}">

					<OPTION value="GENERAL">GENERAL</OPTION>
					<OPTION selected  value="MEDICAL">MEDICAL</OPTION>
					<OPTION  value="CAR">CAR</OPTION>
					<OPTION  value="FIRE">FIRE</OPTION>
					</c:when>
					<c:when test="${contact.category == 'CAR'}">

					<OPTION value="GENERAL">GENERAL</OPTION>
					<OPTION  value="MEDICAL">MEDICAL</OPTION>
					<OPTION selected value="CAR">CAR</OPTION>
					<OPTION  value="FIRE">FIRE</OPTION>
					</c:when>
					<c:when test="${contact.category == 'FIRE'}">

					<OPTION value="GENERAL">GENERAL</OPTION>
					<OPTION  value="MEDICAL">MEDICAL</OPTION>
					<OPTION  value="CAR">CAR</OPTION>
					<OPTION selected value="FIRE">FIRE</OPTION>
					</c:when>
					<c:otherwise>
					<OPTION  value="GENERAL">GENERAL</OPTION>
					<OPTION  value="MEDICAL">MEDICAL</OPTION>
					<OPTION  value="CAR">CAR</OPTION>
					<OPTION  value="FIRE">FIRE</OPTION>
					
    
    </c:otherwise>
				</c:choose>


</SELECT>
<input type="hidden" name="keyStr" value=" ${contact.keyStr}" />
<INPUT id=u16 type=submit class="u16"  name="button" value="cancel"  >

<INPUT id=u17 type=submit class="u17" name="button"  value="save"  >

</form>
<DIV id=u20_container class="u20_container">
<DIV id="u20_img" class="u20_original"></DIV>
<DIV id=u21 class="u21" >
<DIV id=u21_rtf><p style="text-align:center;"><span style="font-family:Century Gothic;font-size:20px;font-weight:bold;font-style:normal;text-decoration:none;color:#FFFFFF;">Name</span></p></DIV></DIV>
</DIV>
<IMG id=u20 src="view/resources/images/transparent.gif" class="u20"    >

<DIV id=u22_container class="u22_container">
<DIV id="u22_img" class="u22_original"></DIV>
<DIV id=u23 class="u23" >
<DIV id=u23_rtf><p style="text-align:center;"><span style="font-family:Century Gothic;font-size:20px;font-weight:bold;font-style:normal;text-decoration:none;color:#FFFFFF;">Email</span></p></DIV></DIV>
</DIV>
<IMG id=u22 src="view/resources/images/transparent.gif" class="u22"    >

<DIV id=u24_container class="u24_container">
<DIV id="u24_img" class="u24_original"></DIV>
<DIV id=u25 class="u25" >
<DIV id=u25_rtf><p style="text-align:center;"><span style="font-family:Century Gothic;font-size:20px;font-weight:bold;font-style:normal;text-decoration:none;color:#FFFFFF;">Phone</span></p></DIV></DIV>
</DIV>
<IMG id=u24 src="view/resources/images/transparent.gif" class="u24"    >

<DIV id=u26_container class="u26_container">
<DIV id="u26_img" class="u26_original"></DIV>
<DIV id=u27 class="u27" >
<DIV id=u27_rtf><p style="text-align:center;"><span style="font-family:Century Gothic;font-size:20px;font-weight:bold;font-style:normal;text-decoration:none;color:#FFFFFF;">Message</span></p></DIV></DIV>
</DIV>
<IMG id=u26 src="view/resources/images/transparent.gif" class="u26"    >
</DIV>
<DIV class=preload>
<img src="view/add_files/u0_original.png" width="1" height="1"/>
<img src="view/add_files/u2_original.png" width="1" height="1"/>
<img src="view/add_files/u4_original.png" width="1" height="1"/>
<img src="view/add_files/u6_original.png" width="1" height="1"/>
<img src="view/add_files/u8_original.png" width="1" height="1"/>
<img src="view/add_files/u11_original.png" width="1" height="1"/>
<img src="view/add_files/u20_original.png" width="1" height="1"/></DIV>
</BODY>
<SCRIPT src="view/resources/scripts/axurerp_pagescript.js"></SCRIPT>
<SCRIPT src="view/add_files/axurerp_pagespecificscript.js" charset="utf-8"></SCRIPT>