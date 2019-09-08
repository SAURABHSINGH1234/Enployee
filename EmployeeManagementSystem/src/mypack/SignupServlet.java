package mypack;
import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
@WebServlet("/signup")
public class SignupServlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String userName=req.getParameter("userName");
		String userPassword=req.getParameter("userPassword");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			String sql="insert into saurav values(?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,name);
			pst.setString(2,email);
			pst.setString(3,userName);
			pst.setString(4,userPassword);
			pst.executeUpdate();
			out.print("Welcome "+userName); 
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