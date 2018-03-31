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
	public List<Company> getCompanyList(String userName) {
		List<Company> companyList = new ArrayList<>();
		Statement statement = null;
		String query = "select * from company";
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
			StringBuffer query = new StringBuffer("insert into company (name,address,country,village,town,state,"
					+ "serviceType,paymentStatus,createdBy,createdOn,id) values(?,?,?,?,?,?,?,?,?,?,?)");
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
}
