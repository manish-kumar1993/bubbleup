package com.manitech.bubbleup.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.manitech.bubbleup.model.Company;
import com.manitech.bubbleup.util.AppUtil;
import com.manitech.bubbleup.util.DatabaseUtil;

public class CompanyManager {
	public List<Company> getCompanyList(String userName, String companyName) {
		List<Company> companyList = new ArrayList<>();
		Statement statement = null;
		String query = "select * from company where 1=1";
		if(AppUtil.isNotEmpty(companyName))
			query += " and name like'%"+companyName+"%'";
		Connection connection = DatabaseUtil.getDbConnection();
		try {
			ResultSet resultSet = null;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				Company company = new Company();
				company.setAddress(resultSet.getString("address"));
				company.setAssignedTo(resultSet.getString("assignedTo"));
				company.setCountry(resultSet.getString("country"));
				company.setId(resultSet.getString("id"));
				company.setName(resultSet.getString("name"));
				company.setPaymentStatus(resultSet.getString("paymentStatus"));
				company.setState(resultSet.getString("state"));
				company.setTown(resultSet.getString("town"));
				company.setVillage(resultSet.getString("village"));
				company.setStatus(resultSet.getString("status"));
				companyList.add(company);
			}
			resultSet.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			DatabaseUtil.closeDBConnection(connection);
		}
		return companyList;
	}

	public boolean saveCompanyDetails(String id, String name, String address, String country, String village,
			String town, String state, String serviceType, String paymentStatus, String userName) {
			StringBuffer query = new StringBuffer();
			if(!AppUtil.isNotEmpty(id)) {
				query.append("insert into company (name,address,country,village,town,state,serviceType,paymentStatus,createdBy,createdOn,id) values(?,?,?,?,?,?,?,?,?,?,?)");
			} else {
				query.append("update  company set name=?,address=?,country=?,village=?,town=?,state=?,serviceType=?,paymentStatus=?,createdBy=?,createdOn=? where id=?");
			}
			boolean status = false;
			Connection connection = DatabaseUtil.getDbConnection();
			PreparedStatement prepareStatement = null;
			try {
				prepareStatement = connection.prepareStatement(query.toString());
				prepareStatement.setString(1, name);
				prepareStatement.setString(2, address);
				prepareStatement.setString(3, country);
				prepareStatement.setString(4, village);
				prepareStatement.setString(5, town);
				prepareStatement.setString(6, state);
				prepareStatement.setString(7, serviceType);
				prepareStatement.setString(8, paymentStatus);
				prepareStatement.setString(9, userName);
				prepareStatement.setString(10, AppUtil.getNowDate());
				if(AppUtil.isNotEmpty(id)) {
					prepareStatement.setString(11, id);
				} else {
					id = (UUID.randomUUID() + "");
					prepareStatement.setString(11, id);
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

	public Company getCompanyById(String id) {
		Company company = new Company();
		Statement statement = null;
		String query = "select * from company where id = '"+id+"'";
		Connection connection = DatabaseUtil.getDbConnection();
		try {
			ResultSet resultSet = null;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			if (resultSet.next()) {
				company.setAddress(resultSet.getString("address"));
				company.setAssignedTo(resultSet.getString("assignedTo"));
				company.setCountry(resultSet.getString("country"));
				company.setId(resultSet.getString("id"));
				company.setName(resultSet.getString("name"));
				company.setPaymentStatus(resultSet.getString("paymentStatus"));
				company.setState(resultSet.getString("state"));
				company.setTown(resultSet.getString("town"));
				company.setVillage(resultSet.getString("village"));
				company.setServiceType(resultSet.getString("serviceType"));
			}
			resultSet.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			DatabaseUtil.closeDBConnection(connection);
		}
		return company;
	}

	public int deleteCompanyById(String id) {
		Statement statement = null;
		int records = 0;
		String query = "delete  from company where id = '"+id+"'";
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

	public int updateCompanyById(String id, String status) {
		Statement statement = null;
		int records = 0;
		String query = "update company set status = '"+status+"' where id = '"+id+"'";
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
