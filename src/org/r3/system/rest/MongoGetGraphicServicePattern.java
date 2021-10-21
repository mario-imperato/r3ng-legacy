package org.r3.system.rest;

import javax.servlet.ServletContext;

import org.mongodb.morphia.Datastore;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.mongo.MongoImageDTO.MongoImageRole;
import org.r3.db.mongo.filecollection.FileCollectionPersistence;
import org.r3.db.mongo.filecollection.FileCollectionUrl;
import org.r3.db.mongo.sitecollection.SiteCollectionDTO;
import org.r3.db.mongo.sitecollection.SiteCollectionDTO.SiteImageRole;
import org.r3.db.mongo.sitecollection.SiteCollectionPersistence;

public abstract class MongoGetGraphicServicePattern extends ServicePattern
{

	public MongoGetGraphicServicePattern(ServletContext ctx,  ServiceEnvironment serviceEnvironment)
	{
		super(ctx, serviceEnvironment);
	}

	protected byte[] getURLContent(MongoPersistenceContext mpctx, String aMongoUrl)
	{
		if (aMongoUrl != null)
		{
			FileCollectionUrl furl = FileCollectionUrl.newInstance(aMongoUrl);
			if (furl != null)
			{
				FileCollectionPersistence fp = FileCollectionPersistence.createPersistenceObject(mpctx);
				return fp.getUrlAsByteArray(mpctx, furl);
			}
		}
		
		return null;
	}
	
	protected byte[] getSiteGraphicByRole(MongoPersistenceContext mpctx, String aSite, MongoImageRole aMajorRole, SiteImageRole aMinorRole)
	{
		Datastore mongoDatastore = mpctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		
		SiteCollectionPersistence p = SiteCollectionPersistence.createPersistenceObject(mpctx);
		
		SiteCollectionDTO dto1 = p.selectBySite(mongoDatastore, aSite);
		if (dto1 != null)
		{
			String u = dto1.getPhotoUrlByRole(aMajorRole, aMinorRole);
			return getURLContent(mpctx, u);			
		}				
		
		return null;
	}
}
