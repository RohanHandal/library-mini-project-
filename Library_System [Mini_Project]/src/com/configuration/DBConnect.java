package com.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

		static final String driver = "com.mysql.cj.jdbc.Driver";
		static final String uri = "jdbc:mysql://localhost:3306/library_systeem";
		static final String user = "root";
		static final String password ="Rohan@19";
		
		
		public static Connection getConnection () {
			Connection con = null;
			try {
				con=DriverManager.getConnection(uri,user,password);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return con;
			
		}
	//	public static void main(String[] args) {
		//	DBConnect.getConnection();
		//	System.out.println("jhggkg");
		//}	
}
