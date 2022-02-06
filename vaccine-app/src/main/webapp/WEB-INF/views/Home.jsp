<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/style.css">
<title>Home</title>
</head>
<body
	style="background-image: url('images/images.jpg'); background-repeat: no-repeat; background-attachment: fixed; background-size: 100% 100%;">
	<header>
		<div>
			<span style="margin-left: 8%; color: white; font-size: 35px;">Ministry of
				health and family welfare</span>
			<div>
				<a href="getLogin.vaccine"
					style="text-align: right; margin-left: 5%; margin-bottom: 50%; font-size: large; color: white;">Login</a>
				<a href="getSignUp.vaccine"
					style="text-align: right; margin-left: 80%; margin-bottom: 50%; font-size: large; color: white;">SignUp</a>
			</div>

			<!-- <img src="images/logo.jpg" class="logo" /> -->
		</div>
	</header>

<table>
<tr>
<td> <div style="text-align: center; margin-left: 550px;font-size: 28px; font-weight: bold;">Welcome to Co-Vaccine</div></td>
		<td ><div style="margin-left: 310px; color: green;font-size: large;">${username}</div></td>|
<td><a href="logout.vaccine"
			style="text-align: right; margin-left: 20px; font-size: large;"class="btn btn-primary"; role="button";>Logout</a></td>
</tr>
</table>
	 
	<h2 style="margin-left: 560px; color: green;font-size: medium; font-weight: bold;">${verifyMessage}</h2>
	<h2 style="margin-left: 560px; color: green;font-size: medium; font-weight: bold;">${savedMsg}</h2>
<a href="addMember.vaccine" class="btn btn-primary btn-lg active" role="button" aria-pressed="true" style="margin-left: 600px">Add Member</a></body>
<footer>
	<div>Copyright © 2021. All Rights Reserved</div>
</footer>
</html>