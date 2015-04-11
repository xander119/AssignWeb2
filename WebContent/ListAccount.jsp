<%@ include file="header.jsp" %>


<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

	<display:table name="accounts" requestURI="" sort="list" pagesize="20" >
		<display:column  property="address" title="Address" />
		<display:column property="balance" title="Balance" />
		<display:column property="paymentMethod" title="Payment Method"  />
		<display:column property="id" value="View" title="View" href="accDetail.action" paramId="accId" />
		<display:column property="id" title="Edit" href="editAcc.action" paramId="accId" />
		<display:column  property="id" title="Remove" href="deleteAccount.action" paramId="accId" />
		<s:if test="#session.account.id != %{id}">
			<display:column  property="id" title="Set To Current Account" href="setCurrentAcc.action" paramId="accId" />
		</s:if>
	</display:table>


</body>
</html>