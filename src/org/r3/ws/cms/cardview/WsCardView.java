package org.r3.ws.cms.cardview;


import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
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

@Path("{site}/{language}/cms/cardviews")
public class WsCardView extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(WsCardView.class);

	@GET
	@Produces({ "application/xml", "application/json" })
	public Response cardViewQuery(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @Form CardViewQueryActionForm queryForm,
		     @MatrixParam("mode") String viewMode
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

		boolean boolViewMode = false;
		if (viewMode != null && viewMode.equalsIgnoreCase("full"))
		{
			boolViewMode = true;
		}
		
		GETCardsView bl = new GETCardsView(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, aLanguage, queryForm, boolViewMode);
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
	public Response cardViewDetail(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aCardId,
		     @MatrixParam("mode") String viewMode
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

		boolean boolViewMode = false;
		if (viewMode != null && viewMode.equalsIgnoreCase("full"))
		{
			boolViewMode = true;
		}
		
		GETCardViewDetail bl = new GETCardViewDetail(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, aLanguage, aCardId, boolViewMode);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

}
