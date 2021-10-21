package org.r3.ws.system.siteproperty;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.Form;
import org.r3.system.rest.AccessLogInfo;
import org.r3.system.rest.RestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("{site}/{language}/properties")
public class WsSiteProperty  extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(WsSiteProperty.class);

	@GET
	@Produces({ "application/xml", "application/json" })
	public Response query(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest, 
		     @Context Request request,
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @Form SitePropertyQueryActionForm queryForm)
	{
		AccessLogInfo a = null;
		if (logger.isInfoEnabled())
		{
			a = this.accessLogInfo();	
		}		

		if (logger.isDebugEnabled())
		{

		}		

		GETSiteProperties bl = new GETSiteProperties(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), queryForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@POST
	@Path("{idpackage}")
	@Produces({ "application/xml", "application/json" })
	public Response updateProperties(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("idpackage") String aPackageId,
		     @MatrixParam("invalidatesite") Boolean invalidateSite,
		     MultivaluedMap<String, String> rawData
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

		
		SitePropertiesActionForm actionForm = new SitePropertiesActionForm(rawData);
		
		POSTSiteProperties bl = new POSTSiteProperties(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aPackageId, actionForm, invalidateSite != null ? invalidateSite.booleanValue() : false);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@POST
	@Path("{idpackage}/acquirefbpagetoken")
	@Produces({ "application/xml", "application/json" })
	public Response acquireFBToken(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("idpackage") String aPackageId,
		     @MatrixParam("invalidatesite") Boolean invalidateSite,
		     @Form FBAcquirePageTokenActionForm actionForm
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
			
		
		POSTAcquireFacebookToken bl = new POSTAcquireFacebookToken(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aPackageId, actionForm, invalidateSite != null ? invalidateSite.booleanValue() : false);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

}
