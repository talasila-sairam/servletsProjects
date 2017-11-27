package com.httpsession.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet(name="ProcessingServlet",urlPatterns={"/test1"})
public class SessionManagment1 extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession(false);
		         if(session != null)
		            {
		              pw.println("Hello your session was Created with an Id of"+session.getId());
		              Enumeration<String> e=session.getAttributeNames();
		              while(e.hasMoreElements())
		                {
			              String uname=e.nextElement();
			              String uvalue=(String)session.getAttribute(uname);
			              pw.println(uname+"      "+uvalue);
		                }
		               long s1=session.getCreationTime();
		               long s2=session.getLastAccessedTime();
	 	               pw.println("The session creation time is     :"+new Date(s1));
		               pw.println("The Last accessed time is     :"+new Date(s2));
	                 }
		         else
		         {
		 			pw.println("Your Session is not avilable plz Login Once Again....");
		 			RequestDispatcher rd=request.getRequestDispatcher("index.html");
		 			rd.include(request, response);
		         }
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
