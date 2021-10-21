//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



package org.r3.db.bbs.bbsthread;


import java.util.List;

import org.apache.ibatis.session.RowBounds;

public class BBSThreadPersistenceBase
{
  protected BBSThreadMapper mapper;
  
  public void setMapper(BBSThreadMapper aMapper)
  {
     this.mapper = aMapper;
  }


  protected org.r3.db.system.sequence.SequencePersistence  sequencePersistence;    
  
  public void setSequencePersistence(org.r3.db.system.sequence.SequencePersistence aSequencePersistence)
  {
      this.sequencePersistence = aSequencePersistence;
  }
   
  public String getThreadid_sequence(org.r3.db.PersistenceConfigInfo pcfg)
  {
     String seqId = null;
     seqId = sequencePersistence.getSequence("BBT", pcfg.getSequenceSubPrefix());
     return seqId;
  }
  
  
  public BBSThreadPersistenceBase ()
  {
  
  }
      
  public org.r3.db.bbs.bbsthread.BBSThreadDTO  selectBySiteThreadid( java.lang.String site, java.lang.String threadid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.bbs.bbsthread.BBSThreadDTO dto = this.mapper.selectBySiteThreadid( site, threadid, pcfg);
      return dto;
  }
  
  public int deleteBySiteThreadid( java.lang.String site, java.lang.String threadid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteBySiteThreadid( site, threadid, pcfg);
      return numberOfRowsAffected;  
  }
  
  public org.r3.db.bbs.bbsthread.BBSThreadDTO  selectByPrimaryKey(org.r3.db.bbs.bbsthread.BBSThreadKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.bbs.bbsthread.BBSThreadDTO dto = this.mapper.selectByPrimaryKey(pk, pcfg);
      return dto;
  }
  
  public int  deleteByPrimaryKey(org.r3.db.bbs.bbsthread.BBSThreadKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteByPrimaryKey(pk, pcfg);
      return numberOfRowsAffected;  
  }  

  public org.r3.db.bbs.bbsthread.BBSThreadDTO selectFirst(org.r3.db.bbs.bbsthread.BBSThreadFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {   
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.bbs.bbsthread.BBSThreadFilter();
      }
      filterCondition.setLimitFetch(1);

      List<org.r3.db.bbs.bbsthread.BBSThreadDTO> l = select(filterCondition, pcfg, new RowBounds(0, 1));
      if (l != null && l.size() > 0)
     			return l.get(0);
     			
      return null;
  }

  public List<org.r3.db.bbs.bbsthread.BBSThreadDTO> select(org.r3.db.bbs.bbsthread.BBSThreadFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {      
      return select(filterCondition, pcfg, null);
  }

  public List<org.r3.db.bbs.bbsthread.BBSThreadDTO> select(org.r3.db.bbs.bbsthread.BBSThreadFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg, RowBounds aRowBounds)
  {      
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.bbs.bbsthread.BBSThreadFilter();
      }
            
      if (aRowBounds == null)
         aRowBounds = new RowBounds();
      else
      {      
    	   if (aRowBounds.getLimit() < RowBounds.NO_ROW_LIMIT)
              filterCondition.setLimitFetch(aRowBounds.getOffset() + aRowBounds.getLimit());
      }
                        
      List<org.r3.db.bbs.bbsthread.BBSThreadDTO> listOfDTOs = this.mapper.select(filterCondition, pcfg, aRowBounds);
      return listOfDTOs;
  }
  
  public int count(org.r3.db.bbs.bbsthread.BBSThreadFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.count(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public org.r3.db.bbs.bbsthread.BBSThreadDataTableAdapter query(
      org.r3.db.bbs.bbsthread.BBSThreadFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg, 
      String sEcho, 
      int iDisplayStart, 
      int iDisplayLength,
      boolean countElements)
  {  
    	int numberOfItems = (countElements) ? count(aFilterCondition, pcfg) : -1;    	
    	List<org.r3.db.bbs.bbsthread.BBSThreadDTO> l = null;
    	if (numberOfItems != 0)
    	{
    	RowBounds rb = new RowBounds(
    					(iDisplayStart >= 0)  ? iDisplayStart : RowBounds.NO_ROW_OFFSET, 
    			    (iDisplayLength > 0) ? iDisplayLength : RowBounds.NO_ROW_LIMIT);
    	
		  l = select(aFilterCondition, pcfg, rb);
      }

		  org.r3.db.bbs.bbsthread.BBSThreadDataTableAdapter dt = new org.r3.db.bbs.bbsthread.BBSThreadDataTableAdapter();
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

  public org.r3.db.bbs.bbsthread.BBSThreadDataTableAdapter query(
      org.r3.db.bbs.bbsthread.BBSThreadFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg)
  {  
      return query(aFilterCondition, pcfg, "1", -1, -1, false);
  }  
  
  public int delete(org.r3.db.bbs.bbsthread.BBSThreadFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.delete(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public int insert(org.r3.db.bbs.bbsthread.BBSThreadDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {
      String seqId = null;
      if (aRecord.getThreadid() == null)
      {     
        seqId = getThreadid_sequence(pcfg);
        aRecord.setThreadid(seqId);
      }      

      int numberOfRowsAffected = this.mapper.insert(aRecord, pcfg);
      return numberOfRowsAffected;  
  }

  public int update(org.r3.db.bbs.bbsthread.BBSThreadDTO aRecord, org.r3.db.bbs.bbsthread.BBSThreadFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.update(aRecord, aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }
  
  public int updateByPrimaryKey(org.r3.db.bbs.bbsthread.BBSThreadDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.updateByPrimaryKey(aRecord, pcfg);
      return numberOfRowsAffected;  
  }


}
  
