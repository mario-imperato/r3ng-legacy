package org.r3.ws.sailevent.ranking.cyberaltura;

import java.text.ParseException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.r3.ws.sailevent.ranking.cyberaltura.CyberAlturaRankEntry.CyberAlturaRankEntryTableHeaderInfo;

public class CyberAlturaOverallRankingParser extends CyberAlturaRankParser
{
	
	protected CyberAlturaOverallRankInfo parseTableFragment(List<String> htmlFragments) throws ParseException 
	{
		CyberAlturaOverallRankInfo rank = new CyberAlturaOverallRankInfo();
		rank.setHtmlListing(htmlFragments.get(2));
		parseSoftwareInfo(rank, htmlFragments.get(3));
		
		parseRankEntriesInfo(rank, htmlFragments.get(2));
		return rank;
	}
	
	protected boolean validate(List<String> htmlFragments) throws ParseException
	{
		if (htmlFragments.size() != 4)
			throw new ParseException("Unexpected Number Of Tables", htmlFragments.size());

		return true;
	}
	
	
	protected CyberAlturaOverallRankInfo parseRankEntriesInfo(
			CyberAlturaOverallRankInfo theRank, String htmlFragment)
			throws ParseException
	{
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
				tableHeaderInfo = CyberAlturaOverallRankEntry.parseRankEntriesTableHeader(aRow);
				theRank.setNumberOfRaces(tableHeaderInfo.getMaxNumberOfRaces());
			}
			else
			{
				CyberAlturaOverallRankEntry entry = new CyberAlturaOverallRankEntry(tableHeaderInfo.getMaxNumberOfRaces());
				Elements cols = aRow.select("td");
				int columnIndex = 0;
				for (Element aCol : cols)
				{
					String infoText = aCol.text().replace((char)160, ' ');
					entry.setValue(infoText, tableHeaderInfo.getFieldIndexByColumnIndex(columnIndex));					
					columnIndex++;
				}
				
				theRank.addRankEntry(entry);
			}

			rowNumber++;
		}

		return theRank;
	}    
}
