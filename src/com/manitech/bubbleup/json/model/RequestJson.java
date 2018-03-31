package com.manitech.bubbleup.json.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.manitech.bubbleup.model.Role;
import com.manitech.bubbleup.util.AppUtil;

/**
 * @description this is used to send in the request parameters in the request
 *              body
 * @file RequestJson.java
 * @author Manish
 * @email 765mann@gmail.com
 * @createdDate Mar 17, 2018
 * @version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class RequestJson implements Serializable {

	private static final long serialVersionUID = -4577299083148155379L;
	private String token;
	private String lastSyncTime;
	private String username;
	private String password;
	private String orderId;
	private String orderMobileId;
	private String status;
	private String uniqueCode;
	private String tbgrOrVbgrNo;
	private String roleName;
	private String name;
	private String firstName;
	private String lastName;
	private String rejectedStatus;
	private String registrationId;
    private List<Role> userRoleAccessList;
   

	private String villageName;
    
	public RequestJson(String token,String roleName,String userName,String firstName,String lastName,List<Role> userRoleAccessList) {
		this.token = token;
		this.roleName=roleName;
		this.username=userName;
		this.firstName=firstName;
		this.lastName=lastName;
		this.userRoleAccessList=userRoleAccessList;
	}

	public RequestJson() {
		
	}
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token
	 *            the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	
	public RequestJson(String token) {
		this.token = token;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public String getLastSyncTime() {
		// TODO make the date 1 day before
		String finalDateStr = null;
		if (AppUtil.isNotEmpty(lastSyncTime)) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				Date myDate = sdf.parse(lastSyncTime);
				Date newDate = new Date(myDate.getTime() - 86400000);
				finalDateStr = sdf.format(newDate);
			} catch (Exception e) {
				System.out.println(e.getMessage() + "");
			}
		}
		return finalDateStr;
	}

	public void setLastSyncTime(String lastSyncTime) {
		this.lastSyncTime = lastSyncTime;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderMobileId() {
		return orderMobileId;
	}

	public void setOrderMobileId(String orderMobileId) {
		this.orderMobileId = orderMobileId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUniqueCode() {
		return uniqueCode;
	}

	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}

	public String getTbgrOrVbgrNo() {
		return tbgrOrVbgrNo;
	}

	public void setTbgrOrVbgrNo(String tbgrOrVbgrNo) {
		this.tbgrOrVbgrNo = tbgrOrVbgrNo;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @return the rejectedSatus
	 */
	
	public String getRejectedStatus() {
		return rejectedStatus;
	}

	/**
	 * @param rejectedSatus the rejectedSatus to set
	 */
	public void setRejectedStatus(String rejectedStatus) {
		this.rejectedStatus = rejectedStatus;
	}

	/**
	 * @return the registrationId
	 */
	public String getRegistrationId() {
		return registrationId;
	}

	/**
	 * @param registrationId the registrationId to set
	 */
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
	public List<Role> getUserRoleAccessList() {
		return userRoleAccessList;
	}

	public void setUserRoleAccessList(List<Role> userRoleAccessList) {
		this.userRoleAccessList = userRoleAccessList;
	}


	public String getVillageName() {
		return villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
	
}
