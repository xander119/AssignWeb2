<%@ include file="header.jsp" %>

	<table>
		<tr>
			<td>Shipping address</td>
			<td>Payment Method</td>
			<td>Balance</td>
		</tr>
		<tr>
			<td>${account.address }</td>
			<td>${account.paymentMethod }</td>
			<td>${account.balance }</td>
		</tr>

	</table>

</body>
</html>