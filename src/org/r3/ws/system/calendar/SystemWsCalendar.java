package org.r3.ws.system.calendar;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import org.r3.db.system.calendarperiod.SystemCalendarPeriodDTO.PeriodType;
import org.r3.system.rest.AccessLogInfo;
import org.r3.system.rest.RestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("{site}/{language}/system/calendar")
public class SystemWsCalendar extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(SystemWsCalendar.class);

	@POST
	@Path("initialize")
	@Produces({ "application/xml", "application/json" })
	public Response process(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request,
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,		     
		     @MatrixParam("calendarid") String calendarId,
		     @MatrixParam("startdate") String eveStart,
		     @MatrixParam("startday") int eveStartDayNumber,
		     @MatrixParam("length") int calendarLength,
		     @MatrixParam("calperiod") Boolean computeCalendarPeriod
		     )
	{
		AccessLogInfo a = null;
		if (logger.isInfoEnabled())
		{
			a = this.accessLogInfo();	
		}		

		if (logger.isDebugEnabled())
		{
		    logger.info(a.start());

		}		
	
		boolean computeCalendarPeriodBool = false;
		if (computeCalendarPeriod != null)
			computeCalendarPeriodBool = computeCalendarPeriod.booleanValue();
			
		POSTCalendarInitialization bl = new POSTCalendarInitialization(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), calendarId, eveStart, eveStartDayNumber, calendarLength, computeCalendarPeriodBool);
		Response response = bl.process(request);
		if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("periods/{periodtype}")
	@Produces({ "application/xml", "application/json" })
	@Consumes("application/x-www-form-urlencoded")
	public Response getCalendarPeriod(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request,
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,		     
		     @PathParam("periodtype")  String aPeriodTypeStr,
		     @MatrixParam("startdate")  String startDate,
		     @MatrixParam("lutsize")  Integer lutSize,
		     @MatrixParam("offset")  Integer offsetFromNow
		     )
	{
		AccessLogInfo a = null;
		if (logger.isInfoEnabled())
		{
			a = this.accessLogInfo();	
		}		

		if (logger.isDebugEnabled())
		{
		    logger.info(a.start());

		}		
	
		GETLUTPeriodItems bl = new GETLUTPeriodItems(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), startDate, PeriodType.valueOf(aPeriodTypeStr), lutSize, offsetFromNow);
		Response response = bl.process(request);
		if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

}
