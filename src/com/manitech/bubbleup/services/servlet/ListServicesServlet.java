package com.manitech.bubbleup.services.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manitech.bubbleup.manager.ServiceVehicleWorkerManager;
import com.manitech.bubbleup.manager.UserDataManager;
import com.manitech.bubbleup.model.Services;
import com.manitech.bubbleup.model.UserDetail;

public class ListServicesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServiceVehicleWorkerManager serviceVehicleWorkerManager = new ServiceVehicleWorkerManager();
		String totalCount="0";
		List<Services> services = serviceVehicleWorkerManager.getServiceList("");
		if(services !=null && services.size() >0){
			totalCount=services.size()+"";
		}
		
		request.setAttribute("services", services);
		request.setAttribute("totalCount", totalCount);

		request.getServletContext().getRequestDispatcher("/WEB-INF/pages/service/serviceList.jsp").forward(request, response);
	}
}