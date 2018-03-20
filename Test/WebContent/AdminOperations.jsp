<%@ page import="javax.naming.spi.DirStateFactory.Result"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
   <%!
   public JSONObject userValid(String operation)
	{
	    JSONObject obj=new JSONObject();
	    try
    	{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/sai","root","root");  
		Statement stmt=con.createStatement();
		System.out.println(operation);
		ResultSet rs=stmt.executeQuery("select * from lessoperations where operation="+"'"+operation+"'");
		System.out.println(rs);
		if(rs.next())
		{
				System.out.println(rs.getString("operation"));
				obj.put("info","already exists");		    
		}
		else
		{
			 PreparedStatement stmt1=con.prepareStatement("insert into lessoperations values(?,?)");
			 stmt1.setInt(1,0);
			 stmt1.setString(2,operation);
			 int i=stmt1.executeUpdate();
			 obj.put("info","added sucessfully");
			 System.out.println("inserted sucessfully");	
		}
	    }
	    catch(Exception e)
	    {
	    System.out.println(e);
	    }
	    return obj; 
	}
   %>
   <% 
        response.setContentType("application/json");
        String operation=request.getParameter("operation");
        JSONObject jsonObj=userValid(operation);
        out.print(jsonObj);   
   %>