<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="assm.math.dao.DualOperation" %>
    <%@ page import="java.sql.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
           String clientName=(String)session.getAttribute("client");
           String operation=request.getParameter("sai");
         try
          {
    	   int i1=Integer.parseInt(request.getParameter("number1"));
           int i2=Integer.parseInt(request.getParameter("number2"));
          
                if(operation.equalsIgnoreCase("ADDITION"))
                  {
                	//System.out.println(clientNam);
                	int k=new DualOperation().insertValues(operation,clientName);
    	             out.println(operation+"  is"  +(i1+i2)); 	   
                  }
                  else if(operation.equalsIgnoreCase("SUBTRACTION"))
                  {
                	  int k=new DualOperation().insertValues(operation,clientName);
    	              out.println(operation+"  is"  +(i1-i2)); 	   
                  }
                   else if(operation.equalsIgnoreCase("MULTIFLICATION"))
                    {
                	   int k=new DualOperation().insertValues(operation,clientName);
    	               out.println(operation+"  is"  +(i1*i2)); 	   
                    }
                   else if(operation.equalsIgnoreCase("DIVISION"))
                   {
                	   int k=new DualOperation().insertValues(operation,clientName);
    	               out.println(operation+"  is"  +(i1/i2)); 	   
                   }  
        }
       catch(Exception e)
       {
    	   out.println("Provide Valid Data");
       }
%>
</body>
</html>