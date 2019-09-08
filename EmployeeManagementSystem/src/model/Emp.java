package model;

import java.sql.*;
public class Emp
{
private String userName;
private String userPassword;
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserPassword() {
	return userPassword;
}
public void setUserPassword(String userPassword) {
	this.userPassword = userPassword;
}
public String Validate() throws Exception
{
	
	 Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		PreparedStatement pst = conn.prepareStatement("select * from saurav where userName=? and userPassword=?");
		pst.setString(1,userName);
		pst.setString(2,userPassword);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			 
			return "index.html";
		}
		else
		{
			return "error.jsp";
		}
}

}