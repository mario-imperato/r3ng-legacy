//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.openregattas.openregattasview;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface OpenRegattasViewMapper{    
  List<org.r3.db.sailevent.openregattas.openregattasview.OpenRegattasViewDTO> select(
            @Param("filter") org.r3.db.sailevent.openregattas.openregattasview.OpenRegattasViewFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.sailevent.openregattas.openregattasview.OpenRegattasViewFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
}
  
