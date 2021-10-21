package org.r3.db.mongo.usercollection;

import org.mongodb.morphia.annotations.Entity;
import org.r3.db.mongo.MongoImageDTO.MongoImageRole;

@Entity(value = "r3_usercollection", noClassnameStored = true)
public class UserCollectionDTO extends UserCollectionDTOBase
{
//	public enum PhotoRole { 
//		image, icon;
//		
//	    public static PhotoRole getValue4(String s, PhotoRole defaultValue)
//	    {
//	    	if (s != null && s.length() > 0)
//	    	{
//	    		try
//	    		{
//	    			return PhotoRole.valueOf(s);
//	    		}
//	    		catch(Exception exc)
//	    		{
//	    			exc.printStackTrace();
//	    		}
//	    	}
//	    	
//	    	return defaultValue;
//	    }
//	};
	
	public UserCollectionDTO()
	{
		// TODO Auto-generated constructor stub
	}

	public PhotoDTO getPhotoByRole(MongoImageRole aRole)
	{
		if (getPhoto() != null)
		{
			for(PhotoDTO p : getPhoto())
			{
				String r = p.getRole();
				if (r != null && r.equalsIgnoreCase(aRole.toString()))
					return p;
			}
		}
		
		return null;
	}

	public String getPhotoUrlByRole(MongoImageRole aRole)
	{
		PhotoDTO p = getPhotoByRole(aRole);
		if (p != null)
			return p.getUrl();
		
		return null;
	}
	
	public String getPhotoUrl4Icon()
	{
		return getPhotoUrlByRole(MongoImageRole.icon);
	}

	public String getPhotoUrl4Image()
	{
		return getPhotoUrlByRole(MongoImageRole.image);
	}

}
