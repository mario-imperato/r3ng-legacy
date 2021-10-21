//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.lut;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LUTDictionaryMapper{
    
  org.r3.db.system.lut.LUTDictionaryDTO  selectByLutid(
            @Param("lutid")   java.lang.String lutid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
            
  int deleteByLutid(
            @Param("lutid")   java.lang.String lutid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
  org.r3.db.system.lut.LUTDictionaryDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.system.lut.LUTDictionaryKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.system.lut.LUTDictionaryKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.system.lut.LUTDictionaryDTO> select(
            @Param("filter") org.r3.db.system.lut.LUTDictionaryFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.system.lut.LUTDictionaryFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.system.lut.LUTDictionaryFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.system.lut.LUTDictionaryDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.system.lut.LUTDictionaryDTO aRecord, 
             @Param("filter") org.r3.db.system.lut.LUTDictionaryFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.system.lut.LUTDictionaryDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    

  int invalidate(
		            @Param("filter") org.r3.db.system.lut.LUTDictionaryFilter filterCondition, 
		            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  int invalidateByLutid(
		            @Param("lutid")   java.lang.String lutid,
		            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);  
}
  
