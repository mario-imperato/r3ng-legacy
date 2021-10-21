package org.r3.ws.system.sitecollection;

import javax.ws.rs.FormParam;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.DTOBase;
import org.r3.db.mongo.sitecollection.SiteCollectionDTO;

public class SiteInfoActionForm
{
	@FormParam("summary")
	private String summary               ;    

	public String getSummary()    { return DTOBase.nullOnEmpty(summary); }	
	
	public UpdateOperations<SiteCollectionDTO> getUpdateOperation(Datastore mongoDatastore)
	{
		UpdateOperations<SiteCollectionDTO> uop = mongoDatastore.createUpdateOperations(SiteCollectionDTO.class);
		
		uop.set(SiteCollectionDTO.SUMMARY, getSummary());
		return  uop;
	}

	

	
}
