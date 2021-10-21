//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



package org.r3.db.system.siteportletcfg;


import java.util.List;

import org.apache.ibatis.session.RowBounds;

public class SitePortletConfigPersistenceBase
{
  protected SitePortletConfigMapper mapper;
  
  public void setMapper(SitePortletConfigMapper aMapper)
  {
     this.mapper = aMapper;
  }

  
  public SitePortletConfigPersistenceBase ()
  {
  
  }
      
  public org.r3.db.system.siteportletcfg.SitePortletConfigDTO  selectBySitePageidPositionid( java.lang.String site, java.lang.String pageid, java.lang.String positionid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.system.siteportletcfg.SitePortletConfigDTO dto = this.mapper.selectBySitePageidPositionid( site, pageid, positionid, pcfg);
      return dto;
  }
  
  public int deleteBySitePageidPositionid( java.lang.String site, java.lang.String pageid, java.lang.String positionid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteBySitePageidPositionid( site, pageid, positionid, pcfg);
      return numberOfRowsAffected;  
  }
  
  public org.r3.db.system.siteportletcfg.SitePortletConfigDTO  selectByPrimaryKey(org.r3.db.system.siteportletcfg.SitePortletConfigKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.system.siteportletcfg.SitePortletConfigDTO dto = this.mapper.selectByPrimaryKey(pk, pcfg);
      return dto;
  }
  
  public int  deleteByPrimaryKey(org.r3.db.system.siteportletcfg.SitePortletConfigKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteByPrimaryKey(pk, pcfg);
      return numberOfRowsAffected;  
  }  

  public org.r3.db.system.siteportletcfg.SitePortletConfigDTO selectFirst(org.r3.db.system.siteportletcfg.SitePortletConfigFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {   
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.system.siteportletcfg.SitePortletConfigFilter();
      }
      filterCondition.setLimitFetch(1);

      List<org.r3.db.system.siteportletcfg.SitePortletConfigDTO> l = select(filterCondition, pcfg, new RowBounds(0, 1));
      if (l != null && l.size() > 0)
     			return l.get(0);
     			
      return null;
  }

  public List<org.r3.db.system.siteportletcfg.SitePortletConfigDTO> select(org.r3.db.system.siteportletcfg.SitePortletConfigFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {      
      return select(filterCondition, pcfg, null);
  }

  public List<org.r3.db.system.siteportletcfg.SitePortletConfigDTO> select(org.r3.db.system.siteportletcfg.SitePortletConfigFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg, RowBounds aRowBounds)
  {      
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.system.siteportletcfg.SitePortletConfigFilter();
      }
            
      if (aRowBounds == null)
         aRowBounds = new RowBounds();
      else
      {      
    	   if (aRowBounds.getLimit() < RowBounds.NO_ROW_LIMIT)
              filterCondition.setLimitFetch(aRowBounds.getOffset() + aRowBounds.getLimit());
      }
                        
      List<org.r3.db.system.siteportletcfg.SitePortletConfigDTO> listOfDTOs = this.mapper.select(filterCondition, pcfg, aRowBounds);
      return listOfDTOs;
  }
  
  public int count(org.r3.db.system.siteportletcfg.SitePortletConfigFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.count(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public org.r3.db.system.siteportletcfg.SitePortletConfigDataTableAdapter query(
      org.r3.db.system.siteportletcfg.SitePortletConfigFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg, 
      String sEcho, 
      int iDisplayStart, 
      int iDisplayLength,
      boolean countElements)
  {  
    	int numberOfItems = (countElements) ? count(aFilterCondition, pcfg) : -1;    	
    	List<org.r3.db.system.siteportletcfg.SitePortletConfigDTO> l = null;
    	if (numberOfItems != 0)
    	{
    	RowBounds rb = new RowBounds(
    					(iDisplayStart >= 0)  ? iDisplayStart : RowBounds.NO_ROW_OFFSET, 
    			    (iDisplayLength > 0) ? iDisplayLength : RowBounds.NO_ROW_LIMIT);
    	
		  l = select(aFilterCondition, pcfg, rb);
      }

		  org.r3.db.system.siteportletcfg.SitePortletConfigDataTableAdapter dt = new org.r3.db.system.siteportletcfg.SitePortletConfigDataTableAdapter();
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

  public org.r3.db.system.siteportletcfg.SitePortletConfigDataTableAdapter query(
      org.r3.db.system.siteportletcfg.SitePortletConfigFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg)
  {  
      return query(aFilterCondition, pcfg, "1", -1, -1, false);
  }  
  
  public int delete(org.r3.db.system.siteportletcfg.SitePortletConfigFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.delete(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public int insert(org.r3.db.system.siteportletcfg.SitePortletConfigDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {

      int numberOfRowsAffected = this.mapper.insert(aRecord, pcfg);
      return numberOfRowsAffected;  
  }

  public int update(org.r3.db.system.siteportletcfg.SitePortletConfigDTO aRecord, org.r3.db.system.siteportletcfg.SitePortletConfigFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.update(aRecord, aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }
  
  public int updateByPrimaryKey(org.r3.db.system.siteportletcfg.SitePortletConfigDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.updateByPrimaryKey(aRecord, pcfg);
      return numberOfRowsAffected;  
  }


}
  
