package org.r3.ws.mongocms.post;

import javax.ws.rs.FormParam;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.DTOBase;
import org.r3.db.mongo.MongoLinkDTO;
import org.r3.db.mongo.postcollection.PostCollectionDTO;


public class PostLink_ActionForm
{	
    @FormParam("name")
    private String name;

    public String getName()
    {    	
    	return DTOBase.nullOnEmpty(name);
    }

    @FormParam("href")
    private String href;

    public String getHref()
    {    	
    	return DTOBase.nullOnEmpty(href);
    }
    
    @FormParam("refattachmentid")
    private String refattachmentid;

    public String getRefattachmentid()
    {    	
    	return DTOBase.nullOnEmpty(refattachmentid);
    }

    public UpdateOperations<PostCollectionDTO> getInsertOperation(Datastore mongoDatastore)
	{
		UpdateOperations<PostCollectionDTO> uop = mongoDatastore.createUpdateOperations(PostCollectionDTO.class);
		
    	MongoLinkDTO dto = new MongoLinkDTO();
		dto.setLinkid(new ObjectId());
		dto.setName(getName());
		dto.setHref(getHref());
		dto.setRefattachmentid(getRefattachmentid());
		uop.add(PostCollectionDTO.LINKS, dto);
		return uop;
	}
    
	public UpdateOperations<PostCollectionDTO> getUpdateOperation(
			Datastore mongoDatastore, PostCollectionDTO dto,
			String linkId)
	{
		MongoLinkDTO fdto = dto.getLinkByLinkid(linkId);
		if (fdto != null)
		{
			fdto.setName(getName());
			fdto.setHref(getHref());
			fdto.setRefattachmentid(getRefattachmentid());
	        UpdateOperations<PostCollectionDTO> uop = mongoDatastore.createUpdateOperations(PostCollectionDTO.class);
	        dto.setLastmodified4Update(uop, new java.util.Date());
	        uop.set(PostCollectionDTO.LINKS, dto.getLinks());
	        return uop;
		}
		
		return null;
	}


}
