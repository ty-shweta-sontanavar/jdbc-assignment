package com.tyss.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DynamicUpdate {

	public static void main(String[] args) 
	{
		Connection con=null;
	   PreparedStatement pstmt=null;
	   try {
     Class.forName("com.mysql.cj.jdbc.Driver");
     
     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
     
     String query="update employee set name=? where id=?";
     pstmt=con.prepareStatement(query);
     //Binding the parameters
     pstmt.setString(1, "pinkii");
     pstmt.setInt(2, 2);
     
     int count=pstmt.executeUpdate();
     System.out.println("update successfull.....:"+count);
	}
	   catch(Exception e)
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