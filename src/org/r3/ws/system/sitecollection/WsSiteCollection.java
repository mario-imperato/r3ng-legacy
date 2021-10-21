package org.r3.ws.system.sitecollection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.Form;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.r3.system.rest.AccessLogInfo;
import org.r3.system.rest.RestService;
import org.r3.ws.mongocms.filecollection.FileUpload_POST.ResponseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("{site}/{language}/sitecollection")
public class WsSiteCollection extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(WsSiteCollection.class);

	@GET
	@Produces({ "application/xml", "application/json" })
	public Response query(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aContextSite,
		     @PathParam("language") String aLanguage,
		     @Form SiteCollectionQueryActionForm actionForm
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

		GETSiteCollections bl = new GETSiteCollections(ctx, getServiceEnvironment(ctx, servletRequest, headers, aContextSite, aLanguage), actionForm);
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
	public Response detail(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aContextSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aSite
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

		GETSiteCollectionDetail bl = new GETSiteCollectionDetail(ctx, getServiceEnvironment(ctx, servletRequest, headers, aContextSite, aLanguage), aSite);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@PUT
	@Path("{thesite}/address")
	@Consumes("application/x-www-form-urlencoded")
	public Response uploadProfileAddress(
				     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
				     @Context Request request,
				     @Context HttpHeaders headers,
				     @PathParam("site") String currentSite,
				     @PathParam("language") String aLanguage,
				     @PathParam("thesite") String aSite,
					 @Form AddressActionForm actionForm) 
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

		PUTSiteCollectionAddress bl = new PUTSiteCollectionAddress(ctx, getServiceEnvironment(ctx, servletRequest, headers, currentSite, aLanguage), aSite, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@PUT
	@Path("{thesite}/info")
	@Consumes("application/x-www-form-urlencoded")
	public Response uploadProfileInformation(
				     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
				     @Context Request request,
				     @Context HttpHeaders headers,
				     @PathParam("site") String currentSite,
				     @PathParam("language") String aLanguage,
				     @PathParam("thesite") String aSite,
					 @Form SiteInfoActionForm actionForm) 
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

		PUTSiteCollectionGeneralInfo bl = new PUTSiteCollectionGeneralInfo(ctx, getServiceEnvironment(ctx, servletRequest, headers, currentSite, aLanguage), aSite, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@PUT
	@Path("{thesite}/graphics")
	@Consumes("multipart/form-data")
	public Response uploadProfilePhoto(
				     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
				     @Context Request request,
				     @Context HttpHeaders headers,
				     @PathParam("site") String aSite,
				     @PathParam("language") String aLanguage,
				     @PathParam("thesite") String theSite,
				     @MatrixParam("responsetype") String aResponseType,
				     @MatrixParam("filepartname") String aFilepartname,
				     @MatrixParam("attachmenttype") String anAttachmentType,				     
					 MultipartFormDataInput input) 
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

		if (aFilepartname == null)
			aFilepartname = "file";
				
		ResponseType responseType = ResponseType.getValue4(aResponseType, ResponseType.array_of_persistedfiles);
		
		POSTSiteCollectionGraphicUpload bl = new POSTSiteCollectionGraphicUpload(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), theSite, input, aFilepartname, anAttachmentType, responseType);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}	
	
	@GET
	@Path("{thesite}/graphics/{graphictype}")
	public Response getGraphicByType(
				     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
				     @Context Request request,
				     @Context HttpHeaders headers,
				     @PathParam("site") String aSite,
				     @PathParam("language") String aLanguage,
				     @PathParam("thesite") String theSite,
				     @PathParam("graphictype") String aGraphicType,
				     @MatrixParam("imagerole") String anImageRole) 
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

		GETSiteCollectionGraphic bl = new GETSiteCollectionGraphic(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), theSite, anImageRole, aGraphicType);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}	
}
