package org.r3.ws.sailevent.console;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.Form;
import org.r3.system.rest.AccessLogInfo;
import org.r3.system.rest.RestService;
import org.r3.ws.sailevent.appcrewmemberview.GETSailApplicationCrewReport;
import org.r3.ws.sailevent.appcrewmemberview.GETSailEventAthletesReport;
import org.r3.ws.sailevent.appcrewmemberview.GETSailEventCrewReport;
import org.r3.ws.sailevent.appcrewmemberview.SailApplicationCrewMemberViewQueryActionForm;
import org.r3.ws.sailevent.attendancesheetview.GETSailEventAttendanceSheetReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("{site}/{language}/sev/console")
public class WsSailEventConsole extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(WsSailEventConsole.class);

	@GET
	@Path("applications")
	@Produces({ "application/xml", "application/json" })
	public Response queryApplications(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @Form SailApplicationViewQueryActionForm queryForm
		     )
	{
		AccessLogInfo a = null;
		if (logger.isInfoEnabled())
		{
			a = this.accessLogInfo();	
		}		

		if (logger.isDebugEnabled())
		{

		}		

		GETSailApplications bl = new GETSailApplications(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), queryForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("applications/eventlog")
	@Produces({ "application/xml", "application/json" })
	public Response queryApplicationsEventLog(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @Form SailApplicationEventLogViewQueryActionForm queryForm
		     )
	{
		AccessLogInfo a = null;
		if (logger.isInfoEnabled())
		{
			a = this.accessLogInfo();	
		}		

		if (logger.isDebugEnabled())
		{

		}		

		GETSailApplicationsEventLogView bl = new GETSailApplicationsEventLogView(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), queryForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@POST
	@Path("applications/checkcrew")
	@Produces({ "application/xml", "application/json" })
	public Response postFleetFIVCardsVerification(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @Form SailEventFIVVerificationActionForm actionForm
		     )
	{
		AccessLogInfo a = null;
		if (logger.isInfoEnabled())
		{
			a = this.accessLogInfo();	
		}		

		if (logger.isDebugEnabled())
		{

		}		

		POSTSailEventFIVCardVerification bl = new POSTSailEventFIVCardVerification(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), null, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@POST
	@Path("applications/{idapp}/checkcrew")
	@Produces({ "application/xml", "application/json" })
	public Response postFIVCardsVerification(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("idapp") String anApplicationid,
		     @Form SailEventFIVVerificationActionForm actionForm
		     )
	{
		AccessLogInfo a = null;
		if (logger.isInfoEnabled())
		{
			a = this.accessLogInfo();	
		}		

		if (logger.isDebugEnabled())
		{

		}		

		POSTSailEventFIVCardVerification bl = new POSTSailEventFIVCardVerification(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anApplicationid, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@POST
	@Path("applications/{idapp}/clone")
	@Produces({ "application/xml", "application/json" })
	public Response postCloneApplication(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("idapp") String anApplicationid,
		     @Form SailEventCloneApplicationActionForm actionForm
		     )
	{
		AccessLogInfo a = null;
		if (logger.isInfoEnabled())
		{
			a = this.accessLogInfo();	
		}		

		if (logger.isDebugEnabled())
		{

		}		

		POSTSailEventApplicationClone bl = new POSTSailEventApplicationClone(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anApplicationid, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("applications/{idapp}/crewreport")
	@Produces({ "application/xml", "application/json" })
	public Response crewReport(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("idapp") String anApplicationid,
		     @Form SailApplicationCrewMemberViewQueryActionForm actionForm
		     )
	{
		AccessLogInfo a = null;
		if (logger.isInfoEnabled())
		{
			a = this.accessLogInfo();	
		}		

		if (logger.isDebugEnabled())
		{

		}		

		GETSailApplicationCrewReport bl = new GETSailApplicationCrewReport(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anApplicationid, actionForm, true);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("applications/crewreport")
	@Produces({ "application/xml", "application/json" })
	public Response fleetCrewReport(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage
		     )
	{
		AccessLogInfo a = null;
		if (logger.isInfoEnabled())
		{
			a = this.accessLogInfo();	
		}		

		if (logger.isDebugEnabled())
		{

		}		

		GETSailEventCrewReport bl = new GETSailEventCrewReport(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage));
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@GET
	@Path("applications/athletesreport.slk")
	@Produces({ "text/csv" })	
	public Response crewReport(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage
		     )
	{
		AccessLogInfo a = null;
		if (logger.isInfoEnabled())
		{
			a = this.accessLogInfo();	
		}		

		if (logger.isDebugEnabled())
		{

		}		

		GETSailEventAthletesReport bl = new GETSailEventAthletesReport(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), OutputFormat.sylk);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@GET
	@Path("applications/attendancesheetreport.slk")
	@Produces({ "text/csv" })	
	public Response attendanceSheet(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage
		     )
	{
		AccessLogInfo a = null;
		if (logger.isInfoEnabled())
		{
			a = this.accessLogInfo();	
		}		

		if (logger.isDebugEnabled())
		{

		}		

		GETSailEventAttendanceSheetReport bl = new GETSailEventAttendanceSheetReport(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), OutputFormat.sylk);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
}
