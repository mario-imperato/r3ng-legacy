package org.r3.ws.mongocms.filecollection;


import javax.ws.rs.Consumes;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.r3.db.mongo.filecollection.FileCollectionDTO.FileStatus;
import org.r3.system.rest.AccessLogInfo;
import org.r3.system.rest.RestService;
import org.r3.ws.mongocms.filecollection.FileUpload_POST.ResponseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("{site}/{language}/cms/files")
public class WsFileCollection extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(WsFileCollection.class);
	
	@POST	
	@Consumes("multipart/form-data")
	public Response uploadPhoto(
				     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
				     @Context Request request,
				     @Context HttpHeaders headers,
				     @PathParam("site") String aSite,
				     @PathParam("language") String aLanguage,
				     @MatrixParam("entityid") String aMainEntityId,
				     @MatrixParam("ambitid") String anAmbitid,
				     @MatrixParam("subambitid") String aSubAmbitid,
				     @MatrixParam("filestatus") String aFileStatus,
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
			aFilepartname = "files[]";
				
		ResponseType responseType = ResponseType.getValue4(aResponseType, ResponseType.mongoimage_fileattachment);
		FileStatus fileStatus = FileStatus.getValue4(aFileStatus, FileStatus.pending);
		FileUpload_POST bl = new FileUpload_POST(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), fileStatus, aMainEntityId, anAmbitid, aSubAmbitid, input, aFilepartname, anAttachmentType, responseType);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
//	@POST
//	@Path("{id}/fileattachments")
//	@Consumes("multipart/form-data")
//	public Response uploadFile(
//				     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
//				     @Context Request request,
//				     @Context HttpHeaders headers,
//				     @PathParam("site") String aSite,
//				     @PathParam("language") String aLanguage,
//				     @PathParam("id") String aPostId,
//				     @MatrixParam("responsetype") String aResponseType,
//				     @PathParam("filepartname") String aFilepartname,
//				     @PathParam("attachmenttype") String anAttachmentType,
//					 MultipartFormDataInput input) 
//	{
//		AccessLogInfo a = null;
//		if (logger.isInfoEnabled())
//		{
//			a = this.accessLogInfo();	
//		}		
//
//		if (logger.isDebugEnabled())
//		{
//		    logger.info(a.start());
//		}		
//
//		if (aFilepartname == null)
//			aFilepartname = "files[]";
//		
//		ResponseType rt = ResponseType.getValue4(aResponseType, ResponseType.uploaded_file);
//		
//		PostFileAttachmentUpload_POST bl = new PostFileAttachmentUpload_POST(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aPostId, input, aFilepartname, anAttachmentType, rt);
//		Response response = bl.process(request);
//	    if (a != null)
//	    {
//	       logger.info(a.close());	 
//	    }
//		return response;
//	}
//	
//	@GET
//	@Path("{id}/links")
//	@Produces({ "application/xml", "application/json" })
//	public Response links(
//		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
//		     @Context Request request, 
//		     @Context HttpHeaders headers,
//		     @PathParam("site") String aSite,
//		     @PathParam("language") String aLanguage,
//		     @PathParam("id") String aPostId,
//		     @Form DataTableQueryActionForm queryActionForm
//		     )
//	{
//		AccessLogInfo a = null;
//		if (logger.isInfoEnabled())
//		{
//			a = this.accessLogInfo();	
//		}		
//
//		if (logger.isDebugEnabled())
//		{
//
//		}		
//
//		GETPostLinks bl = new GETPostLinks(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, aPostId, queryActionForm);
//		Response response = bl.process(request);
//	    if (a != null)
//	    {
//	       logger.info(a.close());	 
//	    }
//		return response;
//	}
//	
//	@POST
//	@Path("{id}/links")
//	@Produces({ "application/xml", "application/json" })
//	public Response addLink(
//		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
//		     @Context Request request, 
//		     @Context HttpHeaders headers,
//		     @PathParam("site") String aSite,
//		     @PathParam("language") String aLanguage,
//		     @PathParam("id") String aPostId,		  
//		     @Form PostLink_ActionForm anActionForm
//		     )
//	{
//		AccessLogInfo a = null;
//		if (logger.isInfoEnabled())
//		{
//			a = this.accessLogInfo();	
//		}		
//
//		if (logger.isDebugEnabled())
//		{
//
//		}		
//
//		PostLink_POST bl = new PostLink_POST(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, aPostId, anActionForm);
//		Response response = bl.process(request);
//	    if (a != null)
//	    {
//	       logger.info(a.close());	 
//	    }
//		return response;
//	}
//	
//	@PUT
//	@Path("{id}/links/{fid}")
//	@Produces({ "application/xml", "application/json" })
//	public Response updateLink(
//		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
//		     @Context Request request, 
//		     @Context HttpHeaders headers,
//		     @PathParam("site") String aSite,
//		     @PathParam("language") String aLanguage,
//		     @PathParam("id") String aPostId,
//		     @PathParam("fid") String aLinkId,
//		     @Form PostLink_ActionForm anActionForm
//		     )
//	{
//		AccessLogInfo a = null;
//		if (logger.isInfoEnabled())
//		{
//			a = this.accessLogInfo();	
//		}		
//
//		if (logger.isDebugEnabled())
//		{
//
//		}		
//
//		PostLink_PUT bl = new PostLink_PUT(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, aPostId, aLinkId, anActionForm);
//		Response response = bl.process(request);
//	    if (a != null)
//	    {
//	       logger.info(a.close());	 
//	    }
//		return response;
//	}
//
//	@DELETE
//	@Path("{id}/links/{fid}")
//	@Produces({ "application/xml", "application/json" })
//	public Response deleteLink(
//		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
//		     @Context Request request, 
//		     @Context HttpHeaders headers,
//		     @PathParam("site") String aSite,
//		     @PathParam("language") String aLanguage,
//		     @PathParam("id") String aPostId,
//		     @PathParam("fid") String aLinkId
//		     )
//	{
//		AccessLogInfo a = null;
//		if (logger.isInfoEnabled())
//		{
//			a = this.accessLogInfo();	
//		}		
//
//		if (logger.isDebugEnabled())
//		{
//
//		}		
//
//		PostLink_DELETE bl = new PostLink_DELETE(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, aPostId, aLinkId);
//		Response response = bl.process(request);
//	    if (a != null)
//	    {
//	       logger.info(a.close());	 
//	    }
//		return response;
//	}
//
//	@DELETE
//	@Path("{id}")
//	@Produces({ "application/xml", "application/json" })
//	public Response deletePost(
//		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
//		     @Context Request request, 
//		     @Context HttpHeaders headers,
//		     @PathParam("site") String aSite,
//		     @PathParam("language") String aLanguage,
//		     @PathParam("id") String aPostId
//		     )
//	{
//		AccessLogInfo a = null;
//		if (logger.isInfoEnabled())
//		{
//			a = this.accessLogInfo();	
//		}		
//
//		if (logger.isDebugEnabled())
//		{
//
//		}		
//
//		Post_DELETE bl = new Post_DELETE(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aPostId);
//		Response response = bl.process(request);
//	    if (a != null)
//	    {
//	       logger.info(a.close());	 
//	    }
//		return response;
//	}

}
