package assm.math.dao;
import java.sql.*;

import javax.jws.soap.SOAPBinding;

import assm.math.service.ServiceProvider;
public class DataBaseValidation 
{
	Connection con=null;
	public boolean userValid(String uname,String pwd)
	{
	  boolean b=false;
	    try
        	{  
	    	ServiceProvider sp=new ServiceProvider();
	    	con=sp.getConnection();
		    Statement stmt=con.createStatement();  
		    ResultSet rs=stmt.executeQuery("select * from login where username='"+uname+"'");  
		    ResultSetMetaData rsmd =  rs.getMetaData();
		    if(rs.next()!=false)
		      {
			    if(rs.getString(1).equalsIgnoreCase(uname) & rs.getString(2).equalsIgnoreCase(pwd))
			      {
				    b=true;
				    System.out.println("user name and password are valid");
		       	  }
		        else
	      	      {
			        System.out.println("provide valid credentials");
		          }
		      }
		    con.close();  
		    }
	    catch(Exception e)
	     {  
	    	System.out.println(e);
	     }
	  return b;
	}
}
