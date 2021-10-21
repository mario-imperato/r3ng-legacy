//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// GPA Web Framework, Copyright 2004, 2005
//
//
// TODO: Readme Section.
//
package org.r3.db.system.sequence;


public interface SequenceMapper{
    
	org.r3.db.system.sequence.SequenceDTO  selectbySequencecode(java.lang.String sequencecode);
  int updateByPrimaryKey(org.r3.db.system.sequence.SequenceDTO aRecord);    

}
  
