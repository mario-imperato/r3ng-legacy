//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.cardgroup;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CardGroupMapper{
    
  org.r3.db.cms.cardgroup.CardGroupDTO  selectBySiteCardidGroupid(
             @Param("site") java.lang.String site, @Param("cardid") java.lang.String cardid, @Param("groupid") java.lang.String groupid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int deleteBySiteCardidGroupid(
             @Param("site") java.lang.String site, @Param("cardid") java.lang.String cardid, @Param("groupid") java.lang.String groupid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);            
  org.r3.db.cms.cardgroup.CardGroupDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.cms.cardgroup.CardGroupKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.cms.cardgroup.CardGroupKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.cms.cardgroup.CardGroupDTO> select(
            @Param("filter") org.r3.db.cms.cardgroup.CardGroupFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.cms.cardgroup.CardGroupFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.cms.cardgroup.CardGroupFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.cms.cardgroup.CardGroupDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.cms.cardgroup.CardGroupDTO aRecord, 
             @Param("filter") org.r3.db.cms.cardgroup.CardGroupFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.cms.cardgroup.CardGroupDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    


}
  
