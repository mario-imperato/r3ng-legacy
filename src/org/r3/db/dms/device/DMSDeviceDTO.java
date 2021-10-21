//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.device;



public class DMSDeviceDTO extends DMSDeviceDTOBase
{
    public DMSDeviceDTO()
    {
        super();
    }

    public DMSDeviceDTO(DMSDeviceDTO another)
    {
        super(another);
    }

    public void copyFrom(DMSDeviceDTOBase another)
    {
       deviceid = another.getDeviceid();
       devicename = another.getDevicename();
       devicetype = another.getDevicetype();

       dirtyFlagsArray = another.getCopyOfDirtyFlags();
    }
}
