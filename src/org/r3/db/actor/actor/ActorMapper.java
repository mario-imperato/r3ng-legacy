//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.actor.actor;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ActorMapper{
    
  org.r3.db.actor.actor.ActorDTO  selectByEventidActorid(
             @Param("eventid") java.lang.String eventid, @Param("actorid") java.lang.String actorid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int deleteByEventidActorid(
             @Param("eventid") java.lang.String eventid, @Param("actorid") java.lang.String actorid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);            
  org.r3.db.actor.actor.ActorDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.actor.actor.ActorKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.actor.actor.ActorKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.actor.actor.ActorDTO> select(
            @Param("filter") org.r3.db.actor.actor.ActorFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.actor.actor.ActorFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.actor.actor.ActorFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.actor.actor.ActorDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.actor.actor.ActorDTO aRecord, 
             @Param("filter") org.r3.db.actor.actor.ActorFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.actor.actor.ActorDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    
  
  int insertActorsIntoSMS(@Param("site") String aSite, @Param("smsid")  String aSmsid, @Param("filter") org.r3.db.actor.actor.ActorFilter aFilterCondition, @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);

  int insertActorsIntoOutMailSpoolerRecipient(@Param("site") String aSite, @Param("messageid")  String aMessageid, @Param("filter") org.r3.db.actor.actor.ActorFilter aFilterCondition, @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);

}
  
