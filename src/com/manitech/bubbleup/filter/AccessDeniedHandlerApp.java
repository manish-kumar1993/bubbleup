/**
 * 
 */
package com.manitech.bubbleup.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.google.gson.JsonObject;
import com.manitech.bubbleup.restapi.enums.RestStatusEnum;

/**
 * 
 * @author Manish
 * @email 765mann@gmail.com
 * @createdDate Mar 17, 2018
 * @version 1.0
 */
public class AccessDeniedHandlerApp implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException arg2) throws IOException, ServletException {
		// Handles when user doesn't have permissions to access
		response.setStatus(401);
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		try {
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("status", RestStatusEnum.FAILURE.getCode());
			jsonObject.addProperty("message", "you are not authorised to access this url");

			response.getWriter().write(jsonObject.toString());
		} catch (IOException e) {
		} 
	}

}