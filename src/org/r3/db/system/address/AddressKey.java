//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.address;

public class AddressKey
{
    protected java.lang.String  addressid;


    /**
      * DataBean constructor.
      */
    public AddressKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public AddressKey(AddressKey another) 
    {    	
       addressid = another.getAddressid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getAddressid()         { return addressid; }
    
    public void setAddressid(String  p)
    {
         addressid = p;
    }
}
