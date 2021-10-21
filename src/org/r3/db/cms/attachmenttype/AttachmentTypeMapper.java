//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.attachmenttype;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AttachmentTypeMapper{
    
  org.r3.db.cms.attachmenttype.AttachmentTypeDTO  selectBySiteAttachtypeid(
             @Param("site") java.lang.String site, @Param("attachtypeid") java.lang.String attachtypeid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int deleteBySiteAttachtypeid(
             @Param("site") java.lang.String site, @Param("attachtypeid") java.lang.String attachtypeid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);            
  org.r3.db.cms.attachmenttype.AttachmentTypeDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.cms.attachmenttype.AttachmentTypeKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.cms.attachmenttype.AttachmentTypeKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.cms.attachmenttype.AttachmentTypeDTO> select(
            @Param("filter") org.r3.db.cms.attachmenttype.AttachmentTypeFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.cms.attachmenttype.AttachmentTypeFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.cms.attachmenttype.AttachmentTypeFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.cms.attachmenttype.AttachmentTypeDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.cms.attachmenttype.AttachmentTypeDTO aRecord, 
             @Param("filter") org.r3.db.cms.attachmenttype.AttachmentTypeFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.cms.attachmenttype.AttachmentTypeDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    


}
  
