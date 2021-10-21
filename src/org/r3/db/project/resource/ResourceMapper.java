//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.resource;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ResourceMapper{
    
  org.r3.db.project.resource.ResourceDTO  selectByResourceid(
            @Param("resourceid")   java.lang.String resourceid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
            
  int deleteByResourceid(
            @Param("resourceid")   java.lang.String resourceid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
  org.r3.db.project.resource.ResourceDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.project.resource.ResourceKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.project.resource.ResourceKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.project.resource.ResourceDTO> select(
            @Param("filter") org.r3.db.project.resource.ResourceFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.project.resource.ResourceFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.project.resource.ResourceFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.project.resource.ResourceDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.project.resource.ResourceDTO aRecord, 
             @Param("filter") org.r3.db.project.resource.ResourceFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.project.resource.ResourceDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    


}
  
