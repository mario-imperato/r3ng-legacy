//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.agenda.agendaentry;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AgendaEntryMapper{
    
  org.r3.db.agenda.agendaentry.AgendaEntryDTO  selectByAgendaentryid(
            @Param("agendaentryid")   java.lang.String agendaentryid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
            
  int deleteByAgendaentryid(
            @Param("agendaentryid")   java.lang.String agendaentryid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
  org.r3.db.agenda.agendaentry.AgendaEntryDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.agenda.agendaentry.AgendaEntryKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.agenda.agendaentry.AgendaEntryKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.agenda.agendaentry.AgendaEntryDTO> select(
            @Param("filter") org.r3.db.agenda.agendaentry.AgendaEntryFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.agenda.agendaentry.AgendaEntryFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.agenda.agendaentry.AgendaEntryFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.agenda.agendaentry.AgendaEntryDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.agenda.agendaentry.AgendaEntryDTO aRecord, 
             @Param("filter") org.r3.db.agenda.agendaentry.AgendaEntryFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.agenda.agendaentry.AgendaEntryDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    


}
  
