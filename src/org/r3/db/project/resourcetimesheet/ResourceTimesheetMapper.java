//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.resourcetimesheet;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ResourceTimesheetMapper{
    
  org.r3.db.project.resourcetimesheet.ResourceTimesheetDTO  selectByTsentryid(
            @Param("tsentryid")   java.lang.String tsentryid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
            
  int deleteByTsentryid(
            @Param("tsentryid")   java.lang.String tsentryid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
  org.r3.db.project.resourcetimesheet.ResourceTimesheetDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.project.resourcetimesheet.ResourceTimesheetKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.project.resourcetimesheet.ResourceTimesheetKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.project.resourcetimesheet.ResourceTimesheetDTO> select(
            @Param("filter") org.r3.db.project.resourcetimesheet.ResourceTimesheetFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.project.resourcetimesheet.ResourceTimesheetFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.project.resourcetimesheet.ResourceTimesheetFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.project.resourcetimesheet.ResourceTimesheetDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.project.resourcetimesheet.ResourceTimesheetDTO aRecord, 
             @Param("filter") org.r3.db.project.resourcetimesheet.ResourceTimesheetFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.project.resourcetimesheet.ResourceTimesheetDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    


}
  
