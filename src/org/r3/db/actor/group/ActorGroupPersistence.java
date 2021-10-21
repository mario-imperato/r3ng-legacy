//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.actor.group;

import org.r3.db.PersistenceConfigInfo;

public class ActorGroupPersistence extends ActorGroupPersistenceBase
{
	public static ActorGroupPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg,
					org.apache.ibatis.session.SqlSession aSession)
	{
		ActorGroupPersistence p = new ActorGroupPersistence();
		p.setMapper(aSession.getMapper(ActorGroupMapper.class));
		p.setSequencePersistence(pcfg.getSequencePersistence());
		return p;
	}

	public ActorGroupDataTableAdapter queryByEventidActorid(String requestSiteId, String actorId,
					PersistenceConfigInfo persistenceConfigInfo)
	{
		ActorGroupFilter filter = new ActorGroupFilter();
		filter.or().andEventidEqualTo(requestSiteId).andActoridEqualTo(requestSiteId, actorId);

		ActorGroupDataTableAdapter dt = this.query(filter, persistenceConfigInfo, "1", -1, -1, false);
		return dt;
	}

	
	
}
