/**
 * 
 */
package com.yoga.User.util;

import java.util.Calendar;
import java.util.Date;

public class GenericHelper {
	
	/**
	 * Method to get the current date to persist in DB.
	 * @return Date
	 */
	public static Date getCurrentDate() {
		long currentDate = new Date().getTime() + 0;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(currentDate));
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

}
