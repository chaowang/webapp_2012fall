<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>



<c:if test="${!(empty list)}">
	<table>
		<c:forEach var="contact" items="${list}">
		<tr>
		<td>
		        <div>
				<form method="POST" action="deleteContact.do">
			
                    <input type="hidden" name="key" value=" ${contact.keyStr}"/>
                    <input type="submit" class="remove" value="X"/>
                </form>
			
				key : ${contact.keyStr} <br>
				name : ${contact.name} <br>
				email: ${contact.email} <br>
				messsage: ${contact.message} <br>
				</div>
			</td>
		</tr>
		</c:forEach>
	</table>
</c:if>