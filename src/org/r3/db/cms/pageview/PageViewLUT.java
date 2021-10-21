package org.r3.db.cms.pageview;

import org.r3.db.system.lut.LUT;
import org.r3.db.system.lut.LUTException;

public class PageViewLUT extends LUT
{
	public PageViewLUT(String languageCode) 
	{
		try
		{
		    setLutLanguage(languageCode);
			setReader(new PageViewLUTReader(languageCode));	
	    // setTimeout(300000);
		}
		catch(LUTException lute)
		{
			lute.printStackTrace();
		}
	}
			
	public String getDtodescr(String aDtokey)
	{
		PageViewLUTDTO dto = getItem(aDtokey);
		if (dto != null)
			return dto.getDtodescr();
	    
	    return null;
	}
	
	public PageViewLUTDTO getItem(String aSite, String aLanguageCode)
	{
		// Non uso il linguaggio indicato ma uso il linguaggio della lut. La  selezione di questa LUT può essere magari il risultato
		// di una logica di fallback.
		return getItem(PageViewLUTDTO.getDtokey(aSite, getLutLanguage()));
	}
	
	public PageViewLUTDTO getItem(String aDtokey)
	{
	    try
		{		    
	    	PageViewLUTDTO dto = (PageViewLUTDTO)getInstance().getItem(aDtokey);
			return dto;
		}
		catch (LUTException e1)
		{
			e1.printStackTrace();
		}
	    
	    return null;
	}

}
