package assm.math.dao;
import java.sql.*;
import assm.math.service.ServiceProvider;

public class DualOperation 
{
	Connection con;	
	public int insertValues(String operation,String clientName)
	{
		int i=0;
	     try
		   {   
		    ServiceProvider sp=new ServiceProvider();
	    	con=sp.getConnection();   
	        Statement stmt=con.createStatement();  
	        ResultSet rs=stmt.executeQuery("select * from login where username='"+clientName+"'");
	        if(rs.next())
	         {
	    	// System.out.println("inside if condition");
	    	 int j=rs.getInt(operation);
	    	 System.out.println(j);
	         i=stmt.executeUpdate("update login set "+operation+"="+(1+j)+" where username='"+clientName+"'");
	         System.out.println("data is inserted  "+i);
	         }
	     con.close();
		}  
	   catch(Exception e)
	    {  
		System.out.println(e);
	    }
	   return i;
	}
}
