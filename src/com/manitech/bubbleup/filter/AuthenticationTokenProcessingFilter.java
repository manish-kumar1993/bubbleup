/**
 * 
 */
package com.manitech.bubbleup.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.cxf.service.invoker.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.GenericFilterBean;

import com.google.gson.Gson;
import com.manitech.bubbleup.json.model.RequestJson;
import com.manitech.bubbleup.model.UserDetail;
import com.manitech.bubbleup.util.AppUtil;

/**
 * 
 * @author Manish
 * @email 765mann@gmail.com
 * @createdDate Mar 17, 2018
 * @version 1.0
 */
public class AuthenticationTokenProcessingFilter extends GenericFilterBean {

	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		MultiReadHttpServletRequest httpServletRequest = new MultiReadHttpServletRequest((HttpServletRequest) request);
		String token = null;
//		String registrationId = null;
		boolean isMultipart = ServletFileUpload.isMultipartContent(httpServletRequest);
		if (isMultipart) {
			List<FileItem> multiparts;
			try {
				multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(httpServletRequest);
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						// for file
					} else {
						String value = item.getString();
						Gson gson = new Gson();
						RequestJson requestJson = (RequestJson) gson.fromJson(value, RequestJson.class);
						token = requestJson.getToken();
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		} else {
			RequestJson requestJson = AppUtil.getRequestJson(httpServletRequest);
			if (requestJson != null) {
				token = requestJson.getToken();
			}
		}
		if (token != null && !token.isEmpty()) {

			List<UserDetail> users = null; //write query here
			if (users != null && users.size() > 0) {
				UserDetails userDetails = (UserDetails) users.get(0);
				SecurityContextHolder.getContext().setAuthentication(new UserAuthentication(userDetails, userDetails.isEnabled() && "ACTIVE".equals(users.get(0).getStatus())));
			}
		}
		chain.doFilter(httpServletRequest, response);
	}
}

