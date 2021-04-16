package com.tyss.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementExample1 {

	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		   try {
	     Class.forName("com.mysql.cj.jdbc.Driver");
	     
	     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","root");
	     
	     String query="select * from employee where id=?";
	     
	     pstmt=con.prepareStatement(query);
	     //Reading the parameter input through command-line argument
	     String eid=args[0];
	     int employeeid=Integer.parseInt(eid);
	     //Binding parameter for employee id
	     pstmt.setInt(1, employeeid);
	     rs=pstmt.executeQuery();
	     
	     //4.process the results returned by sql query
	     
	     if(rs.next())
	     {
	    	 int empid=rs.getInt("id");
	    	 String empname=rs.getNString("name");
	    	 int empsal=rs.getInt("sal");
	    	 String empdept=rs.getString("dept");
	    	 int empphone=rs.getInt("phone_no");
	    	 
	    	 //print all the values
	    	 System.out.println("employee id:"+empid);
	    	 System.out.println("employee name:"+empname);
	    	 System.out.println("employee sal:"+empsal);
	    	 System.out.println("employee dept:"+empdept);
	    	 System.out.println("employee phone_sal:"+empphone);
	    	 
	     }
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
