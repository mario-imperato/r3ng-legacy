//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.siteresource;

public class SiteResourceKey
{
    protected java.lang.String  site;
    protected java.lang.String  resourceid;


    /**
      * DataBean constructor.
      */
    public SiteResourceKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public SiteResourceKey(SiteResourceKey another) 
    {    	
       site = another.getSite();
       resourceid = another.getResourceid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getSite()         { return site; }
    
    public void setSite(String  p)
    {
         site = p;
    }
    
    public java.lang.String   getResourceid()         { return resourceid; }
    
    public void setResourceid(String  p)
    {
         resourceid = p;
    }
}
