//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



package org.r3.db.bbs.bbsthreadnodeview;


import java.util.List;

import org.apache.ibatis.session.RowBounds;

public class BBSThreadNodeViewPersistenceBase
{
  protected BBSThreadNodeViewMapper mapper;
  
  public void setMapper(BBSThreadNodeViewMapper aMapper)
  {
     this.mapper = aMapper;
  }
  
  public BBSThreadNodeViewPersistenceBase ()
  {
  
  }

  public org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewDTO selectFirst(org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {   
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewFilter();
      }
      filterCondition.setLimitFetch(1);

      List<org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewDTO> l = select(filterCondition, pcfg, new RowBounds(0, 1));
      if (l != null && l.size() > 0)
     			return l.get(0);
     			
      return null;
  }
      
  public List<org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewDTO> select(org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {      
      return select(filterCondition, pcfg, null);
  }

  public List<org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewDTO> select(org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg, RowBounds aRowBounds)
  {      
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewFilter();
      }
            
      if (aRowBounds == null)
         aRowBounds = new RowBounds();
      else
      {      
    	   if (aRowBounds.getLimit() < RowBounds.NO_ROW_LIMIT)
              filterCondition.setLimitFetch(aRowBounds.getOffset() + aRowBounds.getLimit());
      }
                              
      List<org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewDTO> listOfDTOs = this.mapper.select(filterCondition, pcfg, aRowBounds);
      return listOfDTOs;
  }
  
  public int count(org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.count(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewDataTableAdapter query(
      org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg, 
      String sEcho, 
      int iDisplayStart, 
      int iDisplayLength,
      boolean countElements)
  {  
    	int numberOfItems = (countElements) ? count(aFilterCondition, pcfg) : -1;    	
    	List<org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewDTO> l = null;
    	if (numberOfItems != 0)
    	{
    	RowBounds rb = new RowBounds(
    					(iDisplayStart >= 0)  ? iDisplayStart : RowBounds.NO_ROW_OFFSET, 
    			    (iDisplayLength > 0) ? iDisplayLength : RowBounds.NO_ROW_LIMIT);
    	    	
		  l = select(aFilterCondition, pcfg, rb);
      }
      
		  org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewDataTableAdapter dt = new org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewDataTableAdapter();
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

  public org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewDataTableAdapter query(
      org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg)
  {
      return query(aFilterCondition, pcfg, "1", -1, -1, false); 
  }  
}
  
