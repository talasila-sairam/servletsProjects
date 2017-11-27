package com.wlserver.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;
import javax.sql.PooledConnection;



import oracle.jdbc.pool.OracleConnectionPoolDataSource;
import oracle.jdbc.pool.OracleDataSource;
import oracle.jdbc.pool.OraclePooledConnection;
import weblogic.store.io.jdbc.BasicDataSource;


import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

//@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("This is Test Program from Get Method");
           
	      PrintWriter out=response.getWriter();
	      String str=request.getRemoteUser();
	      String str1=request.getAuthType();
	      System.out.println(str);
	      out.println(str);
	      out.println(request.getAuthType());
	      out.println(request.getProtocol());
	      out.println(request.isSecure());
	      out.println(request.getUserPrincipal());
	      out.println("<h1>Hi    "+str1+"</h1>");
	      out.println("<h1>Hi    "+str+"</h1>");
	      if(request.isUserInRole("hero"))
	      {
	    	  out.println("This is admin homepage"+request.getRemoteUser());
	      }
	      else if(request.isUserInRole("vilan"))
	      {
	    	  out.println("this is manager home page");
	      }
	      else
	      {
	    	  out.println("This is others home page");
	      }
	      out.println("<h1>get:after authentication only we can acess this servlet</h1>");
	      
	      Hashtable<String, String> h = new Hashtable<String, String>(7);
	      h.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
	      h.put(Context.PROVIDER_URL, "t3://127.0.0.1:7001"); //For example "t3://127.0.0.1:7001"
	      h.put(Context.SECURITY_PRINCIPAL, "administrator");
	      h.put(Context.SECURITY_CREDENTIALS, "administrator@123");

	      InitialContext context;
		try {
			context = new InitialContext(h);
			DataSource dataSource = (javax.sql.DataSource) context.lookup("oraclejndi");
			
			System.out.println("dataSource name from weblogic "+dataSource.getClass().getName());
			
			Class[] classes = dataSource.getClass().getClasses();
			for(Class classOnly : classes){
				System.out.println(" class is  "+classOnly.getName());
			}
			
			Class[] interfaces = dataSource.getClass().getInterfaces();
			for(Class interfaceOnly : interfaces){
				System.out.println(" interface is    "+interfaceOnly.getName());
			}
			
			if(dataSource instanceof ConnectionPoolDataSource){
				System.out.println("it is instance of Connetion PoolDataSource");
			}else{
				System.out.println("Not an instance ");
			}
			
			//dataSource.getPooledConnection();
			  if(dataSource != null){
				  System.out.println("data Source is created");
				   Connection connection = dataSource.getConnection();
				   System.out.println("connection implemented class  "+connection.getClass().getName());
				   for(Class classType : connection.getClass().getClasses()){
					   System.out.println("Connection classes are   "+classType.getName());
				   }

				  /* PooledConnection pooledConection = dataSource.getPooledConnection();
				  Connection connection = pooledConection.getConnection();*/
				  DatabaseMetaData dataBaseMataData =  connection.getMetaData();
				  System.out.println("JDBC MAjor version   "+dataBaseMataData.getJDBCMajorVersion());
				  System.out.println("JDBC MAjor version   "+dataBaseMataData.getJDBCMinorVersion());
				  System.out.println("Driver Version  "+dataBaseMataData.getDriverVersion());
				  System.out.println("Driver Major Version   "+dataBaseMataData.getDriverMajorVersion());
				  System.out.println("Driver Minior Version   "+dataBaseMataData.getDriverMinorVersion());
				  System.out.println("Driver Name  "+dataBaseMataData.getDriverName());
				  Statement  st = connection.createStatement();
				  
				  OracleDataSource oracleDataSource = new OracleDataSource();
				  System.out.println("----------------------------------------------------------");
				  System.out.println("This is OracleDataSource is ");
				  for(Class classType : oracleDataSource.getClass().getInterfaces()){
					  System.out.println("classes are  "+classType.getName());
				  }
				  
				  
				  OraclePooledConnection pooledConnection = new OraclePooledConnection();
				  System.out.println("----------------------------------------------------------");
				  System.out.println("This is OraclePooledConnection ");
				  for(Class classType : pooledConnection.getClass().getInterfaces()){
					  System.out.println("classes are  "+classType.getName());
				  }
				  
				  
				  OracleConnectionPoolDataSource oracleConnectionPoolDataSource = new OracleConnectionPoolDataSource();
				  System.out.println("----------------------------------------------------------");
				  System.out.println("This is OracleConnectionPoolDataSources are ");
				  for(Class classType : oracleConnectionPoolDataSource.getClass().getInterfaces()){
					  System.out.println("classes are  "+classType.getName());
				  }
				  
				 /* boolean b = st.execute("create table Second_Tatble (user_id number(10) NOT NULL,user_name varchar2(50) NOT NULL,city varchar2(50))");
				  if(b){
					  System.out.println("table created");
				  }else{
					  System.out.println("not created");
				  }*/
			  }else{
				  System.out.println("Data Source Created    "+dataSource.hashCode());
			  }
			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw =response.getWriter();
		pw.println("This is Test Program from Post Method");
	}

}
