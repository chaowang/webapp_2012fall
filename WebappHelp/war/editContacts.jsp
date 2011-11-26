<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ page import="webapp.help.beans.ContactBean" %>
<%@page isELIgnored="false" %> 

<h3>Edit a contact</h3>
<form action="editContact.do" method="post">
	<table>
		<tr>
			<td>Name</td>
			<td>Phone</td>
			<td>Email</td>
			<td>Message</td>
			<td>Category</td>
		</tr>
		<tr>
			<td><input type="text" name="name" value="${contact.name}" />
			</td>
			<td><input type="text" name="phone" value="${contact.phone}" />
			</td>
			<td><input type="text" name="email" value="${contact.email}" />
			</td>
			<td><input type="text" name="msg" value="${contact.message}" />
			</td>
			<td><input type="text" name="category" value="${contact.category}" />
			</td>
		</tr>

		

	</table>
    <input type="hidden" name="keyStr" value=" ${contact.keyStr}" />
	<input type="submit" class="remove" name="button" value="save" />
	<input type="submit" class="edit" name="button" value="cancel" />
</form>
