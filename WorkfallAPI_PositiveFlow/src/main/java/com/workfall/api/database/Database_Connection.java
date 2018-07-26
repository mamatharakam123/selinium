package com.workfall.api.database;

import java.sql.Statement;
import org.postgresql.util.PSQLException;

import com.workfall.api.utils.Global;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database_Connection extends Global{
	public static ResultSet Database_executeQuery(String sqlquery) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			
			//Register JDBC driver
			Class.forName(JDBC_DRIVER);

			//Open a connection
			conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			//Execute a query
			stmt = conn.createStatement();

			// String sql = "SELECT id, email, first_name, last_name FROM app_user ";
			String sql = sqlquery;

			resultSet = stmt.executeQuery(sql);
			
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		
		return resultSet;
	}
	
	public static void Database_executeUpdate(String query) throws Exception {
	
		Connection conn = null;
		Statement stmt = null;
		try {
			//Register JDBC driver
			Class.forName(JDBC_DRIVER);

			//Open a connection
			conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			//Execute a query
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			// String sql = "SELECT id, email, first_name, last_name FROM app_user ";
		} catch (PSQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		}
}
}
