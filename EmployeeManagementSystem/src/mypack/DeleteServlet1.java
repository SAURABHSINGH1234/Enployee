package mypack;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
@WebServlet("/delete1")
public class DeleteServlet1 extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<a href='info.jsp'>Infopage..</a>");
		String name=req.getParameter("name");
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			String sql="delete from saurav1 where name=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,name);
			
			pst.executeUpdate();
			out.println("RECORD IS SUCCESSFULLY DELETED");
			
		}
		catch(ClassNotFoundException e)
		{
			out.println(e);
		}
		catch(SQLException e)
		{
			out.println(e);
		}
		
	}
}