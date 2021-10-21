package org.r3.db.dms.model;

import org.r3.db.dms.model.DMSDeviceType.DeviceType;


public abstract class DMSDeviceUrl  extends DMSUrl
{
    
    public  DMSDeviceUrl()
    {
        super();
    }
    
    @Override
    protected String getSchema()
    {
        return UrlType.DMS_DEVICE.toString();
    }
    
    public abstract DeviceType getDeviceType();

}
