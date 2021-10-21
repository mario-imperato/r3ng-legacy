package org.r3.ws.user.usercollection;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.usercollection.UserCollectionDTO;
import org.r3.db.mongo.usercollection.UserCollectionPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PUTUserCollectionAddress extends ServicePattern
{
    private AddressActionForm actionForm;
    private String userId;
    
	public PUTUserCollectionAddress(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aUserId, AddressActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		userId = aUserId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		MongoPersistenceContext mctx = pcfg.getMongoPersistenceContext();
		Datastore mongoDatastore = mctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		
		UserCollectionPersistence up = UserCollectionPersistence.createPersistenceObject(mctx);
		UpdateOperations<UserCollectionDTO> uop = actionForm.getUpdateOperation(mongoDatastore);
		up.updateByUserid(mongoDatastore, uop, userId, true);
		
		return null;
	}
}
