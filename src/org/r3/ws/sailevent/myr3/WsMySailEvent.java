package org.r3.ws.sailevent.myr3;

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
import org.r3.system.rest.ServiceEnvironment;
import org.r3.ws.sailevent.application.GETSailApplicationDetail;
import org.r3.ws.sailevent.application.GETSailApplications;
import org.r3.ws.sailevent.application.POSTSailApplication;
import org.r3.ws.sailevent.application.SailApplicationQueryActionForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("{site}/{language}/sev/my_applications")
public class WsMySailEvent extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(WsMySailEvent.class);

	@GET
	@Produces({ "application/xml", "application/json" })
	public Response query(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @Form SailApplicationQueryActionForm queryForm
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

		ServiceEnvironment senv = getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage);
		
		queryForm.setUserid(senv.getUserProfile().getUserid());
		GETSailApplications bl = new GETSailApplications(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), queryForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	
	@GET
	@Path("{id}")
	@Produces({ "application/xml", "application/json" })
	public Response detail(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String anApplicationId
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

		GETSailApplicationDetail bl = new GETSailApplicationDetail(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anApplicationId, true);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@POST
	@Produces({ "application/xml", "application/json" })
	public Response createEmpty(
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
		
		POSTSailApplication bl = new POSTSailApplication(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), null);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
}
