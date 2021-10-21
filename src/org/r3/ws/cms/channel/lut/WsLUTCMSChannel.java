package org.r3.ws.cms.channel.lut;


import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import org.r3.system.rest.AccessLogInfo;
import org.r3.system.rest.RestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("{site}/{language}/cms/lut/channels")
public class WsLUTCMSChannel  extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(WsLUTCMSChannel.class);

	@GET
	@Produces({ "application/xml", "application/json" })
	public Response getCentroEsiti(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest, 
		     @Context Request request,
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @MatrixParam("mode") String lutmode
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
		
		GETCMSChannelLUTItems bl = new GETCMSChannelLUTItems(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), lutmode);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
		
}
