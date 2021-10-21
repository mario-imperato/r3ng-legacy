//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.carddescr;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CardDescrMapper{
    
  org.r3.db.cms.carddescr.CardDescrDTO  selectBySiteCardidLanguagecode(
             @Param("site") java.lang.String site, @Param("cardid") java.lang.String cardid, @Param("languagecode") java.lang.String languagecode,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int deleteBySiteCardidLanguagecode(
             @Param("site") java.lang.String site, @Param("cardid") java.lang.String cardid, @Param("languagecode") java.lang.String languagecode,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);            
  org.r3.db.cms.carddescr.CardDescrDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.cms.carddescr.CardDescrKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.cms.carddescr.CardDescrKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.cms.carddescr.CardDescrDTO> select(
            @Param("filter") org.r3.db.cms.carddescr.CardDescrFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.cms.carddescr.CardDescrFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.cms.carddescr.CardDescrFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.cms.carddescr.CardDescrDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.cms.carddescr.CardDescrDTO aRecord, 
             @Param("filter") org.r3.db.cms.carddescr.CardDescrFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.cms.carddescr.CardDescrDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    


}
  
