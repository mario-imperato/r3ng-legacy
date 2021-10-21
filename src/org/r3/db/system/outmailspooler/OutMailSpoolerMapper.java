//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.outmailspooler;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface OutMailSpoolerMapper{
    
  org.r3.db.system.outmailspooler.OutMailSpoolerDTO  selectBySiteMessageid(
             @Param("site") java.lang.String site, @Param("messageid") java.lang.String messageid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int deleteBySiteMessageid(
             @Param("site") java.lang.String site, @Param("messageid") java.lang.String messageid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);            
  org.r3.db.system.outmailspooler.OutMailSpoolerDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.system.outmailspooler.OutMailSpoolerKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.system.outmailspooler.OutMailSpoolerKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.system.outmailspooler.OutMailSpoolerDTO> select(
            @Param("filter") org.r3.db.system.outmailspooler.OutMailSpoolerFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.system.outmailspooler.OutMailSpoolerFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.system.outmailspooler.OutMailSpoolerFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.system.outmailspooler.OutMailSpoolerDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.system.outmailspooler.OutMailSpoolerDTO aRecord, 
             @Param("filter") org.r3.db.system.outmailspooler.OutMailSpoolerFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.system.outmailspooler.OutMailSpoolerDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    

  int updateRecstatusBySiteMessageid(
          @Param("site") java.lang.String site, @Param("messageid") java.lang.String messageid,
          @Param("recstatus")     java.lang.String  recordstatus,
          @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
  
  List<org.r3.db.system.outmailspooler.OutMailSpoolerDTO> selectWithCounters(
          @Param("filter") org.r3.db.system.outmailspooler.OutMailSpoolerFilter filterCondition, 
          @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
          RowBounds aRowBounds);
  
}
  
