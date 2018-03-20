package assm.math.controller;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener("/logout")
public class LogoutListerner implements HttpSessionListener 
{
    public void sessionCreated(HttpSessionEvent e)  
    {
    	System.out.println("Object in Lister created"+e.getSession());
    }
    public void sessionDestroyed(HttpSessionEvent e)  
    { 
    	System.out.println("Object in Lister Destryoed"+e.getSession());
    	e.getSession().removeAttribute("client");
    }	
}
