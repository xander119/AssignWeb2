<%@ include file="header.jsp" %>

<s:if test="#session.customer==null">
	<s:if test="#session.admin == null" >
		<h2>Administrator Log In</h2>
		<s:form action="admin">
			<s:textfield label="Name" name="admin.name" placeholder="Name"></s:textfield>
			<s:password label="Password" name="admin.password" placeholder="Password"></s:password>
			<s:submit type="button">Log In</s:submit>

		</s:form>
	</s:if> 
		<s:a action="createAdmin">New Admin</s:a>
</s:if>
<s:if test="#session.customer!=null">
	You have already Logged in as Customer.
</s:if>
</body>
</html>