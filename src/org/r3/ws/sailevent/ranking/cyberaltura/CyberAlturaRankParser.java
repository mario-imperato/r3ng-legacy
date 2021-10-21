package org.r3.ws.sailevent.ranking.cyberaltura;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public abstract class CyberAlturaRankParser
{
    protected static final String CYBERALTURA_FIELD_DATE_PREFIX = "Data :";
    protected static final String CYBERALTURA_FIELD_TIME_PREFIX = "Ora Partenza :";
    protected static final String CYBERALTURA_FIELD_DISTANCE_PREFIX = "Distanza :";
    protected static final String CYBERALTURA_FIELD_COEFFICIENT_PREFIX = "Coefficiente :";
    
	public enum CyberAlturaField { data, ora, distanza, coeffient, rating };

	public CyberAlturaRankInfo parse(BufferedReader br) throws IOException, ParseException
	{	
		List<String> htmlFragments = new ArrayList<String>();
		String fragment = retrieveTableFromInputStream(br);		
		while (fragment != null)
		{
			htmlFragments.add(fragment);
			fragment = retrieveTableFromInputStream(br);
		}

		validate(htmlFragments);
		
		return parseTableFragment(htmlFragments);
	}

	private String retrieveTableFromInputStream(BufferedReader br) throws IOException
	{
		String newLine = System.getProperty("line.separator");

		StringBuilder stb = new StringBuilder();
		stb.append("<!-- CyberAltura Parser -->").append(newLine);

		int status = 0;
		String line = br.readLine();
		while (line != null)
		{
			switch (status)
			{
			case 0:
				if (line.indexOf("<table") >= 0)
				{
					stb.append(line).append(newLine);
					status = 1;
				}
				break;
			case 1:
				stb.append(line).append(newLine);
				if (line.indexOf("</table") >= 0)
				{
					return stb.toString();
				}
				break;
			}

			line = br.readLine();
		}

		return null;
	}
	
	protected abstract boolean validate(List<String> htmlFragments) throws ParseException;
	protected abstract CyberAlturaRankInfo parseTableFragment(List<String> htmlFragments) throws ParseException;
	
    protected CyberAlturaRankInfo parseSoftwareInfo(CyberAlturaRankInfo theRank, String htmlFragment)
    {
		Document jsoupDocument = Jsoup.parseBodyFragment(htmlFragment);
		Elements infos = jsoupDocument.select("td");		
		
		int elementIndex = 0;
		for(Element info : infos)
		{
			String infoText = info.text();
			infoText = infoText.replace("\u00A0"," ");
            switch(elementIndex)
            {
            case 0:
            	theRank.setSoftwareversion(infoText);
            	break;
            case 1:
            	theRank.setSoftwarecode(infoText);
            	break;
            case 2:
            	theRank.setRankdate(infoText.substring(CYBERALTURA_FIELD_DATE_PREFIX.length()));            	
            	break;            		
            }
				
            elementIndex ++;
		}
		
		return theRank;
    }

}
