//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.cardgroup;

public class CardGroupKey
{
    protected java.lang.String  site;
    protected java.lang.String  cardid;
    protected java.lang.String  groupid;


    /**
      * DataBean constructor.
      */
    public CardGroupKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public CardGroupKey(CardGroupKey another) 
    {    	
       site = another.getSite();
       cardid = another.getCardid();
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
    
    public java.lang.String   getCardid()         { return cardid; }
    
    public void setCardid(String  p)
    {
         cardid = p;
    }
    
    public java.lang.String   getGroupid()         { return groupid; }
    
    public void setGroupid(String  p)
    {
         groupid = p;
    }
}
