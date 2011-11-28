<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p id="errors" style="font-size:medium; color:red">
    <c:choose>
   	<c:when test="${(not empty errors)}">
       <!-- 	<p style=\"font-size:medium; color:red\" >
       	 
	 	</p>  -->
	 	<c:forEach var="error" items="${errors}">
			<span   >${error }</span><br/>
  
				
	 	</c:forEach>
     </c:when>
    </c:choose>
 			
</p>