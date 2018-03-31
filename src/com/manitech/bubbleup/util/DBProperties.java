package com.manitech.bubbleup.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @description
 * @file DBProperties.java
 * @author jakki
 * @email jithendra@trisysit.com
 * @createdDate Jun 22, 2016
 * @version 1.0
 * @modifiedDate Jun 22, 2016
 */

public class DBProperties {

	private static Properties properties;

	private DBProperties() {

	}

	public static String getProperty(String key) {
		if (properties == null) {
			InputStream fileInput = DBProperties.class.getClassLoader().getResourceAsStream("db.properties");
			properties = new Properties();
			try {
				properties.load(fileInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (properties != null && properties.containsKey(key)) {
			return properties.getProperty(key);
		}
		return key;
	}
}
