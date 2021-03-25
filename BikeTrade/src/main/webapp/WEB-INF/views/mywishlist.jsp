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
		<b>My Wish List</b>
	</h3>
	<table border="1" class="table table-striped table-borderd">
		<tr class="thead-dark">
			<th scope="col">Bike ID</th>
			<th scope="col">Brand</th>
			<th scope="col">Model Name</th>
			<th scope="col">Running</th>
			<th scope="col">Registration Date</th>
			<th scope="col">Price</th>
			<th scope="col">Seller Mob No.</th>
			<th scope="col">Seller Name</th>
			<th scope="col">Bike Location</th>
			<th scope="col">Status</th>
			<th scope="col">Action</th>
		</tr>
		<tbody>
			<c:forEach var="ibikes" items="${interestedBikes}">
				<tr>
					<th scope="row">${ibikes.bike.id}</th>
					<th scope="row">${ibikes.bike.brand}</th>
					<th scope="row">${ibikes.bike.modelName}</th>
					<th scope="row">${ibikes.bike.running}</th>
					<th scope="row">${ibikes.bike.regDate}</th>
					<th scope="row">${ibikes.bike.price}</th>
					<th scope="row">${ibikes.bike.contactNo}</th>
					<th scope="row">${ibikes.bike.contactName}</th>
					<th scope="row">${ibikes.bike.address}</th>
					<th scope="row">${ibikes.status}</th>
					<th>
						<div class="dropdown">
							<button class="dropbtn">Action</button>
								<div class="dropdown-content">
									<c:if test="${ibikes.status == 'APPROVED' and empty ibikes.bike.state }">
										<spring:url value="/paymentmode?bikeid=${ibikes.bike.id}&receiptId=${ibikes.id}"
											var="paymentURL" />
											<a href="${paymentURL}">Buy</a>
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