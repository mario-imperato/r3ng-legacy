package org.r3.db.system.metadata.tmetadataview;

import org.r3.db.system.lut.LUT;
import org.r3.db.system.lut.LUTException;

public class TableColumnsMetadataLUT extends LUT
{
	public TableColumnsMetadataLUT() 
	{
		try
		{
	    setReader(new TableColumnsMetadataLUTReader());	
	    // setTimeout(300000);
		}
		catch(LUTException lute)
		{
			lute.printStackTrace();
		}
	}
			
	public String getDtodescr(String aDtokey)
	{
		TableColumnsMetadataDTO dto = getItem(aDtokey);
		if (dto != null)
			return dto.getDtodescr();
	    
	    return null;
	}
	
	public TableColumnsMetadataDTO getItem(String aDtokey)
	{
		return getItem(aDtokey, false);
	}
	
	public TableColumnsMetadataDTO getItem(String aDtokey, boolean duplicate)
	{
	    try
		{		    
	    	TableColumnsMetadataDTO dto = (TableColumnsMetadataDTO)getInstance().getItem(aDtokey);
		    if (dto != null && duplicate)
		    {
		    	dto = new TableColumnsMetadataDTO(dto);
		    }
			return dto;
		}
		catch (LUTException e1)
		{
			e1.printStackTrace();
		}
	    
	    return null;
	}

}
