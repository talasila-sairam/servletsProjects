package com.httpsession.test;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ProcessServ")
public class ProcessServ extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw=response.getWriter();
		/*HttpSession session=request.getSession();
		if(session.isNew())
		{
			pw.println("<h2>New session got created with session id    :"+session.getId());
		}
		else
		{
		pw.print("<h2>An existing session id is only using with session id   :"+session.getId());	
		}
		String name=request.getParameter("uname");
		String val=request.getParameter("uval");
		session.setAttribute(name, val);
		session.setMaxInactiveInterval(30);*/
        
		String name=request.getParameter("uname");
		String val=request.getParameter("uval");
        Cookie c=new Cookie(name, val);
		c.setMaxAge(100);
		response.addCookie(c);
		RequestDispatcher req=request.getRequestDispatcher("userlogin.html");
		req.include(request, response);
	}
}
