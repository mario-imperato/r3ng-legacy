//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.otp;

public class OTPKey
{
    protected java.lang.String  digest;


    /**
      * DataBean constructor.
      */
    public OTPKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public OTPKey(OTPKey another) 
    {    	
       digest = another.getDigest();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getDigest()         { return digest; }
    
    public void setDigest(String  p)
    {
         digest = p;
    }
}
