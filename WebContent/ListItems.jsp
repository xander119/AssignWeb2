<%@ include file="header.jsp" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

	<display:table name="items" requestURI="" sort="list" pagesize="20" >
		<display:column property="title" title="Title" sortable="true" />
		<display:column property="category.categoryName" title="Category" sortable="true" />
		<display:column property="manufacturer" title="Manufacturer" sortable="true" />
		<display:column property="price" title="Price" sortable="true" />
		<display:column property="stockQuantity" title="Stock Quantity" />
		<display:column property="id"  title="View" href="viewItem.action" paramId="itemId" />
		<s:if test="#session.admin!=null">
			<display:column property="id" title="Edit" href="editItem.action" paramId="itemId" />
		</s:if>
	</display:table>

	<s:form>

	</s:form>
</body>
</html>
