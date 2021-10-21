//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.cardcategory;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CardCategoryMapper{
    
  org.r3.db.cms.cardcategory.CardCategoryDTO  selectBySiteCardidCategoryid(
             @Param("site") java.lang.String site, @Param("cardid") java.lang.String cardid, @Param("categoryid") java.lang.String categoryid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int deleteBySiteCardidCategoryid(
             @Param("site") java.lang.String site, @Param("cardid") java.lang.String cardid, @Param("categoryid") java.lang.String categoryid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);            
  org.r3.db.cms.cardcategory.CardCategoryDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.cms.cardcategory.CardCategoryKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.cms.cardcategory.CardCategoryKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.cms.cardcategory.CardCategoryDTO> select(
            @Param("filter") org.r3.db.cms.cardcategory.CardCategoryFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.cms.cardcategory.CardCategoryFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.cms.cardcategory.CardCategoryFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.cms.cardcategory.CardCategoryDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.cms.cardcategory.CardCategoryDTO aRecord, 
             @Param("filter") org.r3.db.cms.cardcategory.CardCategoryFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.cms.cardcategory.CardCategoryDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    


}
  
