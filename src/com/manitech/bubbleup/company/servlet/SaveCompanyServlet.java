package com.manitech.bubbleup.company.servlet;

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
import com.manitech.bubbleup.model.Services;
import com.manitech.bubbleup.model.UserDetail;
import com.manitech.bubbleup.util.AppUtil;

public class SaveCompanyServlet extends HttpServlet {
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
		String address = request.getParameter("address");
		String country = request.getParameter("country");
		String village = request.getParameter("village");
		String town = request.getParameter("town");
		String state = request.getParameter("state");
		String serviceType = request.getParameter("serviceType");
		String paymentStatus = request.getParameter("paymentStatus");
		List<Services> services = new ServiceVehicleWorkerManager().getServiceList(null);
		
		request.setAttribute("id", id);
		request.setAttribute("name", name);
		request.setAttribute("address", address);
		request.setAttribute("country", country);
		request.setAttribute("village", village);
		request.setAttribute("town", town);
		request.setAttribute("state", state);
		request.setAttribute("serviceType", serviceType);
		request.setAttribute("services", services);
		
		boolean savedStaus = new CompanyManager().saveCompanyDetails(id, name, address, country, village,
					town,  state, serviceType, paymentStatus, userInfo.getId());
		if(savedStaus) {
			if(AppUtil.isNotEmpty(id)){
				saveMessageAndError(request, "Company details updated successfully","messages");
				response.sendRedirect("dashboard");
			}else{
				saveMessageAndError(request, "Company details added successfully","messages");
				response.sendRedirect("dashboard");
			}
		} else {
			saveMessageAndError(request, "There was some error. Please try again.","errors");
			request.getServletContext().getRequestDispatcher("/WEB-INF/pages/company/addCompany.jsp").forward(request, response);
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