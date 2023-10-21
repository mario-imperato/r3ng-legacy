package org.r3.ws.sailevent.application;

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
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.Form;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.r3.db.sailevent.application.SailApplicationDTO;
import org.r3.system.rest.AccessLogInfo;
import org.r3.system.rest.RestService;
import org.r3.ws.sailevent.appcrewmember.DeleteCrewMember;
import org.r3.ws.sailevent.appcrewmember.GETSailApplicationCrew;
import org.r3.ws.sailevent.appcrewmember.POSTSailApplicationCrewMember;
import org.r3.ws.sailevent.appcrewmember.PUTSailApplicationCrewMember;
import org.r3.ws.sailevent.appcrewmember.SailApplicationCrewMemberActionForm;
import org.r3.ws.sailevent.appcrewmember.SailApplicationCrewMemberQueryActionForm;
import org.r3.ws.sailevent.appdocument.DELETESailApplicationDocument;
import org.r3.ws.sailevent.appdocument.GETSailApplicationDocuments;
import org.r3.ws.sailevent.appdocument.SailApplicationDocumentQueryActionForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("{site}/{language}/sev/applications")
public class WsSailApplication extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(WsSailApplication.class);

	@GET
	@Produces({ "application/xml", "application/json" })
	public Response query(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @Form SailApplicationQueryActionForm queryForm
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

		GETSailApplications bl = new GETSailApplications(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), queryForm);
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
		     @PathParam("id") String anApplicationId
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

		GETSailApplicationDetail bl = new GETSailApplicationDetail(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anApplicationId, false);
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
		     @PathParam("id") String anApplicationId
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

		DELETESailApplication bl = new DELETESailApplication(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anApplicationId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@POST
	@Produces({ "application/xml", "application/json" })
	public Response createEmpty(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @MatrixParam("onbehalf") String aUserId
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
		
		POSTSailApplication bl = new POSTSailApplication(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aUserId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("{id}/crew")
	@Produces({ "application/xml", "application/json" })
	public Response queryCrew(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String anApplicationId,
		     @Form SailApplicationCrewMemberQueryActionForm queryForm
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

		GETSailApplicationCrew bl = new GETSailApplicationCrew(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anApplicationId, queryForm, true);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@POST
	@Path("{id}/crew")
	@Produces({ "application/xml", "application/json" })
	public Response insertCrew(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String anApplicationId,
		     @Form SailApplicationCrewMemberActionForm actionForm
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

		POSTSailApplicationCrewMember bl = new POSTSailApplicationCrewMember(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, anApplicationId, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@PUT
	@Path("{id}/crew/{memberid}")
	@Produces({ "application/xml", "application/json" })
	public Response updateCrew(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String anApplicationId,
		     @PathParam("memberid") String anMemberId,
		     @Form SailApplicationCrewMemberActionForm actionForm
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

		PUTSailApplicationCrewMember bl = new PUTSailApplicationCrewMember(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, anApplicationId, anMemberId, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@DELETE
	@Path("{id}/crew/{memberid}")
	@Produces({ "application/xml", "application/json" })
	public Response deleteCrew(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String anApplicationId,
		     @PathParam("memberid") String anMemberId
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

		DeleteCrewMember bl = new DeleteCrewMember(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, anApplicationId, anMemberId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("{id}/crew/{memberid}/documents")
	@Produces({ "application/xml", "application/json" })
	public Response queryCrewMemberDocuments(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String anApplicationId,
		     @PathParam("memberid") String aCrewMemberId,
		     @Form SailApplicationDocumentQueryActionForm queryForm
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

		GETSailApplicationDocuments bl = new GETSailApplicationDocuments(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anApplicationId, aCrewMemberId, queryForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@GET
	@Path("{id}/documents")
	@Produces({ "application/xml", "application/json" })
	public Response queryDocuments(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String anApplicationId,
		     @Form SailApplicationDocumentQueryActionForm queryForm
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

		GETSailApplicationDocuments bl = new GETSailApplicationDocuments(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anApplicationId, null, queryForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@PUT
	@Path("{id}/boatinfo")
	@Produces({ "application/xml", "application/json" })
	public Response updateboatinfo(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String anApplicationId,
		     MultivaluedMap<String, String> rawData
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

		SailFillOutApplicationActionForm actionForm = new SailFillOutApplicationActionForm(rawData);
		
		PUTSailApplication bl = new PUTSailApplication(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anApplicationId, SailApplicationDTO.ApplicationSection.r3ea_boatinfo, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@PUT
	@Path("{id}/classinfo")
	@Produces({ "application/xml", "application/json" })
	public Response updateclassinfo(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String anApplicationId,
		     MultivaluedMap<String, String> rawData
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

		SailFillOutApplicationActionForm actionForm = new SailFillOutApplicationActionForm(rawData);

		PUTSailApplication bl = new PUTSailApplication(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anApplicationId, SailApplicationDTO.ApplicationSection.r3ea_classinfo, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@PUT
	@Path("{id}/ownerinfo")
	@Produces({ "application/xml", "application/json" })
	public Response updateownerinfo(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String anApplicationId,
		     MultivaluedMap<String, String> rawData
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

		SailFillOutApplicationActionForm actionForm = new SailFillOutApplicationActionForm(rawData);

		PUTSailApplication bl = new PUTSailApplication(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anApplicationId, SailApplicationDTO.ApplicationSection.r3ea_ownerinfo, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@PUT
	@Path("{id}/authorinfo")
	@Produces({ "application/xml", "application/json" })
	public Response updateauthorinfo(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String anApplicationId,
		     MultivaluedMap<String, String> rawData
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

		SailFillOutApplicationActionForm actionForm = new SailFillOutApplicationActionForm(rawData);

		PUTSailApplication bl = new PUTSailApplication(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anApplicationId, SailApplicationDTO.ApplicationSection.r3ea_authorinfo, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@PUT
	@Path("{id}/attendancesheetinfo")
	@Produces({ "application/xml", "application/json" })
	public Response updateattendancesheetinfo(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String anApplicationId,
		     MultivaluedMap<String, String> rawData
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

		SailFillOutApplicationActionForm actionForm = new SailFillOutApplicationActionForm(rawData);

		PUTSailApplication bl = new PUTSailApplication(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anApplicationId, SailApplicationDTO.ApplicationSection.r3ea_attsheet, actionForm);
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
				     @PathParam("id") String anApplicationId,
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

		POSTFileUpload bl = new POSTFileUpload(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, anApplicationId, input, "files[]", false);
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
				     @PathParam("id") String anApplicationId,
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

		POSTFileUpload bl = new POSTFileUpload(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, anApplicationId, input, "files[]", true);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@DELETE
	@Path("{id}/files/{docid}")
	@Produces({ "application/xml", "application/json" })
	public Response deleteFile(
				     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
				     @Context Request request,
				     @Context HttpHeaders headers,
				     @PathParam("site") String aSite,
				     @PathParam("language") String aLanguage,
				     @PathParam("id") String anApplicationId,
				     @PathParam("docid") String aDocId) 
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

		DELETESailApplicationDocument bl = new DELETESailApplicationDocument(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aSite, anApplicationId, aDocId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@POST
	@Path("{id}/commit")
	@Produces({ "application/xml", "application/json" })
	public Response commitApplication(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String anApplicationId
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

		POSTSailApplicationCommit bl = new POSTSailApplicationCommit(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anApplicationId);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@PUT
	@Path("{id}/adminchecks")
	@Produces({ "application/xml", "application/json" })
	public Response updateadminchecks(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String anApplicationId,
		     MultivaluedMap<String, String> rawData
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

		SailFillOutApplicationActionForm actionForm = new SailFillOutApplicationActionForm(rawData);

		PUTSailApplication bl = new PUTSailApplication(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anApplicationId, SailApplicationDTO.ApplicationSection.r3ea_adminchecks, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	@PUT
	@Path("{id}/adminraceinfo")
	@Produces({ "application/xml", "application/json" })
	public Response updateadminraceinfo(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("id") String anApplicationId,
		     MultivaluedMap<String, String> rawData
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

		SailFillOutApplicationActionForm actionForm = new SailFillOutApplicationActionForm(rawData);

		PUTSailApplication bl = new PUTSailApplication(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), anApplicationId, SailApplicationDTO.ApplicationSection.r3ea_adminraceinfo, actionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

}
