package com.manitech.bubbleup.role;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manitech.bubbleup.model.MasterRole;
import com.manitech.bubbleup.roleManager.RoleManager;
import com.manitech.bubbleup.util.AppUtil;


/**
 * Servlet implementation class MasterRoleServlet
 */
public class MasterRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoleManager roleManager = new RoleManager();
		String masterRoleId = request.getParameter("masterRoleId");
		String status = request.getParameter("status");
		if(AppUtil.isNotEmpty(masterRoleId) ){
			int insertUpdateStatus = roleManager.changeMasterRoleStatus(masterRoleId,status);
			if(insertUpdateStatus > 0){
				if(status.equalsIgnoreCase("ACTIVE")){
					saveMessage(request, "Role Activated Successfully");
				}else{
					saveMessage(request, "Role Inactivated Successfully");
				}
		}
		}
		List<MasterRole> masterRoleList = new ArrayList<MasterRole>();
		masterRoleList =roleManager.getAllMasterRoles();
		request.setAttribute("masterRoleList", masterRoleList);
		
		RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/pages/role/masterRole.jsp");
		requestDispatcher.forward(request, response);
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void saveMessage(HttpServletRequest request, String msg) {
		List messages = (List) request.getSession().getAttribute("messages");
		if (messages == null) {
			messages = new ArrayList();
		}
		messages.add(msg);
		request.getSession().setAttribute("messages", messages);
	}

}
