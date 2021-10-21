//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.bbs.bbsthreadnodeview;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BBSThreadNodeViewMapper{    
  List<org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewDTO> select(
            @Param("filter") org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
}
  
