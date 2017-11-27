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

public class ForwardindServ extends HttpServlet 
{     
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw=response.getWriter();
		String uname=request.getParameter("name");
		String upwd=request.getParameter("pwd");
		HttpSession sesssion=request.getSession();
		sesssion.setAttribute(uname, upwd);
		RequestDispatcher rd=request.getRequestDispatcher("/second");
		rd.forward(request, response);
		
	}

}
