package org.r3.ws.mongocms.post;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.MongoLinkDTO.MongoLinkDataTableAdapter;
import org.r3.db.mongo.postcollection.PostCollectionDTO;
import org.r3.db.mongo.postcollection.PostCollectionPersistence;
import org.r3.db.utils.DataTableAdapter;
import org.r3.db.utils.DataTableQueryActionForm;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.ws.mongocms.PostServicePattern;

public class GETPostLinks extends PostServicePattern
{
	private DataTableQueryActionForm queryActionForm = null;
    
	public GETPostLinks(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aSite, String aCardId, DataTableQueryActionForm aQueryActionForm)
	{
		super(ctx, serviceEnvironment, aSite, null, aCardId);
		queryActionForm = aQueryActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		MongoPersistenceContext mpctx = pcfg.getMongoPersistenceContext();		
		Datastore datastore = mpctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		
		PostCollectionPersistence p = PostCollectionPersistence.createPersistenceObject(mpctx);		
		PostCollectionDTO dto = p.selectBySitePostid(datastore, senv.getRequestSiteId(), cardId, false);		
				
		if (dto.hasLinks())
		{
			MongoLinkDataTableAdapter dt = new MongoLinkDataTableAdapter(dto.getLinks(), queryActionForm.getsEcho());
			return dt;
		}
		
		return new DataTableAdapter();			
	}

}
