package org.r3.ws.system.mongo.lut;


import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.bson.Document;
import org.mongodb.morphia.Datastore;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.lutcollection.LUTCollectionPersistence;
import org.r3.system.rest.LUTConditionalGetPattern;
import org.r3.system.rest.ServiceEnvironment;

public class ConditionallyGETLUTCollectionItems extends LUTConditionalGetPattern
{
    private String     classifierId = null;
   
    public ConditionallyGETLUTCollectionItems(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aClassifierId)
	{
		super(ctx, serviceEnvironment, aClassifierId);
		classifierId = aClassifierId;
	}
		
	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		Document dt = getData(pcfg, aSession, classifierId);
		return dt;
	}

	private Document getData(PersistenceContext pcfg, SqlSession sqlSession, String aClassifierId)
	{
		MongoPersistenceContext mpctx = pcfg.getMongoPersistenceContext();		
		Datastore datastore = mpctx.getDatastore(MongoDbSchemaInfo.MongoDbName);	

		LUTCollectionPersistence p = LUTCollectionPersistence.createPersistenceObject(mpctx);
		Document d = p.rawSelectByLUTNameSite(mpctx, aClassifierId, senv.getRequestSiteDomain(), senv.getRequestSiteId());				

		return d;
	}

}
