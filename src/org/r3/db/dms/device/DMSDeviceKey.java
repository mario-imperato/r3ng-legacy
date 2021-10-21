//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.device;

public class DMSDeviceKey
{
    protected java.lang.String  deviceid;


    /**
      * DataBean constructor.
      */
    public DMSDeviceKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public DMSDeviceKey(DMSDeviceKey another) 
    {    	
       deviceid = another.getDeviceid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getDeviceid()         { return deviceid; }
    
    public void setDeviceid(String  p)
    {
         deviceid = p;
    }
}
