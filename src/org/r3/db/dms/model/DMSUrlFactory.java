package org.r3.db.dms.model;



public class DMSUrlFactory
{
    
    public DMSUrlFactory()
    {
        super();
    }
       
    public static DMSUrl newInstance(String aUrl) throws DMSException
    {
        DMSUrl url    = null;
        String locUrl = null;
        
        switch(DMSUrl.getUrlType(aUrl))
        {
            case DMS_DEVICE:
                locUrl = DMSUrl.getPath(aUrl).toUpperCase();
                if (locUrl.indexOf("POOL=") >= 0)
                    url = new DMSDBDeviceUrl(aUrl);
                else
                    url = new DMSFileSystemDeviceUrl(aUrl);
                // if (locUrl.length() > 1 && (locUrl.startsWith("FILE:///") || (Character.isLetter(locUrl.charAt(0)) && locUrl.charAt(1) == ':' )))                                    
                break;                

            case DMS_FILE:
                url = new DMSFileSystemUrl(aUrl);
                break;
                
            case DMS_UNKNOWN:
                locUrl = aUrl.toUpperCase();
                if (locUrl.indexOf("POOL=") >= 0)
                    url = new DMSDBDeviceUrl(aUrl);
                if (locUrl.length() > 1 && (locUrl.startsWith("FILE:///") || (Character.isLetter(locUrl.charAt(0)) && locUrl.charAt(1) == ':' )))
                    url = new DMSFileSystemDeviceUrl(aUrl);                
                break;                
        }
        
        if (url == null)
            url = new DMSFileSystemUrl(aUrl);
        
        return url;                
    }

}
