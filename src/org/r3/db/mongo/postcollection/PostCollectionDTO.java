//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//

package org.r3.db.mongo.postcollection;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.mongo.MongoFileAttachmentDTO;
import org.r3.db.mongo.MongoImageIconDTO;
import org.r3.db.mongo.MongoLinkDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * Please Define in MongoDbSchemaInfo: public static final String MongoDbTimelineCollectionName = "r3_timelinecollection";
 */
@Entity(value = MongoDbSchemaInfo.MongoDbPostCollectionName, noClassnameStored = true)
public class PostCollectionDTO extends PostCollectionDTOBase
{
	public enum StatusType
	{
		published, draft;
		
		public static StatusType getValue4(String s, StatusType defaultValue)
	    {
	    	if (s != null && s.length() > 0)
	    	{
	    		try
	    		{
	    			return StatusType.valueOf(s);
	    		}
	    		catch(Exception exc)
	    		{
	    			exc.printStackTrace();
	    		}
	    	}
	    	
	    	return defaultValue;
	    }
	}
	
	public enum AuthorType
	{
		user
		;
		
	    public static AuthorType getValue4(String s, AuthorType defaultValue)
	    {
	    	if (s != null && s.length() > 0)
	    	{
	    		try
	    		{
	    			return AuthorType.valueOf(s);
	    		}
	    		catch(Exception exc)
	    		{
	    			exc.printStackTrace();
	    		}
	    	}
	    	
	    	return defaultValue;
	    }
	}
	
	public PostCollectionDTO()
	{
		super();
	}
	
	public void setAuthortype(AuthorType anAuthorType)
	{
		setAuthortype(anAuthorType.toString());
	}
	
	@JsonIgnore
	public boolean hasAttachments()
	{
		List<MongoFileAttachmentDTO> listOfFileAttchments = this.getAttachments();		
		return listOfFileAttchments != null && listOfFileAttchments.size() > 0;
	}
	
	@JsonIgnore
	public boolean hasLinks()
	{
		List<MongoLinkDTO> listOfLinks = this.getLinks();		
		return listOfLinks != null && listOfLinks.size() > 0;
	}
	
	public MongoFileAttachmentDTO getAttachmentByFileid(String aFileId)
	{
		if (hasAttachments())
		{
			for(MongoFileAttachmentDTO dto : getAttachments())
			{
				if (dto.getFileid().equalsIgnoreCase(aFileId))
					return dto;
			}
		}
		
		return null;
	}

	public MongoLinkDTO getLinkByLinkid(String aLinkId)
	{
		if (hasLinks())
		{
			for(MongoLinkDTO dto : getLinks())
			{
				if (dto.getLinkid().equalsIgnoreCase(aLinkId))
					return dto;
			}
		}
		
		return null;
	}


	public boolean photoHasBeenChanged(MongoImageIconDTO aPhoto)
	{
		String currentPhotoId = "NULLIMAGE";
		MongoImageIconDTO photo = getPhoto();
		if (photo != null)
			currentPhotoId = photo.getImageiconid();
		
		String uploadPhotoId = (aPhoto != null) ? aPhoto.getImageiconid() : "NULLIMAGE";
		
		if (!currentPhotoId.equalsIgnoreCase(uploadPhotoId))
			return true;
		
		return false; 		
	}

	
}
