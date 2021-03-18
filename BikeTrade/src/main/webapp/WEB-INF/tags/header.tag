<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> 
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"/>
	<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
</head>
<header class="header">
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"><b><i class="fa fa-motorcycle" aria-hidden="true"></i><i class="fa fa-btc" aria-hidden="true"></i><b>ikeTrad</b><i class="fa fa-etsy" aria-hidden="true"></i></b></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
    <div class="collapse navbar-collapse" id="navbarText">
      <ul class="navbar-nav mr-auto">
			<li class="nav-item">
			  <a class="nav-link" aria-current="page" href='<c:url value="/" />'><i class="fa fa-home"></i>Home</a>
			</li>
			<li class="nav-item">
			  <a class="nav-link" href='<c:url value="/used/bikes" />'><i class="fa fa-motorcycle" aria-hidden="true"></i>Used Bikes</a>
			</li>
			<li class="nav-item">
			  <a class="nav-link" href='<c:url value="/registration" />'><i class="fa fa-user-plus" aria-hidden="true"></i> Sign Up</a>
			</li>
		<c:if test="${pageContext.request.userPrincipal.name == null}">	
			<li class="nav-item">
			  <a class="nav-link" href='<c:url value="/login"  />'><i class="fa fa-sign-in" aria-hidden="true"></i> Login</a>
			</li>
		</c:if>
		<c:if test="${pageContext.request.userPrincipal.name != null}">	
					<sec:authorize access="hasAuthority('ADMIN')">
						<li class="nav-item"><a class="nav-link" href="<c:url value="/admin/show" />"><i class="fa fa-address-book" aria-hidden="true"></i>Admin Page</a></li>
					</sec:authorize>
					<sec:authorize access="hasAuthority('USER')">
						<li class="nav-item"><a class="nav-link" href="<c:url value="/registrationbike" />"><i class="fa fa-inr" aria-hidden="true"></i>Sell Bike</a></li>							
						<li class="nav-item"><a class="nav-link" href="<c:url value="/myaccount" />"><i class="fa fa-user-circle-o" aria-hidden="true"></i>My Account</a></li>
					</sec:authorize>									 
					<li class="nav-item"><a class="nav-link" href="<c:url value="/logout" />"><i class="fa fa-sign-out" aria-hidden="true"></i>Logout</a></li>
		</c:if> 
      </ul>
      <span class="navbar-text">
      	<c:if test="${pageContext.request.userPrincipal.name != null}">	
			<span>Hi ${pageContext.request.userPrincipal.name }</span>
		</c:if>  
      </span>
    </div>
  </div>
</nav>
</header>
</html>			
								
				
				
						
						
						
						
				
	
	




  

	