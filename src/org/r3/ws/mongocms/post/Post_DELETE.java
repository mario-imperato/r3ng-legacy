package org.r3.ws.mongocms.post;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.filecollection.FileCollectionPersistence;
import org.r3.db.mongo.postcollection.PostCollectionPersistence;
import org.r3.db.mongo.postcommentcollection.PostCommentCollectionPersistence;
import org.r3.db.mongo.usercollection.UserCollectionPersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class Post_DELETE extends ServicePattern
{
    private String postId;
    
	public Post_DELETE(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aPostId)
	{
		super(ctx, serviceEnvironment);
		postId = aPostId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		MongoPersistenceContext mctx = pcfg.getMongoPersistenceContext();
		Datastore mongoDatastore = mctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		
		PostCollectionPersistence tlp = PostCollectionPersistence.createPersistenceObject(mctx);
		tlp.removeBySitePostid(mongoDatastore, senv.getRequestSiteId(), postId);
		
		PostCommentCollectionPersistence tlpc = PostCommentCollectionPersistence.createPersistenceObject(mctx);
		tlpc.removeBySitePostid(mongoDatastore, senv.getRequestSiteId(), postId);
		
		UserCollectionPersistence userCollPersistence = UserCollectionPersistence.createPersistenceObject(mctx);
		userCollPersistence.updateUserAnalyticsOnPostUpdateRemove(mongoDatastore, senv.getUserProfile().getUserid());
		
		FileCollectionPersistence flp = FileCollectionPersistence.createPersistenceObject(mctx);
		flp.removeBySiteRefInfo(mongoDatastore, senv.getRequestSiteId(), null, null, postId);
		return RestServiceDTO.SuccessDTO;
	}

}
