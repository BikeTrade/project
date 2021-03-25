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
		<b>Request for My Bike</b>
	</h3>
	
	<table border="1" class="table table-striped table-borderd">
	<c:forEach var="ibikes" items="${bikes}">
		<tr class="thead-dark">
			<th scope="col">Bike ID</th>
			<th scope="col">Brand</th>
			<th scope="col">Model Name</th>
			<th scope="col">Running</th>
			<th scope="col">Price</th>
			<th scope="col">Location</th>
		</tr>
		<tbody>
		<tr>
			<th scope="row">${ibikes.id}</th>
			<th scope="row">${ibikes.brand}</th>
			<th scope="row">${ibikes.modelName}</th>
			<th scope="row">${ibikes.running}</th>
			<th scope="row">${ibikes.price}</th>
			<th scope="row">${ibikes.bLocation}</th>
		</tr>
				
		<tr class="thead-dark">
			<th scope="col">Interested Buyer Name</th>
			<th scope="col">Buyer Email Id</th>
			<th scope="col">Buyer Contact No</th>
			<th scope="col">Buyer Address</th>
			<th scope="col">Status</th>
			<th scope="col">Action</th>
		</tr>
		
		<c:forEach var="iuser" items="${ibikes.interestedUsers}">
		<tr>	
			<th scope="row">${iuser.interestedUser.userName}</th>
			<th scope="row">${iuser.interestedUser.email}</th>
			<th scope="row">${iuser.interestedUser.contactNo}</th>
			<th scope="row">${iuser.interestedUser.address}</th>
			<th scope="row">${iuser.status}</th>
			<th>
				<div>
					<div class="dropdown">
							<button class="dropbtn">Action</button>
								<div class="dropdown-content">
						<c:if test="${ibikes.state != 'SOLD'}">
							<spring:url value="/interestRequest?bikeid=${ibikes.id}&userid=${iuser.interestedUser.id}"
								var="approveURL" />
								<a href="${approveURL}">Approve</a>
						</c:if>
						</div>
				</div>
			</th>	
		</tr>
		</c:forEach>
		</tbody>		
		</c:forEach>
	</table>
</body>
</html>