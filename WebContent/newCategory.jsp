<%@ include file="header.jsp" %>

	<s:form action="saveCate" method="post">
		<s:textfield name="category.categoryName" label="Category Name"></s:textfield>
		<s:submit type="button" value="Add"></s:submit>
		<s:a action="cancelAction">Cancel</s:a>		
	</s:form>
</body>
</html>