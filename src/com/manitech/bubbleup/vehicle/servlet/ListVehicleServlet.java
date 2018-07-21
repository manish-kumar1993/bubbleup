package com.manitech.bubbleup.vehicle.servlet;

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
import com.manitech.bubbleup.model.Vehicle;

public class ListVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServiceVehicleWorkerManager serviceVehicleWorkerManager = new ServiceVehicleWorkerManager();
		String totalCount="0";
		List<Vehicle> vehicles = serviceVehicleWorkerManager.getVehicleList("");
		if(vehicles !=null && vehicles.size() >0){
			totalCount=vehicles.size()+"";
		}
		request.setAttribute("vehicles", vehicles);
		request.setAttribute("totalCount", totalCount);

		request.getServletContext().getRequestDispatcher("/WEB-INF/pages/vehicle/vehicleList.jsp").forward(request, response);
	}
}