package com.manitech.bubbleup.json.model;

import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 
 * @file ResponseJson.java
 * @author Manish
 * @email 765mann@gmail.com
 * @createdDate Mar 17, 2018
 * @version 1.0
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResponseJson implements Serializable {

	private static final long serialVersionUID = -3942144430594863526L;

	private int status;
	private String message;
	private String lastSyncTime;
	private Object data;
	private String username;
	private String roleName;
	private String token;
	private String imageId;
	
	public ResponseJson(int status, String message,String lastSyncTime,String imageId) {
		super();
		this.status = status;
		this.message = message;
		this.lastSyncTime = lastSyncTime;
		this.imageId=imageId;
	}
	
	public ResponseJson(int status, String message,String token,String username,String roleName) {
		super();
		this.status = status;
		this.message = message;
		this.token = token;
		this.username=username;
		this.roleName=roleName;
	}
	
	
	public ResponseJson(int status, String message,String lastSyncTime, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.lastSyncTime=lastSyncTime;
		this.data = data;
		
	}
	public ResponseJson(int status, String message, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
		
	}
	
	/**
	 * Create a Response Json object with status message and data as inputs.
	 * 
	 * @param status
	 * @param message
	 */
	public ResponseJson(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	

	public ResponseJson(String userRequest) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	public String getLastSyncTime() {
		return lastSyncTime;
	}

	public void setLastSyncTime(String lastSyncTime) {
		this.lastSyncTime = lastSyncTime;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	

}
