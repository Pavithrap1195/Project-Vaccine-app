<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vaccination</title>
</head>
<body> 
	<h1>Register For Vaccine</h1>
	<h2>${ValidationEmailID }</h2>
	<div>
	<form action="processOTP.vaccine">
		<label>Enter EmailId</label> <input type="email" name="emailID"
			placeholder="Enter emailId"/>
			</br>
			<input type="submit"  value="Get OTP"/>
	</form>
	<h2>${SendingMessage }</h2>
	</div>
</body>
</html>