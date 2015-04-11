<%@ include file="header.jsp" %>

	
<h2>Customer Log in </h2>
		<s:form action="login">
			<s:textfield name="customer.userName" placeholder="User name" cssClass="form-control"></s:textfield>
			<s:password name="customer.password" placeholder="Password" cssClass="form-control"></s:password>
			<s:submit type="button">Log In</s:submit>
		</s:form>
	<a href="register.jsp"> Register as new customer.</a>
	<br>
	<a href="adminLogin.jsp">Administrator Log In</a>
</body>
</html>