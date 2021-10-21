package org.r3.db.dms.model;

import org.r3.db.dms.model.DMSDeviceType.DeviceType;


public class DMSFileSystemDeviceUrl extends DMSDeviceUrl
{
    public DMSFileSystemDeviceUrl(String aUrl) throws DMSException
    {
        super();

        if (!isWellFormed(aUrl))
        {
            DMSException exc = new DMSException("$DMS_EXC_CODE$: Malformed URL");
            throw exc;
        }

        setUrl(aUrl);
    }

    protected boolean isWellFormed(String aUrl)
    {
        return true;
    }

    @Override
    public DeviceType getDeviceType()
    {
        return DeviceType.filesys;
    }

}
