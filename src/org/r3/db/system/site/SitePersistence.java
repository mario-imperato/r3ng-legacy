//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.system.site;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.r3.db.system.siteproperty.SitePropertyPersistence;

public class SitePersistence extends SitePersistenceBase
{
	public static SitePersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg,
			org.apache.ibatis.session.SqlSession aSession)
	{
		SitePersistence p = new SitePersistence();
		p.setMapper(aSession.getMapper(SiteMapper.class));
		p.setSequencePersistence(pcfg.getSequencePersistence());
		return p;
	}

	/*
	 * Metodi dei quali si e' fatto l'override per risolvere il problema degli extra campi tolti dalla tabella site

	
	@Override
	public org.r3.db.system.site.SiteDTO selectBySite(java.lang.String site, org.r3.db.PersistenceConfigInfo pcfg)
	{
		org.r3.db.system.site.SiteDTO siteDTO = super.selectBySite(site, pcfg);			
		return siteDTO;
	}

	@Override
	public org.r3.db.system.site.SiteDTO selectByPrimaryKey(org.r3.db.system.site.SiteKey pk,
			org.r3.db.PersistenceConfigInfo pcfg)
	{
		org.r3.db.system.site.SiteDTO dto = super.selectByPrimaryKey(pk, pcfg);
		return dto;
	}

	@Override
	public org.r3.db.system.site.SiteDTO selectFirst(org.r3.db.system.site.SiteFilter filterCondition,
			org.r3.db.PersistenceConfigInfo pcfg)
	{
		org.r3.db.system.site.SiteDTO dto = super.selectFirst(filterCondition, pcfg);
		return dto;
	}
		 */  		
}
