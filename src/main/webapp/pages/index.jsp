<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Home</title>
</head>
<style>
#heading {
	position: absolute;
	top: 30%;
	left: 16%;
	font-size: 80px;
	color: red;
}

.button1 {
	position: relative;
	left: 400px;
	top: 350px;
}

.button2 {
	position: relative;
	left: 500px;
	top: 350px;
}

button {
	display: inline-block;
	background-color: #7b38d8;
	border-radius: 10px;
	border: 4px double #cccccc;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	position: relative;
	font-size: 20px;
	margin: 0;
	top: 50%;
	left: 30%;
	width: 200px;
	cursor: pointer;
}

button:hover {
	background: green;
}

body {
	background-image:
		url(data:image/jpeg;base64,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);
	background-repeat: no-repeat;
	background-size: cover;
}
#heading
</style>

<body>
	<div id="heading">Welcome to Smart Bank Portal</div>
	<div>
		<a href="adminHome">
			<button class="button1">Admin Login</button>
		</a> <a href="accountSummary">
			<button class="button2">User Login</button>
		</a>
	</div>

</body>
</html>