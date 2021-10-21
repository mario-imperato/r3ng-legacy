package org.r3.system.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class UnzipUtil
{
    private File sourceFile           = null;
    private File destinationDirectory = null;
    private boolean useFolderNames = true;
    private boolean overWrite      = true;
    
    public UnzipUtil(String sourceFileName, String destinationDirectoryName) throws IOException
    {
        this(sourceFileName, destinationDirectoryName, true, true);
    }
    public UnzipUtil(String sourceFileName, String destinationDirectoryName, boolean useFolderNamesFlag, boolean overWriteFlag) throws IOException
    {
        super();
        if (sourceFileName == null || destinationDirectoryName == null)
            throw new IOException("Source File and target Directory Must != null " + sourceFileName + "/" + destinationDirectoryName);
        
        this.sourceFile = new File(sourceFileName);
        if (!sourceFile.exists() || !sourceFile.isFile())
            throw new IOException("Could not find file: " + sourceFileName);
        
        this.destinationDirectory = new File(destinationDirectoryName);
        if (!destinationDirectory.exists() || !destinationDirectory.isDirectory())
            throw new IOException("Could access destinationDirectory: " + destinationDirectoryName);
        
        useFolderNames = useFolderNamesFlag; 
        overWrite = overWriteFlag;
    }

    public static final void copyInputStream(InputStream in, OutputStream out) throws IOException
    {
        byte[] buffer = new byte[1024];
        int len;

        while ((len = in.read(buffer)) >= 0)
            out.write(buffer, 0, len);

        in.close();
        out.close();
    }

    public void process()
    {
        Enumeration entries;
       

        try ( ZipFile zipFile = new ZipFile(sourceFile);)
        {
            

            entries = zipFile.entries();

            while (entries.hasMoreElements())
            {
                ZipEntry entry = (ZipEntry) entries.nextElement();

                if (entry.isDirectory())
                {
                    // Assume directories are stored parents first then
                    // children.
                    System.err.println("Extracting directory: " + entry.getName());

                    if (useFolderNames)
                    {
                        File directory = new File(destinationDirectory, entry.getName());
                        if (!directory.exists())
                            directory.mkdirs();
                    }
                    continue;
                }

                String entryName = entry.getName();
                if (!useFolderNames)
                {
                    int ndx = entryName.lastIndexOf('/');
                    if (ndx >= 0)
                        entryName = entryName.substring(ndx + 1);
                }
                
                File targetFile = new File(destinationDirectory, entryName);
                if (overWrite || !targetFile.exists())
                {
                	try(FileOutputStream fos = new FileOutputStream(targetFile); BufferedOutputStream bos = new BufferedOutputStream(fos);)
                	{
                    copyInputStream(zipFile.getInputStream(entry), bos);
                	}
                }
            }

           
        }
        catch (IOException ioe)
        {
            System.err.println("Unhandled exception:");
            ioe.printStackTrace();
            return;
        }
    }

    public static void main(String[] args) throws IOException
    {
        UnzipUtil zu = new UnzipUtil(args[0], args[1], false, true);
        zu.process();
    }
}
