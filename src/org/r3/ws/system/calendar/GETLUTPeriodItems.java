package org.r3.ws.system.calendar;



import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.core.EntityTag;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.DTOBase;
import org.r3.db.PersistenceContext;
import org.r3.db.system.calendarperiod.SystemCalendarPeriodDTO;
import org.r3.db.system.calendarperiod.SystemCalendarPeriodDTO.PeriodType;
import org.r3.db.system.calendarperiod.SystemCalendarPeriodDataTableAdapter;
import org.r3.db.system.calendarperiod.SystemCalendarPeriodFilter;
import org.r3.db.system.calendarperiod.SystemCalendarPeriodPersistence;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.system.rest.LUTConditionalGetPattern;
import org.r3.system.rest.ServiceEnvironment;

public class GETLUTPeriodItems extends LUTConditionalGetPattern
{
    private Integer    lutSize = null;
    private Integer    offsetFromNow = null;
    private PeriodType     periodType = null;
    // private long       refDateInMillis;
    private int        cacheIntervalInSecs = -1;
    private EntityTag  classifierETag = null;
    
	public GETLUTPeriodItems(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aReferenceDate, PeriodType aPeriodType, Integer lutLength, Integer anOffsetFromNow)
	{
		super(ctx, serviceEnvironment, LUTName.calendar_period.toString());

		if (lutLength == null)
		      lutSize = new Integer(10);
		else  lutSize = lutLength;
		
		if (anOffsetFromNow != null)
		{
			offsetFromNow = anOffsetFromNow;			
		}
		else
		{
			offsetFromNow = 0;
		}
				
		java.util.Date d = new java.util.Date();
		long refDateInMillis = d.getTime();
		if (aReferenceDate != null)
		{
		 try
	        {
			    d = DTOBase.sysDateFormat.parse(aReferenceDate);
			    refDateInMillis = d.getTime();
	        }
	        catch(ParseException pe)
	        {
	        	
	        }
		}
		
		periodType = aPeriodType;				              
        classifierETag = new EntityTag(Long.toString(refDateInMillis));        
        
	}
	
	@Override
	protected long getCacheIntervalInMillis()
	{		
		return (cacheIntervalInSecs > 0) ? ((long)cacheIntervalInSecs) * 1000 : -1;
	}

	@Override
	protected int getCacheIntervalInSecs()
	{
		return cacheIntervalInSecs;
	}
	
	@Override 
	protected EntityTag getETag()
	{
		return classifierETag;
	}
	
	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		SystemCalendarPeriodDataTableAdapter dt = getData(pcfg, aSession, periodType, lutSize, offsetFromNow);
		return dt;
	}

	private SystemCalendarPeriodDataTableAdapter getData(PersistenceContext pcfg, SqlSession sqlSession, PeriodType periodType,  Integer aLutSize, Integer offsetFromNow)
	{				
		SystemCalendarPeriodPersistence p = SystemCalendarPeriodPersistence.createPersistenceObject(pcfg, sqlSession);
		SystemCalendarPeriodDTO dto = p.getCurrentPeriod(periodType, pcfg.getPersistenceConfigInfo());
		
		SystemCalendarPeriodFilter filter = new SystemCalendarPeriodFilter();
		filter.or().andPeriodindexGreaterThanOrEqualTo(dto.getPeriodindex() + offsetFromNow).andPeriodindexLessThanOrEqualTo(dto.getPeriodindex() + lutSize + offsetFromNow).andPeriodtypeEqualTo(periodType.toString());
		// filter.or().andPeriodstartLessThanOrEqualTo(new java.sql.Date(aRefDate)).andPeriodtypeEqualTo(periodType);
		filter.setOrderByClause(" periodindex ");
		filter.setLimitFetch(aLutSize);

		List<SystemCalendarPeriodDTO> l = p.select(filter, pcfg.getPersistenceConfigInfo());
		SystemCalendarPeriodDataTableAdapter dt = new SystemCalendarPeriodDataTableAdapter();
		dt.setsEcho("1");
		dt.setiTotalRecords(l.size());
		dt.setiTotalDisplayRecords(l.size());
		dt.setAaData(l);

		return dt;
	}

}
