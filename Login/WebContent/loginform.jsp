<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<style>
.left{
    margin-left: 20px;
}
label{
    display: inline-block;
    width: 170px;
    text-align: right;
}
#msg{
color: tomato;
margin-left: 5px;
}
#reg{
color: blue;
margin-left: 5px;
}
input[type="submit"]{
margin-left: 190px;
}
a{
text-decoration: none;
}
</style>
</head>
<body>
	<h1>Login</h1>
	<form action="loginform" method="post">
		<label>Email</label><input type="email" name="email" class="left" required />
		<a href="./register.jsp"><span id="reg">${register}</span></a><br><br>
		<label>Password</label><input type="password" name="pwd" required class="left"/>
		<span id="msg">${message}</span><br><br>
		<input type="submit" value="Log In"/>
	</form>
</body>
<script type="text/javascript">
setTimeout(function() {
    $('#msg').fadeOut('slow');
}, 3000);
</script>
</html>