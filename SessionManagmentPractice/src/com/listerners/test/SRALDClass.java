package com.listerners.test;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SRALDClass")

public class SRALDClass extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
     PrintWriter pw=response.getWriter();	
     request.setAttribute("durgs","scwcd");
     request.setAttribute("pavan","scjp");
     request.removeAttribute("pavan");
     request.setAttribute("durgs","scbcd");
     request.setAttribute("sai","scwcd");
     pw.println("this is servlet request attribute listener demo");
	}
}
