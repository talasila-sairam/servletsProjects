package assm.math.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.taglibs.standard.tag.common.core.CatchTag;

import assm.math.service.ServiceProvider;

public class Details 
{
	Connection con;	
	Statement stmt;
	ResultSet rs;
	public ResultSet getResult(String clientName)
	{
	     try
		   {   
		    ServiceProvider sp=new ServiceProvider();
	    	con=sp.getConnection();   
	        stmt=con.createStatement();  
	        rs=stmt.executeQuery("select * from login where username='"+clientName+"'");
		   }
	        catch(Exception e)
		    {  
			System.out.println(e);
		    }
	     return rs;
    }
}
