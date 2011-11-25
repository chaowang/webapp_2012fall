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
			<td><input type="text" name="name"/></td>
			<td><input type="text" name="phone"/></td>
			<td><input type="text" name="email"/></td>
			<td><input type="text" name="msg"/></td>
			<td><input type="text" name="category" value="GENERAL"/></td>
		</tr>
	</table>
	<input type="submit" name="button" value="Add"/> 
</form>