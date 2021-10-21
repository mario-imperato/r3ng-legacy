//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.siteportletcfg;

public class SitePortletConfigKey
{
    protected java.lang.String  site;
    protected java.lang.String  pageid;
    protected java.lang.String  positionid;


    /**
      * DataBean constructor.
      */
    public SitePortletConfigKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public SitePortletConfigKey(SitePortletConfigKey another) 
    {    	
       site = another.getSite();
       pageid = another.getPageid();
       positionid = another.getPositionid();
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
    
    public java.lang.String   getPositionid()         { return positionid; }
    
    public void setPositionid(String  p)
    {
         positionid = p;
    }
}
