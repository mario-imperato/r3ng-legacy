package org.r3.ws.mongocms.post;

import javax.servlet.ServletContext;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.mongo.MongoFileAttachmentDTO;
import org.r3.db.mongo.filecollection.FileCollectionDTO;
import org.r3.db.mongo.postcollection.PostCollectionDTO;
import org.r3.db.mongo.postcollection.PostCollectionPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.ws.mongocms.filecollection.FileUpload_POST.ResponseType;

public class PostFileAttachmentUpload_POST extends PostFileUpload_POST
{

	public PostFileAttachmentUpload_POST(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aPostId,
			MultipartFormDataInput input, String fileDataPart, String anAttachmentType, ResponseType aResponseType)
	{
		super(ctx, serviceEnvironment, aPostId, input, fileDataPart, anAttachmentType, aResponseType);

	}
	
	@Override
	protected void applyUpdates(MongoPersistenceContext mctx, Datastore mongoDatastore, PostCollectionDTO postDTO, FileCollectionDTO r0, FileCollectionDTO r1)
	{				
		MongoFileAttachmentDTO attachmentDTO = new MongoFileAttachmentDTO();
		attachmentDTO.populate(r0, r1);
		
		UpdateOperations<PostCollectionDTO> uop = mongoDatastore.createUpdateOperations(PostCollectionDTO.class);
		postDTO.addAttachments4Update(uop, attachmentDTO);
		
		PostCollectionPersistence  postCollection = PostCollectionPersistence.createPersistenceObject(mctx);
		postCollection.updateBySitePostid(mongoDatastore, uop, postDTO.getSite(), postDTO.getPostid());
	}

//	@Override
//	protected UpdateOperations<TimelineCollectionDTO> getPostUpdateOperation(Datastore mongoDatastore, TimelineCollectionDTO postDTO)
//	{
//		UpdateOperations<TimelineCollectionDTO> uop = mongoDatastore.createUpdateOperations(TimelineCollectionDTO.class);
//		uop.set(TimelineCollectionDTO.ATTACHMENTS, postDTO.getAttachments());		
//		return uop;
//	}		

}
