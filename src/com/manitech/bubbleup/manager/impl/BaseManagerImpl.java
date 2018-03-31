package com.manitech.bubbleup.manager.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.manitech.bubbleup.dao.BaseDao;
import com.manitech.bubbleup.manager.BaseManager;

/**
 * 
 * @description
 * @file BaseManagerImpl.java
 * @author Manish
 * @email 765mann@gmail.com
 * @createdDate Mar 17, 2018
 * @version 1.0
 */
public class BaseManagerImpl implements BaseManager {
	protected final Log log = LogFactory.getLog(getClass());

	/**
	 * BaseDao instance, set by constructor of child classes
	 */
	protected BaseDao dao;

	public BaseManagerImpl() {
	}

	public BaseManagerImpl(BaseDao baseDao) {
		this.dao = baseDao;
	}
}
