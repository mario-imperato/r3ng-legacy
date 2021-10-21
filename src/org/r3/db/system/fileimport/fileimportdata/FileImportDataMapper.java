//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.fileimport.fileimportdata;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface FileImportDataMapper{
    
  org.r3.db.system.fileimport.fileimportdata.FileImportDataDTO  selectByImportdataid(
            @Param("importdataid")   java.lang.Integer importdataid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
            
  int deleteByImportdataid(
            @Param("importdataid")   java.lang.Integer importdataid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
  org.r3.db.system.fileimport.fileimportdata.FileImportDataDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.system.fileimport.fileimportdata.FileImportDataKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.system.fileimport.fileimportdata.FileImportDataKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.system.fileimport.fileimportdata.FileImportDataDTO> select(
            @Param("filter") org.r3.db.system.fileimport.fileimportdata.FileImportDataFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.system.fileimport.fileimportdata.FileImportDataFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.system.fileimport.fileimportdata.FileImportDataFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.system.fileimport.fileimportdata.FileImportDataDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.system.fileimport.fileimportdata.FileImportDataDTO aRecord, 
             @Param("filter") org.r3.db.system.fileimport.fileimportdata.FileImportDataFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.system.fileimport.fileimportdata.FileImportDataDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    


}
  
