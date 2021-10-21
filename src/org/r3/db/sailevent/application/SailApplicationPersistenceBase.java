//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



package org.r3.db.sailevent.application;


import java.util.List;

import org.apache.ibatis.session.RowBounds;

public class SailApplicationPersistenceBase
{
  protected SailApplicationMapper mapper;
  
  public void setMapper(SailApplicationMapper aMapper)
  {
     this.mapper = aMapper;
  }


  protected org.r3.db.system.sequence.SequencePersistence  sequencePersistence;    
  
  public void setSequencePersistence(org.r3.db.system.sequence.SequencePersistence aSequencePersistence)
  {
      this.sequencePersistence = aSequencePersistence;
  }
   
  public String getApplicationid_sequence(org.r3.db.PersistenceConfigInfo pcfg)
  {
     String seqId = null;
     seqId = sequencePersistence.getSequence("R3EA", pcfg.getSequenceSubPrefix());
     return seqId;
  }
  
  
  public SailApplicationPersistenceBase ()
  {
  
  }
      
  public org.r3.db.sailevent.application.SailApplicationDTO  selectByEventidApplicationid( java.lang.String eventid, java.lang.String applicationid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.sailevent.application.SailApplicationDTO dto = this.mapper.selectByEventidApplicationid( eventid, applicationid, pcfg);
      return dto;
  }
  
  public int deleteByEventidApplicationid( java.lang.String eventid, java.lang.String applicationid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteByEventidApplicationid( eventid, applicationid, pcfg);
      return numberOfRowsAffected;  
  }
  
  public org.r3.db.sailevent.application.SailApplicationDTO  selectByPrimaryKey(org.r3.db.sailevent.application.SailApplicationKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.sailevent.application.SailApplicationDTO dto = this.mapper.selectByPrimaryKey(pk, pcfg);
      return dto;
  }
  
  public int  deleteByPrimaryKey(org.r3.db.sailevent.application.SailApplicationKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteByPrimaryKey(pk, pcfg);
      return numberOfRowsAffected;  
  }  

  public org.r3.db.sailevent.application.SailApplicationDTO selectFirst(org.r3.db.sailevent.application.SailApplicationFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {   
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.sailevent.application.SailApplicationFilter();
      }
      filterCondition.setLimitFetch(1);

      List<org.r3.db.sailevent.application.SailApplicationDTO> l = select(filterCondition, pcfg, new RowBounds(0, 1));
      if (l != null && l.size() > 0)
     			return l.get(0);
     			
      return null;
  }

  public List<org.r3.db.sailevent.application.SailApplicationDTO> select(org.r3.db.sailevent.application.SailApplicationFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {      
      return select(filterCondition, pcfg, null);
  }

  public List<org.r3.db.sailevent.application.SailApplicationDTO> select(org.r3.db.sailevent.application.SailApplicationFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg, RowBounds aRowBounds)
  {      
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.sailevent.application.SailApplicationFilter();
      }
            
      if (aRowBounds == null)
         aRowBounds = new RowBounds();
      else
      {      
    	   if (aRowBounds.getLimit() < RowBounds.NO_ROW_LIMIT)
              filterCondition.setLimitFetch(aRowBounds.getOffset() + aRowBounds.getLimit());
      }
                        
      List<org.r3.db.sailevent.application.SailApplicationDTO> listOfDTOs = this.mapper.select(filterCondition, pcfg, aRowBounds);
      return listOfDTOs;
  }
  
  public int count(org.r3.db.sailevent.application.SailApplicationFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.count(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public org.r3.db.sailevent.application.SailApplicationDataTableAdapter query(
      org.r3.db.sailevent.application.SailApplicationFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg, 
      String sEcho, 
      int iDisplayStart, 
      int iDisplayLength,
      boolean countElements)
  {  
    	int numberOfItems = (countElements) ? count(aFilterCondition, pcfg) : -1;    	
    	List<org.r3.db.sailevent.application.SailApplicationDTO> l = null;
    	if (numberOfItems != 0)
    	{
    	RowBounds rb = new RowBounds(
    					(iDisplayStart >= 0)  ? iDisplayStart : RowBounds.NO_ROW_OFFSET, 
    			    (iDisplayLength > 0) ? iDisplayLength : RowBounds.NO_ROW_LIMIT);
    	
		  l = select(aFilterCondition, pcfg, rb);
      }

		  org.r3.db.sailevent.application.SailApplicationDataTableAdapter dt = new org.r3.db.sailevent.application.SailApplicationDataTableAdapter();
		  dt.setsEcho(sEcho);
		  dt.setiTotalRecords(numberOfItems);
		  dt.setiTotalDisplayRecords(numberOfItems);
		  dt.setAaData(l);
		
		  return dt;
  }  
  
  public int delete(org.r3.db.sailevent.application.SailApplicationFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.delete(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public int insert(org.r3.db.sailevent.application.SailApplicationDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {
      String seqId = null;
      if (aRecord.getApplicationid() == null)
      {     
        seqId = getApplicationid_sequence(pcfg);
        aRecord.setApplicationid(seqId);
      }      

      int numberOfRowsAffected = this.mapper.insert(aRecord, pcfg);
      return numberOfRowsAffected;  
  }

  public int update(org.r3.db.sailevent.application.SailApplicationDTO aRecord, org.r3.db.sailevent.application.SailApplicationFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.update(aRecord, aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }
  
  public int updateByPrimaryKey(org.r3.db.sailevent.application.SailApplicationDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.updateByPrimaryKey(aRecord, pcfg);
      return numberOfRowsAffected;  
  }


}
  
