package connection;

import java.sql.*;

public class JDBCconnection {
	public static Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minigame","root","1234");
			return con;
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return null;
	}
}
