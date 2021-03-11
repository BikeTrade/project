<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="btag" tagdir="/WEB-INF/tags/" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
    <title>Update User Registration</title>
    
</head>
<btag:header />
<body>
<spring:url value="/login?error=false"   var="loginURL"/>
<a href="${loginURL}" value ="Login"><h5>Go To Login Page</h5></a>
<form action="${loginURL}" method="get">
  <%--  <button class="btn btn-md btn-warning btn-block" type="Submit">Go To Login Page</button> --%>

</form>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
        <spring:url value="/edit"  var="editURL"/>
            <form:form autocomplete="off"  action="${editURL}" method="post" class="form-horizontal" role="form" modelAttribute="user">
                <h2>Registration Form</h2>
                <div class="form-group">
                    <div class="col-sm-9">
                       
                          <form:input type="text" path="name" name="name" placeholder="Name" 
                               class="form-control"/>
                               <div class="has-error">
                                 <form:errors path="name" class="text-danger"/>
                               </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-9">
                        <form:input type="text" name="lastName" path="lastName"
                               placeholder="Last Name" class="form-control"/>
                                <div class="has-error">
                                 <form:errors path="lastName" class="text-danger"/>
                               </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-9">
                        <form:input type="text" name="email" placeholder="Email" path="email"
                               class="form-control"/> 
                               <div class="has-error">
                                 <form:errors path="email" class="text-danger"/>
                               </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-9">
                        <button type="submit" class="btn btn-primary btn-block">Save Changes</button>
                    </div>
                </div>

                <h2><span class="text-success">${successMessage}</span></h2>

            </form:form>
        </div>
    </div>
</div>

</body>
</html>