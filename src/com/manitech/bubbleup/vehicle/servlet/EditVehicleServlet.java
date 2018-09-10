package com.manitech.bubbleup.vehicle.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manitech.bubbleup.manager.ServiceVehicleWorkerManager;
import com.manitech.bubbleup.manager.UserDataManager;
import com.manitech.bubbleup.model.Services;
import com.manitech.bubbleup.model.UserDetail;
import com.manitech.bubbleup.model.Vehicle;
import com.manitech.bubbleup.util.AppUtil;

public class EditVehicleServlet extends HttpServlet {

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
			Vehicle vehicle = new ServiceVehicleWorkerManager().getVehicleById(id);
			request.setAttribute("id", id);
			request.setAttribute("name", vehicle.getName());
			request.setAttribute("charges", vehicle.getCharges());
			request.setAttribute("status", vehicle.getStatus());
		}
		request.getServletContext().getRequestDispatcher("/WEB-INF/pages/vehicle/addVehicle.jsp").forward(request, response);
	}

}
