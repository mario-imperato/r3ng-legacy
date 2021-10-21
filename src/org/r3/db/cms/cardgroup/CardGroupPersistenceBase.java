//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



package org.r3.db.cms.cardgroup;


import java.util.List;

import org.apache.ibatis.session.RowBounds;

public class CardGroupPersistenceBase
{
  protected CardGroupMapper mapper;
  
  public void setMapper(CardGroupMapper aMapper)
  {
     this.mapper = aMapper;
  }

  
  public CardGroupPersistenceBase ()
  {
  
  }
      
  public org.r3.db.cms.cardgroup.CardGroupDTO  selectBySiteCardidGroupid( java.lang.String site, java.lang.String cardid, java.lang.String groupid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.cms.cardgroup.CardGroupDTO dto = this.mapper.selectBySiteCardidGroupid( site, cardid, groupid, pcfg);
      return dto;
  }
  
  public int deleteBySiteCardidGroupid( java.lang.String site, java.lang.String cardid, java.lang.String groupid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteBySiteCardidGroupid( site, cardid, groupid, pcfg);
      return numberOfRowsAffected;  
  }
  
  public org.r3.db.cms.cardgroup.CardGroupDTO  selectByPrimaryKey(org.r3.db.cms.cardgroup.CardGroupKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.cms.cardgroup.CardGroupDTO dto = this.mapper.selectByPrimaryKey(pk, pcfg);
      return dto;
  }
  
  public int  deleteByPrimaryKey(org.r3.db.cms.cardgroup.CardGroupKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteByPrimaryKey(pk, pcfg);
      return numberOfRowsAffected;  
  }  

  public org.r3.db.cms.cardgroup.CardGroupDTO selectFirst(org.r3.db.cms.cardgroup.CardGroupFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {   
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.cms.cardgroup.CardGroupFilter();
      }
      filterCondition.setLimitFetch(1);

      List<org.r3.db.cms.cardgroup.CardGroupDTO> l = select(filterCondition, pcfg, new RowBounds(0, 1));
      if (l != null && l.size() > 0)
     			return l.get(0);
     			
      return null;
  }

  public List<org.r3.db.cms.cardgroup.CardGroupDTO> select(org.r3.db.cms.cardgroup.CardGroupFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {      
      return select(filterCondition, pcfg, null);
  }

  public List<org.r3.db.cms.cardgroup.CardGroupDTO> select(org.r3.db.cms.cardgroup.CardGroupFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg, RowBounds aRowBounds)
  {      
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.cms.cardgroup.CardGroupFilter();
      }
            
      if (aRowBounds == null)
         aRowBounds = new RowBounds();
      else
      {      
    	   if (aRowBounds.getLimit() < RowBounds.NO_ROW_LIMIT)
              filterCondition.setLimitFetch(aRowBounds.getOffset() + aRowBounds.getLimit());
      }
                        
      List<org.r3.db.cms.cardgroup.CardGroupDTO> listOfDTOs = this.mapper.select(filterCondition, pcfg, aRowBounds);
      return listOfDTOs;
  }
  
  public int count(org.r3.db.cms.cardgroup.CardGroupFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.count(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public org.r3.db.cms.cardgroup.CardGroupDataTableAdapter query(
      org.r3.db.cms.cardgroup.CardGroupFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg, 
      String sEcho, 
      int iDisplayStart, 
      int iDisplayLength,
      boolean countElements)
  {  
    	int numberOfItems = (countElements) ? count(aFilterCondition, pcfg) : -1;    	
    	List<org.r3.db.cms.cardgroup.CardGroupDTO> l = null;
    	if (numberOfItems != 0)
    	{
    	RowBounds rb = new RowBounds(
    					(iDisplayStart >= 0)  ? iDisplayStart : RowBounds.NO_ROW_OFFSET, 
    			    (iDisplayLength > 0) ? iDisplayLength : RowBounds.NO_ROW_LIMIT);
    	
		  l = select(aFilterCondition, pcfg, rb);
      }

		  org.r3.db.cms.cardgroup.CardGroupDataTableAdapter dt = new org.r3.db.cms.cardgroup.CardGroupDataTableAdapter();
		  dt.setsEcho(sEcho);
		  dt.setiTotalRecords(numberOfItems);
		  dt.setiTotalDisplayRecords(numberOfItems);
		  dt.setAaData(l);
		
		  return dt;
  }  
  
  public int delete(org.r3.db.cms.cardgroup.CardGroupFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.delete(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public int insert(org.r3.db.cms.cardgroup.CardGroupDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {

      int numberOfRowsAffected = this.mapper.insert(aRecord, pcfg);
      return numberOfRowsAffected;  
  }

  public int update(org.r3.db.cms.cardgroup.CardGroupDTO aRecord, org.r3.db.cms.cardgroup.CardGroupFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.update(aRecord, aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }
  
  public int updateByPrimaryKey(org.r3.db.cms.cardgroup.CardGroupDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.updateByPrimaryKey(aRecord, pcfg);
      return numberOfRowsAffected;  
  }


}
  
