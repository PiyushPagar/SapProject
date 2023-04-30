package com.SapPortal.util;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;

public class DateUtil {
	public static Date localToDate(LocalDate localDate) {
		return new Date(localDate.toEpochDay() * 86400000L);
	}

	public static LocalDate dateToLocalDate(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static LocalDate stringToLocalDate(String string, String format) throws ParseException {
		Date d = new SimpleDateFormat(format).parse(string);
		return Instant.ofEpochMilli(new java.sql.Date(d.getTime()).getTime()).atZone(ZoneId.systemDefault())
				.toLocalDate();
	}

	public static String formatDate(Date date, String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(date);
	}

	public static String currentformatDateTime(String format) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	public static long daysBetween(Date one, Date two) {
		if (one != null && two != null) {
			long difference = (one.getTime() - two.getTime()) / 86400000;
			return Math.abs(difference);
		}
		return 0;
	}

	public static Date getLastMonthFirstDate(DateTime systemToday) {
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(systemToday.toDate());
		aCalendar.add(Calendar.MONTH, -1);
		aCalendar.set(Calendar.DATE, 1);
		return aCalendar.getTime();
	}

	public static Integer getWeekofYear(LocalDate systemToday) {
		return systemToday.get(WeekFields.ISO.weekOfWeekBasedYear());
	}

	public static Date getLastMonthLastDate(DateTime systemToday) {
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(systemToday.toDate());
		aCalendar.add(Calendar.MONTH, -1);
		int lastDate = aCalendar.getActualMaximum(Calendar.DATE);
		aCalendar.set(Calendar.DATE, lastDate);
		return aCalendar.getTime();
	}

	public static Date toDate(String string, String format) {
		try {
			Date d = new SimpleDateFormat(format).parse(string);
			return new java.sql.Date(d.getTime());
		} catch (ParseException e) {
			return null;
		}
	}

	public static Date toDateUtilDateGMTtoIST(String string, String format) {
		try {
			SimpleDateFormat simp = new SimpleDateFormat(format);
			simp.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
			Date d = simp.parse(string);
			Time t = addTime(new Time(d.getTime()), 5, 30);
			d = new Date(t.getTime());
			return d;
		} catch (ParseException e) {
			return null;
		}
	}

	public static Date toDateByAllFormat(String string, String format) {
		Date date = null;

		date = toDate(string, format);

		// check for dd-MM-yyyy
		if (date == null) {
			date = toDate(string, "yyyy-MM-dd");
		}
		if (date == null) {
			date = toDate(string, "dd-MM-yyyy");
		}

		return date;

	}

	public static Date toHourDate(String string, String format) {
		try {
			return new SimpleDateFormat(format).parse(string);
		} catch (ParseException e) {
			return null;
		}
	}

	public static Date toHourDateByAllFormattoset(String string1, String format) {
		Date date = null;
		String string = string1 + " 00:00:00";
		date = toHourDate(string, format);

		// check for dd-MM-yyyy
		if (date == null) {
			date = toHourDate(string, "dd-MM-yyyy HH:mm:ss aa");
		}

		if (date == null) {
			date = toHourDate(string, "dd-MM-yyyy HH:mm:ss");
		}

		if (date == null) {
			date = toHourDate(string, "dd-MM-yyyy HH:mm");
		}

		if (date == null) {
			date = toHourDate(string, "yyyy-MM-dd HH:mm:ss aa");
		}

		if (date == null) {
			date = toHourDate(string, "yyyy-MM-dd HH:mm:ss");
		}

		if (date == null) {
			date = toHourDate(string, "yyyy-MM-dd HH:mm");
		}

		return date;

	}

	public static Date toHourDateByAllFormat(String string, String format) {
		Date date = null;

		date = toHourDate(string, format);

		// check for dd-MM-yyyy
		if (date == null) {
			date = toHourDate(string, "dd-MM-yyyy HH:mm:ss aa");
		}

		if (date == null) {
			date = toHourDate(string, "dd-MM-yyyy HH:mm:ss");
		}

		if (date == null) {
			date = toHourDate(string, "dd-MM-yyyy HH:mm");
		}

		if (date == null) {
			date = toHourDate(string, "yyyy-MM-dd HH:mm:ss aa");
		}

		if (date == null) {
			date = toHourDate(string, "yyyy-MM-dd HH:mm:ss");
		}

		if (date == null) {
			date = toHourDate(string, "yyyy-MM-dd HH:mm");
		}

		return date;

	}

	public static XMLGregorianCalendar dateToXMLGregorianCalendar(Date date) {
		try {
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(date);
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static XMLGregorianCalendar dateToXMLGregorianCalendarByFormatter(Date date) {
		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

			return DatatypeFactory.newInstance().newXMLGregorianCalendar(format.format(date));
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	public static Date setTimeToZero(Date date) {
		date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0);
		return date;
	}

	@SuppressWarnings("deprecation")
	public static Date setTime(Date date, Integer hour, Integer min, Integer sec) {
		date.setHours(hour);
		date.setMinutes(min);
		date.setSeconds(sec);
		return date;
	}

	public static Date getLastDateOfMonth(DateTime systemToday) {
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(systemToday.toDate());
		int lastDate = aCalendar.getActualMaximum(Calendar.DATE);
		aCalendar.set(Calendar.DATE, lastDate);
		return aCalendar.getTime();
	}

	public static Date getLastDateOfMonthbyDate(Date systemToday) {
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(systemToday);
		int lastDate = aCalendar.getActualMaximum(Calendar.DATE);
		aCalendar.set(Calendar.DATE, lastDate);
		return aCalendar.getTime();
	}

	public static Date getFirstDateOfMonthbyDate(Date systemToday) {
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(systemToday);
		int lastDate = aCalendar.getActualMinimum(Calendar.DATE);
		aCalendar.set(Calendar.DATE, lastDate);
		return aCalendar.getTime();
	}

	public static Date setDayofMonth(Date datetoSet, Date currentDate) {
		Calendar datetoSetCal = Calendar.getInstance();
		datetoSetCal.setTime(datetoSet);
		Calendar currDateCal = Calendar.getInstance();
		currDateCal.setTime(currentDate);
		datetoSetCal.set(Calendar.DATE, currDateCal.get(Calendar.DAY_OF_MONTH));
		datetoSetCal.set(Calendar.HOUR_OF_DAY, 0);
		return datetoSetCal.getTime();
	}

	public static Date getFirstDateOfMonth(DateTime systemToday) {
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(systemToday.toDate());
		aCalendar.set(Calendar.DATE, 1);
		return aCalendar.getTime();
	}

	public static Date addDays(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}

	public static Date addYear(Date date, int year) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, year); // to get previous year add -1
		return cal.getTime();
	}

	public static Date addMonth(Date date, int month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, month);
		return cal.getTime();
	}

	public static Date swapDateYear(Date date, Date setDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);

		Calendar ncal = Calendar.getInstance();
		ncal.setTime(setDate);
		if (ncal.get(Calendar.DATE) == 29 && ncal.get(Calendar.MONTH) == 2) {
			ncal.set(Calendar.DATE, 28);
		}
		ncal.set(Calendar.YEAR, year);
		return ncal.getTime();
	}

	public static java.time.LocalDate asLocalDate(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static Date getDate(Date date) {
		return DateUtils.truncate(date, java.util.Calendar.DAY_OF_MONTH);
	}

	public static Date convertToDate(LocalDate dateToConvert) {
		return java.sql.Date.valueOf(dateToConvert);
	}

	public static Calendar getLastMonth(DateTime systemToday) {
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(systemToday.toDate());
		aCalendar.add(Calendar.MONTH, -1);
		aCalendar.set(Calendar.DATE, 1);
		return aCalendar;
	}

	public static Date minusDay(DateTime dateTime, Integer minusDay) {
		return dateTime.minusDays(minusDay).toDate();
	}

	public static Date addDay(DateTime dateTime, Integer plusDay) {
		return dateTime.plusDays(plusDay).toDate();
	}

	public static Date convertDateTimeToDate(DateTime dateTime) {
		return dateTime.toDate();
	}

	public static Integer getMonth(Date date) {
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int month = localDate.getMonthValue();
		return month;
	}

	public static List<String> getMonthsBetween(Date startDate, Date endDate) {
		List<String> monthList = new ArrayList<String>();
		LocalDate startDatelocalDate = new java.sql.Date(startDate.getTime()).toLocalDate();
		LocalDate endDatelocalDate = new java.sql.Date(endDate.getTime()).toLocalDate();
		if (startDatelocalDate.getYear() == endDatelocalDate.getYear()) {
			Integer startMonth = startDatelocalDate.getMonthValue();
			Integer endMonth = endDatelocalDate.getMonthValue();
			for (int i = startMonth; i <= endMonth; i++) {
				monthList.add(Month.of(i).name() + " " + startDatelocalDate.getYear());
			}
		} else {
			Integer startMonth = startDatelocalDate.getMonthValue();
			Integer endMonth = endDatelocalDate.getMonthValue();
			for (int i = startMonth; i <= 12; i++) {
				monthList.add(Month.of(i).name() + " " + startDatelocalDate.getYear());
			}
			for (int i = 1; i <= endMonth; i++) {
				monthList.add(Month.of(i).name() + " " + endDatelocalDate.getYear());
			}
		}
		return monthList;
	}

	public static String getMonthStr(Date date) {
		return new SimpleDateFormat("MMMM").format(date);
	}

	public static Date setMonth(Date date, int month) {
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int defaultmonth = localDate.getMonthValue();
		Integer diff = Math.abs(month - defaultmonth);
		Date finalDate = null;
		if (month >= defaultmonth) {
			finalDate = addMonth(date, diff);
		} else {
			finalDate = addMonth(date, -diff);
		}
		return finalDate;
	}

	public static Time getTime(Integer hour, Integer minutes) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, minutes);
		cal.set(Calendar.SECOND, 0);
		Date datetime = cal.getTime();
		return new Time(datetime.getTime());
	}

	public static Time addTime(Time time, Integer hour, Integer minutes) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTimeInMillis(time.getTime());
		calendar.add(Calendar.HOUR, hour);
		calendar.add(Calendar.MINUTE, minutes);
		Date datetime = calendar.getTime();
		return new Time(datetime.getTime());
	}

	public static boolean isDateBetweenTwoDates(Date min, Date date, Date max) {
		return date.after(min) && date.before(max);
	}

	public static boolean isFirstDayOrLastDayOfTheMonth(Date dateToday) {
		Calendar c = new GregorianCalendar();
		c.setTime(dateToday);
		int noOfLastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		if (c.get(Calendar.DAY_OF_MONTH) == 1 || c.get(Calendar.DAY_OF_MONTH) == noOfLastDay) {
			return true;
		}
		return false;
	}

	public static Date getDateDDMMYYYY(String date) {
		return DateUtil.toDateByAllFormat(date,"dd-MM-yyyy");
	}

	public static List<Date> getAllIntervalDates(Integer interval, Date startDate, Date endDate) {
		Long daysDiff = daysBetween(startDate, endDate);
		List<Date> dateList = new ArrayList<Date>();
		for (int i = 0; i < daysDiff; interval++) {
			Date d = addDays(startDate, i);
			dateList.add(d);
		}
		return dateList;
	}
}
