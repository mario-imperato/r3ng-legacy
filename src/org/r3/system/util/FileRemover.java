
package org.r3.system.util;

import java.io.File;

public class FileRemover
{
    String          pathToDelete;
    boolean         recurse;
    File            processFile;
    private boolean flag;

    public FileRemover()
    {
        pathToDelete   = "";
        recurse        = false;
        processFile    = null;
        flag           = false;
    }

    public FileActionErrorEvent process()
    {
        FileActionErrorEvent act = null;

        if(!processFile.exists())
        {
            return new FileActionErrorEvent(-1, "The file doesn't exist: " + processFile.getAbsolutePath());
        }

        if(processFile.isFile())
        {
            try
            {
                if(!processFile.delete())
                {
                  return new FileActionErrorEvent(-2, "Error in deleting the file: " + processFile.getAbsolutePath());
                }
            }
            catch(SecurityException _ex)
            {
                  return new FileActionErrorEvent(-3, "Security Exception in deleting the file: " + processFile.getAbsolutePath());
            }
        }
        else
        {
            if(processFile.isDirectory())
                if ((act = deleteFolder(processFile)) != null) return act;
        }
        return act;
    }

    private FileActionErrorEvent deleteFolder(File processFolder)
    {
        FileActionErrorEvent act = null;

        String fileList[] = processFolder.list();
        if(fileList.length != 0)
        {
            for(int i = 0; i < fileList.length; i++)
            {
                File fileDel = new File(processFolder.getPath() + System.getProperty("file.separator") + fileList[i]);
                if(fileDel.isFile())
		   {
                    try
                    {
                        if(!fileDel.delete())
                        {
                         return new FileActionErrorEvent(-2, "Error in deleting the file: " + fileDel.getAbsolutePath());
                        }
                    }
                    catch(SecurityException _ex)
                    {
                        return new FileActionErrorEvent(-3, "Security Exception in deleting the file: " + fileDel.getAbsolutePath());
                    }
		   }
                else
                if(fileDel.isDirectory() && recurse)
                    if ((act = deleteFolder(fileDel)) != null) return act;
            }

        }
        if(recurse)
            try
            {
                if (!processFolder.delete())
                {
                   return new FileActionErrorEvent(-4, "Error in deleting the folder: " + processFolder.getAbsolutePath());
                }
            }
            catch(SecurityException _ex)
            {
                return new FileActionErrorEvent(-3, "Security Exception in deleting the folder: " + processFolder.getAbsolutePath());
            }

         return act;
    }

    public String getInputPathToDelete()
    {
        if(pathToDelete == null)
            pathToDelete = new String();
        return pathToDelete;
    }

    public boolean getRecurse()
    {
        return recurse;
    }

    public void setInputPathToDelete(String pathToDelete)
    {
        this.pathToDelete = pathToDelete;
        if(pathToDelete == null)
            throw new IllegalArgumentException("Can not set inputPath to null!");
        try
        {
            processFile = new File(pathToDelete);
        }
        catch(NullPointerException _ex)
        {
            throw new IllegalArgumentException("Specified path does not exist!");
        }
    }

    public void setRecurse(boolean recurse)
    {
        this.recurse = recurse;
    }

    public static void main(String[] argv)
    {
      FileRemover cp = new FileRemover();
      cp.setInputPathToDelete("/opt/httpd/jakarta-tomcat/webapps/electio/data/workDir/Content");
      //cp.setInputPathToDelete("/opt/electio.jpg");
      cp.setRecurse(true);
      FileActionErrorEvent act = cp.process();
      if (act != null)
        {
          System.out.println("Error: " + act.getReason());
        }
    }

}
