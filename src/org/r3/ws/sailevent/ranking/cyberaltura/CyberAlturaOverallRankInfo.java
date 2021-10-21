package org.r3.ws.sailevent.ranking.cyberaltura;

import org.r3.db.sailevent.rankinginstance.RankingInstanceDTO;


public class CyberAlturaOverallRankInfo extends CyberAlturaRankInfo
{			
	private int numberOfRaces;

	public CyberAlturaOverallRankInfo()
	{
		numberOfRaces = 99;
	}
	
	public int getNumberOfRaces()
	{
		return numberOfRaces;
	}

	public void setNumberOfRaces(int numberOfRaces)
	{
		this.numberOfRaces = numberOfRaces;
	}
	
	public void populateFromRankInfo(RankingInstanceDTO dto)
	{
		dto.setSoftwareversion(getSoftwareversion());
		dto.setSoftwarecode(getSoftwarecode());
		dto.setRectimestamp(getRankdate());
		dto.setRacenumber(getNumberOfRaces());
	}
}
