package org.r3.ws.sailevent.ranking.cyberaltura;

import org.r3.db.DTOBase;
import org.r3.db.sailevent.rankinginstancedetail.RankingInstanceDetailDTO;
import org.r3.system.util.StringUtils;

public abstract class CyberAlturaRankEntry
{
	private String sailNumber;
	private String yachtName;
	private String owner;
	private String club;
	private String model;
	private String div;
	private String classe;
	private String timoniere;
	private int pos;
	
	public CyberAlturaRankEntry()
	{

	}

	public String getSailNumber()
	{
		return sailNumber;
	}

	public void setSailNumber(String s)
	{
		if (s != null)
		    s = s.trim();
		
		this.sailNumber = DTOBase.nullOnEmpty(s);		   
	}

	public String getOwner()
	{
		return owner;
	}

	public void setOwner(String s)
	{
		if (s != null)
		    s = s.trim();
		
		this.owner = DTOBase.nullOnEmpty(s);		   
	}

	public String getClasse()
	{
		return classe;
	}

	public void setClasse(String s)
	{
		if (s != null)
		    s = s.trim();
		
		this.classe = DTOBase.nullOnEmpty(s);	
	}

	public String getDiv()
	{
		return div;
	}

	public void setDiv(String s)
	{
		if (s != null)
		    s = s.trim();
		
		this.div = DTOBase.nullOnEmpty(s);		   
	}
	
	public String getClub()
	{
		return club;
	}

	public void setClub(String s)
	{
		if (s != null)
		    s = s.trim();
		
		this.club = DTOBase.nullOnEmpty(s);		   
	}

	public String getModel()
	{
		return model;
	}

	public void setModel(String s)
	{
		if (s != null)
		    s = s.trim();
		
		this.model = DTOBase.nullOnEmpty(s);	
	}

	public int getPos()
	{
		return pos;
	}

	public void setPos(int pos)
	{
		this.pos = pos;
	}
	
	public String getYachtName()
	{
		return yachtName;
	}

	public void setYachtName(String s)
	{
		if (s != null)
		    s = s.trim();
		
		this.yachtName = DTOBase.nullOnEmpty(s);		   
	}
	
	public String getTimoniere()
	{
		return timoniere;
	}

	public void setTimoniere(String timoniere)
	{
		this.timoniere = timoniere;
	}

	public static class CyberAlturaRankEntryTableHeaderInfo
	{
		private int[] mappingVector;
		private int   maxNumberOfRaces;
		
		public CyberAlturaRankEntryTableHeaderInfo(int[] aMappingVector, int n)
		{
			mappingVector = aMappingVector;
			maxNumberOfRaces = n;
		}

		public CyberAlturaRankEntryTableHeaderInfo(int[] aMappingVector)
		{
			this(aMappingVector, -1);
		}
		
		public int[] getMappingVector()
		{
			return mappingVector;
		}

		public int getMaxNumberOfRaces()
		{
			return maxNumberOfRaces;
		}

		public int getFieldIndexByColumnIndex(int columnIndex)
		{
			return mappingVector[columnIndex];
		}				
	}

	public static class CyberAlturaRankEntryScore implements Comparable
	{
		private int raceNumber;
	    private float score;
	    private String annotation;
	    
	    public CyberAlturaRankEntryScore(int aRaceNumber, String aScore)
	    {		    	
	    	raceNumber = aRaceNumber;
	    	score = -1;
	    	annotation = null;
	    	
	    	if (aScore == null)
	    		return;
	    	
	    	aScore = aScore.trim();
	    	if (aScore.length() == 0)
	    		return;
	    	
	    	if (StringUtils.existsOnlyInBag(aScore, "0123456789."))	
	    		score = Float.parseFloat(aScore);
	    	else
	    	{
	    		int ndx = 0;
	    		for(int i = 0; i < aScore.length(); i++)
	    		{
	    			if (!Character.isDigit(aScore.charAt(i)))
	    					break;
	    			
	    			ndx++;
	    		}
	    		
	    		if (ndx > 0)
	    		{
	    			score = Float.parseFloat(aScore.substring(0, ndx));
	    			if (ndx <  aScore.length())
	    			    aScore = aScore.substring(ndx);
	    			else aScore = null;
	    		}
	    		
	    		if (aScore != null)
	    		{
	    			if (aScore.length() > 4)
	    				aScore = aScore.substring(0, 4);
	    			
	    			annotation = aScore;
	    		}
	    	}
	    }

		public float getScore()
		{
			return score;
		}

		public String getAnnotation()
		{
			return annotation;
		}

		public int getRaceNumber()
		{
			return raceNumber;
		}
		
		public int compareTo(Object o)
		{
			CyberAlturaRankEntryScore another = (CyberAlturaRankEntryScore)o;
			if (getScore() == another.getScore())
				return 0;
			else if (getScore() > another.getScore())
				return 1;
			else return -1;
		}	    	    
	}
	
	public abstract void populate(java.sql.Date rankDate, RankingInstanceDetailDTO dto);
}
