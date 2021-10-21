package org.r3.ws.system.sitecollection;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.sitecollection.SiteCollectionDTO;
import org.r3.db.mongo.sitecollection.SiteCollectionPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PUTSiteCollectionGeneralInfo extends ServicePattern
{
    private SiteInfoActionForm actionForm;
    private String opSite;
    
	public PUTSiteCollectionGeneralInfo(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aSite, SiteInfoActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		opSite = aSite;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		MongoPersistenceContext mctx = pcfg.getMongoPersistenceContext();
		Datastore mongoDatastore = mctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		
		SiteCollectionPersistence up = SiteCollectionPersistence.createPersistenceObject(mctx);
		UpdateOperations<SiteCollectionDTO> uop = actionForm.getUpdateOperation(mongoDatastore);
		up.updateBySite(mongoDatastore, uop, opSite, true);
		
		return null;
	}
}
