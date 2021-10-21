package org.r3.ws.system.dms;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import org.r3.system.rest.AccessLogInfo;
import org.r3.system.rest.RestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("{site}/{language}/system/mdbdms")
public class MongoWsDMS extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(MongoWsDMS.class);


	
	@GET
	@Path("{urlsite}/{urllanguage}/{dbname}/{collection}/{objectid}")
	public Response getMongoDbDMSFile(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request,
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     
		     @PathParam("urlsite") String aUrlSite,
		     @PathParam("urllanguage") String aUrlLanguage,		     
		     @PathParam("dbname") String aDbName,
		     @PathParam("collection") String aCollection,
		     @PathParam("objectid") String anObjectId,
		     @MatrixParam("saveas") Boolean forceDownload
		     )
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

		GETMongoDMSFile bl = new GETMongoDMSFile(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aUrlSite, aUrlLanguage, aDbName, aCollection, anObjectId, forceDownload != null ? forceDownload.booleanValue() : false);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
}
