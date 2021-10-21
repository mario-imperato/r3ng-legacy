package org.r3.ws.user.usercollection;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.MongoImageDTO.MongoImageRole;
import org.r3.db.mongo.sitecollection.SiteCollectionDTO.SiteImageRole;
import org.r3.db.mongo.usercollection.UserCollectionDTO;
import org.r3.db.mongo.usercollection.UserCollectionPersistence;
import org.r3.system.rest.MongoGetGraphicServicePattern;
import org.r3.system.rest.ServiceEnvironment;

public class GETUserCollectionPhoto extends MongoGetGraphicServicePattern
{
    private String userId;
    private MongoImageRole imageRole;
    
	public GETUserCollectionPhoto(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aUserId, String anImageRole)
	{
		super(ctx, serviceEnvironment);
		userId = aUserId;
		imageRole = MongoImageRole.getValue4(anImageRole, MongoImageRole.image);
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		byte[] graphicData = null;
		
		MongoPersistenceContext mpctx = pcfg.getMongoPersistenceContext();
		Datastore mongoDatastore = mpctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
	
		UserCollectionPersistence p = UserCollectionPersistence.createPersistenceObject(mpctx);
						
		UserCollectionDTO dto1 = p.selectByUserid(mongoDatastore, userId);
		if (dto1 != null)
		{
			String u = dto1.getPhotoUrlByRole(imageRole);
			graphicData = this.getURLContent(mpctx, u);
		}
		
		if (graphicData == null)
		{
			graphicData = getSiteGraphicByRole(mpctx, senv.getRequestSiteDomain(), imageRole, SiteImageRole.userphoto);
		}
		return graphicData;
	}

}
