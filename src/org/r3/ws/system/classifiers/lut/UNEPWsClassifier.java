package org.r3.ws.system.classifiers.lut;

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

@Path("{site}/{language}/lut/classifiers")
public class UNEPWsClassifier  extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(UNEPWsClassifier.class);

	@GET
	@Produces({ "application/xml", "application/json" })
	public Response getClassifiers(
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
		    logger.info(a.start());

		}		

		ConditionallyGETClassifiers bl = new ConditionallyGETClassifiers(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage));
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }

	    return response;
	}

	@GET
	@Path("{clsid}/items")
	@Produces({ "application/xml", "application/json" })
	public Response getClassifier(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest, 
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("clsid") String aClassifierId,
		     @MatrixParam("sattr") String sattr,
		     @MatrixParam("depth") Integer depth)
	{
		AccessLogInfo a = null;
		if (logger.isInfoEnabled())
		{
			a = this.accessLogInfo();	
		}		

		if (logger.isDebugEnabled())
		{
		    logger.info(a.start());

		}		

		ConditionallyGETClassifierItems bl = new ConditionallyGETClassifierItems(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aClassifierId, depth, sattr);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@GET
	@Path("{clsid}/items/{itemId}/children")
	@Produces({ "application/xml", "application/json" })
	public Response getClassifierItemChildren(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest, 
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("clsid") String aClassifierId,
		     @PathParam("itemId") String aClassifierItemId)
	{
		AccessLogInfo a = null;
		if (logger.isInfoEnabled())
		{
			a = this.accessLogInfo();	
		}		

		if (logger.isDebugEnabled())
		{
		    logger.info(a.start());

		}		

		ConditionallyGETClassifierItems bl = new ConditionallyGETClassifierItems(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aClassifierId, aClassifierItemId, null, null);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}


}
