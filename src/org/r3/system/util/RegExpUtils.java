package org.r3.system.util;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpUtils
{

	public RegExpUtils()
	{
		
	}
	
	public static Pattern getPattern4PrefixMatching(String aPattern)
	{
		if (aPattern == null || aPattern.length() == 0)
			return null;
		
		 Pattern MY_PATTERN = Pattern.compile("^" + aPattern);
		 return MY_PATTERN;			
	}
	
	public static boolean matches(String aPattern, String targetString)
	{
		if (targetString == null || targetString.length() == 0)
			return false;
		
		 Pattern MY_PATTERN = Pattern.compile(aPattern);
		 return matches(MY_PATTERN, targetString);	
	}
	
	public static boolean matches(Pattern aPattern, String targetString)
	{
		 if (targetString == null)
			 return false;
		 
		 Matcher m = aPattern.matcher(targetString);
		 return m.matches();
	}

	public static boolean isFound(Pattern aPattern, String targetString)
	{
		 if (targetString == null)
			 return false;
		 
		 Matcher m = aPattern.matcher(targetString);
		 return m.find();
	}
	
	public static String findFirst(String aPattern, String targetString)
	{
		List<String> l = find(aPattern, targetString);
		if (l != null && l.size() > 0)
			return l.get(0);
		
		return null;
	}
	
	public static List<String> find(String aPattern, String targetString)
	{
		if (targetString == null || targetString.length() == 0)
				 return null;
		
		Pattern MY_PATTERN = Pattern.compile(aPattern);
		return find(MY_PATTERN, targetString);
	}

	public static String findFirst(Pattern aPattern, String targetString)
	{
		List<String> l = find(aPattern, targetString);
		if (l != null && l.size() > 0)
			return l.get(0);
		
		return null;
	}

	public static List<String> find(Pattern aPattern, String targetString)
	{
		 if (targetString == null)
			 return null;
		 
		 List<String> listOfResults = null;
		 Matcher m = aPattern.matcher(targetString);
		 while (m.find()) 
		 {     
			 System.out.println("---" + m.groupCount());
			 for(int i = 1; i <= m.groupCount(); i++)
			 {
			 String s = m.group(i);			 
			 if (listOfResults == null)
				 listOfResults = new ArrayList<String>();
			 
			 listOfResults.add(s);
			 }
		 }
		 
		 return listOfResults;
	}
	
	public static void main(String[] args)
	{
		List<String> l = null;

 	    StringBuilder stb = new StringBuilder();
	    	stb.append("MAST_")
	    	   .append("ZZZZZZZZZZZ")
	    	   .append("_")
	    	   .append("assegni")
	    	   .append("_")
	    	   .append("([0-9]{14})\\.zip");

	    l = RegExpUtils.find(stb.toString(), "MAST_ZZZZZZZZZZZ_assegni_01234567890123.zip");
		
				
		Pattern p = RegExpUtils.getPattern4PrefixMatching("^SDEMA");		
		boolean b = RegExpUtils.isFound(p, "DEMAWHATEVER");
		
		String j00Pattern = ".*\\.J00";
		String e00Pattern = ".*\\.E00";
		String rdaccJ00Pattern = "(DEMA_\\d{14})\\.J00";
		String rdaccE00Pattern = "(DEMA_\\d{14})\\.E00";
		String rdvPattern = "(DEMA_\\d{14})_(EG\\d{10}).xml";
		String rdarcPattern = new StringBuilder()
				.append("Z0075873")
				.append('_')
				.append("assegni")
				.append("_(.*)\\.xml")
				.toString();
		
		String targetString = "Pippo.J00";		
		System.out.printf("Pattern: %s - String: %s = %b\n", j00Pattern, targetString, RegExpUtils.matches(j00Pattern, targetString));
		
		targetString = "RF37000EF45-DEMA_20170621155143.J00";
		String rdaccJ00Pattern_02 = "([^-]*)-(DEMA_\\d{14})\\.J00";
		l = RegExpUtils.find(rdaccJ00Pattern_02, targetString);
		
		if (l != null)
		{
			System.out.printf("Pattern: %s - String: %s\n", rdaccJ00Pattern_02, targetString);

			for(String s : l)
			{
				System.out.printf("Group: %s\n", s);				
			}
		}
		else
			System.out.printf("Pattern: %s - String: %s = null\n", rdaccJ00Pattern_02, targetString);
		
		
		targetString = "DEMA_20170101231259.J00";				
		l = RegExpUtils.find(rdaccJ00Pattern, targetString);
		
		if (l != null)
		{
			System.out.printf("Pattern: %s - String: %s\n", rdaccJ00Pattern, targetString);

			for(String s : l)
			{
				System.out.printf("Group: %s\n", s);				
			}
		}
		else
			System.out.printf("Pattern: %s - String: %s = null\n", rdaccJ00Pattern, targetString);


		targetString = "DEMA_20170101231259_EG1234567890.xml";
		l = RegExpUtils.find(rdvPattern, targetString);
		
		if (l != null)
		{
			System.out.printf("Pattern: %s - String: %s\n", rdvPattern, targetString);

			for(String s : l)
			{
				System.out.printf("Group: %s\n", s);				
			}
		}
		else
			System.out.printf("Pattern: %s - String: %s = null\n", rdvPattern, targetString);

		targetString = "Z0075873_assegni_3_3.xml";
		l = RegExpUtils.find(rdarcPattern, targetString);
		
		if (l != null)
		{
			System.out.printf("Pattern: %s - String: %s\n", rdarcPattern, targetString);

			for(String s : l)
			{
				System.out.printf("Group: %s\n", s);				
			}
		}
		else
			System.out.printf("Pattern: %s - String: %s = null\n", rdarcPattern, targetString);
		
		targetString = "F1700003650-RF37000EF5D-17062210120576-6014635-Z0060979-RMFTP-DEMA_20170621155143.xml";
		String rdvPattern_02 = "([^-]*)-([^-]*)-([^-]*)-([^-]*)-([^-]*)-([^-]*)-(DEMA_\\d{14}).xml";
		
		l = RegExpUtils.find(rdvPattern_02, targetString);
		
		if (l != null)
		{
			System.out.printf("Pattern: %s - String: %s\n", rdvPattern_02, targetString);

			for(String s : l)
			{
				System.out.printf("Group: %s\n", s);				
			}
		}
		else
			System.out.printf("Pattern: %s - String: %s = null\n", rdvPattern_02, targetString);
		
		System.out.println(Paths.get("/pippo/pluto").getName(1));
	}
	


}
