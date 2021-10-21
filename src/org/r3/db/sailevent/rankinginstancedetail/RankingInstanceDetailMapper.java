//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.rankinginstancedetail;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface RankingInstanceDetailMapper{
    
  org.r3.db.sailevent.rankinginstancedetail.RankingInstanceDetailDTO  selectByRankentryid(
            @Param("rankentryid")   java.lang.Integer rankentryid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
            
  int deleteByRankentryid(
            @Param("rankentryid")   java.lang.Integer rankentryid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
  org.r3.db.sailevent.rankinginstancedetail.RankingInstanceDetailDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.sailevent.rankinginstancedetail.RankingInstanceDetailKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.sailevent.rankinginstancedetail.RankingInstanceDetailKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.sailevent.rankinginstancedetail.RankingInstanceDetailDTO> select(
            @Param("filter") org.r3.db.sailevent.rankinginstancedetail.RankingInstanceDetailFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.sailevent.rankinginstancedetail.RankingInstanceDetailFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.sailevent.rankinginstancedetail.RankingInstanceDetailFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.sailevent.rankinginstancedetail.RankingInstanceDetailDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.sailevent.rankinginstancedetail.RankingInstanceDetailDTO aRecord, 
             @Param("filter") org.r3.db.sailevent.rankinginstancedetail.RankingInstanceDetailFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.sailevent.rankinginstancedetail.RankingInstanceDetailDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    


}
  
