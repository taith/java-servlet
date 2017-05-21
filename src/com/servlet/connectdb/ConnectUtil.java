package com.servlet.connectdb;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectUtil {
	public static Connection getConnection()
			throws ClassNotFoundException, SQLException {
		return MySqlConnect.getConnection();
	}
	
	public static void closeConnect(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollBack(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
