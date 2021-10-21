//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.channel;

import org.r3.db.PersistenceConfigInfo;

public class ChannelPersistence extends ChannelPersistenceBase
{
  public static ChannelPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  ChannelPersistence p = new ChannelPersistence();
	    p.setMapper(aSession.getMapper(ChannelMapper.class));
	    p.setSequencePersistence(pcfg.getSequencePersistence());
	    return p;
  }

	public ChannelDataTableAdapter selectBySiteCardid(String site, String aCardid, PersistenceConfigInfo persistenceConfigInfo)
	{
		ChannelFilter filter = new ChannelFilter();
		filter.or().andSiteCardidEqualTo(site, aCardid);
		filter.setOrderByClause(" channelname asc ");
		return query(filter, persistenceConfigInfo, "1", -1, -1, false);		
	}    

}
  
