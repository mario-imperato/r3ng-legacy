package org.r3.ws.wbs;

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
import org.r3.db.DTOBase;
import org.r3.system.rest.AccessLogInfo;
import org.r3.system.rest.RestService;
import org.r3.system.rest.ServicePattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("{site}/{language}/wbs")
public class WsWBS extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(WsWBS.class);

	@GET
	@Produces({ "application/xml", "application/json" })
	public Response query(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @MatrixParam("includetree") Boolean includeNodesTree,
		     @Form WBSQueryActionForm queryForm
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

		GETWBSes bl = new GETWBSes(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), queryForm,  (includeNodesTree != null) ? includeNodesTree.booleanValue() : false);
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
	public Response createWbs(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @Form WBSActionForm actionForm
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

		POSTWBS bl = new POSTWBS(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), actionForm);
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
	public Response updateWbs(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aWbsId,
		     @Form WBSActionForm actionForm
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

		PUTWBS bl = new PUTWBS(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aWbsId, actionForm);
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
	public Response detailWbs(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aWbsId,
		     @MatrixParam("includetree") Boolean includeNodesTree
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

		if (includeNodesTree != null)
		{
			
		}
		
		GETWBSDetail bl = new GETWBSDetail(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aWbsId, (includeNodesTree != null) ? includeNodesTree.booleanValue() : false);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@PUT
	@Path("{id}/nodes")
	@Produces({ "application/xml", "application/json" })
	public Response updateWbsOutlineNumbering(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aWbsId
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

		PUTUpdateWBSOutlineNumbering bl = new PUTUpdateWBSOutlineNumbering(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aWbsId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("{id}/wbsactors")
	@Produces({ "application/xml", "application/json" })
	public Response getWbsActors(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aWbsId,
		     @Form WBSActorQueryActionForm queryForm
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

		GETWBSActors bl = new GETWBSActors(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aWbsId, queryForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@GET
	@Path("{wbsid}/teamprofile")
	@Produces({ "application/xml", "application/json" })
	public Response getWbsTeamProfile(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("wbsid") String aWbsId,		     
		     @Form WBSNodeTeamProfileQueryActionForm anActionForm
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

		ServicePattern bl = null;		
		bl = new GETWBSTeamProfile(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aWbsId, anActionForm);		
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	
	@GET
	@Path("{wbsid}/nodes/{wbsnodeid}/children")
	@Produces({ "application/xml", "application/json" })
	public Response queryNodeChildren(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("wbsid") String aWbsId,
		     @PathParam("wbsnodeid") String aWbsNodeId,
		     @Form WBSNodeQueryActionForm aQueryForm
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

		GETWBSNodeChildren bl = new GETWBSNodeChildren(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aWbsId, aWbsNodeId, aQueryForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@POST
	@Path("{wbsid}/nodes/{wbsnodeid}/children")
	@Produces({ "application/xml", "application/json" })
	@Consumes("application/x-www-form-urlencoded")
	public Response postNodeChild(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("wbsid") String aWbsId,
		     @PathParam("wbsnodeid") String aWbsNodeId,
		     @Form WBSNodeActionForm anActionForm
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

		POSTWBSNode bl = new POSTWBSNode(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aWbsId, aWbsNodeId, anActionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("{wbsid}/nodes/{wbsnodeid}")
	@Produces({ "application/xml", "application/json" })
	public Response getNode(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("wbsid") String aWbsId,
		     @PathParam("wbsnodeid") String aWbsNodeId	     
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

		ServicePattern bl = null;		
		bl = new GETWBSNodeDetail(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aWbsId, aWbsNodeId);		
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@GET
	@Path("{wbsid}/nodes/{wbsnodeid}/thread")
	@Produces({ "application/xml", "application/json" })
	public Response getNodeThread(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("wbsid") String aWbsId,
		     @PathParam("wbsnodeid") String aWbsNodeId	     
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

		ServicePattern bl = null;		
		bl = new GETBBSThread4WBSNode(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aWbsId, aWbsNodeId);		
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("{wbsid}/nodes/{wbsnodeid}/teamprofile")
	@Produces({ "application/xml", "application/json" })
	public Response getTeamProfile(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("wbsid") String aWbsId,
		     @PathParam("wbsnodeid") String aWbsNodeId,
		     @Form WBSNodeTeamProfileQueryActionForm anActionForm
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

		ServicePattern bl = null;		
		bl = new GETWBSNodeTeamProfile(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aWbsId, aWbsNodeId, anActionForm);		
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

			
	@PUT
	@Path("{wbsid}/nodes/{wbsnodeid}")
	@Produces({ "application/xml", "application/json" })
	@Consumes("application/x-www-form-urlencoded")
	public Response putNode(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("wbsid") String aWbsId,
		     @PathParam("wbsnodeid") String aWbsNodeId,		     
		     @Form WBSNodeActionForm anActionForm,
		     @MatrixParam("mode") String updateMode
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

		boolean updateModeFillOut = false;
		if (updateMode != null && updateMode.equalsIgnoreCase("fill"))
		{
			updateModeFillOut = true;
		}
		
		ServicePattern bl = null;		
		bl = new PUTWBSNode(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aWbsId, aWbsNodeId, anActionForm, updateModeFillOut);		
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@DELETE
	@Path("{wbsid}/nodes/{wbsnodeid}")
	@Produces({ "application/xml", "application/json" })
	public Response deleteNode(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("wbsid") String aWbsId,
		     @PathParam("wbsnodeid") String aWbsNodeId
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

		DELETEWBSNode bl = new DELETEWBSNode(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aWbsId, aWbsNodeId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@PUT
	@Path("{wbsid}/nodes/{wbsparentnodeid}/children/{wbsnodeid}")
	@Produces({ "application/xml", "application/json" })
	public Response sortNode(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("wbsid") String aWbsId,
		     @PathParam("wbsparentnodeid") String aWbsParentNodeId,		     		     
		     @PathParam("wbsnodeid") String aWbsNodeId,		     
		     @MatrixParam("position") String position,
		     @MatrixParam("prevnodeid") String prevNodeId
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

		ServicePattern bl = null;
		
		int p = Integer.parseInt(position);
		bl = new PUTSORTWBSNode(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aWbsId, aWbsParentNodeId, aWbsNodeId, p, DTOBase.nullOnEmpty(prevNodeId));			
		
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

}
