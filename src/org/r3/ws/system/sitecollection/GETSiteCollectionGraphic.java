package org.r3.ws.system.sitecollection;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.MongoImageDTO.MongoImageRole;
import org.r3.db.mongo.sitecollection.SiteCollectionDTO.SiteImageRole;
import org.r3.system.rest.MongoGetGraphicServicePattern;
import org.r3.system.rest.ServiceEnvironment;

public class GETSiteCollectionGraphic extends MongoGetGraphicServicePattern
{
    private String theSite;
    private MongoImageRole majorRole;
    private SiteImageRole minorRole;
    
	public GETSiteCollectionGraphic(
			ServletContext ctx,  ServiceEnvironment serviceEnvironment, 
			String aUserId, String anImageMajorRole, String anImageMinorRole)
	{
		super(ctx, serviceEnvironment);
		theSite = aUserId;
		majorRole = MongoImageRole.getValue4(anImageMajorRole, MongoImageRole.image);
		minorRole = SiteImageRole.getValue4(anImageMinorRole, SiteImageRole.sitesquared);
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		MongoPersistenceContext mpctx = pcfg.getMongoPersistenceContext();
		// Datastore mongoDatastore = mpctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
	
		byte[] graphicData = getSiteGraphicByRole(mpctx, theSite, majorRole, minorRole);
		
		// Verifico che il sito non sia un sito di dominio. In caso contrario non riprovo su stesso
		if (graphicData == null && !theSite.equalsIgnoreCase(senv.getRequestSiteDomain()))
			graphicData = getSiteGraphicByRole(mpctx, senv.getRequestSiteDomain(), majorRole, minorRole);
						
		return graphicData;
	}

}
