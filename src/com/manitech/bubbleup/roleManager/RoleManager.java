package com.manitech.bubbleup.roleManager;

import java.util.List;

import com.manitech.bubbleup.model.MasterRole;
import com.manitech.bubbleup.roleDao.RoleDao;
import com.manitech.bubbleup.roleDao.RoleDaoImpl;

public class RoleManager {
	
	private RoleDao roleDao;

	public RoleManager() {
		this.roleDao = new RoleDaoImpl();
	}

	public List<MasterRole> getAllMasterRoles() {
		return roleDao.getAllMasterRoles();
	}

	public int changeMasterRoleStatus(String masterRoleId, String status) {
		// TODO Auto-generated method stub
		return roleDao.changeMasterRoleStatus(masterRoleId,status);
	}

	public List<MasterRole> getAllRoles() {
		// TODO Auto-generated method stub
		return roleDao.getAllRoles();
	}

	public List<MasterRole> getAllRolesBasedOnMasterRoleId(String masterRoleId) {
		// TODO Auto-generated method stub
		return roleDao.getAllRolesBasedOnMasterRoleId(masterRoleId);
	}

	public int updateInMasterRoleAccess(String masterRoleId, String[] roleIds) {
		// TODO Auto-generated method stub
		return roleDao.updateInMasterRoleAccess(masterRoleId,roleIds);
	}
	
//	public List<Customer> getAllCustomerList(String remoteUser, Customer customerForSearch, int pageNo, String status) {
//		// TODO Auto-generated method stub
//		return customerDao.getAllCustomerList(remoteUser, customerForSearch, pageNo,status);
//
//	}

}
