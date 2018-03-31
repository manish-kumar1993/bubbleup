package com.manitech.bubbleup.roleDao;

import java.util.List;

import com.manitech.bubbleup.model.MasterRole;

public interface RoleDao {

	List<MasterRole> getAllMasterRoles();

	int changeMasterRoleStatus(String masterRoleId,String status);

	List<MasterRole> getAllRoles();

	List<MasterRole> getAllRolesBasedOnMasterRoleId(String masterRoleId);

	int updateInMasterRoleAccess(String masterRoleId, String[] roleIds);

}
