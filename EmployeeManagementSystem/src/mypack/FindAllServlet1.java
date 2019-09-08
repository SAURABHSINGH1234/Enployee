package mypack;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
@WebServlet("/FindAllServlet1")
public class FindAllServlet1 extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<a href='info.jsp'>Infopage..</a>");
		
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			String sql="select * from saurav1";
			PreparedStatement pst=conn.prepareStatement(sql);
			
			ResultSet rs=pst.executeQuery();
			out.println("<table border='1' width='100%' cellpadding='10' cellspacing='20'>");
			out.println("<tr bgcolor='pink'>");
			out.println("<th>Name</th><th>Email</th><th>City</th><th>Pincode</th><th>Adhar Number</th><th>Mobile Number</th>");
			out.println("</tr>");
			while(rs.next())
			{
				out.println("<tr>");
				out.println("<td>"+rs.getString(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3)+"</td><td>" +rs.getString(4) +"</td><td>" +rs.getString(5) +"</td><td>"+rs.getString(6) +"</td>");
				out.println("</tr>");
			}
			
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