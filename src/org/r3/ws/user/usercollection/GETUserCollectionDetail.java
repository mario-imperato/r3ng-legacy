package org.r3.ws.user.usercollection;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.usercollection.UserCollectionDTO;
import org.r3.db.mongo.usercollection.UserCollectionPersistence;
import org.r3.system.WebAuthInfo;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETUserCollectionDetail extends ServicePattern
{
    private String userId;
    
	public GETUserCollectionDetail(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aUserId)
	{
		super(ctx, serviceEnvironment);
		userId = aUserId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		if (!pcfg.isMongoDbAvailable())
			return null;
		
		MongoPersistenceContext mctx = pcfg.getMongoPersistenceContext();
		Datastore mongoDatastore = mctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		
		UserCollectionPersistence p = UserCollectionPersistence.createPersistenceObject(mctx);
						
		if (userId.equalsIgnoreCase("whoami"))
		{
			WebAuthInfo authInfo = getWebAuthInfo(); 
			if (authInfo.isUserNotIdentified())
				return null;	
			
			userId = authInfo.getUserProfile().getUserid();
		}
		
		UserCollectionDTO dto1 = p.selectByUserid(mongoDatastore, userId);
		return dto1;
	}

}
