package assm.math.dao;

import java.sql.*;

import assm.math.service.ServiceProvider;

public class RegisterDb 
{
	int i;
	Connection con;
   public int insertDemo(String uname,String upd)
   {
	   try
    	{  
		ServiceProvider sp=new ServiceProvider();
		con=sp.getConnection();
		PreparedStatement pst=con.prepareStatement("INSERT INTO login (username, password) VALUES (?,?)");  
		pst.setString(1,uname);
		pst.setString(2, upd);
		i=pst.executeUpdate();
		con.close();  
		}
	    catch(Exception e)
	     {  
	    	System.out.println(e);
	     }
	   return i;
	}
}