package testdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionDb {
	
	public static Connection GetConnection()
	{
		Connection cn = null;
		try {
			Class.forName("org.postgresql.Driver");
			
			cn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "root");
		} catch (Exception e) {
			System.out.println("Database Connection Failed");
		}
		
		return cn;
		
	}
	
	public static void fetchdata()
	{
		Connection cd = GetConnection();
		Statement smt = null;
		try {
			smt = cd.createStatement();
			ResultSet rs = smt.executeQuery("select * from testdb");
			while(rs.next())
			{  
				String name = rs.getString("tname");
				int id = rs.getInt("tid");
				System.out.println(id+ "should be " +name);
			}
		} catch (SQLException e) {
			System.out.println("query is notexecuted");
		}
	}
	public static void insertdata()
	{   Connection cn = GetConnection();
		Statement stmt =null;
		
		try {
			stmt = cn.createStatement();
			String insert = "insert into testdb(tid,tname)values(5,'keval')";
			stmt.execute(insert);
		} catch (Exception e) {
			System.out.println("Data is not inserted");
		}
	
	}
	public static void deletedata()
	{
		Connection cn = GetConnection();
		Statement smt = null;
		try {
			smt = cn.createStatement();
			String delete = "delete from testdb where tid = 5";
			smt.executeUpdate(delete);
			System.out.println("Data is deleted");
		} catch (Exception e) {
			System.out.println("Data is not Deleted");
		}
	}
	public static void dataupdate()
	{
		Connection cn = GetConnection();
		Statement smt = null;
		try {
			smt=cn.createStatement();
			String update="update testdb set tname='veeha' where tid=2";
			smt.executeUpdate(update);
			System.out.println("Data is updated");
		} catch (Exception e) {
			System.out.println("Data is not updated");
		}
	}
}









	