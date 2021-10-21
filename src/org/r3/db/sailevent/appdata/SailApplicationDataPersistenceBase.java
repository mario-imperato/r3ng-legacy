//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



package org.r3.db.sailevent.appdata;


import java.util.List;

import org.apache.ibatis.session.RowBounds;

public class SailApplicationDataPersistenceBase
{
  protected SailApplicationDataMapper mapper;
  
  public void setMapper(SailApplicationDataMapper aMapper)
  {
     this.mapper = aMapper;
  }

  
  public SailApplicationDataPersistenceBase ()
  {
  
  }
      
  public org.r3.db.sailevent.appdata.SailApplicationDataDTO  selectByEventidApplicationidSectionidParamname( java.lang.String eventid, java.lang.String applicationid, java.lang.String sectionid, java.lang.String paramname, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.sailevent.appdata.SailApplicationDataDTO dto = this.mapper.selectByEventidApplicationidSectionidParamname( eventid, applicationid, sectionid, paramname, pcfg);
      return dto;
  }
  
  public int deleteByEventidApplicationidSectionidParamname( java.lang.String eventid, java.lang.String applicationid, java.lang.String sectionid, java.lang.String paramname, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteByEventidApplicationidSectionidParamname( eventid, applicationid, sectionid, paramname, pcfg);
      return numberOfRowsAffected;  
  }
  
  public org.r3.db.sailevent.appdata.SailApplicationDataDTO  selectByPrimaryKey(org.r3.db.sailevent.appdata.SailApplicationDataKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.sailevent.appdata.SailApplicationDataDTO dto = this.mapper.selectByPrimaryKey(pk, pcfg);
      return dto;
  }
  
  public int  deleteByPrimaryKey(org.r3.db.sailevent.appdata.SailApplicationDataKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteByPrimaryKey(pk, pcfg);
      return numberOfRowsAffected;  
  }  

  public org.r3.db.sailevent.appdata.SailApplicationDataDTO selectFirst(org.r3.db.sailevent.appdata.SailApplicationDataFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {   
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.sailevent.appdata.SailApplicationDataFilter();
      }
      filterCondition.setLimitFetch(1);

      List<org.r3.db.sailevent.appdata.SailApplicationDataDTO> l = select(filterCondition, pcfg, new RowBounds(0, 1));
      if (l != null && l.size() > 0)
     			return l.get(0);
     			
      return null;
  }

  public List<org.r3.db.sailevent.appdata.SailApplicationDataDTO> select(org.r3.db.sailevent.appdata.SailApplicationDataFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {      
      return select(filterCondition, pcfg, null);
  }

  public List<org.r3.db.sailevent.appdata.SailApplicationDataDTO> select(org.r3.db.sailevent.appdata.SailApplicationDataFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg, RowBounds aRowBounds)
  {      
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.sailevent.appdata.SailApplicationDataFilter();
      }
            
      if (aRowBounds == null)
         aRowBounds = new RowBounds();
      else
      {      
    	   if (aRowBounds.getLimit() < RowBounds.NO_ROW_LIMIT)
              filterCondition.setLimitFetch(aRowBounds.getOffset() + aRowBounds.getLimit());
      }
                        
      List<org.r3.db.sailevent.appdata.SailApplicationDataDTO> listOfDTOs = this.mapper.select(filterCondition, pcfg, aRowBounds);
      return listOfDTOs;
  }
  
  public int count(org.r3.db.sailevent.appdata.SailApplicationDataFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.count(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public org.r3.db.sailevent.appdata.SailApplicationDataDataTableAdapter query(
      org.r3.db.sailevent.appdata.SailApplicationDataFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg, 
      String sEcho, 
      int iDisplayStart, 
      int iDisplayLength,
      boolean countElements)
  {  
    	int numberOfItems = (countElements) ? count(aFilterCondition, pcfg) : -1;    	
    	List<org.r3.db.sailevent.appdata.SailApplicationDataDTO> l = null;
    	if (numberOfItems != 0)
    	{
    	RowBounds rb = new RowBounds(
    					(iDisplayStart >= 0)  ? iDisplayStart : RowBounds.NO_ROW_OFFSET, 
    			    (iDisplayLength > 0) ? iDisplayLength : RowBounds.NO_ROW_LIMIT);
    	
		  l = select(aFilterCondition, pcfg, rb);
      }

		  org.r3.db.sailevent.appdata.SailApplicationDataDataTableAdapter dt = new org.r3.db.sailevent.appdata.SailApplicationDataDataTableAdapter();
		  dt.setsEcho(sEcho);
		  dt.setiTotalRecords(numberOfItems);
		  dt.setiTotalDisplayRecords(numberOfItems);
		  dt.setAaData(l);
		
		  return dt;
  }  
  
  public int delete(org.r3.db.sailevent.appdata.SailApplicationDataFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.delete(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public int insert(org.r3.db.sailevent.appdata.SailApplicationDataDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {

      int numberOfRowsAffected = this.mapper.insert(aRecord, pcfg);
      return numberOfRowsAffected;  
  }

  public int update(org.r3.db.sailevent.appdata.SailApplicationDataDTO aRecord, org.r3.db.sailevent.appdata.SailApplicationDataFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.update(aRecord, aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }
  
  public int updateByPrimaryKey(org.r3.db.sailevent.appdata.SailApplicationDataDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.updateByPrimaryKey(aRecord, pcfg);
      return numberOfRowsAffected;  
  }


}
  
