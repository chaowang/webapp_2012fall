<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="webapp.help.beans.ContactBean" %>

<c:if test="${!(empty list)}">
	
	
	<table>
	<c:forEach var="ContactBean" items="${list}">
		<tr >
			  
				
				<tr>    
   		        <td valign="top" class="comment">Comment:${ContactBean.getName()}</td>
   			     </tr>
      			  <tr>
       		     <td valign="top" class="owner">Owner: ${ContactBean.getEmail()}</td>
       			 </tr>
      			  <tr>
       		     <td valign="top" class="clicks">Clicks:${ContactBean.getEmail()}</td>
			    </tr>
       	</tr>
  
				
	 </c:forEach>
	</table>
</c:if>