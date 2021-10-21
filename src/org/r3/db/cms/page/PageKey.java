//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.page;

public class PageKey
{
    protected java.lang.String  site;
    protected java.lang.String  pageid;


    /**
      * DataBean constructor.
      */
    public PageKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public PageKey(PageKey another) 
    {    	
       site = another.getSite();
       pageid = another.getPageid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getSite()         { return site; }
    
    public void setSite(String  p)
    {
         site = p;
    }
    
    public java.lang.String   getPageid()         { return pageid; }
    
    public void setPageid(String  p)
    {
         pageid = p;
    }
}
