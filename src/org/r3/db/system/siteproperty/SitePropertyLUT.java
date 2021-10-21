package org.r3.db.system.siteproperty;

import java.util.HashMap;
import java.util.Iterator;

import org.r3.db.system.lut.ILUTItem;
import org.r3.db.system.lut.ILUTVisitor;
import org.r3.db.system.lut.LUT;
import org.r3.db.system.lut.LUTException;
import org.r3.db.system.siteproperty.SitePropertyDTO.PropertyScope;

public class SitePropertyLUT extends LUT
{
	public SitePropertyLUT() 
	{
		try
		{
	    setReader(new SitePropertyLUTReader());	
	    // setTimeout(300000);
		}
		catch(LUTException lute)
		{
			lute.printStackTrace();
		}
	}
			
	public String getDtodescr(String aSite, PropertyScope aPropertyscope, String aPropertykey)
	{
		return getDtodescr(aSite, aPropertyscope.toString(), aPropertykey);
	}
	
	public String getDtodescr(String aSite, String aPropertyscope, String aPropertykey)
	{
		SitePropertyDTO dto = getItem(aSite, aPropertyscope, aPropertykey);
		if (dto != null)
			return dto.getDtodescr();
	    
	    return null;
	}

	public SitePropertyDTO getItem(String aSite, PropertyScope aPropertyscope, String aPropertykey)
	{
		return getItem(aSite, aPropertyscope.toString(), aPropertykey);
	}
	
	public SitePropertyDTO getItem(String aSite, String aPropertyscope, String aPropertykey)
	{
		String aDtokey = SitePropertyDTO.getDtokey(aSite, aPropertyscope, aPropertykey);
	    try
		{		    
	    	SitePropertyDTO dto = (SitePropertyDTO)getInstance().getItem(aDtokey);
			return dto;
		}
		catch (LUTException e1)
		{
			e1.printStackTrace();
		}
	    
	    return null;
	}

	public HashMap<String, String> getPropertyMapFor(final String targetSite, final String propertyScope) throws LUTException
	{
	    return 	getPropertyMapFor(targetSite, propertyScope, null);
	}
	
	public HashMap<String, String> getPropertyMapFor(final String targetSite, final String propertyScope, final String propertyPackage) throws LUTException
	{
		HashMap<String, String> resultProperties = null;

		ILUTVisitor v = new ILUTVisitor() {
			public boolean accept(ILUTItem anItem)
			{
				SitePropertyDTO castedItem = (SitePropertyDTO)anItem;
				
				String scope = castedItem.getPropertyscope();
				String p = castedItem.getPropertykey();
				
				String matchSite = SitePropertyDTO.SiteIdentifier.__any__.toString();				
				if (targetSite != null)					
					matchSite = targetSite;
				
				if (matchSite.equalsIgnoreCase(castedItem.getSite()) && scope.equalsIgnoreCase(propertyScope))
				{
					if (propertyPackage == null)
						return true;
					
					if (p.startsWith(propertyPackage) && p.length() > (propertyPackage.length() + 2))
						return true;
				}

				return false;
			}
			
		};

		Iterator iter = getInstance().elements(v);
		if (iter != null)
		{
			for (; iter.hasNext();)
			{
				SitePropertyDTO item = (SitePropertyDTO) iter.next();
				if (resultProperties == null)
					resultProperties = new HashMap<String, String>();

				String mapKey = item.getPropertykey();
				if (propertyPackage != null)
					mapKey = item.getPropertykey().substring(propertyPackage.length() + 1);
				
				resultProperties.put(mapKey, item.getPropertyvalue());
			}
		}

		return resultProperties;
	}

}
