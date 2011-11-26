<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<c:if test="${!(empty list)}">
	<table>
		<c:forEach var="contact" items="${list}">
		<tr>
			<td>
						
				key: ${contact.key} <br>
				name : ${contact.name} <br>
				email: ${contact.email} <br>
				messsage: ${contact.message} <br>
			</td>
		</tr>
		</c:forEach>
	</table>
</c:if>