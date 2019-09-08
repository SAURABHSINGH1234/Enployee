package mypack;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class StoreRecord extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out= res.getWriter();
		int eno=Integer.parseInt(req.getParameter("eno"));
		String ename = req.getParameter("ename");
		Long esal=Long.valueOf(req.getParameter("esal"));
		out.println("<html>");
		out.println("<body>");
		out.println("<form action = 'updateServlet'>");
		               out.println("No<input type='text' name='eno' value='"+eno+"'><br>");
		               out.println("No<input type='text' name='ename' value='"+ename+"'><br>");
		               out.println("No<input type='text' name='esal' value='"+esal+"'><br>");
		               out.println("No<input type='submit' value='UpdateRecord'>");
		
		  out.println("</form>");
		  out.println("</body>");
		  out.println("</html>");
}
}