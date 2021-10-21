//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.rankinginstanceview;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface RankingInstanceViewMapper{    
  List<org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewDTO> select(
            @Param("filter") org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
}
  
