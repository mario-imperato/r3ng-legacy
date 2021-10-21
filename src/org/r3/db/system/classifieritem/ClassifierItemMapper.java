//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.classifieritem;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ClassifierItemMapper{
    
  org.r3.db.system.classifieritem.ClassifierItemDTO  selectByClsitemid(
            @Param("clsitemid")   java.lang.String clsitemid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
            
  int deleteByClsitemid(
            @Param("clsitemid")   java.lang.String clsitemid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
  org.r3.db.system.classifieritem.ClassifierItemDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.system.classifieritem.ClassifierItemKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.system.classifieritem.ClassifierItemKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.system.classifieritem.ClassifierItemDTO> select(
            @Param("filter") org.r3.db.system.classifieritem.ClassifierItemFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.system.classifieritem.ClassifierItemFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.system.classifieritem.ClassifierItemFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.system.classifieritem.ClassifierItemDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.system.classifieritem.ClassifierItemDTO aRecord, 
             @Param("filter") org.r3.db.system.classifieritem.ClassifierItemFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.system.classifieritem.ClassifierItemDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    

  List<org.r3.db.system.classifieritem.ClassifierItemDTO> select_WNOC(
          @Param("filter") org.r3.db.system.classifieritem.ClassifierItemFilter filterCondition, 
          @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
          RowBounds aRowBounds);
}
  
