<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="btag" tagdir="/WEB-INF/tags/" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<spring:url value="/css/style.css" var="style" />
<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
    <title>BikeRegistration Form</title>

</head>
<body>
<btag:header />
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
        <spring:url value="/registrationbike"  var="bikeURL"/>
            <form:form autocomplete="off"  action="${bikeURL}" method="post" class="form-horizontal" role="form" modelAttribute="bikeform" enctype="multipart/form-data">
                <h3>Bike Registration Form</h3>
				<div class="form-group">
                    <div class="col-sm-9">
                    	<form>
                          	<form:select path="brand" name="brand" class="form-control" >
                            	<form:option value="" label ="Select Brand"/>
                              	<form:options  items = "${requestScope.brand_names}" />
                           	</form:select>
                    	<class="form-control" /form>
                            <div class="has-error"><form:errors path="brand" class="text-danger" />
                            </div>   
                    </div>
                </div>
				
				<div class="form-group">
                    <div class="col-sm-9">
                          <form:input type="text" path="modelName" name="modelname" placeholder="Bike model name"
                               class="form-control"/>
                            <div class="has-error"><form:errors path="modelName" class="text-danger"/></div>   
                    </div>
                </div>
				
				<div class="form-group">
                    <div class="col-sm-9">
                          <form:input type="text" path="running" name="running" placeholder="KMs Driven"
                               class="form-control"/>
                            <div class="has-error"><form:errors path="running" class="text-danger"/></div>   
                    </div>
                </div>
				
				<div class="form-group">
                    <div class="col-sm-9">
                          <form:input type="date" path="regDate" name="regDate" placeholder="Registration Date"
                               class="form-control"/>
                            <div class="has-error"><form:errors path="regDate" class="text-danger"/></div>   
                    </div>
                </div>
             
				<div class="form-group">
                    <div class="col-sm-9">
                          <form:input type="number" path="noOfOwner" name="noOfOwner" placeholder="OwnerShip"
                               class="form-control"/>
                            <div class="has-error"><form:errors path="noOfOwner" class="text-danger"/></div>   
                    </div>
                </div>
				
				<div class="form-group">
                    <div class="col-sm-9" class="radio-toolbar">
                    	  <form >
                    	  <input type="radio"name="insurance" id="true" value="true" checked>
                    	  <label for="true">Insurance Yes</label>
						  <input type="radio" name="insurance" id="false" value="false">
						  <label for="false">Insurance No</label>
						  <class="form-control" /form>
                          <div class="has-error"><form:errors path="insurance" class="text-danger"/></div>   
                    </div>
                </div>
			
				<div class="form-group">
                    <div class="col-sm-9">
                          <form:input type="date" path="iExpDate" name="iExpDate" placeholder="Insurance Expire Date"
                               class="form-control"/>
                            <div class="has-error"><form:errors path="iExpDate" class="text-danger"/></div>   
                    </div>
                </div>
                
				<div class="form-group">
                    <div class="col-sm-9">
                          <form:input type="text" path="price" name="price" placeholder="Price to Sold"
                               class="form-control"/>
                            <div class="has-error"><form:errors path="price" class="text-danger"/></div>   
                    </div>
                </div>
				
				<div class="form-group">
                    <div class="col-sm-9">
                          <form:input type="text" path="contactNo" name="contactNo" placeholder="Contact Number"
                               class="form-control"/>
                            <div class="has-error"><form:errors path="contactNo" class="text-danger"/></div>   
                    </div>
                </div>
				
				<div class="form-group">
                    <div class="col-sm-9">
                          <form:input type="text" path="contactName" name="contactname" placeholder="Name"
                               class="form-control"/>
                            <div class="has-error"><form:errors path="contactName" class="text-danger"/></div>   
                    </div>
                </div>
				
				<div class="form-group">
                    <div class="col-sm-9">
                          <form:input type="text" path="address" name="address" placeholder="Address"
                               class="form-control"/>
                            <div class="has-error"><form:errors path="address" class="text-danger"/></div>   
                    </div>
                </div>
				
				<div class="form-group">
                    <div class="col-sm-9">
                          <form:input type="text" path="bLocation" name="blocation" placeholder="Bike Location"
                               class="form-control"/>
                            <div class="has-error"><form:errors path="bLocation" class="text-danger"/></div>   
                    </div>
                </div>
                
                <div class="form-group">
                    <div class="col-sm-9">
                          <form:input type="hidden" path="status" 
                               class="form-control"/>   
                    </div>
                </div>
                
               <div class="form-group">
                    <div class="col-sm-9">
                          <input type="file" name ="leftImage"   placeholder="Upload images"
                               class="form-control" />
                    </div>
                </div>
                
                <div class="form-group">
                    <div class="col-sm-9">
                          <input type="file" name ="rightImage"   placeholder="Upload images"
                               class="form-control" />
                    </div>
                </div>
                
                <div class="form-group">
                    <div class="col-sm-9">
                          <input type="file" name ="frontImage"   placeholder="Upload images"
                               class="form-control" />
                    </div>
                </div>
                
                <div class="form-group">
                    <div class="col-sm-9">
                          <input type="file" name ="backImage"   placeholder="Upload images"
                               class="form-control" />
                    </div>
                </div>
                
			    <div class="form-group">
                    <div class="col-sm-9">
                        <button type="submit" class="btn btn-primary btn-block">Register Bike</button>
                    </div>
                </div>
                
                <h2><span class="text-success">${successMessageB}</span></h2>
            </form:form>
          </div>
       </div>
  </div>              
</body>
</html>