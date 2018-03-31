package com.manitech.bubbleup.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.google.gson.Gson;
import com.manitech.bubbleup.json.model.RequestJson;

/**
 * @description
 * @file AppUtil.java
 * @author jakki
 * @email jithendra@trisysit.com
 * @date Jun 20, 2016
 * @version 1.5
 * @modifiedDate Jul 08, 2016
 */
public class AppUtil {

	/**
	 * Private Constructor so that an instance of AppUtil cannot be created
	 */
	private AppUtil() {
	}

	// Windows file location

	// Linux file location
	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
	private static SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
	private static SimpleDateFormat dateFormat3 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	/**
	 * 
	 * Bellow Scripts(getDayName, getHourOfTheDay) are getting used in multiple
	 * classes..
	 */
	public static String getDayName = " case when day = 1 then 'SUN' when day = 2 then 'MON' when day = 3 then 'TUE' when day = 4 then 'WED' "
			+ " when day = 5 then 'THU' when day = 6 then 'FRI' when day = 7 then 'SAT' else  '' end as day ";

	public static String getHourOfTheDay = " case when hourOfTheDay = 6 then '06:00-07:00' when hourOfTheDay = 7 then '07:00-08:00' when hourOfTheDay = 8 then '08:00-09:00' "
			+ " when hourOfTheDay = 9 then '09:00-10:00' when hourOfTheDay = 10 then '10:00-11:00'  when hourOfTheDay = 11 then '11:00-12:00' "
			+ " when hourOfTheDay = 12 then '12:00-13:00' when hourOfTheDay = 13 then '13:00-14:00' when hourOfTheDay = 14 then '14:00-15:00' "
			+ " when hourOfTheDay = 15 then'15:00-16:00' when hourOfTheDay = 16 then '16:00-17:00' when  hourOfTheDay = 17 then '17:00-18:00' "
			+ "else '' end as hourOfTheDay ";

	// MAC file location


	private static PasswordEncoder passwordEncoder;

	/**
	 * @description returns the password encoder implementation.
	 * @date Jun 20, 2016
	 * @version 1.0
	 * @modifiedDate Jun 20, 2016
	 */
	public static PasswordEncoder getPasswordEncoder() {
		if (passwordEncoder == null) {
			passwordEncoder = new BCryptPasswordEncoder();
		}
		return passwordEncoder;
	}

	/**
	 * 
	 * @description adds the attribute value object to session if the request
	 *              and attributeName are not null
	 * @author jakki
	 * @email jithendra@trisysit.com
	 * @createdDate Jun 23, 2016
	 * @version 1.0
	 * @modifiedDate Jun 23, 2016
	 */
	public static void setAttributeToSession(HttpServletRequest request, String attributeName, Object attributeValue) {
		if (request != null && isNotEmpty(attributeName)) {
			request.getSession().setAttribute(attributeName, attributeValue);
		}
	}

	/**
	 * 
	 * @description retrives the attribute value object to session if the
	 *              request and attributeName are not null, else returns null
	 * @author jakki
	 * @email jithendra@trisysit.com
	 * @createdDate Jun 23, 2016
	 * @version 1.0
	 * @modifiedDate Jun 23, 2016
	 */
	public static Object getAttributeFromSession(HttpServletRequest request, String attributeName) {
		if (request != null && isNotEmpty(attributeName)) {
			return request.getSession().getAttribute(attributeName);
		}
		return null;
	}

	/**
	 * 
	 * @description adds the message to the message list in the session if the
	 *              request object is not null
	 * @author jakki
	 * @email jithendra@trisysit.com
	 * @createdDate Jun 23, 2016
	 * @version 1.0
	 * @modifiedDate Jun 23, 2016
	 */
	@SuppressWarnings("unchecked")
	public static void saveMessageToSession(HttpServletRequest request, String message) {
		if (request != null) {
			List<String> messages = (List<String>) request.getSession().getAttribute("messages");
			if (messages == null) {
				messages = new ArrayList<String>();
			}
			messages.add(message);
			request.getSession().setAttribute("messages", messages);
		}
	}

	/**
	 * 
	 * @description adds the message to the errorMessage list in the session if
	 *              the request object is not null
	 * @author jakki
	 * @email jithendra@trisysit.com
	 * @createdDate Jun 23, 2016
	 * @version 1.0
	 * @modifiedDate Jun 23, 2016
	 */
	@SuppressWarnings("unchecked")
	public static void setErrorMessageToSession(HttpServletRequest request, String message) {
		if (request != null) {
			List<String> errors = (List<String>) request.getSession().getAttribute("errorMessages");
			if (errors == null) {
				errors = new ArrayList<String>();
			}
			errors.add(message);
			request.getSession().setAttribute("errorMessages", errors);
		}
	}

	public static boolean isNotEmpty(String value) {
		if (value != null && !"".equals(value) && value != "NULL" && !"null".equals(value)) {
			return true;
		}
		return false;
	}

	public static boolean isNotEmpty(int value) {
		if (value != 0) {
			return true;
		}
		return false;
	}

	public static Date getCurrentDate() {
		return new Date();
	}

	public static String getYesterdayDateString() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return dateFormat.format(cal.getTime());
	}

	public static String getTodayDateString() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 0);
		return dateFormat.format(cal.getTime());
	}


	/**
	 * @description the following method is a small hack to supply values for in
	 *              clause as prepared statement in java does not support list
	 *              values to be passed a parameter
	 * @author jithendra
	 * @createdDate Jul 8, 2016
	 * @version 1.0
	 * @lastModifiedDate Jul 8, 2016
	 */
	public static String getStringListQueryParam(String value) {
		String valueParam = "";
		if (AppUtil.isNotEmpty(value)) {
			valueParam = value.replace(",", "','");
		}
		return valueParam;
	}

	public static String getSyncDateFilter(String lastSyncTime) {

		if (lastSyncTime != null && !"".equals(lastSyncTime)) {
			return " and (createdDate >= " + "'" + lastSyncTime + "' or updatedDate >=" + "'" + lastSyncTime + "')";

		}

		return "";
	}

	public static String getNowDate() {
		return dateFormat2.format(new Date());
	}
	
	public static String getNowDateWithTime() {
		return dateFormat3.format(new Date());
	}
	
	public static String getNowDateWithTime1() {
		return dateFormat3.format(new Date());
	}

	public static String getFormatedDate(Date date) {
		if (date != null) {
			return formatter.format(date);
		}
		return null;
	}

	public static String getDayMonthFormat(Date date) {
		if (date != null) {
			return format.format(date);
		}
		return null;
	}

	public static String getDateTime(String date) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateTime = null;
		try {
			Date dateFormate = dateFormat.parse(date);
			dateTime = AppUtil.getFormatedDate(dateFormate);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return dateTime;

	}

	public static double getFormatedValue(double value) {
		if (value != 0.0) {
			double roundOff = Math.round(value * 100.00) / 100.00;
			return roundOff;
		}
		return value;
	}

	public static String stringDateFormater(String str) {

		if (str != null && str.length() > 0) {
			str = str.substring(0, str.length() - 2);
		}
		return str;
	}

	public static RequestJson getRequestJson(HttpServletRequest httpServletRequest) {
		String body = "";
		try {
			body = (String) getRequestBody(httpServletRequest.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		RequestJson requestJson = (RequestJson) gson.fromJson(body, RequestJson.class);
		return requestJson;
	}

	public static String getRequestBody(InputStream inputStream) throws IOException {
		String body = null;
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;

		try {
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
					throw ex;
				}
			}
		}
		body = stringBuilder.toString();
		return body;
	}

	public static String getDecimalPoint(String data) {
		if (data != null && !data.isEmpty() && !"0.0".equals(data) && !"0".equals(data)) {
			int index = data.lastIndexOf(".");
			if (index > 0 && index + 3 <= data.length()) {
				index = index + 3;
				String finalString = data.substring(0, index);
				return finalString;
			} else if (index + 2 == data.length()) {
				data = data + "0";
				return data;
			} else {
				return data;
			}
		}
		return "0.0";
	}

	public static String arrayToString(String[] idStr) {
		if (idStr != null) {
			String ids = "";
			ids = Arrays.toString(idStr);
			ids = ids.substring(1, ids.length() - 1);
			return ids;
		}
		return null;
	}

	public static String[] getDateRange(String btnText) {
		String[] dates = { "", "", "", "" };
		if ("This Month".equals(btnText) || "Last Month".equals(btnText)) {
			Date today = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(today);
			if ("Last Month".equals(btnText)) {
				calendar.add(Calendar.MONTH, -1);
			}
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			Date firstDayOfMonth = calendar.getTime();

			calendar.setTime(today);
			if ("Last Month".equals(btnText)) {
				calendar.add(Calendar.MONTH, -1);
			}
			calendar.add(Calendar.MONTH, 1);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			calendar.add(Calendar.DATE, -1);
			Date lastDayOfMonth = calendar.getTime();

			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			dates[0] = sdf.format(firstDayOfMonth);
			dates[1] = sdf.format(lastDayOfMonth);
			dates[2] = " Date(`date`)  ";
			dates[3] = "yyyy-MM-dd";
		} else if ("This Year".equals(btnText) || "Last Year".equalsIgnoreCase(btnText)) {
			Calendar c = GregorianCalendar.getInstance();
			if ("Last Year".equals(btnText)) {
				c.add(Calendar.YEAR, -1);
			}
			int mYear = c.get(Calendar.YEAR);
			String startYear = mYear + "-01-01";
			String endYear = mYear + "-12-31";
			dates[0] = startYear;
			dates[1] = endYear;

			dates[2] = " concat(concat(Year(`date`),'-'),concat(If(Month(`date`)<'10',concat('0',Month(`date`)),Month(`date`)))) ";
			dates[3] = "yyyy-MM";
		} else if ("This Quarter".equals(btnText)) {
			Date today = new Date();
			Calendar c = GregorianCalendar.getInstance();
			c.setTime(today);
			float thisMonth = c.get(Calendar.MONTH) + 1;
			int thisYear = c.get(Calendar.YEAR);
			String quarter = thisMonth / 3 <= 1 ? "Q1" : thisMonth / 3 <= 2 ? "Q2" : thisMonth / 3 <= 3 ? "Q3" : "Q4";
			switch (quarter) {
			case "Q2":
				dates[0] = thisYear + "-04-01";
				dates[1] = thisYear + "-06-30";
				break;
			case "Q3":
				dates[0] = thisYear + "-07-01";
				dates[1] = thisYear + "-09-30";
				break;
			case "Q4":
				dates[0] = thisYear + "-10-01";
				dates[1] = thisYear + "-12-31";
				break;
			default:
				dates[0] = thisYear + "-01-01";
				dates[1] = thisYear + "-03-31";
				break;
			}
			dates[2] = " concat(concat(Year(`date`),'-'),CASE " + " WHEN Month(`date`) IN (1, 2, 3) THEN 'Q1' "
					+ " WHEN Month(`date`) IN (4, 5, 6) THEN  'Q2' " + " WHEN Month(`date`) IN (7, 8, 9) THEN  'Q3' "
					+ " ELSE  'Q4' END )";
			dates[3] = null;
		} else {
			Calendar c = GregorianCalendar.getInstance();
			if (c.getTime().getDay() == 0) {
				c.add(Calendar.DATE, -7);
			}
			c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
			dates[0] = df.format(c.getTime());
			c.add(Calendar.DATE, 6);
			dates[1] = df.format(c.getTime());
			dates[2] = " Date(`date`) ";
			dates[3] = "yyyy-MM-dd";
		}
		return dates;
	}

	public static String[] getPreviousYearDate() {
		String[] dates = { "", "", "", "" };
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);

		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DATE, -1);
		Date lastDayOfYear = calendar.getTime();
		
		calendar.add(Calendar.YEAR, -1);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date firstDayOfYear = calendar.getTime();

		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		dates[0] = sdf.format(firstDayOfYear);
		dates[1] = sdf.format(lastDayOfYear);
		dates[2] = " concat(concat(Year(`emailCreatedDate`),'-'),concat(If(Month(`emailCreatedDate`)<'10',concat('0',Month(`emailCreatedDate`)),Month(`emailCreatedDate`)))) ";
		dates[3] = "yyyy-MM";

		return dates;
	}

	public static String getFormatedDatefordmy(Date date) {
		if (date != null) {
			return dateFormat1.format(date);
		}
		return null;
	}
	
	
	public static long date2Timestamp(String timeIn) {
		
//		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");			
//	    DateTime dt = formatter.parseDateTime(timeIn);
		
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");	
		DateTime dt = formatter.parseDateTime(timeIn);
		
		 long timestamp = dt.getMillis()/1000;
	    
		return timestamp;
	}
	
	public static String changeDateFormatte(String date) {	
		String newDate = "";
		Date dateValue = null;
		try {
			dateValue = dateFormat3.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newDate = formatter.format(dateValue);
		return newDate;		
	}
	/*
	 * public static String getDayName(){ String dayName =
	 * " case when day = 1 then 'SUN' when day = 2 then 'MON' when day = 3 then 'TUE' when day = 4 then 'WED' "
	 * +
	 * " when day = 5 then 'THU' when day = 6 then 'FRI' when day = 7 then 'SAT' else  '' end as day "
	 * ; return dayName; }
	 */
}