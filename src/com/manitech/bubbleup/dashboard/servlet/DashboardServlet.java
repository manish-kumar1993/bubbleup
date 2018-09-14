package com.manitech.bubbleup.dashboard.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manitech.bubbleup.Constants;
import com.manitech.bubbleup.manager.CompanyManager;
import com.manitech.bubbleup.manager.UserDataManager;
import com.manitech.bubbleup.model.Company;
import com.manitech.bubbleup.model.UserDetail;

public class DashboardServlet extends HttpServlet{
	String query;
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getRemoteUser();
		String query = request.getParameter("query");
		UserDataManager userManager = new UserDataManager();
		UserDetail user = userManager.getUserByUserName(username);
		String roleName = userManager.geRolesByUserId(user.getUserId());
		if (Constants.ROLE_SERVER_ADMIN.equals(roleName)) {
			CompanyManager companyManager = new CompanyManager();
			List<Company> companyList = companyManager.getCompanyList(username,query);
			request.setAttribute("companyList", companyList);
			request.getServletContext().getRequestDispatcher("/WEB-INF/pages/dashboard/dashboard.jsp").forward(request, response);
		} else {
			request.getServletContext().getRequestDispatcher("/WEB-INF/pages/dashboard/adminDashboard.jsp").forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
