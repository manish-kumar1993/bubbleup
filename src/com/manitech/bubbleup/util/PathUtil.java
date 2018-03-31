package com.manitech.bubbleup.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @description Util to get the Path for dynamic resources and other files.
 * @file PathUtil.java
 * @author jakki
 * @email jithendra@trisysit.com
 * @date Mar 21, 2016
 * @version 1.0
 */
public final class PathUtil {
	private static final Log log = LogFactory.getLog(PathUtil.class);
	
	/**
	 * Checkstyle rule: utility classes should not have public constructor
	 */
	private PathUtil() {
	}
	
	/**
	 * Windows File location to place dynamic resources
	 */
	private static final String UPLOAD_DIR_WINDOWS = "c:/bubbleup";

	/**
	 * Ubuntu File location to place dynamic resources
	 */
	private static final String UPLOAD_DIR_UBUNTU = "/home/usr/bubbleup";

	/**
	 * Mac File location to place dynamic resources
	 */
	private static final String UPLOAD_DIR_MAC = System.getProperty("user.home") + "/bubbleup";

	/**
	 * retrives the operating system on which the application is running
	 */
	public static String os = System.getProperty("os.name");
	
	static{
		log.debug("Running Application on "+os);
	}
	
	public static final String getFilePath() {
		String filePath = null;
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
