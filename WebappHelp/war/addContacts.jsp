<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ page import="webapp.help.beans.ContactBean" %>
<%@page isELIgnored="false" %> 

view contacts

<h3>Add a contact</h3>
<form action="addContact.do" method="post">
	<table>
		<tr>
			<td>Name</td>
			<td>Phone</td>
			<td>Email</td>
			<td>Message</td>
			<td>Category</td>
		</tr><tr>
			<td><input type="text" name="name"  value="${contact.name}"/></td>
			<td><input type="text" name="phone"  value="${contact.phone}"/></td>
			<td><input type="text" name="email"  value="${contact.email}"/></td>
			<td><input type="text" name="msg"  value="${contact.message}"/></td>
			<td><input type="text" name="category" value="GENERAL"/></td>
		</tr>
	</table>
	<input type="submit" name="button" value="Add"/> 
</form>