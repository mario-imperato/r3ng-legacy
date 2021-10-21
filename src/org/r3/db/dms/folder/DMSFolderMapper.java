//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.folder;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface DMSFolderMapper{
    
  org.r3.db.dms.folder.DMSFolderDTO  selectByFolderid(
            @Param("folderid")   java.lang.String folderid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
            
  int deleteByFolderid(
            @Param("folderid")   java.lang.String folderid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
  org.r3.db.dms.folder.DMSFolderDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.dms.folder.DMSFolderKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.dms.folder.DMSFolderKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.dms.folder.DMSFolderDTO> select(
            @Param("filter") org.r3.db.dms.folder.DMSFolderFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.dms.folder.DMSFolderFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.dms.folder.DMSFolderFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.dms.folder.DMSFolderDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.dms.folder.DMSFolderDTO aRecord, 
             @Param("filter") org.r3.db.dms.folder.DMSFolderFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.dms.folder.DMSFolderDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    


}
  
