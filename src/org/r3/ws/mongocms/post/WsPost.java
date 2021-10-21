package org.r3.ws.mongocms.post;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
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
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.r3.db.DTOBase;
import org.r3.db.utils.DataTableQueryActionForm;
import org.r3.system.rest.AccessLogInfo;
import org.r3.system.rest.RestService;
import org.r3.ws.mongocms.filecollection.FileUpload_POST.ResponseType;
import org.r3.ws.mongocms.post.PostComment_PUT.UpdateVerb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("{site}/{language}/cms/posts")
public class WsPost extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(WsPost.class);

	@GET
	@Produces({ "application/xml", "application/json" })
	public Response query(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @Form PostQueryActionForm queryForm
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

		GETPosts bl = new GETPosts(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), queryForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@POST
	@Produces({ "application/xml", "application/json" })
	public Response newPost(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @MatrixParam("timeline") String inTimeLineFlag,
		     @Form PostActionForm actionForm
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

		boolean inTimeline = false;
		if (inTimeLineFlag != null)
			inTimeline = DTOBase.getBTrueFalseAsBoolean(inTimeLineFlag);
		
		Response response = null;
		if (inTimeline)
		{
		POSTAddPost2Timeline bl = new POSTAddPost2Timeline(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), actionForm);
		response = bl.process(request);
		}
		else
		{
			POSTAddPost bl = new POSTAddPost(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), actionForm);
			response = bl.process(request);			
		}
		
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
		     @PathParam("id") String aPostId
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

		GETPostDetail bl = new GETPostDetail(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, aPostId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@PUT
	@Path("{id}")
	@Produces({ "application/xml", "application/json" })
	public Response updatePostInTimeline(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aPostId,
		     @Form PostActionForm actionForm
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

		PUTUpdatePostInTimeline bl = new PUTUpdatePostInTimeline(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aPostId, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@PUT
	@Path("{id}/publish")
	@Produces({ "application/xml", "application/json" })
	public Response updateStatusInfo(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aPostId,
		     @Form PostActionForm actionForm
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

		PostContent_PUT bl = new PostContent_PUT(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, PostContent_PUT.UpdateModeSection.publish, aPostId, null, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@PUT
	@Path("{id}/generalinfo")
	@Produces({ "application/xml", "application/json" })
	public Response updateGeneralInfo(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aPostId,
		     @Form PostActionForm actionForm
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

		PostContent_PUT bl = new PostContent_PUT(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, PostContent_PUT.UpdateModeSection.generalInfo, aPostId, null, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@PUT
	@Path("{id}/textbody/{lang}")
	@Produces({ "application/xml", "application/json" })
	public Response updateTextBody(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aPostId,
		     @PathParam("lang") String textBodyLanguageCode,
		     @Form PostActionForm actionForm
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

		PostContent_PUT bl = new PostContent_PUT(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, PostContent_PUT.UpdateModeSection.textBody, aPostId, textBodyLanguageCode, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@PUT
	@Path("{id}/content")
	@Produces({ "application/xml", "application/json" })
	public Response updateContent(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aPostId,
		     @Form PostActionForm actionForm
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

		PostContent_PUT bl = new PostContent_PUT(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, PostContent_PUT.UpdateModeSection.content, aPostId, null, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("{id}/fileattachments")
	@Produces({ "application/xml", "application/json" })
	public Response fileAttachments(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aPostId,
		     @Form DataTableQueryActionForm queryActionForm
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

		PostFileAttachments_GET bl = new PostFileAttachments_GET(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, aPostId, queryActionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@DELETE
	@Path("{id}/fileattachments/{fid}")
	@Produces({ "application/xml", "application/json" })
	public Response deletefileAttachment(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aPostId,
		     @PathParam("fid") String anAttachmentId		     
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

		PostFileAttachment_DELETE bl = new PostFileAttachment_DELETE(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, aPostId, anAttachmentId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@PUT
	@Path("{id}/fileattachments/{fid}")
	@Produces({ "application/xml", "application/json" })
	public Response updatefileAttachmentInfo(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aPostId,
		     @PathParam("fid") String anAttachmentId,
		     @Form PostFileAttachment_ActionForm anActionForm
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

		PostFileAttachment_PUT bl = new PostFileAttachment_PUT(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, aPostId, anAttachmentId, anActionForm);
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
	public Response uploadPhoto(
				     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
				     @Context Request request,
				     @Context HttpHeaders headers,
				     @PathParam("site") String aSite,
				     @PathParam("language") String aLanguage,
				     @PathParam("id") String aPostId,
				     @MatrixParam("filepartname") String aFilepartname,
				     @MatrixParam("attachmenttype") String anAttachmentType,
				     @MatrixParam("responsetype") String aResponseType,
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
		
		ResponseType rt = ResponseType.getValue4(aResponseType, ResponseType.uploaded_file);
		
		PostPhotoUpload_PUT bl = new PostPhotoUpload_PUT(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aPostId, input, aFilepartname, anAttachmentType, rt);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@POST
	@Path("{id}/fileattachments")
	@Consumes("multipart/form-data")
	@Produces({ "application/json" })
	public Response uploadFile(
				     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
				     @Context Request request,
				     @Context HttpHeaders headers,
				     @PathParam("site") String aSite,
				     @PathParam("language") String aLanguage,
				     @PathParam("id") String aPostId,
				     @MatrixParam("filepartname") String aFilepartname,
				     @MatrixParam("attachmenttype") String anAttachmentType,
				     @MatrixParam("responsetype") String aResponseType,
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
		
		ResponseType rt = ResponseType.getValue4(aResponseType, ResponseType.uploaded_file);
		PostFileAttachmentUpload_POST bl = new PostFileAttachmentUpload_POST(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aPostId, input, aFilepartname, anAttachmentType, rt);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@GET
	@Path("{id}/links")
	@Produces({ "application/xml", "application/json" })
	public Response links(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aPostId,
		     @Form DataTableQueryActionForm queryActionForm
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

		GETPostLinks bl = new GETPostLinks(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, aPostId, queryActionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@POST
	@Path("{id}/links")
	@Produces({ "application/xml", "application/json" })
	public Response addLink(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aPostId,		  
		     @Form PostLink_ActionForm anActionForm
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

		PostLink_POST bl = new PostLink_POST(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, aPostId, anActionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@PUT
	@Path("{id}/links/{fid}")
	@Produces({ "application/xml", "application/json" })
	public Response updateLink(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aPostId,
		     @PathParam("fid") String aLinkId,
		     @Form PostLink_ActionForm anActionForm
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

		PostLink_PUT bl = new PostLink_PUT(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, aPostId, aLinkId, anActionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@DELETE
	@Path("{id}/links/{fid}")
	@Produces({ "application/xml", "application/json" })
	public Response deleteLink(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aPostId,
		     @PathParam("fid") String aLinkId
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

		PostLink_DELETE bl = new PostLink_DELETE(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, aPostId, aLinkId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@DELETE
	@Path("{id}")
	@Produces({ "application/xml", "application/json" })
	public Response deletePost(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aPostId
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

		Post_DELETE bl = new Post_DELETE(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aPostId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("{id}/comments")
	@Produces({ "application/xml", "application/json" })
	public Response getComments(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aPostId,
		     @Form PostCommentQueryActionForm queryActionForm
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

		GETPostComments bl = new GETPostComments(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aPostId, queryActionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@POST
	@Path("{idPost}/comments")
	@Produces({ "application/xml", "application/json" })
	public Response addComment2PostInTimeline(
			 @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("idPost") String aPostId,
		     @Form PostActionForm queryActionForm,
		     @MatrixParam("osite") String overrideSite	
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

		PostComment_POST bl = new PostComment_POST(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aPostId, queryActionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@PUT
	@Path("{idPost}/comments/{idComment}")
	@Produces({ "application/xml", "application/json" })
	public Response updateCommentInPostInTimeline(
			 @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("idPost") String aPostId,
		     @PathParam("idComment") String aCommentId,
		     @MatrixParam("verb") String anUpdateAction,
		     @Form PostActionForm queryActionForm   
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

		UpdateVerb updateVerb = UpdateVerb.getValue4(anUpdateAction, UpdateVerb.update);
		
		PostComment_PUT bl = new PostComment_PUT(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), updateVerb, aPostId, aCommentId, queryActionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
		
	@DELETE
	@Path("{idPost}/comments/{idComment}")
	@Produces({ "application/xml", "application/json" })
	public Response deleteCommentFromPostInTimeline(
			 @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("idPost") String aPostId,
		     @PathParam("idComment") String aCommentId
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

		PostComment_DELETE bl = new PostComment_DELETE(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aPostId, aCommentId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

}
