package org.r3.ws.system.siteconfig;

import javax.ws.rs.GET;
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

@Path("{site}/{language}/siteconfig")
public class WsSiteConfig extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(WsSiteConfig.class);

	@GET
	@Path("portlets/{pageid}/positions")
	@Produces({ "application/xml", "application/json" })
	public Response queryPositions(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("pageid") String aPageId
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

		GETSitePortletConfig bl = new GETSitePortletConfig(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aPageId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@PUT
	@Path("portlets/{pageid}/positions/{positionid}")
	@Produces({ "application/xml", "application/json" })
	public Response updatePagePosition(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("pageid") String aPageId,
		     @PathParam("positionid") String aPositionId,
		     @Form PortletConfigActionForm actionForm
		     
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

		PUTPortletConfig bl = new PUTPortletConfig(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aPageId, aPositionId, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
}
