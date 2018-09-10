package com.manitech.bubbleup.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.manitech.bubbleup.model.Services;
import com.manitech.bubbleup.model.Vehicle;
import com.manitech.bubbleup.util.AppUtil;
import com.manitech.bubbleup.util.DatabaseUtil;

public class ServiceVehicleWorkerManager {
	public List<Services> getServiceList(String userName) {
		List<Services> serviceList = new ArrayList<>();
		Statement statement = null;
		String query = "select * from services";
		Connection connection = DatabaseUtil.getDbConnection();
		try {
			ResultSet resultSet = null;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				Services service = new Services();
				service.setType(resultSet.getString("type"));
				service.setDescription(resultSet.getString("description"));
				service.setId(resultSet.getString("id"));
				service.setStatus(resultSet.getString("status"));
				serviceList.add(service);
			}
			resultSet.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			DatabaseUtil.closeDBConnection(connection);
		}
		return serviceList;
	}

	public boolean saveServiceDetails(String id, String type, String description, String userName) {
			StringBuffer query = new StringBuffer("");
			if(!AppUtil.isNotEmpty(id))
				query = query.append("insert into services (type,description,createdBy,createdOn,id) values(?,?,?,?,?)");
			else
				query = query.append("update services set type=?,description=?,createdBy=?,createdOn=? where id=?");
			boolean status = false;
			Connection connection = DatabaseUtil.getDbConnection();
			PreparedStatement prepareStatement = null;
			try {
				prepareStatement = connection.prepareStatement(query.toString());
				prepareStatement.setString(1, type);
				prepareStatement.setString(2, description);
				prepareStatement.setString(3, userName);
				prepareStatement.setString(4, AppUtil.getNowDate());
				if(AppUtil.isNotEmpty(id)) {
					prepareStatement.setString(5, id);
				} else {
					id = (UUID.randomUUID() + "");
					prepareStatement.setString(5, id);
				}
				int x = prepareStatement.executeUpdate();
				if (x > 0) {
					 status=true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DatabaseUtil.closePreparedStatement(prepareStatement);
				DatabaseUtil.closeDBConnection(connection);
			}
		return status;
	}
	/*public List<Services> getWorkerList(String userName) {
		List<Services> serviceList = new ArrayList<>();
		Statement statement = null;
		String query = "select * from services";
		Connection connection = DatabaseUtil.getDbConnection();
		try {
			ResultSet resultSet = null;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				Services service = new Services();
				service.setType(resultSet.getString("type"));
				service.setDescription(resultSet.getString("description"));
				service.setId(resultSet.getString("id"));
				serviceList.add(service);
			}
			resultSet.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			DatabaseUtil.closeDBConnection(connection);
		}
		return serviceList;
	}

	public boolean saveWorkerDetails(String id, String type, String description, String userName) {
			StringBuffer query = new StringBuffer("insert into services (type,description,createdBy,createdOn,id) values(?,?,?,?,?)");
			boolean status = false;
			Connection connection = DatabaseUtil.getDbConnection();
			PreparedStatement prepareStatement = null;
			try {
				prepareStatement = connection.prepareStatement(query.toString());
				prepareStatement.setString(1, type);
				prepareStatement.setString(2, description);
				prepareStatement.setString(3, userName);
				prepareStatement.setString(4, AppUtil.getNowDate());
				if(AppUtil.isNotEmpty(id)) {
					prepareStatement.setString(5, id);
				} else {
					id = (UUID.randomUUID() + "");
					prepareStatement.setString(5, id);
				}
				int x = prepareStatement.executeUpdate();
				if (x > 0) {
					 status=true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DatabaseUtil.closePreparedStatement(prepareStatement);
				DatabaseUtil.closeDBConnection(connection);
			}
		return status;
	}*/
	public List<Vehicle> getVehicleList(String userName) {
		List<Vehicle> vehicleList = new ArrayList<>();
		Statement statement = null;
		String query = "select * from vehicle";
		Connection connection = DatabaseUtil.getDbConnection();
		try {
			ResultSet resultSet = null;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				Vehicle vehicle = new Vehicle();
				vehicle.setName(resultSet.getString("name"));
				vehicle.setCharges(resultSet.getString("charges"));
				vehicle.setId(resultSet.getString("id"));
				vehicleList.add(vehicle);
			}
			resultSet.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			DatabaseUtil.closeDBConnection(connection);
		}
		return vehicleList;
	}

	public boolean saveVehicleDetails(String id, String name, String charges, String userName) {
			StringBuffer query = new StringBuffer("insert into vehicle (name,charges,createdBy,createdOn,id) values(?,?,?,?,?)");
			boolean status = false;
			Connection connection = DatabaseUtil.getDbConnection();
			PreparedStatement prepareStatement = null;
			try {
				prepareStatement = connection.prepareStatement(query.toString());
				prepareStatement.setString(1, name);
				prepareStatement.setString(2, charges);
				prepareStatement.setString(3, userName);
				prepareStatement.setString(4, AppUtil.getNowDate());
				if(AppUtil.isNotEmpty(id)) {
					prepareStatement.setString(5, id);
				} else {
					id = (UUID.randomUUID() + "");
					prepareStatement.setString(5, id);
				}
				int x = prepareStatement.executeUpdate();
				if (x > 0) {
					 status=true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DatabaseUtil.closePreparedStatement(prepareStatement);
				DatabaseUtil.closeDBConnection(connection);
			}
		return status;
	}

	public Services getServiceById(String id) {
		Services service = new Services();
		Statement statement = null;
		String query = "select * from services where id ='"+id+"'";
		Connection connection = DatabaseUtil.getDbConnection();
		try {
			ResultSet resultSet = null;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			if(resultSet.next()) {
				service.setType(resultSet.getString("type"));
				service.setDescription(resultSet.getString("description"));
				service.setId(resultSet.getString("id"));
				service.setStatus(resultSet.getString("status"));
			}
			resultSet.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			DatabaseUtil.closeDBConnection(connection);
		}
		return service;
	}

	public int deleteServiceById(String id) {
		Statement statement = null;
		int records = 0;
		String query = "delete  from services where id = '"+id+"'";
		Connection connection = DatabaseUtil.getDbConnection();
		try {
			statement = connection.createStatement();
			records = statement.executeUpdate(query);
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeDBConnection(connection);
		}
		return records;
	}
	
	public int updateServicesById(String id, String status) {
		Statement statement = null;
		int records = 0;
		String query = "update services set status = '"+status+"' where id = '"+id+"'";
		Connection connection = DatabaseUtil.getDbConnection();
		try {
			statement = connection.createStatement();
			records = statement.executeUpdate(query);
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeDBConnection(connection);
		}
		return records;
	}
}
