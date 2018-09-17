package com.manitech.bubbleup.worker.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manitech.bubbleup.manager.UserDataManager;
import com.manitech.bubbleup.model.UserDetail;

public class ListWorkerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String query = request.getParameter("query");
		UserDataManager userDataManager = new UserDataManager();
		String totalCount="0";
		List<UserDetail> users = userDataManager.getWorkers(null, query);
		if(users !=null && users.size() >0){
			totalCount=users.size()+"";
		}
		
		request.setAttribute("users", users);
		request.setAttribute("totalCount", totalCount);

		request.getServletContext().getRequestDispatcher("/WEB-INF/pages/worker/workerList.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}