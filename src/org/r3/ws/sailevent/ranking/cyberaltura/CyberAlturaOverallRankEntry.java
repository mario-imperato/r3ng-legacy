package org.r3.ws.sailevent.ranking.cyberaltura;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Comparator;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.r3.db.sailevent.rankinginstancedetail.RankingInstanceDetailDTO;
import org.r3.system.util.StringUtils;
import org.r3.ws.sailevent.ranking.cyberaltura.CyberAltura_ListingInfo.CyberAlturaListingColumnInfo;

public class CyberAlturaOverallRankEntry extends CyberAlturaRankEntry
{
	
	


	private CyberAlturaRankEntryScore[] scores;
	private float   overallScore;
	
	public CyberAlturaOverallRankEntry(int maxNumberOfRaces)
	{
		scores = new CyberAlturaRankEntryScore[maxNumberOfRaces];
	}

	
	

	public float getOverallScore()
	{
		return overallScore;
	}

	public void setOverallScore(float overallScore)
	{
		this.overallScore = overallScore;
	}

	private void setScore(String raceScore, int i)
	{
        scores[i - 1] = new CyberAlturaRankEntryScore(i, raceScore);		
	}
	
	public void setValue(String infoText, int fieldIndex)
	{
        switch(fieldIndex)
        {
        case CyberAltura_ListingInfo.CRUCERO_LISTING_UNKNOWN_ID:
        	break;
        	
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
        case CyberAltura_ListingInfo.CRUCERO_LISTING_CLUB:
        	setClub(infoText);
        	break;
        case CyberAltura_ListingInfo.CRUCERO_LISTING_MODELLO:
        	setModel(infoText);
        	break;
        case CyberAltura_ListingInfo.CRUCERO_LISTING_PUNTI:
        	setOverallScore(Float.parseFloat(infoText));
        	break;

        case CyberAltura_ListingInfo.CRUCERO_LISTING_CLASSE:
        	setClasse(infoText);	
        	break;

        case CyberAltura_ListingInfo.CRUCERO_LISTING_DIV:
        	setDiv(infoText);	
        	break;

        case CyberAltura_ListingInfo.CRUCERO_LISTING_TIMONIERE:
        	setTimoniere(infoText);	
        	break;

        case CyberAltura_ListingInfo.CRUCERO_LISTING_RACESCORE1:
        case CyberAltura_ListingInfo.CRUCERO_LISTING_RACESCORE2:
        case CyberAltura_ListingInfo.CRUCERO_LISTING_RACESCORE3:
        case CyberAltura_ListingInfo.CRUCERO_LISTING_RACESCORE4:
        case CyberAltura_ListingInfo.CRUCERO_LISTING_RACESCORE5:
        case CyberAltura_ListingInfo.CRUCERO_LISTING_RACESCORE6:
        case CyberAltura_ListingInfo.CRUCERO_LISTING_RACESCORE7:
        case CyberAltura_ListingInfo.CRUCERO_LISTING_RACESCORE8:
        case CyberAltura_ListingInfo.CRUCERO_LISTING_RACESCORE9:
        case CyberAltura_ListingInfo.CRUCERO_LISTING_RACESCORE10:
        case CyberAltura_ListingInfo.CRUCERO_LISTING_RACESCORE11:
        case CyberAltura_ListingInfo.CRUCERO_LISTING_RACESCORE12:
        case CyberAltura_ListingInfo.CRUCERO_LISTING_RACESCORE13:
        case CyberAltura_ListingInfo.CRUCERO_LISTING_RACESCORE14:
        case CyberAltura_ListingInfo.CRUCERO_LISTING_RACESCORE15:

        	setScore(infoText, fieldIndex - CyberAltura_ListingInfo.CRUCERO_LISTING_RACESCORE1 + 1);	
        	break;        	
        	
        default:
        	break;
        }		        
	}

	// Metodo per il momento non utilizzato in quanto mi manca un meccanismo per le regate non scartabili.
    private void determineExclusions()
    {
    	Arrays.sort(scores, new Comparator<CyberAlturaRankEntryScore>() 
    	{
			public int compare(CyberAlturaRankEntryScore o1, CyberAlturaRankEntryScore o2)
			{
				return o1.compareTo(o2);				
			}    		
    	});
    	    	
    	float runningScores = overallScore;
    	for(int i = 0; i < scores.length; i++)
    	{
    		if (scores[i].getScore() > runningScores)
    			 System.out.println("Excluding: " + scores[i].getScore());
    		else runningScores = runningScores - scores[i].getScore();
    	}
    }
    
    /*
	public static final String[] overallRankEntriesColumns = { 
	    "Pos", "N.Velico",
		"Yacht", "Armatore", "Club", "Modello", "RaceScore1", "RaceScore2", "RaceScore3", "RaceScore4", "RaceScore5",
		"RaceScore6", "RaceScore7", "RaceScore8", "RaceScore9", "RaceScore10", "RaceScore11", "RaceScore12", "RaceScore13", "RaceScore14", "RaceScore15",
		"Punti", "Classe", "Div", "Timoniere" };
     */
    
	public static CyberAlturaRankEntryTableHeaderInfo parseRankEntriesTableHeader(Element aRow) throws ParseException
    {
    	int columnIndex = 0;
    	int maxRaces = -1;
    	Elements cols = aRow.select("td");
    	
    	int[] resMapping = new int[cols.size()];
		for(Element aCol : cols)
		{
			String aColText = aCol.text();
			if (StringUtils.existsOnlyInBag(aColText, "0123456789"))
			{
				int raceNumber = Integer.parseInt(aColText);
				if (raceNumber > maxRaces)
					maxRaces = raceNumber;
				
				aColText = "RaceScore" + aColText;
			}
			
            // int columnId = findColumnIdFor(aColText);
			CyberAlturaListingColumnInfo columnInfo = CyberAltura_ListingInfo.getListingColumn4(aColText);
			resMapping[columnIndex] = columnInfo.getHeaderId();
			
			columnIndex++;
		}
		
    	return new CyberAlturaRankEntryTableHeaderInfo(resMapping, maxRaces);
    }

//	private static int findColumnIdFor(String text) throws ParseException
//	{
//		for(int i = 0; i < overallRankEntriesColumns.length; i++)
//		{
//			if (overallRankEntriesColumns[i].indexOf(text) >= 0)
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
		dto.setClub(getClub());		
		dto.setDivision(getDiv());
		dto.setRacegroup(getClasse());
		dto.setTimoniere(getTimoniere());
		
		dto.setScore(getOverallScore());
		dto.setMaxraces(scores.length);
		
		for(CyberAlturaRankEntryScore aScore : scores)
		{
			dto.setRaceScore(aScore.getRaceNumber(), aScore.getScore(), aScore.getAnnotation());
		}
	}

}
