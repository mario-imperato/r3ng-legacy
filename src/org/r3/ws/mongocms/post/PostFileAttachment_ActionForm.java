package org.r3.ws.mongocms.post;

import javax.ws.rs.FormParam;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.DTOBase;
import org.r3.db.mongo.MongoFileAttachmentDTO;
import org.r3.db.mongo.postcollection.PostCollectionDTO;


public class PostFileAttachment_ActionForm
{
	
    @FormParam("name")
    private String name;

    public String getName()
    {    	
    	return DTOBase.nullOnEmpty(name);
    }

	public UpdateOperations<PostCollectionDTO> getUpdateOperation(
			Datastore mongoDatastore, PostCollectionDTO dto,
			String attachmentId)
	{
		MongoFileAttachmentDTO fdto = dto.getAttachmentByFileid(attachmentId);
		if (fdto != null)
		{
			fdto.setName(getName());
			
	        UpdateOperations<PostCollectionDTO> uop = mongoDatastore.createUpdateOperations(PostCollectionDTO.class);
	        dto.setLastmodified4Update(uop, new java.util.Date());
	        uop.set(PostCollectionDTO.ATTACHMENTS, dto.getAttachments());
	        return uop;
		}
		
		return null;
	}


}
