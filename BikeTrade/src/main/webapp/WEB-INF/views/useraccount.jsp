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
	<h4 class="text-right">
		<b>Hello,${user.name}</b>
	</h4>
	<h3 class="text-left">
		<b>Personal Details</b>
	</h3>
	<table border="1" class="table table-striped table-borderd">
		<tr class="thead-dark">
			<th scope="col">First Name</th>
			<th scope="col">Last Name</th>
			<th scope="col">Email</th>
			<%--<th scope="col">Action</th> --%>
		</tr>
		<tbody>
			<tr>
				<th scope="row">${user.name}</th>
				<th scope="row">${user.lastName}</th>
				<th scope="row">${user.email}</th>
				<%--<th>
					<spring:url value="/edit"   var="updateURL"/>
					<a href="${updateURL}">Edit</a>
				</th> --%>
			</tr>
		</tbody>
	</table>

	<h3 class="text-left">
		<b>Registered Bike Details</b>
	</h3>
	<table border="1" class="table table-striped table-borderd">
		<tr class="thead-dark">
			<th scope="col">Bike ID</th>
			<th scope="col">Brand</th>
			<th scope="col">Model Name</th>
			<th scope="col">Running</th>
			<th scope="col">Registration Date</th>
			<th scope="col">Insurance Status</th>
			<th scope="col">Price</th>
			<th scope="col">Contact No.</th>
			<th scope="col">ContactName</th>
			<th scope="col">Address</th>
			<th scope="col">Status</th>
			<th scope="col">Action</th>
		</tr>
		<tbody>
			<c:forEach var="bike" items="${bikes}">
				<tr>
					<th scope="row">${bike.id}</th>
					<th scope="row">${bike.brand}</th>
					<th scope="row">${bike.modelName}</th>
					<th scope="row">${bike.running}</th>
					<th scope="row">${bike.regDate}</th>
					<th scope="row">${bike.insurance}</th>
					<th scope="row">${bike.price}</th>
					<th scope="row">${bike.contactNo}</th>
					<th scope="row">${bike.contactName}</th>
					<th scope="row">${bike.address}</th>
					<th scope="row">${bike.status}</th>
					<th>
						<div class="dropdown">
							<button class="dropbtn">Action</button>
							<div class="dropdown-content">

								<c:if test="${bike.status != 'CANCELLED'}">

									<spring:url value="/updatebike?bikeid=${bike.id}"
										var="updateURL" />

									<a href="${updateURL}">Edit</a>
									<spring:url value="/bike/cancel?bikeid=${bike.id}"
										var="cancelURL" />
									<a href="${cancelURL}">cancel</a>
								</c:if>
							</div>
						</div>
					</th>
				</tr>
			</c:forEach>
		</tbody>

	</table>
</body>
</html>