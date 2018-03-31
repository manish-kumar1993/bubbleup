package com.manitech.bubbleup.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.manitech.bubbleup.dao.UserDaoV0;
import com.manitech.bubbleup.model.Role;
import com.manitech.bubbleup.model.UserDetail;
import com.manitech.bubbleup.util.DatabaseUtil;

/**
 * 
 * @description
 * @file UserDaoV0Impl.java
 * @author Manish
 * @email 765mann@gmail.com
 * @createdDate Mar 17, 2018
 * @version 1.0
 */

@Repository("userDaoV0")
public class UserDaoV0Impl extends BaseDaoImpl implements UserDaoV0 {

	public UserDetail getUserIdByToken(String token) {
		UserDetail userDetail = null;
		PreparedStatement preparedStatement = null;
		Connection conn = DatabaseUtil.getDbConnection();
		try {
			preparedStatement = conn
					.prepareStatement("select * from user u where u.token=? and status='ACTIVE' limit 1 ");
			preparedStatement.setString(1, token);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				userDetail = new UserDetail();
				userDetail.setId(rs.getString("id"));
				userDetail.setFirstName(rs.getString("firstName"));
				userDetail.setLastName(rs.getString("lastName"));
				userDetail.setUsername(rs.getString("username"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closePreparedStatement(preparedStatement);
			DatabaseUtil.closeDBConnection(conn);
		}
		return userDetail;
	}

	@Override
	public List<Role> getRoleList(UserDetail user) {
		List<Role> roleList = new ArrayList<Role>();
		Connection conn = DatabaseUtil.getDbConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = " select r.* from masterRole mr inner join masterRoleAccess mra on mr.masterRoleId=mra.masterRoleId inner join role r on mra.roleId=r.roleId where mr.masterRoleId=? ";
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, user.getMasterRoleId());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Role role = new Role();
				role.setRoleId(resultSet.getString("roleId"));
				role.setRoleDescription(resultSet.getString("roleDescription"));
				role.setRoleName(resultSet.getString("roleName"));
				roleList.add(role);
			}
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				DatabaseUtil.closePreparedStatement(preparedStatement);
				DatabaseUtil.closeDBConnection(conn);
			}
		return roleList;
	}
	
	 
}