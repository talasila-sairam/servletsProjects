package com.listerners.test;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

@WebListener
public class Demo implements HttpSessionBindingListener 
{
    public void valueBound(HttpSessionBindingEvent e)  
    { 
       System.out.println("demo object is added sucessfully   :"+e.getName()+"------"+e.getValue());
    }
    public void valueUnbound(HttpSessionBindingEvent e)  
    { 
    	System.out.println("demo object is removed sucessfully   :"+e.getName()+"------"+e.getValue());
    }
	
}
