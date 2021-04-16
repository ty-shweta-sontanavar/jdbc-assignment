package com.tyss.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StaticSelect {

	public static void main(String[] args) 
	{
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2/get connection via Driver
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
			
			//3.Issue SQL Query via the connection
			String query="select * from employee";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
			if(stmt!=null)
			{
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

	}
	}
}
