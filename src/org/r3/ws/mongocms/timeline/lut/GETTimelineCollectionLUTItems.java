package org.r3.ws.mongocms.timeline.lut;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.timelinecollection.TimelineCollectionDTO;
import org.r3.db.mongo.timelinecollection.TimelineCollectionPersistence;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.system.rest.LUTConditionalGetPattern;
import org.r3.system.rest.ServiceEnvironment;

public class GETTimelineCollectionLUTItems extends LUTConditionalGetPattern
{
	
	public GETTimelineCollectionLUTItems(ServletContext ctx,  ServiceEnvironment serviceEnvironment)
	{
		super(ctx, serviceEnvironment, LUTName.timeline.toString());
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		MongoPersistenceContext mpctx = pcfg.getMongoPersistenceContext();		
		Datastore datastore = mpctx.getDatastore(MongoDbSchemaInfo.MongoDbName);	

		TimelineCollectionPersistence p = TimelineCollectionPersistence.createPersistenceObject(mpctx);
		Query<TimelineCollectionDTO> query = datastore.createQuery(TimelineCollectionDTO.class);
		query.field(TimelineCollectionDTO.SITE).equal(senv.getRequestSiteId()); 		

		return p.query(query, "1", 0, -1, false);
	}

}
