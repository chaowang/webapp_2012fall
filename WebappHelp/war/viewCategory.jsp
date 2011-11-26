<jsp:include page="loginbar.jsp"/>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="webapp.help.beans.ContactBean" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<% session = request.getSession(true);  
	ContactBean t1 = (ContactBean)session.getAttribute("contacts");
	
	
%>

		<h1>${test3.name}</h1>

<table>
	<c:forEach var="contact" items="${list}">


		<tr>
			<td class="contact">Name:${contact.name}</td>
		</tr>



	</c:forEach>
</table>
<jsp:include page="contactsList.jsp" />