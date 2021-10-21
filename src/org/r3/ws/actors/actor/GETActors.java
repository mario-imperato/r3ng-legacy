package org.r3.ws.actors.actor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.ws.rs.core.CacheControl;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.DTOBase;
import org.r3.db.PersistenceContext;
import org.r3.db.actor.actor.ActorCSVStreamingOutput;
import org.r3.db.actor.actor.ActorDataTableAdapter;
import org.r3.db.actor.actor.ActorFilter;
import org.r3.db.actor.actor.ActorPersistence;
import org.r3.db.system.classifieritem.ClassifierItemDTO;
import org.r3.db.system.classifieritem.ClassifierItemLUT;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.system.rest.RestService.OutputFormat;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETActors extends ServicePattern
{
	private static final String csvHeaders = "actorid:Id,firstname:Nome,lastname:Cognome,email:Indirizzo posta elettronica,phone:Ufficio,cellphone:Cellulare,address:via (uff.),zipcode:CAP (uff.),town:Citta (uff.)";
    private ActorQueryActionForm queryForm;
    private OutputFormat         outputFormat;
    
	public GETActors(ServletContext ctx,  ServiceEnvironment serviceEnvironment, ActorQueryActionForm aQueryForm, OutputFormat anOutputFormat)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
		outputFormat = anOutputFormat;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		ActorPersistence p = ActorPersistence.createPersistenceObject(pcfg, aSession);				
		ActorFilter filter = queryForm.getSearchCondition(senv.getRequestSiteId());
		
		ActorDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		
		if (outputFormat == OutputFormat.csv)
		{
			ClassifierItemLUT theLUT = (ClassifierItemLUT)LUTManager.getLUTManager().getLUT(LUTName.actor_expformat, this.getServiceEnvironment().getRequestLanguage());
			ClassifierItemDTO csvFormat = theLUT.getItem(queryForm.getCsvformat());
			if (csvFormat != null)
			{				
				char csvSeparator = csvFormat.getClassifieritemsattr().charAt(0);
				String csvHeaders = csvFormat.getClassifieritemsattr().substring(1);
			    ActorCSVStreamingOutput streamer = new ActorCSVStreamingOutput(dt.getAaData(), csvHeaders,csvSeparator);
	            return streamer;
			}
			else logger.error(String.format("Formato CSV %s non determinabile.", csvFormat));
			
			return null;
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
		return String.format("%s_contatti_%s.csv", senv.getRequestSiteId(), DTOBase.currentTimestampAsFileStampString());		
	}

}
