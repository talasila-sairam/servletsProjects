<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="assm.math.dao.DualOperation" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
     String clientName=(String)session.getAttribute("client");
     System.out.println("in Addition.jsp session is try to creating");
     String operation=request.getParameter("sai");
     try
       {
        int i1=Integer.parseInt(request.getParameter("number1"));
        int i2=Integer.parseInt(request.getParameter("number2"));

          if(operation.equalsIgnoreCase("ADDITION"))
            {
     	//System.out.println(clientNam);
     	int k=new DualOperation().insertValues(operation,clientName);
          out.println(operation+"  is  "+(i1+i2)); 	   
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