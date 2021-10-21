//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.bbs.bbsthread;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BBSThreadMapper{
    
  org.r3.db.bbs.bbsthread.BBSThreadDTO  selectBySiteThreadid(
             @Param("site") java.lang.String site, @Param("threadid") java.lang.String threadid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int deleteBySiteThreadid(
             @Param("site") java.lang.String site, @Param("threadid") java.lang.String threadid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);            
  org.r3.db.bbs.bbsthread.BBSThreadDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.bbs.bbsthread.BBSThreadKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.bbs.bbsthread.BBSThreadKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.bbs.bbsthread.BBSThreadDTO> select(
            @Param("filter") org.r3.db.bbs.bbsthread.BBSThreadFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.bbs.bbsthread.BBSThreadFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.bbs.bbsthread.BBSThreadFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.bbs.bbsthread.BBSThreadDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.bbs.bbsthread.BBSThreadDTO aRecord, 
             @Param("filter") org.r3.db.bbs.bbsthread.BBSThreadFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.bbs.bbsthread.BBSThreadDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    

  int updatePostCountersOnAddBySiteThreadid(		  
	         @Param("site") java.lang.String site, @Param("threadid") java.lang.String threadid,
	         @Param("lastthreadnodeid") java.lang.String lastthreadnodeid,
	         @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);  
	  
	  int updatePostCountersOnDeleteBySiteThreadid(
	         @Param("site") java.lang.String site, @Param("threadid") java.lang.String threadid,
	         @Param("numposts") java.lang.Integer numPosts,
	         @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);  


}
  
