package org.r3.system.util;

import java.sql.Timestamp;
import java.util.GregorianCalendar;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Duration;
import org.joda.time.Instant;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.base.BaseDateTime;
import org.joda.time.base.BaseLocal;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.ISODateTimeFormat;

public class JavaTimeUtils
{
	private static DateTimeFormatter filename_formatter = JavaTimeUtils.forPattern("yyyyMMdd_HHmmss");
	private static LocalDateTime epochDateTime = new LocalDateTime(0);
	private static LocalDate epochDate 			= new LocalDate(0);
	
	public static final String BASIC_ISO_DATE = "BASIC_ISO_DATE";
	public static final String ISO_LOCAL_DATE = "ISO_LOCAL_DATE";
	public static final String ISO_LOCAL_DATE_TIME = "ISO_LOCAL_DATE_TIME";
	public static final String ISO_DATE = "ISO_DATE";
	public static final String ISO_DATE_TIME = "ISO_DATE_TIME";
	
	private static final DateTimeFormatter isoLocalTime;
	
	static
	{
		isoLocalTime = new DateTimeFormatterBuilder()
				.appendYear(4, 9)
				.appendLiteral('-').appendMonthOfYear(2)
				.appendLiteral('-').appendDayOfMonth(2)
				.appendLiteral('T') .appendHourOfDay(2)
				.appendLiteral(':').appendMinuteOfHour(2)
				.appendLiteral(':').appendSecondOfMinute(2).appendLiteral('.')
                .appendFractionOfSecond(3, 9)
                .toFormatter();
	}
	
	public JavaTimeUtils()
	{

	}

	// JDK8 Version
	// if (aTs != null)
	// return aTs.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	public static LocalDate timestampAsLocalDate(java.sql.Timestamp aTs)
	{
		if (aTs != null)
			return new LocalDate(aTs);

		return null;
	}

	// JDK8 Version
	// if (aTs != null)
	// return aTs.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	public static LocalDateTime dateAsLocalDateTime(java.util.Date aTs)
	{
		if (aTs != null)
			return new LocalDateTime(aTs);

		return null;
	}
	
	public static long getElapsedFrom(Instant a, Instant b)
	{
		// Duration timeElapsed = Duration.between(startOperation,
		// stopOperation);
		// return timeElapsed.toMillis();

		Duration timeElapsed = new Duration(a, b);
		return timeElapsed.getMillis();
	}

	public static java.sql.Timestamp timestampFromLocalDate(LocalDate aLocalDate)
	{
		if (aLocalDate != null)
		{
			// return java.sql.Timestamp.valueOf(dt.atStartOfDay())
			return new Timestamp(aLocalDate.toDateTimeAtStartOfDay().getMillis());
		}

		return null;
	}

	public static java.sql.Timestamp timestampFromLocalDateTime(LocalDateTime aLocalDate)
	{
		if (aLocalDate != null)
		{
			// return Timestamp.valueOf(aLocalDate);
			return new Timestamp(aLocalDate.toDateTime().getMillis());
		}

		return null;
	}

	
	private static DateTimeFormatter forPattern(String aPattern)
	{
		return DateTimeFormat.forPattern(aPattern); // DateTimeFormatter.ofPattern("dd/MM/yyyy");
	}

	public static String format(BaseLocal aLocalDate, DateTimeFormatter fmt)
	{
		// jdk8: aLocalDate.format(fmt)
		if (aLocalDate != null)
			return fmt.print(aLocalDate);

		return null;
	}

	public static String format(BaseDateTime aDate, DateTimeFormatter fmt)
	{
		// jdk8: aLocalDate.format(fmt)
		if (aDate != null)
			return fmt.print(aDate);

		return null;
	}
	
	public static String format(BaseLocal aLocalDate, String fmts)
	{
		// jdk8: aLocalDate.format(fmt)
		if (aLocalDate != null)
		{
			DateTimeFormatter fmt = getDateTimeFormatter4(fmts);
			return fmt.print(aLocalDate);
		}

		return null;
	}
	
	public static LocalDate parseLocalDate(String aStringDate, DateTimeFormatter fmt)
	{
		// JDK8: LocalDate.parse(pkg.getReceiptDate(),
		// CPXDefinitions.ddMMyyyy_formatter);
		if (aStringDate != null)
			return fmt.parseLocalDate(aStringDate);

		return null;
	}
	
	public static LocalDateTime parseLocalDateTime(String aStringDate, DateTimeFormatter fmt)
	{
		// JDK8: LocalDateTime.parse(aDate, DateTimeFormatter.ISO_DATE_TIME);
		if (aStringDate != null)
			return fmt.parseLocalDateTime(aStringDate);

		return null;
	}
	
	public static LocalDateTime parseLocalDateTime(String aStringDate, String fmtStr)
	{
		// JDK8: LocalDateTime.parse(aDate, DateTimeFormatter.ISO_DATE_TIME);
		if (aStringDate != null)
		{
			DateTimeFormatter fmt = getDateTimeFormatter4(fmtStr);
			return fmt.parseLocalDateTime(aStringDate);
		}
		
		return null;
	}
	
	public static DateTime parseDateTime(String aStringDate, DateTimeFormatter fmt)
	{
		// JDK8: LocalDateTime.parse(aDate, DateTimeFormatter.ISO_DATE_TIME);
		if (aStringDate != null)
			return fmt.parseDateTime(aStringDate);

		return null;
	}
	
	/*
	 * JDK8 public static java.time.format.DateTimeFormatter
	 * getDateTimeFormatter4(String aFormat_or_formatName) {
	 * java.time.format.DateTimeFormatter df = null;
	 * 
	 * switch(aFormat_or_formatName) { case "BASIC_ISO_DATE": df =
	 * java.time.format.DateTimeFormatter.BASIC_ISO_DATE; break; case
	 * "ISO_LOCAL_DATE": df = java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;
	 * break; case "ISO_OFFSET_DATE": df =
	 * java.time.format.DateTimeFormatter.ISO_OFFSET_DATE; break; case
	 * "ISO_DATE": df = java.time.format.DateTimeFormatter.ISO_DATE; break; case
	 * "ISO_LOCAL_TIME": df = java.time.format.DateTimeFormatter.ISO_LOCAL_TIME;
	 * break; case "ISO_OFFSET_TIME": df =
	 * java.time.format.DateTimeFormatter.ISO_OFFSET_TIME; break; case
	 * "ISO_TIME": df = java.time.format.DateTimeFormatter.ISO_TIME; break; case
	 * "ISO_LOCAL_DATE_TIME": df =
	 * java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME; break; case
	 * "ISO_OFFSET_DATE_TIME": df =
	 * java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME; break; case
	 * "ISO_ZONED_DATE_TIME": df =
	 * java.time.format.DateTimeFormatter.ISO_ZONED_DATE_TIME; break; case
	 * "ISO_DATE_TIME": df = java.time.format.DateTimeFormatter.ISO_DATE_TIME;
	 * break; case "ISO_ORDINAL_DATE": df =
	 * java.time.format.DateTimeFormatter.ISO_ORDINAL_DATE; break; case
	 * "ISO_WEEK_DATE": df = java.time.format.DateTimeFormatter.ISO_WEEK_DATE;
	 * break; case "ISO_INSTANT": df =
	 * java.time.format.DateTimeFormatter.ISO_INSTANT; break; case
	 * "RFC_1123_DATE_TIME": df =
	 * java.time.format.DateTimeFormatter.RFC_1123_DATE_TIME; break; default: df
	 * = DateTimeFormatter.ofPattern(aFormat_or_formatName); }
	 * 
	 * return df;
	 * 
	 * }
	 */

	public static DateTimeFormatter getDateTimeFormatter4(String aFormat_or_formatName)
	{
		DateTimeFormatter df = null;

		if (aFormat_or_formatName.equalsIgnoreCase(BASIC_ISO_DATE))
		{
			df = ISODateTimeFormat.basicDate();
		}
		else if (aFormat_or_formatName.equalsIgnoreCase(ISO_LOCAL_DATE))
		{
			df = ISODateTimeFormat.date();
		}
		else if (aFormat_or_formatName.equalsIgnoreCase(ISO_LOCAL_DATE_TIME))
		{
			df = isoLocalTime; // ISODateTimeFormat.dateTime();
		}
		else if (aFormat_or_formatName.equalsIgnoreCase(ISO_DATE_TIME))
		{
			df = ISODateTimeFormat.dateTime();
		}
		else if (aFormat_or_formatName.equalsIgnoreCase(ISO_DATE))
		{
			df = ISODateTimeFormat.date();
		}
		else
		{
			df = forPattern(aFormat_or_formatName);
		}

		return df;

	}

	public static int toEpochDay(LocalDate aLocalDate)
	{
		// JDK8: aLocalDate.toEpochDay();
		Days days1 = Days.daysBetween(epochDate, aLocalDate);
		return days1.getDays();
	}

	public static LocalDate ofEpochDay(long aLocalDate)
	{
		// JDK8: aLocalDate.toEpochDay();
		LocalDate days1 = epochDate.plusDays((int)aLocalDate);
		return days1;
	}

	public static String fileNameTimestampFragment()
	{
		// JDK8: LocalDateTime.now().format(filename_formatter)
		return filename_formatter.print(new LocalDateTime());
	}
	
	public static GregorianCalendar GregorianCalendarFrom(LocalDate ld)
	{
		// JDK8: GregorianCalendar.from(ld.atStartOfDay(ZoneId.systemDefault()))
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(ld.toDate());
		
		return c;
	}
}
