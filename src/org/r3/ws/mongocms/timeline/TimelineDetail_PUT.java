package org.r3.ws.mongocms.timeline;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.timelinecollection.TimelineCollectionDTO;
import org.r3.db.mongo.timelinecollection.TimelineCollectionPersistence;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class TimelineDetail_PUT extends ServicePattern
{	
    private TimelineActionForm actionForm;
    private String timelineId;
    
	public TimelineDetail_PUT(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aTimelineId, TimelineActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		timelineId = aTimelineId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		MongoPersistenceContext mctx = pcfg.getMongoPersistenceContext();
		Datastore mongoDatastore = mctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		
		TimelineCollectionPersistence up = TimelineCollectionPersistence.createPersistenceObject(mctx);
		TimelineCollectionDTO post = up.selectBySiteTimelineid(mongoDatastore, senv.getRequestSiteId(), timelineId);
		
		UpdateOperations<TimelineCollectionDTO> uop = actionForm.getUpdateOperation(mongoDatastore, post);
		up.updateBySiteTimelineid(mongoDatastore, uop, senv.getRequestSiteId(), timelineId);				
		
	    LUTManager.getLUTManager().invalidateLUT(LUTName.timeline);
	    
		return post;
	}

}
