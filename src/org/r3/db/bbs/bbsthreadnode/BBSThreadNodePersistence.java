//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.bbs.bbsthreadnode;

import java.util.List;

import org.r3.db.PersistenceConfigInfo;
import org.r3.db.utils.SQLStringUtils;
import org.r3.db.utils.SQLStringUtils.LikeMode;

public class BBSThreadNodePersistence extends BBSThreadNodePersistenceBase
{
	public static BBSThreadNodePersistence createPersistenceObject(
			org.r3.db.PersistenceContext pcfg,
			org.apache.ibatis.session.SqlSession aSession)
	{
		BBSThreadNodePersistence p = new BBSThreadNodePersistence();
		p.setMapper(aSession.getMapper(BBSThreadNodeMapper.class));
		p.setSequencePersistence(pcfg.getSequencePersistence());
		return p;
	}

	public List<BBSThreadNodeDTO> selectBySiteThreadid(String aSite,
			String aThreadId, PersistenceConfigInfo persistenceConfigInfo)
	{
		BBSThreadNodeFilter f = new BBSThreadNodeFilter();
		f.or().andSiteEqualTo(aSite).andThreadidEqualTo(aThreadId);
		f.setOrderByClause(" threadnodeid ");

		List<BBSThreadNodeDTO> l = select(f, persistenceConfigInfo);
		return l;
	}

	public int deleteBySiteTopicid(String aSite, String aTopicId,
			PersistenceConfigInfo persistenceConfigInfo)
	{
		BBSThreadNodeFilter f = new BBSThreadNodeFilter();
		f.or().andSiteEqualTo(aSite).andTopicidEqualTo(aSite, aTopicId);

		return this.delete(f, persistenceConfigInfo);
	}

	public int deleteBySiteThreadid(String aSite, String aThreadId,
			PersistenceConfigInfo persistenceConfigInfo)
	{
		BBSThreadNodeFilter f = new BBSThreadNodeFilter();
		f.or().andSiteEqualTo(aSite).andThreadidEqualTo(aThreadId);

		return this.delete(f, persistenceConfigInfo);		
	}
	
	@Override
    public int deleteByThreadnodeid(java.lang.String threadnodeid, org.r3.db.PersistenceConfigInfo pcfg)
	{
		int numberOfRowsAffected = 0;
		
		BBSThreadNodeDTO dto = selectByThreadnodeid(threadnodeid, pcfg);
		if (dto != null)
		{
			BBSThreadNodeFilter f = new BBSThreadNodeFilter();
			f.or().andNodepathLike(SQLStringUtils.getStringForLikeMode(dto.getChildrenNodepathPrefix(), LikeMode.LeftLike));
			numberOfRowsAffected = this.delete(f, pcfg);
			
			numberOfRowsAffected += super.deleteByThreadnodeid(threadnodeid, pcfg);
		}
		
		return numberOfRowsAffected;
	}  
}
