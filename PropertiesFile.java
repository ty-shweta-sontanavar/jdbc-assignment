package com.tyss.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class PropertiesFile {

	public static void main(String[] args) 
	{
		Connection con=null;
		Statement stmt=null;
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String path="D:\\properties.txt";
		FileReader reader=new FileReader(path);
		Properties properties1=new Properties();
		properties1.load(reader);
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems",properties1);
		
		String query="insert into employee values(5,'kavya',35000,'mech',8976756)";
		stmt=con.createStatement();
		
		//4.process the ResultSet
		int count=stmt.executeUpdate(query);
		System.out.println("number of rows affected:"+count);
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
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
	}

}
