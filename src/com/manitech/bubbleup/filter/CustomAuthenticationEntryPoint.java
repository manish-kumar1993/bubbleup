/**
 * 
 */
package com.manitech.bubbleup.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.google.gson.JsonObject;
import com.manitech.bubbleup.restapi.enums.RestStatusEnum;

/**
 * 
 * @author Manish
 * @email 765mann@gmail.com
 * @createdDate Mar 17, 2018
 * @version 1.0
 */
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

		response.setStatus(401);
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		try {
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("status", RestStatusEnum.FAILURE.getCode());
			jsonObject.addProperty("message", "you are not logged in to access this url");

			response.getWriter().write(jsonObject.toString());
		} catch (IOException e) {
		} 
	}
}
