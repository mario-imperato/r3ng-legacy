//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.carddescr;

public class CardDescrKey
{
    protected java.lang.String  site;
    protected java.lang.String  cardid;
    protected java.lang.String  languagecode;


    /**
      * DataBean constructor.
      */
    public CardDescrKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public CardDescrKey(CardDescrKey another) 
    {    	
       site = another.getSite();
       cardid = another.getCardid();
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
    
    public java.lang.String   getCardid()         { return cardid; }
    
    public void setCardid(String  p)
    {
         cardid = p;
    }
    
    public java.lang.String   getLanguagecode()         { return languagecode; }
    
    public void setLanguagecode(String  p)
    {
         languagecode = p;
    }
}
