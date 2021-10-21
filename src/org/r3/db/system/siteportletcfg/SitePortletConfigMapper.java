//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.siteportletcfg;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SitePortletConfigMapper{
    
  org.r3.db.system.siteportletcfg.SitePortletConfigDTO  selectBySitePageidPositionid(
             @Param("site") java.lang.String site, @Param("pageid") java.lang.String pageid, @Param("positionid") java.lang.String positionid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int deleteBySitePageidPositionid(
             @Param("site") java.lang.String site, @Param("pageid") java.lang.String pageid, @Param("positionid") java.lang.String positionid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);            
  org.r3.db.system.siteportletcfg.SitePortletConfigDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.system.siteportletcfg.SitePortletConfigKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.system.siteportletcfg.SitePortletConfigKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.system.siteportletcfg.SitePortletConfigDTO> select(
            @Param("filter") org.r3.db.system.siteportletcfg.SitePortletConfigFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.system.siteportletcfg.SitePortletConfigFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.system.siteportletcfg.SitePortletConfigFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.system.siteportletcfg.SitePortletConfigDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.system.siteportletcfg.SitePortletConfigDTO aRecord, 
             @Param("filter") org.r3.db.system.siteportletcfg.SitePortletConfigFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.system.siteportletcfg.SitePortletConfigDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    

  List<org.r3.db.system.siteportletcfg.SitePortletConfigLUTDTO> readLUT(
          @Param("filter") org.r3.db.system.siteportletcfg.SitePortletConfigFilter filterCondition, 
          @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
          RowBounds aRowBounds);
}
  
