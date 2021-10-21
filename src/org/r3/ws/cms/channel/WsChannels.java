package org.r3.ws.cms.channel;

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

@Path("{site}/{language}/cms/channels")
public class WsChannels extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(WsChannels.class);

	@GET
	@Path("cards")
	@Produces({ "application/xml", "application/json" })
	public Response query(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @Form CardChannelQueryActionForm queryForm
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

		GETCardChannel bl = new GETCardChannel(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), queryForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@PUT
	@Path("cards")
	@Produces({ "application/xml", "application/json" })
	public Response deleteSelectedCardChannels(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @Form ChannelActionForm queryForm
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

		DELETECollectionCardChannel bl = new DELETECollectionCardChannel(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), queryForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
}
