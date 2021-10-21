//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.calendarperiod;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SystemCalendarPeriodMapper{
    
  org.r3.db.system.calendarperiod.SystemCalendarPeriodDTO  selectByPeriodindexPeriodtype(
             @Param("periodindex") java.lang.Integer periodindex, @Param("periodtype") java.lang.String periodtype,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int deleteByPeriodindexPeriodtype(
             @Param("periodindex") java.lang.Integer periodindex, @Param("periodtype") java.lang.String periodtype,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);            
  org.r3.db.system.calendarperiod.SystemCalendarPeriodDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.system.calendarperiod.SystemCalendarPeriodKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.system.calendarperiod.SystemCalendarPeriodKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.system.calendarperiod.SystemCalendarPeriodDTO> select(
            @Param("filter") org.r3.db.system.calendarperiod.SystemCalendarPeriodFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.system.calendarperiod.SystemCalendarPeriodFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.system.calendarperiod.SystemCalendarPeriodFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.system.calendarperiod.SystemCalendarPeriodDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.system.calendarperiod.SystemCalendarPeriodDTO aRecord, 
             @Param("filter") org.r3.db.system.calendarperiod.SystemCalendarPeriodFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.system.calendarperiod.SystemCalendarPeriodDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    


}
  
