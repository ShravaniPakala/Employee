package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static Connection conn;
	
	private DBConnection() {}
	
	public static Connection getConnectionObject() {
		 if(conn!=null) {
			 return conn;
		 }
		 else {
			 try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeDB"
							,"root","root");
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			return conn;
		 }
	}
}
