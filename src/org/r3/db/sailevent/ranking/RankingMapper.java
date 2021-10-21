//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.ranking;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface RankingMapper{
    
  org.r3.db.sailevent.ranking.RankingDTO  selectByEventidRankid(
             @Param("eventid") java.lang.String eventid, @Param("rankid") java.lang.String rankid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int deleteByEventidRankid(
             @Param("eventid") java.lang.String eventid, @Param("rankid") java.lang.String rankid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);            
  org.r3.db.sailevent.ranking.RankingDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.sailevent.ranking.RankingKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.sailevent.ranking.RankingKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.sailevent.ranking.RankingDTO> select(
            @Param("filter") org.r3.db.sailevent.ranking.RankingFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.sailevent.ranking.RankingFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.sailevent.ranking.RankingFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.sailevent.ranking.RankingDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.sailevent.ranking.RankingDTO aRecord, 
             @Param("filter") org.r3.db.sailevent.ranking.RankingFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.sailevent.ranking.RankingDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    


}
  
