package com.manitech.bubbleup.services.servlet;

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

public class SaveServicesServlet extends HttpServlet {
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
		String service = request.getParameter("service");
		String description = request.getParameter("description");

		request.setAttribute("id", id);
		request.setAttribute("description", description);
		request.setAttribute("service", service);
		
		boolean savedStaus = new ServiceVehicleWorkerManager().saveServiceDetails(id, service,description, userInfo.getId());
		if(savedStaus) {
			if(AppUtil.isNotEmpty(id)){
				saveMessageAndError(request, "Service details updated successfully","messages");
				response.sendRedirect("listService");
			}else{
				saveMessageAndError(request, "Service details added successfully","messages");
				response.sendRedirect("listService");
			}
		} else {
			saveMessageAndError(request, "There was some error. Please try again.","errors");
			request.getServletContext().getRequestDispatcher("/WEB-INF/pages/service/addService.jsp").forward(request, response);
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