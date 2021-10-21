//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.rankinginstance;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface RankingInstanceMapper{
    
  org.r3.db.sailevent.rankinginstance.RankingInstanceDTO  selectByEventidInstanceid(
             @Param("eventid") java.lang.String eventid, @Param("instanceid") java.lang.String instanceid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int deleteByEventidInstanceid(
             @Param("eventid") java.lang.String eventid, @Param("instanceid") java.lang.String instanceid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);            
  org.r3.db.sailevent.rankinginstance.RankingInstanceDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.sailevent.rankinginstance.RankingInstanceKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.sailevent.rankinginstance.RankingInstanceKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.sailevent.rankinginstance.RankingInstanceDTO> select(
            @Param("filter") org.r3.db.sailevent.rankinginstance.RankingInstanceFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.sailevent.rankinginstance.RankingInstanceFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.sailevent.rankinginstance.RankingInstanceFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.sailevent.rankinginstance.RankingInstanceDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.sailevent.rankinginstance.RankingInstanceDTO aRecord, 
             @Param("filter") org.r3.db.sailevent.rankinginstance.RankingInstanceFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.sailevent.rankinginstance.RankingInstanceDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    


}
  
