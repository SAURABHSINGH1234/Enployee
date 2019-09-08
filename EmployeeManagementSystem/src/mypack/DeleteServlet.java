package mypack;
import javax.servlet.*;

import model.*;
import javax.servlet.http.*;
import java.io.*;
public class DeleteServlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		try
		{
			Employee e = new Employee();
			int eno=Integer.parseInt(req.getParameter("eno"));
			e.setEno(eno);
			int i= e.deleteRecord();
			if(i>0)
			{
				res.sendRedirect("showServlet");
			}
			else
			{
				out.println("Not Done");
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}