package model;
import java.sql.*;
import mypack.*;
import java.util.*;
public class Employee
{
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	private String sql;
public Employee() throws Exception 
{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn=MyConnection.getConnection();
}
private Integer eno;
private String ename;
private Long esal;
public Integer getEno() {
	return eno;
}
public void setEno(Integer eno) {
	this.eno = eno;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public Long getEsal() {
	return esal;
}
public void setEsal(Long esal) {
	this.esal = esal;
}
public int addRecord() throws SQLException
{
	sql="insert into saurabh values(?,?,?)";
	pst=conn.prepareStatement(sql);
	pst.setInt(1,eno);
	pst.setString(2,ename);
	pst.setLong(3,esal);
	return pst.executeUpdate();
}
public int deleteRecord() throws Exception
{
	sql="delete from saurabh where eno=?";
	pst=conn.prepareStatement(sql);
	pst.setInt(1,eno);
	return pst.executeUpdate();
}
public List<Employee> findAllRecord() throws Exception
{
	sql="select * from saurabh";
	pst=conn.prepareStatement(sql);
	rs= pst.executeQuery();
	List<Employee> l=new ArrayList<Employee>();
	while(rs.next())
	{
		Employee e = new Employee();
		e.setEno(rs.getInt("eno"));
		e.setEname(rs.getString("ename"));
		e.setEsal(rs.getLong("esal"));
		l.add(e);
	}
	return l;
}
public Employee findRecord() throws Exception
{
	sql="select * from saurabh where eno=?";
	pst=conn.prepareStatement(sql);
	pst.setInt(1,eno);
	rs= pst.executeQuery();
	rs.next();
	Employee e= new Employee();
	e.setEno(rs.getInt("eno"));
	e.setEname(rs.getString("ename"));
	e.setEsal(rs.getLong("esal"));
	return e;
}
public int ModifyRecord() throws Exception
{
	sql="update saurabh set ename=?,esal=? where eno=?";
	pst=conn.prepareStatement(sql);
	pst.setInt(3,eno);
	pst.setString(1,ename);
	pst.setLong(2,esal);
	return pst.executeUpdate();
}


}