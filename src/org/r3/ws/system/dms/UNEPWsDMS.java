package org.r3.ws.system.dms;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import org.r3.system.R3Application;
import org.r3.system.rest.AccessLogInfo;
import org.r3.system.rest.RestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("{site}/{language}/system/dms")
public class UNEPWsDMS extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(UNEPWsDMS.class);

	public static String getDMSUrl4(String aSite, String aLanguage, String aUrl)
	{
		String u = null;
		
	   if (aUrl.startsWith("DMS_FILE:///PUB"))
	   {
		   if (R3Application.DMSPublicURLWWWvisible)
			    u = aUrl.substring("DMS_FILE:///PUB".length());
		   else u = String.format(R3Application.DMSPublicURLMountPoint, aSite, aLanguage,aUrl.substring("DMS_FILE:///PUB/".length()));
	   }	   
	   else if (aUrl.startsWith("DMS_FILE:///"))
	   {
		   u = String.format(R3Application.DMSPrivateURLMountPoint, aSite, aLanguage, aUrl.substring("DMS_FILE:///".length()));
	   }
	   
	   return u;
	   
//	   StringBuilder stb = new StringBuilder();
//	   stb.append("/r3ng/was/").append(aSite).append("/").append(aLanguage).append("/system/dms");
//	   
//	   if (aUrl.startsWith("DMS_FILE://"))
//	   {
//		   stb.append(aUrl.substring("DMS_FILE://".length()));
//	   }
//	   
//	   return stb.toString();
	}
	
//	@GET
//	@Path("initialize")
//	@Produces({ "application/xml", "application/json" })
//	@Consumes("application/x-www-form-urlencoded")
//	public Response initialize(
//		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
//		     @Context Request request,
//		     @Context HttpHeaders headers
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
//	       logger.info(a.start());	 
//	    }
//		
//		PopulateUNEPTree bl = new PopulateUNEPTree(ctx, getServiceEnvironment(ctx, servletRequest, headers));
//		Response response = bl.process(request);
//	    if (a != null)
//	    {
//	       logger.info(a.close());	 
//	    }
//		return response;
//	}
	
	@GET
	@Path("document/{dmsUrl : .+}")
	public Response getDMSFile(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request,
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("dmsUrl") String aDmsUrl,
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

		GETDMSFile bl = new GETDMSFile(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aDmsUrl, forceDownload != null ? forceDownload.booleanValue() : false);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
			
	/* E' solo un metodo di test per l0infame problema della cache..  */
	@GET
	@Path("fileresource/{dmsUrl : .+}")
	public Response getFilesystemResource(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request,
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,		     
		     @PathParam("dmsUrl") String aDmsUrl,
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

		GETFileSystemResourceFile bl = new GETFileSystemResourceFile(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aDmsUrl, forceDownload != null ? forceDownload.booleanValue() : false );
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	
	@GET
	@Path("test/addFile")
	@Produces({ "application/xml", "application/json" })
	@Consumes("application/x-www-form-urlencoded")
	public Response testAddFile(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request,
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage		     
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

		TestAddFile bl = new TestAddFile(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage));
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}

	
}
