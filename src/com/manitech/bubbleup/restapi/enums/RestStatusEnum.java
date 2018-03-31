package com.manitech.bubbleup.restapi.enums;

/**
 * 
* @description 
* @file RestStatusEnum.java
* @author bharath
* @email bharath@trisysit.com
* @createdDate Sep , 2017
* @version 1.0
* @modifiedDate Sep , 2017
 */
public enum RestStatusEnum {
	SUCCESS(200, "Ok"), 
	FAILURE(500, "Internal Server Error"), 
	UNAUTHORISED(401, "Unauthorised request"), 
	BAD_REQUEST(400, "The request could not be understood by the server due to malformed syntax"), 
	FORBIDDEN(403, "The server understood the request, but is refusing to fulfill it."), 
	SERVICE_UNAVAILABLE(503, "The server is currently unable to handle the request due to a temporary overloading or maintenance of the server."),
	PERMISSIONDENIED(101, "Permission Denied"),
	NODATAFOUND(412, "No data available");
	private int code;
	private String description;

	private RestStatusEnum(int code, String description) {
		this.code = code;
		this.description = description;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

}