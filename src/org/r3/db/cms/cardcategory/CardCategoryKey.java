//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.cardcategory;

public class CardCategoryKey
{
    protected java.lang.String  site;
    protected java.lang.String  cardid;
    protected java.lang.String  categoryid;


    /**
      * DataBean constructor.
      */
    public CardCategoryKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public CardCategoryKey(CardCategoryKey another) 
    {    	
       site = another.getSite();
       cardid = another.getCardid();
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
    
    public java.lang.String   getCardid()         { return cardid; }
    
    public void setCardid(String  p)
    {
         cardid = p;
    }
    
    public java.lang.String   getCategoryid()         { return categoryid; }
    
    public void setCategoryid(String  p)
    {
         categoryid = p;
    }
}
