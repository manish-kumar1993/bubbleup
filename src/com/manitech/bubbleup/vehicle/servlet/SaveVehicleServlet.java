package com.manitech.bubbleup.vehicle.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.manitech.bubbleup.manager.CompanyManager;
import com.manitech.bubbleup.manager.ServiceVehicleWorkerManager;
import com.manitech.bubbleup.manager.UserDataManager;
import com.manitech.bubbleup.model.UserDetail;
import com.manitech.bubbleup.util.AppUtil;

public class SaveVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDataManager userDataManager = new UserDataManager();

		String loggedInUser = request.getRemoteUser();
		UserDetail userInfo = null;
		if (AppUtil.isNotEmpty(loggedInUser)) {
			userInfo = userDataManager.getUserByUserName(loggedInUser);
		}

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String charges = request.getParameter("charges");

		request.setAttribute("id", id);
		request.setAttribute("name", name);
		request.setAttribute("charges", charges);
		
		boolean savedStaus = new ServiceVehicleWorkerManager().saveVehicleDetails(id, name,charges, userInfo.getId());
		if(savedStaus) {
			if(AppUtil.isNotEmpty(id)){
				saveMessageAndError(request, "Vehicle details updated successfully","messages");
				response.sendRedirect("listVehicles");
			}else{
				saveMessageAndError(request, "Vehicle details added successfully","messages");
//				request.getServletContext().getRequestDispatcher("/WEB-INF/pages/vehicle/addVehicle.jsp").forward(request, response);
				response.sendRedirect("listVehicles");
			}
		} else {
			saveMessageAndError(request, "There was some error. Please try again.","errors");
			request.getServletContext().getRequestDispatcher("/WEB-INF/pages/service/addVehicle.jsp").forward(request, response);
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