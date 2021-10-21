//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



package org.r3.db.system.queues.queuemessage;


import java.util.List;

import org.apache.ibatis.session.RowBounds;

public class QueueMessagePersistenceBase
{
  protected QueueMessageMapper mapper;
  
  public void setMapper(QueueMessageMapper aMapper)
  {
     this.mapper = aMapper;
  }


  protected org.r3.db.system.sequence.SequencePersistence  sequencePersistence;    
  
  public void setSequencePersistence(org.r3.db.system.sequence.SequencePersistence aSequencePersistence)
  {
      this.sequencePersistence = aSequencePersistence;
  }
   
  public String getQueuemessageid_sequence(org.r3.db.PersistenceConfigInfo pcfg)
  {
     String seqId = null;
     seqId = sequencePersistence.getSequence("QMSG", pcfg.getSequenceSubPrefix());
     return seqId;
  }
  
  
  public QueueMessagePersistenceBase ()
  {
  
  }
      
  public org.r3.db.system.queues.queuemessage.QueueMessageDTO  selectByQueuemessageid(
         java.lang.String queuemessageid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.system.queues.queuemessage.QueueMessageDTO dto = this.mapper.selectByQueuemessageid(queuemessageid, pcfg);
      return dto;
  }

  public int deleteByQueuemessageid(java.lang.String queuemessageid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteByQueuemessageid(queuemessageid, pcfg);
      return numberOfRowsAffected;
  }  
  public org.r3.db.system.queues.queuemessage.QueueMessageDTO  selectByPrimaryKey(org.r3.db.system.queues.queuemessage.QueueMessageKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.system.queues.queuemessage.QueueMessageDTO dto = this.mapper.selectByPrimaryKey(pk, pcfg);
      return dto;
  }
  
  public int  deleteByPrimaryKey(org.r3.db.system.queues.queuemessage.QueueMessageKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteByPrimaryKey(pk, pcfg);
      return numberOfRowsAffected;  
  }  

  public org.r3.db.system.queues.queuemessage.QueueMessageDTO selectFirst(org.r3.db.system.queues.queuemessage.QueueMessageFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {   
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.system.queues.queuemessage.QueueMessageFilter();
      }
      filterCondition.setLimitFetch(1);

      List<org.r3.db.system.queues.queuemessage.QueueMessageDTO> l = select(filterCondition, pcfg, new RowBounds(0, 1));
      if (l != null && l.size() > 0)
     			return l.get(0);
     			
      return null;
  }

  public List<org.r3.db.system.queues.queuemessage.QueueMessageDTO> select(org.r3.db.system.queues.queuemessage.QueueMessageFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {      
      return select(filterCondition, pcfg, null);
  }

  public List<org.r3.db.system.queues.queuemessage.QueueMessageDTO> select(org.r3.db.system.queues.queuemessage.QueueMessageFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg, RowBounds aRowBounds)
  {      
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.system.queues.queuemessage.QueueMessageFilter();
      }
            
      if (aRowBounds == null)
         aRowBounds = new RowBounds();
      else
      {      
    	   if (aRowBounds.getLimit() < RowBounds.NO_ROW_LIMIT)
              filterCondition.setLimitFetch(aRowBounds.getOffset() + aRowBounds.getLimit());
      }
                        
      List<org.r3.db.system.queues.queuemessage.QueueMessageDTO> listOfDTOs = this.mapper.select(filterCondition, pcfg, aRowBounds);
      return listOfDTOs;
  }
  
  public int count(org.r3.db.system.queues.queuemessage.QueueMessageFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.count(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public org.r3.db.system.queues.queuemessage.QueueMessageDataTableAdapter query(
      org.r3.db.system.queues.queuemessage.QueueMessageFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg, 
      String sEcho, 
      int iDisplayStart, 
      int iDisplayLength,
      boolean countElements)
  {  
    	int numberOfItems = (countElements) ? count(aFilterCondition, pcfg) : -1;    	
    	List<org.r3.db.system.queues.queuemessage.QueueMessageDTO> l = null;
    	if (numberOfItems != 0)
    	{
    	RowBounds rb = new RowBounds(
    					(iDisplayStart >= 0)  ? iDisplayStart : RowBounds.NO_ROW_OFFSET, 
    			    (iDisplayLength > 0) ? iDisplayLength : RowBounds.NO_ROW_LIMIT);
    	
		  l = select(aFilterCondition, pcfg, rb);
      }

		  org.r3.db.system.queues.queuemessage.QueueMessageDataTableAdapter dt = new org.r3.db.system.queues.queuemessage.QueueMessageDataTableAdapter();
		  dt.setsEcho(sEcho);
		  dt.setiTotalRecords(numberOfItems);
		  dt.setiTotalDisplayRecords(numberOfItems);
		  dt.setAaData(l);
		
		  return dt;
  }  
  
  public int delete(org.r3.db.system.queues.queuemessage.QueueMessageFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.delete(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public int insert(org.r3.db.system.queues.queuemessage.QueueMessageDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {
      String seqId = null;
      if (aRecord.getQueuemessageid() == null)
      {     
        seqId = getQueuemessageid_sequence(pcfg);
        aRecord.setQueuemessageid(seqId);
      }      

      int numberOfRowsAffected = this.mapper.insert(aRecord, pcfg);
      return numberOfRowsAffected;  
  }

  public int update(org.r3.db.system.queues.queuemessage.QueueMessageDTO aRecord, org.r3.db.system.queues.queuemessage.QueueMessageFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.update(aRecord, aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }
  
  public int updateByPrimaryKey(org.r3.db.system.queues.queuemessage.QueueMessageDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.updateByPrimaryKey(aRecord, pcfg);
      return numberOfRowsAffected;  
  }

  public org.r3.db.utils.BlobDTO selectMessagebodyByPrimaryKey(org.r3.db.system.queues.queuemessage.QueueMessageKey aPk, org.r3.db.PersistenceConfigInfo pcfg)
  {
     org.r3.db.utils.BlobDTO aBlob = this.mapper.selectMessagebodyByPrimaryKey(aPk, pcfg);
     return aBlob;
  }
  
  public org.r3.db.utils.BlobDTO selectMessagebodyByQueuemessageid( java.lang.String queuemessageid, org.r3.db.PersistenceConfigInfo pcfg)
  {
     org.r3.db.utils.BlobDTO aBlob = this.mapper.selectMessagebodyByQueuemessageid( queuemessageid, pcfg);
     return aBlob;
  }
  
  public int storeMessagebodyByQueuemessageid(byte[] messagebody, java.lang.String queuemessageid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfByteStored = this.mapper.storeMessagebodyByQueuemessageid(messagebody, queuemessageid, pcfg);
      return numberOfByteStored;  
  }

}
  
