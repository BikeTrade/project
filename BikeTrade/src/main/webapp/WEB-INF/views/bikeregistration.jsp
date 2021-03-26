<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="btag" tagdir="/WEB-INF/tags/" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                  <h2><span class="text-success">${successMessageB}</span></h2>
				<div class="form-group">
                    <div class="col-sm-9">
                   
                          <form:select path="brand"  class="form-control" id="options">
                          
                              <form:option value=""  label ="Select Brand"/>
                        		
  								<option value="HERO">HERO</option>
  								<option value="HONDA">HONDA</option>
  								<option value="YAMAHA">YAMAHA</option>
								<option value="TVS">TVS</option>
								<option value="ROYALENFIELD">ROYALENFIELD</option>
								<option value="BAJAJ">BAJAJ</option>
								<option value="KTM">KTM</option>
						
                          </form:select>
                            <div class="has-error"><form:errors path="brand" class="text-danger" />
                            </div>   
                    </div>
                </div>
				
				
				<div class="form-group">
                    <div class="col-sm-9">
                          <form:select id="choices" path="modelName"  class="form-control">
                                
                                <form:option value="" lable="Bike model name"/>
                               <option value="" disabled selected>Bike model name</option>
                              
  					
  								
                               </form:select>      
                            
  								<script type="text/javascript">
  								
								var lookup = {
							   'HERO': ['select HERO model',' Hero Splendor Plus','Hero Passion Pro', 'Hero Glamour','Hero Passion Pro 110','Hero HF Deluxe BS6'],
							   'HONDA': ['select HONDA model', 'Hness CB350','SP 125','Unicorn','Hornet 2.0'],
							   'YAMAHA': ['select YAMAHA model','MT-15','FZS-FI V3','FZ 25','FZ-FI Version 3.0'],
							   'ROYALENFIELD': ['select ROYALENFIELD model','Classic 350','Bullet 350', 'Himalayan','Meteor 350'],
							   'BAJAJ': ['select BAJAJ model','Bajaj Avenger Cruise 220','Bajaj Avenger Street 160', 'Bajaj Platina 100','Bajaj Platina 110'],
							   'KTM': ['select KTM model','KTM 200 Duke','KTM 125 Duke', 'KTM RC 390','KTM RC 200'],
							   'TVS': ['select TVS model','Apache RTR 160 4V','Apache RR 310', 'Apache RTR 200 4V','Apache RTR 180'],
								};
								
							
								$('#options').on('change', function() {
								
							   var selectValue = $(this).val();
			
							
								   $('#choices').empty();
		   
							
							   for (i = 0; i < lookup[selectValue].length; i++) {
						  
						      $('#choices').append("<option value='" + lookup[selectValue][i] + "'>" + lookup[selectValue][i] + "</option>");
							   }
								});
								</script>		                    
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
                    <div class="col-sm-9"><label  class="control-label">Bike Registration Date</label>
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
                    <div class="col-sm-9"><label  class="control-label">Insurance Expire Date</label>
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
                    <form>
                    	<form:select path="bLocation" name="blocation" class="form-control">
                    		<form:option value="" label ="Select Bike Location"/>
	                            <c:forEach items="${cities}" var="cities">
	                            	<option value="${cities}">${cities}</option>
	                            </c:forEach>
                    	</form:select>
                    	<class="form-control" /form>
                            <div class="has-error"><form:errors path="bLocation" class="text-danger"/></div>  
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
               
              
            </form:form>
          </div>
       </div>
  </div>    
          <btag:footer />   
</body>
</html>