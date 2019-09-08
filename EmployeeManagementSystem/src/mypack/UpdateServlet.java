package mypack;
import javax.servlet.*;

import model.*;
import javax.servlet.http.*;
import java.io.*;
public class UpdateServlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out= res.getWriter();
		int eno=Integer.parseInt(req.getParameter("eno"));
		String ename = req.getParameter("ename");
		Long esal=Long.valueOf(req.getParameter("esal"));
		try
		{
			Employee e = new Employee();
			e.setEno(eno);
			e.setEname(ename);
			e.setEsal(esal);
			int i = e.ModifyRecord();
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


