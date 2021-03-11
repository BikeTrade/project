<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url value="/css/style.css" var="style" />
<link rel="stylesheet" type="text/css" href="${style}">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<header class="header">
		<nav class="navbar navbar-style">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#micon">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>

					<spring:url value="/images/logo.png" var="logo" />
					<a href=""><img class="logo" src="${logo}"></a>
				</div>
				<div class="collapse navbar-collapse" id="micon">
					<ul class="nav navbar-nav navbar-right ">
						
						<li><a href="<c:url value="/" />">Home</a></li>						
						<li><a href="<c:url value="/registration" />">User Register</a></li>
						<li><a href="<c:url value="/used/bikes" />">Used Bike</a></li>						
						
						<c:if test="${pageContext.request.userPrincipal.name == null}">							
							<li><a href="<c:url value="/login"  />">Login</a></li>
						</c:if>
						
						<c:if test="${pageContext.request.userPrincipal.name != null}">	
						  <sec:authorize access="hasAuthority('ADMIN')">
							    <li><a href="<c:url value="/admin/show" />">Admin Page</a></li>
							</sec:authorize>
						    <sec:authorize access="hasAuthority('USER')">
							    <li><a href="<c:url value="/registrationbike" />">Sell Bike</a></li>							
								<li><a href="<c:url value="/myaccount" />">My Account</a></li>
							</sec:authorize>									 
						    <li><a href="<c:url value="/logout" />">Logout</a></li>
											   
						</c:if>
						<c:if test="${pageContext.request.userPrincipal.name != null}">	
							<span>  Hi  ${pageContext.request.userPrincipal.name }	</span>
						</c:if>			
					</ul>
				</div>
			</div>
		</nav>

		<div></div>
	</header>