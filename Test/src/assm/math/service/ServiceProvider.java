package assm.math.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServiceProvider 
{
  public Connection getConnection() throws SQLException, ClassNotFoundException
  {
	    Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sai","root","root");
		return con;
  }
}
