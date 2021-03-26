<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
</head>
<header class="header">
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<!-- Brand -->
		<a class="navbar-brand" href="#"> <b><i
				class="fa fa-motorcycle" aria-hidden="true"></i> <i
				class="fa fa-btc" aria-hidden="true"></i> <b>ikeTrad</b> <i
				class="fa fa-etsy" aria-hidden="true"></i> </b>
		</a>

		<!-- Links -->
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" aria-current="page"
				href='<c:url value="/" />'><i class="fa fa-home"></i> Home </a></li>
			<li class="nav-item"><a class="nav-link"
				href='<c:url value="/used/bikes" />'><i class="fa fa-motorcycle"
					aria-hidden="true"></i> Used Bikes </a></li>
			<li class="nav-item"><a class="nav-link"
				href='<c:url value="/registration" />'><i
					class="fa fa-user-plus" aria-hidden="true"></i> Sign Up </a></li>
			<c:if test="${pageContext.request.userPrincipal.name == null}">
				<li class="nav-item"><a class="nav-link"
					href='<c:url value="/login"  />'><i class="fa fa-sign-in"
						aria-hidden="true"></i> Login </a></li>
			</c:if>
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<sec:authorize access="hasAuthority('ADMIN')">
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/admin/show" />"> <i
							class="fa fa-address-book" aria-hidden="true"></i> Admin Portal
					</a>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/getcount" />"><i class="fa fa-bar-chart"
							aria-hidden="true"></i>Staticstics</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/logout" />"><i class="fa fa-sign-out"
							aria-hidden="true"></i>Logout</a></li>

				</sec:authorize>
				<sec:authorize access="hasAuthority('USER')">
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/registrationbike" />"> <i
							class="fa fa-inr" aria-hidden="true"></i> Sell Bike
					</a></li>

					<!-- Dropdown -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbardrop"
						data-toggle="dropdown"> My Account </a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="<c:url value="/myaccount" />">My
								Profile</a> <a class="dropdown-item"
								href="<c:url value="/mybikedetails" />">My Bike Details</a> <a
								class="dropdown-item" href="<c:url value="/requestformybike" />">Request
								for My Bike</a> <a class="dropdown-item"
								href="<c:url value="/mywishlist" />">Wish List</a> <a
								class="dropdown-item" href="<c:url value="/orderhistory" />">Order
								History</a>
							<div class="dropdown-divider"></div>
							<a href="<c:url value="/logout" />" class="dropdown-item"><i
								class="fa fa-sign-out" aria-hidden="true"></i>Logout</a>
						</div></li>
				</sec:authorize>
			</c:if>
		</ul>
	</nav>
</header>
</html>
















