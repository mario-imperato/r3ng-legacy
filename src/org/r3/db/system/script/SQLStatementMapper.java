//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.script;

import org.apache.ibatis.annotations.Param;

public interface SQLStatementMapper
{              
  int delete(@Param("statement") String aStatement);
             
  int insert(@Param("statement") String aStatement);
               
  int update(@Param("statement") String aStatement);             
}
  
