<%@ include file="header.jsp" %>

	<table>
		<tr>
			<td>UserName:</td>
		</tr>
		<tr>
			<td>${customer.userName }</td>
		</tr>

	</table>
	<a href="<s:url action="newAccountAc"/>">Create new Account</a>

</body>
</html>