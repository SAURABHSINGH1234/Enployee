package mypack;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
@WebServlet("/Find1")
public class FindServlet1 extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<a href='info.jsp'>Infopage..</a>");
		String name=req.getParameter("ename");
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			String sql="select * from saurav1 where name=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,name);
			ResultSet rs=pst.executeQuery();
			rs.next();
			out.println(rs.getString(1)+" " +rs.getString(2)+" " +rs.getString(3)+" " +rs.getString(4)+" " +rs.getString(5)+" " +rs.getString(6));
			
			
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