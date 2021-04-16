package com.tyss.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DynamicSelect {

	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			//1.load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2.get the connection via driver
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
			
			//3.issues SQL Query via connection
			String query="select * from employee where id=?";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, 1);
			rs=pstmt.executeQuery();
			
			//4.process the ResultSet
			while(rs.next())
			{
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getInt("sal"));
				System.out.println(rs.getString("dept"));
		 		System.out.println(rs.getInt("phone_no"));
				System.out.println("---------------------");
				
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
