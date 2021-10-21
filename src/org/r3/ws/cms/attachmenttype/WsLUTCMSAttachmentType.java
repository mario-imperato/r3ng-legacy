package org.r3.ws.cms.attachmenttype;


import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import org.r3.db.cms.attachmenttype.AttachmentTypeDTO.AttachScope;
import org.r3.system.rest.AccessLogInfo;
import org.r3.system.rest.RestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("{site}/{language}/cms/lut/attachtype")
public class WsLUTCMSAttachmentType  extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(WsLUTCMSAttachmentType.class);

	@GET
	@Produces({ "application/xml", "application/json" })
	public Response getUnfilteredAttachments(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest, 
		     @Context Request request,
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @MatrixParam("scope") String attachmentScope
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

		GETCMSAttachmentTypeLUTItems bl = new GETCMSAttachmentTypeLUTItems(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), attachmentScope);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("card_scope")
	@Produces({ "application/xml", "application/json" })
	public Response getDefaultAttachments(
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

		GETCMSAttachmentTypeLUTItems bl = new GETCMSAttachmentTypeLUTItems(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), AttachScope.card_scope.toString());
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("site_scope")
	@Produces({ "application/xml", "application/json" })
	public Response getSiteAttachments(
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

		GETCMSAttachmentTypeLUTItems bl = new GETCMSAttachmentTypeLUTItems(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), AttachScope.site_scope.toString());
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}


}
