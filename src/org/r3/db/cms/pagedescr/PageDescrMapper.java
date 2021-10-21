//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.pagedescr;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PageDescrMapper{
    
  org.r3.db.cms.pagedescr.PageDescrDTO  selectBySitePageidLanguagecode(
             @Param("site") java.lang.String site, @Param("pageid") java.lang.String pageid, @Param("languagecode") java.lang.String languagecode,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int deleteBySitePageidLanguagecode(
             @Param("site") java.lang.String site, @Param("pageid") java.lang.String pageid, @Param("languagecode") java.lang.String languagecode,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);            
  org.r3.db.cms.pagedescr.PageDescrDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.cms.pagedescr.PageDescrKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.cms.pagedescr.PageDescrKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.cms.pagedescr.PageDescrDTO> select(
            @Param("filter") org.r3.db.cms.pagedescr.PageDescrFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.cms.pagedescr.PageDescrFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.cms.pagedescr.PageDescrFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.cms.pagedescr.PageDescrDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.cms.pagedescr.PageDescrDTO aRecord, 
             @Param("filter") org.r3.db.cms.pagedescr.PageDescrFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.cms.pagedescr.PageDescrDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    


}
  
