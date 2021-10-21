//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.calendar;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SystemCalendarMapper{
    
  org.r3.db.system.calendar.SystemCalendarDTO  selectBySitedomainCalendaridCaldate(
             @Param("sitedomain") java.lang.String sitedomain, @Param("calendarid") java.lang.String calendarid, @Param("caldate") java.sql.Date caldate,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int deleteBySitedomainCalendaridCaldate(
             @Param("sitedomain") java.lang.String sitedomain, @Param("calendarid") java.lang.String calendarid, @Param("caldate") java.sql.Date caldate,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);            
  org.r3.db.system.calendar.SystemCalendarDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.system.calendar.SystemCalendarKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.system.calendar.SystemCalendarKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.system.calendar.SystemCalendarDTO> select(
            @Param("filter") org.r3.db.system.calendar.SystemCalendarFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.system.calendar.SystemCalendarFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.system.calendar.SystemCalendarFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.system.calendar.SystemCalendarDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.system.calendar.SystemCalendarDTO aRecord, 
             @Param("filter") org.r3.db.system.calendar.SystemCalendarFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.system.calendar.SystemCalendarDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    

  int countWorkingDays(
		    @Param("filter") org.r3.db.system.calendar.SystemCalendarFilter aFilterCondition,
        @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

}
  
