package org.r3.ws.mongocms.post;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.postcommentcollection.PostCommentCollectionDTO;
import org.r3.db.mongo.postcommentcollection.PostCommentCollectionDataTableAdapter;
import org.r3.db.mongo.postcommentcollection.PostCommentCollectionPersistence;
import org.r3.db.utils.MongoUtils;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETPostComments extends ServicePattern
{
    private PostCommentQueryActionForm queryForm;
    private String postId;
    
	public GETPostComments(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aPostId, PostCommentQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
		postId = aPostId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		MongoPersistenceContext mpctx = pcfg.getMongoPersistenceContext();		
		Datastore datastore = mpctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		
		PostCommentCollectionPersistence p = PostCommentCollectionPersistence.createPersistenceObject(mpctx);		
		Query<PostCommentCollectionDTO> query = queryForm.getSearchCondition(datastore, getServiceEnvironment().getRequestSiteId(), MongoUtils.getObjectIdFromString(postId));
		
		PostCommentCollectionDataTableAdapter dt = null;
		if (query != null)
		   dt = p.query(query, queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
				
		return dt;				
	}



}
