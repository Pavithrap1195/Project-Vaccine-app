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
<title>Sign-Up</title>
</head>
<body
	style="background-image: url('images/images.jpg'); background-repeat: no-repeat; background-attachment: fixed; background-size: 100% 100%;">
	<header>
		<div>
			<span>Ministry of health and family welfare</span> <img
				src="images/logo.jpg" class="logo" />
		</div>
	</header>
	<div class="container-fluid p-0 m-0">
		<div>
			<h1>SignUp For Vaccination</h1>
		</div>
		<br/>
		<div>${validateMessage}</div>
		<form action="signUp.vaccine" method="post" style="text-align: center;">
					<label for="username">User Name</label>
					<input name="userName" type="text" id="username"
						placeholder="User Name">
					<p style="color: red">${validateUserName}</p>
					<label for="number">Mobile Number</label>
					<input name="mobileNumber" type="number" id="number"
						placeholder="Mobile Number">
					<p style="color: red">${validatedMobileNumber}</p>
					<label for="gender">Gender</label>
					<input name="gender" type="radio" id="gender" value="Male">Male
						<input name="gender" type="radio" id="gender" value="Female">Female
						<input name="gender" type="radio" id="gender" value="Others">Others
					<p style="color: red">${validateGender}</p>
					<label for="dob">Date of Birth</label>
					<input name="dateOfBirth" type="date" id="dob"
						placeholder="DOB">
					<p style="color: red">${validateDOB}</p>
					<label for="password">Password</label>
					<input name="password" type="password" id="password"
						placeholder="Password">
					<p style="color: red">${validatePassword}</p>
					<label for="confirmpassword">Confirm Password</label>
					<input name="confirmPassword" type="password"
						id="confirmpassword" placeholder="Confirm Password">
					<p style="color: red">${validateConfirmPassword}</p>
					<input type="submit" class="btn btn-primary"
							style="text-align: center" value="Create Account"/>
			<%-- <table style="text-align: center;">
				<tr>
					<td><label for="username">User Name</label></td>
					<td><input name="userName" type="text" id="username"
						placeholder="User Name"></td>
					<td style="color: red">${validateUserName}</td>
				</tr>
				<tr>
					<td><label for="number">Mobile Number</label></td>
					<td><input name="mobileNumber" type="number" id="number"
						placeholder="Mobile Number"></td>
					<td style="color: red">${validatedMobileNumber}</td>
				</tr>
				<tr>
					<td><label for="gender">Gender</label></td>
					<td><input name="gender" type="radio" id="gender" value="Male">Male
						<input name="gender" type="radio" id="gender" value="Female">Female
						<input name="gender" type="radio" id="gender" value="Others">Others</td>
					<td style="color: red">${validateGender}</td>
				</tr>
				<tr>
					<td><label for="dob">Date of Birth</label></td>
					<td><input name="dateOfBirth" type="date" id="dob"
						placeholder="DOB"></td>
					<td style="color: red">${validateDOB}</td>
				</tr>
				<tr>
					<td><label for="password">Password</label></td>
					<td><input name="password" type="password" id="password"
						placeholder="Password"></td>
					<td style="color: red">${validatePassword}</td>
				</tr>
				<tr>
					<td><label for="confirmpassword">Confirm Password</label></td>
					<td><input name="confirmPassword" type="password"
						id="confirmpassword" placeholder="Confirm Password"></td>
					<td style="color: red">${validateConfirmPassword}</td>
				</tr>
				<tr>
					<td><button type="submit" class="btn btn-primary"
							style="text-align: center">Create Account</button></td>
				</tr>
			</table> --%>
		</form>
	</div>
</body>
<footer>
	<div>Copyright © 2021. All Rights Reserved</div>
</footer>
</html>