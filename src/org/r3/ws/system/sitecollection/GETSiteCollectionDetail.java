package org.r3.ws.system.sitecollection;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.sitecollection.SiteCollectionDTO;
import org.r3.db.mongo.sitecollection.SiteCollectionPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETSiteCollectionDetail extends ServicePattern
{
    private String opSite;
    
	public GETSiteCollectionDetail(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aSite)
	{
		super(ctx, serviceEnvironment);
		opSite = aSite;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		if (!pcfg.isMongoDbAvailable())
			return null;
		
		MongoPersistenceContext mpctx = pcfg.getMongoPersistenceContext();
		Datastore mongoDatastore = mpctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		
		SiteCollectionPersistence p = SiteCollectionPersistence.createPersistenceObject(pcfg.getMongoPersistenceContext());
					
		SiteCollectionDTO dto1 = p.selectBySite(mongoDatastore, opSite);
		return dto1;
	}

}
