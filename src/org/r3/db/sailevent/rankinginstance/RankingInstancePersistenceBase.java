//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



package org.r3.db.sailevent.rankinginstance;


import java.util.List;

import org.apache.ibatis.session.RowBounds;

public class RankingInstancePersistenceBase
{
  protected RankingInstanceMapper mapper;
  
  public void setMapper(RankingInstanceMapper aMapper)
  {
     this.mapper = aMapper;
  }


  protected org.r3.db.system.sequence.SequencePersistence  sequencePersistence;    
  
  public void setSequencePersistence(org.r3.db.system.sequence.SequencePersistence aSequencePersistence)
  {
      this.sequencePersistence = aSequencePersistence;
  }
   
  public String getInstanceid_sequence(org.r3.db.PersistenceConfigInfo pcfg)
  {
     String seqId = null;
     seqId = sequencePersistence.getSequence("RAC", pcfg.getSequenceSubPrefix());
     return seqId;
  }
  
  
  public RankingInstancePersistenceBase ()
  {
  
  }
      
  public org.r3.db.sailevent.rankinginstance.RankingInstanceDTO  selectByEventidInstanceid( java.lang.String eventid, java.lang.String instanceid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.sailevent.rankinginstance.RankingInstanceDTO dto = this.mapper.selectByEventidInstanceid( eventid, instanceid, pcfg);
      return dto;
  }
  
  public int deleteByEventidInstanceid( java.lang.String eventid, java.lang.String instanceid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteByEventidInstanceid( eventid, instanceid, pcfg);
      return numberOfRowsAffected;  
  }
  
  public org.r3.db.sailevent.rankinginstance.RankingInstanceDTO  selectByPrimaryKey(org.r3.db.sailevent.rankinginstance.RankingInstanceKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.sailevent.rankinginstance.RankingInstanceDTO dto = this.mapper.selectByPrimaryKey(pk, pcfg);
      return dto;
  }
  
  public int  deleteByPrimaryKey(org.r3.db.sailevent.rankinginstance.RankingInstanceKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteByPrimaryKey(pk, pcfg);
      return numberOfRowsAffected;  
  }  

  public org.r3.db.sailevent.rankinginstance.RankingInstanceDTO selectFirst(org.r3.db.sailevent.rankinginstance.RankingInstanceFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {   
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.sailevent.rankinginstance.RankingInstanceFilter();
      }
      filterCondition.setLimitFetch(1);

      List<org.r3.db.sailevent.rankinginstance.RankingInstanceDTO> l = select(filterCondition, pcfg, new RowBounds(0, 1));
      if (l != null && l.size() > 0)
     			return l.get(0);
     			
      return null;
  }

  public List<org.r3.db.sailevent.rankinginstance.RankingInstanceDTO> select(org.r3.db.sailevent.rankinginstance.RankingInstanceFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {      
      return select(filterCondition, pcfg, null);
  }

  public List<org.r3.db.sailevent.rankinginstance.RankingInstanceDTO> select(org.r3.db.sailevent.rankinginstance.RankingInstanceFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg, RowBounds aRowBounds)
  {      
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.sailevent.rankinginstance.RankingInstanceFilter();
      }
            
      if (aRowBounds == null)
         aRowBounds = new RowBounds();
      else
      {      
    	   if (aRowBounds.getLimit() < RowBounds.NO_ROW_LIMIT)
              filterCondition.setLimitFetch(aRowBounds.getOffset() + aRowBounds.getLimit());
      }
                        
      List<org.r3.db.sailevent.rankinginstance.RankingInstanceDTO> listOfDTOs = this.mapper.select(filterCondition, pcfg, aRowBounds);
      return listOfDTOs;
  }
  
  public int count(org.r3.db.sailevent.rankinginstance.RankingInstanceFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.count(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public org.r3.db.sailevent.rankinginstance.RankingInstanceDataTableAdapter query(
      org.r3.db.sailevent.rankinginstance.RankingInstanceFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg, 
      String sEcho, 
      int iDisplayStart, 
      int iDisplayLength,
      boolean countElements)
  {  
    	int numberOfItems = (countElements) ? count(aFilterCondition, pcfg) : -1;    	
    	List<org.r3.db.sailevent.rankinginstance.RankingInstanceDTO> l = null;
    	if (numberOfItems != 0)
    	{
    	RowBounds rb = new RowBounds(
    					(iDisplayStart >= 0)  ? iDisplayStart : RowBounds.NO_ROW_OFFSET, 
    			    (iDisplayLength > 0) ? iDisplayLength : RowBounds.NO_ROW_LIMIT);
    	
		  l = select(aFilterCondition, pcfg, rb);
      }

		  org.r3.db.sailevent.rankinginstance.RankingInstanceDataTableAdapter dt = new org.r3.db.sailevent.rankinginstance.RankingInstanceDataTableAdapter();
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

  public org.r3.db.sailevent.rankinginstance.RankingInstanceDataTableAdapter query(
      org.r3.db.sailevent.rankinginstance.RankingInstanceFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg)
  {  
      return query(aFilterCondition, pcfg, "1", -1, -1, false);
  }  
  
  public int delete(org.r3.db.sailevent.rankinginstance.RankingInstanceFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.delete(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public int insert(org.r3.db.sailevent.rankinginstance.RankingInstanceDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {
      String seqId = null;
      if (aRecord.getInstanceid() == null)
      {     
        seqId = getInstanceid_sequence(pcfg);
        aRecord.setInstanceid(seqId);
      }      

      int numberOfRowsAffected = this.mapper.insert(aRecord, pcfg);
      return numberOfRowsAffected;  
  }

  public int update(org.r3.db.sailevent.rankinginstance.RankingInstanceDTO aRecord, org.r3.db.sailevent.rankinginstance.RankingInstanceFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.update(aRecord, aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }
  
  public int updateByPrimaryKey(org.r3.db.sailevent.rankinginstance.RankingInstanceDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.updateByPrimaryKey(aRecord, pcfg);
      return numberOfRowsAffected;  
  }


}
  
