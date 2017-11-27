package com.httpsession.test;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ResponseServ")
public class ResponseServ extends HttpServlet 
{
	public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession(false);
		if(session==null)
		{
			pw.println("no session information available");
		}
		else
		{
			Enumeration e=session.getAttributeNames();
			while(e.hasMoreElements())
			{
				String name=(String)e.nextElement();
				String value=(String)session.getAttribute(name);
				pw.print(name+"     "+value+"<br>");
			}
			long l1=session.getCreationTime();
			long l2=session.getLastAccessedTime();
			int l3=session.getMaxInactiveInterval();
			pw.println("<h3>The creation time is    :"+new Date(l1)+"</h3>");
			pw.println("<h3>The last acessed time is    :"+new Date(l2)+"</h3>");			
			pw.println("<h3>max inactive interval is    :"+l3+"</h3>");
		}
	}
}
