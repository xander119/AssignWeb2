<%@ include file="header.jsp"%>

<s:if test="#session.customer!=null || #session.admin!=null">
	<s:iterator value="items">
		<s:form action="viewItem" theme="bootstrap" cssClass=" well form-inline">
			<h4>
				Products :
				<s:property value="title" />
			</h4>
			<img src="C:/JBOSS/jboss-as-7.1.1.Final/standalone/deployments/userimages/<s:property value="image" />"
				alt="<s:property value="image"/>"/>
			<p>
				Manufacturer : <s:property  value="manufacturer" />
			</p>
			<h5>
				Category:
				<s:property value="category.categoryName" />
			</h5>
			<s:hidden value="%{id}" name="itemId"></s:hidden>
			<s:submit type="button" value="Detail"></s:submit>
		</s:form>
	</s:iterator>
</s:if>
<s:else>
	<h2>Customer Log in</h2>
	<s:form action="login">
		<s:textfield name="customer.userName" placeholder="User name" cssClass="form-control"></s:textfield>
		<s:password name="customer.password" placeholder="Password" cssClass="form-control"></s:password>
		<s:submit type="button">Log In</s:submit>
	</s:form>
	<a href="register.jsp"> Register as new customer.</a>
	<br>
	<a href="adminLogin.jsp">Administrator Log In</a>
</s:else>
</body>
</html>