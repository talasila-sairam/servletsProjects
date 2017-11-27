package com.filters.test;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
@WebFilter(servletNames="LogServlet")
public class LogFilterDemo implements Filter 
{
	FilterConfig conf;
     public void init(FilterConfig config) throws ServletException {
		this.conf=config;
	}
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
		PrintWriter pw=response.getWriter();
		ServletContext context=conf.getServletContext();
		HttpServletRequest req1=(HttpServletRequest)request;
		pw.println("<h1>This line added by LogFilter Before Processing</h1>");
		context.log("This request is comming from   :"+req1.getRemoteHost()+"For URL is  :"+req1.getRequestURL()+"   at  :"+new Date());
		chain.doFilter(request, response);
		pw.println("<h1>This line added by LodFilter After Processing</h1>");
	}
}
