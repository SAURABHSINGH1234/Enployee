package mypack;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
@WebServlet("/Update1")
public class UpdateServlet1 extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<a href='info.jsp'>Infopage..</a>");
		String name=req.getParameter("ename");
		String email=req.getParameter("email");
		String city=req.getParameter("city");
		String pincode=req.getParameter("pincode");
		String adharno=req.getParameter("adharno");
		String mobile=req.getParameter("mobile");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			String sql="update saurav1 set email=?,city=?,pincode=?,adharno=?,mobile=? where name=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(6,name);
			pst.setString(1,email);
			pst.setString(2,city);
			pst.setString(3,pincode);
			pst.setString(4,adharno);
			pst.setString(5,mobile);
			pst.executeUpdate();
			out.println("record update");
			
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