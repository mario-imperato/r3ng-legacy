package org.r3.ws.mongocms.timeline;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.DTOBase;
import org.r3.db.mongo.MongoImageIconDTO;
import org.r3.db.mongo.timelinecollection.TimelineCollectionDTO;


public class TimelineActionForm
{
	@FormParam("title")
    private String title;

    public String getTitle()
    {    	
    	String s = DTOBase.nullOnEmpty(title);
    	if (s != null && s.length() > 80)
    		s = s.substring(0, 80);
    	
    	return s;
    }
    
	@FormParam("description")
    private String description;

    public String getDescription()
    {    	
    	return DTOBase.nullOnEmpty(description);
    }
        
    @FormParam("photo")
    private String photo;

    public String getPhoto()
    {    	
    	return DTOBase.nullOnEmpty(photo);
    }
    	
    @FormParam("allowedcontent")
    private String[] allowedcontent;

    public String[] getAllowedcontent()
    {    	
    	return allowedcontent;
    }
    
    public List<String> getAllowedcontentAsList()
    {
    	if (allowedcontent != null && allowedcontent.length > 0)
    	{
    		List<String> l = new ArrayList<String>();
    		for(String a : allowedcontent)
    		{
    			l.add(a);
    		}
    		
    		return l;
    	}
    	
    	return null;
    }
    
    public MongoImageIconDTO getPhotoAsMongoImageIconDTO()
    {
		String nt = getPhoto();
		if (nt != null)
		{
			try
			{
				MongoImageIconDTO mimg = MongoImageIconDTO.newInstanceFromJSONString(nt);
			    return mimg;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return null;
    }
    
	
	public UpdateOperations<TimelineCollectionDTO> getUpdateOperation(Datastore mongoDatastore, TimelineCollectionDTO aPost)
	{
        UpdateOperations<TimelineCollectionDTO> uop = mongoDatastore.createUpdateOperations(TimelineCollectionDTO.class);
        aPost.setLastmodified4Update(uop, new java.util.Date());        
        aPost.setDescription4Update(uop, getDescription());
		aPost.setTitle4Update(uop, getTitle());
		
		if (getAllowedcontent() != null)
		{
			aPost.setAllowedcontent4Update(uop, getAllowedcontentAsList());
		}
		else uop.unset(TimelineCollectionDTO.ALLOWEDCONTENT);
		
		return  uop;
	}

	public TimelineCollectionDTO getDTO4Insert(String requestSiteId, String requestSiteDomain, String userid, String lastname)
	{
		TimelineCollectionDTO dto = new TimelineCollectionDTO();
		dto.setSite(requestSiteId);
		dto.setLastmodified(new java.util.Date());
        dto.setDescription(getDescription());
		dto.setTitle(getTitle());
		
		if (getAllowedcontent() != null)
		{
			dto.setAllowedcontent(getAllowedcontentAsList());
		}
		
		return dto;
	}




}
