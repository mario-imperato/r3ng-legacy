//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



package org.r3.db.system.user.userrole;


import java.util.List;

import org.apache.ibatis.session.RowBounds;

public class UserRolePersistenceBase
{
  protected UserRoleMapper mapper;
  
  public void setMapper(UserRoleMapper aMapper)
  {
     this.mapper = aMapper;
  }

  
  public UserRolePersistenceBase ()
  {
  
  }
      
  public org.r3.db.system.user.userrole.UserRoleDTO  selectBySiteUseridRoleid( java.lang.String site, java.lang.String userid, java.lang.String roleid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.system.user.userrole.UserRoleDTO dto = this.mapper.selectBySiteUseridRoleid( site, userid, roleid, pcfg);
      return dto;
  }
  
  public int deleteBySiteUseridRoleid( java.lang.String site, java.lang.String userid, java.lang.String roleid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteBySiteUseridRoleid( site, userid, roleid, pcfg);
      return numberOfRowsAffected;  
  }
  
  public org.r3.db.system.user.userrole.UserRoleDTO  selectByPrimaryKey(org.r3.db.system.user.userrole.UserRoleKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.system.user.userrole.UserRoleDTO dto = this.mapper.selectByPrimaryKey(pk, pcfg);
      return dto;
  }
  
  public int  deleteByPrimaryKey(org.r3.db.system.user.userrole.UserRoleKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteByPrimaryKey(pk, pcfg);
      return numberOfRowsAffected;  
  }  

  public org.r3.db.system.user.userrole.UserRoleDTO selectFirst(org.r3.db.system.user.userrole.UserRoleFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {   
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.system.user.userrole.UserRoleFilter();
      }
      filterCondition.setLimitFetch(1);

      List<org.r3.db.system.user.userrole.UserRoleDTO> l = select(filterCondition, pcfg, new RowBounds(0, 1));
      if (l != null && l.size() > 0)
     			return l.get(0);
     			
      return null;
  }

  public List<org.r3.db.system.user.userrole.UserRoleDTO> select(org.r3.db.system.user.userrole.UserRoleFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {      
      return select(filterCondition, pcfg, null);
  }

  public List<org.r3.db.system.user.userrole.UserRoleDTO> select(org.r3.db.system.user.userrole.UserRoleFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg, RowBounds aRowBounds)
  {      
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.system.user.userrole.UserRoleFilter();
      }
            
      if (aRowBounds == null)
         aRowBounds = new RowBounds();
      else
      {      
    	   if (aRowBounds.getLimit() < RowBounds.NO_ROW_LIMIT)
              filterCondition.setLimitFetch(aRowBounds.getOffset() + aRowBounds.getLimit());
      }
                        
      List<org.r3.db.system.user.userrole.UserRoleDTO> listOfDTOs = this.mapper.select(filterCondition, pcfg, aRowBounds);
      return listOfDTOs;
  }
  
  public int count(org.r3.db.system.user.userrole.UserRoleFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.count(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public org.r3.db.system.user.userrole.UserRoleDataTableAdapter query(
      org.r3.db.system.user.userrole.UserRoleFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg, 
      String sEcho, 
      int iDisplayStart, 
      int iDisplayLength,
      boolean countElements)
  {  
    	int numberOfItems = (countElements) ? count(aFilterCondition, pcfg) : -1;    	
    	List<org.r3.db.system.user.userrole.UserRoleDTO> l = null;
    	if (numberOfItems != 0)
    	{
    	RowBounds rb = new RowBounds(
    					(iDisplayStart >= 0)  ? iDisplayStart : RowBounds.NO_ROW_OFFSET, 
    			    (iDisplayLength > 0) ? iDisplayLength : RowBounds.NO_ROW_LIMIT);
    	
		  l = select(aFilterCondition, pcfg, rb);
      }

		  org.r3.db.system.user.userrole.UserRoleDataTableAdapter dt = new org.r3.db.system.user.userrole.UserRoleDataTableAdapter();
		  dt.setsEcho(sEcho);
		  dt.setiTotalRecords(numberOfItems);
		  dt.setiTotalDisplayRecords(numberOfItems);
		  dt.setAaData(l);
		
		  return dt;
  }  
  
  public int delete(org.r3.db.system.user.userrole.UserRoleFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.delete(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public int insert(org.r3.db.system.user.userrole.UserRoleDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {

      int numberOfRowsAffected = this.mapper.insert(aRecord, pcfg);
      return numberOfRowsAffected;  
  }

  public int update(org.r3.db.system.user.userrole.UserRoleDTO aRecord, org.r3.db.system.user.userrole.UserRoleFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.update(aRecord, aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }
  
  public int updateByPrimaryKey(org.r3.db.system.user.userrole.UserRoleDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.updateByPrimaryKey(aRecord, pcfg);
      return numberOfRowsAffected;  
  }


}
  
