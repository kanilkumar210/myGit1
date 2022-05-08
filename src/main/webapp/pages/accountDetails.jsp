
<%@page import="org.springframework.web.bind.annotation.RequestParam"%>
<%@page import="com.pack.model.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.button3 {
	position: relative;
	left: 900px;
	top: -10px;
	background-color: blue;
	border-radius: 100px;
	box-shadow: rgba(44, 187, 99, .2) 0 -25px 18px -14px inset,
		rgba(44, 187, 99, .15) 0 1px 2px, rgba(44, 187, 99, .15) 0 2px 4px,
		rgba(44, 187, 99, .15) 0 4px 8px, rgba(44, 187, 99, .15) 0 8px 16px,
		rgba(44, 187, 99, .15) 0 16px 32px;
	color: white;
	cursor: pointer;
	display: inline-block;
	font-family: CerebriSans-Regular, -apple-system, system-ui, Roboto,
		sans-serif;
	padding: 7px 20px;
	text-decoration: none;
	transition: all 250ms;
	border: 0;
	font-size: 16px;
	user-select: none;
	-webkit-user-select: none;
	touch-action: manipulation;
}
</style>
</head>
<body style="background-color: powderblue;">
	<div class="container">
		<h2 style="color: blue; text-align: center;">Account Details</h2>
		<a href="/logout"><button class="button3"
				style="background-color: red;">Log Out</button></a>
		<hr>
		<div class="row">
			<div class="col-md-4 offset-4">
				<table style="font-size: 20px;">

					<tr>
						<td>Corporate Id</td>
						<td>:</td>
						<th>${acc.corporate.corporate_id}</th>
					</tr>
					<tr>
						<td>Account Number</td>
						<td>:</td>

						<th>${acc.accountNumber}</th>
					</tr>
					<tr>
						<td>Account Name</td>
						<td>:</td>

						<th>${acc.accountName}</th>
					</tr>
					<tr>
						<td>Branch</td>
						<td>:</td>

						<th>${acc.branch}</th>
					</tr>
					<tr>
						<td>Currency</td>
						<td>:</td>

						<th>${acc.currency}</th>
					</tr>
					<tr>
						<td>Available Balance</td>
						<td>:</td>

						<th>${acc.availableBalance}</th>
					</tr>
					<tr>
						<td>Opening Balance</td>
						<td>:</td>

						<th>1000</th>
					</tr>
					<tr>
						<td>Closing Balance</td>
						<td>:</td>

						<th>${acc.availableBalance}</th>
					</tr>

					<tr>
						<td>Transaction Summary</td>
						<td>:</td>
				</table>
			</div>
		</div>
	</div>
</body>
</html>