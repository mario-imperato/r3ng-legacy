package org.r3.ws.sailevent.ranking;

import javax.ws.rs.Consumes;
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
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.r3.system.rest.AccessLogInfo;
import org.r3.system.rest.RestService;
import org.r3.ws.sailevent.rankinginstance.GETRankingInstanceDetail;
import org.r3.ws.sailevent.rankinginstance.GETRankingInstances;
import org.r3.ws.sailevent.rankinginstance.RankingInstancesQueryActionForm;
import org.r3.ws.sailevent.rankinginstancedetailview.GETRankingInstanceEntries;
import org.r3.ws.sailevent.rankinginstancedetailview.RankingInstanceEntriesQueryActionForm;
import org.r3.ws.sailevent.rankingview.GETRankingSynoptic;
import org.r3.ws.sailevent.rankingview.SailRankingViewQueryActionForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("{site}/{language}/sev/rankings")
public class WsSailRanking extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(WsSailRanking.class);

	@GET
	@Produces({ "application/xml", "application/json" })
	public Response query(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @Form SailRankingQueryActionForm queryForm
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

		GETSailRankings bl = new GETSailRankings(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), queryForm);
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
		     @PathParam("id") String aRankId
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

		GETRankingDetail bl = new GETRankingDetail(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aRankId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("synoptic")
	@Produces({ "application/xml", "application/json" })
	public Response querySynoptic(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @Form SailRankingViewQueryActionForm queryForm
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

		GETRankingSynoptic bl = new GETRankingSynoptic(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), queryForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@POST
	@Produces({ "application/xml", "application/json" })
	@Consumes("application/x-www-form-urlencoded")
	public Response create(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @Form RankingActionForm actionForm
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

		POSTRanking bl = new POSTRanking(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), actionForm);
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
	@Consumes("application/x-www-form-urlencoded")
	public Response update(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aRankId,
		     @Form RankingActionForm actionForm
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

		PUTRanking bl = new PUTRanking(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aRankId, actionForm);
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
	public Response deleteRanking(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aRankId
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

		DELETERanking bl = new DELETERanking(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aRankId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("{id}/instances")
	@Produces({ "application/xml", "application/json" })
	public Response queryInstances(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aRankId,
		     @Form RankingInstancesQueryActionForm queryForm
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

		GETRankingInstances bl = new GETRankingInstances(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aRankId, queryForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@PUT
	@Path("{id}/instances")
	@Produces({ "application/xml", "application/json" })
	@Consumes("application/x-www-form-urlencoded")
	public Response deleteInstances(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aRankId,
		     @Form RankingActionForm actionForm
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

		DELETERankingInstances bl = new DELETERankingInstances(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aRankId, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("{id}/instances/{instanceId}")
	@Produces({ "application/xml", "application/json" })
	public Response queryInstanceDetail(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aRankId,
		     @PathParam("instanceId") String anInstanceId
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

		GETRankingInstanceDetail bl = new GETRankingInstanceDetail(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anInstanceId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@POST
	@Path("cyberaltura_files")
	@Consumes("multipart/form-data")
	public Response uploadFile(
				     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
				     @Context Request request,
				     @Context HttpHeaders headers,
				     @PathParam("site") String aSite,
				     @PathParam("language") String aLanguage,
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

		POSTFileUpload bl = new POSTFileUpload(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), input,  "files[]", false);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@POST
	@Path("cyberaltura_files_ie")
	@Consumes("multipart/form-data")
	@Produces({ "text/plain" })
	public Response uploadIEFile(
				     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
				     @Context Request request,
				     @Context HttpHeaders headers,
				     @PathParam("site") String aSite,
				     @PathParam("language") String aLanguage,
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

		POSTFileUpload bl = new POSTFileUpload(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), input,  "files[]", true);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("{id}/instances/{instanceId}/entries")
	@Produces({ "application/xml", "application/json" })
	public Response queryInstanceDetailEntries(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aRankId,
		     @PathParam("instanceId") String anInstanceId,
		     @Form RankingInstanceEntriesQueryActionForm queryActionForm
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

		GETRankingInstanceEntries bl = new GETRankingInstanceEntries(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anInstanceId, queryActionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

}
