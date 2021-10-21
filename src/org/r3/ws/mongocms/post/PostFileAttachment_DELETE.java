package org.r3.ws.mongocms.post;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.MongoFileAttachmentDTO;
import org.r3.db.mongo.MongoImageDTO;
import org.r3.db.mongo.filecollection.FileCollectionPersistence;
import org.r3.db.mongo.postcollection.PostCollectionDTO;
import org.r3.db.mongo.postcollection.PostCollectionPersistence;
import org.r3.db.utils.MongoUtils;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.ws.mongocms.PostServicePattern;

public class PostFileAttachment_DELETE extends PostServicePattern
{
	private String attachmentId;
    
	public PostFileAttachment_DELETE(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aSite, String aCardId, String anAttachmentId)
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
		if (dto != null)
		{
			MongoFileAttachmentDTO fdto = dto.getAttachmentByFileid(attachmentId);
			if (fdto != null)
			{
				FileCollectionPersistence fp = FileCollectionPersistence.createPersistenceObject(mpctx);		
				long r1 = fp.rawRemoveByFileid(mpctx, MongoUtils.getObjectIdFromString(attachmentId));
				
				MongoImageDTO iconDto = fdto.getFileIcon();
				if (iconDto != null)
				{
					long r2 = fp.rawRemoveByFileid(mpctx, MongoUtils.getObjectIdFromString(iconDto.getImageid()));
				}				
			}
		}
						
		long i = p.rawRemoveFileAttachmentBySitePostidFileid(mpctx, senv.getRequestSiteId(), getPostidAsObjectid(cardId), attachmentId);       				
		return RestServiceDTO.SuccessDTO;			
	}

}
