<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="btag" tagdir="/WEB-INF/tags/" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page isELIgnored = "false" %>
	
	<spring:url value="/css/adminstyle.css" var="style" />
	<link rel="stylesheet" type="text/css" href="${style}">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
 
</head>


<body>
	<btag:header />


	<c:choose>
		<c:when test="${empty NA_list}">

			<h1 class="text-center">${message}</h1>
		</c:when>
		<c:otherwise>



			<h1 class="text-center">${message}</h1>
			<h1 class="text-center">Admin</h1>
			<table class="table">
				<thead>
					<tr>
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
				</thead>
				<tbody>
					<c:forEach var="b" items="${NA_list}">
						<tr>
							<th scope="row">${b.id}</th>
							<td>${b.brand}</td>
							<td>${b.modelName}</td>
							<td>${b.running}</td>
							<td>${b.regDate}</td>
							<td>${b.insurance}</td>
							<td>${b.price}</td>
							<td>${b.contactNo}</td>
							<td>${b.contactName}</td>
							<td>${b.address}</td>
							<td>${b.status}</td>
							<td>
								<div class="dropdown">

									<button class="dropbtn">Action</button>
									<div class="dropdown-content">
										<spring:url value="/approve?bid=${b.id}" var="approveURL" />
										<a href="${approveURL}">Approve</a>
										<spring:url value="/reject?bid=${b.id}" var="rejectURL" />
										<a href="${rejectURL}">Reject</a>
									</div>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>

	<a href="<spring:url value='/getcount'/>">Summerise </a>
	 <spring:url value="/payment" var="debitURL" />
			
			
			
			
			
				<form autocomplete="off" action="${debitURL}" >
	<input type="radio" name="paymentmode" value="1"/>debitr
<input type="radio" NAME="paymentmode" VALUE="2"/>netbankr
<input type="radio" NAME="paymentmode" VALUE="3"/>upi
<input type="submit" value="pay radio"/>
</form>
</body>
</html>