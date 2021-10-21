package org.r3.ws.mongocms.post;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.MongoImageIconDTO;
import org.r3.db.mongo.filecollection.FileCollectionDTO.FileStatus;
import org.r3.db.mongo.filecollection.FileCollectionPersistence;
import org.r3.db.mongo.postcollection.PostCollectionDTO;
import org.r3.db.mongo.postcollection.PostCollectionPersistence;
import org.r3.db.mongo.usercollection.UserCollectionPersistence;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class POSTAddPost2Timeline extends ServicePattern
{
    private PostActionForm actionForm;
    
	public POSTAddPost2Timeline(ServletContext ctx,  ServiceEnvironment serviceEnvironment, PostActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		MongoPersistenceContext mctx = pcfg.getMongoPersistenceContext();
		Datastore mongoDatastore = mctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		
		PostCollectionPersistence tlp = PostCollectionPersistence.createPersistenceObject(mctx);
		UserProfileViewDTO theUser = senv.getUserProfile();
		PostCollectionDTO dto = actionForm.getDTO4InsertFromTimeline(senv.getRequestSiteId(), senv.getRequestSiteDomain(), theUser.getUserid(), theUser.getLastname());
		tlp.insert(dto, mongoDatastore);
		
		FileCollectionPersistence fcp = FileCollectionPersistence.createPersistenceObject(mctx);
		
		// La nuova immagine viene marcata permanent
		MongoImageIconDTO photo = dto.getPhoto();
		if (photo != null)
		{
			fcp.updateRefinfoBySiteFileid(mongoDatastore, senv.getRequestSiteId(), photo.getImageiconid(), dto.getPostid().toString(), dto.getTimeline(), dto.getContentclass(), FileStatus.permanent);
		}
		
//		String[] listOfFiles = actionForm.getListOfPostFiles(); 
//		if (listOfFiles != null)
//		{
//			FileCollectionPersistence fcp = FileCollectionPersistence.createPersistenceObject(mctx);
//			for(String f : listOfFiles)
//			{
//				if (f != null && f.length() > 0)
//				{
//					FileCollectionUrl u = new FileCollectionUrl(f);					
//					fcp.updateRefinfoBySiteFileid(mongoDatastore, senv.getRequestSiteId(), u.getOid(), dto.getPostid().toString(), dto.getTimeline(), dto.getContentclass(), FileStatus.permanent);
//				}
//			}
//		}
		
		UserCollectionPersistence userCollPersistence = UserCollectionPersistence.createPersistenceObject(mctx);
		userCollPersistence.updateUserAnalyticsOnPostInsert(mongoDatastore, theUser.getUserid(), dto.getAuthor(), dto.getAuthortype());
		
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
