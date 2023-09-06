package com.neosoft;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_connection {
	public static void main(String[] args) throws Exception {
		DB_connection obj_DB_connection = new DB_connection();
		System.out.println(obj_DB_connection.get_connection());
	}

	public Connection get_connection() throws Exception {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsf", "root", "root");
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}

//	public Connection getConnection() {
//		Connection connection = null;
//		try {
//			// Load the PostgreSQL JDBC driver
//			Class.forName("org.postgresql.Driver");
//
//			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/multiple_db", "postgres",
//					"root");
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		return connection;
//	}
}
