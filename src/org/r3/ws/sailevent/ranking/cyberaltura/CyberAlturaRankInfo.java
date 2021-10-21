package org.r3.ws.sailevent.ranking.cyberaltura;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.r3.db.DTOBase;
import org.r3.db.sailevent.rankinginstance.RankingInstanceDTO;

public abstract class CyberAlturaRankInfo
{
	protected static DateFormat timestampFormatH = new SimpleDateFormat("HH:mm:ss");
	protected static DateFormat timestampFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	protected static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	private String htmlListing;

	private String        softwareversion;
	private String        softwarecode;
	
	private java.sql.Timestamp rankdate;
	
	public CyberAlturaRankInfo()
	{
	}

	private List<CyberAlturaRankEntry> listOfRankEntry;
	
	public List<CyberAlturaRankEntry> getListOfRankEntry()
	{
		return listOfRankEntry;
	}

	public void setListOfRankEntry(List<CyberAlturaRankEntry> listOfRankEntry)
	{
		this.listOfRankEntry = listOfRankEntry;
	}

	public void addRankEntry(CyberAlturaRankEntry entry)
	{
		if (listOfRankEntry == null)
			listOfRankEntry = new ArrayList<CyberAlturaRankEntry>();
		
		listOfRankEntry.add(entry);		
	}
	
	public void setSoftwareversion(String s)
	{
		softwareversion = s;
	}

	public void setSoftwarecode(String s)
	{
		softwarecode = s;
	}
	
	public String getSoftwareversion()
	{
		return softwareversion;
	}

	public String getSoftwarecode()
	{
		return softwarecode;
	}
	
	public void setRankdate(String s)
	{		
		rankdate = DTOBase.stringAsTimestamp(s, timestampFormat);
	}

	public java.sql.Timestamp getRankdate()
	{
		return rankdate;
	}

	public void setRankdate(java.sql.Timestamp rankdate)
	{
		this.rankdate = rankdate;
	}

	public String getHtmlListing()
	{
		return htmlListing;
	}

	public void setHtmlListing(String htmlListing)
	{
		this.htmlListing = htmlListing;
	}
	
	public abstract void populateFromRankInfo(RankingInstanceDTO dto);
}
