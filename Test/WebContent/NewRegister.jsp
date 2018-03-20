<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="assm.math.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="cssfiles/NewRigister.css">
<script src="jquery-3.1.1.js"></script>
<script src="jsfiles/NewRegister.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NEW REGISTRARTION</title>
</head>
<body>
<form id="form1" action="/Test/RegisterServlet">
<pre>
<center>
EnterFirstName    :<input type="text" name="fname" placeholder="FirstName" id="fname" required ><br>
EnterPassword     :<input type="password" name="pwd" placeholder="password" id="pwd"><br>
ReEnterPassword   :<input type="password" name="pwd1" placeholder="RePassword" id="pwd1"><br>
                   <button type="submit" id="btn" >REGISTER</button>
</center>
</pre>
</form>
</body>
</html>