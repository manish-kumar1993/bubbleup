package com.manitech.bubbleup.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manitech.bubbleup.dao.UserDaoV0;
import com.manitech.bubbleup.dao.impl.UserDaoV0Impl;
import com.manitech.bubbleup.manager.UserManagerV0;
import com.manitech.bubbleup.model.Role;
import com.manitech.bubbleup.model.UserDetail;

/**
 * 
 * @description
 * @file UserManagerV0Impl.java
 * @author Manish
 * @email 765mann@gmail.com
 * @createdDate Mar 17, 2018
 * @version 1.0
 */

@Service("userManagerV0")
public class UserManagerV0Impl extends BaseManagerImpl implements UserManagerV0 {

	private UserDaoV0 userDaoV0;
	private UserDaoV0Impl userDaoV0Impl;

	@Autowired
	public void setUserDaoV0(UserDaoV0 userDaoV0) {
		this.dao = userDaoV0;
		this.userDaoV0 = userDaoV0;
	}

	@Autowired
	public void setUserDaoV0Impl(UserDaoV0Impl userDaoV0Impl) {
		this.userDaoV0Impl = userDaoV0Impl;
	}

	@Override
	public UserDetail getUserIdByToken(String token) {
		return userDaoV0.getUserIdByToken(token);
	}

	@Override
	public List<Role> getRoleList(UserDetail user) {
		return userDaoV0.getRoleList(user);
	}

}
