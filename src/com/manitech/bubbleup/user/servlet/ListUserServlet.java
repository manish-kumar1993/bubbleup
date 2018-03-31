package com.manitech.bubbleup.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manitech.bubbleup.manager.UserDataManager;
import com.manitech.bubbleup.model.UserDetail;

public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDataManager userDataManager = new UserDataManager();
//		String clientId = AppUtil.getClientId(request);
		String totalCount="0";
		List<UserDetail> users = userDataManager.getUsers(null, null);
		if(users !=null && users.size() >0){
			totalCount=users.size()+"";
		}
		
		request.setAttribute("users", users);
		request.setAttribute("totalCount", totalCount);

		request.getServletContext().getRequestDispatcher("/WEB-INF/pages/user/userList.jsp").forward(request, response);
	}
}