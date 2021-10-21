//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.bbs.bbsthread;

import java.util.List;

import org.r3.db.PersistenceConfigInfo;

public class BBSThreadPersistence extends BBSThreadPersistenceBase
{
  public static BBSThreadPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  BBSThreadPersistence p = new BBSThreadPersistence();
	    p.setMapper(aSession.getMapper(BBSThreadMapper.class));
	    p.setSequencePersistence(pcfg.getSequencePersistence());
	    return p;
  }    

	public List<BBSThreadDTO> selectBySiteTopicid(String aSite, String aTopicId, PersistenceConfigInfo persistenceConfigInfo)
	{
		BBSThreadFilter f = new BBSThreadFilter();
		f.or().andSiteEqualTo(aSite).andTopicidEqualTo(aTopicId);
		f.setOrderByClause(" threadid " );
		
		List<BBSThreadDTO> l = select(f, persistenceConfigInfo);
		return l;
	}

	public int deleteBySiteTopicid(String aSite, String aTopicId,
			PersistenceConfigInfo persistenceConfigInfo)
	{
		BBSThreadFilter f = new BBSThreadFilter();
		f.or().andSiteEqualTo(aSite).andTopicidEqualTo(aTopicId);

		int nd = delete(f, persistenceConfigInfo);
		return nd;
	}
	
	public int updatePostCountersOnAddBySiteThreadid(String aSite, String aThreadId, String aThreadNodeId,
			PersistenceConfigInfo persistenceConfigInfo)
	{
		int nd = this.mapper.updatePostCountersOnAddBySiteThreadid(aSite, aThreadId, aThreadNodeId, persistenceConfigInfo);
		return nd;
	}
	
	public int updatePostCountersOnDeleteBySiteThreadid(String aSite, String aThreadId, int numPosts,
			PersistenceConfigInfo persistenceConfigInfo)
	{
		int nd = this.mapper.updatePostCountersOnDeleteBySiteThreadid(aSite, aThreadId, numPosts, persistenceConfigInfo);
		return nd;
	}
}
  
