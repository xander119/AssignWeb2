<%@ include file="header.jsp" %>

	<s:form action="saveItem" method="post" enctype="multipart/form-data">
		<s:textfield name="item.title" label="Item Title" value="%{item.title}"></s:textfield>
		<s:select label="Category" name="category" list="displayCate" headerKey="-1" headerValue="Select Category"  value="%{category}"></s:select>
		<s:textfield name="item.manufacturer" label="Manufacturer" value="%{item.manufacturer}"></s:textfield>
		<s:textfield name="item.price" type="number" label="Item Price" value="%{item.price}"></s:textfield>
		<s:textfield name="item.stockQuantity" type="number" label="Stock Quantity" value="%{item.stockQuantity}"></s:textfield>
		<s:file name="userImage" label="Choose image to upload"  value="%{item.userImage}"/>
		<s:hidden name="itemId" value="%{item.id}"/>
		<s:submit type="button" value="Submit"></s:submit>
		<s:a action="cancelAction">Cancel</s:a>
	</s:form>
</body>
</html>