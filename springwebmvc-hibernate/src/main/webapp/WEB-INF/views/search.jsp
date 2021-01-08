<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello Spring-MVC</title>
</head>
<body>
	<h1>Hello Spring Index JSP</h1>
	<div align="center">
		<h3><a href="/new">Search customer</a></h3>
		<table border="1" padding="5">
			<tr>
				<td>id</td>
				<td>name</td>
				<td>e-mail</td>
				<td>address</td>
				<td>action</td>
			</tr>
			<c:forEach items="${listCustomer}" var="customer">
				<tr>
					<td>${customer.id}</td>
					<td>${customer.name}</td>
					<td>${customer.email}</td>
					<td>${customer.address}</td>
					<td>
						<a href="/edit?id=${customer.id}">edit</a> 
						<a href="/delete?id=${customer.id}">delete</a> 
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>