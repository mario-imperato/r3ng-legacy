//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.file;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface DMSFileMapper{
    
  org.r3.db.dms.file.DMSFileDTO  selectByFileid(
            @Param("fileid")   java.lang.String fileid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
            
  int deleteByFileid(
            @Param("fileid")   java.lang.String fileid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
  org.r3.db.dms.file.DMSFileDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.dms.file.DMSFileKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.dms.file.DMSFileKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.dms.file.DMSFileDTO> select(
            @Param("filter") org.r3.db.dms.file.DMSFileFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.dms.file.DMSFileFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.dms.file.DMSFileFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.dms.file.DMSFileDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.dms.file.DMSFileDTO aRecord, 
             @Param("filter") org.r3.db.dms.file.DMSFileFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.dms.file.DMSFileDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    

  byte[] selectFilebodyByPrimaryKey(
         @Param("pk")    org.r3.db.dms.file.DMSFileKey aPk, 
         @Param("pcfg")  org.r3.db.PersistenceConfigInfo pcfg);    
  byte[] selectFilebodyByFileid(
         @Param("fileid") java.lang.String fileid,
         @Param("pcfg")  org.r3.db.PersistenceConfigInfo pcfg);   
  int storeFilebodyByFileid(
         @Param("filebody") byte[] filebody,
         @Param("fileid") java.lang.String fileid,
         @Param("pcfg")  org.r3.db.PersistenceConfigInfo pcfg);   

}
  
