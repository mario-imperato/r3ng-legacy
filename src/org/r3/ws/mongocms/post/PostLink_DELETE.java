package org.r3.ws.mongocms.post;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.postcollection.PostCollectionDTO;
import org.r3.db.mongo.postcollection.PostCollectionPersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.ws.mongocms.PostServicePattern;

public class PostLink_DELETE extends PostServicePattern
{
	private String attachmentId;
    
	public PostLink_DELETE(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aSite, String aCardId, String anAttachmentId)
	{
		super(ctx, serviceEnvironment, aSite, null, aCardId);
		attachmentId = anAttachmentId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		MongoPersistenceContext mpctx = pcfg.getMongoPersistenceContext();		
		Datastore mongoDatastore = mpctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		
		PostCollectionPersistence p = PostCollectionPersistence.createPersistenceObject(mpctx);		
		PostCollectionDTO dto = p.selectBySitePostid(mongoDatastore, senv.getRequestSiteId(), cardId, false);		
						
		long i = p.rawRemoveFileAttachmentBySitePostidLinkid(mpctx, senv.getRequestSiteId(), getPostidAsObjectid(cardId), attachmentId);       				
		return RestServiceDTO.SuccessDTO;			
	}

}
