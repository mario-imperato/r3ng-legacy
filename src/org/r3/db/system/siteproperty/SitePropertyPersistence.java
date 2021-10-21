//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.system.siteproperty;

import java.util.List;

import org.r3.db.PersistenceConfigInfo;
import org.r3.db.PersistenceContext;
import org.r3.db.utils.SQLStringUtils;

public class SitePropertyPersistence extends SitePropertyPersistenceBase
{
	public static SitePropertyPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg,
					org.apache.ibatis.session.SqlSession aSession)
	{
		SitePropertyPersistence p = new SitePropertyPersistence();
		p.setMapper(aSession.getMapper(SitePropertyMapper.class));
		return p;
	}

	public List<SitePropertyDTO> selectCascade(String aSiteDomain, String aSite, PersistenceConfigInfo pcfg)
	{	
		return this.mapper.selectCascade(aSiteDomain, aSite, pcfg);
	}
	
	public List<SitePropertyDTO> selectPropertiesInPropertyScope(String aSite, String aPropertyScope, PersistenceConfigInfo pcfg)
	{
		SitePropertyFilter filter = new SitePropertyFilter();				
		filter.or()
		   .andSiteEqualTo(aSite, true)
		   .andPropertyscopeEqualTo(aPropertyScope);
		
		List<SitePropertyDTO> listOf = this.select(filter, pcfg);
		return listOf;
	}
	
	public List<SitePropertyDTO> selectPropertiesInPropertyScope(String aSite, String aPropertyScope, String aPropertyKey, PersistenceConfigInfo pcfg)
	{
		SitePropertyFilter filter = new SitePropertyFilter();				
		filter.or()
		   .andSiteEqualTo(aSite, true)
		   .andPropertyscopeEqualTo(aPropertyScope)
		   .andPropertykeyLike(SQLStringUtils.getStringForLikeMode(aPropertyKey, SQLStringUtils.LikeMode.LeftLike));
		
		List<SitePropertyDTO> listOf = this.select(filter, pcfg);
		return listOf;
	}

	public int insertOrUpdate(String requestSiteId, String aPropertyScope, String aPropertyKey, String aValue, PersistenceConfigInfo persistenceConfigInfo)
	{
		int numOfRows = 0;
		
		SitePropertyDTO sitePropertyDto = selectBySitePropertyscopePropertykey(requestSiteId, aPropertyScope, aPropertyKey, persistenceConfigInfo);
		if (sitePropertyDto != null)
		{
			if (!sitePropertyDto.getPropertyvalue().equalsIgnoreCase(aValue))
			{
		    sitePropertyDto.setPropertyvalue(aValue);	
		    numOfRows = updateByPrimaryKey(sitePropertyDto, persistenceConfigInfo);
			}
		}
		else 
		{	
			sitePropertyDto = new SitePropertyDTO();
			sitePropertyDto.setSite(requestSiteId);
			sitePropertyDto.setPropertyscope(aPropertyScope);
			sitePropertyDto.setPropertykey(aPropertyKey);
			sitePropertyDto.setPropertyvalue(aValue);
			
			numOfRows = insert(sitePropertyDto, persistenceConfigInfo);	
		}
		
        return 	numOfRows;
	}

	public int deleteBySitePropertyscope(String aSite, String aPropertyScope, PersistenceContext pcfg)
	{		
		SitePropertyFilter filter = new SitePropertyFilter();				
		filter.or()
		   .andSiteEqualTo(aSite, false)
		   .andPropertyscopeEqualTo(aPropertyScope);
		
		return delete(filter, pcfg.getPersistenceConfigInfo());
	}
	
}
