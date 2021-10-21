package org.r3.ws.system.calendar;

import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.RestServiceDTO.Status;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class POSTCalendarInitialization extends ServicePattern
{    
	private SimpleDateFormat sf;
	
	private String calendarId;
    private int   eveFirstDayNumber = 1;
    private int   eveLength = 1;
    private String  eveFirstDay = null;
    private boolean computeCalendarPeriod = true;
    
	public POSTCalendarInitialization(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aCalendarId, String eveStart, int eveStartDayNumber, int calendarLength, boolean computeCalendarPeriodFlag)
	{
		super(ctx, serviceEnvironment);
		
        sf = new SimpleDateFormat("dd/MM/yyyy");
    	
        calendarId = aCalendarId;
    	eveFirstDayNumber = eveStartDayNumber;
    	eveFirstDay = eveStart;    					    	
    	eveLength = calendarLength;
    	computeCalendarPeriod = computeCalendarPeriodFlag;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)  throws ServicePatternException
	{
		try
		{
			CalendarInitializer c = new CalendarInitializer(senv.getRequestSiteDomain(), calendarId, eveFirstDay, eveFirstDayNumber, eveLength, computeCalendarPeriod);
			c.process(pcfg, aSession);
			
//			SystemCalendarPersistence persistence = SystemCalendarPersistence.createPersistenceObject(pcfg, aSession);
//			
//			// Cancellazione record del Calendario
//			SystemCalendarFilter calendarFilter = new SystemCalendarFilter();
//			calendarFilter.or().andCalendaridEqualTo(senv.getRequestSiteDomain()).andCalendaridEqualTo(calendarId);
//			persistence.delete(calendarFilter, pcfg.getPersistenceConfigInfo());
//
//			SystemCalendarPeriodPersistence periodPersistence = SystemCalendarPeriodPersistence.createPersistenceObject(pcfg, aSession);
//
//			// Cancellazione periodi del Calendario
//			if (computeCalendarPeriod)
//			{
//			SystemCalendarPeriodFilter calendarPeriodFilter = new SystemCalendarPeriodFilter();
//			periodPersistence.delete(calendarPeriodFilter, pcfg.getPersistenceConfigInfo());
//			}
//			
//			Calendar runningDay = Calendar.getInstance(Locale.ITALIAN);	    	
//			runningDay.setTime(DTOBase.parseDate(eveFirstDay));
//
//	    	int   caleveday = this.eveFirstDayNumber;
//	    	int   caleveworkday = this.eveFirstDayNumber;
//	    	
//	    	int   calday   = runningDay.get(Calendar.DAY_OF_MONTH);
//	    	int   calmonth = runningDay.get(Calendar.MONTH) + 1;
//	    	int   calyear  = runningDay.get(Calendar.YEAR);
//	    	   
//	    	int   calweek = runningDay.get(Calendar.WEEK_OF_YEAR);
//	    	int   calquarter = runningDay.get(Calendar.MONTH) / 3 + 1;
//	    	   
//	    	int   calyday    = runningDay.get(Calendar.DAY_OF_YEAR);
//	    	int   calwday    = runningDay.get(Calendar.DAY_OF_WEEK);    	   
//	    	
//	    	int   calevemonth = 1;
//	    	int   caleveweek  = 1;
//	    	int   calevequarter = 1;
//	    	int   caleveyear = 1;
//	    	
//	    	CalendarEntryType calentrytype = getCalEntryType(calwday);    	      	
//	    	Calendar startOfYear = (Calendar) runningDay.clone();
//	    	startOfYear.set(Calendar.DAY_OF_YEAR, 1);
//	    	startOfYear.set(Calendar.MONTH, 0);
//	    	Calendar endOfYear = null;
//	    	
//	    	Calendar startOfMonth = (Calendar) runningDay.clone();
//	    	Calendar endOfMonth = null;
//	    	
//	    	Calendar startOfWeek = (Calendar) runningDay.clone();
//	    	int wday = startOfWeek.get(Calendar.DAY_OF_WEEK);
//	    	startOfWeek.add(Calendar.DATE, -(this.getDayOfWeek(wday) - 1));
//	    	
//	    	Calendar endOfWeek = null;
//	    	
//	    	Calendar startOfQuarter = (Calendar) runningDay.clone();
//	    	Calendar endOfQuarter = null;
//	    	
//	        for(int i = 1; i <= eveLength; i++)
//	        {
//	        	SystemCalendarDTO calendarDto = new SystemCalendarDTO();
//	        	calendarDto.setSitedomain(senv.getRequestSiteDomain());
//	        	calendarDto.setCalendarid(calendarId);
//	        	calendarDto.setCaldate(new java.sql.Date(runningDay.getTimeInMillis()));
//	        	calendarDto.setCalentrytype(calentrytype.toString());
//	        	calendarDto.setCalday(calday);
//                calendarDto.setCaleveday(caleveday);
//                calendarDto.setCaleveworkday((isWorkingDay(calentrytype) ? caleveworkday : -1));
//                calendarDto.setCalevemonth(calevemonth);
//                calendarDto.setCaleveyear(caleveyear);
//                calendarDto.setCalevequarter(calevequarter);
//                calendarDto.setCaleveweek(caleveweek);
//                calendarDto.setCalmonth(calmonth);
//                calendarDto.setCalquarter(calquarter);
//                calendarDto.setCalwday(this.getDayOfWeek(calwday));
//                calendarDto.setCalweek(calweek);
//                calendarDto.setCalyday(calyday);
//                calendarDto.setCalyear(calyear);
//
//                persistence.insert(calendarDto, pcfg.getPersistenceConfigInfo());
//
//                /*
//	            System.out.printf("%s (%d): %d-%d-%d (%d-%s-%s), week: %d, quarter: %d, yday: %d, emonth: %d, eweek: %d, equart: %d\n",
//	                        	sf.format(runningDay.getTime()),
//	                        	caleveday,
//	                        	calday,
//	                        	calmonth,
//	                        	calyear,
//	                        	this.getDayOfWeek(calwday),
//	                        	runningDay.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.ALL_STYLES, Locale.ITALIAN),
//	                        	calentrytype,
//	                        	calweek,
//	                        	calquarter,
//	                        	calyday,
//	                        	calevemonth,
//	                        	caleveweek,
//	                        	calevequarter
//	                        );
//                */
//                
//	            Calendar pastDay   = (Calendar) runningDay.clone();
//	            
//	            caleveday++;
//	            if (isWorkingDay(calentrytype))  caleveworkday++;
//	            runningDay.add(Calendar.DATE, 1);
//	        		            
//	        	int m = runningDay.get(Calendar.MONTH) + 1;
//	        	if (m != calmonth)
//	        	{
//	        	    endOfMonth = pastDay;
//	        	    	        	    
//	        	    SystemCalendarPeriodDTO calendarPeriodDTO = new SystemCalendarPeriodDTO();
//	        	    calendarPeriodDTO.setPerioddescr(String.format("%s %d", startOfMonth.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ITALIAN), calyear));
//	        	    calendarPeriodDTO.setPeriodstart(new java.sql.Date(startOfMonth.getTimeInMillis()));
//	        	    calendarPeriodDTO.setPeriodend(new java.sql.Date(endOfMonth.getTimeInMillis()));
//	        	    calendarPeriodDTO.setPeriodindex(calevemonth);
//	        	    calendarPeriodDTO.setPeriodtype("monthly");
//	        	    calendarPeriodDTO.setPeriodyear(calyear);
//	        	    calendarPeriodDTO.setPeriodyindex(calmonth);
//	        	    
//	        	    if (computeCalendarPeriod)
//	    			{
//	        	    periodPersistence.insert(calendarPeriodDTO, pcfg.getPersistenceConfigInfo());
//	    			}
//	        	    
//	        	    calevemonth ++;
//	        	    // System.out.printf("Month Period (%s): %s to %s\n", startOfMonth.getDisplayName(Calendar.MONTH, Calendar.ALL_STYLES, Locale.ITALIAN), sf.format(startOfMonth.getTime()), sf.format(endOfMonth.getTime()));         	    
//	        	    startOfMonth = (Calendar) runningDay.clone();
//	        	}	        	
//	            calmonth = m;
//	            
//	        	int w = runningDay.get(Calendar.WEEK_OF_YEAR);
//	        	if ( w != calweek )
//	        	{
//	        	    endOfWeek = pastDay;
//
//	        	    SystemCalendarPeriodDTO calendarPeriodDTO = new SystemCalendarPeriodDTO();
//	        	    calendarPeriodDTO.setPerioddescr(String.format("%s %s", sf.format(startOfWeek.getTime()), sf.format(endOfWeek.getTime())));
//	        	    calendarPeriodDTO.setPeriodstart(new java.sql.Date(startOfWeek.getTimeInMillis()));
//	        	    calendarPeriodDTO.setPeriodend(new java.sql.Date(endOfWeek.getTimeInMillis()));
//	        	    calendarPeriodDTO.setPeriodindex(caleveweek);
//	        	    calendarPeriodDTO.setPeriodtype("weekly");
//	        	    calendarPeriodDTO.setPeriodyear(calyear);
//	        	    calendarPeriodDTO.setPeriodyindex(calweek);
//	        	    
//	        	    if (computeCalendarPeriod)
//	    			{
//	        	    periodPersistence.insert(calendarPeriodDTO, pcfg.getPersistenceConfigInfo());
//	    			}
//	        	    
//	        		caleveweek ++;
//	        	    // System.out.printf("Week Period: %s to %s\n", sf.format(startOfWeek.getTime()), sf.format(endOfWeek.getTime()));
//	        	    startOfWeek = (Calendar) runningDay.clone();        		
//	        	}        	
//	        	calweek = w;
//	        	
//	        	int q = runningDay.get(Calendar.MONTH) / 3 + 1;
//	        	if ( q != calquarter )
//	        	{
//	        	    endOfQuarter = pastDay;
//
//	        	    SystemCalendarPeriodDTO calendarPeriodDTO = new SystemCalendarPeriodDTO();
//	        	    // calendarPeriodDTO.setPerioddescr(String.format("%s %s", sf.format(startOfQuarter.getTime()), sf.format(endOfQuarter.getTime())));
//	        	    
//	        	    calendarPeriodDTO.setPerioddescr(String.format("Trim. %d %d", calquarter, calyear));
//	        	    calendarPeriodDTO.setPeriodstart(new java.sql.Date(startOfQuarter.getTimeInMillis()));
//	        	    calendarPeriodDTO.setPeriodend(new java.sql.Date(endOfQuarter.getTimeInMillis()));
//	        	    calendarPeriodDTO.setPeriodindex(calevequarter);
//	        	    calendarPeriodDTO.setPeriodtype("quarterly");
//	        	    calendarPeriodDTO.setPeriodyear(calyear);
//	        	    calendarPeriodDTO.setPeriodyindex(calquarter);
//	        	    
//	        	    if (computeCalendarPeriod)
//	    			{
//	        	    	periodPersistence.insert(calendarPeriodDTO, pcfg.getPersistenceConfigInfo());
//	    			}
//
//	        		calevequarter ++;
//	        	    // System.out.printf("Quarter Period: %s to %s\n", sf.format(startOfQuarter.getTime()), sf.format(endOfQuarter.getTime()));
//	        	    startOfQuarter = (Calendar) runningDay.clone();        		        		
//	        	}
//	        	calquarter = q;
//	        	
//	            int y = runningDay.get(Calendar.YEAR);
//	            if (y != calyear)
//	            {
//	                endOfYear = pastDay;	
//	        	 
//	                SystemCalendarPeriodDTO calendarPeriodDTO = new SystemCalendarPeriodDTO();
//	        	    calendarPeriodDTO.setPerioddescr(String.format("%d", calyear));
//	        	    calendarPeriodDTO.setPeriodstart(new java.sql.Date(startOfYear.getTimeInMillis()));
//	        	    calendarPeriodDTO.setPeriodend(new java.sql.Date(endOfYear.getTimeInMillis()));
//	        	    calendarPeriodDTO.setPeriodindex(caleveyear);
//	        	    calendarPeriodDTO.setPeriodtype("yearly");
//	        	    calendarPeriodDTO.setPeriodyear(calyear);
//	        	    calendarPeriodDTO.setPeriodyindex(0);
//	        	    
//	        	    if (computeCalendarPeriod)
//	    			{
//	        	    periodPersistence.insert(calendarPeriodDTO, pcfg.getPersistenceConfigInfo());
//	    			}
//	        	    
//	        	    caleveyear ++;
//	        	    
//	        	    // System.out.printf("Month Period (%s): %s to %s\n", startOfMonth.getDisplayName(Calendar.MONTH, Calendar.ALL_STYLES, Locale.ITALIAN), sf.format(startOfMonth.getTime()), sf.format(endOfMonth.getTime()));         	    
//	        	    startOfYear = (Calendar) runningDay.clone();
//	            }
//
//	        	calday = runningDay.get(Calendar.DAY_OF_MONTH);
//	        	calwday = runningDay.get(Calendar.DAY_OF_WEEK);
//	            calyear = runningDay.get(Calendar.YEAR);                        
//	            calyday = runningDay.get(Calendar.DAY_OF_YEAR);        
//	            
//	            calentrytype = getCalEntryType(calwday);                        
//	        }
	        
	        LUTManager.getLUTManager().invalidateLUT(LUTName.calendar);
	        LUTManager.getLUTManager().invalidateLUT(LUTName.calendar_monthly);
	        LUTManager.getLUTManager().invalidateLUT(LUTName.calendar_quarterly);
	        LUTManager.getLUTManager().invalidateLUT(LUTName.calendar_weekly);
	        LUTManager.getLUTManager().invalidateLUT(LUTName.calendar_yearly);

		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new ServicePatternException(e.getMessage());
		}
				
		RestServiceDTO restDTO = new RestServiceDTO(Status.ok, "");		
		return restDTO;
	}

//	private CalendarEntryType getCalEntryType(int calwday)
//	{
//		CalendarEntryType calentrytype;
//		switch(calwday)
//		{
//		case Calendar.SUNDAY:
//			calentrytype = CalendarEntryType.sunday;
//			break;
//
//		case Calendar.SATURDAY:
//			calentrytype = CalendarEntryType.saturday;            	
//			break;
//			
//		default:
//			calentrytype = CalendarEntryType.work;
//		}
//		return calentrytype;
//	}
//    
//	private boolean isWorkingDay(CalendarEntryType aCalentrytype)
//	{
//		return aCalentrytype == CalendarEntryType.work;
//	}
//	
//    private int getDayOfWeek(int aCalendarDayOfWeek)
//    {
//    	return (aCalendarDayOfWeek - 1) + ((aCalendarDayOfWeek == 1) ? 7 : 0);
//    }

}
