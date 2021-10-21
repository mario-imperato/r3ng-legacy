package org.r3.ws.test;

import java.util.List;

import org.r3.system.util.RegExpUtils;

public class RegexpTest
{

	public RegexpTest()
	{
	}

	public static void main(String[] args)
	{
		String targetString;
		List<String> l = null;
		
		// String rdvPattern = "(DEMA_\\d{14})_(EG\\d{10}).xml";
		// String targetPattern = "(\\$\\{[a-zA-Z0-9.]+\\})";
		// String targetPattern = "\\$\\{([a-zA-Z0-9._]+)\\}";
		String targetPattern = "(DEMA_\\d{14})_([A-Z0-9]{10,12}).xml";
		
		// targetString = "${db.piffero} whatever it takes ${db.pluto} Ciao.... ${db_terza_pluto}";
		targetString = "DEMA_20170509173237_F17000017051.xml";
		l = RegExpUtils.find(targetPattern, targetString);
		
		if (l != null)
		{
			System.out.printf("Pattern: %s - String: %s\n", targetPattern, targetString);

			for(String s : l)
			{
				System.out.printf("Group: %s\n", s);				
			}
		}
		else
			System.out.printf("Pattern: %s - String: %s = null\n", targetPattern, targetString);
		
	}
	
}
