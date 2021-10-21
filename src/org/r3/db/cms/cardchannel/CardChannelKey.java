//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.cardchannel;

public class CardChannelKey
{
    protected java.lang.String  channelid;
    protected java.lang.String  site;
    protected java.lang.String  cardid;


    /**
      * DataBean constructor.
      */
    public CardChannelKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public CardChannelKey(CardChannelKey another) 
    {    	
       channelid = another.getChannelid();
       site = another.getSite();
       cardid = another.getCardid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getChannelid()         { return channelid; }
    
    public void setChannelid(String  p)
    {
         channelid = p;
    }
    
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
}
