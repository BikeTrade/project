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
.footer {
  bottom: 0; 
   width: 100%;
   background-color: #303030;
   color: white;
   text-align: center;
 
    position:absolute;
  
   }
</style>


  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> 
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"/>
	<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />


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
	<h5>${message}</h5>
	<h3 class="text-left">
		<b>Personal Details</b>
	</h3>
	<table border="1" class="table table-striped table-borderd">
		<tr class="thead-dark">
			<th scope="col">First Name</th>
			<th scope="col">Last Name</th>
			<th scope="col">Email</th>
			<th scope="col">Contact No</th>
			<th scope="col">Address</th>
			<%--<th scope="col">Action</th> --%>
		</tr>
		<tbody>
			<tr>
				<th scope="row">${user.name}</th>
				<th scope="row">${user.lastName}</th>
				<th scope="row">${user.email}</th>
				<th scope="row">${user.contactNo}</th>
				<th scope="row">${user.address}</th>
				<%--<th>
					<spring:url value="/edit"   var="updateURL"/>
					<a href="${updateURL}">Edit</a>
				</th> --%>
			</tr>
		</tbody>
	</table>
<footer>
<div class="footer" >
  <p>Copyright</p>

 
<p class="footer-links">
 <a   href='<c:url value="/" />'><i class="fa fa-home"></i>Home</a>


</p>
                <p class="footer-company-name"> © 2021 Bike trade Pvt. Ltd</p>
                <div class="footer-center">

                <div>
<i class="fa fa-phone"></i>
<p>+91 22-27782183</p>
</div>
               
                <div>
<i class="fa fa-envelope"></i>
<p><a href="mailto:support@biketrade.com">bike@trade2021.com</a></p>
</div>
</div>
</div>
</footer>
</body>
</html>