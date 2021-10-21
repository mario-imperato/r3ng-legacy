//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.homeentrylist;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SailHomeEntryListMapper{    
  List<org.r3.db.sailevent.homeentrylist.SailHomeEntryListDTO> select(
            @Param("filter") org.r3.db.sailevent.homeentrylist.SailHomeEntryListFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.sailevent.homeentrylist.SailHomeEntryListFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
}
  
