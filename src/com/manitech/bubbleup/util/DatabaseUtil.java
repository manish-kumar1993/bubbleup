package com.manitech.bubbleup.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DatabaseUtil {

	private static DataSource ds;

	static {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/bubbleup");
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	public static Connection getDbConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void closeDBConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closePreparedStatement(PreparedStatement preparedStatement) {
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		}
	}
	
	public static void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				try {
					if (statement != null) {
						statement.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		}
	}
}
