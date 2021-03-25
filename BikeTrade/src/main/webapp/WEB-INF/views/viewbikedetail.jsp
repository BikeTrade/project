<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="btag" tagdir="/WEB-INF/tags/" %>
<!DOCTYPE html>
<html>
	<head>
	  <head>  
     <title>viewBikeDetails</title>  
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>  
  </head>  
<style>  
  .carousel-inner > .item > img,  
  .carousel-inner > .item > a > img {  
      width: 80%;  
      margin: auto;  
  }  
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>  
		<style type="text/css">
			.overlay {
			  position: fixed;
			  top: 0;
			  left: 0;
			  bottom: 0;
			  right: 0;
			  background: rgba(0,0,0,.7);
			}
			
			.overlay__wrapper {
			  width: 100%;
			  height: 100%;
			  position: relative;
			}
			
			.overlay__spinner {
			  position: absolute;
			  left: 50%;
			  top: 50%;
			  transform: translate(-50%, -50%);
			}
		</style>
  </head>
 
<body>  
<btag:header />
	<spring:url value="/bike/interested"  var="interestedURL"/>
		<table style="width:50%;" border="3" align="center">
			<thead>	
			  	<tr>
			    	<th colspan="4" class="text-center">Bike Details</th>
			  	</tr>
			  	<tr>
			    	<th colspan="4" class="text-left">Bike ID: ${bike.id}</th>
			  	</tr>
			  	<tr>
			  		<th colspan="4" style="width:50px;height:50px;" >
			  			<div id="myCarousel" class="carousel slide" data-ride="carousel">  
						    <!-- Indicators -->  
						    <ol class="carousel-indicators">  
						      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>  
						      <li data-target="#myCarousel" data-slide-to="1"></li>  
						      <li data-target="#myCarousel" data-slide-to="2"></li>  
						    </ol>  
		  
						    <!-- Wrapper for slides -->  
						    <div class="carousel-inner" role="listbox">
						    <c:forEach var = "image" items="${desktopImages}" varStatus="loopCount" >
						    	<c:if test="${loopCount.count eq 1}">
									<div class="item active">  
								        <img src="data:${image.type};base64,${image.src}" alt="jokes 1" class="responsive" >  
								     </div>  
								</c:if>
								<c:if test="${loopCount.count ne 1}">
									<div class="item ">  
								        <img src="data:${image.type};base64,${image.src}" alt="jokes 1" class="responsive" >  
								    </div>
						     	</c:if>  
						    </c:forEach>  
							</div>  
		  
						    <!-- Left and right controls -->  
						    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">  
						    	<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>  
								<span class="sr-only">Previous</span>  
						    </a>  
						    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">  
						    	<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>  
						    	<span class="sr-only">Next</span>  
						    </a>  
						</div><!-- corousel end --> 
			  		</th>
			  	</tr>
				<tr>
				    <th class="text-left"><b>Brand Name</b></th>
				    <th class="text-left">${bike.brand}</th>
				    <th class="text-left"><b>Model Name</b></th>
				    <th class="text-left">${bike.modelName}</th>
				</tr>
				<tr>
				    <th class="text-left"><b>Running</b></th>
				    <th class="text-left">${bike.running}</th>
				    <th class="text-left"><b>Registration Date</b></th>
				    <th class="text-left">${bike.regDate}</th>
				</tr>
				<tr>
				    <th class="text-left"><b>Insurance</b></th>
				    <th class="text-left">${bike.insurance}</th>
				    <th class="text-left"><b>Price</b></th> 
				    <th class="text-left">${bike.price}</th>
				</tr>
				  <tr>
				    <th class="text-left"><b>Contact Name</b></th>
				    <th class="text-left">${bike.contactName}</th>
				    <th class="text-left"><b>Contact Number</b></th> 
				    <th class="text-left">${bike.contactNo}</th>
				</tr>
				<tr>
				    <th class="text-left"><b>Address</b></th>
				    <th class="text-left">${bike.address}</th>
				    <th class="text-left"><b>Status</b></th> 
				   	<th class="text-left">${interestedInfo.status}</th>
				</tr>						
				<tr>
					<th class="text-center" colspan="4" align="center">
				 
						<form autocomplete="off"  action="${interestedURL}" method="post" class="form-horizontal"  >
						    <input type="hidden" name="bikeId" value="${bike.id}" />
							<button type="submit" class="btn btn-success">I am Interested</button>
						</form>
						<h3><b><span class="text-success">${successMessage}</span></b></h3>
					</th>
				</tr>
			</thead>
		</table> 

</body>
</html>