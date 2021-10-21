//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// GPA Web Framework, Copyright 2004, 2005
//
//
// TODO: Readme Section.
//

package org.r3.db.system.sequence;

public class SequenceKey
{
    protected java.lang.String  sequencecode;


    /**
      * DataBean constructor.
      */
    public SequenceKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public SequenceKey(SequenceKey another) 
    {    	
       sequencecode = another.getSequencecode();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getSequencecode()         { return sequencecode; }
    
    public void setSequencecode(String  p)
    {
         sequencecode = p;
    }
}
