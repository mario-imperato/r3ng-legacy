package org.r3.db.system.classifieritem;

import org.r3.db.system.lut.LUT;
import org.r3.db.system.lut.LUTException;


public class ClassifierItemLUT extends LUT
{
	public ClassifierItemLUT(String aClassifierId) 
	{
		this(aClassifierId, -1, -1);
	}

	public ClassifierItemLUT(String aClassifierId, int aTimeout) 
	{
		this(aClassifierId, aTimeout, -1);
	}

	public ClassifierItemLUT(String aClassifierId, int aTimeout, int aDepth) 
	{
		try
		{
	    setReader(new ClassifierItemLUTReader(aClassifierId, aDepth));	
	    // setTimeout(aTimeout);
		}
		catch(LUTException lute)
		{
			lute.printStackTrace();
		}
	}
			
	public String getDtodescr(String aDtokey)
	{
		ClassifierItemDTO dto = getItem(aDtokey);
		if (dto != null)
			return dto.getDtodescr();
	    
	    return null;
	}
	
	public ClassifierItemDTO getItem(String aDtokey)
	{
	    try
		{		    
	    	ClassifierItemDTO dto = (ClassifierItemDTO)getInstance().getItem(aDtokey);
			return dto;
		}
		catch (LUTException e1)
		{
			e1.printStackTrace();
		}
	    
	    return null;
	}
}
