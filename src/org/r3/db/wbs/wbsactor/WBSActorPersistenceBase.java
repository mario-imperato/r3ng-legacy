//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



package org.r3.db.wbs.wbsactor;


import java.util.List;

import org.apache.ibatis.session.RowBounds;

public class WBSActorPersistenceBase
{
  protected WBSActorMapper mapper;
  
  public void setMapper(WBSActorMapper aMapper)
  {
     this.mapper = aMapper;
  }


  protected org.r3.db.system.sequence.SequencePersistence  sequencePersistence;    
  
  public void setSequencePersistence(org.r3.db.system.sequence.SequencePersistence aSequencePersistence)
  {
      this.sequencePersistence = aSequencePersistence;
  }
   
  public String getWbsactorid_sequence(org.r3.db.PersistenceConfigInfo pcfg)
  {
     String seqId = null;
     seqId = sequencePersistence.getSequence("WAC", pcfg.getSequenceSubPrefix());
     return seqId;
  }
  
  
  public WBSActorPersistenceBase ()
  {
  
  }
      
  public org.r3.db.wbs.wbsactor.WBSActorDTO  selectByWbsactorid(
         java.lang.String wbsactorid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.wbs.wbsactor.WBSActorDTO dto = this.mapper.selectByWbsactorid(wbsactorid, pcfg);
      return dto;
  }

  public int deleteByWbsactorid(java.lang.String wbsactorid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteByWbsactorid(wbsactorid, pcfg);
      return numberOfRowsAffected;
  }  
  public org.r3.db.wbs.wbsactor.WBSActorDTO  selectByPrimaryKey(org.r3.db.wbs.wbsactor.WBSActorKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.wbs.wbsactor.WBSActorDTO dto = this.mapper.selectByPrimaryKey(pk, pcfg);
      return dto;
  }
  
  public int  deleteByPrimaryKey(org.r3.db.wbs.wbsactor.WBSActorKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteByPrimaryKey(pk, pcfg);
      return numberOfRowsAffected;  
  }  

  public org.r3.db.wbs.wbsactor.WBSActorDTO selectFirst(org.r3.db.wbs.wbsactor.WBSActorFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {   
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.wbs.wbsactor.WBSActorFilter();
      }
      filterCondition.setLimitFetch(1);

      List<org.r3.db.wbs.wbsactor.WBSActorDTO> l = select(filterCondition, pcfg, new RowBounds(0, 1));
      if (l != null && l.size() > 0)
     			return l.get(0);
     			
      return null;
  }

  public List<org.r3.db.wbs.wbsactor.WBSActorDTO> select(org.r3.db.wbs.wbsactor.WBSActorFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {      
      return select(filterCondition, pcfg, null);
  }

  public List<org.r3.db.wbs.wbsactor.WBSActorDTO> select(org.r3.db.wbs.wbsactor.WBSActorFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg, RowBounds aRowBounds)
  {      
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.wbs.wbsactor.WBSActorFilter();
      }
            
      if (aRowBounds == null)
         aRowBounds = new RowBounds();
      else
      {      
    	   if (aRowBounds.getLimit() < RowBounds.NO_ROW_LIMIT)
              filterCondition.setLimitFetch(aRowBounds.getOffset() + aRowBounds.getLimit());
      }
                        
      List<org.r3.db.wbs.wbsactor.WBSActorDTO> listOfDTOs = this.mapper.select(filterCondition, pcfg, aRowBounds);
      return listOfDTOs;
  }
  
  public int count(org.r3.db.wbs.wbsactor.WBSActorFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.count(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public org.r3.db.wbs.wbsactor.WBSActorDataTableAdapter query(
      org.r3.db.wbs.wbsactor.WBSActorFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg, 
      String sEcho, 
      int iDisplayStart, 
      int iDisplayLength,
      boolean countElements)
  {  
    	int numberOfItems = (countElements) ? count(aFilterCondition, pcfg) : -1;    	
    	List<org.r3.db.wbs.wbsactor.WBSActorDTO> l = null;
    	if (numberOfItems != 0)
    	{
    	RowBounds rb = new RowBounds(
    					(iDisplayStart >= 0)  ? iDisplayStart : RowBounds.NO_ROW_OFFSET, 
    			    (iDisplayLength > 0) ? iDisplayLength : RowBounds.NO_ROW_LIMIT);
    	
		  l = select(aFilterCondition, pcfg, rb);
      }

		  org.r3.db.wbs.wbsactor.WBSActorDataTableAdapter dt = new org.r3.db.wbs.wbsactor.WBSActorDataTableAdapter();
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

  public org.r3.db.wbs.wbsactor.WBSActorDataTableAdapter query(
      org.r3.db.wbs.wbsactor.WBSActorFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg)
  {  
      return query(aFilterCondition, pcfg, "1", -1, -1, false);
  }  
  
  public int delete(org.r3.db.wbs.wbsactor.WBSActorFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.delete(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public int insert(org.r3.db.wbs.wbsactor.WBSActorDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {
      String seqId = null;
      if (aRecord.getWbsactorid() == null)
      {     
        seqId = getWbsactorid_sequence(pcfg);
        aRecord.setWbsactorid(seqId);
      }      

      int numberOfRowsAffected = this.mapper.insert(aRecord, pcfg);
      return numberOfRowsAffected;  
  }

  public int update(org.r3.db.wbs.wbsactor.WBSActorDTO aRecord, org.r3.db.wbs.wbsactor.WBSActorFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.update(aRecord, aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }
  
  public int updateByPrimaryKey(org.r3.db.wbs.wbsactor.WBSActorDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.updateByPrimaryKey(aRecord, pcfg);
      return numberOfRowsAffected;  
  }


}
  
