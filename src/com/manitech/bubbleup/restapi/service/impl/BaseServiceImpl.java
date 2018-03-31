package com.manitech.bubbleup.restapi.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.manitech.bubbleup.manager.BaseManager;
import com.manitech.bubbleup.manager.UserManagerV0;

/**
 * 
* @description 
* @file BaseServiceImpl.java
* @author jakki
* @email jithendra@trisysit.com
* @createdDate Aug 30, 2016 
* @version 1.0
* @modifiedDate Aug 30, 2016
 */
public class BaseServiceImpl implements BaseManager {
	protected final Log log = LogFactory.getLog(getClass());
	
	protected UserManagerV0 userManagerV0;
	

	@Autowired
	public void setUserManager(UserManagerV0 userManagerV0) {
		this.userManagerV0 = userManagerV0;
	}

	 
	
	

}
