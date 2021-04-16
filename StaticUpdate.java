package com.tyss.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class StaticUpdate {

	public static void main(String[] args) 
	{
		Connection con=null;
		Statement stmt=null;
	
		try {
			Driver d=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
			
			String query="update employee set name='shirin' where id=2";
			stmt=con.createStatement();
			
			int count=stmt.executeUpdate(query);
			System.out.println("number of rows affected:"+count);
		} catch (SQLException e) {
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
		}

	}

}
