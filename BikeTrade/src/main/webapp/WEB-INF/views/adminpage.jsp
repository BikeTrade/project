<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Non Approved</title>
 
 <link rel="stylesheet" type="text/css" href="/css/registration.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
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
<h5> ${message}</h5>
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
      <th scope="col"> Status</th>
      <th scope="col"> Action</th>
     
  </thead>
  
  
  <tbody>
  <c:forEach var="b" items="${NA_list}" >
    <tr>
     <th scope="row">${b.id}</th>
      <td> ${b.brand}</td>
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
  <spring:url value="/approve?bid=${b.id}"   var="approveURL"/>
  <a href="${approveURL}">Approve</a>
   <spring:url value="/reject?bid=${b.id}"   var="rejectURL"/>
    <a href="${rejectURL}">Reject</a>
  </div>
  	</div>
   </td>
    </tr>
    </c:forEach>
  </tbody>
 
</table>

</body>
</html>