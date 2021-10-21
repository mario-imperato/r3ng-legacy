//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.system.smsqueueitem;

import java.util.List;

import org.r3.db.PersistenceConfigInfo;


public class SMSQueueItemPersistence extends SMSQueueItemPersistenceBase
{
	public static SMSQueueItemPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg,
					org.apache.ibatis.session.SqlSession aSession)
	{
		SMSQueueItemPersistence p = new SMSQueueItemPersistence();
		p.setMapper(aSession.getMapper(SMSQueueItemMapper.class));
		return p;
	}

	public List<SMSQueueItemDTO> selectBySiteSmsid(String site, String smsId, PersistenceConfigInfo persistenceConfigInfo)
	{
		SMSQueueItemFilter filter = new SMSQueueItemFilter();
		filter.or().andSiteEqualTo(site).andSmsidEqualTo(smsId);
		
		filter.setOrderByClause(" phonenumber ");
		return select(filter, persistenceConfigInfo);
	}


}
