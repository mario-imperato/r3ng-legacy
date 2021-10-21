package org.r3.ws.cms.card;


import javax.ws.rs.BeanParam;
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
import org.r3.db.cms.cardproperty.CardPropertyDTO;
import org.r3.system.rest.AccessLogInfo;
import org.r3.system.rest.RestService;
import org.r3.ws.cms.carddescr.CardDescrActionForm;
import org.r3.ws.cms.carddescr.GETCardDescrDetail;
import org.r3.ws.cms.carddescr.PUTCardDescr;
import org.r3.ws.cms.cardproperty.CardPropertyFileActionForm;
import org.r3.ws.cms.cardproperty.CardPropertyLinkActionForm;
import org.r3.ws.cms.cardproperty.CardPropertyQueryActionForm;
import org.r3.ws.cms.cardproperty.DeleteCardProperty;
import org.r3.ws.cms.cardproperty.GETCardProperties;
import org.r3.ws.cms.cardproperty.POSTCMSCardPropertyFileUpload;
import org.r3.ws.cms.cardproperty.POSTCardProperty;
import org.r3.ws.cms.cardproperty.PUTCardProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("{site}/{language}/cms/cards")
public class WsCard extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(WsCard.class);

	@GET
	@Produces({ "application/xml", "application/json" })
	public Response query(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @Form CardQueryActionForm queryForm
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

		GETCards bl = new GETCards(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), queryForm);
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
		     @Form CardActionForm actionForm
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

		POSTCard bl = new POSTCard(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), actionForm);
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
		     @PathParam("id") String aCardId
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

		GETCardDetail bl = new GETCardDetail(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, aCardId);
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
		     @PathParam("id") String aCardId,
		     @Form CardActionForm actionForm
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

		PUTCard bl = new PUTCard(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, aCardId, actionForm);
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
		     @PathParam("id") String aCardId
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

		DELETECard bl = new DELETECard(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, aCardId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("{id}/{cardLanguage}/text")
	@Produces({ "application/xml", "application/json" })
	public Response detailText(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aCardId,
		     @PathParam("cardLanguage") String aCardLanguage
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

		GETCardDescrDetail bl = new GETCardDescrDetail(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, aCardId, aCardLanguage);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@PUT
	@Path("{id}/{cardLanguage}/text")
	@Produces({ "application/xml", "application/json" })
	@Consumes("application/x-www-form-urlencoded")
	public Response updateDetailText(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aCardId,
		     @PathParam("cardLanguage") String aCardLanguage,
		     @Form CardDescrActionForm actionForm
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

		PUTCardDescr bl = new PUTCardDescr(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, aCardId, aCardLanguage, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("{id}/files")
	@Produces({ "application/xml", "application/json" })
	public Response queryFiles(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aCardId,
		     @Form CardPropertyQueryActionForm queryForm
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

		queryForm.setListOfPropertytypecode(CardPropertyDTO.listOfPropertyType_attachment);
		GETCardProperties bl = new GETCardProperties(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aCardId, queryForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@POST
	@Path("{id}/files")
	@Consumes("multipart/form-data")
	public Response uploadFile(
				     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
				     @Context Request request,
				     @Context HttpHeaders headers,
				     @PathParam("site") String aSite,
				     @PathParam("language") String aLanguage,
				     @PathParam("id") String aCardId,
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

		POSTCMSCardPropertyFileUpload bl = new POSTCMSCardPropertyFileUpload(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, aCardId, input, "files[]", false);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@POST
	@Path("{id}/ie_files")
	@Consumes("multipart/form-data")
	@Produces({ "text/plain" })
	public Response uploadIEFile(
				     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
				     @Context Request request,
				     @Context HttpHeaders headers,
				     @PathParam("site") String aSite,
				     @PathParam("language") String aLanguage,
				     @PathParam("id") String aCardId,
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

		POSTCMSCardPropertyFileUpload bl = new POSTCMSCardPropertyFileUpload(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, aCardId, input, "files[]", true);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@DELETE
	@Path("{cardId}/properties/{propId}")
	@Produces({ "application/xml", "application/json" })
	public Response deleteProperty(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("cardId") String aCardId,
		     @PathParam("propId") String aPropertyId
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

		DeleteCardProperty bl = new DeleteCardProperty(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, aCardId, aPropertyId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@PUT
	@Path("{cardId}/files/{propId}")
	@Produces({ "application/xml", "application/json" })
	@Consumes("application/x-www-form-urlencoded")
	public Response updateFileProperty(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("cardId") String aCardId,
		     @PathParam("propId") String aPropertyId,
		     @Form CardPropertyFileActionForm actionForm
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

		PUTCardProperty bl = new PUTCardProperty(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, aCardId, aPropertyId, actionForm);
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
	public Response queryLinks(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aCardId,
		     @Form CardPropertyQueryActionForm queryForm
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

		queryForm.setListOfPropertytypecode(CardPropertyDTO.listOfPropertyType_link);
		GETCardProperties bl = new GETCardProperties(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aCardId, queryForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@PUT
	@Path("{cardId}/links/{propId}")
	@Produces({ "application/xml", "application/json" })
	@Consumes("application/x-www-form-urlencoded")
	public Response updateLinkProperty(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("cardId") String aCardId,
		     @PathParam("propId") String aPropertyId,
		     @Form CardPropertyLinkActionForm actionForm
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

		PUTCardProperty bl = new PUTCardProperty(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, aCardId, aPropertyId, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@POST
	@Path("{cardId}/links")
	@Produces({ "application/xml", "application/json" })
	@Consumes("application/x-www-form-urlencoded")
	public Response insertLinkProperty(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("cardId") String aCardId,
		     @Form CardPropertyLinkActionForm actionForm
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

		POSTCardProperty bl = new POSTCardProperty(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, aCardId, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("{id}/images")
	@Produces({ "application/xml", "application/json" })
	public Response queryImages(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String aCardId,
		     @Form CardPropertyQueryActionForm queryForm
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

		queryForm.setListOfPropertytypecode(CardPropertyDTO.listOfPropertyType_image);
		GETCardProperties bl = new GETCardProperties(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aCardId, queryForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}


}
