package mypack;
import javax.servlet.*;
import javax.servlet.http.HttpSession;

import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class LogoutServlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");  
        PrintWriter out=res.getWriter();  
          
        req.getRequestDispatcher("index1.html").include(req, res);  
          
        HttpSession session=req.getSession();  
        session.invalidate();  
          
        out.print("YOU ARE SUCCESSFULLY LOGGED OUT!");  
          
        out.close();  
	}
}