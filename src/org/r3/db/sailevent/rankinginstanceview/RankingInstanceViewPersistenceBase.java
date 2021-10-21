//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



package org.r3.db.sailevent.rankinginstanceview;


import java.util.List;

import org.apache.ibatis.session.RowBounds;

public class RankingInstanceViewPersistenceBase
{
  protected RankingInstanceViewMapper mapper;
  
  public void setMapper(RankingInstanceViewMapper aMapper)
  {
     this.mapper = aMapper;
  }
  
  public RankingInstanceViewPersistenceBase ()
  {
  
  }

  public org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewDTO selectFirst(org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {   
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewFilter();
      }
      filterCondition.setLimitFetch(1);

      List<org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewDTO> l = select(filterCondition, pcfg, new RowBounds(0, 1));
      if (l != null && l.size() > 0)
     			return l.get(0);
     			
      return null;
  }
      
  public List<org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewDTO> select(org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {      
      return select(filterCondition, pcfg, null);
  }

  public List<org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewDTO> select(org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg, RowBounds aRowBounds)
  {      
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewFilter();
      }
            
      if (aRowBounds == null)
         aRowBounds = new RowBounds();
      else
      {      
    	   if (aRowBounds.getLimit() < RowBounds.NO_ROW_LIMIT)
              filterCondition.setLimitFetch(aRowBounds.getOffset() + aRowBounds.getLimit());
      }
                              
      List<org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewDTO> listOfDTOs = this.mapper.select(filterCondition, pcfg, aRowBounds);
      return listOfDTOs;
  }
  
  public int count(org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.count(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewDataTableAdapter query(
      org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg, 
      String sEcho, 
      int iDisplayStart, 
      int iDisplayLength,
      boolean countElements)
  {  
    	int numberOfItems = (countElements) ? count(aFilterCondition, pcfg) : -1;    	
    	List<org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewDTO> l = null;
    	if (numberOfItems != 0)
    	{
    	RowBounds rb = new RowBounds(
    					(iDisplayStart >= 0)  ? iDisplayStart : RowBounds.NO_ROW_OFFSET, 
    			    (iDisplayLength > 0) ? iDisplayLength : RowBounds.NO_ROW_LIMIT);
    	    	
		  l = select(aFilterCondition, pcfg, rb);
      }
      
		  org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewDataTableAdapter dt = new org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewDataTableAdapter();
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

  public org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewDataTableAdapter query(
      org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg)
  {
      return query(aFilterCondition, pcfg, "1", -1, -1, false); 
  }  
}
  
