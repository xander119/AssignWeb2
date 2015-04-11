<%@ include file="header.jsp" %>

<h2>Create new Administrator</h2>
<s:form label="Register new admin" action="newadmin" method="post"  theme="bootstrap" cssClass=" well form-horizontal" >
		<s:textfield label="Name" name="admin.name" placeholder="Name" tooltip="Enter admin name here"></s:textfield>
		<s:password label="Password" name="admin.password" placeholder="password" tooltip="Enter your Password" ></s:password>
		<s:submit type="button" value="Create" cssClass="btn btn-primary"></s:submit>
		<s:a action="cancelAction">Cancel</s:a>
	</s:form>

</body>
</html>