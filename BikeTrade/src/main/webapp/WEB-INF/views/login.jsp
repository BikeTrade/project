<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%>
<%@ taglib prefix="btag" tagdir="/WEB-INF/tags/" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<spring:url value="/css/loginstyle.css" var="login" />
<link rel="stylesheet" type="text/css" href="${login}">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<btag:header />
	<div class="login-box">
		<spring:url value="/login"  var="loginURL"/>
        <form:form autocomplete="off"  action="${loginURL}" method="post" class="form-horizontal" >
		<spring:url value="/images/avatar.png" var="avatar" />
		<img src="${avatar}" alt="avtar">
			<div class="form-input">
				<i class="fa fa-user fa-2x cust" aria-hidden="true"></i>
				<input type="text" placeholder="Enter Username" name="user_name" value=""><br/>
				<i class="fa fa-unlock-alt fa-2x cust" aria-hidden="true"></i>
				<input type="password" placeholder="Enter Password" name="password" value=""><br/>
				<input type="submit" name="submit" value="LOGIN"><br/><br/>
				<spring:url value="/registration" var="signup" />
				<h4><a href="${signup}">Click Here For New User Registration</a></h4>
			</div>		
		</form:form>
	</div>	
</body>
</html>