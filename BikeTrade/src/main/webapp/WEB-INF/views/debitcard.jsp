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


	<script>$(function($) {
        $('[data-numeric]').payment('restrictNumeric');
        $('.cc-number').payment('formatCardNumber');
        $('.cc-exp').payment('formatCardExpiry');
        $('.cc-cvc').payment('formatCardCVC');
       
        
        $.fn.toggleInputError = function(erred) {
        this.parent('.form-group');
        return this;
        };
        $('form').submit(function(e) {
     
        var cardType = $.payment.cardType($('.cc-number').val());
        $('.cc-number').toggleInputError(!$.payment.CardNumber($('.cc-number').val()));
        $('.cc-exp').toggleInputError(!$.payment.CardExpiry($('.cc-exp').payment('cardExpiryVal')));
        $('.cc-cvc').toggleInputError(!$.payment.CardCVC($('.cc-cvc').val(), cardType));
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
		<p>

</p>
    <div class="padding">
        <div class="row">
            <div class="container-fluid d-flex justify-content-center">
                <div class="col-sm-8 col-md-6">
                    <div class="card">
                        <div class="card-header">
                            <div class="row">
                                <div class="col-md-6"> <span>CREDIT/DEBIT CARD PAYMENT</span> </div>
                                <div class="col-md-6 text-right" style="margin-top: -5px;"> <img src="https://img.icons8.com/color/36/000000/visa.png"> <img src="https://img.icons8.com/color/36/000000/mastercard.png"> <img src="https://img.icons8.com/color/36/000000/amex.png"> </div>
                            </div>
                        </div>
                        
                        <spring:url value="/debit" var="debitURL" />
				<form:form autocomplete="off" action="${debitURL}" method="post"  modelAttribute="payment" name="form">
                        <div class="card-body" style="height: 350px">
                            <div class="form-group"> <label for="cc-number" class="control-label">CARD NUMBER</label> 
                            <input id="cc-number" type="tel" class="input-lg form-control cc-number" autocomplete="cc-number" placeholder="•••• •••• •••• ••••" required> </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group"> <label for="cc-exp" class="control-label">CARD EXPIRY</label> 
                                    <input id="cc-exp" type="tel" class="input-lg form-control cc-exp" autocomplete="cc-exp" placeholder="MM / YY" required> </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group"> <label for="cc-cvc" class="control-label">CARD CVC</label> 
                                    <input id="cc-cvc" type="tel" class="input-lg form-control cc-cvc" autocomplete="off" placeholder="•••" required> </div>
                                </div>
                                
                                
                                  <form:input type="hidden" class="form-control" value="DEBIT_CARD"
						path="mode" name="paymentMode"/>

					<form:input type="hidden" class="form-control" value="000"
						path="amount" name="amount"/>
						
                            </div>
                            <div class="form-group"> <label  class="control-label">CARD HOLDER NAME</label>
                             <form:input type="text" path="payeeName" class="input-lg form-control" name ="payeeName"/> </div>
                           
                            <div class="form-group">
                             <input value="MAKE PAYMENT" type="submit" class="btn btn-success btn-lg form-control" style="font-size: .8rem;"> </div>
                        </div>
                      
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
    <btag:footer />
</body>
</html>