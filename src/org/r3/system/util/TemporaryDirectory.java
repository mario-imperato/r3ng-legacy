package org.r3.system.util;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class TemporaryDirectory extends SystemDirectory
{
	private File    tempDir;
    private boolean managed;
    
    public TemporaryDirectory(String aTempRootLocation, boolean managedFlag)
    {
    	super(aTempRootLocation, "/tmp");
    	    	    	
    	tempDir = new File(rootLocation, generateSubDirectoryName());
    	if (!tempDir.exists())
    		tempDir.mkdirs();    	    	
    	
    	managed = managedFlag;
    }
    
    public boolean isManaged()
	{
		return managed;
	}

    public String getAbsolutePath()
    {
        return tempDir.getAbsolutePath();	
    }
    
	public void setManaged(boolean managed)
	{
		this.managed = managed;
	}

	public File getFile(String aFileName)
    {		  	    	
    	File f = new File(tempDir, timestampFileName(aFileName));
    	return f;
    }
    
	private String timestampFileName(String aFileName)
	{
		Calendar c = Calendar.getInstance();  
	    return String.format(aFileName, sf.format(c.getTime()));	
	}
	
    public File getFolder(String aFileName)
    {
    	File f = new File(tempDir, aFileName);
    	f.mkdirs();
    	return f;
    }
    
    public File zipTo(String aFileName) throws IOException
    {
    	// Osservazione: il file viene scritto nella directory stessa ma non viene incluso nello zip in quanto la ZipUtils
    	// lo .... salta..
    	File zipFile = getFile(aFileName);
        ZipUtils.zip(tempDir, zipFile);
        return zipFile;
    }
    
    @Override
    public void release()
    {
    	if (isManaged())
           tempDir.renameTo(new File(tempDir.getAbsolutePath() + ".done"));
    }
        
    private String generateSubDirectoryName()
    {   	
    	Calendar c = Calendar.getInstance();    	    	
    	StringBuilder stb = new StringBuilder();
    	stb.append("tmpd.")
    	   .append(sf.format(c.getTime()))
    	   .append("_")
    	   .append(Thread.currentThread().getName());
    	
    	return stb.toString();
    }
    
}
