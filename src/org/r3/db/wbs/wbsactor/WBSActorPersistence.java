//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.wbs.wbsactor;

import org.r3.db.PersistenceConfigInfo;
import org.r3.db.wbs.wbsactor.WBSActorDTO.WBSActorRole;

public class WBSActorPersistence extends WBSActorPersistenceBase
{
	public static WBSActorPersistence createPersistenceObject(
			org.r3.db.PersistenceContext pcfg,
			org.apache.ibatis.session.SqlSession aSession)
	{
		WBSActorPersistence p = new WBSActorPersistence();
		p.setMapper(aSession.getMapper(WBSActorMapper.class));
		p.setSequencePersistence(pcfg.getSequencePersistence());
		return p;
	}

	public int deleteManagingActorsBySiteWbsid(String aSite, String aWbsId, PersistenceConfigInfo pcfg)
	{
		WBSActorFilter filter = new WBSActorFilter();
		filter.or().andSiteEqualTo(aSite).andWbsidEqualTo(aWbsId).andActorroleEqualTo(WBSActorRole.manager.toString());
		filter.or().andSiteEqualTo(aSite).andWbsidEqualTo(aWbsId).andActorroleEqualTo(WBSActorRole.coach.toString());
		filter.or().andSiteEqualTo(aSite).andActorroleEqualTo(WBSActorRole.sponsor.toString());
		
		return delete(filter, pcfg);
	}
}
