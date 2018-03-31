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


/**
 * Servlet implementation class MasterRoleServlet
 */
public class ViewPermissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoleManager roleManager = new RoleManager();
		String masterRoleId=request.getParameter("masterRoleId");
		String [] roleIds = request.getParameterValues("roleIds");
		String page = request.getParameter("page");
		if(page !=null && page!="" && page.equalsIgnoreCase("SUBMIT")){
			int update = roleManager.updateInMasterRoleAccess(masterRoleId,roleIds);
			if(update>0){
				saveMessage(request, "Role Access Given Successfully");
			}
		}
		List<MasterRole> roleList = new ArrayList<MasterRole>();
		List<MasterRole> roleAccessList = new ArrayList<MasterRole>();
		roleAccessList =roleManager.getAllRolesBasedOnMasterRoleId(masterRoleId);
		roleList =roleManager.getAllRoles();
		request.setAttribute("roleList", roleList);
		request.setAttribute("roleAccessList", roleAccessList);
		request.setAttribute("masterRoleId", masterRoleId);
		request.setAttribute("masterRoleName", request.getParameter("masterRoleName"));
		
		RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/pages/role/roleDefinition.jsp");
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
