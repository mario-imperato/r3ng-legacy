package org.r3.ws.mongocms.post;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.postcollection.PostCollectionDTO;
import org.r3.db.mongo.postcollection.PostCollectionDTO.StatusType;
import org.r3.db.mongo.postcollection.PostCollectionPersistence;
import org.r3.db.mongo.usercollection.UserCollectionPersistence;
import org.r3.db.system.siteproperty.SitePropertyDTO;
import org.r3.db.system.siteproperty.SitePropertyPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.system.social.facebook.AppInfo;

public class PostContent_PUT extends ServicePattern
{
	public enum UpdateModeSection { generalInfo, textBody, content, publish };
	
    private PostActionForm actionForm;
    private String postId;
    private String languageCode;
    private UpdateModeSection updateMode;
    
	public PostContent_PUT(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String anOverrideSite, UpdateModeSection anUpdateMode, String aPostId, String aLanguage, PostActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		postId = aPostId;
		languageCode = aLanguage;
		updateMode = anUpdateMode;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		MongoPersistenceContext mctx = pcfg.getMongoPersistenceContext();
		Datastore mongoDatastore = mctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		
		PostCollectionPersistence up = PostCollectionPersistence.createPersistenceObject(mctx);
		PostCollectionDTO post = up.selectBySitePostid(mongoDatastore, senv.getRequestSiteId(), postId, false);
		
		UpdateOperations<PostCollectionDTO> uop = null;
		switch(updateMode)
		{
		case generalInfo:
			uop = actionForm.getUpdateGeneralInfoOperation(mongoDatastore, post);
			break;
			
		case content:
			uop = actionForm.getUpdateOperation4Content(mongoDatastore,post);
			break;
			
		case textBody:
			uop = actionForm.getUpdateTextBodyOperation(mongoDatastore, post, languageCode);
			break;
			
		case publish:
			uop = actionForm.getUpdatePublishingInfoOperation(mongoDatastore, post, StatusType.published);
			break;
					
		}
		
		up.updateBySitePostid(mongoDatastore, uop, senv.getRequestSiteId(), postId);				
		
		UserCollectionPersistence userCollPersistence = UserCollectionPersistence.createPersistenceObject(mctx);
		userCollPersistence.updateUserAnalyticsOnPostUpdateRemove(mongoDatastore, senv.getUserProfile().getUserid());		

		if (updateMode == UpdateModeSection.publish && actionForm.getPublish2facebookAsBoolean())
		{
			boolean published = false;

			SitePropertyPersistence siptePropertyPersistence = SitePropertyPersistence.createPersistenceObject(pcfg, aSession);
			List<SitePropertyDTO> listOf = siptePropertyPersistence.selectPropertiesInPropertyScope(senv.getRequestSiteId(), SitePropertyDTO.FB_PAGEPUB_SCOPE, pcfg.getPersistenceConfigInfo());
		
			String aPageId = SitePropertyDTO.getPropertyFromList(listOf, SitePropertyDTO.FB_PAGEPUB_SCOPE, SitePropertyDTO.FB_PAGEPUB_PAGEID);
			String aPageToken = SitePropertyDTO.getPropertyFromList(listOf, SitePropertyDTO.FB_PAGEPUB_SCOPE, SitePropertyDTO.FB_PAGEPUB_PAGETOKEN);						
			
			if (aPageId != null && aPageToken != null)
			{
				System.out.println("Update To FaceBook...2" + aPageId);
				
				String m = "Hello Guys. Hope Tomorrow Doesn't Turn Into A Nightmare.";			
				AppInfo appInfo = AppInfo.retrieveAppInfo(senv.getServerName());
				if (appInfo != null && appInfo.isValid())
				{
					appInfo.post2FaceBookPage(aPageId, aPageToken, m);
				}				
			}
			
			else
			{
				System.out.println("Invalid Facebook Setup");
			}
			
		}
		
		return post;
	}

}
