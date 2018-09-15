package com.manitech.bubbleup.company.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manitech.bubbleup.manager.CompanyManager;
import com.manitech.bubbleup.manager.ServiceVehicleWorkerManager;
import com.manitech.bubbleup.manager.UserDataManager;
import com.manitech.bubbleup.model.Company;
import com.manitech.bubbleup.model.Services;
import com.manitech.bubbleup.model.UserDetail;
import com.manitech.bubbleup.util.AppUtil;

public class EditCompanyServlet extends HttpServlet {

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
			Company company = new CompanyManager().getCompanyById(id);
			List<Services> services = new ServiceVehicleWorkerManager().getServiceList(null);
			request.setAttribute("id", id);
			request.setAttribute("name", company.getName());
			request.setAttribute("address", company.getAddress());
			request.setAttribute("country", company.getCountry());
			request.setAttribute("village", company.getVillage());
			request.setAttribute("town", company.getTown());
			request.setAttribute("state", company.getState());
			request.setAttribute("serviceType", company.getServiceType());
			request.setAttribute("services", services);
			
		}
		request.getServletContext().getRequestDispatcher("/WEB-INF/pages/company/addCompany.jsp").forward(request, response);
	}

}
