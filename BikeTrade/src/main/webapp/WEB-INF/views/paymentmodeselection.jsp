<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="btag" tagdir="/WEB-INF/tags/" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.js" integrity="sha512-dqw6X88iGgZlTsONxZK9ePmJEFrmHwpuMrsUChjAw1mRUhUITE5QU9pkcSox+ynfLhL15Sv2al5A0LVyDCmtUw==" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css" integrity="sha512-8bHTC73gkZ7rZ7vpqUQThUDhqcNFyYi2xgDgPDHc+GXVGHXq+xPjynxIopALmOPqzo9JZj0k6OqqewdGO3EsrQ==" crossorigin="anonymous" />
	<style type="text/css">
				.container{
							background-color: skyblue;
						  }
				.formdiv {
						  margin-top:"140";
						  width: 500px;
						  height: 600px;
						  padding: 50px;
						  border: 1px solid black;
						  box-sizing: border-box;
						  max-width: 500px;
  						  margin: auto;
  						  background-color: white;
					  }	
				.ui positive button{
							margin-left: auto;
							margin-right: auto;
				}		  	  
	</style>

</head>
<body class="container">
<div class="formdiv">
<spring:url value="/payment/success"  var="paymentSuccessUrl"/>
<form class="ui form" action="${paymentSuccessUrl}" method="POST" id="authenticationForm"> 	 
		<h2 class="ui dividing header">Billing Information</h2>			
		<label>Billing Address</label>
			<div class="two fields">
				<div class="field">
        			<input type="text" name="firstName" placeholder="First Name">	
      			</div>
      			<div class="field">
        			<input type="text" name="lastName" placeholder="Last Name">
      			</div>	
  			</div>
 
 
 

      		<div class="field">
      			<lable>Address Line 1</lable>
        			<input type="text" name="street" placeholder="House No, Name, Street Name">
      		</div>
      		<div class="field">
      			<lable>Address Line 2</lable>
        			<input type="text" name="area" placeholder="Area Name, Land Mark, Sub-Dist, District">
      		</div>
        
			<div class="two fields">
				<div class="field">
      				<label>City</label>
        			<input type="text" name="city" placeholder="City">	
      			</div>
      			<div class="field">
      				<label>ZIP</label>
        			<input type="number" name="zipCode" placeholder="zipCode">
      			</div>	
  			</div>
			<div class="two fields">
    			<div class="field">
      				<label>State</label>
      					<select name="state" class="ui fluid dropdown">
					        <option value="">Select State</option>
							    <option value="AP">Andhra Pradesh</option>
							    <option value="AR">Arunachal Pradesh</option>
							    <option value="AS">Assam</option>
							    <option value="BR">Bihar</option>
							    <option value="CT">Chhattisgarh</option>
							    <option value="GA">Goa</option>
							    <option value="GJ">Gujarat</option>
							    <option value="HR">Haryana</option>
							    <option value="HP">Himachal Pradesh</option>
							    <option value="JK">Jammu and Kashmir</option>
							    <option value="JH">Jharkhand</option>
							    <option value="KA">Karnataka</option>
							    <option value="KL">Kerala</option>
							    <option value="MP">Madhya Pradesh</option>
							    <option value="MH">Maharashtra</option>
							    <option value="MN">Manipur</option>
							    <option value="ML">Meghalaya</option>
							    <option value="MZ">Mizoram</option>
							    <option value="NL">Nagaland</option>
							    <option value="OR">Odisha</option>
							    <option value="PB">Punjab</option>
							    <option value="RJ">Rajasthan</option>
							    <option value="SK">Sikkim</option>
							    <option value="TN">Tamil Nadu</option>
							    <option value="TG">Telangana</option>
							    <option value="TR">Tripura</option>
							    <option value="UT">Uttarakhand</option>
							    <option value="UP">Uttar Pradesh</option>
							    <option value="WB">West Bengal</option>
							    <option value="AN">Andaman and Nicobar Islands</option>
							    <option value="CH">Chandigarh</option>
							    <option value="DN">Dadra and Nagar Haveli</option>
							    <option value="DD">Daman and Diu</option>
							    <option value="DL">Delhi</option>
							    <option value="LD">Lakshadweep</option>
							    <option value="PY">Puducherry</option>
      					</select>
    				</div>	 

    			<div class="field">
      				<label>Country</label>
      					<select class="ui fluid dropdown" name="country">
        					<option value="">Select Country</option>
		    					<option value="IND">India</option>
	  					</select>			    
    			</div>
  			</div>	  
			<div class="two fields">
				<div class="field">
      				<label>Contact No</label>
        			<input type="number" name="contactNo" placeholder="Contact No">	
      			</div>
      			<div class="field">
      				<label>Email Id</label>
        			<input type="email" name="email" placeholder="abc@test.com">
      			</div>	
  			</div>
  				<input type="hidden" name="razorpay_payment_id" id="razorpay_payment_id">
				<input type="hidden" name="razorpay_order_id" id="razorpay_order_id">
				<input type="hidden" name="razorpay_signature" id="razorpay_signature">
				<input type="hidden" name="bikeId" value="${bikeid}"/>
				<input type="hidden" name="receiptId" value="${receipt}"> 
		<button class="ui positive button" id="rzp-button1" tabindex="0">Make Payment</button>
	</form>
</div>
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script>

var options = {
    "key": '${secretKey}', // Enter the Key ID generated from the Dashboard
    "amount": '${price}', // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise
    "currency": "INR",
    "name": "${bike.modelName}",
    "description": "Bike Purchase",
    "image": "https://example.com/your_logo",
    "order_id": "${orderId}", 
    "handler": function (response){
    	document.getElementById("razorpay_payment_id").value=response.razorpay_payment_id;
    	document.getElementById("razorpay_order_id").value=response.razorpay_order_id;
    	document.getElementById("razorpay_signature").value=response.razorpay_signature;
    	document.getElementById("authenticationForm").submit();
    },
    "prefill": {
        "name": "${user.userName}",
        "email": "${user.email}",
        "contact": "${user.contactNo}"
    },
    "notes": {
        "address": "BikeTrade Corporate Office"
    },
    "theme": {
        "color": "#3399cc"
    }
};
var rzp1 = new Razorpay(options);
rzp1.on('payment.failed', function (response){

	/*  
	    alert(response.error.code);
        alert(response.error.description);
        alert(response.error.source);
        alert(response.error.step);
        alert(response.error.reason);
        alert(response.error.metadata.order_id);
        alert(response.error.metadata.payment_id); 
        
        */
        
});
document.getElementById('rzp-button1').onclick = function(e){
    rzp1.open();
    e.preventDefault();
}
</script>
<%-- <spring:url value="/payment/success"  var="paymentSuccessUrl"/>
<form action="${paymentSuccessUrl}" method="POST" id="authenticationForm"> 


</form> --%>

</body>
</html>
