package org.r3.db.dms.model;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DMSEnvironment
{
    private static String clientIdentifier = "DMSLib_ClientId";
    
    static
    {
        try
        {
            InetAddress a = InetAddress.getLocalHost();
            setClientIdentifier(a.getHostName());
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
    }
    
    public DMSEnvironment()
    {
        super();
    }

    public static void setClientIdentifier(String aClientIdentifier)
    {
        clientIdentifier = aClientIdentifier;
    }

    public static String getClientIdentifier()
    {
        return clientIdentifier;
    }

}
