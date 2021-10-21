//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



package org.r3.db.wbs.wbs;


import java.util.List;

import org.apache.ibatis.session.RowBounds;

public class WBSPersistenceBase
{
  protected WBSMapper mapper;
  
  public void setMapper(WBSMapper aMapper)
  {
     this.mapper = aMapper;
  }


  protected org.r3.db.system.sequence.SequencePersistence  sequencePersistence;    
  
  public void setSequencePersistence(org.r3.db.system.sequence.SequencePersistence aSequencePersistence)
  {
      this.sequencePersistence = aSequencePersistence;
  }
   
  public String getWbsid_sequence(org.r3.db.PersistenceConfigInfo pcfg)
  {
     String seqId = null;
     seqId = sequencePersistence.getSequence("WBS", pcfg.getSequenceSubPrefix());
     return seqId;
  }
  
  
  public WBSPersistenceBase ()
  {
  
  }
      
  public org.r3.db.wbs.wbs.WBSDTO  selectBySiteWbsid( java.lang.String site, java.lang.String wbsid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.wbs.wbs.WBSDTO dto = this.mapper.selectBySiteWbsid( site, wbsid, pcfg);
      return dto;
  }
  
  public int deleteBySiteWbsid( java.lang.String site, java.lang.String wbsid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteBySiteWbsid( site, wbsid, pcfg);
      return numberOfRowsAffected;  
  }
  
  public org.r3.db.wbs.wbs.WBSDTO  selectByPrimaryKey(org.r3.db.wbs.wbs.WBSKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.wbs.wbs.WBSDTO dto = this.mapper.selectByPrimaryKey(pk, pcfg);
      return dto;
  }
  
  public int  deleteByPrimaryKey(org.r3.db.wbs.wbs.WBSKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteByPrimaryKey(pk, pcfg);
      return numberOfRowsAffected;  
  }  

  public org.r3.db.wbs.wbs.WBSDTO selectFirst(org.r3.db.wbs.wbs.WBSFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {   
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.wbs.wbs.WBSFilter();
      }
      filterCondition.setLimitFetch(1);

      List<org.r3.db.wbs.wbs.WBSDTO> l = select(filterCondition, pcfg, new RowBounds(0, 1));
      if (l != null && l.size() > 0)
     			return l.get(0);
     			
      return null;
  }

  public List<org.r3.db.wbs.wbs.WBSDTO> select(org.r3.db.wbs.wbs.WBSFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {      
      return select(filterCondition, pcfg, null);
  }

  public List<org.r3.db.wbs.wbs.WBSDTO> select(org.r3.db.wbs.wbs.WBSFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg, RowBounds aRowBounds)
  {      
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.wbs.wbs.WBSFilter();
      }
            
      if (aRowBounds == null)
         aRowBounds = new RowBounds();
      else
      {      
    	   if (aRowBounds.getLimit() < RowBounds.NO_ROW_LIMIT)
              filterCondition.setLimitFetch(aRowBounds.getOffset() + aRowBounds.getLimit());
      }
                        
      List<org.r3.db.wbs.wbs.WBSDTO> listOfDTOs = this.mapper.select(filterCondition, pcfg, aRowBounds);
      return listOfDTOs;
  }
  
  public int count(org.r3.db.wbs.wbs.WBSFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.count(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public org.r3.db.wbs.wbs.WBSDataTableAdapter query(
      org.r3.db.wbs.wbs.WBSFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg, 
      String sEcho, 
      int iDisplayStart, 
      int iDisplayLength,
      boolean countElements)
  {  
    	int numberOfItems = (countElements) ? count(aFilterCondition, pcfg) : -1;    	
    	List<org.r3.db.wbs.wbs.WBSDTO> l = null;
    	if (numberOfItems != 0)
    	{
    	RowBounds rb = new RowBounds(
    					(iDisplayStart >= 0)  ? iDisplayStart : RowBounds.NO_ROW_OFFSET, 
    			    (iDisplayLength > 0) ? iDisplayLength : RowBounds.NO_ROW_LIMIT);
    	
		  l = select(aFilterCondition, pcfg, rb);
      }

		  org.r3.db.wbs.wbs.WBSDataTableAdapter dt = new org.r3.db.wbs.wbs.WBSDataTableAdapter();
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

  public org.r3.db.wbs.wbs.WBSDataTableAdapter query(
      org.r3.db.wbs.wbs.WBSFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg)
  {  
      return query(aFilterCondition, pcfg, "1", -1, -1, false);
  }  
  
  public int delete(org.r3.db.wbs.wbs.WBSFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.delete(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public int insert(org.r3.db.wbs.wbs.WBSDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {
      String seqId = null;
      if (aRecord.getWbsid() == null)
      {     
        seqId = getWbsid_sequence(pcfg);
        aRecord.setWbsid(seqId);
      }      

      int numberOfRowsAffected = this.mapper.insert(aRecord, pcfg);
      return numberOfRowsAffected;  
  }

  public int update(org.r3.db.wbs.wbs.WBSDTO aRecord, org.r3.db.wbs.wbs.WBSFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.update(aRecord, aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }
  
  public int updateByPrimaryKey(org.r3.db.wbs.wbs.WBSDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.updateByPrimaryKey(aRecord, pcfg);
      return numberOfRowsAffected;  
  }


}
  
