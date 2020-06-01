<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<style>
.left{
    margin-left: 20px;
}
label{
    display: inline-block;
    width: 170px;
    text-align: right;
}
input[type="submit"]{
margin-left: 190px;
}
</style>
</head>
<body>
	<h1>Register</h1>
	<form action="registerUser" method="post">
		<label>Email</label><input type="email" name="email" required class="left" /><br><br>
		<label>Password</label><input type="password" name="pwd" required class="left" /><br><br>
		<input type="submit" value="Register"/>
	</form>
</body>
</html>