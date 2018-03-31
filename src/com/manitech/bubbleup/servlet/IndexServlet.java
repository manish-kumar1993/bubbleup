package com.manitech.bubbleup.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manitech.bubbleup.util.DatabaseUtil;

public class IndexServlet  extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		hitServer() ;
		RequestDispatcher requestDispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/index.jsp");
		requestDispatcher.forward(request, response);
	}
	
	private void hitServer() {
		String id=UUID.randomUUID().toString();
		Statement statement = null;
		String sql = "select now() " ;
		Connection connection = DatabaseUtil.getDbConnection();
		try {

			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeDBConnection(connection);
		}
	}
}
