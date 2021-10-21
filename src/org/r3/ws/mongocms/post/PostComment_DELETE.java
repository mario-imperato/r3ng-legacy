package org.r3.ws.mongocms.post;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.postcollection.PostCollectionDTO;
import org.r3.db.mongo.postcollection.PostCollectionDTOBase.CommentsDTO;
import org.r3.db.mongo.postcollection.PostCollectionPersistence;
import org.r3.db.mongo.postcommentcollection.PostCommentCollectionPersistence;
import org.r3.db.mongo.usercollection.UserCollectionPersistence;
import org.r3.db.utils.MongoUtils;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PostComment_DELETE extends ServicePattern
{
    private String postId;
    private String commentId;
    
	public PostComment_DELETE(
			ServletContext ctx,  ServiceEnvironment serviceEnvironment, 
			String aPostId, String aCommentId)
	{
		super(ctx, serviceEnvironment);
		postId = aPostId;
		commentId = aCommentId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		MongoPersistenceContext mctx = pcfg.getMongoPersistenceContext();
		Datastore mongoDatastore = mctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		
		PostCommentCollectionPersistence pcp = PostCommentCollectionPersistence.createPersistenceObject(mctx);
		pcp.rawRemoveByCommentid(mctx, MongoUtils.getObjectIdFromString(commentId));
		
		PostCollectionPersistence tlp = PostCollectionPersistence.createPersistenceObject(mctx);
		UpdateOperations<PostCollectionDTO> uop = mongoDatastore.createUpdateOperations(PostCollectionDTO.class);
		CommentsDTO dto2Remove = new CommentsDTO();
		dto2Remove.setCommentid(commentId);
		uop.removeAll(PostCollectionDTO.COMMENTS, dto2Remove);
		tlp.updateBySitePostid(mongoDatastore, uop, senv.getRequestSiteId(), postId);

		UserCollectionPersistence userCollPersistence = UserCollectionPersistence.createPersistenceObject(mctx);
		userCollPersistence.updateUserAnalyticsOnCommentUpdateRemove(mongoDatastore, senv.getUserProfile().getUserid());
		
		return RestServiceDTO.SuccessDTO;
	}

}
