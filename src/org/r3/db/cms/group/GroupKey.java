//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.group;

public class GroupKey
{
    protected java.lang.String  site;
    protected java.lang.String  groupid;


    /**
      * DataBean constructor.
      */
    public GroupKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public GroupKey(GroupKey another) 
    {    	
       site = another.getSite();
       groupid = another.getGroupid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getSite()         { return site; }
    
    public void setSite(String  p)
    {
         site = p;
    }
    
    public java.lang.String   getGroupid()         { return groupid; }
    
    public void setGroupid(String  p)
    {
         groupid = p;
    }
}
