<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="webapp.help.beans.ContactBean" %>

<c:if test="${!(empty list)}">
	
	
	<table>
	<c:forEach var="ContactBean" items="${list}">
		<tr >
			    <tr>    
   		        <td valign="top" class="comment">Comment:${ContactBean.name}</td>
   			     </tr>
      			  <tr>
       		     <td valign="top" class="owner">Owner: ${ContactBean.email)}</td>
       			 </tr>
       			 <tr>
       		     <td valign="top" class="owner">LIST</td>
       			 </tr>
      			 
       	</tr>
  
				
	 </c:forEach>
	</table>
</c:if>