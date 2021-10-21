package org.r3.db.dms.model;

import org.r3.db.dms.devicealias.DMSDeviceAliasDTO;




public class DMSDeviceAlias extends DMSDeviceAliasDTO
{   
    public final static String ALIAS_WILDCARD  = "*";
    public final static String MOUNT_WINSHARE  = "WINSHARE";
    
    private DMSUrl devphysicalname = null;
    
    public DMSDeviceAlias(String clientId, DMSUrl physicalName) throws DMSException
    {
        super();
        
        this.setClientid(clientId);
        this.setDevphysicalnameAsUrl(physicalName);        
    }

    public DMSDeviceAlias(DMSDeviceAliasDTO another) throws DMSException
    {
        super(another);
        this.setDevphysicalnameAsUrl(DMSUrlFactory.newInstance(another.getDevicephysicalname()));
    }

    private void setDevphysicalnameAsUrl(DMSUrl devphysicalname)
    {
        this.devphysicalname = devphysicalname;
    }

    public DMSUrl getDevphysicalnameAsUrl()
    {
        return devphysicalname;
    }
    
    public boolean isDefaultAlias()
    {
        return clientid.equalsIgnoreCase(ALIAS_WILDCARD);
    }
             
}
