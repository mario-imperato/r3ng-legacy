//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.classifier;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ClassifierMapper{
    
  org.r3.db.system.classifier.ClassifierDTO  selectBySiteClsid(
             @Param("site") java.lang.String site, @Param("clsid") java.lang.String clsid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int deleteBySiteClsid(
             @Param("site") java.lang.String site, @Param("clsid") java.lang.String clsid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);            
  org.r3.db.system.classifier.ClassifierDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.system.classifier.ClassifierKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.system.classifier.ClassifierKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.system.classifier.ClassifierDTO> select(
            @Param("filter") org.r3.db.system.classifier.ClassifierFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.system.classifier.ClassifierFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.system.classifier.ClassifierFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.system.classifier.ClassifierDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.system.classifier.ClassifierDTO aRecord, 
             @Param("filter") org.r3.db.system.classifier.ClassifierFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.system.classifier.ClassifierDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    


}
  
