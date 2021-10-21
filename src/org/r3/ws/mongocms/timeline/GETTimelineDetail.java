package org.r3.ws.mongocms.timeline;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.timelinecollection.TimelineCollectionDTO;
import org.r3.db.mongo.timelinecollection.TimelineCollectionPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETTimelineDetail extends ServicePattern
{
    protected String timelineId;
    
	public GETTimelineDetail(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aCardId)
	{
		super(ctx, serviceEnvironment);
		timelineId = aCardId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		MongoPersistenceContext mpctx = pcfg.getMongoPersistenceContext();		
		Datastore datastore = mpctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		
		TimelineCollectionPersistence p = TimelineCollectionPersistence.createPersistenceObject(mpctx);		
		TimelineCollectionDTO dto = p.selectBySiteTimelineid(datastore, senv.getRequestSiteId(), timelineId);		
				
		return dto;			
	}

}
