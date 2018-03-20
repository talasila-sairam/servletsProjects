<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MATH OPERATIONS</title>
<link rel="stylesheet" type="text/css" href="cssfiles/mathoperations.css">
<script src="jquery-3.1.1.js"></script>
<script src="jsfiles/mathoperations.js"></script>
</head>
<body>
   <div>
      <h1 align="center" style="color: blue;"> WELCOME TO ONLINE MATHOPERATIONS </h1> <h2 align="center">Hi  <%= (session.getAttribute("client")) %></h2><hr>
      
      <div id="div1"></div>
      
       <span>ACTION :</span><select id="myselect">
       <!--  <option value="ADDITION">ADDITION</option>
        <option value="SUBTRACTION">SUBTRACTION</option>
        <option value="MULTIFLICATION">MULTIFLICATION</option>
        <option value="DIVISION">DIVISION</option>
        <option value="SQARE">SQARE</option> -->
       </select>
    
     <button id="btn">SELECT</button>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
       <span id="spn1">ADD HERE :</span><select   id="tolselect">
       <option value="ADDITION">ADDITION</option>
       <option value="SUBTRACTION">SUBTRACTION</option>
       <option value="MULTIFLICATION">MULTIFLICATION</option>
       <option value="DIVISION">DIVISION</option>
       <option value="SQARE">SQARE</option>
       <option value="CUBE">CUBE</option>
       <option value="DOUBLE">DOUBLE</option>
     </select>
     
     <button type="button" id="opr">ADD</button>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
     
     <button type="button" id="details">VIEW DETAILS</button>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
     
     <button onclick="document.location.href='/Test/logout'">LOGOUT</button><br><br><br>
     
     <div class="main" id="mydiv" ></div><br><br>
		
     <div align="left" id="result"></div><br>
     
     <div align="center" id="send"></div>
     
     </div>
</body>
</html>