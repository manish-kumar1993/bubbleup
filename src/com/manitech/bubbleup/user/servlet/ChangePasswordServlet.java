package com.manitech.bubbleup.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manitech.bubbleup.manager.UserDataManager;

public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String password = request.getParameter("password");
		String username = request.getParameter("username");
		UserDataManager userDataManager = new UserDataManager();
		boolean passwordUpdated = userDataManager.updateUserPassword(password, username);
		if (passwordUpdated) {
				saveMessage(request, "Your Password has been change, Please Login with new Password");
				request.getServletContext().getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
		}
		else
			{
			request.setAttribute("status", "error");
			request.setAttribute("username", username);
			saveMessage(request, "Please do not use the old password,use the recent one");
			request.getServletContext().getRequestDispatcher("/WEB-INF/pages/user/changePasswordContent.jsp")
					.forward(request, response);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void saveMessage(HttpServletRequest request, String msg) {
		List messages = (List) request.getSession().getAttribute("messages");
		if (messages == null) {
			messages = new ArrayList();
		}
		messages.add(msg);
		request.getSession().setAttribute("messages", messages);
	}
}