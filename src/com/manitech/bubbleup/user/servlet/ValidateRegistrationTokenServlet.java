package com.manitech.bubbleup.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manitech.bubbleup.manager.UserDataManager;

public class ValidateRegistrationTokenServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		
		String registrationToken = request.getParameter("rt");
		String emailAddress = request.getParameter("ea");
		 
			request.setAttribute("status", "error");
			saveMessage(request, "Your Password Link is Expired,please try again");
			request.getServletContext().getRequestDispatcher("/WEB-INF/pages/user/forgotPasswordContent.jsp")
					.forward(request, response);

	}
	private void saveMessage(HttpServletRequest request, String msg) {
		List messages = (List) request.getSession().getAttribute("messages");
		if (messages == null) {
			messages = new ArrayList();
		}
		messages.add(msg);
		request.getSession().setAttribute("messages", messages);
	}

}
