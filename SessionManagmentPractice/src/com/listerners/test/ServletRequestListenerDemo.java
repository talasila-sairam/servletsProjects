package com.listerners.test;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

//@WebListener("/SRLDClass")
public class ServletRequestListenerDemo implements ServletRequestListener 
{
	public static int count=0;
    public void requestDestroyed(ServletRequestEvent e)  
    {
          	count++;
          	System.out.println("A request object created"+count);
          	System.out.println("Servlet Context"+e.getServletContext());
          	System.out.println("Servlet Source"+e.getSource());
          	System.out.println("Servlet Request"+e.getServletRequest());
    }
    public void requestInitialized(ServletRequestEvent e)  
    { 
    	System.out.println("A request object Destryoed"+count);
    }
	
}
