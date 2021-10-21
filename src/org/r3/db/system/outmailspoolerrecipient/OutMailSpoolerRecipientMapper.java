//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.outmailspoolerrecipient;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface OutMailSpoolerRecipientMapper{
    
  org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDTO  selectByRecipientid(
            @Param("recipientid")   java.lang.Integer recipientid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
            
  int deleteByRecipientid(
            @Param("recipientid")   java.lang.Integer recipientid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
  org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDTO> select(
            @Param("filter") org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDTO aRecord, 
             @Param("filter") org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    

  int updateRecstatusByRecipientid(
          @Param("recipientid")   java.lang.Integer recipientid,
          @Param("recstatus")     java.lang.String  recordstatus,
          @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
}
  
