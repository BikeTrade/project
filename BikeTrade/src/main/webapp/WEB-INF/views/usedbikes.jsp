<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="btag" tagdir="/WEB-INF/tags/" %>
<!DOCTYPE html>
<html>
	<head>
	<title>Used Bikes</title>
		<script src="https://unpkg.com/react@16/umd/react.production.min.js"></script>
		<script src="https://unpkg.com/react-dom@16/umd/react-dom.production.min.js"></script>
		<script src="https://unpkg.com/babel-standalone@6.15.0/babel.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
		<script src="https://unpkg.com/react-bootstrap@next/dist/react-bootstrap.min.js"></script>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.js"></script>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css" />
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
	<div class="ui breadcrumb">
		<a class="section">Home</a>
	  	<i class="right angle icon divider"></i>
	<div class="active section">Used Bike</div>
	</div>
    	<div id="mydiv"></div>
			<spring:url value="/js/App.js"  var="app" />
    			<script type="text/babel"   src="${app} "></script>
    	<btag:footer />		
</body>
</html>