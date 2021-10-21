package org.r3.db.cms.attachmenttype;

import org.r3.db.system.lut.LUT;
import org.r3.db.system.lut.LUTException;


public class AttachmentTypeLUT extends LUT
{
	public AttachmentTypeLUT(String aClassifierId) 
	{
		this(aClassifierId, -1, -1);
	}

	public AttachmentTypeLUT(String aClassifierId, int aTimeout) 
	{
		this(aClassifierId, aTimeout, -1);
	}

	public AttachmentTypeLUT(String aClassifierId, int aTimeout, int aDepth) 
	{
		try
		{
	    setReader(new AttachmentTypeLUTReader(aClassifierId, aDepth));	
	    // setTimeout(aTimeout);
		}
		catch(LUTException lute)
		{
			lute.printStackTrace();
		}
	}
			
	public String getDtodescr(String aSite, String attachmentTypeId)
	{
		AttachmentTypeDTO dto = getItem(aSite, attachmentTypeId);
		if (dto != null)
			return dto.getDtodescr();
	    
	    return null;
	}

	public AttachmentTypeDTO getItem(String aSiteAttachmentTypeId)
	{
	    try
		{		    
	    	AttachmentTypeDTO dto = (AttachmentTypeDTO)getInstance().getItem(aSiteAttachmentTypeId);
			return dto;
		}
		catch (LUTException e1)
		{
			e1.printStackTrace();
		}
	    
	    return null;
	}

	public AttachmentTypeDTO getItem(String aSite, String attachmentTypeId)
	{
		String dtokey = new StringBuilder().append(aSite).append('_').append(attachmentTypeId).toString();
	    return getItem(dtokey);
	}
}
