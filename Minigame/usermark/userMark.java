package usermark;

import java.sql.*;
import Login.ChoosePlay;
import connection.JDBCconnection;

public class userMark 
{
	int mark;
	public userMark(){}
	
	public int getMark(String username)
	{
		PreparedStatement pst = null;
		Connection conn = null;
		try
		{
			conn = JDBCconnection.getConnection();
			
			String sql = "select * from accMark where name = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
        
			ResultSet rs = pst.executeQuery();
			if (rs.next())
				mark = rs.getInt(3);
		}
		catch (Exception e1) {}
		return mark;
	}
	
	public void saveMark(String username, int mark)
	{
		PreparedStatement pst = null;
		Connection conn = null;
		try
		{
			conn = JDBCconnection.getConnection();
			
			String sql = "update accMark set mark = ? where name = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, mark);
			pst.setString(2, username);
        
			int rowAffected = pst.executeUpdate();
		}
		catch (Exception e1) {}
	}
}
