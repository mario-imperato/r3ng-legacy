//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//

package org.r3.db.mongo.lutcollection;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.system.siteproperty.SitePropertyDTO.SiteIdentifier;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class LUTCollectionPersistence 
{
	public static LUTCollectionPersistence createPersistenceObject(org.r3.db.MongoPersistenceContext pcfg)
	{
		LUTCollectionPersistence p = new LUTCollectionPersistence();
		return p;
	}

	public Document rawSelectByLUTNameSite(org.r3.db.MongoPersistenceContext mpctx, java.lang.String aLUTName, java.lang.String aSiteDomain, java.lang.String aSite) 
	{
		MongoDatabase db = mpctx.getMongoDbClient().getDatabase(MongoDbSchemaInfo.MongoDbName);
		MongoCollection<Document> coll = db.getCollection(MongoDbSchemaInfo.MongoDbLUTCollectionName);
		
		Bson orFilter = Filters.or(Filters.eq("site", aSite), Filters.eq("site", aSiteDomain), Filters.eq("site", "__any__")); 
		Bson filter = Filters.and(Filters.eq("lutname", aLUTName), orFilter);
		
		Document domainLUT = null;
		Document siteLUT = null;
		Document defaultLUT = null;
				
		List<Document> foundList = coll.find(filter).into(new ArrayList<Document>());
		if (foundList != null)
		{
			for(Document d : foundList)
			{
				String s = d.getString("site");
				if (s.equalsIgnoreCase(aSiteDomain))
					domainLUT = d;
				
				if (s.equalsIgnoreCase(aSite))
					siteLUT = d;
				
				if (s.equalsIgnoreCase(SiteIdentifier.__any__.toString()))
					defaultLUT = d;
			}			
		}
		
		if (siteLUT != null)
			return siteLUT;
		
		if (domainLUT != null)
			return domainLUT;
		
		return defaultLUT;		
	}
	
}
