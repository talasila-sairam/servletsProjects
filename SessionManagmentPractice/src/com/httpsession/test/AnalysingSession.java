package com.httpsession.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AnalysingSession")
public class AnalysingSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AnalysingSession() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("session Id "+session.getId());
		session.setAttribute("rajini","sairam");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/AnalysingSeesion2");
		dispatcher.forward(request, response);
	}


}
