package org.r3.ws.sailevent.ranking.cyberaltura;

import java.text.ParseException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.r3.ws.sailevent.ranking.cyberaltura.CyberAlturaRankEntry.CyberAlturaRankEntryTableHeaderInfo;


public class CyberAlturaRaceRankParser extends CyberAlturaRankParser
{
    
	protected CyberAlturaRaceRankInfo parseTableFragment(List<String> htmlFragments) throws ParseException 
	{
		CyberAlturaRaceRankInfo rank = new CyberAlturaRaceRankInfo();
		rank.setHtmlListing(htmlFragments.get(3));
		
		parseRankInfo(rank, htmlFragments.get(2));
		parseSoftwareInfo(rank, htmlFragments.get(4));
		parseRankEntriesInfo(rank, htmlFragments.get(3));
		return rank;
	}
	
	protected boolean validate(List<String> htmlFragments) throws ParseException
	{
		if (htmlFragments.size() != 5)
			throw new ParseException("Unexpected Number Of Tables", htmlFragments.size());

		return true;
	}

    protected CyberAlturaRaceRankInfo parseRankInfo(CyberAlturaRaceRankInfo theRank, String htmlFragment)
    {
		Document jsoupDocument = Jsoup.parseBodyFragment(htmlFragment);
		Elements infos = jsoupDocument.select("font");		
		
		for(Element info : infos)
		{
			String infoText = info.text();
          
			infoText = infoText.replace("\u00A0"," ");
			if (infoText.startsWith(CYBERALTURA_FIELD_DATE_PREFIX))
			{
				theRank.setRacedate(infoText.substring(CYBERALTURA_FIELD_DATE_PREFIX.length()));	
			}
			
			if (infoText.startsWith(CYBERALTURA_FIELD_TIME_PREFIX))
			{
				theRank.setRacetime(infoText.substring(CYBERALTURA_FIELD_TIME_PREFIX.length()));	
			}

			if (infoText.startsWith(CYBERALTURA_FIELD_DISTANCE_PREFIX))
			{
				theRank.setRacedistance(infoText.substring(CYBERALTURA_FIELD_DISTANCE_PREFIX.length()));	
			}

			if (infoText.startsWith(CYBERALTURA_FIELD_COEFFICIENT_PREFIX))
			{
				theRank.setRacecoefficient(infoText.substring(CYBERALTURA_FIELD_COEFFICIENT_PREFIX.length()));	
			}

			theRank.setRacerating(infoText);				
		}
		
		return theRank;
    }

	protected CyberAlturaRaceRankInfo parseRankEntriesInfo(
			CyberAlturaRaceRankInfo theRank, String htmlFragment)
			throws ParseException
	{
		theRank.setMinrealtime(-1);
		
		Document jsoupDocument = Jsoup.parseBodyFragment(htmlFragment);
		Elements rows = jsoupDocument.select("tr");
		if (rows.size() == 0)
		{
		}

		int rowNumber = 0;
		CyberAlturaRankEntryTableHeaderInfo tableHeaderInfo = null;
		for (Element aRow : rows)
		{
			if (rowNumber == 0)
			{
				tableHeaderInfo = CyberAlturaRaceRankEntry.parseRankEntriesTableHeader(aRow);
			}
			else
			{
				CyberAlturaRaceRankEntry entry = new CyberAlturaRaceRankEntry();
				Elements cols = aRow.select("td");
				int columnIndex = 0;
				for (Element aCol : cols)
				{
					String infoText = aCol.text().replace((char)160, ' ');
					entry.setValue(infoText, tableHeaderInfo.getFieldIndexByColumnIndex(columnIndex));					
					columnIndex++;
				}
				
				theRank.addRankEntry(entry);
				theRank.updateMinrealtime(entry.getElapsedRealTimeAsSeconds());					
			}

			rowNumber++;
		}

		theRank.computeRealtimeDeltas();
		return theRank;
	}    
        
}
