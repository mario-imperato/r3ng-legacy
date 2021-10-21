package org.r3.ws.sailevent.sailevent.lut;


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

@Path("{site}/{language}/lut/sailevent")
public class WsLUTSailEvent  extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(WsLUTSailEvent.class);

	@GET
	@Produces({ "application/xml", "application/json" })
	public Response getCentroEsiti(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest, 
		     @Context Request request,
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @MatrixParam("eventgroup") String  eventgroup
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

		GETSailEventLUTItems bl = new GETSailEventLUTItems(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), eventgroup);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
		
}
