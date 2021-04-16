package com.tyss.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StaticDelete {

	public static void main(String[] args) 
	{
      Connection con=null;
      Statement stmt=null;
      
      try {
      //1.load the driver
      Class.forName("com.mysql.cj.jdbc.Driver");
      
      //get the connection via driver
      con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
      
      //3.issue SQL Query via connection
      String query="delete from employee where id=2";
      stmt=con.createStatement();
      
      //4.process the resultset
       int count=stmt.executeUpdate(query);
		System.out.println("number of rows affected:"+count);
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