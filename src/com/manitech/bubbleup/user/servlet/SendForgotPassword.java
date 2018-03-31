package com.manitech.bubbleup.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manitech.bubbleup.manager.UserDataManager;
import com.manitech.bubbleup.model.MasterRole;
import com.manitech.bubbleup.model.UserDetail;
import com.manitech.bubbleup.util.AppUtil;

public class SendForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		
		UserDataManager userDataManager = new UserDataManager(); 
		boolean isUserAvailable = userDataManager.isEmailExist(email);
		if (isUserAvailable) {
			setMessages(request,"messages","Your request is recorded. We will send your password shortly to your email.");
			response.sendRedirect("/login"); 
		}else
		{
			setMessages(request,"errors","Email is not in our system. Please contact administrator.");
			request.getServletContext().getRequestDispatcher("/WEB-INF/pages/forgotPassword.jsp").forward(request,response);
			
		}
	}

	private void setMessages(HttpServletRequest request,String messageType,String message) {
		List mList = (List) request.getSession().getAttribute(messageType);
		if (mList == null) {
			mList = new ArrayList();
		}
		mList.add(message);
		request.getSession().setAttribute(messageType, mList);
	}
	 
	 
}