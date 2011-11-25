<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<c:if test="${!(empty list)}">
	<table>
		<c:forEach var="contact" items="${list}">
		<tr>
			<td>
				<span class="bookmark"><b>${bookmark.url}</b></span><br>
				<span class="comment">${bookmark.comment}</span><br>
				<span class="${bookmark.clicks} clicks!
				
				key: ${contact.key} <br>
				name : ${conact.name} <br>
				email: ${contact.email} <br>
				messsage: ${contact.message} <br>
			</td>
		</tr>
		</c:forEach>
	</table>
</c:if>