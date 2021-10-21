package org.r3.ws.mongocms.timeline;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.timelinecollection.TimelineCollectionDTO;
import org.r3.db.mongo.timelinecollection.TimelineCollectionDataTableAdapter;
import org.r3.db.mongo.timelinecollection.TimelineCollectionPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETTimelines extends ServicePattern
{
    private TimelineQueryActionForm queryForm;
    
	public GETTimelines(ServletContext ctx,  ServiceEnvironment serviceEnvironment, TimelineQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		MongoPersistenceContext mpctx = pcfg.getMongoPersistenceContext();		
		Datastore datastore = mpctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		
		TimelineCollectionPersistence p = TimelineCollectionPersistence.createPersistenceObject(mpctx);		
		Query<TimelineCollectionDTO> query = queryForm.getSearchCondition(datastore, getServiceEnvironment().getRequestSiteId());
		// query.retrievedFields(true, TimelineCollectionDTO.SIMPLETYPE_ATTRIBUTES_CSVLIST);
		
		TimelineCollectionDataTableAdapter dt = null;
		if (query != null)
		   dt = p.query(query, queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
				
		return dt;				
	}



}
