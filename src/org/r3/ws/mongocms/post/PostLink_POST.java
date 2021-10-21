package org.r3.ws.mongocms.post;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.postcollection.PostCollectionDTO;
import org.r3.db.mongo.postcollection.PostCollectionPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.ws.mongocms.PostServicePattern;

public class PostLink_POST extends PostServicePattern
{
    private PostLink_ActionForm actionForm;
    
	public PostLink_POST(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aSite, String aCardId, PostLink_ActionForm anActionForm)
	{
		super(ctx, serviceEnvironment, aSite, null, aCardId);
		actionForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		MongoPersistenceContext mpctx = pcfg.getMongoPersistenceContext();		
		Datastore mongoDatastore = mpctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		
		PostCollectionPersistence p = PostCollectionPersistence.createPersistenceObject(mpctx);		
		PostCollectionDTO dto = p.selectBySitePostid(mongoDatastore, senv.getRequestSiteId(), cardId, false);
		if (dto != null)
		{
			UpdateOperations<PostCollectionDTO> uop = actionForm.getInsertOperation(mongoDatastore);
			if (uop != null)
				p.updateBySitePostid(mongoDatastore, uop, senv.getRequestSiteId(), cardId);	
		}
						   				
		return dto;			
	}

}
