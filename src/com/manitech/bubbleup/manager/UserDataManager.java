package com.manitech.bubbleup.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.manitech.bubbleup.model.MasterRole;
import com.manitech.bubbleup.model.UserDetail;
import com.manitech.bubbleup.util.AppUtil;
import com.manitech.bubbleup.util.DatabaseUtil;

public class UserDataManager {
	public boolean saveUserDetails(String userId, String firstName, String lastName, String username, String password, String mobileNo, String saltedPass, String status, String enabled, String loggedInUser, String masterRoleId) {
		String token = null;
		String saveQuery = null;
		boolean isUpdateQuery = false;
		String updatedPassword = null;
		PasswordEncoder passwordEncoder = AppUtil.getPasswordEncoder();
		updatedPassword = passwordEncoder.encode(password);
		// check password updating or not
			if (userId != null) {
			saveQuery = "update  user set firstName=?,lastName=?,username=?,password=?,mobile=?,status=?,enabled=?,updatedDate=?,updatedBy=? where id=?";
			isUpdateQuery = true;
		} else {
			saveQuery = "insert into user (firstName,lastName,username,password,mobile,status,enabled,createdDate,createdBy,id,token) values(?,?,?,?,?,?,?,?,?,?,?)";
		}

		Connection connection = DatabaseUtil.getDbConnection();
		PreparedStatement prepareStatement = null;
		boolean update = false;
		try {
			prepareStatement = connection.prepareStatement(saveQuery);
			prepareStatement.setString(1, firstName);
			prepareStatement.setString(2, lastName);
			prepareStatement.setString(3, username);
			if (saltedPass != null) {
				if (saltedPass.equals(password) || passwordEncoder.matches(password, saltedPass)) {
					prepareStatement.setString(4, saltedPass);
				} else {
					// updatedPassword = passwordEncoder.encode(password);
					prepareStatement.setString(4, updatedPassword);
				}
			} else {
				// updatedPassword = passwordEncoder.encode(password);
				prepareStatement.setString(4, updatedPassword);
			}
			prepareStatement.setString(5, mobileNo);
			prepareStatement.setString(6, status);
			prepareStatement.setString(7, enabled);
			prepareStatement.setString(8, AppUtil.getNowDate());
			prepareStatement.setString(9, loggedInUser);
			if (userId != null) {
				prepareStatement.setString(10, userId);
			} else {
				token = UUID.nameUUIDFromBytes((username + System.currentTimeMillis()).getBytes()).toString();
				userId = (UUID.randomUUID() + "");
				prepareStatement.setString(10, userId);
				prepareStatement.setString(11, token);
			}
			int x = prepareStatement.executeUpdate();
			if (x > 0) {
				 
				if (isUpdateQuery) {
					deleteExistingRoleFromUserMasterRole(userId);
				}
				 userMasterRoleTableInsertion(userId, masterRoleId);
				 update=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closePreparedStatement(prepareStatement);
			DatabaseUtil.closeDBConnection(connection);
		}
		return update;
	}
 

	
 

	private int userMasterRoleTableInsertion(String userId, String masterRoleId) {
		PreparedStatement prepareStatement = null;
		Connection connection = DatabaseUtil.getDbConnection();
		int insert = 0;
		String userRoleSql = "insert into userMasterRole (userMasterRoleId,userId,masterRoleId) values(uuid(),?,?)";
		try {
			prepareStatement = connection.prepareStatement(userRoleSql);
			prepareStatement.setString(1, userId);
			prepareStatement.setString(2, masterRoleId);
			insert = prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeDBConnection(connection);
			DatabaseUtil.closePreparedStatement(prepareStatement);
		}
		return insert;
	}

	private void deleteExistingRoleFromUserMasterRole(String userId) {
		Connection connection = DatabaseUtil.getDbConnection();
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection.prepareStatement("delete from userMasterRole where userId=?");
			prepareStatement.setString(1, userId);
			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closePreparedStatement(prepareStatement);
			DatabaseUtil.closeDBConnection(connection);
		}

	}



	public boolean isUsernameExist(String username, String userId) {
		StringBuffer selectQuery = new StringBuffer("select username from user where username=? ");
		if (AppUtil.isNotEmpty(userId)) {
			selectQuery.append(" and not id='" + userId + "'");
		}
		Connection connection = DatabaseUtil.getDbConnection();
		PreparedStatement prepareStatement = null;
		boolean isUserAvailabel = false;
		try {
			prepareStatement = connection.prepareStatement(selectQuery.toString());
			prepareStatement.setString(1, username);
			ResultSet resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				isUserAvailabel = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closePreparedStatement(prepareStatement);
			DatabaseUtil.closeDBConnection(connection);
		}

		return isUserAvailabel;
	}

	public boolean isEmailExist(String email) {
		StringBuffer selectQuery = new StringBuffer("select email,status from user where email=? limit 1 ");

		Connection connection = DatabaseUtil.getDbConnection();
		PreparedStatement prepareStatement = null;
		boolean isUserAvailabel = false;
		try {
			prepareStatement = connection.prepareStatement(selectQuery.toString());
			prepareStatement.setString(1, email);
			ResultSet resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				isUserAvailabel = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closePreparedStatement(prepareStatement);
			DatabaseUtil.closeDBConnection(connection);
		}

		return isUserAvailabel;
	}

	public UserDetail getUserByUserName(String username) {
		String selectQuery = null;
		UserDetail userDetail = null;
		if (AppUtil.isNotEmpty(username)) {
			selectQuery = "select id,username,token,status,firstName,lastName from user where  username=? ";
			Connection connection = DatabaseUtil.getDbConnection();
			PreparedStatement prepareStatement = null;
			try {
				prepareStatement = connection.prepareStatement(selectQuery);
				prepareStatement.setString(1, username);
				ResultSet resultSet = prepareStatement.executeQuery();

				if (resultSet.next()) {
					userDetail = new UserDetail();
					userDetail.setUserId(resultSet.getString("id"));
					userDetail.setId(resultSet.getString("id"));
					userDetail.setUsername(resultSet.getString("username"));
					userDetail.setFirstName(resultSet.getString("firstName"));
					userDetail.setLastName(resultSet.getString("lastName"));
					userDetail.setToken(resultSet.getString("token"));
					userDetail.setName(resultSet.getString("firstName") + "  " + resultSet.getString("lastName"));
					userDetail.setStatus(resultSet.getString("status"));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DatabaseUtil.closePreparedStatement(prepareStatement);
				DatabaseUtil.closeDBConnection(connection);
			}
		}
		return userDetail;
	}

	public String getClientLogoByclientId(String clientId) {
		String selectQuery = null;
		String logo = "";
		if (AppUtil.isNotEmpty(clientId)) {
			selectQuery = "select clientLogo from client where  clientId=? ";
			Connection connection = DatabaseUtil.getDbConnection();
			PreparedStatement prepareStatement = null;

			try {
				prepareStatement = connection.prepareStatement(selectQuery);
				prepareStatement.setString(1, clientId);
				ResultSet resultSet = prepareStatement.executeQuery();

				if (resultSet.next()) {
					logo = resultSet.getString("clientLogo");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DatabaseUtil.closePreparedStatement(prepareStatement);
				DatabaseUtil.closeDBConnection(connection);
			}
		}
		return logo;
	}


	public boolean updateUserPassword(String password, String username) {
		boolean passwordUpdated = false;
		Connection connection = DatabaseUtil.getDbConnection();
		PreparedStatement prepareStatement = null;

		try {
			prepareStatement = connection.prepareStatement("update user set password=? where username=?");
			String currentPassword = AppUtil.getPasswordEncoder().encode(password);
			prepareStatement.setString(1, currentPassword);
			prepareStatement.setString(2, username);
			int updatedRecords = prepareStatement.executeUpdate();
			// if (x > 0) {
			// passwordUpdated = changePasswordHistory(history, currentPassword, connection);
			// }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closePreparedStatement(prepareStatement);
			DatabaseUtil.closeDBConnection(connection);
		}

		return passwordUpdated;
	}

	public List<MasterRole> getMasterRoles() {
		Statement statement = null;
		StringBuilder roleSql = new StringBuilder("select masterRoleId, masterRoleName ,status from masterRole ");
		roleSql.append("order by masterRoleName ");
		List<MasterRole> masterRoleList = new ArrayList<>();
		Connection connection = DatabaseUtil.getDbConnection();
		try {
			statement = connection.createStatement();
			ResultSet rsRole = statement.executeQuery(roleSql.toString());
			while (rsRole.next()) {
				MasterRole masterRole = new MasterRole();
				masterRole.setMasterRoleId(rsRole.getString("masterRoleId"));
				masterRole.setMasterRoleName(rsRole.getString("masterRoleName"));
				masterRole.setStatus(rsRole.getString("status"));
				masterRoleList.add(masterRole);
			}
			rsRole.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeDBConnection(connection);
			DatabaseUtil.closeStatement(statement);
		}
		return masterRoleList;
	}

	public UserDetail getUserByUserId(String userId) {
		String selectQuery = null;
		UserDetail userDetail = null;
		if (AppUtil.isNotEmpty(userId)) {
			selectQuery = "select u.id,u.username,u.password,u.token,u.status,u.firstName,u.lastName,u.mobile,u.enabled,mr.masterRoleName,mr.masterRoleId from user as u left join userMasterRole as umr "
					+ "on umr.userId=u.id left join masterRole as mr on mr.masterRoleId=umr.masterRoleId where  id=? ";
			Connection connection = DatabaseUtil.getDbConnection();
			PreparedStatement prepareStatement = null;
			try {
				prepareStatement = connection.prepareStatement(selectQuery);
				prepareStatement.setString(1, userId);
				ResultSet resultSet = prepareStatement.executeQuery();

				if (resultSet.next()) {
					userDetail = new UserDetail();
					userDetail.setUserId(resultSet.getString("u.id"));
					userDetail.setUsername(resultSet.getString("u.username"));
					userDetail.setFirstName(resultSet.getString("u.firstName"));
					userDetail.setLastName(resultSet.getString("u.lastName"));
					userDetail.setPassword(resultSet.getString("u.password"));
					userDetail.setToken(resultSet.getString("u.token"));
					userDetail.setName(resultSet.getString("u.firstName") + "  " + resultSet.getString("u.lastName"));
					userDetail.setStatus(resultSet.getString("u.status"));
					userDetail.setMobile(resultSet.getString("u.mobile"));
					userDetail.setEnabled(resultSet.getString("u.enabled"));
					userDetail.setMasterRoleName(resultSet.getString("mr.masterRoleName"));
					userDetail.setMasterRoleId(resultSet.getString("mr.masterRoleId"));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DatabaseUtil.closePreparedStatement(prepareStatement);
				DatabaseUtil.closeDBConnection(connection);
			}
		}
		return userDetail;
	}

	public List<UserDetail> getUsers(String userId, String clientId) {
		List<UserDetail> userDetails = new ArrayList<UserDetail>();
		Connection connection = DatabaseUtil.getDbConnection();
		PreparedStatement preparedStatement = null;
		StringBuffer stringBuffer = new StringBuffer(
				"select u.id,u.username,u.mobile,u.token,u.password,u.status,u.firstName,u.lastName, " + "umr.masterRoleId,mr.masterRoleName " + "from user as u left join userMasterRole as umr on umr.userId=u.id left join masterRole as mr on mr.masterRoleId=umr.masterRoleId ");
		try {
			preparedStatement = connection.prepareStatement(stringBuffer.toString());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				UserDetail userDetail = new UserDetail();
				userDetail.setUserId(resultSet.getString("u.id"));
				userDetail.setUsername(resultSet.getString("u.username"));
				userDetail.setPassword(resultSet.getString("u.password"));
				userDetail.setMobileNo(resultSet.getString("u.mobile"));
				userDetail.setToken(resultSet.getString("u.token"));
				userDetail.setStatus(resultSet.getString("u.status"));
				userDetail.setFirstName(resultSet.getString("u.firstName"));
				userDetail.setLastName(resultSet.getString("u.lastName"));
				userDetail.setMasterRoleId(resultSet.getString("umr.masterRoleId"));
				userDetail.setMasterRoleName(resultSet.getString("mr.masterRoleName"));
				userDetails.add(userDetail);
			}
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closePreparedStatement(preparedStatement);
			DatabaseUtil.closeDBConnection(connection);
		}
		return userDetails;
	}


	public Set<UserDetail> getUserRegionNameBasedOnRegionId(List<UserDetail> userRegion) {
		Set<UserDetail> userDetails = new HashSet<UserDetail>();
		Connection connection = DatabaseUtil.getDbConnection();
		PreparedStatement preparedStatement = null;
		for (int i = 0; i < userRegion.size(); i++) {
			StringBuffer stringBuffer = new StringBuffer("select region from region where 1=1 ");
			if (AppUtil.isNotEmpty(userRegion.get(i).getRegionId())) {
				stringBuffer.append(" and id='" + userRegion.get(i).getRegionId() + "' ");
			}
			try {
				preparedStatement = connection.prepareStatement(stringBuffer.toString());
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					UserDetail userDetail = new UserDetail();
					userDetail.setRegion(resultSet.getString("region"));
					userDetails.add(userDetail);
				}
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DatabaseUtil.closePreparedStatement(preparedStatement);
				DatabaseUtil.closeDBConnection(connection);
			}
		}
		return userDetails;
	}

	public boolean userRoleUpdate(String masterRoleId, List<UserDetail> userRoleIds) {
		boolean update = false;
		Connection connection = DatabaseUtil.getDbConnection();
		PreparedStatement preparedStatement = null;
		StringBuffer stringBuffer = new StringBuffer("select userId from userMasterRole where 1=1 ");
		if (AppUtil.isNotEmpty(masterRoleId)) {
			stringBuffer.append(" and masterRoleId='" + masterRoleId + "' ");
		}
		try {
			preparedStatement = connection.prepareStatement(stringBuffer.toString());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				UserDetail userDetail = new UserDetail();
				userDetail.setUserId(resultSet.getString("userId"));
			}

			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closePreparedStatement(preparedStatement);
			DatabaseUtil.closeDBConnection(connection);
		}
		return update;
	}

}
