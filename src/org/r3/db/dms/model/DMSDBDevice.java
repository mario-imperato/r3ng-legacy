package org.r3.db.dms.model;


public class DMSDBDevice extends DMSDevice
{
    DMSDBDevice() throws DMSException
    {
        super();
    }

    public DMSStorageBucket getStorageBucket(String aPhysicalName) throws DMSException
    {        
        return new DMSDBStorageBucket(this, aPhysicalName);
    }

    public void addAlias(DMSContext aDmsContext, DMSDeviceAlias anAlias) throws DMSException
    {
        if (!(anAlias.getDevphysicalnameAsUrl() instanceof DMSDBDeviceUrl))
            throw new DMSException("$DMS_EXC_CODE$: Alias not matched with device type");
        
        super.addAlias(aDmsContext, anAlias);
    }
}
