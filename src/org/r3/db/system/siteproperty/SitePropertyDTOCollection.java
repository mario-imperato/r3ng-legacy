package org.r3.db.system.siteproperty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SitePropertyDTOCollection extends ArrayList<SitePropertyDTO>
{
	private Map<String, List<SitePropertyDTO>> propertiesPkgMap;
	private Map<String, SitePropertyDTO> propertiesMap;

	// private String[] UiCfgHomePortletsConfig;
	public SitePropertyDTOCollection()
	{
//		UiCfgHomePortletsConfig = new String[30];
//		for(int i = 0; i < UiCfgHomePortletsConfig.length; i++)
//			UiCfgHomePortletsConfig[i] = "id='JSPortletPosition_" + String.valueOf(i) + "'";
	}
	
	private void updateUiCfgHomePortletsConfig(SitePropertyDTO aPropertyDto)
	{
//		int positionIndex = aPropertyDto.getPropertykeyAsInt();
//  	    if (positionIndex < UiCfgHomePortletsConfig.length)
//		{
//  	    	UiCfgHomePortletsConfig[positionIndex] = aPropertyDto.getPropertyvalue();
//		}	     	  			
	}
	
//	public String[] getUiCfgHomePortletsConfig()
//	{
//		return UiCfgHomePortletsConfig;
//	}
	
	@Override
	public boolean addAll(Collection<? extends SitePropertyDTO> listOfProperties)	
	{
		boolean rc = true;
	
		for(SitePropertyDTO dto : listOfProperties)
		{
		   rc = rc && add(dto);
		}
		
		return rc;
	}
	
	public boolean add(SitePropertyDTO dto)
	{
		boolean rc = super.add(dto);

		if (propertiesMap == null)
			propertiesMap = new HashMap<String, SitePropertyDTO>();

		if (propertiesPkgMap == null)
			propertiesPkgMap = new HashMap<String, List<SitePropertyDTO>>();

//		if (dto.getPropertypackage().equalsIgnoreCase(SitePropertyDTO.UI_CFG_HOME_PORTLETS_PKG))
//		{
//			this.updateUiCfgHomePortletsConfig(dto);
//		}
		
		String pkgName = dto.getPropertypackage();
		
//		if (pkgName.indexOf('.') < 0)
//		{
//		   StringBuilder pkgNameBuilder = new StringBuilder();
//		   pkgNameBuilder.append(dto.getPropertyscope()).append('$').append(dto.getPropertypackage());
//
//		   pkgName = pkgNameBuilder.toString();
//		}
		
		propertiesMap.put(dto.getPropertykey(true), dto);

		List<SitePropertyDTO> packageList = propertiesPkgMap.get(pkgName);
		if (packageList == null)
		{
			packageList = new ArrayList<SitePropertyDTO>();
			propertiesPkgMap.put(pkgName, packageList);
		}
		packageList.add(dto);
		return rc;
	}

//	public SitePropertyDTO getPropertyByPropertykey(String propertykey)
//	{
//		if (propertiesMap == null || propertiesMap.size() == 0)
//			return SitePropertyDTO.NullProperty;				
//			
//		SitePropertyDTO resDto = propertiesMap.get(propertykey);
//		if (resDto == null)
//		{
//			resDto = SitePropertyDTO.NullProperty;
//		}
//		
//		return resDto;
//	}

	public SitePropertyDTO getPropertyByPropertykey(String propertykey)
	{
		return getPropertyByPropertykey(null, propertykey);
	}

	public SitePropertyDTO getPropertyByPropertykey(String aPropertyPackage, String propertykey)
	{
		if (propertiesMap == null || propertiesMap.size() == 0)
			return SitePropertyDTO.NullProperty;				
			
		if (aPropertyPackage != null)
		{
		    propertykey = new StringBuilder().append(aPropertyPackage).append('.').append(propertykey).toString();	
		}
		
		SitePropertyDTO resDto = propertiesMap.get(propertykey);
		if (resDto == null)
		{
			resDto = SitePropertyDTO.NullProperty;
		}
		
		return resDto;
	}
	
	public List<SitePropertyDTO> getPropertiesByPropertyPackage(/* PropertyScope propertyScope, */ String propertyPackage)
	{
		if (propertiesPkgMap == null || propertiesPkgMap.size() == 0)
			return null;				
		
//		StringBuilder lookUpNameBuilder = new StringBuilder().append(propertyScope).append('$');
//		if (propertyPackage == null)
//		{
//			lookUpNameBuilder.append("__default__");
//		}
//		else lookUpNameBuilder.append(propertyPackage);
		
		List<SitePropertyDTO> resultList = propertiesPkgMap.get(propertyPackage /* lookUpNameBuilder.toString() */);		
		return resultList;
	}
	
//	public List<SitePropertyDTO> getPropertiesByPropertyscopePropertykeyPrefix(PropertyScope propertyScope, String propertyKeyPrefix)
//	{
//		if (size() == 0)
//			return null;
//		
//		List<SitePropertyDTO> resultList = null;
//		for(SitePropertyDTO stdo : this)
//		{
//			if (stdo.getPropertyscope().equalsIgnoreCase(propertyScope.toString()) && stdo.getPropertykey().startsWith(propertyKeyPrefix))
//			{
//				if (resultList == null)
//					resultList = new ArrayList<SitePropertyDTO>();
//				
//				resultList.add(stdo);
//			}
//		}
//		
//		return resultList;
//	}
	
}
