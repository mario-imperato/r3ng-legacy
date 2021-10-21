//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.file;

public class DMSFileKey
{
    protected java.lang.String  fileid;


    /**
      * DataBean constructor.
      */
    public DMSFileKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public DMSFileKey(DMSFileKey another) 
    {    	
       fileid = another.getFileid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getFileid()         { return fileid; }
    
    public void setFileid(String  p)
    {
         fileid = p;
    }
}
