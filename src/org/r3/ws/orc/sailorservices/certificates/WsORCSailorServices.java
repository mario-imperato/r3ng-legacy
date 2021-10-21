package org.r3.ws.orc.sailorservices.certificates;


import javax.ws.rs.Consumes;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.r3.system.rest.AccessLogInfo;
import org.r3.system.rest.RestService;
import org.r3.system.rest.RestServiceMeta;
import org.r3.ws.mongocms.filecollection.FileUpload_POST.ResponseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("{site}/{language}/orc/sailorservices/certificates")
public class WsORCSailorServices extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(WsORCSailorServices.class);

	@POST
	@Path("rms")
	@Consumes("multipart/form-data")
	@Produces({ "application/json" })
	@RestServiceMeta
	public Response uploadRMSFile(
				     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
				     @Context Request request,
				     @Context HttpHeaders headers,
				     @PathParam("site") String aSite,
				     @PathParam("language") String aLanguage,
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
		RMSFileUpload_POST bl = new RMSFileUpload_POST(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), input, aFilepartname, anAttachmentType, rt);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	

}
