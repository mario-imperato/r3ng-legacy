//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.siteresource;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SiteResourceMapper{
    
  org.r3.db.project.siteresource.SiteResourceDTO  selectBySiteResourceid(
             @Param("site") java.lang.String site, @Param("resourceid") java.lang.String resourceid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int deleteBySiteResourceid(
             @Param("site") java.lang.String site, @Param("resourceid") java.lang.String resourceid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);            
  org.r3.db.project.siteresource.SiteResourceDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.project.siteresource.SiteResourceKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.project.siteresource.SiteResourceKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.project.siteresource.SiteResourceDTO> select(
            @Param("filter") org.r3.db.project.siteresource.SiteResourceFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.project.siteresource.SiteResourceFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.project.siteresource.SiteResourceFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.project.siteresource.SiteResourceDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.project.siteresource.SiteResourceDTO aRecord, 
             @Param("filter") org.r3.db.project.siteresource.SiteResourceFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.project.siteresource.SiteResourceDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    


}
  
