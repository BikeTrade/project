<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--import spring suppiled JSP tag lib for URL rewriting --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<%-- <html lang="en" xmlns="http://www.w3.org/1999/xhtml"/>--%>
<html>
<head>
	<meta charset="UTF-8">
    <title>Registration Form</title>
    <link rel="stylesheet" type="text/css" href="/css/registration.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<spring:url value="/login"   var="loginURL"/>
<form action="${loginURL}" method="get">
    <button class="btn btn-md btn-warning btn-block" type="Submit">Go To Login Page</button>
</form>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
        <spring:url value="/registration"  var="regURL"/>
            <form autocomplete="off"  action="${regURL}" method="post" class="form-horizontal" role="form">
                <h2>Registration Form</h2>
                <div class="form-group">
                    <div class="col-sm-9">
                          <input type="text" name="name" placeholder="Name"
                               class="form-control"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-9">
                        <input type="text" name="lastName"
                               placeholder="Last Name" class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-9">
                        <input type="text" name="email" placeholder="Email"
                               class="form-control"/> 
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-9">
                        <input type="text" name="userName" placeholder="User Name"
                               class="form-control"/> 
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-9">
                        <input type="password" name="password"
                               placeholder="Password" class="form-control"/> 
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-9">
                        <button type="submit" class="btn btn-primary btn-block">Register User</button>
                    </div>
                </div>

                <h2><span class="text-success">${successMessage}</span></h2>

            </form>
        </div>
    </div>
</div>

</body>
</html>