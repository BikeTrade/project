<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Receipt</title>
<style>
* {
	border: 0;
	box-sizing: content-box;
	color: inherit;
	font-family: inherit;
	font-size: inherit;
	font-style: inherit;
	font-weight: inherit;
	line-height: inherit;
	list-style: none;
	margin: 0;
	padding: 0;
	text-decoration: none;
	vertical-align: top;
}

/* heading */
h1 {
	font: bold 100% sans-serif;
	letter-spacing: 0.5em;
	text-align: center;
	text-transform: uppercase;
}

/* table */
table {
	font-size: 75%;
	table-layout: fixed;
	width: 100%;
}

table {
	border-collapse: separate;
	border-spacing: 2px;
}

th, td {
	border-width: 1px;
	padding: 0.5em;
	position: relative;
	text-align: left;
}

th, td {
	border-radius: 0.25em;
	border-style: solid;
}

th {
	background: #EEE;
	border-color: #BBB;
}

td {
	border-color: #DDD;
}

/* page */
html {
	font: 16px/1 'Open Sans', sans-serif;
	overflow: auto;
	padding: 0.5in;
}

html {
	background: #46a6d2;
	cursor: default;
}

.divbody {
	box-sizing: border-box;
	height: 5.5in;
	margin: 0 auto;
	overflow: hidden;
	padding: 0.5in;
	width: 8.5in;
}

.divbody {
	background: #FFF;
	border-radius: 1px;
	box-shadow: 0 0 1in -0.25in rgba(0, 0, 0, 0.5);
}

/* header */
header {
	margin: 0 0 3em;
}

header:after {
	clear: both;
	content: "";
	display: table;
}

header h1 {
	background: #000;
	border-radius: 0.25em;
	color: #FFF;
	margin: 0 0 1em;
	padding: 0.5em 0;
}

header address {
	float: left;
	font-size: 75%;
	font-style: normal;
	line-height: 1.25;
	margin: 0 1em 1em 0;
}

header address p {
	margin: 0 0 0.25em;
}

header span, header img {
	display: block;
	float: right;
}

header span {
	margin: 0 0 1em 1em;
	max-height: 25%;
	max-width: 50%;
	position: relative;
}

article, table.meta, table.inventory {
	margin: 0 0 3em;
}

article:after {
	clear: both;
	content: "";
	display: table;
}

article h1 {
	clip: rect(0, 0, 0, 0);
	position: absolute;
}

/* table meta & balance */
table.meta, table.balance {
	float: right;
	width: 36%;
}
table.meta1 {
	float: left;
	width: 36%;
}

table.meta:after, table.balance:after {
	clear: both;
	content: "";
	display: table;
}

/* table meta */
table.meta th {
	width: 40%;
}

table.meta td {
	width: 60%;
}

/* table items */
table.inventory {
	clear: both;
	width: 100%;
}

table.inventory th {
	font-weight: bold;
	text-align: center;
}
/* table balance */
table.balance th, table.balance td {
	width: 50%;
}

table.balance td {
	text-align: right;
}

/* aside */
@page {
	margin: auto;
}

.thanktag{
	align-content: center;
}
</style>
</head>
<body>
	<div class="divbody">
	<header>
		<h1>RECEIPT</h1>
	</header>
	<article>
		<table class="meta1">
			<tr>
				<th><span>Reciver</span></th>
				<td><span>${payment.address.firstName} ${payment.buyer.lastName}</span></td>
			</tr>
			<tr>
				<th><span>Reciver Adress</span></th>
				<td><span>${payment.address.street} ${payment.address.area} <br>${payment.address.city} <br>${payment.address.state} <br>${payment.address.country}<br>
				${payment.address.email}<br>${payment.address.contactNo}
				</span></td>
			</tr>
			
		</table>


		<table class="meta">
			<tr>
				<th><span>Transaction Id</span></th>
				<td><span data-prefix>BT03</span><span>${payment.receiptId}</span></td>
			</tr>
			<tr>
				<th><span>Date</span></th>
				<td><span><script> document.write(new Date().toLocaleDateString()); </script></span></td>
			</tr>
			<tr>
				<th><span>Payee Name</span></th>
				<td><span>${payment.address.firstName} ${payment.buyer.lastName}</span></td>
			</tr>
		</table>
		<table class="inventory">
			<thead>
				<tr>
					<th><span>Brand Name</span></th>
					<th><span>Model Name</span></th>
					<th><span>OwnerShip</span></th>  
					<th><span>Price</span></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><span>${payment.bike.brand}</span></td>
					<td><span>${payment.bike.modelName}</span></td>
					<td><span>${payment.bike.user.name} ${payment.bike.user.lastName}</span></td>
					<td><span data-prefix>₹</span><span>${payment.amount}</span></td>
				</tr>
			</tbody>
		</table>

		<table class="balance">
			<tr>
				<th><span>Total</span></th>
				<td><span data-prefix>₹</span><span>${payment.amount}</span></td>
			</tr>
			<tr>
				<th><span>Amount Paid</span></th>
				<td><span data-prefix>₹</span><span>${payment.amount}</span></td>
			</tr>
			<tr>
				<th><span>Payment Mode</span></th>
				<td><span>${payment.mode}</span></td>
			</tr>
			<tr></tr>
			<tr>
				<spring:url value="/"  var="homeURL"/>
				<th><a href="${homeURL}">Print</a></th>
				<th><a href="${homeURL}">Download</a></th>
			</tr>	
		</table>
	</article>
	</div>	
</body>
</html>