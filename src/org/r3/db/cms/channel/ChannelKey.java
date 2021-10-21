//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.channel;

public class ChannelKey
{
    protected java.lang.String  channelid;


    /**
      * DataBean constructor.
      */
    public ChannelKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public ChannelKey(ChannelKey another) 
    {    	
       channelid = another.getChannelid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getChannelid()         { return channelid; }
    
    public void setChannelid(String  p)
    {
         channelid = p;
    }
}
