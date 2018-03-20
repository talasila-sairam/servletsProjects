package assm.math.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import assm.math.dao.DataBaseValidation;
@WebServlet("/LoginServletCheck")
public class LoginServletCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
	    String userName=request.getParameter("uname");
	    String passWord=request.getParameter("password");
	    DataBaseValidation  dbVadidaton=new DataBaseValidation();
        boolean b=dbVadidaton.userValid(userName, passWord);
         if(b==true)
           {
        	  HttpSession session=request.getSession();
        	  System.out.println(session);
        	  session.setAttribute("client",userName);
        	  response.sendRedirect("mathoperations.jsp");
    	     /* RequestDispatcher rd=request.getRequestDispatcher("mathoperations.jsp");
    			   {
    		          rd.forward(request, response);
    			   }*/
           }
         else
           {
    	     
    	      RequestDispatcher rd=request.getRequestDispatcher("UserLogin.html");
		        {
	               rd.include(request, response);
		        }   
		        out.println("Credentials are invalid");
          }
	}
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
