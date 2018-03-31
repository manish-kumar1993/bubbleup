package com.manitech.bubbleup.manager;

import java.util.List;

import com.manitech.bubbleup.model.Role;
import com.manitech.bubbleup.model.UserDetail;

/**
 * 
 * @description
 * @file UserManagerV0.java
 * @author Manish
 * @email 765mann@gmail.com
 * @createdDate Mar 17, 2018
 * @version 1.0
 */
public interface UserManagerV0 extends BaseManager {

	public UserDetail getUserIdByToken(String token);

	public List<Role> getRoleList(UserDetail user);

}
