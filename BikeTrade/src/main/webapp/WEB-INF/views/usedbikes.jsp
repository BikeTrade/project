<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="btag" tagdir="/WEB-INF/tags/" %>
<!DOCTYPE html>
<html>
  <script src="https://unpkg.com/react@16/umd/react.production.min.js"></script>
  <script src="https://unpkg.com/react-dom@16/umd/react-dom.production.min.js"></script>
  <script src="https://unpkg.com/babel-standalone@6.15.0/babel.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
  <style>
  .image-list{
  display:grid;
  grid-template-columns: repeat(auto-fill,minmax(250px,1fr));
  grid-gap:10px;
  }
  
  .image-list img{
  width:250px;
  }
  </style>
  <body>  
  <btag:header />
    <div id="mydiv"></div>
	<spring:url value="/js/App.js"  var="app" />
    <script type="text/babel"   src="${app} ">
    </script>
  </body>
</html>