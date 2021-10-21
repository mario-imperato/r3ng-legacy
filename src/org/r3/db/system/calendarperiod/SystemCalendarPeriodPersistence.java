//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.system.calendarperiod;

import org.r3.db.DTOBase;

public class SystemCalendarPeriodPersistence extends
		SystemCalendarPeriodPersistenceBase
{
	public static SystemCalendarPeriodPersistence createPersistenceObject(
			org.r3.db.PersistenceContext pcfg,
			org.apache.ibatis.session.SqlSession aSession)
	{
		SystemCalendarPeriodPersistence p = new SystemCalendarPeriodPersistence();
		p.setMapper(aSession.getMapper(SystemCalendarPeriodMapper.class));
		return p;
	}

	public SystemCalendarPeriodDTO getCurrentMonthlyPeriod(org.r3.db.PersistenceConfigInfo pcfg)
	{
		return getCurrentPeriod(SystemCalendarPeriodDTO.PeriodType.monthly, pcfg);
	}
		
	public SystemCalendarPeriodDTO getCurrentPeriod(SystemCalendarPeriodDTO.PeriodType aPeriodType, org.r3.db.PersistenceConfigInfo pcfg)
	{
		SystemCalendarPeriodFilter periodFilter = new SystemCalendarPeriodFilter();
		periodFilter.or().andPeriodtypeEqualTo(aPeriodType.toString())
						.andPeriodstartLessThanOrEqualTo(DTOBase.currentDate()).andPeriodendGreaterThanOrEqualTo(DTOBase.currentDate());

		periodFilter.setLimitFetch(1);
		SystemCalendarPeriodDTO dto = selectFirst(periodFilter, pcfg);

		return dto;
	}
}
