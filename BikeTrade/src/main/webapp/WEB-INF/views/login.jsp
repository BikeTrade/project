<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--import spring suppiled JSP tag lib for URL rewriting --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<%-- <html xmlns="http://www.w3.org/1999/xhtml">--%>
<html>
<head>
	<meta charset="UTF-8">
    <title>Spring Security Tutorial</title>
    <link rel="stylesheet" type="text/css" href="/css/login.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<spring:url value="/registration"  var="regURL"/>
<form action="${regURL}" method="get">
    <button class="btn btn-md btn-warning btn-block" type="Submit">Go To Registration Page</button>
</form>

<div class="container">
<spring:url value="/login"   var="loginURL"/>
    <img src="/images/login.jpg" class="img-responsive center-block" width="300" height="300" alt="Logo"/>
    <form action="${loginURL}" method="POST" class="form-signin">
        <h3 class="form-signin-heading" >Welcome</h3>
		        <font color="red"> ${message}</font>
		      
		 
        <br/>
    
        <input type="text" id="user_name" name="user_name" placeholder="User Name"
               class="form-control"/> <br/>
        <input type="password" placeholder="Password"
               id="password" name="password" class="form-control"/> <br/>
               
        <button class="btn btn-lg btn-primary btn-block" name="Submit" value="Login" type="Submit">Login</button>
    </form>
    
</div>
</body>
</html>