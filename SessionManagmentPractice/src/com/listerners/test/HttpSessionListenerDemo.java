package com.listerners.test;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener("/HSLDClass")
public class HttpSessionListenerDemo implements HttpSessionListener 
{
    public void sessionCreated(HttpSessionEvent e)  
    { 
     System.out.println("session created is     :"+e.getSession());
    }
    public void sessionDestroyed(HttpSessionEvent e)  
    { 
    	System.out.println("session destoyed is     :"+e.getSession());
    }
	
}
