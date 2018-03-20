<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="assm.math.dao.Details" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
   session=request.getSession(false);
   System.out.println(session);
   String clientName=(String)session.getAttribute("client");
   System.out.println(clientName);
   if(session != null)
   {
	   try
		{   
	        ResultSet rs=new Details().getResult(clientName);
	       %>
	       <table border="1" style="background: green;">
	          <tr><th>USERNAME</th>
	              <th>PASSWORD</th>
	              <th>ADDITION</th>
	              <th>SUTRACTION</th>
	              <th>MULTIFLICATION</th>
	              <th>DIVISION</th>
	              <th>SQUARE</th>
	              <th>DOUB</th>
	              <th>CUBE</th></tr></tr>
	             <% 
	             if(rs.next())
	             {
	            	 System.out.println("inside if condition");
	            	 System.out.println(rs.getString(1));
	            	 
	             %>
	             <tr>
	             	<td><%= rs.getString(1)%></td>
	             	<td><%= rs.getString(2)%></td>
	             	<td><%= rs.getInt(3)%></td>
	             	<td><%= rs.getInt(4)%></td>
	             	<td><%= rs.getInt(5)%></td>
	             	<td><%= rs.getInt(6)%></td>
	             	<td><%= rs.getInt(7)%></td>
	             	<td><%= rs.getInt(8)%></td>
	             	<td><%= rs.getInt(9)%></td>
	             </tr>
	             <%   
	             
	             }
	             %>
	       </table>
	       <%
		}  
	   catch(Exception e)
	    {  
		System.out.println(e);
	    }
   }
%>
</body>
</html>