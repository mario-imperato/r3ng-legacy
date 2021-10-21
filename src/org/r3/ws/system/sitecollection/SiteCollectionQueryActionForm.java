package org.r3.ws.system.sitecollection;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.r3.db.DTOBase;
import org.r3.db.mongo.sitecollection.SiteCollectionDTO;
import org.r3.db.utils.DataTableQueryActionForm;


public class SiteCollectionQueryActionForm extends DataTableQueryActionForm
{    
	@QueryParam("sitetype")
	private String sitetype;    
	
	public String getSitetype()    
	{ 
		return DTOBase.nullOnEmpty(sitetype); 
	}
		
	@QueryParam("area_level_1_id")
	private String area_level_1_id;    
	
	public String getArea_level_1_id()    
	{ 
		return DTOBase.nullOnEmpty(area_level_1_id); 
	}
	
	@QueryParam("limit2favsites")
	private String limit2favsites;    
	
	public String getLimit2favsites()    
	{ 
		return DTOBase.nullOnEmpty(limit2favsites); 
	}

	public boolean getLimit2favsitesAsBoolean()  
	{ 
		return DTOBase.getBTrueFalseAsBoolean(getLimit2favsites());
	}	
	
	@QueryParam("addressrequired")
	private String addressrequired;
	
	public String getAddressrequired()  
	{ 
		return DTOBase.nullOnEmpty(addressrequired); 
	}	
	
	public boolean getAddressrequiredAsBoolean()  
	{ 
		return DTOBase.getBTrueFalseAsBoolean(getAddressrequired());
	}	
	
	public Query<SiteCollectionDTO> getSearchCondition(Datastore ds, String aSite, String aSiteDomain)
	{
		// ;
		Query<SiteCollectionDTO> query = ds.createQuery(SiteCollectionDTO.class);
		
		if (getLimit2favsitesAsBoolean())
		{
			if (userfavsites == null || userfavsites.size() == 0)
			{
				return null;
			}
			else
			{
				query.field(SiteCollectionDTO.SITE).in(userfavsites);
			}
		}
		
		query.field(SiteCollectionDTO.DOMAIN).equal(aSiteDomain);
		
		String s = getSitetype();
		if (s != null)
		   query.field(SiteCollectionDTO.SITETYPE).equal(s);
				
		if (getAddressrequiredAsBoolean())		
			query.field(SiteCollectionDTO.ADDRESS).exists();
		
		s = getArea_level_1_id();
		if (s != null)
		{
			query.field(SiteCollectionDTO.ADDRESS_ADMINAREA_L1_LOCATIONID).equal(s);			
		}
		
		return query;
	}

	private List<String> userfavsites;
	
	public void setFavsites(List<String> favsites)
	{
		userfavsites = favsites;		
	}
	
}
