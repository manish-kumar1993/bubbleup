package com.manitech.bubbleup.roleDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.manitech.bubbleup.model.MasterRole;
import com.manitech.bubbleup.util.AppUtil;
import com.manitech.bubbleup.util.DatabaseUtil;

public class RoleDaoImpl implements RoleDao{

	@Override
	public List<MasterRole> getAllMasterRoles() {
		List<MasterRole> masterRoles = new ArrayList<MasterRole>();
		Connection connection = DatabaseUtil.getDbConnection();
		PreparedStatement preparedStatement = null;
		StringBuffer stBuffer = new StringBuffer("select * from masterRole where 1=1 ");
//		stBuffer.append(" order by datemax desc");
		try {
			preparedStatement = connection.prepareStatement(stBuffer.toString());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				MasterRole masterRole = new MasterRole();
				masterRole.setMasterRoleId(resultSet.getString("masterRoleId"));
				masterRole.setMasterRoleName(resultSet.getString("masterRoleName"));
				masterRole.setStatus(resultSet.getString("status"));
				masterRoles.add(masterRole);
			}
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closePreparedStatement(preparedStatement);
			DatabaseUtil.closeDBConnection(connection);
		}
		return masterRoles;
	}
	
	
//	public int changeMasterRoleStatus(String masterRoleId, String status) {
//		int status = 0;
//		int update = 0;
//		Connection connection = DatabaseUtils.getDbConnection();
//		PreparedStatement prepareStatement = null;
//		try {
//			prepareStatement = connection.prepareStatement("update masterRole set status=?");
//				prepareStatement.setString(1, "ACTIVE");
//				status = prepareStatement.executeUpdate();
//				if(status>0){
//				update =	updateMasterRoleStatus(checkBoxValues);
//				}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DatabaseUtils.closePreparedStatement(prepareStatement);
//		}
//		return update;
//	}

	@Override
	public int changeMasterRoleStatus(String masterRoleId, String status) {
		int update = 0;
		Connection connection = DatabaseUtil.getDbConnection();
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection.prepareStatement("update masterRole set status=? where masterRoleId=?");
			if(status.equalsIgnoreCase("ACTIVE")){
				prepareStatement.setString(1, "ACTIVE");
			}
			if(status.equalsIgnoreCase("INACTIVE")){
				prepareStatement.setString(1, "INACTIVE");
			}
				prepareStatement.setString(2, masterRoleId);
				update = prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closePreparedStatement(prepareStatement);
			DatabaseUtil.closeDBConnection(connection);
		}
		return update;
	}

	@Override
	public List<MasterRole> getAllRoles() {
		List<MasterRole> roles = new ArrayList<MasterRole>();
		Connection connection = DatabaseUtil.getDbConnection();
		PreparedStatement preparedStatement = null;
		StringBuffer stBuffer = new StringBuffer("select * from role where 1=1 ");
//		stBuffer.append(" order by datemax desc");
		try {
			preparedStatement = connection.prepareStatement(stBuffer.toString());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				MasterRole role = new MasterRole();
				role.setRoleId(resultSet.getString("roleId"));
				role.setRoleName(resultSet.getString("roleName"));
				role.setRoleDescription(resultSet.getString("roleDescription"));
				roles.add(role);
			}
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closePreparedStatement(preparedStatement);
			DatabaseUtil.closeDBConnection(connection);
		}
		return roles;
	}
	
	@Override
	public List<MasterRole> getAllRolesBasedOnMasterRoleId(String masterRoleId) {
		List<MasterRole> roles = new ArrayList<MasterRole>();
		Connection connection = DatabaseUtil.getDbConnection();
		PreparedStatement preparedStatement = null;
		StringBuffer stBuffer = new StringBuffer("select * from masterRoleAccess where 1=1 ");
		if(AppUtil.isNotEmpty(masterRoleId)){
			stBuffer.append("and masterRoleId = '"+masterRoleId+"' ");
		}
//		stBuffer.append(" order by datemax desc");
		try {
			preparedStatement = connection.prepareStatement(stBuffer.toString());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				MasterRole role = new MasterRole();
				role.setRoleId(resultSet.getString("roleId"));
				role.setMasterRoleId(resultSet.getString("masterRoleId"));
				roles.add(role);
			}
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closePreparedStatement(preparedStatement);
			DatabaseUtil.closeDBConnection(connection);
		}
		return roles;
	}
	
	@Override
	public int updateInMasterRoleAccess(String masterRoleId,String[] checkBoxValues) {
		int status = 0;
		int update = 0;
		Connection connection = DatabaseUtil.getDbConnection();
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection.prepareStatement("delete from masterRoleAccess where masterRoleId=?");
				prepareStatement.setString(1, masterRoleId);
				status = prepareStatement.executeUpdate();
				if(checkBoxValues !=null && checkBoxValues.length>0){
					update =	updateMasterRoleAccess(masterRoleId,checkBoxValues);
				}else{
					update=1;
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closePreparedStatement(prepareStatement);
			DatabaseUtil.closeDBConnection(connection);
		}
		return update;
	}

	
	public int updateMasterRoleAccess(String masterRoleId,String[] roleIds) {
		int status = 0;
		Connection connection = DatabaseUtil.getDbConnection();
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection.prepareStatement("insert into masterRoleAccess(masterRoleAccessId,masterRoleId,roleId) values(UUID(),?,?)");
			for (String roleId : roleIds) {
				prepareStatement.setString(1, masterRoleId);
				prepareStatement.setString(2, roleId);
				status = prepareStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closePreparedStatement(prepareStatement);
			DatabaseUtil.closeDBConnection(connection);
		}
		return status;
	}

}
