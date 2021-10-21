//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.smsqueueitem;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SMSQueueItemMapper{
    
  org.r3.db.system.smsqueueitem.SMSQueueItemDTO  selectBySmsitemid(
            @Param("smsitemid")   java.lang.Integer smsitemid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
            
  int deleteBySmsitemid(
            @Param("smsitemid")   java.lang.Integer smsitemid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
  org.r3.db.system.smsqueueitem.SMSQueueItemDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.system.smsqueueitem.SMSQueueItemKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.system.smsqueueitem.SMSQueueItemKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.system.smsqueueitem.SMSQueueItemDTO> select(
            @Param("filter") org.r3.db.system.smsqueueitem.SMSQueueItemFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.system.smsqueueitem.SMSQueueItemFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.system.smsqueueitem.SMSQueueItemFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.system.smsqueueitem.SMSQueueItemDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.system.smsqueueitem.SMSQueueItemDTO aRecord, 
             @Param("filter") org.r3.db.system.smsqueueitem.SMSQueueItemFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.system.smsqueueitem.SMSQueueItemDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    

}
  
