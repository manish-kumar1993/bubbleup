package com.manitech.bubbleup.dao;

import java.util.List;

import com.manitech.bubbleup.model.Role;
import com.manitech.bubbleup.model.UserDetail;

/**
 * 
 * @description
 * @file UserDaoV0.java
 * @author Manish
 * @email 765mann@gmail.com
 * @createdDate Mar 17, 2018
 * @version 1.0
 */
public interface UserDaoV0 extends BaseDao {


	public UserDetail getUserIdByToken(String token);

	public List<Role> getRoleList(UserDetail user);
	
}
