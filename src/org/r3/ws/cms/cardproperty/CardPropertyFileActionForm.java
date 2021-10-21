package org.r3.ws.cms.cardproperty;

import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.cms.cardproperty.CardPropertyDTO;

public class CardPropertyFileActionForm extends CardPropertyActionForm
{

	@Override
	public CardPropertyDTO getDTO4Update(String aSite, String aCardId, String aPropertyId)
	{
		CardPropertyDTO dto = new CardPropertyDTO();
		dto.setPropertyid(aPropertyId);
		dto.setPropertyname(getPropertyname());

	    dto.setRecstatus(RecordStatus.sys_recact.toString());		
		return  dto;
	}

	@Override
	public CardPropertyDTO getDTO4Insert(String aSite, String aCardId)
	{
		return null;
	}

}
