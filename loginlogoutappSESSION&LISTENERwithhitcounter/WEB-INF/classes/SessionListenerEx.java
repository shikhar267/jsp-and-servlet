import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.sql.*; 
public class SessionListenerEx implements HttpSessionListener
{
ServletContext ctx=null;
private static int sessionCurrent=0,sessionTotal=0;
public void sessionCreated(HttpSessionEvent e)
{
	sessionCurrent++;
	sessionTotal++;
	ctx=e.getSession().getServletContext();
	ctx.setAttribute("Total Session",sessionTotal);
	ctx.setAttribute("Current Session",sessionCurrent);
}
public void sessionDestroyed(HttpSessionEvent e){
	sessionCurrent--;
	ctx.setAttribute("Current Session",sessionCurrent);
}
}