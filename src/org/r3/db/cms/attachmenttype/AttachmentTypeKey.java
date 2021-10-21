//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.attachmenttype;

public class AttachmentTypeKey
{
    protected java.lang.String  site;
    protected java.lang.String  attachtypeid;


    /**
      * DataBean constructor.
      */
    public AttachmentTypeKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public AttachmentTypeKey(AttachmentTypeKey another) 
    {    	
       site = another.getSite();
       attachtypeid = another.getAttachtypeid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getSite()         { return site; }
    
    public void setSite(String  p)
    {
         site = p;
    }
    
    public java.lang.String   getAttachtypeid()         { return attachtypeid; }
    
    public void setAttachtypeid(String  p)
    {
         attachtypeid = p;
    }
}
