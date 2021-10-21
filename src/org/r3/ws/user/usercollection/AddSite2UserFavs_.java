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
import org.r3.db.system.user.userrole.UserRoleDTO;
import org.r3.db.system.user.userrole.UserRoleFilter;
import org.r3.db.system.user.userrole.UserRolePersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class AddSite2UserFavs_ extends ServicePattern
{
    
	public AddSite2UserFavs_(ServletContext ctx,  ServiceEnvironment serviceEnvironment)
	{
		super(ctx, serviceEnvironment);		
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		MongoPersistenceContext mctx = pcfg.getMongoPersistenceContext();
		Datastore mongoDatastore = mctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		
		UserCollectionPersistence up = UserCollectionPersistence.createPersistenceObject(mctx);
		up.addSite2Favsite(mongoDatastore, senv.getUserProfile().getUserid(), senv.getRequestSiteId());
		
		UserRolePersistence p2 = UserRolePersistence.createPersistenceObject(pcfg, aSession);
	    UserRoleFilter userFilter = new UserRoleFilter();
	    
	    userFilter.or().andUseridEqualTo(senv.getUserProfile().getUserid()).andRoleidEqualTo("shkfollower");
	    UserRoleDTO roleDto = p2.selectBySiteUseridRoleid(senv.getRequestSiteId(), senv.getUserProfile().getUserid(), "shkfollower", pcfg.getPersistenceConfigInfo());
	    if (roleDto == null)
	    {
	    	roleDto = new UserRoleDTO();
	    	roleDto.setSite(senv.getRequestSiteId());
	    	roleDto.setUserid(senv.getUserProfile().getUserid());
	    	roleDto.setRoleid("shkfollower");
	        p2.insert(roleDto,  pcfg.getPersistenceConfigInfo());            	            
	    }
				    
	    LUTManager.getLUTManager().invalidateLUT(LUTName.userprofile);
	    
		return RestServiceDTO.SuccessDTO;
	}

}
