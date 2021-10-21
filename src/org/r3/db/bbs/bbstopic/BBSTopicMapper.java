//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.bbs.bbstopic;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BBSTopicMapper{
    
  org.r3.db.bbs.bbstopic.BBSTopicDTO  selectBySiteTopicid(
             @Param("site") java.lang.String site, @Param("topicid") java.lang.String topicid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int deleteBySiteTopicid(
             @Param("site") java.lang.String site, @Param("topicid") java.lang.String topicid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);            
  org.r3.db.bbs.bbstopic.BBSTopicDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.bbs.bbstopic.BBSTopicKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.bbs.bbstopic.BBSTopicKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.bbs.bbstopic.BBSTopicDTO> select(
            @Param("filter") org.r3.db.bbs.bbstopic.BBSTopicFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.bbs.bbstopic.BBSTopicFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.bbs.bbstopic.BBSTopicFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.bbs.bbstopic.BBSTopicDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.bbs.bbstopic.BBSTopicDTO aRecord, 
             @Param("filter") org.r3.db.bbs.bbstopic.BBSTopicFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.bbs.bbstopic.BBSTopicDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    


}
  
