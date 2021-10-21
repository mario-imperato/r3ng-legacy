//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.siteproperty;

public class SitePropertyKey
{
    protected java.lang.String  site;
    protected java.lang.String  propertyscope;
    protected java.lang.String  propertykey;


    /**
      * DataBean constructor.
      */
    public SitePropertyKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public SitePropertyKey(SitePropertyKey another) 
    {    	
       site = another.getSite();
       propertyscope = another.getPropertyscope();
       propertykey = another.getPropertykey();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getSite()         { return site; }
    
    public void setSite(String  p)
    {
         site = p;
    }
    
    public java.lang.String   getPropertyscope()         { return propertyscope; }
    
    public void setPropertyscope(String  p)
    {
         propertyscope = p;
    }
    
    public java.lang.String   getPropertykey()         { return propertykey; }
    
    public void setPropertykey(String  p)
    {
         propertykey = p;
    }
}
