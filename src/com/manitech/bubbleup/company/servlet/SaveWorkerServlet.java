package com.manitech.bubbleup.company.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manitech.bubbleup.manager.UserDataManager;
import com.manitech.bubbleup.model.UserDetail;
import com.manitech.bubbleup.util.AppUtil;

public class SaveWorkerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDataManager userDataManager = new UserDataManager();

		String loggedInUser = request.getRemoteUser();
		UserDetail userInfo = null;
		if (AppUtil.isNotEmpty(loggedInUser)) {
			userInfo = userDataManager.getUserByUserName(loggedInUser);
		}
		String userId = request.getParameter("userId");
		String saltedPass = request.getParameter("saltedPass");
		String firstName = request.getParameter("firstName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String mobileNo = request.getParameter("mobileNo");

		request.setAttribute("firstName", firstName);
		request.setAttribute("username", username);
		request.setAttribute("mobileNo", mobileNo);
		

		boolean isUserAvailable = userDataManager.isUsernameExist(username, userId);
		if (isUserAvailable) {
			saveMessageAndError(request, "Worker Already Exist","messages");
			request.getServletContext().getRequestDispatcher("/WEB-INF/pages/user/addWorker.jsp").forward(request, response);
			return;
		} else {
			boolean savedStaus = userDataManager.saveUserDetails(userId, firstName, "", username, password,
					mobileNo,  saltedPass, "", "", userInfo.getId(),"");
			if(savedStaus){
				saveMessageAndError(request, "Worker updated successfully","messages");
					response.sendRedirect("workersList");
			}else{
				saveMessageAndError(request, "There was some error. Please try again.","errors");
				request.getServletContext().getRequestDispatcher("/WEB-INF/pages/user/addWorker.jsp").forward(request, response);
			}
			
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void saveMessageAndError(HttpServletRequest request, String msg,String type) {
		List messages = (List) request.getSession().getAttribute(type);
		if (messages == null) {
			messages = new ArrayList();
		}
		messages.add(msg);
		request.getSession().setAttribute(type, messages);
	}
}