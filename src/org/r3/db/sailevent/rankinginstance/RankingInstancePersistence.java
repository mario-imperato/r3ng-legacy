//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.sailevent.rankinginstance;

import org.r3.db.PersistenceConfigInfo;
import org.r3.db.sailevent.ranking.RankingDTO;
import org.r3.db.sailevent.rankinginstance.RankingInstanceDTO.InstanceType;

public class RankingInstancePersistence extends RankingInstancePersistenceBase
{
	public static RankingInstancePersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg,
					org.apache.ibatis.session.SqlSession aSession)
	{
		RankingInstancePersistence p = new RankingInstancePersistence();
		p.setMapper(aSession.getMapper(RankingInstanceMapper.class));
		p.setSequencePersistence(pcfg.getSequencePersistence());
		return p;
	}

	public RankingInstanceDTO selectByEventidRankidRacenumber(String eventid, String rankid, int i, PersistenceConfigInfo pcfg)
	{
		RankingInstanceFilter filter = new RankingInstanceFilter();
		filter.or().andEventidEqualTo(eventid).andRankidEqualTo(rankid).andRacenumberEqualTo(i);
		return selectFirst(filter, pcfg);
	}

	public RankingInstanceDTO selectByEventidRankidInstancetypeRacenumber(String eventid, String rankid, InstanceType it, int i, PersistenceConfigInfo pcfg)
	{
		RankingInstanceFilter filter = new RankingInstanceFilter();
		RankingInstanceCriteria c = filter.or().andEventidEqualTo(eventid).andRankidEqualTo(rankid);
		if (it == InstanceType.rank_race)
		{
			c.andRacenumberEqualTo(i);
			c.andInstancetypeEqualTo(it.toString());
	    }
		else  c.andInstancetypeEqualTo(it.toString());
		
		return selectFirst(filter, pcfg);
	}
	
	public RankingInstanceDTO newRankingDetailInstance(PersistenceConfigInfo pcfg, RankingDTO rDto, InstanceType it,  int i)
	{
		
		RankingInstanceDTO instanceDTO = selectByEventidRankidInstancetypeRacenumber(rDto.getEventid(), rDto.getRankid(), it, i, pcfg);
		if (instanceDTO == null)
		{
		instanceDTO = new RankingInstanceDTO();
		instanceDTO.setEventid(rDto.getEventid());
		instanceDTO.setRankid(rDto.getRankid());
		instanceDTO.setInstancetype(it.toString());
		instanceDTO.setRacenumber(i);
		}
		
		return instanceDTO;
	}
}
