//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.system.calendar;

import org.r3.db.PersistenceConfigInfo;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;

public class SystemCalendarPersistence extends SystemCalendarPersistenceBase
{
	public static SystemCalendarPersistence createPersistenceObject(
			org.r3.db.PersistenceContext pcfg,
			org.apache.ibatis.session.SqlSession aSession)
	{
		SystemCalendarPersistence p = new SystemCalendarPersistence();
		p.setMapper(aSession.getMapper(SystemCalendarMapper.class));
		return p;
	}

	public int countNumberOfWorkingDays(String aSiteDomain, String aCalendarId, java.sql.Date data1, java.sql.Date data2, org.r3.db.PersistenceConfigInfo pcfg)
	{				
		SystemCalendarDTO dto1 = getCalendarDate(aSiteDomain, aCalendarId, data1);
		SystemCalendarDTO dto2 = getCalendarDate(aSiteDomain, aCalendarId, data2);

		if (dto1 == null || dto2 == null)
			return -1;
				
		return countNumberOfWorkingDays(aSiteDomain, aCalendarId, dto1.getCalevedayAsInt(), dto2.getCalevedayAsInt(), pcfg);
	}

    private SystemCalendarDTO getCalendarDate(String aSiteDomain, String aCalendarId, java.util.Date aDate)
    {
    	if (aDate == null)
    		return null;
    	
    	SystemCalendarLUT lut = (SystemCalendarLUT)LUTManager.getLUTManager().getLUT(LUTName.calendar, null);
    	SystemCalendarDTO dto = lut.getItem(aSiteDomain, aCalendarId, aDate);
    	return dto;
    }
    
	public int countNumberOfWorkingDays(String aSiteDomain, String aCalendarId, int caleveday1, int caleveday2, org.r3.db.PersistenceConfigInfo pcfg)
	{
		if (caleveday1 <= 0 || caleveday2 <= 0)
			return -1;
		
		if (caleveday1 == caleveday2)
			return 0;
		
		if (caleveday1 > caleveday2)
		{
		    int tmp = caleveday2;
		    caleveday2 = caleveday1;
		    caleveday1 = tmp;
		}
		
		SystemCalendarFilter periodFilter = new SystemCalendarFilter();
		periodFilter.or().andSitedomainEqualTo(aSiteDomain).andCalendaridEqualTo(aCalendarId).andCalevedayGreaterThan(caleveday1).andCalevedayLessThanOrEqualTo(caleveday2);
		periodFilter.setOrderByClause(" caldate asc" );
		
		int c = this.mapper.countWorkingDays(periodFilter, pcfg);
		return c;
	}

	public SystemCalendarDTO selectByCaleveworkday(String aSiteDomain, String aCalendarId, int workingDayIndex,
			PersistenceConfigInfo persistenceConfigInfo)
	{
		SystemCalendarFilter periodFilter = new SystemCalendarFilter();
		periodFilter.or().andSitedomainEqualTo(aSiteDomain).andCalendaridEqualTo(aCalendarId).andCaleveworkdayEqualTo(workingDayIndex);
		
		return selectFirst(periodFilter, persistenceConfigInfo);
	}

}
