package com.global.tx.serv;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.transaction.UserTransaction;



@WebServlet("/TwoWayCommitServlet")
public class TwoWayCommitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		     //This Hashtable is used to configure all configuration information to perform lookup logic 
		      Hashtable<String, String> h = new Hashtable<String, String>(7);
		      h.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		      h.put(Context.PROVIDER_URL, "t3://127.0.0.1:7001"); //For example "t3://127.0.0.1:7001"
		      h.put(Context.SECURITY_PRINCIPAL, "administrator");
		      h.put(Context.SECURITY_CREDENTIALS, "administrator@123");
		      InitialContext context;
		      
		      //UserTransaction Object Those Jars are comming from ojdbc6 which is there in ApacheTomcat bin directory
		      //that directory i addd to user Library
		      UserTransaction transaction = null;
		      boolean flag = false;
	          try{
	        	  
	            int totalBalance = 0;
				context = new InitialContext(h);
				transaction = (UserTransaction) context.lookup("javax/transaction/UserTransaction");
				
				/* All the Connections which are comming from Different Datasources have some limitations
				 * If you are using XA Drivers you can get the connections from respective DataSource but those connections by default autoCommit true.
				 * If you access the same connections inside the Transaction boundary it will become false that will be done by TransactionManager inside Application Server
				 * Where as if you use NonXA Driver you have to lookup the Connection Objects from DataSource inside the Transaction Boundry.
				 * Because if you do it outside as usevally by default autocommit true.but inside transaction boundry also it will acts as auto commit true
				 * So there will be no use of doing the Transactions with that connection
				 * 
				 * After this Step Application Server will perform lot of internal operations are like below
				 * Creating there ResourceFactory and Getting TrasactionalResource and Then it will get XAResource after that it will
				 * Enlist the resources to TransactionManger. Then it will call start() method from XAResource then it will call the 
				 * Connection Method from TransactionalResource.All These Steps it will perform
				 * 
				 * Here we are getting The different DataSources/Connection Objects
				 * 
				 * 1)Oracle Connection and MySql Connection These DataSources are  are configured by Using XA Drivers(Their Respective Drivers)
				 * 
				 * 2)In Case of Remaining 2 DataSources we configured without XA Drivers.But Still the WebLogic Server will support the GlobalTransactions
				 *   With SomeConditions incase of this we can achieve GlobalTransactions by configuring either
				 *   
				 *   a)Emulate Two-Phase Commit: With this option, the transaction branch in which the connection is used always returns success
				 *     for the prepare phase of the transaction. It offers performance benefits, but also has risks to data in some failure 
				 *     conditions. Select this option only if your application can tolerate heuristic conditions. See Understanding the 
				 *     Emulate Two-Phase Commit Transaction Option.
				 *   b)Logging Last Resource: With this option, the transaction branch in which the connection is used is processed as the
				 *     last resource in the transaction and is processed as a local transaction. Commit records for two-phase commit (2PC) 
				 *     transactions are inserted in a table on the resource itself, and the result determines the success or failure of the 
				 *     prepare phase of the global transaction. This option offers some performance benefits and greater data safety than 
				 *     Emulate Two-Phase Commit, but it has some limitations. See Understanding the Logging Last Resource Transaction Option.
				 *     Note : Logging Last Resource is not supported for data sources used by a multi data source.
				 *     
				 * Here we have to open the Connection After The Transaction has begin other wise Connection Object will be created with auto commit true
				 * Where as incase of XA Datasource Where ever you created the connection Object inside the begin Transaction it will be false
				 * 
				 *  If you force to use Global Transaction with OnePhaseCommit then it will Throw Exception saying 
				 *   a)One-Phase Commit: (selected by default) With this option, a connection from the data source can be the only participant 
				 *   in the global transaction and the transaction is completed using a one-phase commit optimization. If more than one resource 
				 *   participates in the transaction, an exception is thrown when the transaction manager calls XAResource.prepare 
				 *   on the 1PC resource
				 *   Could not prepare resource 'OracleDataSourceWith1PC_base_domain
                 *   JDBC driver does not support XA, hence cannot be a participant in two-phase commit. To force this participation,
                 *   Set the GlobalTransactionsProtocol attribute to LoggingLastResource (recommended) or EmulateTwoPhaseCommit 
                 *   for the Data Source = OracleDataSourceWith1PC
                 *   These will not participate in Global Transaction Exception if you ask to do it will throw RollBack Eception
				 *   
				 *  */
				
				transaction.begin();
				
				//These two DataSources are XA DataSources so these DataSources internally contain ConnetionPooling 
				//And support Global Transactions with Two Way Commit
				DataSource oracleDataSource = (javax.sql.DataSource) context.lookup("oraclejndi");
				DataSource mySqlDataSource = (javax.sql.DataSource) context.lookup("mysqldatasource");
				
				/* This Rmi DataSource is implementing sal DataSource this interface is extending the remaing two Interfaces ConnectionPoolDataSource
				 * and XA DataSources
				 * */
				 System.out.println("oracle DataSource Object  "+oracleDataSource.getClass().getName());
				for(Class classType : oracleDataSource.getClass().getClasses()){
					System.out.println("Parent classes are "+classType.getName());
					for(Class classType1 : classType.getClasses()){
						System.out.println(classType.getName()+" for this parent interfaces are  "+ classType1.getName());
						for(Class classType2 : classType1.getClasses()){
							System.out.println(classType1.getName()+" for this parent interfaces are "+classType2.getName());
						}
					}
				}
				System.out.println("mysql DataSource Object  "+mySqlDataSource.getClass().getName());
				
				//These Connection Objects are comming from Above DataSources
				Connection oracleConnection = oracleDataSource.getConnection();
				Connection mysqlConnection = mySqlDataSource.getConnection();
				
				/*To Know the Implementation classes of These Connections and it will display the all implementation interfaces
				 *  and classes for it you can easily find out that it is using XAConnection and it is also implementing the 
				 *  PooledConnection interface also so our connection object will support global transactions and connection pooling also
				 * 
				System.out.println("oracle Connection Object  "+oracleConnection.getClass().getName());
				for(Class classType : oracleConnection.getClass().getInterfaces()){
					System.out.println("Parent classes are "+classType.getName());
					for(Class classType1 : classType.getInterfaces()){
						System.out.println(classType.getName()+" for this Parent classes are  "+ classType1.getName());
					}
				}
				System.out.println("mysql Connection Object  "+mysqlConnection.getClass().getName());*/
				
				//These DataSources are Non XA DataSources Are Configured in Weblogic server
				//DataSource oracleDataSourceWith1PC = (javax.sql.DataSource) context.lookup("oracleJndiWith1PC");
				DataSource oracleDataSourceWithEmulate2PC = (javax.sql.DataSource) context.lookup("oracleJndiWithEmulate2PC");
				//DataSource oracleDataSourceWithLLR = (javax.sql.DataSource) context.lookup("oracleJndiWithLLR")
				
				//These are the Connections Comming from above DataSources
				//Connection oracleConnectioneWith1PC = oracleDataSourceWith1PC.getConnection(); //With in Same resource Table it will insert so it will throw exception
				  Connection oracleConnectionWithEmulate2PC =  oracleDataSourceWithEmulate2PC.getConnection();
				//Connection oracleConnectionWithLLR = oracleDataSourceWithLLR.getConnection();//If more than one resource participates throws Exception
				
				//Checking these Connection Objects are AutoCmmited or not inside transaction as well as outside Transaction
				System.out.println("OracleXAConnection  "+oracleConnection.getAutoCommit());
				System.out.println("MySqlXAConnection  "+mysqlConnection.getAutoCommit());
				
				//Checking these Connection Objects are AutoCmmited or not inside transaction as well as outside Transaction
				//System.out.println("OracleConnetionWith1PC   "+oracleConnectioneWith1PC.getAutoCommit());
				System.out.println("OracleConnetionWithEmulate2PC   "+oracleConnectionWithEmulate2PC.getAutoCommit());
				//System.out.println("OracleConnetionWithLLR   "+oracleConnectionWithLLR.getAutoCommit());
				
				PreparedStatement preparedStatementForTotal = mysqlConnection.prepareStatement("select BALANCE from sys.ICICI_BANK where ACC_NO = 'ICIC012'");
				ResultSet rs = preparedStatementForTotal.executeQuery();
				
				while(rs.next()){
					totalBalance = rs.getInt(1);
				}
				
				totalBalance =totalBalance - 100;
				
				PreparedStatement preparedStatementForUpdateFlipkart = oracleConnectionWithEmulate2PC.prepareStatement("update FLIPKART set WALLET = ? where USERNAME = 'Rajini'");
				preparedStatementForUpdateFlipkart.setString(1,"100");
				
				PreparedStatement preparedStatementForUpdateICICI = mysqlConnection.prepareStatement("update sys.ICICI_BANK set BALANCE = ? where ACC_NO ='ICIC012';");
				preparedStatementForUpdateICICI.setInt(1, totalBalance);
				
				int k = preparedStatementForUpdateFlipkart.executeUpdate();
				int j = preparedStatementForUpdateICICI.executeUpdate();
				
				System.out.println("no of records are updated  "+k);
				System.out.println("no of records are updated  "+j);
				flag = true;
				
				}catch(Exception e){
					System.out.println("inside catch block");
					e.printStackTrace();
				}finally{
					   try {
						if(flag){
							transaction.commit();	
							System.out.println("commited");
						   }
						else{
							System.out.println("not commited");
							transaction.rollback();
					   	   }
					     } 
					   catch(Exception e){
						   System.out.println("inside second catch block");
						  System.out.println(e);
					     }
					   
					   //Here we are commenting bcz we have commented transaction.rollback() so if we have not commented this line it will throw 
					   //all thse checked exceptions so we have commented this catch block and have written normal catch block
					   /*catch (SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
							| HeuristicRollbackException | SystemException e) {
						e.printStackTrace();
					}*/
				}
	}
}
