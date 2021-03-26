<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="btag" tagdir="/WEB-INF/tags/"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Account</title>
<spring:url value="/css/adminstyle.css" var="style" />
<link rel="stylesheet" type="text/css" href="${style}">
</head>
<body>
	<btag:header />
	<h5>${message}</h5>
	
	<h3 class="text-left">
		<b>Order History</b>
	</h3>
	<table border="1" class="table table-striped table-borderd">
		<tr class="thead-dark">
			<th scope="col">Receipt ID</th>
			<th scope="col">Purchase Date</th>
			<th scope="col">Brand</th>
			<th scope="col">Model Name</th>
			<th scope="col">Amount</th>
		</tr>
		<tbody>
			<c:forEach var="order" items="${orders}">
				<tr>
					<th scope="row">${order.receiptId}</th>
					<th scope="row">${order.purchaseDate}</th>
					<th scope="row">${order.bike.brand}</th>
					<th scope="row">${order.bike.modelName}</th>
					<th scope="row">${order.amount}</th>
					</tr>
			</c:forEach>
		</tbody>
	</table>	
</body>
</html>