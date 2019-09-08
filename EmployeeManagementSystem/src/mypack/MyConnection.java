package mypack;
import java.sql.*;

import java.io.*;
import java.util.*;
public class MyConnection
{
	private MyConnection(){}
	private static Connection conn;
	public static Connection getConnection() throws Exception
	{
		if(conn==null)
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		
		}
		
		return conn;
	}
}