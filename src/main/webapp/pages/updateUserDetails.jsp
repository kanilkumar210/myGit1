<%@page import="com.pack.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<h3 style="color: skyblue; text-align: center;">Update User
				Details</h3>
			<hr>
			<div class="col-md-4 offset-4">

				<form action="updateUser" modelAttribute="userBean">
					<div class="form-group">
						<label for="corporateId">Corporate Id</label> <input type="number"
							class="form-control" name="corporate.corporate_id"
							value="${userBean.corporate.corporate_id}" readonly="readonly">
					</div>
					<div class="form-group">
						<label for="loginId">Login Id</label> <input type="number"
							class="form-control" value="${userBean.login_id}" name="login_id"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="username">User Name</label> <input type="text"
							value="${userBean.username}" class="form-control" name="username"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="department">Department</label> <input type="text"
							value="${userBean.department}" placeholder="Department"
							name="department" class="form-control" required="required">
					</div>
					<div class="form-group">
						<label for="address">Address</label> <input type="text"
							placeholder="Address" class="form-control" required="required"
							name="address" value="${userBean.address}">
					</div>
					<div class="form-group">
						<label for="mobNumber">Mobile Number</label> <input type="tel"
							placeholder="850XXXX123" class="form-control" pattern="[0-9]{10}"
							title="Ten digits code" required="required" name="mobileNumber"
							value="${userBean.mobileNumber}">
					</div>
					<button type="submit" class="btn btn-success my-1 pt-1">submit</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>

