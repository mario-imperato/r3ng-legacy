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
import org.r3.db.mongo.postcommentcollection.PostCommentCollectionDTO;
import org.r3.db.mongo.postcommentcollection.PostCommentCollectionPersistence;
import org.r3.db.mongo.usercollection.UserCollectionPersistence;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.db.utils.MongoUtils;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PostComment_PUT extends ServicePattern
{
	public enum UpdateVerb { 
		update, shake, unshake;
		
		public static UpdateVerb getValue4(String s, UpdateVerb defaultValue)
		{
			if (s != null && s.length() > 0)
				return UpdateVerb.valueOf(s);
			
			return defaultValue;
		}
	};
	
	private UpdateVerb updateVerb;
    private String postId;
    private String commentId;
    private PostActionForm actionForm;
    
	public PostComment_PUT(
			ServletContext ctx,  ServiceEnvironment serviceEnvironment, UpdateVerb anUpdateVerb, 
			String aPostId, String aCommentId, PostActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		updateVerb = anUpdateVerb;
		postId = aPostId;
		commentId = aCommentId;
		actionForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		MongoPersistenceContext mctx = pcfg.getMongoPersistenceContext();
		Datastore mongoDatastore = mctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		UserProfileViewDTO theUser = senv.getUserProfile();
		
		PostCommentCollectionPersistence tlccp = PostCommentCollectionPersistence.createPersistenceObject(mctx);
		PostCommentCollectionDTO commentDTO = tlccp.selectByCommentid(mongoDatastore, MongoUtils.getObjectIdFromString(commentId));
		if (commentDTO == null)
		{
			// Ho un problema... mi è stato cancellato sotto ....
			return RestServiceDTO.FailDTO;
		}
		
		// A questo punto procedo alla rimozione dell'elemento dalla collection... Visto che è un sottoelemento lo cancello
		// e lo reinserisco. Magari c'e' un metodo migliore.		
		PostCollectionPersistence tlp = PostCollectionPersistence.createPersistenceObject(mctx);
		
		UpdateOperations<PostCollectionDTO> uop = mongoDatastore.createUpdateOperations(PostCollectionDTO.class);
		CommentsDTO dto2Remove = new CommentsDTO();
		dto2Remove.setCommentid(commentId);
		uop.removeAll(PostCollectionDTO.COMMENTS, dto2Remove);
		tlp.updateBySitePostid(mongoDatastore, uop, senv.getRequestSiteId(), postId);

		// Aggiorno la collection commenti...
		commentDTO = actionForm.getDTO4UpdateComment(mongoDatastore, updateVerb, commentDTO, theUser.getUserid(), theUser.getLastname());
		mongoDatastore.save(commentDTO);
		
		// Inserisco il nuovo dato nell'array...	
		UpdateOperations<PostCollectionDTO> uop1 = actionForm.getAddComment2PostOperation(mongoDatastore, commentDTO);
		tlp.updateBySitePostid(mongoDatastore, uop1, senv.getRequestSiteId(), postId);
		
		UserCollectionPersistence userCollPersistence = UserCollectionPersistence.createPersistenceObject(mctx);
		userCollPersistence.updateUserAnalyticsOnCommentUpdateRemove(mongoDatastore, theUser.getUserid());

		return commentDTO;
	}

}
