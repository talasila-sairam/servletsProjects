package assm.math.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assm.math.dao.RegisterDb;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      PrintWriter pw=response.getWriter();
      String name=request.getParameter("fname");
      String pwd=request.getParameter("pwd");
      RegisterDb rb=new RegisterDb();
      int j=rb.insertDemo(name,pwd);
      if( j == 1 )
      {
    	 
    	  RequestDispatcher rd=request.getRequestDispatcher("UserLogin.html");
    	  rd.include(request, response);
    	  pw.println("<h2>Thanks You "+name.toUpperCase()+"   You are Registered Suucessfully<h2>");
      }
      else
      {
    	 
    	  RequestDispatcher rd=request.getRequestDispatcher("NewRegister.jsp");
    	  rd.include(request, response);
    	  pw.println("<h2>This UserName :   "+name.toUpperCase()+" Already exists Please Register With Another Name<h2>");
      }
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
