package com.manitech.bubbleup.company.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manitech.bubbleup.manager.CompanyManager;
import com.manitech.bubbleup.manager.UserDataManager;
import com.manitech.bubbleup.model.UserDetail;
import com.manitech.bubbleup.util.AppUtil;

public class UpdateCompanyServlet extends HttpServlet{
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
			String status = request.getParameter("status");
			String[] assignedUsers= request.getParameterValues("assignedUsers");
			int records = new CompanyManager().updateCompanyById(id,status,assignedUsers);
			if(records >0) {
				if(AppUtil.isNotEmpty(status)) {
					if("INACTIVE".equals(status))
						saveMessageAndError(request, "Company marked Inactive","messages");
					else {
						saveMessageAndError(request, "Company marked Active","messages");
					}
				} else {
					saveMessageAndError(request, "Company Assigned Successfully","messages");
				}
			}
		}
		response.sendRedirect("dashboard");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
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
