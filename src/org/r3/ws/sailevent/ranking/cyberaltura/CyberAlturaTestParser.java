package org.r3.ws.sailevent.ranking.cyberaltura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class CyberAlturaTestParser
{
	
	public static void main(String[] args) throws IOException, ParseException
	{
       if (args.length != 2)
       {
    	   syntax();
    	   return;
       }
       
       CyberAlturaRankParser parser = null;
       if (args[0].equalsIgnoreCase("race"))
       {
    	   parser = new CyberAlturaRaceRankParser();
       }
       else parser = new CyberAlturaOverallRankingParser();
       
       BufferedReader br = new BufferedReader(new FileReader(args[1]));
       CyberAlturaRankInfo rank = parser.parse(br);
       br.close();
	}
	
	public static void syntax()
	{
		System.out.println("Syntax: CyberAlturaTestParser <race | overall> <html file>");
	}

}
