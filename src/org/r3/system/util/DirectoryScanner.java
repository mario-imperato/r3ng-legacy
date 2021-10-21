package org.r3.system.util;

import java.io.File;
import java.io.IOException;

public class DirectoryScanner
{
    private File rootDirectory  = null;

    
    public DirectoryScanner(String rootDirectoryName)
    {
        super();
        
        rootDirectory = new File(rootDirectoryName);
        if (!rootDirectory.isDirectory())
            throw new IllegalArgumentException("Not a directory:  " + rootDirectoryName);
    }

    public  void process() throws IOException, IllegalArgumentException
    {
        process(rootDirectory);        
    }
    
    public  void process(File directory) throws IOException, IllegalArgumentException
    {
        String[] entries = directory.list();

        for (int i = 0; i < entries.length; i++)
        {
            File f = new File(directory, entries[i]);
            if (f.isDirectory())
                process(f);

            visitFile(f);
        }
    }
    
    public void visitFile(File f)
    {
    }
    
}
