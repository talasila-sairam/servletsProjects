<%@ page import="javax.naming.spi.DirStateFactory.Result"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page  session="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
   <%!
   public JSONObject userValid()
	{
	   System.out.println("inside userValid method");
	    JSONObject obj=new JSONObject();
		ArrayList<String> al = new ArrayList<String>();
	    try
    	{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/sai","root","root");  
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from lessoperations");
		while(rs.next())
		{
			al.add(rs.getString("operation"));
			System.out.println(rs.getString(2));
		}
	    }
	    catch(Exception e)
	    {
	    System.out.println(e);
	    }
	    obj.put("author",al);
	    return obj; 
	}
   %>
   <% 
        response.setContentType("application/json");
        JSONObject jsonObj=userValid();
        out.print(jsonObj);   
   %>