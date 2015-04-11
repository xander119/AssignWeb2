<%@ include file="header.jsp" %>

	<s:form action="saveAccount" method="post"> 

		<s:textarea cols="30" rows="10" label="Address" name="address" value="%{account.address}"></s:textarea>
		<s:textfield label="Balance" name="balance" value="%{account.balance}"></s:textfield>
		<s:select label="Payment Method" headerKey="-1" headerValue="Select Payment Methods" list="paymentMethods" name="paymentMethod" value="%{account.paymentMethod}"/> 
		<s:hidden name="accId" value="%{account.id}"/>
		<s:submit type="button" value="Save"></s:submit>
	</s:form>
</body>
</html>