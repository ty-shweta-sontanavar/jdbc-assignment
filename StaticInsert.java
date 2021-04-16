package com.tyss.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class StaticInsert {

	public static void main(String[] args) 
	{
		Connection con=null;
		Statement stmt=null;
		try {
			//1.load the driver
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Driver d=new com.mysql.cj.jdbc.Driver();
    		DriverManager.registerDriver(d);
			System.out.println("driver class is loaded successfully...");
			
		
		//2.get connection via Driver
       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
		
     //3.Issue SQL Query via connection
		String query="insert into employee values(3,'kaveri',30000,'eee',8973256)";
		stmt=con.createStatement();
		
		//4.process the ResultSet
		int count=stmt.executeUpdate(query);
		System.out.println("number of rows affected:"+count);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		finally {
			//5.close all JDBC objects
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
//		try {
//			Driver d=new com.mysql.cj.jdbc.Driver();
//			DriverManager.registerDriver(d);
//			System.out.println("driver class loaded successfully.....");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		

	}

}
