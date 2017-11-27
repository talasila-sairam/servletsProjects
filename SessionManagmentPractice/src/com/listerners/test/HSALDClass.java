package com.listerners.test;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HSALDClass")
public class HSALDClass extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
      PrintWriter pw=response.getWriter();
      HttpSession session=request.getSession();
      session.setAttribute("a1","scjp");
      session.setAttribute("a1","scwcd");
      session.setAttribute("a2",new Demo());
      session.setAttribute("a3",new Demo());
      session.setAttribute("a2",new Demo());
      session.removeAttribute("a3");
      pw.println("This is session Binding Demo ");
	}
}
