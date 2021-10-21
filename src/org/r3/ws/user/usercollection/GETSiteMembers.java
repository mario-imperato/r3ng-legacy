package org.r3.ws.user.usercollection;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.query.Query;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.usercollection.UserCollectionDTO;
import org.r3.db.mongo.usercollection.UserCollectionDataTableAdapter;
import org.r3.db.mongo.usercollection.UserCollectionPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETSiteMembers extends ServicePattern
{
    private UserCollectionQueryActionForm actionForm;
    
	public GETSiteMembers(ServletContext ctx,  ServiceEnvironment serviceEnvironment, UserCollectionQueryActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		MongoPersistenceContext mpctx = pcfg.getMongoPersistenceContext();		
		UserCollectionPersistence p = UserCollectionPersistence.createPersistenceObject(mpctx);
		Query<UserCollectionDTO> query = actionForm.getSiteMembers(mpctx.getDatastore(MongoDbSchemaInfo.MongoDbName), senv.getRequestSiteId(), senv.getRequestSiteDomain());
		
		UserCollectionDataTableAdapter dt = p.query(query, actionForm.getsEcho(), actionForm.getiDisplayStart(), actionForm.getiDisplayLength(), actionForm.isExecuteCount());
		return dt;
	}

}
