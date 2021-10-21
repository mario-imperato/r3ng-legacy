package org.r3.db.system.siteportletcfg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SitePortletConfigDTOCollection extends ArrayList<SitePortletConfigDTO>
{
	public static SitePortletConfigDTOCollection NullPortletConfigCollection = new SitePortletConfigDTOCollection();
	
	private Map<String, SitePortletConfigDTO> propertiesMap;

	public SitePortletConfigDTOCollection()
	{
	}

	public boolean add(SitePortletConfigDTO dto)
	{
		boolean rc = super.add(dto);

		if (propertiesMap == null)
			propertiesMap = new HashMap<String, SitePortletConfigDTO>();

		propertiesMap.put(dto.getPositionid(), dto);
		return rc;
	}

	public SitePortletConfigDTO getPortletConfigByPositionId(String positionId)
	{
		if (propertiesMap == null || propertiesMap.size() == 0)
			return SitePortletConfigDTO.NullPortlet;

		SitePortletConfigDTO resDto = propertiesMap.get(positionId);
		if (resDto == null)
		{
			resDto = SitePortletConfigDTO.NullPortlet;
		}

		return resDto;
	}

}
