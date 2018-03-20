package assm.math.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logout")
public class logout extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession(false);
		System.out.println(session);
		if(session != null)
		{
			
			System.out.println("inside if  "+session);
			session.removeAttribute("client");
			session.invalidate();
			/*RequestDispatcher rd=request.getRequestDispatcher("/UserLogin.html");
			rd.include(request, response);*/
			response.sendRedirect("UserLogin.html");
		}
		else
		  {
			System.out.println("inside else  "+session);
			//pw.println("<h3>your logouted sucessfully</h3>");
			/*RequestDispatcher rd=request.getRequestDispatcher("/UserLogin.html");
			rd.forward(request, response);	*/
			response.sendRedirect("UserLogin.html");
			System.out.println("inside else  "+session);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
