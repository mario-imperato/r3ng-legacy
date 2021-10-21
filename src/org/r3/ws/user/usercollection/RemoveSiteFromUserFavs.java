package org.r3.ws.user.usercollection;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.usercollection.UserCollectionPersistence;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.user.userrole.UserRolePersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class RemoveSiteFromUserFavs extends ServicePattern
{
    
	public RemoveSiteFromUserFavs(ServletContext ctx,  ServiceEnvironment serviceEnvironment)
	{
		super(ctx, serviceEnvironment);		
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		MongoPersistenceContext mctx = pcfg.getMongoPersistenceContext();
		Datastore mongoDatastore = mctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		
		UserCollectionPersistence up = UserCollectionPersistence.createPersistenceObject(mctx);
		up.removeSiteFromFavsite(mongoDatastore, senv.getUserProfile().getUserid(), senv.getRequestSiteId());
		
		UserRolePersistence p2 = UserRolePersistence.createPersistenceObject(pcfg, aSession);
	    p2.deleteBySiteUseridRoleid(senv.getRequestSiteId(), senv.getUserProfile().getUserid(), "shkfollower", pcfg.getPersistenceConfigInfo());
	    		    
	    LUTManager.getLUTManager().invalidateLUT(LUTName.userprofile);
	    
		return RestServiceDTO.SuccessDTO;
	}

}
