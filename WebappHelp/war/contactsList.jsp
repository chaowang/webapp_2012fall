<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>



<SELECT id=u10 size=2 class="u10"   >
<OPTION selected value="Alex">Alex</OPTION>
<OPTION  value="Barbara">Barbara</OPTION>
<OPTION  value="Cathy">Cathy</OPTION>
<OPTION  value="David">David</OPTION>
<OPTION  value="Eli">Eli</OPTION>
<OPTION  value="Farny">Farny</OPTION>
<OPTION  value="George">George</OPTION>
<OPTION  value="Holly">Holly</OPTION>
<OPTION  value="Iris">Iris</OPTION>
<OPTION  value="Jolly">Jolly</OPTION>
</SELECT>

<c:if test="${!(empty list)}">
	<table>
		<c:forEach var="contact" items="${list}">
		<tr>
		<td>
		        <div>
				<form method="POST" action="updateContact.do">
			
                    <input type="hidden" name="key" value=" ${contact.keyStr}"/>
                    <input type="submit" class="remove" name = "button" value="remove"/>
                    <input type="submit" class="edit" name = "button" value="edit"/>
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
