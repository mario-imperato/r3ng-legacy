package org.r3.system.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtil
{
    private File rootDirectory  = null;
    private File zipFile        = null;
    private ZipOutputStream out = null;
    private String rootPath     = null;
    
    public ZipUtil(String rootDirectoryName, String zipFileName)
    {
        super();
        
        rootDirectory = new File(rootDirectoryName);
        if (!rootDirectory.isDirectory())
            throw new IllegalArgumentException("Not a directory:  " + rootDirectoryName);

        rootPath = rootDirectory.getParent();
        
        zipFile = new File(zipFileName);
    }

    public  void process() throws IOException, IllegalArgumentException
    {
        try
        {
            process(rootDirectory);
        }
        finally
        {
            if (out != null)
                out.close();
        }
        
    }
    
    public  void process(File directory) throws IOException, IllegalArgumentException
    {
        String[] entries = directory.list();
        byte[] buffer = new byte[4096];
        int bytesRead;

        if (out == null) 
            out = new ZipOutputStream(new FileOutputStream(zipFile));

        for (int i = 0; i < entries.length; i++)
        {
            File f = new File(directory, entries[i]);
            if (f.isDirectory())
                process(f);
            else
            {
            	try(FileInputStream in = new FileInputStream(f);)
            	{
            		 ZipEntry entry = new ZipEntry(getPath(f)); 
                     out.putNextEntry(entry);
                     
                     while ((bytesRead = in.read(buffer)) != -1)
                         out.write(buffer, 0, bytesRead);
            	}
                                                                      
            }
        }

    }

    private String getPath(File f)
    {
        String filePath = f.getPath();
        if (filePath.startsWith(rootPath) && filePath.length() > rootPath.length())
            filePath = filePath.substring(rootPath.length() + 1);
        
        return filePath;
    }
    
    public static final void main(String[] args) throws IllegalArgumentException, IOException
    {
       ZipUtil z = new ZipUtil("c:\\tmp\\GWFEMITTER", "c:\\mioZip.zip");
       z.process();
    }
}
