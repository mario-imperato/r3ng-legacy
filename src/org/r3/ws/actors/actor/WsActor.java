package org.r3.ws.actors.actor;

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
import org.r3.ws.wbs.GETWBSNodes4Assignee;
import org.r3.ws.wbs.WBSNodeQueryActionForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("{site}/{language}/actors")
public class WsActor extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(WsActor.class);

	@GET
	@Produces({ "application/xml", "application/json" })
	public Response query(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @Form ActorQueryActionForm queryForm
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

		GETActors bl = new GETActors(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), queryForm, OutputFormat.json);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
//	@Path("asCSV.csv")
	@Produces({ "text/csv" })
	public Response queryAsCsv(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @Form ActorQueryActionForm queryForm
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

		GETActors bl = new GETActors(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), queryForm, OutputFormat.csv);
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
		     @PathParam("id") String anActorId
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

		GETActorDetail bl = new GETActorDetail(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anActorId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

//	@GET
//	@Path("{id}/resource")
//	@Produces({ "application/xml", "application/json" })
//	public Response detailResource(
//		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
//		     @Context Request request, 
//		     @Context HttpHeaders headers,
//		     @PathParam("site") String aSite,
//		     @PathParam("language") String aLanguage,
//		     @PathParam("id") String anActorId
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
//		GETResourceDetail bl = new GETResourceDetail(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anActorId);
//		Response response = bl.process(request);
//	    if (a != null)
//	    {
//	       logger.info(a.close());	 
//	    }
//		return response;
//	}

	@GET
	@Path("{id}/wbsnodes")
	@Produces({ "application/xml", "application/json" })
	public Response listOfWbsNodes(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String anActorId,
		     @Form WBSNodeQueryActionForm queryActionForm
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

		GETWBSNodes4Assignee bl = new GETWBSNodes4Assignee(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anActorId, queryActionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
//	@PUT
//	@Path("{id}/resource")
//	@Produces({ "application/xml", "application/json" })
//	public Response updateResource(
//		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
//		     @Context Request request, 
//		     @Context HttpHeaders headers,
//		     @PathParam("site") String aSite,
//		     @PathParam("language") String aLanguage,
//		     @PathParam("id") String anActorId,
//		     @Form SiteResourceActionForm actionForm
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
//		PUTSiteResource bl = new PUTSiteResource(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anActorId, actionForm);
//		Response response = bl.process(request);
//	    if (a != null)
//	    {
//	       logger.info(a.close());	 
//	    }
//		return response;
//	}

	@POST
	@Produces({ "application/xml", "application/json" })
	@Consumes("application/x-www-form-urlencoded")
	public Response create(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @Form ActorActionForm actionForm
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

		POSTActor bl = new POSTActor(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@POST
	@Path("newsletter")
	@Produces({ "application/xml", "application/json" })
	@Consumes("application/x-www-form-urlencoded")
	public Response create4NewsLetter(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @Form ActorActionForm actionForm
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

		POSTActor4NewsLetter bl = new POSTActor4NewsLetter(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@POST
	@Path("files")
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

		POSTActorFileUpload bl = new POSTActorFileUpload(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), input, "files[]", false);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@POST
	@Path("files_ie")
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

		POSTActorFileUpload bl = new POSTActorFileUpload(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), input, "files[]", true);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@PUT
	@Path("files/{id}")
	@Produces({ "application/xml", "application/json" })
	public Response processFile(
				     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
				     @Context Request request,
				     @Context HttpHeaders headers,
				     @PathParam("site") String aSite,
				     @PathParam("language") String aLanguage,
				     @PathParam("id") String aFileImportId,
				     @Form ProcessActorFileImportActionForm actionForm) 
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

		POSTProcessFileImport bl = new POSTProcessFileImport(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, aFileImportId, actionForm);
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
		     @PathParam("id") String anActorId,
		     @Form ActorActionForm actionForm
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

		PUTActor bl = new PUTActor(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anActorId, actionForm);
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
	public Response delete(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String anActorId
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

		DELETEActor bl = new DELETEActor(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, anActorId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@POST
	@Path("fromsite")
	@Produces({ "application/xml", "application/json" })
	public Response importContactsFromSite(
				     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
				     @Context Request request,
				     @Context HttpHeaders headers,
				     @PathParam("site") String aSite,
				     @PathParam("language") String aLanguage,
				     @Form ImportActorsFromChildSiteActionForm actionForm) 
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

		ImportActorsFromChildSite bl = new ImportActorsFromChildSite(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
}
