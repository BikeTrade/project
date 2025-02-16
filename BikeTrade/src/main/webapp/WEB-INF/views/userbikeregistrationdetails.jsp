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



 <link rel="stylesheet" type="text/css" href="/css/registration.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
.dropbtn {
  background-color: #1E90FF;
  color: white;
  padding: 13px;
  font-size: 13px;
  border: none;
  cursor: pointer;
}

.dropdown {
background-color: #1E90FF;
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
  display: block;
}

.dropdown:hover .dropbtn {
  background-color: #3e8e41;
}




</style>
</head>
<body>
	<btag:header />

	<h3 class="text-left">
		<b>Registered Bike Details</b>
		
	</h3>
	
		<c:choose>
		<c:when test="${empty bikes}">

			<h1 class="text-center">${message}</h1>
		</c:when>
		<c:otherwise>
		
		
	<table border="1" class="table table-striped table-borderd">
		<tr class="thead-dark">
			<th scope="col">Bike ID</th>
			<th scope="col">Brand</th>
			<th scope="col">Model Name</th>
			<th scope="col">Running</th>
			<th scope="col">Registration Date</th>
			<th scope="col">Insurance</th>
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
	</c:otherwise>
	</c:choose>
	<btag:footer />
</body>
</html>