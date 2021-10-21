//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.category;

public class CategoryKey
{
    protected java.lang.String  site;
    protected java.lang.String  categoryid;


    /**
      * DataBean constructor.
      */
    public CategoryKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public CategoryKey(CategoryKey another) 
    {    	
       site = another.getSite();
       categoryid = another.getCategoryid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getSite()         { return site; }
    
    public void setSite(String  p)
    {
         site = p;
    }
    
    public java.lang.String   getCategoryid()         { return categoryid; }
    
    public void setCategoryid(String  p)
    {
         categoryid = p;
    }
}
