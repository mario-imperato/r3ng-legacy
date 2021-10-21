package org.r3.ws.system.sitecollection;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.sitecollection.SiteCollectionDTO;
import org.r3.db.mongo.sitecollection.SiteCollectionDataTableAdapter;
import org.r3.db.mongo.sitecollection.SiteCollectionPersistence;
import org.r3.db.mongo.usercollection.UserCollectionDTO;
import org.r3.db.mongo.usercollection.UserCollectionPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETSiteCollections extends ServicePattern
{
    private SiteCollectionQueryActionForm actionForm;
    
	public GETSiteCollections(ServletContext ctx,  ServiceEnvironment serviceEnvironment, SiteCollectionQueryActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		MongoPersistenceContext mpctx = pcfg.getMongoPersistenceContext();		
		Datastore datastore = mpctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		
		if (actionForm.getLimit2favsitesAsBoolean())
		{
			UserCollectionPersistence up = UserCollectionPersistence.createPersistenceObject(mpctx);
			UserCollectionDTO userCollectionDTO = up.selectByUserid(datastore, senv.getUserProfile().getUserid());
			if (userCollectionDTO != null)
				actionForm.setFavsites(userCollectionDTO.getFavsites());
				
		}
		SiteCollectionPersistence p = SiteCollectionPersistence.createPersistenceObject(mpctx);
		Query<SiteCollectionDTO> query = actionForm.getSearchCondition(datastore, senv.getRequestSiteId(), senv.getRequestSiteDomain());
		
		SiteCollectionDataTableAdapter dt = null;
		if (query != null)
		   dt = p.query(query, actionForm.getsEcho(), actionForm.getiDisplayStart(), actionForm.getiDisplayLength(), actionForm.isExecuteCount());
				
		return dt;
	}

}
