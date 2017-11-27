package com.basicauthentication.test;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BasicAuthenticationDemo")
public class BasicAuthenticationDemo extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
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
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		  doGet(request,response);
	}

}
