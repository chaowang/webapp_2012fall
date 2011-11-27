<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<jsp:include page="loginbar.jsp"/>


<html>
	<head>
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
		
			function getGeoAndSubmit(category){
				if (navigator.geolocation){
					navigator.geolocation.getCurrentPosition(withPosition(category),withError);
					
				}			
				return true;
			}				
			
		</script>
	</head>
	<body>
		<h1>view category!</h1>
		Category: ${category}<br>
		<jsp:include page="contactsList.jsp"/>
		
		<button onClick="getGeoAndSubmit(${category})">Send Message</button>

	</body>
</html>