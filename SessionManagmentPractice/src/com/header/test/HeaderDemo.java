package com.header.test;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HeaderDemo")
public class HeaderDemo extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession();
		HttpSession session2=request.getSession();
		HttpSession session3=request.getSession();
		HttpSession session4=request.getSession();
	    session.setAttribute("Hi","Hello");
	    Cookie cookie = new Cookie("How","Are you");
	    System.out.println(session.getId());
	    System.out.println(session2.getId());
	    System.out.println(session3.getId());
	    System.out.println(session4.getId());
	    response.addCookie(cookie);
	    response.setHeader("Cache-Control", "no-cache");
	    response.setHeader("Cache-Control", "no-store");
		Enumeration e=request.getHeaderNames();
		while(e.hasMoreElements())
		{
			String name=(String)e.nextElement();
			String value=(String)request.getHeader(name);
			pw.println(name+"     "+value+"<br>");
		}
		//session.setMaxInactiveInterval(3);

		session.invalidate();
		  cookie.setMaxAge(3);
	}
}

