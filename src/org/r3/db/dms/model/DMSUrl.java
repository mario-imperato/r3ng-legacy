package org.r3.db.dms.model;


import java.io.Serializable;

import org.r3.system.util.Codecs;

public abstract class DMSUrl implements Serializable
{
    public enum UrlType { DMS_UNKNOWN, DMS_DEVICE, DMS_FILE };
    
    /**
     * Identifica il root folder logico.
     */
    public static DMSFileSystemUrl DMSFILESYSTEM_ROOTURL;
    
    //public static final String URLSCHEME             = "DMS://";

    static 
    {
        try
        {
            DMSFILESYSTEM_ROOTURL = new DMSFileSystemUrl(SimpleDMSConstants.ROOT_FOLDER);
        }
        catch (DMSException e)
        {
            e.printStackTrace();
        }
    }

    private String theUrl;
    
    public DMSUrl()
    {
        super();
    }

    public static UrlType getUrlType(String aUrl)
    {
        aUrl = aUrl.toUpperCase();
        
        if (aUrl.startsWith(UrlType.DMS_DEVICE.toString()))
              return UrlType.DMS_DEVICE;
        
        if (aUrl.startsWith(UrlType.DMS_FILE.toString()))
              return UrlType.DMS_FILE;
        
        return UrlType.DMS_UNKNOWN;
    }
    
    /**
     * Funzione che valuta se l'url e' ben formato oppure no. Ritorna un valore booleano
     * in risposta all'attivita' di verifica. Implementazione corrente sostanzialmente vuota.
     * 
     * @param aUrl
     * @return
     */
    protected abstract boolean isWellFormed(String aUrl);

    /**
     * Funzione che ritorna lo schema dello url.
     * 
     * @return
     */
    protected abstract String getSchema();
    
    /**
     * Ritorna il valore corrente dell'URL. Questo valore risulta uguale a quello inizializzato
     * nel costruttore al netto delle sostituzioni tra caratteri '/' e '\\' e eventuali normalizzazioni
     * (Eliminazione /../ e /./)
     * 
     * @return
     */
    public String getUrl()
    {        
        return  theUrl;
    }
    
    /**
     * Ritorna una versione dell'Url priva dello schema: ovvero tolgo lo schema e i 3 caratteri di :// 
     */
    public String getPath()
    {
        String tmp = theUrl.substring(getSchema().length() + 3);
        
        return tmp;
    }

    /**
     * Ritorna una versione dell'Url priva dello schema: ovvero tolgo lo schema e i 3 caratteri di :// 
     */
    public static String getPath(String aUrl)
    {
        UrlType ut = DMSUrl.getUrlType(aUrl);
        if (ut != UrlType.DMS_UNKNOWN)
        {
            aUrl = aUrl.substring(ut.toString().length() + 3);
        }
                   
        return aUrl;
    }

    protected void setUrl(String aUrl)
    {        
        if (!DMSUrl.isDMSUrl(aUrl))
            aUrl = new StringBuffer(getSchema()).append("://").append(aUrl).toString();
        
        theUrl = aUrl;
    }

    public String toString()
    {
        return getUrl();    
    }

    public static boolean isDMSUrl(String aUrl)
    {
        aUrl = aUrl.toUpperCase();
        return DMSUrl.getUrlType(aUrl) != UrlType.DMS_UNKNOWN;
    }

    /**
     * Funzione che provvede a convertire nomi di file poco amichevoli. 
     * I caratteri ammessi vengono mantenuti inalterati mentre i caratteri speciali vengono trasformati:
     * lo spazio viene convertito in '_' mentre gli altri vengono convertiti secondo una codifica esadecimale ASCII.
     * 
     * @param aFilename
     * @return
     */
    public static String wellFormFileName(String aFilename)
    {
        if (aFilename == null || aFilename.length() == 0)
            return "WELLFORMFILENAME";
                        
        StringBuffer stb = new StringBuffer();
        for(int i = 0; i < aFilename.length(); i++)
        {
            char c = aFilename.charAt(i);
            if (SimpleDMSConstants.FOLDER_ENABLED_CHARACTERS.indexOf(c) >= 0)
                stb.append(c);
            else
            {
                if (c == ' ')
                     stb.append('_');
                else stb.append('x').append(Codecs.byteToHex((byte)c));
            }            
        }
        
        aFilename = stb.toString().toUpperCase();
        
        return aFilename;
    }
}
