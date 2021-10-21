package org.r3.system.util;


public class TimeUtils
{	
     public static int get_HH_mm_ss_TimeAsSecondsFromMidnight(String aTime)
     {
    	 int res = -1;
    	 
    	 if (aTime == null || aTime.length() == 0)
    		 return res;
    	 
    	 String[] timeComponents = aTime.split("[:\\.]");
    	 int multiplier = 1;
    	 res = 0;
    	 for(int i = timeComponents.length - 1; i >= 0; i--)
    	 {
    		 res += Integer.parseInt(timeComponents[i]) * multiplier;
    		 multiplier *= 60;
    	 }

    	 return res;
     }
}
