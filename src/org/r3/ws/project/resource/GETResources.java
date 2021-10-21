package org.r3.ws.project.resource;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.ws.rs.core.CacheControl;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.DTOBase;
import org.r3.db.PersistenceContext;
import org.r3.db.project.resource.ResourceCSVStreamingOutput;
import org.r3.db.project.resource.ResourceDataTableAdapter;
import org.r3.db.project.resource.ResourceFilter;
import org.r3.db.project.resource.ResourcePersistence;
import org.r3.system.rest.RestService.OutputFormat;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETResources extends ServicePattern
{
	private static final String csvHeaders = "actorid:Id,firstname:Nome,lastname:Cognome,email:Indirizzo posta elettronica,phone:Ufficio,cellphone:Cellulare,address:via (uff.),zipcode:CAP (uff.),town:Citta (uff.)";
    	
	private ResourceQueryActionForm queryForm;
	private boolean 				limitSearch2Site;
    private OutputFormat            outputFormat;
    
	public GETResources(ServletContext ctx,  ServiceEnvironment serviceEnvironment, ResourceQueryActionForm aQueryForm, boolean limitSearch2SiteFlag, OutputFormat anOutputFormat)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
		outputFormat = anOutputFormat;
		limitSearch2Site = limitSearch2SiteFlag;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{						
		ResourcePersistence p = ResourcePersistence.createPersistenceObject(pcfg, aSession);				
		ResourceFilter filter = queryForm.getSearchCondition(senv.getRequestSiteId(), senv.getRequestSiteDomain(), limitSearch2Site);
		
		ResourceDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());		
		if (outputFormat == OutputFormat.csv)
		{
			// Da correggere. Vedere csvHeaders. Prendere spunto da getActors.
			ResourceCSVStreamingOutput streamer = new ResourceCSVStreamingOutput(dt.getAaData());
	        return streamer;
		}
		
		return dt;
	}

	@Override
	protected CacheControl getCacheControl()
	{		
		return null;
	}

	@Override
	protected Map<String, String> returningHeaders()
	{
		if (outputFormat == OutputFormat.csv)
		{
		    Map<String, String> hs = new HashMap<String, String>(); 	
		    hs.put("Content-Transfer-Encoding", "binary");
		    hs.put("Accept-Ranges", "bytes");
		    hs.put("Content-Encoding", "none");
		    hs.put("Content-Type", "text/csv");
		    // hs.put("Content-length", String.valueOf(contentLength));
		    hs.put("Content-Disposition", String.format("attachment; filename=%s", getDownloadFileName()));
		    
		    System.out.println("Returning Headers");
		    return hs;
		}
		
		return super.returningHeaders();
	}
	
	private String getDownloadFileName()
	{
		return String.format("%s_risorse_%s.csv", senv.getRequestSiteId(), DTOBase.currentTimestampAsFileStampString());		
	}

}
