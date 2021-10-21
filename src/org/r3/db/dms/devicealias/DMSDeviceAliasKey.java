//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.devicealias;

public class DMSDeviceAliasKey
{
    protected java.lang.String  deviceid;
    protected java.lang.String  clientid;


    /**
      * DataBean constructor.
      */
    public DMSDeviceAliasKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public DMSDeviceAliasKey(DMSDeviceAliasKey another) 
    {    	
       deviceid = another.getDeviceid();
       clientid = another.getClientid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getDeviceid()         { return deviceid; }
    
    public void setDeviceid(String  p)
    {
         deviceid = p;
    }
    
    public java.lang.String   getClientid()         { return clientid; }
    
    public void setClientid(String  p)
    {
         clientid = p;
    }
}
