//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.resource;

public class ResourceKey
{
    protected java.lang.String  resourceid;


    /**
      * DataBean constructor.
      */
    public ResourceKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public ResourceKey(ResourceKey another) 
    {    	
       resourceid = another.getResourceid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getResourceid()         { return resourceid; }
    
    public void setResourceid(String  p)
    {
         resourceid = p;
    }
}
