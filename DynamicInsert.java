package com.tyss.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DynamicInsert {

	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
			
			String query="insert into employee values(?,?,?,?,?)";
			pstmt=con.prepareStatement(query);
			
			String eid=args[0];
			int empid=Integer.parseInt(eid);
			pstmt.setInt(1,empid);
			
			String ename=args[1];
			pstmt.setString(2,ename);
			
			String esal=args[2];
			int empsal=Integer.parseInt(esal);
			pstmt.setInt(3,empsal);
			
			String edept=args[3];
			pstmt.setString(4,edept);
			
			String epone=args[4];
			int empphone=Integer.parseInt(epone);
			pstmt.setInt(5,empphone);
			
			int count=pstmt.executeUpdate();
		    System.out.println("insert successfull.....:"+count);
		}catch(Exception e){
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
