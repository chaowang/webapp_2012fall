<jsp:include page="loginbar.jsp"/>


<html>
	<head>
		<script>
			function withPosition(position){				
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
			
			    document.body.appendChild(form);
			    form.submit();
			}
			function withError(error){
			}
		
			function getGeoAndSubmit(){
				if (navigator.geolocation){
					navigator.geolocation.getCurrentPosition(withPosition,withError);
				}			
				return true;
			}				
			
		</script>
	</head>
	<body>
		<h1>view category!</h1>
		
		<jsp:include page="contactsList.jsp"/>
		
		<input type="submit" onClick="getGeoAndSubmit()"/>

	</body>
</html>