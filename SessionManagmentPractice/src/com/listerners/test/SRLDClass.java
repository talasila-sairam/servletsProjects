package com.listerners.test;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SRLDClass")
public class SRLDClass extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	 	PrintWriter pw=response.getWriter();
	 	pw.println("the no of requests for the web application is   :"+ServletRequestListenerDemo.count);
	}
}
