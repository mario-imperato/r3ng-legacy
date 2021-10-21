package org.r3.ws.system.calendar;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class OldCalendarInitializer
{
	private SimpleDateFormat sf;
	
    private int   eveFirstDayNumber = 1;
    private int   eveLength = 1;
    private Calendar  eveFirstDay = null;
    
    public OldCalendarInitializer(String eveStart, int eveStartDayNumber, int calendarLength) throws ParseException
    {
    	sf = new SimpleDateFormat("dd/MM/yyyy");
    	
    	eveFirstDayNumber = eveStartDayNumber;
    	eveFirstDay = Calendar.getInstance(Locale.ITALIAN);
    	eveFirstDay.setTime(sf.parse(eveStart));
    	eveLength = calendarLength;
    }
    
    public void initialize()
    {
    	Calendar runningDay = (Calendar) eveFirstDay.clone();
    	runningDay.setFirstDayOfWeek(Calendar.MONDAY);
    	
    	int   caleveday = this.eveFirstDayNumber;
    	
    	int   calday   = runningDay.get(Calendar.DAY_OF_MONTH);
    	int   calmonth = runningDay.get(Calendar.MONTH) + 1;
    	int   calyear  = runningDay.get(Calendar.YEAR);
    	   
    	int   calweek = runningDay.get(Calendar.WEEK_OF_YEAR);
    	int   calquarter = runningDay.get(Calendar.MONTH) / 3 + 1;
    	   
    	int   calyday    = runningDay.get(Calendar.DAY_OF_YEAR);
    	int   calwday    = runningDay.get(Calendar.DAY_OF_WEEK);    	   
    	
    	int   calevemonth = 1;
    	int   caleveweek  = 1;
    	int   calevequarter = 1;
    	   
    	String calentrytype = getCalEntryType(calwday);    	      	
    	
    	Calendar startOfMonth = (Calendar) eveFirstDay.clone();
    	Calendar endOfMonth = null;
    	
    	Calendar startOfWeek = (Calendar) eveFirstDay.clone();
    	int wday = startOfWeek.get(Calendar.DAY_OF_WEEK);
    	startOfWeek.add(Calendar.DATE, -(this.getDayOfWeek(wday) - 1));
    	
    	Calendar endOfWeek = null;
    	
    	Calendar startOfQuarter = (Calendar) eveFirstDay.clone();
    	Calendar endOfQuarter = null;
    	
        for(int i = 1; i <= eveLength; i++)
        {
            System.out.printf("%s (%d): %d-%d-%d (%d-%s-%s), week: %d, quarter: %d, yday: %d, emonth: %d, eweek: %d, equart: %d\n",
                        	sf.format(runningDay.getTime()),
                        	caleveday,
                        	calday,
                        	calmonth,
                        	calyear,
                        	this.getDayOfWeek(calwday),
                        	runningDay.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.ALL_STYLES, Locale.ITALIAN),
                        	calentrytype,
                        	calweek,
                        	calquarter,
                        	calyday,
                        	calevemonth,
                        	caleveweek,
                        	calevequarter
                        );

            Calendar pastDay   = (Calendar) runningDay.clone();
            
            caleveday++;
            runningDay.add(Calendar.DATE, 1);
        	
        	int m = runningDay.get(Calendar.MONTH) + 1;
        	if (m != calmonth)
        	{
        	    calevemonth ++;
        	    endOfMonth = pastDay;
        	    
        	    System.out.printf("Month Period (%s): %s to %s\n", startOfMonth.getDisplayName(Calendar.MONTH, Calendar.ALL_STYLES, Locale.ITALIAN), sf.format(startOfMonth.getTime()), sf.format(endOfMonth.getTime()));         	    
        	    startOfMonth = (Calendar) runningDay.clone();
        	}
        	
            calmonth = m;
            
        	int w = runningDay.get(Calendar.WEEK_OF_YEAR);
        	if ( w != calweek )
        	{
        		caleveweek ++;
        	    endOfWeek = pastDay;

        	    System.out.printf("Week Period: %s to %s\n", sf.format(startOfWeek.getTime()), sf.format(endOfWeek.getTime()));
        	    startOfWeek = (Calendar) runningDay.clone();        		
        	}        	
        	calweek = w;
        	
        	int q = runningDay.get(Calendar.MONTH) / 3 + 1;
        	if ( q != calquarter )
        	{
        		calevequarter ++;
        	    endOfQuarter = pastDay;
        	    
        	    System.out.printf("Quarter Period: %s to %s\n", sf.format(startOfQuarter.getTime()), sf.format(endOfQuarter.getTime()));
        	    startOfQuarter = (Calendar) runningDay.clone();        		        		
        	}
        	calquarter = q;
        	        	
        	calday = runningDay.get(Calendar.DAY_OF_MONTH);
        	calwday = runningDay.get(Calendar.DAY_OF_WEEK);
            calyear = runningDay.get(Calendar.YEAR);                        
            calyday = runningDay.get(Calendar.DAY_OF_YEAR);        
            
            calentrytype = getCalEntryType(calwday);                        
        }
    }

	private String getCalEntryType(int calwday)
	{
		String calentrytype;
		switch(calwday)
		{
		case Calendar.SUNDAY:
			calentrytype = "sunday";
			break;

		case Calendar.SATURDAY:
			calentrytype = "saturday";            	
			break;
			
		default:
			calentrytype = "work";
		}
		return calentrytype;
	}
    
    private int getDayOfWeek(int aCalendarDayOfWeek)
    {
    	return (aCalendarDayOfWeek - 1) + ((aCalendarDayOfWeek == 1) ? 7 : 0);
    }
    
	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException
	{                
//		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//		Date aDate = df.parse("01/10/2012");
//		System.out.println("01/10/2012 is: " + aDate.getTime() / 1000 / (3600 * 24));
		
        OldCalendarInitializer ci = new OldCalendarInitializer("01/10/2012", 735142, 365 * 20 + 90 + 7);
        ci.initialize();
	}

}
