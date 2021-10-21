package org.r3.ws.user.usercollection;

import javax.ws.rs.FormParam;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.DTOBase;
import org.r3.db.mongo.usercollection.UserCollectionDTO;
import org.r3.db.mongo.usercollection.UserCollectionDTOBase.BusinesscardDTO;

public class BusinessCardActionForm
{
	@FormParam("personalstatement")
	private String personalstatement               ;    

	public String getPersonalstatement()    { return DTOBase.nullOnEmpty(personalstatement); }
	
	@FormParam("email")
	private String email ;

	public String getEmail()    { return DTOBase.nullOnEmpty(email); }

	@FormParam("cellphone")
	private String cellphone;

	public String getCellphone()    { return DTOBase.nullOnEmpty(cellphone); }
	
	public UpdateOperations<UserCollectionDTO> getUpdateOperation(Datastore mongoDatastore)
	{
		UpdateOperations<UserCollectionDTO> uop = mongoDatastore.createUpdateOperations(UserCollectionDTO.class);
		
		BusinesscardDTO dto = new BusinesscardDTO();
		
		dto.setPersonalstatement(getPersonalstatement());
		dto.setEmail(getEmail());
		dto.setCellphone(getCellphone());
		
		uop.set(UserCollectionDTO.BUSINESSCARD, dto);
		uop.set(UserCollectionDTO.LASTMODIFIED, new java.util.Date());
		uop.add(UserCollectionDTO.SECTIONS, "businesscard", false);
		return  uop;
	}
	
}
