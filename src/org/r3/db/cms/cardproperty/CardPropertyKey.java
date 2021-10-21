//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.cardproperty;

public class CardPropertyKey
{
    protected java.lang.String  propertyid;


    /**
      * DataBean constructor.
      */
    public CardPropertyKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public CardPropertyKey(CardPropertyKey another) 
    {    	
       propertyid = another.getPropertyid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getPropertyid()         { return propertyid; }
    
    public void setPropertyid(String  p)
    {
         propertyid = p;
    }
}
