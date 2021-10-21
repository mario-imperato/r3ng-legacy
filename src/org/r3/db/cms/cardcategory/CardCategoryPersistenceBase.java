//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



package org.r3.db.cms.cardcategory;


import java.util.List;

import org.apache.ibatis.session.RowBounds;

public class CardCategoryPersistenceBase
{
  protected CardCategoryMapper mapper;
  
  public void setMapper(CardCategoryMapper aMapper)
  {
     this.mapper = aMapper;
  }

  
  public CardCategoryPersistenceBase ()
  {
  
  }
      
  public org.r3.db.cms.cardcategory.CardCategoryDTO  selectBySiteCardidCategoryid( java.lang.String site, java.lang.String cardid, java.lang.String categoryid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.cms.cardcategory.CardCategoryDTO dto = this.mapper.selectBySiteCardidCategoryid( site, cardid, categoryid, pcfg);
      return dto;
  }
  
  public int deleteBySiteCardidCategoryid( java.lang.String site, java.lang.String cardid, java.lang.String categoryid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteBySiteCardidCategoryid( site, cardid, categoryid, pcfg);
      return numberOfRowsAffected;  
  }
  
  public org.r3.db.cms.cardcategory.CardCategoryDTO  selectByPrimaryKey(org.r3.db.cms.cardcategory.CardCategoryKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.cms.cardcategory.CardCategoryDTO dto = this.mapper.selectByPrimaryKey(pk, pcfg);
      return dto;
  }
  
  public int  deleteByPrimaryKey(org.r3.db.cms.cardcategory.CardCategoryKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteByPrimaryKey(pk, pcfg);
      return numberOfRowsAffected;  
  }  

  public org.r3.db.cms.cardcategory.CardCategoryDTO selectFirst(org.r3.db.cms.cardcategory.CardCategoryFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {   
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.cms.cardcategory.CardCategoryFilter();
      }
      filterCondition.setLimitFetch(1);

      List<org.r3.db.cms.cardcategory.CardCategoryDTO> l = select(filterCondition, pcfg, new RowBounds(0, 1));
      if (l != null && l.size() > 0)
     			return l.get(0);
     			
      return null;
  }

  public List<org.r3.db.cms.cardcategory.CardCategoryDTO> select(org.r3.db.cms.cardcategory.CardCategoryFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {      
      return select(filterCondition, pcfg, null);
  }

  public List<org.r3.db.cms.cardcategory.CardCategoryDTO> select(org.r3.db.cms.cardcategory.CardCategoryFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg, RowBounds aRowBounds)
  {      
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.cms.cardcategory.CardCategoryFilter();
      }
            
      if (aRowBounds == null)
         aRowBounds = new RowBounds();
      else
      {      
    	   if (aRowBounds.getLimit() < RowBounds.NO_ROW_LIMIT)
              filterCondition.setLimitFetch(aRowBounds.getOffset() + aRowBounds.getLimit());
      }
                        
      List<org.r3.db.cms.cardcategory.CardCategoryDTO> listOfDTOs = this.mapper.select(filterCondition, pcfg, aRowBounds);
      return listOfDTOs;
  }
  
  public int count(org.r3.db.cms.cardcategory.CardCategoryFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.count(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public org.r3.db.cms.cardcategory.CardCategoryDataTableAdapter query(
      org.r3.db.cms.cardcategory.CardCategoryFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg, 
      String sEcho, 
      int iDisplayStart, 
      int iDisplayLength,
      boolean countElements)
  {  
    	int numberOfItems = (countElements) ? count(aFilterCondition, pcfg) : -1;    	
    	List<org.r3.db.cms.cardcategory.CardCategoryDTO> l = null;
    	if (numberOfItems != 0)
    	{
    	RowBounds rb = new RowBounds(
    					(iDisplayStart >= 0)  ? iDisplayStart : RowBounds.NO_ROW_OFFSET, 
    			    (iDisplayLength > 0) ? iDisplayLength : RowBounds.NO_ROW_LIMIT);
    	
		  l = select(aFilterCondition, pcfg, rb);
      }

		  org.r3.db.cms.cardcategory.CardCategoryDataTableAdapter dt = new org.r3.db.cms.cardcategory.CardCategoryDataTableAdapter();
		  dt.setsEcho(sEcho);
		  dt.setiTotalRecords(numberOfItems);
		  dt.setiTotalDisplayRecords(numberOfItems);
		  dt.setAaData(l);
		
		  return dt;
  }  
  
  public int delete(org.r3.db.cms.cardcategory.CardCategoryFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.delete(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public int insert(org.r3.db.cms.cardcategory.CardCategoryDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {

      int numberOfRowsAffected = this.mapper.insert(aRecord, pcfg);
      return numberOfRowsAffected;  
  }

  public int update(org.r3.db.cms.cardcategory.CardCategoryDTO aRecord, org.r3.db.cms.cardcategory.CardCategoryFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.update(aRecord, aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }
  
  public int updateByPrimaryKey(org.r3.db.cms.cardcategory.CardCategoryDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.updateByPrimaryKey(aRecord, pcfg);
      return numberOfRowsAffected;  
  }


}
  
