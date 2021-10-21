//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.fileproperty;

public class DMSFilePropertyKey
{
    protected java.lang.String  fileid;
    protected java.lang.String  propertyname;


    /**
      * DataBean constructor.
      */
    public DMSFilePropertyKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public DMSFilePropertyKey(DMSFilePropertyKey another) 
    {    	
       fileid = another.getFileid();
       propertyname = another.getPropertyname();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getFileid()         { return fileid; }
    
    public void setFileid(String  p)
    {
         fileid = p;
    }
    
    public java.lang.String   getPropertyname()         { return propertyname; }
    
    public void setPropertyname(String  p)
    {
         propertyname = p;
    }
}
