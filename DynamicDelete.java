package com.tyss.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DynamicDelete {

	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		//1.load the driver
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.Get the connection via driver
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
		
		//3.issues sql query via connection
		String query="delete from employee where id=?";
		pstmt=con.prepareStatement(query);
		pstmt.setInt(1, 3);
		
		//4.processs the resultset
		int count=pstmt.executeUpdate();
		System.out.println("deleted successfuly.....");
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
      }
		}
	}

}
