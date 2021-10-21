//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



package org.r3.db.bbs.bbstopic;


import java.util.List;

import org.apache.ibatis.session.RowBounds;

public class BBSTopicPersistenceBase
{
  protected BBSTopicMapper mapper;
  
  public void setMapper(BBSTopicMapper aMapper)
  {
     this.mapper = aMapper;
  }


  protected org.r3.db.system.sequence.SequencePersistence  sequencePersistence;    
  
  public void setSequencePersistence(org.r3.db.system.sequence.SequencePersistence aSequencePersistence)
  {
      this.sequencePersistence = aSequencePersistence;
  }
   
  public String getTopicid_sequence(org.r3.db.PersistenceConfigInfo pcfg)
  {
     String seqId = null;
     seqId = sequencePersistence.getSequence("BBS", pcfg.getSequenceSubPrefix());
     return seqId;
  }
  
  
  public BBSTopicPersistenceBase ()
  {
  
  }
      
  public org.r3.db.bbs.bbstopic.BBSTopicDTO  selectBySiteTopicid( java.lang.String site, java.lang.String topicid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.bbs.bbstopic.BBSTopicDTO dto = this.mapper.selectBySiteTopicid( site, topicid, pcfg);
      return dto;
  }
  
  public int deleteBySiteTopicid( java.lang.String site, java.lang.String topicid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteBySiteTopicid( site, topicid, pcfg);
      return numberOfRowsAffected;  
  }
  
  public org.r3.db.bbs.bbstopic.BBSTopicDTO  selectByPrimaryKey(org.r3.db.bbs.bbstopic.BBSTopicKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.bbs.bbstopic.BBSTopicDTO dto = this.mapper.selectByPrimaryKey(pk, pcfg);
      return dto;
  }
  
  public int  deleteByPrimaryKey(org.r3.db.bbs.bbstopic.BBSTopicKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteByPrimaryKey(pk, pcfg);
      return numberOfRowsAffected;  
  }  

  public org.r3.db.bbs.bbstopic.BBSTopicDTO selectFirst(org.r3.db.bbs.bbstopic.BBSTopicFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {   
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.bbs.bbstopic.BBSTopicFilter();
      }
      filterCondition.setLimitFetch(1);

      List<org.r3.db.bbs.bbstopic.BBSTopicDTO> l = select(filterCondition, pcfg, new RowBounds(0, 1));
      if (l != null && l.size() > 0)
     			return l.get(0);
     			
      return null;
  }

  public List<org.r3.db.bbs.bbstopic.BBSTopicDTO> select(org.r3.db.bbs.bbstopic.BBSTopicFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {      
      return select(filterCondition, pcfg, null);
  }

  public List<org.r3.db.bbs.bbstopic.BBSTopicDTO> select(org.r3.db.bbs.bbstopic.BBSTopicFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg, RowBounds aRowBounds)
  {      
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.bbs.bbstopic.BBSTopicFilter();
      }
            
      if (aRowBounds == null)
         aRowBounds = new RowBounds();
      else
      {      
    	   if (aRowBounds.getLimit() < RowBounds.NO_ROW_LIMIT)
              filterCondition.setLimitFetch(aRowBounds.getOffset() + aRowBounds.getLimit());
      }
                        
      List<org.r3.db.bbs.bbstopic.BBSTopicDTO> listOfDTOs = this.mapper.select(filterCondition, pcfg, aRowBounds);
      return listOfDTOs;
  }
  
  public int count(org.r3.db.bbs.bbstopic.BBSTopicFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.count(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public org.r3.db.bbs.bbstopic.BBSTopicDataTableAdapter query(
      org.r3.db.bbs.bbstopic.BBSTopicFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg, 
      String sEcho, 
      int iDisplayStart, 
      int iDisplayLength,
      boolean countElements)
  {  
    	int numberOfItems = (countElements) ? count(aFilterCondition, pcfg) : -1;    	
    	List<org.r3.db.bbs.bbstopic.BBSTopicDTO> l = null;
    	if (numberOfItems != 0)
    	{
    	RowBounds rb = new RowBounds(
    					(iDisplayStart >= 0)  ? iDisplayStart : RowBounds.NO_ROW_OFFSET, 
    			    (iDisplayLength > 0) ? iDisplayLength : RowBounds.NO_ROW_LIMIT);
    	
		  l = select(aFilterCondition, pcfg, rb);
      }

		  org.r3.db.bbs.bbstopic.BBSTopicDataTableAdapter dt = new org.r3.db.bbs.bbstopic.BBSTopicDataTableAdapter();
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

  public org.r3.db.bbs.bbstopic.BBSTopicDataTableAdapter query(
      org.r3.db.bbs.bbstopic.BBSTopicFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg)
  {  
      return query(aFilterCondition, pcfg, "1", -1, -1, false);
  }  
  
  public int delete(org.r3.db.bbs.bbstopic.BBSTopicFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.delete(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public int insert(org.r3.db.bbs.bbstopic.BBSTopicDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {
      String seqId = null;
      if (aRecord.getTopicid() == null)
      {     
        seqId = getTopicid_sequence(pcfg);
        aRecord.setTopicid(seqId);
      }      

      int numberOfRowsAffected = this.mapper.insert(aRecord, pcfg);
      return numberOfRowsAffected;  
  }

  public int update(org.r3.db.bbs.bbstopic.BBSTopicDTO aRecord, org.r3.db.bbs.bbstopic.BBSTopicFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.update(aRecord, aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }
  
  public int updateByPrimaryKey(org.r3.db.bbs.bbstopic.BBSTopicDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.updateByPrimaryKey(aRecord, pcfg);
      return numberOfRowsAffected;  
  }


}
  
