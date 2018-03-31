package com.manitech.bubbleup.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manitech.bubbleup.manager.UserDataManager;
import com.manitech.bubbleup.model.MasterRole;

public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDataManager userDataManager = new UserDataManager();
//		String loggedInUser = request.getRemoteUser();
//		UserDetail userInfo = null;
//		if (AppUtil.isNotEmpty(loggedInUser)) {
//			userInfo = new UserDataManager().getUserByUserName(loggedInUser);
//		}
		
		List<MasterRole> masterRoleList = userDataManager.getMasterRoles();
		request.setAttribute("masterRoleList", masterRoleList);
		

		request.getServletContext().getRequestDispatcher("/WEB-INF/pages/user/addUser.jsp").forward(request, response);
	}
}