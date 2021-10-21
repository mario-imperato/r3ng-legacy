package org.r3.db.dms.model;

public class DMSFileSystemDevice extends DMSDevice
{
    DMSFileSystemDevice() throws DMSException
    {
        super();
    }

    public DMSStorageBucket getStorageBucket(String aPhysicalName) throws DMSException
    {        
        return new DMSFileSystemStorageBucket(this, aPhysicalName);
    }

    public void addAlias(DMSContext aDmsContext, DMSDeviceAlias anAlias) throws DMSException
    {
        if (!(anAlias.getDevphysicalnameAsUrl() instanceof DMSFileSystemDeviceUrl))
            throw new DMSException("$DMS_EXC_CODE$: Alias not matched with device type");
        
        super.addAlias(aDmsContext, anAlias);
    }
}
