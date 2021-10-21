package org.r3.ws.bbs;

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
import org.r3.system.rest.AccessLogInfo;
import org.r3.system.rest.RestService;
import org.r3.ws.bbs.thread.BBSThreadActionForm;
import org.r3.ws.bbs.thread.BBSThreadQueryActionForm;
import org.r3.ws.bbs.thread.DELETEBBSThread;
import org.r3.ws.bbs.thread.DELETECollectionBBSThreadNode;
import org.r3.ws.bbs.thread.GETBBSThreadDetail;
import org.r3.ws.bbs.thread.GETBBSThreads;
import org.r3.ws.bbs.thread.POSTBBSThread;
import org.r3.ws.bbs.thread.PUTBBSThread;
import org.r3.ws.bbs.threadnode.BBSThreadNodeActionForm;
import org.r3.ws.bbs.threadnode.BBSThreadNodeQueryActionForm;
import org.r3.ws.bbs.threadnode.DELETEBBSThreadNode;
import org.r3.ws.bbs.threadnode.GETBBSThreadNodeDetail;
import org.r3.ws.bbs.threadnode.GETBBSThreadNodes;
import org.r3.ws.bbs.threadnode.POSTBBSThreadNode;
import org.r3.ws.bbs.threadnode.PUTBBSThreadNode;
import org.r3.ws.bbs.topic.BBSTopicActionForm;
import org.r3.ws.bbs.topic.BBSTopicQueryActionForm;
import org.r3.ws.bbs.topic.DELETEBBSTopic;
import org.r3.ws.bbs.topic.DELETECollectionBBSThread;
import org.r3.ws.bbs.topic.GETBBSTopicDetail;
import org.r3.ws.bbs.topic.GETBBSTopics;
import org.r3.ws.bbs.topic.POSTBBSTopic;
import org.r3.ws.bbs.topic.PUTBBSTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("{site}/{language}/bbs")
public class WsBBS extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(WsBBS.class);

	@GET
	@Path("topics")
	@Produces({ "application/xml", "application/json" })
	public Response queryTopic(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @MatrixParam("fetchthreads") Boolean fetchThreads,
		     @Form BBSTopicQueryActionForm queryForm
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

		GETBBSTopics bl = new GETBBSTopics(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), queryForm,  (fetchThreads != null) ? fetchThreads.booleanValue() : false);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@POST
	@Path("topics")
	@Produces({ "application/xml", "application/json" })
	public Response createTopic(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @Form BBSTopicActionForm actionForm
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

		POSTBBSTopic bl = new POSTBBSTopic(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("topics/{id}")
	@Produces({ "application/xml", "application/json" })
	public Response getTopicDetail(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aTopicId
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

		GETBBSTopicDetail bl = new GETBBSTopicDetail(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aTopicId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@PUT
	@Path("topics/{id}")
	@Produces({ "application/xml", "application/json" })
	public Response updateTopicDetail(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aTopicId,
		     @Form BBSTopicActionForm aTopicActionForm
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

		PUTBBSTopic bl = new PUTBBSTopic(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aTopicId, aTopicActionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@DELETE
	@Path("topics/{id}")
	@Produces({ "application/xml", "application/json" })
	public Response deleteTopic(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aTopicId
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

		DELETEBBSTopic bl = new DELETEBBSTopic(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aTopicId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("topics/{id}/threads")
	@Produces({ "application/xml", "application/json" })
	public Response getThreads(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aTopicId,
		     @Form BBSThreadQueryActionForm queryActionForm
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

		GETBBSThreads bl = new GETBBSThreads(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aTopicId, queryActionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@POST
	@Path("topics/{id}/threads")
	@Produces({ "application/xml", "application/json" })
	public Response createThread(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aTopicId,
		     @Form BBSThreadActionForm actionForm
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

		POSTBBSThread bl = new POSTBBSThread(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aTopicId, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@PUT
	@Path("topics/{id}/threads")
	@Produces({ "application/xml", "application/json" })
	public Response deleteSelectedThread(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aTopicId,
		     @Form BBSTopicActionForm actionForm
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

		DELETECollectionBBSThread bl = new DELETECollectionBBSThread(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aTopicId, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("topics/{id}/threads/{id_thread}")
	@Produces({ "application/xml", "application/json" })
	public Response getThreadDetail(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aTopicId,
		     @PathParam("id_thread") String aThreadId
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

		GETBBSThreadDetail bl = new GETBBSThreadDetail(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aTopicId, aThreadId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@PUT
	@Path("topics/{id}/threads/{id_thread}")
	@Produces({ "application/xml", "application/json" })
	public Response updateThread(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aTopicId,
		     @PathParam("id_thread") String aThreadId,
		     @Form BBSThreadActionForm actionForm
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

		PUTBBSThread bl = new PUTBBSThread(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aTopicId, aThreadId, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@DELETE
	@Path("topics/{id}/threads/{id_thread}")
	@Produces({ "application/xml", "application/json" })
	public Response deleteThread(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aTopicId,
		     @PathParam("id_thread") String aThreadId
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

		DELETEBBSThread bl = new DELETEBBSThread(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aTopicId, aThreadId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	
	// Posts Section
	@GET
	@Path("topics/{id}/threads/{id_thread}/posts")
	@Produces({ "application/xml", "application/json" })
	public Response getThreadNodes(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aTopicId,
		     @PathParam("id_thread") String aThreadId,
		     @MatrixParam ("mode") String aMode,
		     @Form BBSThreadNodeQueryActionForm queryActionForm
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

		
		GETBBSThreadNodes bl = new GETBBSThreadNodes(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aTopicId, aThreadId, aMode, queryActionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@POST
	@Path("topics/{id}/threads/{id_thread}/posts")
	@Produces({ "application/xml", "application/json" })
	public Response createThread(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aTopicId,
		     @PathParam("id_thread") String aThreadId,
		     @Form BBSThreadNodeActionForm actionForm
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

		POSTBBSThreadNode bl = new POSTBBSThreadNode(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aTopicId, aThreadId, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@PUT
	@Path("topics/{id}/threads/{id_thread}/posts")
	@Produces({ "application/xml", "application/json" })
	public Response deleteSelectedThreadNodes(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aTopicId,
		     @PathParam("id_thread") String aThreadId,
		     @Form BBSThreadActionForm actionForm
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

		DELETECollectionBBSThreadNode bl = new DELETECollectionBBSThreadNode(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aTopicId, aThreadId, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("topics/{id}/threads/{id_thread}/posts/{id_post}")
	@Produces({ "application/xml", "application/json" })
	public Response getThreadNodeDetail(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aTopicId,
		     @PathParam("id_thread") String aThreadId,
		     @PathParam("id_post") String aPostId
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

		GETBBSThreadNodeDetail bl = new GETBBSThreadNodeDetail(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aTopicId, aThreadId, aPostId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@PUT
	@Path("topics/{id}/threads/{id_thread}/posts/{id_post}")
	@Produces({ "application/xml", "application/json" })
	public Response updateThreadNode(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aTopicId,
		     @PathParam("id_thread") String aThreadId,
		     @PathParam("id_post") String aPostId,
		     @Form BBSThreadNodeActionForm actionForm
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

		PUTBBSThreadNode bl = new PUTBBSThreadNode(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aTopicId, aThreadId, aPostId, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@DELETE
	@Path("topics/{id}/threads/{id_thread}/posts/{id_post}")
	@Produces({ "application/xml", "application/json" })
	public Response deleteThreadNode(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aTopicId,
		     @PathParam("id_thread") String aThreadId,
		     @PathParam("id_post") String aPostId
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

		DELETEBBSThreadNode bl = new DELETEBBSThreadNode(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aTopicId, aThreadId, aPostId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
}
