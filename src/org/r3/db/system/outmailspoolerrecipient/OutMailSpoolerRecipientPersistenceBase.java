//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



package org.r3.db.system.outmailspoolerrecipient;


import java.util.List;

import org.apache.ibatis.session.RowBounds;

public class OutMailSpoolerRecipientPersistenceBase
{
  protected OutMailSpoolerRecipientMapper mapper;
  
  public void setMapper(OutMailSpoolerRecipientMapper aMapper)
  {
     this.mapper = aMapper;
  }

  
  public OutMailSpoolerRecipientPersistenceBase ()
  {
  
  }
      
  public org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDTO  selectByRecipientid(
         java.lang.Integer recipientid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDTO dto = this.mapper.selectByRecipientid(recipientid, pcfg);
      return dto;
  }

  public int deleteByRecipientid(java.lang.Integer recipientid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteByRecipientid(recipientid, pcfg);
      return numberOfRowsAffected;
  }  
  public org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDTO  selectByPrimaryKey(org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDTO dto = this.mapper.selectByPrimaryKey(pk, pcfg);
      return dto;
  }
  
  public int  deleteByPrimaryKey(org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteByPrimaryKey(pk, pcfg);
      return numberOfRowsAffected;  
  }  

  public org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDTO selectFirst(org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {   
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientFilter();
      }
      filterCondition.setLimitFetch(1);

      List<org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDTO> l = select(filterCondition, pcfg, new RowBounds(0, 1));
      if (l != null && l.size() > 0)
     			return l.get(0);
     			
      return null;
  }

  public List<org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDTO> select(org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {      
      return select(filterCondition, pcfg, null);
  }

  public List<org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDTO> select(org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg, RowBounds aRowBounds)
  {      
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientFilter();
      }
            
      if (aRowBounds == null)
         aRowBounds = new RowBounds();
      else
      {      
    	   if (aRowBounds.getLimit() < RowBounds.NO_ROW_LIMIT)
              filterCondition.setLimitFetch(aRowBounds.getOffset() + aRowBounds.getLimit());
      }
                        
      List<org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDTO> listOfDTOs = this.mapper.select(filterCondition, pcfg, aRowBounds);
      return listOfDTOs;
  }
  
  public int count(org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.count(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDataTableAdapter query(
      org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg, 
      String sEcho, 
      int iDisplayStart, 
      int iDisplayLength,
      boolean countElements)
  {  
    	int numberOfItems = (countElements) ? count(aFilterCondition, pcfg) : -1;    	
    	List<org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDTO> l = null;
    	if (numberOfItems != 0)
    	{
    	RowBounds rb = new RowBounds(
    					(iDisplayStart >= 0)  ? iDisplayStart : RowBounds.NO_ROW_OFFSET, 
    			    (iDisplayLength > 0) ? iDisplayLength : RowBounds.NO_ROW_LIMIT);
    	
		  l = select(aFilterCondition, pcfg, rb);
      }

		  org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDataTableAdapter dt = new org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDataTableAdapter();
		  dt.setsEcho(sEcho);
		  
		  if (numberOfItems >= 0)
		  {
		     dt.setiTotalRecords(numberOfItems);
		     dt.setiTotalDisplayRecords(numberOfItems);
		  }
		  else
		  {
		     if (l != null)
		     {
		     dt.setiTotalRecords(l.size());
		     dt.setiTotalDisplayRecords(l.size());
		     }
		     else
		     {
		     dt.setiTotalRecords(0);
		     dt.setiTotalDisplayRecords(0);
		     }
		  }
		     
		  dt.setAaData(l);
		
		  return dt;
  }  

  public org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDataTableAdapter query(
      org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg)
  {  
      return query(aFilterCondition, pcfg, "1", -1, -1, false);
  }  
  
  public int delete(org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.delete(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public int insert(org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {

      int numberOfRowsAffected = this.mapper.insert(aRecord, pcfg);
      return numberOfRowsAffected;  
  }

  public int update(org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDTO aRecord, org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.update(aRecord, aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }
  
  public int updateByPrimaryKey(org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.updateByPrimaryKey(aRecord, pcfg);
      return numberOfRowsAffected;  
  }


}
  
