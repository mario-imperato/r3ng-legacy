package org.r3.ws.mongocms.post;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.postcollection.PostCollectionDTO;
import org.r3.db.mongo.postcollection.PostCollectionPersistence;
import org.r3.db.mongo.usercollection.UserCollectionPersistence;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class POSTAddPost extends ServicePattern
{
    private PostActionForm actionForm;
    
	public POSTAddPost(ServletContext ctx,  ServiceEnvironment serviceEnvironment, PostActionForm anActionForm)
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
		
		PostCollectionDTO dto = actionForm.getDTO4Insert(senv.getRequestSiteId(), senv.getRequestSiteDomain(), theUser.getUserid(), theUser.getLastname());
		tlp.insert(dto, mongoDatastore);
						
		UserCollectionPersistence userCollPersistence = UserCollectionPersistence.createPersistenceObject(mctx);
		userCollPersistence.updateUserAnalyticsOnPostInsert(mongoDatastore, theUser.getUserid(), dto.getAuthor(), dto.getAuthortype());
		
		return dto;
	}

}
