//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



package org.r3.db.system.smsqueueitem;


import java.util.List;

import org.apache.ibatis.session.RowBounds;

public class SMSQueueItemPersistenceBase
{
  protected SMSQueueItemMapper mapper;
  
  public void setMapper(SMSQueueItemMapper aMapper)
  {
     this.mapper = aMapper;
  }

  
  public SMSQueueItemPersistenceBase ()
  {
  
  }
      
  public org.r3.db.system.smsqueueitem.SMSQueueItemDTO  selectBySmsitemid(
         java.lang.Integer smsitemid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.system.smsqueueitem.SMSQueueItemDTO dto = this.mapper.selectBySmsitemid(smsitemid, pcfg);
      return dto;
  }

  public int deleteBySmsitemid(java.lang.Integer smsitemid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteBySmsitemid(smsitemid, pcfg);
      return numberOfRowsAffected;
  }  
  public org.r3.db.system.smsqueueitem.SMSQueueItemDTO  selectByPrimaryKey(org.r3.db.system.smsqueueitem.SMSQueueItemKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.system.smsqueueitem.SMSQueueItemDTO dto = this.mapper.selectByPrimaryKey(pk, pcfg);
      return dto;
  }
  
  public int  deleteByPrimaryKey(org.r3.db.system.smsqueueitem.SMSQueueItemKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteByPrimaryKey(pk, pcfg);
      return numberOfRowsAffected;  
  }  

  public org.r3.db.system.smsqueueitem.SMSQueueItemDTO selectFirst(org.r3.db.system.smsqueueitem.SMSQueueItemFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {   
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.system.smsqueueitem.SMSQueueItemFilter();
      }
      filterCondition.setLimitFetch(1);

      List<org.r3.db.system.smsqueueitem.SMSQueueItemDTO> l = select(filterCondition, pcfg, new RowBounds(0, 1));
      if (l != null && l.size() > 0)
     			return l.get(0);
     			
      return null;
  }

  public List<org.r3.db.system.smsqueueitem.SMSQueueItemDTO> select(org.r3.db.system.smsqueueitem.SMSQueueItemFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {      
      return select(filterCondition, pcfg, null);
  }

  public List<org.r3.db.system.smsqueueitem.SMSQueueItemDTO> select(org.r3.db.system.smsqueueitem.SMSQueueItemFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg, RowBounds aRowBounds)
  {      
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.system.smsqueueitem.SMSQueueItemFilter();
      }
            
      if (aRowBounds == null)
         aRowBounds = new RowBounds();
      else
      {      
    	   if (aRowBounds.getLimit() < RowBounds.NO_ROW_LIMIT)
              filterCondition.setLimitFetch(aRowBounds.getOffset() + aRowBounds.getLimit());
      }
                        
      List<org.r3.db.system.smsqueueitem.SMSQueueItemDTO> listOfDTOs = this.mapper.select(filterCondition, pcfg, aRowBounds);
      return listOfDTOs;
  }
  
  public int count(org.r3.db.system.smsqueueitem.SMSQueueItemFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.count(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public org.r3.db.system.smsqueueitem.SMSQueueItemDataTableAdapter query(
      org.r3.db.system.smsqueueitem.SMSQueueItemFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg, 
      String sEcho, 
      int iDisplayStart, 
      int iDisplayLength,
      boolean countElements)
  {  
    	int numberOfItems = (countElements) ? count(aFilterCondition, pcfg) : -1;    	
    	List<org.r3.db.system.smsqueueitem.SMSQueueItemDTO> l = null;
    	if (numberOfItems != 0)
    	{
    	RowBounds rb = new RowBounds(
    					(iDisplayStart >= 0)  ? iDisplayStart : RowBounds.NO_ROW_OFFSET, 
    			    (iDisplayLength > 0) ? iDisplayLength : RowBounds.NO_ROW_LIMIT);
    	
		  l = select(aFilterCondition, pcfg, rb);
      }

		  org.r3.db.system.smsqueueitem.SMSQueueItemDataTableAdapter dt = new org.r3.db.system.smsqueueitem.SMSQueueItemDataTableAdapter();
		  dt.setsEcho(sEcho);
		  dt.setiTotalRecords(numberOfItems);
		  dt.setiTotalDisplayRecords(numberOfItems);
		  dt.setAaData(l);
		
		  return dt;
  }  
  
  public int delete(org.r3.db.system.smsqueueitem.SMSQueueItemFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.delete(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public int insert(org.r3.db.system.smsqueueitem.SMSQueueItemDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {

      int numberOfRowsAffected = this.mapper.insert(aRecord, pcfg);
      return numberOfRowsAffected;  
  }

  public int update(org.r3.db.system.smsqueueitem.SMSQueueItemDTO aRecord, org.r3.db.system.smsqueueitem.SMSQueueItemFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.update(aRecord, aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }
  
  public int updateByPrimaryKey(org.r3.db.system.smsqueueitem.SMSQueueItemDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.updateByPrimaryKey(aRecord, pcfg);
      return numberOfRowsAffected;  
  }


}
  
