package com.manitech.bubbleup;

/**
 * 
 * @description
 * @file Constants.java
 * @author Manish
 * @email 765mann@gmail.com
 * @createdDate Mar 17, 2018
 * @version 1.0
 */
public final class Constants {
	private Constants() {
		// hide me
	}

	static String os = System.getProperty("os.name");

	public static final String INACTIVE = "INACTIVE";
	public static final String ACTIVE = "ACTIVE";
	public static final String DELETE = "DELETE";
	public static final String OPEN = "OPEN";
	public static final String ROLE_USER = "ROLE_USER";
	public static final String AUDITOR = "Auditor";
	public static final String APP_NAME = "bubbleup";
	public static final String IMAGES_DIRECTORY = "images";
	public static final String Community = "COMMUNITY";
	public static final String ROLE_SERVER_ADMIN = "ROLE_SERVER_ADMIN";
	public static final String ROLE_COMPANY_ADMIN = "ROLE_COMPANY_ADMIN";

	// Windows file location
	static String UPLOAD_DIR_WINDOWS = "c:/" + APP_NAME;

	// Linux file location
	public static final String UPLOAD_DIR_UBUNTU = "/home/usr/" + APP_NAME;

	// MAC file location
	public static final String UPLOAD_DIR_MAC = System.getProperty("user.home") + "/" + APP_NAME;
	
	public static final String getFilePath() {
		String filePath = "";
		if (os.startsWith("Windows")) {
			filePath = UPLOAD_DIR_WINDOWS;
		} else if (os.contains("Mac")) {
			filePath = UPLOAD_DIR_MAC;

		} else {
			filePath = UPLOAD_DIR_UBUNTU;
		}
		return filePath;
	}

}