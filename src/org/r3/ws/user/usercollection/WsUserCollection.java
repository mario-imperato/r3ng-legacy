package org.r3.ws.user.usercollection;

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

@Path("{site}/{language}/userscollection")
public class WsUserCollection extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(WsUserCollection.class);
		
	@GET
	@Produces({ "application/xml", "application/json" })
	public Response query(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @Form UserCollectionQueryActionForm actionForm
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

		GETSiteMembers bl = new GETSiteMembers(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), actionForm);
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
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aUserId
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

		GETUserCollectionDetail bl = new GETUserCollectionDetail(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aUserId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@PUT
	@Path("{id}/photo")
	@Consumes("multipart/form-data")
	public Response uploadProfilePhoto(
				     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
				     @Context Request request,
				     @Context HttpHeaders headers,
				     @PathParam("site") String aSite,
				     @PathParam("language") String aLanguage,
				     @PathParam("id") String aUserId,
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
		
		POSTUserCollectionPhotoUpload bl = new POSTUserCollectionPhotoUpload(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aUserId, input, aFilepartname, anAttachmentType, responseType);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("{id}/photo")
	@Produces({ "application/xml", "application/json" })
	public Response getUserPhoto(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aUserId,
		     @MatrixParam("photorole") String imageRole		     
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

		GETUserCollectionPhoto bl = new GETUserCollectionPhoto(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aUserId, imageRole);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@PUT
	@Path("{id}/address")
	@Consumes("application/x-www-form-urlencoded")
	public Response uploadProfileAddress(
				     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
				     @Context Request request,
				     @Context HttpHeaders headers,
				     @PathParam("site") String aSite,
				     @PathParam("language") String aLanguage,
				     @PathParam("id") String aUserId,
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

		PUTUserCollectionAddress bl = new PUTUserCollectionAddress(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aUserId, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@PUT
	@Path("{id}/businesscard")
	@Consumes("application/x-www-form-urlencoded")
	public Response updateBusinessCard(
				     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
				     @Context Request request,
				     @Context HttpHeaders headers,
				     @PathParam("site") String aSite,
				     @PathParam("language") String aLanguage,
				     @PathParam("id") String aUserId,
					 @Form BusinessCardActionForm actionForm) 
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

		PUTUserCollectionBusinessCard bl = new PUTUserCollectionBusinessCard(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aUserId, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@PUT
	@Path("{id}/likesite")
	@Consumes("multipart/form-data")
	public Response likeSite(
				     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
				     @Context Request request,
				     @Context HttpHeaders headers,
				     @PathParam("site") String aSite,
				     @PathParam("language") String aLanguage,
				     @PathParam("id") String aUserId,
					 @MatrixParam("likemode") Boolean likeMode) 
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

		AddSite2UserFavs_ bl = new AddSite2UserFavs_(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage));
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@PUT
	@Path("{id}/dislikesite")
	@Consumes("multipart/form-data")
	public Response dislikeSite(
				     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
				     @Context Request request,
				     @Context HttpHeaders headers,
				     @PathParam("site") String aSite,
				     @PathParam("language") String aLanguage,
				     @PathParam("id") String aUserId,
					 @MatrixParam("likemode") Boolean likeMode) 
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

		RemoveSiteFromUserFavs bl = new RemoveSiteFromUserFavs(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage));
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
}
