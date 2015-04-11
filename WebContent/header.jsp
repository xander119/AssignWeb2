<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Esale</title>
</head>
<s:if test="#session.customer==null">
	<s:if test="#session.admin==null">
		<s:a href="CustomerLogin.jsp">Log in</s:a>
	</s:if>
</s:if>
<s:if test="#session.admin!=null">
	<s:a action="adminLogout">Logout</s:a>
	<s:a action="toIndex">Store</s:a>
	<s:a action="newCategory">Add new Category</s:a>
	<s:a action="newItem">Add new item</s:a>
	<s:a action="manageItems">Manage Items</s:a> 

</s:if>
<s:if test="#session.customer!=null">
	<s:a action="customerLogout">Logout</s:a>
	<s:a action="toIndex">Store</s:a>
	<s:a action="toCart">View Cart</s:a> 
	<s:a action="manageAcc">Manage Account</s:a>
	<s:a action="newAccountAc">Add Account</s:a>
</s:if>
	<a href="searchPage.jsp">Search Item</a>


<body>