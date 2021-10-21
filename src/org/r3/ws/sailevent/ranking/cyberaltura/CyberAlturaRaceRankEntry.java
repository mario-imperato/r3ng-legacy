package org.r3.ws.sailevent.ranking.cyberaltura;

import java.text.ParseException;
import java.util.Calendar;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.r3.db.DTOBase;
import org.r3.db.sailevent.rankinginstancedetail.RankingInstanceDetailDTO;
import org.r3.system.util.TimeUtils;
import org.r3.ws.sailevent.ranking.cyberaltura.CyberAltura_ListingInfo.CyberAlturaListingColumnInfo;

public class CyberAlturaRaceRankEntry extends CyberAlturaRankEntry
{
	private int pos;
//	private String owner;

	private String arrivalDate;
	private String elapsedRealTime;
	private String elapsedCorrectedTime;
	private String annotation;
	private float score;
    private Integer realtimeDelta;
    private String perctempen;
    
//	public int getPos()
//	{
//		return pos;
//	}
//
//	public void setPos(int pos)
//	{
//		this.pos = pos;
//	}
//
//	public String getOwner()
//	{
//		return owner;
//	}

//	public void setOwner(String s)
//	{
//		if (s != null)
//			s = s.trim();
//		
//		this.owner = DTOBase.nullOnEmpty(s);
//	}

	public String getArrivalDate()
	{
		return arrivalDate;
	}

	public void setArrivalDate(String s)
	{		
		if (s != null)
		{
		    s = s.trim();		    
		}
		
		this.arrivalDate = DTOBase.nullOnEmpty(s);		   
		
	}

	public java.sql.Timestamp getArrivalDateAsTimestamp(java.sql.Date aRankDate)
	{		
	    if (arrivalDate != null && arrivalDate.length() > 0)
	    {
			Calendar c = Calendar.getInstance();
			c.setTime(aRankDate);
	 
			// Debbo verificare la presenza del giorno.
			int ndx = arrivalDate.indexOf(' ');
			if (ndx > 0)
			{
				String fullDays = arrivalDate.substring(0, ndx);
				try
				{
				    int numberOfDaysTaken = Integer.parseInt(fullDays);
				    c.add(Calendar.DAY_OF_YEAR, numberOfDaysTaken);
				    
				    arrivalDate = arrivalDate.substring(ndx + 1);
				}
				catch(NumberFormatException p)
				{
					p.printStackTrace();
				}
			}
			
			String[] timeComponents = arrivalDate.split("[:\\.]");
			c.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeComponents[0]));
			c.set(Calendar.MINUTE, Integer.parseInt(timeComponents[1]));
			c.set(Calendar.SECOND, Integer.parseInt(timeComponents[2]));
			
	    	return new java.sql.Timestamp(c.getTimeInMillis());
	    }
	    
	    return null;
	}
	
	public String getElapsedRealTime()
	{
		return elapsedRealTime;
	}

	public void setElapsedRealTime(String s)
	{
		if (s != null)
		    s = s.trim();
		
		this.elapsedRealTime = DTOBase.nullOnEmpty(s);		   
	}

	public Integer getElapsedRealTimeAsSeconds()
	{
		if (elapsedRealTime != null && elapsedRealTime.length() > 0)
	    {
			int t = TimeUtils.get_HH_mm_ss_TimeAsSecondsFromMidnight(elapsedRealTime);
			if (t > 0)
				return t;
	    }
		
		return null;
	}
	
	public String getElapsedCorrectedTime()
	{
		return elapsedCorrectedTime;
	}

	public Integer getElapsedCorrectedTimeAsSeconds()
	{
		if (elapsedCorrectedTime != null && elapsedCorrectedTime.length() > 0)
	    {
			int t = TimeUtils.get_HH_mm_ss_TimeAsSecondsFromMidnight(elapsedCorrectedTime);
			if (t >= 0)
				return t;
	    }
		
		return null;
	}

	public void setElapsedCorrectedTime(String s)
	{
		if (s != null)
		    s = s.trim();
		
		this.elapsedCorrectedTime = DTOBase.nullOnEmpty(s);		   
	}

	public Integer getRealtimeDelta()
	{
		return realtimeDelta;
	}

	public void setRealtimeDelta(Integer minRealtimeDelta)
	{
		Integer er = getElapsedRealTimeAsSeconds();
		if (er != null)
		   this.realtimeDelta = er - minRealtimeDelta;
	}

	
	public String getPerctempen()
	{
		return perctempen;
	}

	public void setPerctempen(String perctempen)
	{
		this.perctempen = perctempen;
	}

	public String getAnnotation()
	{
		return annotation;
	}

	public void setAnnotation(String s)
	{
		if (s != null)
		    s = s.trim();
		
		this.annotation = DTOBase.nullOnEmpty(s);		   
	}

	public float getScore()
	{
		return score;
	}

	public void setScore(float score)
	{
		this.score = score;
	}

	public void setValue(String infoText, int fieldIndex)
	{
        switch(fieldIndex)
        {
        case CyberAltura_ListingInfo.CRUCERO_LISTING_POS:
        	setPos(Integer.parseInt(infoText));
        	break;
        case CyberAltura_ListingInfo.CRUCERO_LISTING_N_VELICO:
        	setSailNumber(infoText);
        	break;
        case CyberAltura_ListingInfo.CRUCERO_LISTING_YACHT:
        	setYachtName(infoText);
        	break;
        case CyberAltura_ListingInfo.CRUCERO_LISTING_ARMATORE:
        	setOwner(infoText);
        	break;
        case CyberAltura_ListingInfo.CRUCERO_LISTING_ORA_ARRIVO:
        	setArrivalDate(infoText);
        	break;
        case CyberAltura_ListingInfo.CRUCERO_LISTING_T_REALE:
        	setElapsedRealTime(infoText);
        	break;
        case CyberAltura_ListingInfo.CRUCERO_LISTING_T_CORRETTI:
        	setElapsedCorrectedTime(infoText);
        	break;
        case CyberAltura_ListingInfo.CRUCERO_LISTING_OSS:
        	setAnnotation(infoText);
        	break;
        case CyberAltura_ListingInfo.CRUCERO_LISTING_PUNTI:
        	setScore(Float.parseFloat(infoText));
        	break;
        case CyberAltura_ListingInfo.CRUCERO_LISTING_CLASSE:
        	setClasse(infoText);
        	break;
        case CyberAltura_ListingInfo.CRUCERO_LISTING_MODELLO:
        	setModel(infoText);
        	break;	
        case CyberAltura_ListingInfo.CRUCERO_LISTING_CLUB:
        	setClub(infoText);
        	break;	
        case CyberAltura_ListingInfo.CRUCERO_LISTING_DIV:
        	setDiv(infoText);
        	break;	
        case CyberAltura_ListingInfo.CRUCERO_LISTING_TIMONIERE:
        	setTimoniere(infoText);
        	break;	    
        case CyberAltura_ListingInfo.CRUCERO_LISTING_PERC_PEN_TEM_: 
        	setPerctempen(infoText);
        	break;
        default:
            System.out.printf("Field Not Handled %d - %s", fieldIndex, infoText);		
        }		
	}

	/* 24/03/2018 11:15:44 
	public static final String[] rankEntriesColumns = { 
	    "Pos", "N.Velico",
		"Yacht", "Armatore", "Ora Arrivo", "T.Reale", "T.Corretti", "Oss",
		"Punti", "Classe", "Modello", "Club", "Div", "Timoniere", "% Pen.Tem." };
	*/
	
	public static CyberAlturaRankEntryTableHeaderInfo parseRankEntriesTableHeader(Element aRow) throws ParseException
    {
    	int columnIndex = 0;
    	Elements cols = aRow.select("td");
    	
    	int[] resMapping = new int[cols.size()];
		for(Element aCol : cols)
		{
			// int columnId = findColumnIdFor(aCol.text());

			CyberAlturaListingColumnInfo columnInfo = CyberAltura_ListingInfo.getListingColumn4(aCol.text());			
			resMapping[columnIndex] = columnInfo.getHeaderId();
			
			columnIndex++;
		}
		
    	return new CyberAlturaRankEntryTableHeaderInfo(resMapping);
    }

//	private static int findColumnIdFor(String text) throws ParseException
//	{
//		for(int i = 0; i < rankEntriesColumns.length; i++)
//		{
//			if (rankEntriesColumns[i].indexOf(text) >= 0)
//				return i;
//		}
//
//		throw new ParseException("Unexpected Column Found In Ranking Entries - " + text, 0);
//	}

	@Override
	public void populate(java.sql.Date rankDate, RankingInstanceDetailDTO dto)
	{
		dto.setPos(getPos());
		dto.setSailnumber(getSailNumber());
		dto.setYachtname(getYachtName());
		dto.setOwner(getOwner());
		dto.setModel(getModel());
		dto.setDivision(getDiv());
		dto.setTimoniere(getTimoniere());
		dto.setClub(getClub());
		dto.setRacegroup(getClasse());
		
		dto.setArrivaldate(getArrivalDateAsTimestamp(rankDate));
		dto.setRealtime(getElapsedRealTimeAsSeconds());
		dto.setCorrectedtime(getElapsedCorrectedTimeAsSeconds());
		dto.setDrealtime(getRealtimeDelta());
		dto.setAnnotation(getAnnotation());
		dto.setScore(getScore());	
    	dto.setPerctempen(getPerctempen());
	}
	
	
}
