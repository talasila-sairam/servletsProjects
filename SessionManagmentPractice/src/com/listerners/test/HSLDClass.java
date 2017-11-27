package com.listerners.test;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HSLDClass")
public class HSLDClass extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
     PrintWriter pw=response.getWriter();
     HttpSession session=request.getSession();
     session.setMaxInactiveInterval(20);
     pw.println("the created session object is   :"+session.getId());
	}
}
