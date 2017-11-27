package com.listerners.test;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
@WebListener("/SRALDClass")
public class ServletRequestAttributeListenerDemo implements ServletRequestAttributeListener 
{
    public void attributeRemoved(ServletRequestAttributeEvent e)
    { 
     System.out.println("The Removed attibue is    :"+e.getName()+"------"+e.getValue());    
    }

    public void attributeAdded(ServletRequestAttributeEvent e)  
    { 
    	System.out.println("The added attibue is    :"+e.getName()+"------"+e.getValue());
    }

    public void attributeReplaced(ServletRequestAttributeEvent e)  
    { 
    	System.out.println("The Replaced attibue is    :"+e.getName()+"------"+e.getValue());
    }	
}
