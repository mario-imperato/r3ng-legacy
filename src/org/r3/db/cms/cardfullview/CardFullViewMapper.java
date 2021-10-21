//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.cardfullview;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CardFullViewMapper{    
  List<org.r3.db.cms.cardfullview.CardFullViewDTO> select(
            @Param("filter") org.r3.db.cms.cardfullview.CardFullViewFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.cms.cardfullview.CardFullViewFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  // Partial
  List<org.r3.db.cms.cardfullview.CardFullViewDTO> selectPartial(
		            @Param("filter") org.r3.db.cms.cardfullview.CardFullViewFilter filterCondition, 
		            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
		            RowBounds aRowBounds);
		            
  int countPartial(@Param("filter") org.r3.db.cms.cardfullview.CardFullViewFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  // Channel  
  List<org.r3.db.cms.cardfullview.CardFullViewDTO> selectChannel(
            @Param("filter") org.r3.db.cms.cardfullview.CardFullViewFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int countChannel(@Param("filter") org.r3.db.cms.cardfullview.CardFullViewFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

}
  
