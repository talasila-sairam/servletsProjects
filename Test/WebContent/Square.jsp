<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="assm.math.dao.SingleOperation" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
            String operation=request.getParameter("sai");
            String clientName=(String)session.getAttribute("client");
       try
       {
    	         int i3=Integer.parseInt(request.getParameter("number3"));
                  if(operation.equalsIgnoreCase("SQARE"))
                  {
                   int k=new SingleOperation().insertValues(operation,clientName);
    	           out.println(operation+"  is"  +(i3*i3)); 	   
                  }
                  else if(operation.equalsIgnoreCase("CUBE"))
                  {
                   int k=new SingleOperation().insertValues(operation,clientName);
    	           out.println(operation+"  is"  +(i3*i3*i3)); 	   
                  }
                  else if(operation.equalsIgnoreCase("DOUBLE"))
                  {
                   int k=new SingleOperation().insertValues(operation,clientName);
    	           out.println(operation+"  is"  +(2*i3)); 	   
                  }
                   else 
                   {
                   out.println("Operation is not available");
                   }    
        }
       catch(Exception e)
       {
    	   out.println("Provide Valid Data");
       }
%>
</body>
</html>