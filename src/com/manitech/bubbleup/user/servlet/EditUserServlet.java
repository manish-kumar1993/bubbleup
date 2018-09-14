package com.manitech.bubbleup.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manitech.bubbleup.manager.UserDataManager;
import com.manitech.bubbleup.model.Role;
import com.manitech.bubbleup.model.UserDetail;

public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		UserDataManager userDataManager = new UserDataManager();
		UserDetail user = userDataManager.getUserByUserId(userId);
		List<Role> roleList = userDataManager.getRoles();
		String roleId = user.getMasterRoleId();
		request.setAttribute("roleId",roleId);
		request.setAttribute("user", user);
		request.setAttribute("roleList", roleList);
		
		request.getServletContext().getRequestDispatcher("/WEB-INF/pages/user/editUser.jsp").forward(request, response);
	}
}
