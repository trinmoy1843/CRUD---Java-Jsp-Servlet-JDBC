package com.MyClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateCon {
	static Connection con = null;
	private static String url = "jdbc:mysql://localhost:3306/";
	private static String database = "USER_INFO";
	private static String username = "root";
	private static String password = "Trinmoy@1843";
	
	static Connection getCon() {
		try {
			con = DriverManager.getConnection(url+database, username, password);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
