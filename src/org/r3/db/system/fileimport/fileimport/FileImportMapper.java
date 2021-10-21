//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.fileimport.fileimport;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface FileImportMapper{
    
  org.r3.db.system.fileimport.fileimport.FileImportDTO  selectBySiteImportid(
             @Param("site") java.lang.String site, @Param("importid") java.lang.String importid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int deleteBySiteImportid(
             @Param("site") java.lang.String site, @Param("importid") java.lang.String importid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);            
  org.r3.db.system.fileimport.fileimport.FileImportDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.system.fileimport.fileimport.FileImportKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.system.fileimport.fileimport.FileImportKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.system.fileimport.fileimport.FileImportDTO> select(
            @Param("filter") org.r3.db.system.fileimport.fileimport.FileImportFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.system.fileimport.fileimport.FileImportFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.system.fileimport.fileimport.FileImportFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.system.fileimport.fileimport.FileImportDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.system.fileimport.fileimport.FileImportDTO aRecord, 
             @Param("filter") org.r3.db.system.fileimport.fileimport.FileImportFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.system.fileimport.fileimport.FileImportDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    


}
  
