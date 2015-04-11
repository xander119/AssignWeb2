<%@ include file="header.jsp" %>

<s:form action="searchItem" theme="bootstrap" cssClass=" well form-inline" >
<s:select label="Type"
       name="type"
       headerKey="-1" headerValue="Select search Type"
       list="#{'01':'Manufacturer', '02':'Category', '03':'Title'}" />
	<s:textfield name="content" type="text" ></s:textfield>
	<s:submit type="button" value="Search"></s:submit>
</s:form> 


</body>
</html>