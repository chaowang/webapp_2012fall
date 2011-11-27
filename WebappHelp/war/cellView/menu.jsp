<HTML><HEAD>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta http-equiv="imagetoolbar" content="no">
<link href="resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet">
<link href="resources/css/axure_rp_page.css" type="text/css" rel="stylesheet">
<link href="menu_files/axurerp_pagespecificstyles.css" type="text/css" rel="stylesheet">
<!--[if IE 6]>
<link href="menu_files/axurerp_pagespecificstyles_ie6.css" type="text/css" rel="stylesheet">
<![endif]-->
<SCRIPT src="resources/scripts/jquery-1.4.2.min.js"></SCRIPT>
<SCRIPT src="resources/scripts/jquery-ui-1.8.10.custom.min.js"></SCRIPT>
<SCRIPT src="resources/scripts/axurerp_beforepagescript.js"></SCRIPT>
<SCRIPT src="resources/scripts/messagecenter.js"></SCRIPT>
<script>
			function withPosition(category){	
				return function(position){
					var form = document.createElement("form");
				    form.setAttribute("method", "get");
				    form.setAttribute("action", "sendMessage.do");
				
					var hiddenField = document.createElement("input");
				        hiddenField.setAttribute("type", "hidden");
				        hiddenField.setAttribute("name", "longitude");
				        hiddenField.setAttribute("value", position.coords.longitude);
					form.appendChild(hiddenField);
					
					hiddenField = document.createElement("input");
				        hiddenField.setAttribute("type", "hidden");
				        hiddenField.setAttribute("name", "latitude");
				        hiddenField.setAttribute("value", position.coords.latitude);
					form.appendChild(hiddenField);
				
					hiddenField = document.createElement("input");
				        hiddenField.setAttribute("type", "hidden");
				        hiddenField.setAttribute("name", "category");
				        hiddenField.setAttribute("value", category);
					form.appendChild(hiddenField);
				
				    document.body.appendChild(form);
				    form.submit();
				};		
			}
			function withError(error){
			}
		
			function getGeoAndSubmit(){
				if (navigator.geolocation){
					navigator.geolocation.getCurrentPosition(withPosition("CAR"),withError);
					
				}			
				return true;
			}				
			
		</script>
</HEAD>
<BODY>
<DIV class="main_container">

<DIV id=u0_container class="u0_container">
<DIV id="u0_img" class="u0_original"></DIV>
<DIV id=u1 class="u1" >
<DIV id=u1_rtf>&nbsp;</DIV></DIV>
</DIV>
<IMG id=u0 src="resources/images/transparent.gif" class="u0"    >

<DIV id=u2_container class="u2_container">
<DIV id="u2_img" class="u2_original"></DIV>
<DIV id=u3 class="u3" >
<DIV id=u3_rtf><p style="text-align:center;"><span style="font-family:Century Gothic;font-size:28px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">General</span></p></DIV></DIV>
</DIV>
<button onClick="getGeoAndSubmit('GENERAL')"><IMG id=u2 src="resources/images/transparent.gif" class="u2"/></button>

<DIV id=u4_container class="u4_container">
<DIV id="u4_img" class="u4_original"></DIV>
<DIV id=u5 class="u5" >
<DIV id=u5_rtf><p style="text-align:center;"><span style="font-family:Century Gothic;font-size:28px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">Medical</span></p></DIV></DIV>
</DIV>
<button onClick="getGeoAndSubmit('CAR')"><IMG id=u4 src="resources/images/transparent.gif" class="u4"/></button>

<DIV id=u6_container class="u6_container">
<DIV id="u6_img" class="u6_original"></DIV>
<DIV id=u7 class="u7" >
<DIV id=u7_rtf><p style="text-align:center;"><span style="font-family:Century Gothic;font-size:28px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">Car</span></p></DIV></DIV>
</DIV>
<button onClick="getGeoAndSubmit('MEDICAL')"><IMG id=u6 src="resources/images/transparent.gif" class="u6"/></button>

<DIV id=u8_container class="u8_container">
<DIV id="u8_img" class="u8_original"></DIV>
<DIV id=u9 class="u9" >
<DIV id=u9_rtf><p style="text-align:center;"><span style="font-family:Century Gothic;font-size:28px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">Fire</span></p></DIV></DIV>
</DIV>
<button onClick="getGeoAndSubmit('FIRE')"><IMG id=u8 src="resources/images/transparent.gif" class="u8"/></button>

<DIV id=u10_container class="u10_container">
<DIV id="u10_img" class="u10_original"></DIV>
<DIV id=u11 class="u11" >
<DIV id=u11_rtf>&nbsp;</DIV></DIV>
</DIV>
<IMG id=u10 src="resources/images/transparent.gif" class="u10"    >
</DIV>
<DIV class=preload>
<img src="menu_files/u0_original.png" width="1" height="1"/>
<img src="menu_files/u2_original.png" width="1" height="1"/>
<img src="menu_files/u4_original.png" width="1" height="1"/>
<img src="menu_files/u6_original.png" width="1" height="1"/>
<img src="menu_files/u8_original.png" width="1" height="1"/>
<img src="menu_files/u10_original.png" width="1" height="1"/></DIV>
</BODY>
<SCRIPT src="resources/scripts/axurerp_pagescript.js"></SCRIPT>
<SCRIPT src="menu_files/axurerp_pagespecificscript.js" charset="utf-8"></SCRIPT>