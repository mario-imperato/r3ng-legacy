//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.appdata;

public class SailApplicationDataKey
{
    protected java.lang.String  eventid;
    protected java.lang.String  applicationid;
    protected java.lang.String  sectionid;
    protected java.lang.String  paramname;


    /**
      * DataBean constructor.
      */
    public SailApplicationDataKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public SailApplicationDataKey(SailApplicationDataKey another) 
    {    	
       eventid = another.getEventid();
       applicationid = another.getApplicationid();
       sectionid = another.getSectionid();
       paramname = another.getParamname();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getEventid()         { return eventid; }
    
    public void setEventid(String  p)
    {
         eventid = p;
    }
    
    public java.lang.String   getApplicationid()         { return applicationid; }
    
    public void setApplicationid(String  p)
    {
         applicationid = p;
    }
    
    public java.lang.String   getSectionid()         { return sectionid; }
    
    public void setSectionid(String  p)
    {
         sectionid = p;
    }
    
    public java.lang.String   getParamname()         { return paramname; }
    
    public void setParamname(String  p)
    {
         paramname = p;
    }
}
