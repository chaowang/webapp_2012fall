<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<HTML><HEAD>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta http-equiv="imagetoolbar" content="no">
<link href="view/resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet">
<link href="view/resources/css/axure_rp_page.css" type="text/css" rel="stylesheet">
<link href="view/Home_files/axurerp_pagespecificstyles.css" type="text/css" rel="stylesheet">
<!--[if IE 6]>
<link href="view/Home_files/axurerp_pagespecificstyles_ie6.css" type="text/css" rel="stylesheet">
<![endif]-->
<SCRIPT src="view/resources/scripts/jquery-1.4.2.min.js"></SCRIPT>
<SCRIPT src="view/resources/scripts/jquery-ui-1.8.10.custom.min.js"></SCRIPT>
<SCRIPT src="view/resources/scripts/axurerp_beforepagescript.js"></SCRIPT>
<SCRIPT src="view/resources/scripts/messagecenter.js"></SCRIPT>

<script type="text/javascript">
function viewContact(keyStr) {
	
	document.location.href = 'viewContact.do?keyStr='+keyStr;
	
}
</script>
</HEAD>
<BODY>
<DIV class="main_container">
<jsp:include page="error-list.jsp" />
<DIV id=u0_container class="u0_container">
<DIV id="u0_img" class="u0_original"></DIV>
<DIV id=u1 class="u1" >
<DIV id=u1_rtf><p style="text-align:center;"><span style="font-family:Century Gothic;font-size:18px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">Fire</span></p></DIV></DIV>
</DIV><a href="viewCategory.do?category=Fire">
<IMG id=u0 src="view/resources/images/transparent.gif" class="u0"    ></a>

<DIV id=u2_container class="u2_container">
<DIV id="u2_img" class="u2_original"></DIV>
<DIV id=u3 class="u3" >
<DIV id=u3_rtf><p style="text-align:center;"><span style="font-family:Century Gothic;font-size:18px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">Car</span></p></DIV></DIV>
</DIV><a href="viewCategory.do?category=Car">
<IMG id=u2 src="view/resources/images/transparent.gif" class="u2"    ></a>

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
</DIV><a href="viewCategory.do?category=Medical">
<IMG id=u6 src="view/resources/images/transparent.gif" class="u6"    ></a>

<DIV id=u8_container class="u8_container">
<DIV id="u8_img" class="u8_original"></DIV>
<DIV id=u9 class="u9" >
<DIV id=u9_rtf><p style="text-align:center;"><span style="font-family:Century Gothic;font-size:18px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">General</span></p></DIV></DIV>
</DIV><a href="viewCategory.do?category=General">
<IMG id=u8 src="view/resources/images/transparent.gif" class="u8"    ></a>
<SELECT id=u10 size=2 class="u10"   >

<c:if test="${!(empty list)}">
		
		<c:forEach var="contact" items="${list}">
			<c:choose>
			<c:when test="${contact.keyStr == keyStr}">
				<OPTION onclick="viewContact('${contact.keyStr}')" selected="selected">${contact.name}</OPTION>
 			</c:when>
 			<c:otherwise>
 				<OPTION onclick="viewContact('${contact.keyStr}')" >${contact.name}</OPTION>
 			</c:otherwise>
 			</c:choose>
		</c:forEach>
	
</c:if>



</SELECT>


<DIV id=u11 class="u11" >
<DIV id=u11_rtf><p style="text-align:left;"><span style="font-family:Century Gothic;font-size:16px;font-weight:normal;font-style:normal;text-decoration:underline;color:#4BACC6;">Logout</span></p></DIV></DIV>
<DIV id=u12_container class="u12_container">
<DIV id="u12_img" class="u12_original"></DIV>
<DIV id=u13 class="u13" >
<DIV id=u13_rtf><p style="text-align:left;"><span style="font-family:Century Gothic;font-size:36px;font-weight:bold;font-style:normal;text-decoration:none;color:#7F7F7F;"> +</span><span style="font-family:Century Gothic;font-size:36px;font-weight:normal;font-style:normal;text-decoration:none;color:#7F7F7F;">&nbsp;&nbsp; </span><span style="font-family:Century Gothic;font-size:20px;font-weight:normal;font-style:normal;text-decoration:none;color:#7F7F7F;">Add New&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; </span></p></DIV></DIV>
</DIV>
<a href="startAdd.do" ><IMG id=u12 src="view/resources/images/transparent.gif" class="u12"    ></a>

<DIV id=u14 class="u14" >
<DIV id=u14_rtf><p style="text-align:left;"><span style="font-family:Century Gothic;font-size:25px;font-weight:normal;font-style:normal;text-decoration:none;color:#1F497D;">${currContact.name}</span></p></DIV></DIV>
<DIV id=u15_container class="u15_container">
<DIV id="u15_img" class="u15_original"></DIV>
<DIV id=u16 class="u16" >
<DIV id=u16_rtf><p style="text-align:left;"><span style="font-family:Century Gothic;font-size:18px;font-weight:normal;font-style:normal;text-decoration:none;color:#7F7F7F;">${currContact.phone}</span></p></DIV></DIV>
</DIV>
<IMG id=u15 src="view/resources/images/transparent.gif" class="u15"    >

<DIV id=u17_container class="u17_container">
<DIV id="u17_img" class="u17_original"></DIV>
<DIV id=u18 class="u18" >
<DIV id=u18_rtf><p style="text-align:left;"><span style="font-family:Century Gothic;font-size:18px;font-weight:normal;font-style:normal;text-decoration:none;color:#7F7F7F;">${currContact.email}</span></p></DIV></DIV>
</DIV>
<IMG id=u17 src="view/resources/images/transparent.gif" class="u17"    >

<DIV id=u19_container class="u19_container">
<DIV id="u19_img" class="u19_original"></DIV>
<DIV id=u20 class="u20" >
<DIV id=u20_rtf><p style="text-align:left;"><span style="font-family:Century Gothic;font-size:18px;font-weight:normal;font-style:normal;text-decoration:none;color:#7F7F7F;">${currContact.message}</span></p></DIV></DIV>
</DIV>
<IMG id=u19 src="view/resources/images/transparent.gif" class="u19"    >

<DIV id=u21_container class="u21_container">
<DIV id="u21_img" class="u21_original"></DIV>
<DIV id=u22 class="u22" >
<DIV id=u22_rtf>&nbsp;</DIV></DIV>
</DIV>
<IMG id=u21 src="view/resources/images/transparent.gif" class="u21"    >

<form method="POST" action="updateContact.do">
			
                    <input type="hidden" name="keyStr" value=" ${currContact.keyStr}"/>
                    <input  id=u23 type=submit class="u23" name = "button" value="remove"/>
                    <input id=u24 type=submit class="u24" name = "button" value="edit"/>
</form>
 
</DIV>
<DIV class=preload>
<img src="view/Home_files/u0_original.png" width="1" height="1"/>
<img src="view/Home_files/u2_original.png" width="1" height="1"/>
<img src="view/Home_files/u4_original.png" width="1" height="1"/>
<img src="view/Home_files/u6_original.png" width="1" height="1"/>
<img src="view/Home_files/u8_original.png" width="1" height="1"/>
<img src="view/Home_files/u12_original.png" width="1" height="1"/>
<img src="view/Home_files/u15_original.png" width="1" height="1"/>
<img src="view/Home_files/u21_original.png" width="1" height="1"/></DIV>
</BODY>
<SCRIPT src="view/resources/scripts/axurerp_pagescript.js"></SCRIPT>
<SCRIPT src="view/Home_files/axurerp_pagespecificscript.js" charset="utf-8"></SCRIPT>