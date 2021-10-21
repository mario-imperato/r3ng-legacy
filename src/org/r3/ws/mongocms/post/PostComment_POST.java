package org.r3.ws.mongocms.post;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.postcollection.PostCollectionDTO;
import org.r3.db.mongo.postcollection.PostCollectionPersistence;
import org.r3.db.mongo.postcommentcollection.PostCommentCollectionDTO;
import org.r3.db.mongo.postcommentcollection.PostCommentCollectionPersistence;
import org.r3.db.mongo.usercollection.UserCollectionPersistence;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PostComment_POST extends ServicePattern
{
    private PostActionForm actionForm;
    private String postId;
    
	public PostComment_POST(ServletContext ctx,  ServiceEnvironment serviceEnvironment,  String aPostId, PostActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		postId = aPostId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		MongoPersistenceContext mctx = pcfg.getMongoPersistenceContext();
		Datastore mongoDatastore = mctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		
		PostCommentCollectionPersistence tlp = PostCommentCollectionPersistence.createPersistenceObject(mctx);
		UserProfileViewDTO theUser = senv.getUserProfile();
		PostCommentCollectionDTO dto = actionForm.getDTO4InsertComment(senv.getRequestSiteId(), senv.getRequestSiteDomain(), postId, null, theUser.getUserid(), theUser.getLastname());
		tlp.insert(dto, mongoDatastore);
		
		PostCollectionPersistence tlp1 = PostCollectionPersistence.createPersistenceObject(mctx);		
		UpdateOperations<PostCollectionDTO> uop = actionForm.getAddComment2PostOperation(mongoDatastore, dto);
		tlp1.updateBySitePostid(mongoDatastore, uop, senv.getRequestSiteId(), postId);
		
		UserCollectionPersistence userCollPersistence = UserCollectionPersistence.createPersistenceObject(mctx);
		userCollPersistence.updateUserAnalyticsOnCommentInsert(mongoDatastore, theUser.getUserid(), dto.getAuthor(), dto.getAuthortype());

//		BBSThreadNodePersistence p = BBSThreadNodePersistence.createPersistenceObject(pcfg, aSession);
//		
//		String parentNodeId = actionForm.getNodeparentid();
//		String parentNodePath = null;
//		if (parentNodeId != null)
//		{
//			BBSThreadNodeDTO dtoParent = p.selectByThreadnodeid(parentNodeId, pcfg.getPersistenceConfigInfo());	
//			if (dtoParent != null)
//			{
//				parentNodePath = dtoParent.getNodepath();
//			}
//			else parentNodeId = null;
//		}
//		
//		BBSThreadNodeDTO dto1 = actionForm.getDTO4Insert(senv.getRequestSiteId(), timelineId, threadId, parentNodeId, parentNodePath, senv.getUserProfile().getUserid());		
//	    p.insert(dto1, pcfg.getPersistenceConfigInfo());
//	    
//	    BBSThreadPersistence pthread = BBSThreadPersistence.createPersistenceObject(pcfg, aSession);
//		pthread.updatePostCountersOnAddBySiteThreadid(senv.getRequestSiteId(), threadId, dto1.getThreadnodeid(), pcfg.getPersistenceConfigInfo());

		return dto;
	}

}
