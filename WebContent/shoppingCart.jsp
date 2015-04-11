<%@ include file="header.jsp" %>
	<h2>Shopping Card Example</h2>
<div >
<s:if test="#session.cart!=null">
    <table class="table">
        <tr>
            
            <th>Item</th>
            <th>Qty</th>
            <th>Cost</th>
            <th>Total</th>
        </tr>
        
                <s:iterator value="cart" status="status" >
        <tr >
            <td><s:property value="item.title" /></td>           
            <td><s:property value="quantity" /></td>
            <td><s:property value="totalPrice" /></td>
            <td>
            <s:form action="deleteFromCart">
						<s:hidden name="itemSelectId" value="%{#status.index}"/>
						<s:submit type="button">Delete</s:submit>
					</s:form>
            </td>
        </tr>
        </s:iterator>
        <tr>
            <td>Total:</td>
            <td>£<s:property value ="total"/></td>
        </tr>
    </table>
    </s:if>
    <s:else><h2>Empty Cart</h2></s:else>
    <s:a action="checkOut">Check-Out</s:a>
</div>
	

</body>
</html>