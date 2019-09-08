package mypack;
import javax.servlet.*;
import java.util.*;
import model.*;
import javax.servlet.http.*;
import java.io.*;
public class ShowServlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<h3><a href='index.html'>AddRecord</a></h3><br>");
		out.println("<h1>Employee Information</h1><hr>");
		try
		{
			Employee e= new Employee();
			List<Employee> l= e.findAllRecord();
			Iterator<Employee> itr=l.iterator();
			out.println("<table width='100%' border='1'>");
			out.println("<tr bgcolor='pink'>");
			           out.println("<td>No</td>");
			           out.println("<td>Name</td>");
			           out.println("<td>Sal</td>");
			           out.println("<td>Update</td>");
			           out.println("<td>Delete</td>");
			
	        out.println("<tr>");
	       while(itr.hasNext())
	       {
	    	 Employee ee=itr.next();
	    	 out.println("<tr>");
	    	           out.println("<td>" + ee.getEno() + "</td>");
	    	           out.println("<td>" + ee.getEname() + "</td>");
	    	           out.println("<td>" + ee.getEsal() + "</td>");
	    	 
out.println("<td><a href='storeRecord?eno="+ee.getEno()+"&ename="+ee.getEname()+"&esal="+ee.getEsal()+"'>Update</a></td>");	    	 
	    	 out.println("<td><a href='deleteServlet?eno="+ee.getEno()+"'>Delete</a></td>");
	    	 out.println("</tr>");
	       }
	        out.println("</table>");
	        
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}
