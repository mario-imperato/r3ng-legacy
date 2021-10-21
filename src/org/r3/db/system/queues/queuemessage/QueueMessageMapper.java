//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.queues.queuemessage;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface QueueMessageMapper{
    
  org.r3.db.system.queues.queuemessage.QueueMessageDTO  selectByQueuemessageid(
            @Param("queuemessageid")   java.lang.String queuemessageid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
            
  int deleteByQueuemessageid(
            @Param("queuemessageid")   java.lang.String queuemessageid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
  org.r3.db.system.queues.queuemessage.QueueMessageDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.system.queues.queuemessage.QueueMessageKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.system.queues.queuemessage.QueueMessageKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.system.queues.queuemessage.QueueMessageDTO> select(
            @Param("filter") org.r3.db.system.queues.queuemessage.QueueMessageFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.system.queues.queuemessage.QueueMessageFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.system.queues.queuemessage.QueueMessageFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.system.queues.queuemessage.QueueMessageDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.system.queues.queuemessage.QueueMessageDTO aRecord, 
             @Param("filter") org.r3.db.system.queues.queuemessage.QueueMessageFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.system.queues.queuemessage.QueueMessageDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    

  org.r3.db.utils.BlobDTO selectMessagebodyByPrimaryKey(
         @Param("pk")    org.r3.db.system.queues.queuemessage.QueueMessageKey aPk, 
         @Param("pcfg")  org.r3.db.PersistenceConfigInfo pcfg);    
  org.r3.db.utils.BlobDTO selectMessagebodyByQueuemessageid(
         @Param("queuemessageid") java.lang.String queuemessageid,
         @Param("pcfg")  org.r3.db.PersistenceConfigInfo pcfg);   
  int storeMessagebodyByQueuemessageid(
         @Param("messagebody") byte[] messagebody,
         @Param("queuemessageid") java.lang.String queuemessageid,
         @Param("pcfg")  org.r3.db.PersistenceConfigInfo pcfg);   

}
  
