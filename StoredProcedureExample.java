package com.tyss.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class StoredProcedureExample {

	public static void main(String[] args) 
	{
		Connection con=null;
		CallableStatement cs=null;
		ResultSet rs=null;
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con=DriverManager.getConnection("");
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
