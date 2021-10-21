package org.r3.ws.system.agenda;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("{site}/{language}/agenda")
public class WsAgenda extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(WsAgenda.class);
  
	public enum EventFormat { datatable, eventarray };
	public enum CalendarUpdateAction { 
		
		move, resize, update; 
		
	    public static CalendarUpdateAction getValue(String s, CalendarUpdateAction defaultValue)
	    {
	    	if (s == null)
	    		return defaultValue;
	    	
	    	return valueOf(s);
	    }
	};
	
	
	@GET
	@Path("{agendaid}")
	@Produces({ "application/xml", "application/json" })
	public Response query(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("agendaid") String anAgendaId,
		     @Form AgendaQueryActionForm queryForm		     
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

		GETAgendaEntries bl = new GETAgendaEntries(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anAgendaId, queryForm, EventFormat.datatable);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("{agendaid}/asCalendarEvents")
	@Produces({ "application/xml", "application/json" })
	public Response queryAsCalendarEvents(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("agendaid") String anAgendaId,		     
		     @Form AgendaQueryActionForm queryForm
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

		GETAgendaEntries bl = new GETAgendaEntries(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anAgendaId, queryForm, EventFormat.eventarray);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

//	@GET
//	@Path("{id}")
//	@Produces({ "application/xml", "application/json" })
//	public Response detail(
//		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
//		     @Context Request request, 
//		     @Context HttpHeaders headers,
//		     @PathParam("site") String aSite,
//		     @PathParam("language") String aLanguage,
//		     @PathParam("id") String anActorId
//		     )
//	{
//		AccessLogInfo a = null;
//		if (logger.isInfoEnabled())
//		{
//			a = this.accessLogInfo();	
//		}		
//
//		if (logger.isDebugEnabled())
//		{
//
//		}		
//
//		GETActorDetail bl = new GETActorDetail(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anActorId);
//		Response response = bl.process(request);
//	    if (a != null)
//	    {
//	       logger.info(a.close());	 
//	    }
//		return response;
//	}
//
	@POST
	@Path("{agendaid}")
	@Produces({ "application/xml", "application/json" })
	@Consumes("application/x-www-form-urlencoded")
	public Response create(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("agendaid") String anAgendaId,
		     @Form AgendaActionForm actionForm
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

		POSTAgendaEntry bl = new POSTAgendaEntry(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anAgendaId, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@PUT
	@Path("{agendaid}/{id}")
	@Produces({ "application/xml", "application/json" })
	@Consumes("application/x-www-form-urlencoded")
	public Response update(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("agendaid") String anAgendaId,		     
		     @PathParam("id") String aCalendarId,
		     @MatrixParam("action") String updateAction,
		     @Form AgendaActionForm actionForm
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

		
		PUTAgendaEntry bl = new PUTAgendaEntry(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anAgendaId, aCalendarId, actionForm, CalendarUpdateAction.getValue(updateAction, CalendarUpdateAction.update));
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@DELETE
	@Path("{agendaid}/{id}")
	@Produces({ "application/xml", "application/json" })
	public Response delete(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("agendaid") String anAgendaId,		     
		     @PathParam("id") String aCalendarId
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

		DELETEAgendaEntry bl = new DELETEAgendaEntry(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, anAgendaId, aCalendarId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

}
