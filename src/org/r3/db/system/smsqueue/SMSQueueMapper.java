//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.smsqueue;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SMSQueueMapper{
    
  org.r3.db.system.smsqueue.SMSQueueDTO  selectBySiteSmsid(
             @Param("site") java.lang.String site, @Param("smsid") java.lang.String smsid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int deleteBySiteSmsid(
             @Param("site") java.lang.String site, @Param("smsid") java.lang.String smsid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);            
  org.r3.db.system.smsqueue.SMSQueueDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.system.smsqueue.SMSQueueKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.system.smsqueue.SMSQueueKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.system.smsqueue.SMSQueueDTO> select(
            @Param("filter") org.r3.db.system.smsqueue.SMSQueueFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.system.smsqueue.SMSQueueFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.system.smsqueue.SMSQueueFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.system.smsqueue.SMSQueueDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.system.smsqueue.SMSQueueDTO aRecord, 
             @Param("filter") org.r3.db.system.smsqueue.SMSQueueFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.system.smsqueue.SMSQueueDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    


}
  
