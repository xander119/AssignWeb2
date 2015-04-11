<%@ include file="header.jsp" %>

	<s:form label="Register new Customer" action="customerReg" theme="bootstrap" method="post" cssClass=" well form-horizontal" >
		<s:textfield label="UserName" name="customer.userName" placeholder="UserName" tooltip="Enter your username here"></s:textfield>
		<s:password label="Password" name="customer.password" placeholder="password" tooltip="Enter your Password" ></s:password>
		<s:submit type="button" value="Register" cssClass="btn btn-primary"></s:submit>
	</s:form>

</body>
</html>