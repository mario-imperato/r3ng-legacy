package org.r3.ws.system.queue;


import javax.ws.rs.POST;
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

@Path("{site}/{language}/system/queues")
public class WsQueues extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(WsQueues.class);

	@POST
	@Path("{id}/process")
	@Produces({ "application/xml", "application/json" })
	public Response process(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request,
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String queueId
		     )
	{
		AccessLogInfo a = null;
		if (logger.isInfoEnabled())
		{
			a = this.accessLogInfo();	
		}		

		if (logger.isDebugEnabled())
		{
			a.pushParam("queueId", queueId);	
		}		

		ProcessQueue bl = new ProcessQueue(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), queueId);
		Response response = bl.process(request);
		
        if (a != null)
        {
            logger.info(a.close());	 
        }
		return response;
	}


}
