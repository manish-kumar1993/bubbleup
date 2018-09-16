package com.manitech.bubbleup.company.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manitech.bubbleup.manager.CompanyManager;
import com.manitech.bubbleup.manager.UserDataManager;
import com.manitech.bubbleup.model.Company;
import com.manitech.bubbleup.model.UserDetail;
import com.manitech.bubbleup.util.AppUtil;

public class AssignCompanyServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDataManager userDataManager = new UserDataManager();
	
		String loggedInUser = request.getRemoteUser();
		UserDetail userInfo = null;
		if (AppUtil.isNotEmpty(loggedInUser)) {
			userInfo = userDataManager.getUserByUserName(loggedInUser);
		}
		if(userInfo != null) {
			String id = request.getParameter("id");
			Company company = new CompanyManager().getCompanyById(id);
			List<UserDetail> users = new UserDataManager().getUsers(null, null);
			request.setAttribute("users", users);
			request.setAttribute("company", company);
			request.getServletContext().getRequestDispatcher("/WEB-INF/pages/company/assignCompany.jsp").forward(request, response);
		}
	}
}
