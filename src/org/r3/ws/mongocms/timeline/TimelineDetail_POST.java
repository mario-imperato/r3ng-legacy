package org.r3.ws.mongocms.timeline;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.timelinecollection.TimelineCollectionDTO;
import org.r3.db.mongo.timelinecollection.TimelineCollectionPersistence;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class TimelineDetail_POST extends ServicePattern
{
    private TimelineActionForm actionForm;
    
	public TimelineDetail_POST(ServletContext ctx,  ServiceEnvironment serviceEnvironment, TimelineActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		MongoPersistenceContext mctx = pcfg.getMongoPersistenceContext();
		Datastore mongoDatastore = mctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		
		TimelineCollectionPersistence tlp = TimelineCollectionPersistence.createPersistenceObject(mctx);
		UserProfileViewDTO theUser = senv.getUserProfile();
		
		TimelineCollectionDTO dto = actionForm.getDTO4Insert(senv.getRequestSiteId(), senv.getRequestSiteDomain(), theUser.getUserid(), theUser.getLastname());
		tlp.insert(dto, mongoDatastore);
						
	    LUTManager.getLUTManager().invalidateLUT(LUTName.timeline);
	    
		return dto;
	}

}
