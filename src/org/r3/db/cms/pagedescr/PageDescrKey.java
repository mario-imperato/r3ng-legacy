//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.pagedescr;

public class PageDescrKey
{
    protected java.lang.String  site;
    protected java.lang.String  pageid;
    protected java.lang.String  languagecode;


    /**
      * DataBean constructor.
      */
    public PageDescrKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public PageDescrKey(PageDescrKey another) 
    {    	
       site = another.getSite();
       pageid = another.getPageid();
       languagecode = another.getLanguagecode();
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
    
    public java.lang.String   getLanguagecode()         { return languagecode; }
    
    public void setLanguagecode(String  p)
    {
         languagecode = p;
    }
}
