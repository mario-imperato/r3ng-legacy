//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.wbs.wbsactor;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface WBSActorMapper{
    
  org.r3.db.wbs.wbsactor.WBSActorDTO  selectByWbsactorid(
            @Param("wbsactorid")   java.lang.String wbsactorid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
            
  int deleteByWbsactorid(
            @Param("wbsactorid")   java.lang.String wbsactorid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
  org.r3.db.wbs.wbsactor.WBSActorDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.wbs.wbsactor.WBSActorKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.wbs.wbsactor.WBSActorKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.wbs.wbsactor.WBSActorDTO> select(
            @Param("filter") org.r3.db.wbs.wbsactor.WBSActorFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.wbs.wbsactor.WBSActorFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.wbs.wbsactor.WBSActorFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.wbs.wbsactor.WBSActorDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.wbs.wbsactor.WBSActorDTO aRecord, 
             @Param("filter") org.r3.db.wbs.wbsactor.WBSActorFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.wbs.wbsactor.WBSActorDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    
   

}
  
