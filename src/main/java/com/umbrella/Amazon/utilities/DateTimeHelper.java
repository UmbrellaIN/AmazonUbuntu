package com.umbrella.Amazon.utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author bsingh5
 *
 */
public class DateTimeHelper {

	public static String getCurrentDateTime() {

		DateFormat dateFormat = new SimpleDateFormat("_yyyy-MM-dd_HH-mm-ss");
		Calendar cal = Calendar.getInstance();
		String time = "" + dateFormat.format(cal.getTime());
		return time;
	}

	public static String getCurrentDate() {
		return getCurrentDateTime().substring(0, 11);
	}

	/*
	 * Conversion of dates into 24 Hour Input date and time: 23/12/2014 12:22:12
	 * PM (12 hour format) Output date and time: 12-23-2014 22:22:12 (24 hour
	 * format)
	 */
	public void convertdateinto24hourformat(String dateinampm) {
		// Date format String input = "23/12/2014 10:22:12 PM";
		String input = dateinampm;
		// Format of the date defined in the input String
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");
		// Desired format: 24 hour format: Change the pattern as per the need
		DateFormat outputformat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		Date date = null;
		String output = null;
		try {
			// Converting the input String to Date
			date = df.parse(input);
			// Changing the format of date and storing it in String
			output = outputformat.format(date);
			// Displaying the date
			System.out.println(output);
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
	}

	/*
	 * Input date and time: 15/02/2014 22:22:12(24 hour format dd/MM/yyyy
	 * HH:mm:ss) Output date and time: 2014-02-15 10:22:12 PM (12 hour format
	 * yyyy-MM-dd hh:mm:ss aa)
	 */

	public static void dateformat2() {
		// Input date in String format
		String input = "15/02/2014 22:22:12";
		// Date/time pattern of input date
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		// Date/time pattern of desired output date
		DateFormat outputformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aa");
		Date date = null;
		String output = null;
		try {
			// Conversion of input String to date
			date = df.parse(input);
			// old date format to new date format
			output = outputformat.format(date);
			System.out.println(output);
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
	}
}
