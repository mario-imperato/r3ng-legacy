package org.r3.db.dms.model;


import java.util.ArrayList;
import java.util.List;

import org.r3.db.dms.device.DMSDeviceDTO;
import org.r3.db.dms.device.DMSDevicePersistence;

public class DMSDeviceFactory
{
    public DMSDeviceFactory()
    {
        super();
    }

    public DMSDevice findDevice(DMSContext aDmsContext, String deviceIdentifier) throws DMSException
    {        
        DMSDevice retDevice = null;
        try
        {
    		DMSDevicePersistence p = DMSDevicePersistence
    						.createPersistenceObject(aDmsContext.getPersistenceContext(), aDmsContext.getSession());
            
            DMSDeviceDTO deviceDataBean = p.selectByDeviceid(deviceIdentifier, aDmsContext.getPersistenceContext().getPersistenceConfigInfo());                                               
            if (deviceDataBean != null)
            {                
                retDevice = instantiateDevice(new DMSDeviceType(deviceDataBean.getDevicetype()));
                retDevice.copyFrom(deviceDataBean);
            }
            else
            {
                throw new DMSException("$DMS_EXC_CODE$: Device cannot be found");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace(System.err);
            throw new DMSException(e);
        }
        finally
        {         
        }
        
        return retDevice;
    }

    public List<DMSDevice> listDevices(DMSContext aDmsContext) throws DMSException
    {
        return listDevicesOfType(aDmsContext, null);  
    }
    
    public List<DMSDevice> listDevicesOfType(DMSContext aDmsContext, DMSDeviceType aDevType) throws DMSException
    {
        List<DMSDevice> listOfDevices = null;
        try
        {
    		DMSDevicePersistence p = DMSDevicePersistence
    						.createPersistenceObject(aDmsContext.getPersistenceContext(), aDmsContext.getSession());

    		List<DMSDeviceDTO>    listOfDeviceDataBean = null;
            if (aDevType != null)
            {
                listOfDeviceDataBean = p.select(null, aDmsContext.getPersistenceContext().getPersistenceConfigInfo()); 
            }
            else
            {
                listOfDeviceDataBean = p.select(null, aDmsContext.getPersistenceContext().getPersistenceConfigInfo());    
            }
                        
            if (listOfDeviceDataBean != null && listOfDeviceDataBean.size() > 0)
            {
                listOfDevices = new ArrayList<DMSDevice>(listOfDeviceDataBean.size());
                for(DMSDeviceDTO dto : listOfDeviceDataBean)
                {
                    DMSDevice aDevice = instantiateDevice(dto);
                    listOfDevices.add(aDevice);
                }
            }

        }
        catch (Exception e)
        {
            e.printStackTrace(System.err);
            throw new DMSException(e);
        }
        finally
        {
        }

        return listOfDevices;        
    }

    public DMSDevice instantiateDevice(DMSDeviceType aDevType) throws DMSException
    {
        DMSDevice aDevice = null;
        
        switch(aDevType.getTypeCode())
        {
            case db:
                   aDevice = new DMSDBDevice();
                   break;

            case filesys:
                   aDevice = new DMSFileSystemDevice();                
                   break;
        }
        
        aDevice.setDevType(aDevType);
        return aDevice;
    }

    private DMSDevice instantiateDevice(DMSDeviceDTO aDeviceDataBean) throws DMSException
    {
        DMSDevice aDevice = null;
        DMSDeviceType devType = new DMSDeviceType(aDeviceDataBean.getDevicetype());
        
        switch(devType.getTypeCode())
        {
            case db:
                   aDevice = new DMSDBDevice();
                   break;

            case filesys:
                   aDevice = new DMSFileSystemDevice();                
                   break;
        }
        
        aDevice.copyFrom(aDeviceDataBean);
        return aDevice;
    }

}
