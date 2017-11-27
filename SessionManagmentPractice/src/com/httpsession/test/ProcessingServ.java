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

public class ProcessingServ extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			String s=(String) session.getAttribute("uname");
		    String s2=(String)session.getAttribute("upwd");
		    pw.println(s+"     "+s2);
		}
		        
	}

}
