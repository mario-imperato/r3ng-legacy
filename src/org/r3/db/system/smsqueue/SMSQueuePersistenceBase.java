//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



package org.r3.db.system.smsqueue;


import java.util.List;

import org.apache.ibatis.session.RowBounds;

public class SMSQueuePersistenceBase
{
  protected SMSQueueMapper mapper;
  
  public void setMapper(SMSQueueMapper aMapper)
  {
     this.mapper = aMapper;
  }


  protected org.r3.db.system.sequence.SequencePersistence  sequencePersistence;    
  
  public void setSequencePersistence(org.r3.db.system.sequence.SequencePersistence aSequencePersistence)
  {
      this.sequencePersistence = aSequencePersistence;
  }
   
  public String getSmsid_sequence(org.r3.db.PersistenceConfigInfo pcfg)
  {
     String seqId = null;
     seqId = sequencePersistence.getSequence("SMS", pcfg.getSequenceSubPrefix());
     return seqId;
  }
  
  
  public SMSQueuePersistenceBase ()
  {
  
  }
      
  public org.r3.db.system.smsqueue.SMSQueueDTO  selectBySiteSmsid( java.lang.String site, java.lang.String smsid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.system.smsqueue.SMSQueueDTO dto = this.mapper.selectBySiteSmsid( site, smsid, pcfg);
      return dto;
  }
  
  public int deleteBySiteSmsid( java.lang.String site, java.lang.String smsid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteBySiteSmsid( site, smsid, pcfg);
      return numberOfRowsAffected;  
  }
  
  public org.r3.db.system.smsqueue.SMSQueueDTO  selectByPrimaryKey(org.r3.db.system.smsqueue.SMSQueueKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.system.smsqueue.SMSQueueDTO dto = this.mapper.selectByPrimaryKey(pk, pcfg);
      return dto;
  }
  
  public int  deleteByPrimaryKey(org.r3.db.system.smsqueue.SMSQueueKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteByPrimaryKey(pk, pcfg);
      return numberOfRowsAffected;  
  }  

  public org.r3.db.system.smsqueue.SMSQueueDTO selectFirst(org.r3.db.system.smsqueue.SMSQueueFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {   
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.system.smsqueue.SMSQueueFilter();
      }
      filterCondition.setLimitFetch(1);

      List<org.r3.db.system.smsqueue.SMSQueueDTO> l = select(filterCondition, pcfg, new RowBounds(0, 1));
      if (l != null && l.size() > 0)
     			return l.get(0);
     			
      return null;
  }

  public List<org.r3.db.system.smsqueue.SMSQueueDTO> select(org.r3.db.system.smsqueue.SMSQueueFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {      
      return select(filterCondition, pcfg, null);
  }

  public List<org.r3.db.system.smsqueue.SMSQueueDTO> select(org.r3.db.system.smsqueue.SMSQueueFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg, RowBounds aRowBounds)
  {      
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.system.smsqueue.SMSQueueFilter();
      }
            
      if (aRowBounds == null)
         aRowBounds = new RowBounds();
      else
      {      
    	   if (aRowBounds.getLimit() < RowBounds.NO_ROW_LIMIT)
              filterCondition.setLimitFetch(aRowBounds.getOffset() + aRowBounds.getLimit());
      }
                        
      List<org.r3.db.system.smsqueue.SMSQueueDTO> listOfDTOs = this.mapper.select(filterCondition, pcfg, aRowBounds);
      return listOfDTOs;
  }
  
  public int count(org.r3.db.system.smsqueue.SMSQueueFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.count(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public org.r3.db.system.smsqueue.SMSQueueDataTableAdapter query(
      org.r3.db.system.smsqueue.SMSQueueFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg, 
      String sEcho, 
      int iDisplayStart, 
      int iDisplayLength,
      boolean countElements)
  {  
    	int numberOfItems = (countElements) ? count(aFilterCondition, pcfg) : -1;    	
    	List<org.r3.db.system.smsqueue.SMSQueueDTO> l = null;
    	if (numberOfItems != 0)
    	{
    	RowBounds rb = new RowBounds(
    					(iDisplayStart >= 0)  ? iDisplayStart : RowBounds.NO_ROW_OFFSET, 
    			    (iDisplayLength > 0) ? iDisplayLength : RowBounds.NO_ROW_LIMIT);
    	
		  l = select(aFilterCondition, pcfg, rb);
      }

		  org.r3.db.system.smsqueue.SMSQueueDataTableAdapter dt = new org.r3.db.system.smsqueue.SMSQueueDataTableAdapter();
		  dt.setsEcho(sEcho);
		  dt.setiTotalRecords(numberOfItems);
		  dt.setiTotalDisplayRecords(numberOfItems);
		  dt.setAaData(l);
		
		  return dt;
  }  
  
  public int delete(org.r3.db.system.smsqueue.SMSQueueFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.delete(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public int insert(org.r3.db.system.smsqueue.SMSQueueDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {
      String seqId = null;
      if (aRecord.getSmsid() == null)
      {     
        seqId = getSmsid_sequence(pcfg);
        aRecord.setSmsid(seqId);
      }      

      int numberOfRowsAffected = this.mapper.insert(aRecord, pcfg);
      return numberOfRowsAffected;  
  }

  public int update(org.r3.db.system.smsqueue.SMSQueueDTO aRecord, org.r3.db.system.smsqueue.SMSQueueFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.update(aRecord, aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }
  
  public int updateByPrimaryKey(org.r3.db.system.smsqueue.SMSQueueDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.updateByPrimaryKey(aRecord, pcfg);
      return numberOfRowsAffected;  
  }


}
  
