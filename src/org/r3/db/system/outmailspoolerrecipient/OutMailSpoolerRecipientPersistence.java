//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.system.outmailspoolerrecipient;

import java.util.List;

import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.PersistenceConfigInfo;

public class OutMailSpoolerRecipientPersistence extends
		OutMailSpoolerRecipientPersistenceBase
{
	public static OutMailSpoolerRecipientPersistence createPersistenceObject(
			org.r3.db.PersistenceContext pcfg,
			org.apache.ibatis.session.SqlSession aSession)
	{
		OutMailSpoolerRecipientPersistence p = new OutMailSpoolerRecipientPersistence();
		p.setMapper(aSession.getMapper(OutMailSpoolerRecipientMapper.class));
		return p;
	}

	public List<OutMailSpoolerRecipientDTO> selectActiveRecipientByMessageId(String aTargetSite, String aMessageId, int batchSize, PersistenceConfigInfo pcfg)
	{
		List<OutMailSpoolerRecipientDTO> l = null;
		
		OutMailSpoolerRecipientFilter f = new OutMailSpoolerRecipientFilter();
		f.or().andSiteEqualTo(aTargetSite).andMessageidEqualTo(aMessageId).andRecstatusEqualTo(RecordStatus.sys_recact.toString());
		f.setLimitFetch(batchSize);
		f.setOrderByClause(" recipientid asc ");
		
		l = select(f, pcfg);
		return l;
	}
	
	public int updateRecstatusByRecipientid(int aRecipientId, String recStatus, PersistenceConfigInfo pcfg)
	{
		return this.mapper.updateRecstatusByRecipientid(aRecipientId, recStatus, pcfg);
	}
}
