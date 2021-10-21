package org.r3.system.rest;


import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.site.SiteDTO;
import org.r3.system.ServicePatternException;
import org.r3.system.UnauthorizedException;
import org.r3.system.UnauthorizedException.UnauthorizedExceptionReason;
import org.r3.system.WebAuthInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ServicePattern
{
	protected static Logger logger = LoggerFactory.getLogger(ServicePattern.class);
	
	// protected SqlSessionFactory sessionFactory = null;
	protected UriInfo            uriInfo = null;
	protected ServiceEnvironment senv;
	
	public void setUriInfo(UriInfo uInfo)
	{
         uriInfo = uInfo;    		
	}

	public ServicePattern(ServletContext ctx, ServiceEnvironment serviceEnvironment)
	{
		// sessionFactory = (SqlSessionFactory) ctx.getAttribute("sqlSessionFactory");
		senv = serviceEnvironment;
	}
	
	public ServiceEnvironment getServiceEnvironment()
	{
		return senv;
	}
	
	public WebAuthInfo getWebAuthInfo()
	{
	    if (senv != null)
	    	return senv.getAuthInfo();
	    
	    return null;
	}

	public SiteDTO getRequestSite()
	{
	    if (senv != null)
	    	return senv.getRequestSite();
	    
	    return null;
	}

	protected abstract Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException;
	
	public Response process(Request request)
	{
		PersistenceContext pcfg = PersistenceContext.getPersistenceContext();
		SqlSession session = pcfg.openSession();
		try
		{
			senv.processAuthorization();		

			Object responseData = process(pcfg, session);			
			session.commit();
			
			ResponseBuilder builder = getResponseBuilder(responseData);

//			if (responseData instanceof File)
//			{
//				File f = ((File)responseData);
//			    System.out.println("Content-length is: " + f.length());
//			    builder.header("Content-length", String.valueOf(f.length()));
//			}

			String m = getMediaType();
			if (m != null)
			{
				// System.out.println("Media Type: " + m);
				builder.type(m);
			}
			
			Map<String, String> retHeaders = returningHeaders();
			if (retHeaders != null)
			{
			    for(String hName : retHeaders.keySet())
			    {
			    	builder.header(hName, retHeaders.get(hName));
			    }
			}


			
			NewCookie c = returningCookies();
			if (c != null)
				builder.cookie(c);
			
			CacheControl ca = getCacheControl();
			if (ca != null)
				builder.cacheControl(ca);
			
			return builder.build();
		}
		catch (UnauthorizedException e)
		{			
			e.printStackTrace();
			ResponseBuilder builder = Response.status(Response.Status.FORBIDDEN);
			builder.entity(new RestServiceDTO(RestServiceDTO.Status.fail, e.getExceptionReason().toString(), e.getMessage()));
			return builder.build();
		}		
		catch(LoginFailedException e1)
		{
			ResponseBuilder builder = Response.status(Response.Status.UNAUTHORIZED);
			builder.entity(new RestServiceDTO(RestServiceDTO.Status.fail, UnauthorizedExceptionReason.loginfailed.toString(), e1.getMessage()));
			return builder.build();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}

		throw new WebApplicationException(Response.Status.SERVICE_UNAVAILABLE);
	}

	protected String getMediaType()
	{
		return null;
	}
	
	protected NewCookie returningCookies()
	{
		return null;
	}

	protected Map<String, String> returningHeaders()
	{		    
		return null;
	}
	
	protected ResponseBuilder getResponseBuilder(Object responseData)
	{
		ResponseBuilder builder = null;
		
		if (responseData != null)
		    builder = Response.ok(responseData);
		else 
			builder = Response.noContent();

		return builder;
	}
		
	public Response redirect(String aLocation)
	{		
		UriBuilder b = uriInfo.getBaseUriBuilder();
		b.path(aLocation);		
		URI u = b.build();
		
		ResponseBuilder builder = Response.temporaryRedirect(u);			
		return builder.build();
	}	

	protected CacheControl getCacheControl()
	{
		CacheControl cc = new CacheControl();
		cc.setNoCache(true);		
		return cc;
	}
    
//	protected FileUploadDTO storeFile(DMSContext aDmsContext, DMSFolder dmsFolder, File aFile, String overrideFileName) throws DMSException
//	{
//		FileUploadDTO fileInfo = null;
//		DMSFileMetadata metadata = getFileMetadata(aFile, overrideFileName);
//
//		DMSFile theFile = dmsFolder.addFile(aDmsContext, aFile, metadata, DMSFolderAddFileMode.NEWNAMEIFPRESENT);
//		fileInfo = new FileUploadDTO(metadata.getFileName(), metadata.getClientFileName(), metadata.getContentType(), metadata.getContentLength(), theFile.getFileUrl()
//						.getUrl());
//
//		return fileInfo;
//	}
//	
//	protected DMSFileMetadata getFileMetadata(File aFile, String overrideFileName)
//	{
//		String fName = aFile.getName();		
//		DMSFileMetadata metadata = new DMSFileMetadata();
//
//		if (overrideFileName != null)
//		{
//			metadata.setFileName(overrideFileName);
//			metadata.setClientFileName(fName);
//		}
//		else			
//			metadata.setFileName(fName);
//		
//		metadata.setContentLength(aFile.length());
//		metadata.setCreationDate();
//		metadata.setContentType(ContentTypeUtil.findMimeType(fName));
//		return metadata;
//	}

}
