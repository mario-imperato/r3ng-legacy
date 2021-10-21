//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.user.userrole;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserRoleMapper{
    
  org.r3.db.system.user.userrole.UserRoleDTO  selectBySiteUseridRoleid(
             @Param("site") java.lang.String site, @Param("userid") java.lang.String userid, @Param("roleid") java.lang.String roleid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int deleteBySiteUseridRoleid(
             @Param("site") java.lang.String site, @Param("userid") java.lang.String userid, @Param("roleid") java.lang.String roleid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);            
  org.r3.db.system.user.userrole.UserRoleDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.system.user.userrole.UserRoleKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.system.user.userrole.UserRoleKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.system.user.userrole.UserRoleDTO> select(
            @Param("filter") org.r3.db.system.user.userrole.UserRoleFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.system.user.userrole.UserRoleFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.system.user.userrole.UserRoleFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.system.user.userrole.UserRoleDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.system.user.userrole.UserRoleDTO aRecord, 
             @Param("filter") org.r3.db.system.user.userrole.UserRoleFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.system.user.userrole.UserRoleDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    


}
  
