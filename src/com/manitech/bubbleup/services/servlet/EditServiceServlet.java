package com.manitech.bubbleup.services.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manitech.bubbleup.manager.ServiceVehicleWorkerManager;
import com.manitech.bubbleup.manager.UserDataManager;
import com.manitech.bubbleup.model.Services;
import com.manitech.bubbleup.model.UserDetail;
import com.manitech.bubbleup.util.AppUtil;

public class EditServiceServlet extends HttpServlet {

	/**
	 * 
	 */
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
			Services services = new ServiceVehicleWorkerManager().getServiceById(id);
			request.setAttribute("id", id);
			request.setAttribute("type", services.getType());
			request.setAttribute("description", services.getDescription());
			request.setAttribute("status", services.getStatus());
		}
		request.getServletContext().getRequestDispatcher("/WEB-INF/pages/service/addService.jsp").forward(request, response);
	}

}
