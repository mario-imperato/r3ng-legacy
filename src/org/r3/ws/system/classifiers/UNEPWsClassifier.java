package org.r3.ws.system.classifiers;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
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

@Path("{site}/{language}/system/classifiers")
public class UNEPWsClassifier  extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(UNEPWsClassifier.class);

	@GET
	@Path("{clsid}")
	@Produces({ "application/xml", "application/json" })
	public Response getClassifierDetail(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest, 
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("clsid") String aClassifierId
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

		GETClassifierDetail bl = new GETClassifierDetail(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aClassifierId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@PUT
	@Path("{clsid}")
	@Produces({ "application/xml", "application/json" })
	public Response updateClassifierInfo(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest, 
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("clsid") String aClassifierId,
		     @Form ClassifierActionForm actionForm
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

		PUTClassifier bl = new PUTClassifier(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aClassifierId, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@GET
	@Path("{clsid}/clsitems")
	@Produces({ "application/xml", "application/json" })
	public Response queryItems(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest, 
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("clsid") String aClassifierId,
		     @Form ClassifierItemQueryActionForm queryActionForm)
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

		GETClassifierItems bl = new GETClassifierItems(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aClassifierId, queryActionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@POST
	@Path("{clsid}/clsitems")
	@Produces({ "application/xml", "application/json" })
	public Response createItem(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest, 
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("clsid") String aClassifierId,
		     @Form ClassifierItemActionForm actionForm)
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

		POSTClassifierItem bl = new POSTClassifierItem(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aClassifierId, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@DELETE
	@Path("{clsid}/clsitems/{clsitemid}")
	@Produces({ "application/xml", "application/json" })
	public Response deleteItem(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest, 
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("clsid") String aClassifierId,
		     @PathParam("clsitemid") String aClassifierItemId
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

		DELETEClassifierItem bl = new DELETEClassifierItem(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aClassifierId, aClassifierItemId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@PUT
	@Path("{clsid}/clsitems/{clsitemid}")
	@Produces({ "application/xml", "application/json" })
	public Response updateItem(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest, 
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("clsid") String aClassifierId,
		     @PathParam("clsitemid") String aClassifierItemId,
		     @Form ClassifierItemActionForm actionForm
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

		PUTClassifierItem bl = new PUTClassifierItem(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aClassifierId, aClassifierItemId, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("{clsid}/clsitems/{clsitemid}")
	@Produces({ "application/xml", "application/json" })
	public Response getItemDetail(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest, 
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("clsid") String aClassifierId,
		     @PathParam("clsitemid") String aClassifierItemId
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

		GETClassifierItemDetail bl = new GETClassifierItemDetail(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aClassifierId, aClassifierItemId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

}
