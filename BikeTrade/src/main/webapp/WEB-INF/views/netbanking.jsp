<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/registration.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>

.padding {
    padding: 5rem !important
}

.form-control:focus {
    box-shadow: 10px 0px 0px 0px #ffffff !important;
    border-color: #4ca746
}



</style>

<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"></script>
	<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<script>
	$(function($) {
        $('[data-numeric]').payment('restrictNumeric');
       
       
       
        
        $.fn.toggleInputError = function(erred) {
        this.parent('.form-group');
        return this;
        };
        $('form').submit(function(e) {
     
        var cardType = $.payment.cardType($('.cc-number').val());
       
     
        $('.cc-brand').text(cardType);
        $('.validation').removeClass('text-danger text-success');
        $('.validation').addClass($('.has-error').length ? 'text-danger' : 'text-success');
        });
        });</script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.payment/3.0.0/jquery.payment.min.js"></script>
 <br> <div class="container">
		<div class="well well-sm text-center">
			<h1>Make Payment</h1>
		</div>
		      <div class="well well-sm text-center">
			<h4>Net Banking</h4>
		</div>
    <div class="padding">
        <div class="row">
            <div class="container-fluid d-flex justify-content-center">
                <div class="col-sm-8 col-md-6">
                    <div class="card">
                
                        
                        <spring:url value="/netbank" var="debitURL" />
				<form:form autocomplete="off" action="${debitURL}" method="post"  modelAttribute="payment">
                        <div class="card-body" style="height: 350px">
                            <div class="form-group"> <label for="cc-number" class="control-label">Account Number</label> 
                            <input id="cc-number" type="tel" class="input-lg form-control cc-number" autocomplete="cc-number" placeholder="Enter Account Number" required> </div>
                            <div class="row">
                                
                                
                                  <form:input type="hidden" class="form-control" value="NET_BANKING"
						path="mode" />

					<form:input type="hidden" class="form-control" value="000"
						path="amount" />
                            </div>
                            <div class="form-group"> <label  class="control-label"> NAME</label>
                             <form:input type="text" path="payeeName" class="input-lg form-control" /> </div>
                             
                               <div class="form-group"> <label  class="control-label"> IFSC Code</label>
                             <input type="text"  class="input-lg form-control" required/> </div>
                             
                               <div class="form-group"> <label  class="control-label"> Bank Name</label>
                             <input type="text"  class="input-lg form-control" required/> </div>
                             
                               <div class="form-group"> <label  class="control-label"> Branch</label>
                             <input type="text"  class="input-lg form-control" required/> </div>
                            <div class="form-group"> <input value="MAKE PAYMENT" type="submit" class="btn btn-success btn-lg form-control" style="font-size: .8rem;"> </div>
                        </div>
                      
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</body>
</html>