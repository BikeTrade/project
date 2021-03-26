<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="btag" tagdir="/WEB-INF/tags/" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
    <title>User Registration Form</title>
   
</head>
<body>
<btag:header />
 
</form>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
        <spring:url value="/registration"  var="regURL"/>
            <form:form autocomplete="off"  action="${regURL}" method="post" class="form-horizontal" role="form" modelAttribute="user">
               <br/> <br/><h2>User Registration Form</h2>
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
                        <form:input type="text" name="name" placeholder="User Name"
                            path="userName"   class="form-control"/> 
                            <div class="has-error">
                                 <form:errors path="userName" class="text-danger"/>
                             </div>
                    </div>
                </div>
                
                <div class="form-group">
                    <div class="col-sm-9">
                        <form:input type="password" name="password" path="password"
                               placeholder="Password" class="form-control"/> 
                         <div class="has-error">
                                 <form:errors path="password" class="text-danger"/>
                          </div>      
                    </div>
                </div>
                
                <div class="form-group">
                    <div class="col-sm-9">
                        <form:input type="text" name="contactNo" path="contactNo"
                               placeholder="Contact No" class="form-control"/> 
                         <div class="has-error">
                                 <form:errors path="contactNo" class="text-danger"/>
                          </div>      
                    </div>
                </div>
                
                <div class="form-group">
                    <div class="col-sm-9">
                    	<form:select path="address" name="address" class="form-control">
                    	    <option>Select City</option>
                    		<form:options items="${cities}"/>
                    	</form:select>   
       	                <div class="has-error"><form:errors path="address" class="text-danger"/></div>  
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-9">
                        <button type="submit" class="btn btn-primary btn-block">Register User</button>
                    </div>
                </div>

                <h2><span class="text-success">${successMessage}</span></h2>
            </form:form>
           
        </div>
    </div>
    
</div>
<btag:footer />
</body>

</html>