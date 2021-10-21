package org.r3.ws.mongocms.post;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.postcollection.PostCollectionDTO;
import org.r3.db.mongo.postcollection.PostCollectionDataTableAdapter;
import org.r3.db.mongo.postcollection.PostCollectionPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETPosts extends ServicePattern
{
    private PostQueryActionForm queryForm;
    
	public GETPosts(ServletContext ctx,  ServiceEnvironment serviceEnvironment, PostQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		MongoPersistenceContext mpctx = pcfg.getMongoPersistenceContext();		
		Datastore datastore = mpctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		
		PostCollectionPersistence p = PostCollectionPersistence.createPersistenceObject(mpctx);		
		Query<PostCollectionDTO> query = queryForm.getSearchCondition(datastore, getServiceEnvironment().getRequestSiteId());
		if (!queryForm.getIncludecommentsAsBoolean())
		query.retrievedFields(false, PostCollectionDTO.COMMENTS);
		
		PostCollectionDataTableAdapter dt = null;
		if (query != null)
		   dt = p.query(query, queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
				
		return dt;				
	}



}
