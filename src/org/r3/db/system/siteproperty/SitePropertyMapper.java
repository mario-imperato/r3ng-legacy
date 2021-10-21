//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.siteproperty;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SitePropertyMapper{
    
  org.r3.db.system.siteproperty.SitePropertyDTO  selectBySitePropertyscopePropertykey(
             @Param("site") java.lang.String site, @Param("propertyscope") java.lang.String propertyscope, @Param("propertykey") java.lang.String propertykey,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int deleteBySitePropertyscopePropertykey(
             @Param("site") java.lang.String site, @Param("propertyscope") java.lang.String propertyscope, @Param("propertykey") java.lang.String propertykey,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);            
  org.r3.db.system.siteproperty.SitePropertyDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.system.siteproperty.SitePropertyKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.system.siteproperty.SitePropertyKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.system.siteproperty.SitePropertyDTO> select(
            @Param("filter") org.r3.db.system.siteproperty.SitePropertyFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.system.siteproperty.SitePropertyFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.system.siteproperty.SitePropertyFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.system.siteproperty.SitePropertyDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.system.siteproperty.SitePropertyDTO aRecord, 
             @Param("filter") org.r3.db.system.siteproperty.SitePropertyFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.system.siteproperty.SitePropertyDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    

  List<org.r3.db.system.siteproperty.SitePropertyDTO> selectCascade(
          @Param("siteDomain") String aSiteDomain,
		  @Param("site") String aSite,          
          @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg
          );
}
  
