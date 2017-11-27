package com.apps.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.apps.tcat.*;



//import com.apps.singleton.A;
import com.apps.tomcat.*;

@WebServlet("/Yservlet")
public class Yservlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("This Servlet class is loaded by  "+this.getClass().getClassLoader()+"  And hash code of this class loader is   "+this.getClass().getClassLoader().hashCode());
		System.out.println("Second webapp  ServerLevelSingleton  ");
        try {
        	Class.forName("com.apps.sys.MyTest");
			A a=A.getInstance();
			System.out.println("A inside second app class loaded by "+a.getClass().getClassLoader());
			 System.out.println("hash code inside Y servelt"+a.hashCode());
			 System.out.println("servlet class is loaded by "+getClass().getClassLoader());
			 System.out.println("parent of this class loader is "+getClass().getClassLoader().getParent());
			 System.out.println("parent of this class loader is "+getClass().getClassLoader().getParent().getParent());
			 System.out.println("parent of this class loader is "+getClass().getClassLoader().getParent().getParent().getParent());
			 System.out.println("parent of this class loader is "+getClass().getClassLoader().getParent().getParent().getParent().getParent());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}
