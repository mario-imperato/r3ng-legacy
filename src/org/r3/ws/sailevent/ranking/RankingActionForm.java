package org.r3.ws.sailevent.ranking;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.sailevent.ranking.RankingDTO;

public class RankingActionForm
{
	
	@FormParam("rankordering")
    private String rankordering;

    public String getRankordering()
    {    	
    	return DTOBase.nullOnEmpty(rankordering);
    }

	@FormParam("rankinggroup")
    private String rankinggroup;

    public String getRankinggroup()
    {    	
    	return DTOBase.nullOnEmpty(rankinggroup);
    }
    
	@FormParam("ranktitle")
    private String ranktitle;

    public String getRanktitle()
    {    	
    	return DTOBase.nullOnEmpty(ranktitle);
    }
    
	@FormParam("championship")
    private String championship;

    public String getChampionship()
    {    	
    	return DTOBase.nullOnEmpty(championship);
    }

	@FormParam("racegroup")
    private String racegroup;

    public String getRacegroup()
    {    	
    	return DTOBase.nullOnEmpty(racegroup);
    }

	@FormParam("raceclass")
    private String raceclass;

    public String getRaceclass()
    {    	
    	return DTOBase.nullOnEmpty(raceclass);
    }

	@FormParam("rating")
    private String rating;

    public String getRating()
    {    	
    	return DTOBase.nullOnEmpty(rating);
    }

	@FormParam("racefilepattern")
    private String racefilepattern;

    public String getRacefilepattern()
    {    	
    	return DTOBase.nullOnEmpty(racefilepattern);
    }

	@FormParam("overallfilepattern")
    private String overallfilepattern;
    
    public String getOverallfilepattern()
    {    	
    	return DTOBase.nullOnEmpty(overallfilepattern);
    }
    	
	@FormParam("instanceid")
	private String[] instanceid;		

	public String[] getInstanceid()
	{
		return instanceid;
	}

	public RankingDTO getDTO4Insert(String aSite)
	{
		RankingDTO dto = new RankingDTO();
		dto.setEventid(aSite);
		dto.setRankinggroup(getRankinggroup());
		dto.setRanktitle(getRanktitle());
		dto.setRanktype("rank_filedet");
		dto.setChampionship(getChampionship());
		dto.setOverallfilepattern(getOverallfilepattern());
		dto.setRaceclass(getRaceclass());
		dto.setRacefilepattern(getRacefilepattern());
		dto.setRacegroup(getRacegroup());
		dto.setRating(getRating());		
		dto.setRankordering(getRankordering());
		return  dto;
	}

	public RankingDTO getDTO4Update(String aSite, String aRankId)
	{
		RankingDTO dto = new RankingDTO();
		dto.setEventid(aSite);
		dto.setRankid(aRankId);
		dto.setRankinggroup(getRankinggroup());
		dto.setRanktitle(getRanktitle());
		dto.setRankordering(getRankordering());
		dto.setChampionship(getChampionship());
		dto.setOverallfilepattern(getOverallfilepattern());
		dto.setRaceclass(getRaceclass());
		dto.setRacefilepattern(getRacefilepattern());
		dto.setRacegroup(getRacegroup());
		dto.setRating(getRating());		
		return  dto;
	}

	
}
