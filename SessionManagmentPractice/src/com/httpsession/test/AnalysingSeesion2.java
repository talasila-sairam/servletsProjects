package com.httpsession.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AnalysingSeesion2")
public class AnalysingSeesion2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
	  HttpSession session = request.getSession();	
	  System.out.println("SessionId from second servlet "+session.getId());
	  System.out.println("userName "+session.getAttribute("rajini"));
	  pw.println("userName "+session.getAttribute("rajini"));
	  pw.print("SessionId from second servlet "+session.getId());
	  
	  HttpSession session1 = request.getSession(false);
	  pw.println("session1 id  "+session1.getId());
	}
}
