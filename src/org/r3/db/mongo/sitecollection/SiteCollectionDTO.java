//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.sitecollection;

import java.util.Iterator;

import org.mongodb.morphia.annotations.Entity;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.mongo.MongoAddressDTO;
import org.r3.db.mongo.MongoImageDTO;
import org.r3.db.mongo.MongoImageDTO.MongoImageRole;
import org.r3.db.mongo.MongoImageIconDTO;

/*
 * Please Define in MongoDbSchemaInfo: public static final String MongoDbSiteCollectionName = "r3_sitecollection";
 */
@Entity(value=MongoDbSchemaInfo.MongoDbSiteCollectionName, noClassnameStored=true)
public class SiteCollectionDTO extends SiteCollectionDTOBase
{
	public static final String ADDRESS_ADMINAREA_L1 		   = ADDRESS + "." + MongoAddressDTO.ADMINAREA_L1;
	public static final String ADDRESS_ADMINAREA_L1_LOCATIONID = ADDRESS + "." + MongoAddressDTO.ADMINAREA_L1_LOCATIONID;
	
	public enum SiteImageRole 
	{ 		
		sitesquared, userphoto, shksitephoto
		;
		
	    public static SiteImageRole getValue4(String s, SiteImageRole defaultValue)
	    {
	    	if (s != null && s.length() > 0)
	    	{
	    		try
	    		{
	    			return SiteImageRole.valueOf(s);
	    		}
	    		catch(Exception exc)
	    		{
	    			exc.printStackTrace();
	    		}
	    	}
	    	
	    	return defaultValue;
	    }
	};
	
	public SiteCollectionDTO()
    {
        super();
    }
	
	public MongoImageDTO getPhotoByRole(MongoImageRole aMajorRole, SiteImageRole aMinorRole)
	{
		if (getGraphics() != null)
		{
			for(MongoImageIconDTO p : getGraphics())
			{
				if (p.isOfRole(aMinorRole.toString()))
				{
					MongoImageDTO p1 = null;
					switch(aMajorRole)
					{
					case image:
						p1 = p.getImage();
						break;
					case icon: 
						p1 = p.getIcon();
						break;
					}
					
					if (p1 != null)
						return p1;
				}
						
			}
		}
		
		return null;
	}

	public String getPhotoUrlByRole(MongoImageRole aMajorRole, SiteImageRole aMinorRole)
	{
		MongoImageDTO p = getPhotoByRole(aMajorRole, aMinorRole);
		if (p != null)
			return p.getUrl();
		
		return null;
	}
	
	public String getPhotoUrl4Icon(SiteImageRole aMinorRole)
	{
		return getPhotoUrlByRole(MongoImageRole.icon, aMinorRole);
	}

	public String getPhotoUrl4Image(SiteImageRole aMinorRole)
	{
		return getPhotoUrlByRole(MongoImageRole.image, aMinorRole);
	}

	public void removePhotoByMinorRole(SiteImageRole imageMinorRole)
	{
		if (getGraphics() != null)
		{
			for (Iterator<MongoImageIconDTO> iter = getGraphics().listIterator(); iter.hasNext(); ) {
				MongoImageIconDTO p = iter.next();
				if (p.getImagerole().equalsIgnoreCase(imageMinorRole.toString())) {
			        iter.remove();
			    }
			}			
		}
		
	}	
}

