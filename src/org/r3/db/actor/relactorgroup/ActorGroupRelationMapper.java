//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.actor.relactorgroup;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ActorGroupRelationMapper{
    
  org.r3.db.actor.relactorgroup.ActorGroupRelationDTO  selectByEventidGroupidActorid(
             @Param("eventid") java.lang.String eventid, @Param("groupid") java.lang.String groupid, @Param("actorid") java.lang.String actorid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int deleteByEventidGroupidActorid(
             @Param("eventid") java.lang.String eventid, @Param("groupid") java.lang.String groupid, @Param("actorid") java.lang.String actorid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);            
  org.r3.db.actor.relactorgroup.ActorGroupRelationDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.actor.relactorgroup.ActorGroupRelationKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.actor.relactorgroup.ActorGroupRelationKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.actor.relactorgroup.ActorGroupRelationDTO> select(
            @Param("filter") org.r3.db.actor.relactorgroup.ActorGroupRelationFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.actor.relactorgroup.ActorGroupRelationFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.actor.relactorgroup.ActorGroupRelationFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.actor.relactorgroup.ActorGroupRelationDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.actor.relactorgroup.ActorGroupRelationDTO aRecord, 
             @Param("filter") org.r3.db.actor.relactorgroup.ActorGroupRelationFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.actor.relactorgroup.ActorGroupRelationDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    

  int insertAllActorsIntoGroup(
	@Param("eventid") java.lang.String eventid, @Param("groupid") java.lang.String groupid, @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
  
  int insertActorsIntoGroupFromGroup( 
	@Param("eventid") java.lang.String eventid, @Param("groupid") java.lang.String groupid, @Param("fromGroupid") java.lang.String fromGroupId, @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
    
}
  
