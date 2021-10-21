package org.r3.ws.test;

import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.ISODateTimeFormat;
import org.r3.system.util.JavaTimeUtils;

public class JodaTimeTest
{

	public JodaTimeTest()
	{
		// TODO Auto-generated constructor stub
	}
	
	public static void testElapsed()
	{
		Instant startOperation = Instant.now();
		
		try
		{
			Thread.currentThread().sleep(2000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		Instant stopOperation = Instant.now();

		System.out.println("Elapsed Time: " + JavaTimeUtils.getElapsedFrom(startOperation, stopOperation));
	}
	
	public static void testTimestamp()
	{
		LocalDate ld = LocalDate.now();
		System.out.println("LocalDate Is: " + ld);
		
		java.sql.Timestamp ts = JavaTimeUtils.timestampFromLocalDate(ld);
		
		LocalDate ld1 = JavaTimeUtils.timestampAsLocalDate(ts);
		System.out.println("LocalDate Through Timestamp: " + ld1);
		
		LocalDateTime ldt = LocalDateTime.now();
		ts = JavaTimeUtils.timestampFromLocalDateTime(ldt);
		
		LocalDateTime ldt1 = JavaTimeUtils.dateAsLocalDateTime(ts);
		System.out.println("LocalDateTime Through Timestamp: " + ldt1);						
	}
	
	public static void testEpoch()
	{
		LocalDate ld = LocalDate.now();
		System.out.println("LocalDate Is: " + ld);
		
		long d = JavaTimeUtils.toEpochDay(ld) + 2;
		
		ld = JavaTimeUtils.ofEpochDay(d);
		System.out.println("LocalDate Is: " + ld);		
	}
	
	public static void testFormat()
	{
		String basic = "20170401";
		
		LocalDate ld = JavaTimeUtils.parseLocalDate(basic, JavaTimeUtils.getDateTimeFormatter4(JavaTimeUtils.BASIC_ISO_DATE));
		System.out.println("Parsed LocalDate Is: " + ld + " from " + basic);
		
		String s1 = JavaTimeUtils.format(ld, JavaTimeUtils.getDateTimeFormatter4(JavaTimeUtils.ISO_LOCAL_DATE));
		System.out.println("LocalDate Formatted ISO_LOCAL_DATE: " + s1);
		
		ld = JavaTimeUtils.parseLocalDate(s1, JavaTimeUtils.getDateTimeFormatter4(JavaTimeUtils.ISO_LOCAL_DATE));
		System.out.println("Re-Parsed LocalDate Is: " + ld + " from " + s1);
		
		String s = JavaTimeUtils.format(ld.toLocalDateTime(LocalTime.MIDNIGHT).minusMinutes(12), JavaTimeUtils.getDateTimeFormatter4(JavaTimeUtils.ISO_LOCAL_DATE_TIME));
		System.out.println("LocalDate Formatted: " + s);	
		
		System.out.println("NEGDETTTTTT: " + ld.toString(DateTimeFormat.shortDate()));
		
//		DateTimeFormatter dft = ISODateTimeFormat.dateTime();
//		String s2 = dft.print(ld.toLocalDateTime(LocalTime.MIDNIGHT));		
//		s2 = dft.print(LocalDateTime.now());
//		LocalDateTime ldt1 = LocalDateTime.parse(s2, ISODateTimeFormat.localDateOptionalTimeParser());
		
		LocalDateTime ldt =  JavaTimeUtils.parseLocalDateTime(s, JavaTimeUtils.getDateTimeFormatter4(JavaTimeUtils.ISO_LOCAL_DATE_TIME));
		System.out.println("LocalDateTime Reparsed: " + ldt);	
		
		s = JavaTimeUtils.format(ld, JavaTimeUtils.getDateTimeFormatter4(JavaTimeUtils.ISO_DATE));
		System.out.println("LocalDateTime Formatted ISO_DATE: " + s);
	
		s = JavaTimeUtils.format(DateTime.now(), JavaTimeUtils.getDateTimeFormatter4(JavaTimeUtils.ISO_DATE_TIME));
		System.out.println("DateTime Formatted ISO_DATE_TIME: " + s);
		
		String j00_receipt = "2017-06-21T15:51:47";
		
		// JavaTimeUtils.getDateTimeFormatter4(JavaTimeUtils.ISO_DATE_TIME);

		ldt = JavaTimeUtils.parseLocalDateTime(j00_receipt,  ISODateTimeFormat.dateHourMinuteSecond());
		System.out.println("Parsed LocalDate Is: " + ldt + " from " + j00_receipt);
		
		String v00_receipt = "2017-06-26T10:53:54+02:00";
		DateTime dt = JavaTimeUtils.parseDateTime(v00_receipt,  ISODateTimeFormat.dateTimeNoMillis());
		System.out.println("Parsed LocalDate Is: " + dt + " from " + v00_receipt);				
	}
	
	public static void main(String[] args)
	{		
		System.out.println("Now As FileNameFragment Is: " + JavaTimeUtils.fileNameTimestampFragment());		
		
		testElapsed();
		testTimestamp();
		testEpoch();
		testFormat();
		
		// GregorianCalendarFrom
		
		
	}

}
