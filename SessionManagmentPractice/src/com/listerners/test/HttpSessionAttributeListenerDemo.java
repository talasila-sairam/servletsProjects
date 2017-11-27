package com.listerners.test;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener("/HSALDClass")
public class HttpSessionAttributeListenerDemo implements HttpSessionAttributeListener 
{

    public void attributeAdded(HttpSessionBindingEvent e) 
    { 
      System.out.println("attribute Added"+e.getName()+"------"+e.getValue());
    }

    public void attributeRemoved(HttpSessionBindingEvent e)  
    { 
    	System.out.println("attribute Removed"+e.getName()+"------"+e.getValue());
    }

    public void attributeReplaced(HttpSessionBindingEvent e)  
    { 
    	System.out.println("attribute Replaced"+e.getName()+"------"+e.getValue());
    }
}
