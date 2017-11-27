package com.apps.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.apps.tomcat.*;

import com.apps.singleton.A;

/**
 *       BootStrapClasLoader
 *              ||
 *              ||
 *       Extension ClassLoader
 *              ||
 *              ||
 *        SystemClassLOader
 *              /\
 *             /  \
 *            /    \
 *           /      \
 *        WebApp  CustomClass
 *        
 *        (That is the reason it is loading A class Two times)
 *
 */
@WebServlet("/Xservlet")
public class Xservlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("This Servlet class is loaded by  "+this.getClass().getClassLoader()+"  And hash code of this class loader is   "+this.getClass().getClassLoader().hashCode());
		System.out.println("first webapp ServerLevelSingleton  ");
		ServletContext context = getServletConfig().getServletContext();
		System.out.println("This servelt context object is loaded by "+context.getClass().getClassLoader());
         try {
			 A a=A.getInstance();
			 System.out.println("A class inside first app class loaded by "+a.getClass().getClassLoader());
			 System.out.println("hash code of A class inside the servlet is  "+a.hashCode());
			 System.out.println("servlet class is loaded by "+getClass().getClassLoader());
			 System.out.println("parent of this class loader is "+getClass().getClassLoader().getParent());
			 System.out.println("parent of this class loader is "+getClass().getClassLoader().getParent().getParent());
			 System.out.println("parent of this class loader is "+getClass().getClassLoader().getParent().getParent().getParent());
			 System.out.println("parent of this class loader is "+getClass().getClassLoader().getParent().getParent().getParent().getParent());
			 System.out.println("--------------------------------------------------------------------");
			 System.out.println("Trying to load the class A again with custom class loader");
			 CustomClassLoader ccl = new CustomClassLoader("Hello");
			 try {
				 
				Class<?> c = ccl.findClass("com.apps.tomcat.A");
				System.out.println("Custom ClassLoader is loaded by"+ccl.getClass().getClassLoader());
				System.out.println("Parent of CustomClassLoader is "+ccl.getClass().getClassLoader().getParent());
				System.out.println("Parent of CustomClassLoader is "+ccl.getClass().getClassLoader().getParent().getParent());
				System.out.println("A class is loaded by "+c.getClassLoader());
			    Object ob = c.newInstance();
			    Method md = c.getMethod("getInstance");
			    md.invoke(ob);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
        
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}
