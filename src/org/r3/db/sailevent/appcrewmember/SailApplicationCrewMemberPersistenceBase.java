//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



package org.r3.db.sailevent.appcrewmember;


import java.util.List;

import org.apache.ibatis.session.RowBounds;

public class SailApplicationCrewMemberPersistenceBase
{
  protected SailApplicationCrewMemberMapper mapper;
  
  public void setMapper(SailApplicationCrewMemberMapper aMapper)
  {
     this.mapper = aMapper;
  }


  protected org.r3.db.system.sequence.SequencePersistence  sequencePersistence;    
  
  public void setSequencePersistence(org.r3.db.system.sequence.SequencePersistence aSequencePersistence)
  {
      this.sequencePersistence = aSequencePersistence;
  }
   
  public String getCrewmemberid_sequence(org.r3.db.PersistenceConfigInfo pcfg)
  {
     String seqId = null;
     seqId = sequencePersistence.getSequence("CREW", pcfg.getSequenceSubPrefix());
     return seqId;
  }
  
  
  public SailApplicationCrewMemberPersistenceBase ()
  {
  
  }
      
  public org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTO  selectByCrewmemberid(
         java.lang.String crewmemberid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTO dto = this.mapper.selectByCrewmemberid(crewmemberid, pcfg);
      return dto;
  }

  public int deleteByCrewmemberid(java.lang.String crewmemberid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteByCrewmemberid(crewmemberid, pcfg);
      return numberOfRowsAffected;
  }  
  public org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTO  selectByPrimaryKey(org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTO dto = this.mapper.selectByPrimaryKey(pk, pcfg);
      return dto;
  }
  
  public int  deleteByPrimaryKey(org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteByPrimaryKey(pk, pcfg);
      return numberOfRowsAffected;  
  }  

  public org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTO selectFirst(org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {   
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberFilter();
      }
      filterCondition.setLimitFetch(1);

      List<org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTO> l = select(filterCondition, pcfg, new RowBounds(0, 1));
      if (l != null && l.size() > 0)
     			return l.get(0);
     			
      return null;
  }

  public List<org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTO> select(org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {      
      return select(filterCondition, pcfg, null);
  }

  public List<org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTO> select(org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg, RowBounds aRowBounds)
  {      
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberFilter();
      }
            
      if (aRowBounds == null)
         aRowBounds = new RowBounds();
      else
      {      
    	   if (aRowBounds.getLimit() < RowBounds.NO_ROW_LIMIT)
              filterCondition.setLimitFetch(aRowBounds.getOffset() + aRowBounds.getLimit());
      }
                        
      List<org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTO> listOfDTOs = this.mapper.select(filterCondition, pcfg, aRowBounds);
      return listOfDTOs;
  }
  
  public int count(org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.count(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDataTableAdapter query(
      org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg, 
      String sEcho, 
      int iDisplayStart, 
      int iDisplayLength,
      boolean countElements)
  {  
    	int numberOfItems = (countElements) ? count(aFilterCondition, pcfg) : -1;    	
    	List<org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTO> l = null;
    	if (numberOfItems != 0)
    	{
    	RowBounds rb = new RowBounds(
    					(iDisplayStart >= 0)  ? iDisplayStart : RowBounds.NO_ROW_OFFSET, 
    			    (iDisplayLength > 0) ? iDisplayLength : RowBounds.NO_ROW_LIMIT);
    	
		  l = select(aFilterCondition, pcfg, rb);
      }

		  org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDataTableAdapter dt = new org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDataTableAdapter();
		  dt.setsEcho(sEcho);
		  dt.setiTotalRecords(numberOfItems);
		  dt.setiTotalDisplayRecords(numberOfItems);
		  dt.setAaData(l);
		
		  return dt;
  }  
  
  public int delete(org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.delete(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public int insert(org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {
      String seqId = null;
      if (aRecord.getCrewmemberid() == null)
      {     
        seqId = getCrewmemberid_sequence(pcfg);
        aRecord.setCrewmemberid(seqId);
      }      

      int numberOfRowsAffected = this.mapper.insert(aRecord, pcfg);
      return numberOfRowsAffected;  
  }

  public int update(org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTO aRecord, org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.update(aRecord, aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }
  
  public int updateByPrimaryKey(org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.updateByPrimaryKey(aRecord, pcfg);
      return numberOfRowsAffected;  
  }


}
  
