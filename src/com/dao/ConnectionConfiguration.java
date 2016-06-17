package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionConfiguration {
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/database", "root", "");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
