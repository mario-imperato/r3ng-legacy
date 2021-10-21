package org.r3.ws.mongocms.post;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.MongoImageIconDTO;
import org.r3.db.mongo.filecollection.FileCollectionDTO.FileStatus;
import org.r3.db.mongo.filecollection.FileCollectionPersistence;
import org.r3.db.mongo.postcollection.PostCollectionDTO;
import org.r3.db.mongo.postcollection.PostCollectionPersistence;
import org.r3.db.mongo.usercollection.UserCollectionPersistence;
import org.r3.db.utils.MongoUtils;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PUTUpdatePostInTimeline extends ServicePattern
{
    private PostActionForm actionForm;
    private String postId;
    
	public PUTUpdatePostInTimeline(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aPostId, PostActionForm anActionForm)
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
		
		PostCollectionPersistence up = PostCollectionPersistence.createPersistenceObject(mctx);
		PostCollectionDTO post = up.selectBySitePostid(mongoDatastore, senv.getRequestSiteId(), postId, false);		
		
		MongoImageIconDTO actionFormPhoto = actionForm.getPhotoAsMongoImageIconDTO();
		boolean photoHasBeenChanged = post.photoHasBeenChanged(actionFormPhoto);
		if (photoHasBeenChanged)
		{
			MongoImageIconDTO currentPhoto = post.getPhoto();
			
			FileCollectionPersistence fcp = FileCollectionPersistence.createPersistenceObject(mctx);

			// La vecchia immagine viene cancellata
			if (currentPhoto != null)
			{
				fcp.removeMasterfileBySiteFileid(mongoDatastore, senv.getRequestSiteId(), MongoUtils.getObjectIdFromString(currentPhoto.getImageiconid()));
			}

			// La nuova immagine viene marcata permanent
			if (actionFormPhoto != null)
			{
				fcp.updateRefinfoBySiteFileid(mongoDatastore, senv.getRequestSiteId(), actionFormPhoto.getImageiconid(), post.getPostid().toString(), post.getTimeline(), post.getContentclass(), FileStatus.permanent);
			}
		}				
		
		UpdateOperations<PostCollectionDTO> uop = actionForm.getUpdateOperationFromTimeline(mongoDatastore, post);
		if (photoHasBeenChanged)
		{
			if (actionFormPhoto != null)
			{
				post.setPhoto4Update(uop, actionFormPhoto);
			}
			else uop.unset(PostCollectionDTO.PHOTO);
		}
		
		up.updateBySitePostid(mongoDatastore, uop, senv.getRequestSiteId(), postId);
		
//		String[] listOfFiles = actionForm.getListOfPostFiles(); 
//		if (listOfFiles != null)
//		{
//			FileCollectionPersistence fcp = FileCollectionPersistence.createPersistenceObject(mctx);
//			fcp.removeBySiteRefInfo(mongoDatastore, senv.getRequestSiteId(), post.getTimeline(), post.getContentclass(), post.getPostid().toHexString());
//			
//			for(String f : listOfFiles)
//			{
//				if (f != null && f.length() > 0)
//				{
//					FileCollectionUrl u = new FileCollectionUrl(f);					
//					fcp.updateRefinfoBySiteFileid(mongoDatastore, senv.getRequestSiteId(), u.getOid(), post.getTimeline(), post.getContentclass(), post.getPostid());
//				}
//			}
//		}
		
		UserCollectionPersistence userCollPersistence = UserCollectionPersistence.createPersistenceObject(mctx);
		userCollPersistence.updateUserAnalyticsOnPostUpdateRemove(mongoDatastore, senv.getUserProfile().getUserid());
		
		return post;
	}

}
