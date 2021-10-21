package org.r3.db.sailevent.rankingview;

import java.util.List;

import org.r3.db.DTOBase;

public class RankingViewSynopticDTO extends DTOBase
{
	private String eventid;
	private String rankid;
	private String ranktitle;
    private String racegroup;
    private String raceclass;
    private String rankinggroup;
    
	public String getEventid()
	{
		return eventid;
	}

	public void setEventid(String eventid)
	{
		this.eventid = eventid;
	}

	public String getRankid()
	{
		return rankid;
	}

	public void setRankid(String rankid)
	{
		this.rankid = rankid;
	}

	public String getRanktitle()
	{
		return ranktitle;
	}

	public void setRanktitle(String ranktitle)
	{
		this.ranktitle = ranktitle;
	}

	private List<RankingViewDTO> listOfInstances;

	public List<RankingViewDTO> getListOfInstances()
	{
		return listOfInstances;
	}

	public void setListOfInstances(List<RankingViewDTO> listOfInstances)
	{
		this.listOfInstances = listOfInstances;
	}

	public String getRacegroup()
	{
		return racegroup;
	}

	public void setRacegroup(String racegroup)
	{
		this.racegroup = racegroup;
	}

	public String getRaceclass()
	{
		return raceclass;
	}

	public void setRaceclass(String raceclass)
	{
		this.raceclass = raceclass;
	}

	public String getRankinggroup()
	{
		return rankinggroup;
	}

	public void setRankinggroup(String rankinggroup)
	{
		this.rankinggroup = rankinggroup;
	}
	
	
}
