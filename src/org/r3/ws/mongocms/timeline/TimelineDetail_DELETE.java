package org.r3.ws.mongocms.timeline;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.timelinecollection.TimelineCollectionPersistence;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class TimelineDetail_DELETE extends ServicePattern
{	
    private String timelineId;
    
	public TimelineDetail_DELETE(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aTimelineId)
	{
		super(ctx, serviceEnvironment);
		timelineId = aTimelineId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		MongoPersistenceContext mctx = pcfg.getMongoPersistenceContext();
		Datastore mongoDatastore = mctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		
		TimelineCollectionPersistence up = TimelineCollectionPersistence.createPersistenceObject(mctx);
		up.removeBySiteTimelineid(mongoDatastore, senv.getRequestSiteId(), timelineId);				
		
	    LUTManager.getLUTManager().invalidateLUT(LUTName.timeline);
	    
		return RestServiceDTO.SuccessDTO;
	}

}
