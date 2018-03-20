package com.ssl.jsse.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/testServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/*
	    JUst we need to uncomment this one in servers.xml and before that you need to genrate keystore file either by you or you can use 
	    Tomcat Provided one. you can find it in conf folder of tomcat and provide the details of keyStoreFile Location and password of 
	    key and KeyStore. 
	 <Connector SSLEnabled="true" clientAuth="false" keystoreFile="C:/Users/t05053/.keystore" keystorePass="changeit" 
	 maxThreads="150" port="8443" protocol="org.apache.coyote.http11.Http11NioProtocol" scheme="https" secure="true" sslProtocol="TLS">
              <!--<SSLHostConfig>
                   <Certificate certificateKeystoreFile="conf/localhost-rsa.jks" type="RSA" />
              </SSLHostConfig> -->
    </Connector>
*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("inside doGet method");
		RequestDispatcher rd= request.getRequestDispatcher("/jsps/maintenence.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
