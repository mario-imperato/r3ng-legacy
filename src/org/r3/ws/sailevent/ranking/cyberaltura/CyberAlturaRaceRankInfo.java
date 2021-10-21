package org.r3.ws.sailevent.ranking.cyberaltura;

import java.util.List;

import org.r3.db.DTOBase;
import org.r3.db.sailevent.rankinginstance.RankingInstanceDTO;

public class CyberAlturaRaceRankInfo extends CyberAlturaRankInfo
{		


	private java.sql.Date racedate;
	private String        racetime;
	private double        racedistance;
	private String        racecoefficient;
	private String        racerating;
	private int           minrealtime;
	
	
	public int getMinrealtime()
	{
		return minrealtime;
	}

	public void setMinrealtime(int minrealtime)
	{
		this.minrealtime = minrealtime;
	}

	public void setRacedate(String aDateStr)
	{
        racedate = DTOBase.stringAsDate(aDateStr, dateFormat);		
	}

	public java.sql.Date getRacedate()
	{
		return racedate;
	}

	public String getRacetime()
	{
		return racetime;
	}

	public double getRacedistance()
	{
		return racedistance;
	}

	public String getRacecoefficient()
	{
		return racecoefficient;
	}

	public String getRacerating()
	{
		return racerating;
	}

	public void setRacetime(String aTimeSubstr)
	{
		racetime = aTimeSubstr;		
	}

	public void setRacedistance(String s)
	{
		racedistance = DTOBase.stringAsDouble(s);		
	}

	public void setRacecoefficient(String s)
	{
		racecoefficient = s;						
	}

	public void setRacerating(String s)
	{
		racerating = s;
	}

	public void updateMinrealtime(Integer elapsedRealTimeAsSeconds)
	{
	    if (elapsedRealTimeAsSeconds != null)
	    {
	    	int mr = getMinrealtime();
	    	if (mr < 0 || mr > elapsedRealTimeAsSeconds)
	    		setMinrealtime(elapsedRealTimeAsSeconds);	    		
	    }
	}

	public void computeRealtimeDeltas()
	{		
		List<CyberAlturaRankEntry> listre = getListOfRankEntry();
		if (listre != null)
		{
			for(CyberAlturaRankEntry re : listre)
			{
				((CyberAlturaRaceRankEntry)re).setRealtimeDelta(getMinrealtime());
				
			}
		}
	}

	public void populateFromRankInfo(RankingInstanceDTO dto)
	{
		dto.setRacedate(getRacedate());
		dto.setRacecoefficient(getRacecoefficient());
		dto.setRacetime(getRacetime());
		dto.setRacedistance(getRacedistance());
		dto.setRacerating(getRacerating());
		dto.setMinrealtime((getMinrealtime() >= 0) ? getMinrealtime() : null);
		dto.setSoftwareversion(getSoftwareversion());
		dto.setSoftwarecode(getSoftwarecode());
		dto.setRectimestamp(getRankdate());
	}
	
}
