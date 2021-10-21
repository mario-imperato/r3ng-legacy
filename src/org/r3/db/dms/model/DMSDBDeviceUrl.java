package org.r3.db.dms.model;



import java.util.StringTokenizer;

import org.r3.db.dms.model.DMSDeviceType.DeviceType;

public class DMSDBDeviceUrl extends DMSDeviceUrl
{
    public enum DBUrlAttributes { POOL, DATA, META, UNKNOWN };

    private String poolName          = null;

    private String dataTableName     = null;

    private String metadataTableName = null;

    public DMSDBDeviceUrl(String aPoolName, String aDataTableName, String aMetadataTableName) throws DMSException
    {
        dataTableName = aDataTableName;
        poolName = aPoolName;
        if (aMetadataTableName != null && aMetadataTableName.length() > 0)
        {
             metadataTableName = aMetadataTableName;    
        }
        else metadataTableName = dataTableName + "Property";
        
        setUrl(toStringUrl());
    }

    public DMSDBDeviceUrl(String aUrl) throws DMSException
    {
        super();

        // Tolgo lo schema per le operazioni di parsing e poi provvedo a reinserirlo....
        aUrl = DMSUrl.getPath(aUrl);
        
        StringTokenizer strTok = new StringTokenizer(aUrl, ";=", true);

        DBUrlAttributes  attribute = getAttributeName(strTok);
        while (attribute != DBUrlAttributes.UNKNOWN)
        {
            if (!strTok.hasMoreTokens() || strTok.nextToken().charAt(0) != '=')
            {
                DMSException exc = new DMSException("$DMS_EXC_CODE$: Malformed URL");
                throw exc;
            }

            switch (attribute)
            {
                case POOL:
                    poolName = getAttributeValue(strTok);
                    break;
                case DATA:
                    dataTableName = getAttributeValue(strTok);
                    break;
                case META:
                    metadataTableName = getAttributeValue(strTok);
                    break;
            }
            
            attribute = getAttributeName(strTok);
        }

        if (!isWellFormed(aUrl))
        {
            DMSException exc = new DMSException("$DMS_EXC_CODE$: Malformed URL");
            throw exc;
        }

        if (metadataTableName == null)
        {
            metadataTableName = dataTableName + "Property";
        }

        setUrl(aUrl);
    }

    private DBUrlAttributes getAttributeName(StringTokenizer strTok)
    {
        if (!strTok.hasMoreTokens())
            return DBUrlAttributes.UNKNOWN;

        String token = strTok.nextToken();
        while (token.charAt(0) == ';')
        {
            if (!strTok.hasMoreTokens())
                return DBUrlAttributes.UNKNOWN;

            token = strTok.nextToken();
        }

        DBUrlAttributes attr = DBUrlAttributes.UNKNOWN;
        try
        {
          attr = DBUrlAttributes.valueOf(token.toUpperCase());
        }
        catch(Exception e)
        { 
           e.printStackTrace();
        }
        
        return attr;
    }

    private String getAttributeValue(StringTokenizer strTok)
    {
        if (!strTok.hasMoreTokens())
            return null;

        return strTok.nextToken();
    }

    protected boolean isWellFormed(String aUrl)
    {
        if (poolName == null || dataTableName == null)
            return false;

        return true;
    }

    public String getPoolName()
    {
        return poolName;
    }

    public String getDataTableName()
    {
        return dataTableName;
    }

    public String getMetadataTableName()
    {
        return metadataTableName;
    }


    private String toStringUrl()
    {
        StringBuffer stb = new StringBuffer();
        stb.append("pool=").append(poolName).append(";");
        stb.append("data=").append(dataTableName).append(";");
        stb.append("meta=").append(metadataTableName).append(";");
        
        return stb.toString();
    }

    @Override
    public DeviceType getDeviceType()
    {
        return DeviceType.db;
    }

}
