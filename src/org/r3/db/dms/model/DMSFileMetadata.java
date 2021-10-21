/**
 * Nome File 	: DMSFileMetadata.java
 * Progetto 	: gwf_struts
 * Sottosistema : it.gwf_struts.gwfdms.model
 * Modulo 		: 
 * Errori		:
 * Description	: descrizione
 *
 * Modifiche :
 *          21-apr-2006 :     -prima versione
 */

package org.r3.db.dms.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author dada
 *
 */
public class DMSFileMetadata implements Cloneable
{
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public enum DMSFileMetadataCoreProperty { fileName, contentLength, contentType, creationDate, dmsUrlFileName, numberOfPages, clientFileName };
    
//    static final String DMSFILEMETA_SOURCEFILENAMEPROPERTY = "_SOURCE-FILENAME";
//    static final String DMSFILEMETA_CONTENTLENGTHPROPERTY = "_CONTENT-LENGTH";
//    static final String DMSFILEMETA_CONTENTTYPEPROPERTY = "_CONTENT-TYPE";
    
    private Properties metadata = null;
    
    /**
     * 
     */
    public DMSFileMetadata()
    {
        super();
    }

    public static boolean isSystemProperty(String aPropertyName)
    {
        if (aPropertyName.startsWith("_")) return true;
        return false;    
    }
    
    public void setProperty(String propertyName, String propertyValue)
    {
        getMetadata().setProperty(propertyName, propertyValue);
    }

    public String getProperty(String property, String defaultValue)
    {
        return getMetadata().getProperty(property, defaultValue);
    }

    public void setDMSUrlFileName(String aFileName)
    {
        getMetadata().setProperty(DMSFileMetadataCoreProperty.dmsUrlFileName.toString(), aFileName);
    }

    // MOD4GWF_30
    public String getDMSUrlFileName(String aFileName)
    {
    	return getMetadata().getProperty(DMSFileMetadataCoreProperty.dmsUrlFileName.toString());
    }

    public void setFileName(String aFileName)
    {
        getMetadata().setProperty(DMSFileMetadataCoreProperty.fileName.toString(), aFileName);
    }

    public String getFileName()
    {
        return getMetadata().getProperty(DMSFileMetadataCoreProperty.fileName.toString());
    }

    public void setClientFileName(String aFileName)
    {
        getMetadata().setProperty(DMSFileMetadataCoreProperty.clientFileName.toString(), aFileName);
    }

    public String getClientFileName()
    {
    	String s =  getMetadata().getProperty(DMSFileMetadataCoreProperty.clientFileName.toString());
    	if (s == null)
    		return getFileName();
    	
        return s;
    }
    
    public void setCreationDate()
    {        
        java.util.Date aDate = new java.util.Date();
        getMetadata().setProperty(DMSFileMetadataCoreProperty.creationDate.toString(), dateFormat.format(aDate));
    }

    public void setCreationDate(java.util.Date aDate)
    {        
        getMetadata().setProperty(DMSFileMetadataCoreProperty.creationDate.toString(), dateFormat.format(aDate));
    }

    public java.util.Date getCreationDate()
    {
        String creationDateStr = getMetadata().getProperty(DMSFileMetadataCoreProperty.creationDate.toString());
        
        java.util.Date theDate = null;
        if (creationDateStr != null)
        {
            try
            {
                theDate = dateFormat.parse(creationDateStr);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        }
        
        return theDate;
    }

    public void setContentType(String contentType)
    {
        getMetadata().setProperty(DMSFileMetadataCoreProperty.contentType.toString(), contentType);
    }

    public String getContentType()
    {
        return getMetadata().getProperty(DMSFileMetadataCoreProperty.contentType.toString());
    }

    public boolean isContentTypeHTMLFriendly()
    {
        String ct = getContentType();
        if (ct == null)
            return false;
        
        if (ct.equalsIgnoreCase("image/jpeg") || ct.equalsIgnoreCase("text/plain") || ct.equalsIgnoreCase("image/png") || ct.equalsIgnoreCase("image/gif"))
            return true;
        
        return false;
    }

    public void setNumberOfPages(int numberOfPages)
    {
        getMetadata().setProperty(DMSFileMetadataCoreProperty.numberOfPages.toString(), String.valueOf(numberOfPages));
    }

    public int getNumberOfPages()
    {
        int retVal = 0;
        String size = getMetadata().getProperty(DMSFileMetadataCoreProperty.numberOfPages.toString(), null);
        if (size != null)  
        {
            try
            {
                retVal = Integer.parseInt(size);
            }
            catch(NumberFormatException exc)
            {
                exc.printStackTrace();
            }
        }
        
        return retVal;        
    }

    public void setContentLength(long fileSize)
    {
        getMetadata().setProperty(DMSFileMetadataCoreProperty.contentLength.toString(), String.valueOf(fileSize));
    }

    public long getContentLength()
    {
        long retVal = 0;
        String size = getMetadata().getProperty(DMSFileMetadataCoreProperty.contentLength.toString(), null);
        if (size != null)  
        {
            try
            {
                retVal = Long.parseLong(size);
            }
            catch(NumberFormatException exc)
            {
                exc.printStackTrace();
            }
        }
        
        return retVal;        
    }

    public Enumeration propertyNames()
    {
        return getMetadata().propertyNames();
    }
    
    void store(OutputStream aStream) throws IOException
    {
        getMetadata().store(aStream, "DMSFile Metadata");
    }
    
    void load(InputStream anInputStream) throws IOException
    {                
        getMetadata().load(anInputStream);
    }
    
    private Properties getMetadata()
    {
        if (metadata == null)  metadata = new Properties();        
        return metadata;
    }
    
    @Override
    protected DMSFileMetadata clone() throws CloneNotSupportedException 
    {
        DMSFileMetadata clone=(DMSFileMetadata)super.clone();

        // make the shallow copy of the object of type Department
        clone.metadata=(Properties)metadata.clone();
        return clone;
      }

}
