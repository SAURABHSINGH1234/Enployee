package mypack;
import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
@WebServlet("/signup1")
public class SignupServlet1 extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<a href='info.jsp'>Infopage..</a>");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String city=req.getParameter("city");
		String pincode=req.getParameter("pincode");
		String adharno=req.getParameter("adharno");
		String mobile=req.getParameter("mobile");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			String sql="insert into saurav1 values(?,?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,name);
			pst.setString(2,email);
			pst.setString(3,city);
			pst.setString(4,pincode);
			pst.setString(5,adharno);
			pst.setString(6,mobile);
			pst.executeUpdate();
			out.print("Welcome "+name); 
			 req.getRequestDispatcher("signup.html").include(req, res);
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