package org.r3.db.dms.model;


public class DMSDeviceType extends DMSObject
{
    public enum DeviceType { db, filesys };
    
    private DeviceType typeCode = null;
    
    public DMSDeviceType(String aDeviceTypeCode)
    {
        super();
        setTypeCode(aDeviceTypeCode);
    }

    private void setTypeCode(String typeCode)
    {
        this.typeCode = DeviceType.valueOf(typeCode);
    }

    public DeviceType getTypeCode()
    {
        return typeCode;
    }
        
}
