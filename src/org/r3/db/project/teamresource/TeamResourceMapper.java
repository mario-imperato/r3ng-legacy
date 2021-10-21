//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.teamresource;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TeamResourceMapper{
    
  org.r3.db.project.teamresource.TeamResourceDTO  selectBySiteTeamidResourceid(
             @Param("site") java.lang.String site, @Param("teamid") java.lang.String teamid, @Param("resourceid") java.lang.String resourceid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int deleteBySiteTeamidResourceid(
             @Param("site") java.lang.String site, @Param("teamid") java.lang.String teamid, @Param("resourceid") java.lang.String resourceid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);            
  org.r3.db.project.teamresource.TeamResourceDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.project.teamresource.TeamResourceKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.project.teamresource.TeamResourceKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.project.teamresource.TeamResourceDTO> select(
            @Param("filter") org.r3.db.project.teamresource.TeamResourceFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.project.teamresource.TeamResourceFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.project.teamresource.TeamResourceFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.project.teamresource.TeamResourceDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.project.teamresource.TeamResourceDTO aRecord, 
             @Param("filter") org.r3.db.project.teamresource.TeamResourceFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.project.teamresource.TeamResourceDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    


}
  
