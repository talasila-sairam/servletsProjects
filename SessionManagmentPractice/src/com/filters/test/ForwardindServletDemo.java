package com.filters.test;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ForwardindServletDemo")
public class ForwardindServletDemo extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter pw=response.getWriter();
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/ForwadedServlet");
		rd.forward(request, response);
		System.out.println("controller comes back");
		pw.println("This is the response ignored by web container");
		pw.print(10/0);
	}
}
