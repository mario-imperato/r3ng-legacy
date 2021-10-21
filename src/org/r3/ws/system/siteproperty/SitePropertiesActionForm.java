package org.r3.ws.system.siteproperty;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import org.r3.db.DTOBase;
import org.r3.db.DTOBase.DTOCasingStyle;
import org.r3.db.system.siteproperty.SitePropertyDTO;

public class SitePropertiesActionForm
{
	public enum SitePropertyFormFields { property_package };
	
    private MultivaluedMap<String, String> requestData;
    
	public SitePropertiesActionForm(MultivaluedMap<String, String> rawData)
	{				
		requestData = rawData;
	}

	public String getPropertypackage()
	{
		return DTOBase.nullOnEmpty(requestData.getFirst(SitePropertyFormFields.property_package.toString()));
	}

	public List<SitePropertyDTO> getDTO4UpdateBoatInfoProperties(String eventId)
	{
		return getDTO4UpdateProperties(eventId, getPropertypackage());
	}

	public List<SitePropertyDTO> getDTO4UpdateProperties(String aSite, String aPackage)
	{
		List<SitePropertyDTO> listOfProps = null; 
		
		if (requestData != null)
		{
			String propValue = null;
		    for(String key : requestData.keySet())
		    {
		    	if (key.startsWith("prop_"))
		    	{
		    		DTOCasingStyle casingOption = DTOCasingStyle.none;
		    		
			    	List<String> items = requestData.get(key);
			    	if (items.size() > 1)
			    	{
			    		propValue = DTOBase.stringList2CSV(items);
			    	}
			    	else propValue = DTOBase.nullOnEmpty(requestData.getFirst(key));
                    if (propValue != null)
                    {
                    	if (listOfProps == null)
                    		 listOfProps = new ArrayList<SitePropertyDTO>();
                    	
                    	SitePropertyDTO dto = new SitePropertyDTO();
                    	dto.setSite(aSite);
                    	dto.setPropertyscope(aPackage);
                    	dto.setPropertykey(key.substring("prop_".length()));
                    	dto.setPropertyvalue(propValue, casingOption);
                    	
                    	listOfProps.add(dto);
                    }
		    	}
		    		
		    }
		}	
		
		return listOfProps;
	}
	
}
