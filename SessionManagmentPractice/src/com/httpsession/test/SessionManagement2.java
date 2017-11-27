package com.httpsession.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet(name="ForwardingServlet",urlPatterns={"/test2"})
public class SessionManagement2 extends HttpServlet 
{     
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw=response.getWriter();
		String uname=request.getParameter("name");
		String upwd=request.getParameter("pwd");
		try
		{
		if(uname.equals(uname))
		{
			HttpSession session=request.getSession();
			session.setAttribute(uname, upwd);
			RequestDispatcher rd=request.getRequestDispatcher("/test1");
			rd.forward(request, response);
		}
		else
		{
			pw.println("Provided Credentials are invalid plz provide valid credentials....");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
		}
		catch(Exception e){pw.println(e.getMessage());}
	}

}
