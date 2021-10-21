
package org.r3.system.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class FileCopierMover
{
    String           sourcePath;
    String           destinationPath;
    int              buffer;
    long             fileLength;
    
    private InputStream  sourceInputStream;
    private OutputStream destinationOutputStream;
    
    boolean          makeDirs;
    boolean          isMoving;
    boolean          replace;

    public FileCopierMover(boolean isMoving)
    {
        sourcePath      =   null;
        destinationPath =   null;
        buffer          = 2048;
        fileLength      =   0L;
        
        setSourceInputStream(null);
        setDestinationOutputStream(null);
        
        makeDirs        = false;
        replace         = false;
        this.isMoving   = isMoving;
    }

    public FileActionErrorEvent process()
    {
        if (sourcePath != null && getSourceInputStream() != null) { return new FileActionErrorEvent(-1,
                "Both source path and source input stream have been specified"); }

        if (destinationPath != null && getDestinationOutputStream() != null) { return new FileActionErrorEvent(-2,
                "Both destination path and destination stream have been specified"); }

        if (isMoving && sourcePath == null)
            return new FileActionErrorEvent(-3, "Cannot Move an InputStream");

        File sourceFile = null;
        File destinationFile = null;
        if (sourcePath != null)
        {
            sourceFile = new File(sourcePath);
            if (!sourceFile.exists()) { return new FileActionErrorEvent(-4, "Source File doesn't exist: "
                    + sourceFile.getAbsolutePath()); }

            if (sourceFile.isDirectory()) { return new FileActionErrorEvent(-5, "SourceFile is a directory: "
                    + sourceFile.getAbsolutePath()); }
        }

        if (destinationPath != null)
        {
            destinationFile = new File(destinationPath);
            if (destinationFile.exists())
            {
                if (replace)
                {
                    if (!destinationFile.delete())
                        return new FileActionErrorEvent(-6, "Destination File exists error on delete: "
                                + destinationFile.getAbsolutePath());
                }
                else
                    return new FileActionErrorEvent(-7, "Destination File exists: " + destinationFile.getAbsolutePath());
            }

            try
            {
                String parentDirectory = destinationFile.getParent();
                File parentDirFile = new File(parentDirectory);
                if (!parentDirFile.exists())
                {
                    if (!makeDirs) { return new FileActionErrorEvent(-8,
                            "Parent Folder doesn't exists and mkDirs not allowed: " + parentDirFile.getAbsolutePath()); }
                    if (makeDirs)
                        parentDirFile.mkdirs();
                }
            }
            catch (NullPointerException _ex)
            {}
        }

        InputStream localSourceInputStream = getSourceInputStream();
        OutputStream localDestinationOutputStream = getDestinationOutputStream();

        byte buf[] = new byte[buffer];
        int counter = 0;
        try
        {
            if (sourcePath != null)
                localSourceInputStream = new FileInputStream(sourceFile);

            if (destinationPath != null)
                localDestinationOutputStream = new FileOutputStream(destinationFile);

            while ((counter = localSourceInputStream.read(buf)) != -1)
            {
                localDestinationOutputStream.write(buf, 0, counter);
            }
        }
        catch (IOException e)
        {
            return new FileActionErrorEvent(-9, "IOException in writing the destination file: "
                    + destinationFile.getAbsolutePath());
        }
        finally
        {
            FileActionErrorEvent errEvent = null;
            if (localDestinationOutputStream != null && destinationPath != null)
            {
                try
                {
                    localDestinationOutputStream.close();
                }
                catch (IOException e1)
                {
                    errEvent = new FileActionErrorEvent(-10, "IOException in closing the destination file: "
                            + destinationFile.getAbsolutePath());
                }
            }

            if (localSourceInputStream != null && sourcePath != null)
            {
                try
                {
                    localSourceInputStream.close();
                }
                catch (IOException e2)
                {
                    errEvent = new FileActionErrorEvent(-11, "IOException in closing the source file: "
                            + sourceFile.getAbsolutePath());
                }
            }
            
            if (errEvent != null)
                return errEvent;
        }
            
        if (isMoving)
                if (!sourceFile.delete())
                    return new FileActionErrorEvent(-12, "Error in deleting the source file: "
                            + sourceFile.getAbsolutePath());

        return null;
    }
    
    public int getBuffer()
    {
        return buffer;
    }

    public long getFileLength()
    {
        return fileLength;
    }

    public String getInputDestinationPath()
    {
        return destinationPath;
    }

    public String getInputSourcePath()
    {
        return sourcePath;
    }

    public boolean getIsMoving()
    {
        return isMoving;
    }

    public boolean getMakeDirs()
    {
        return makeDirs;
    }

    public void setBuffer(int buffer)
    {
        this.buffer = buffer;
    }

    public void setReplaceIfPresent(boolean replace)
    {
        this.replace = replace;
    }

    public void setInputDestinationPath(String destinationPath)
    {
        if(destinationPath == null)
            throw new IllegalArgumentException("Can not set inputDestinationPath to null!");
        this.destinationPath = destinationPath;
    }

    public void setInputSourcePath(String sourcePath)
    {
        if(sourcePath == null)
            throw new IllegalArgumentException("Can not set inputSourcePath to null!");
        this.sourcePath = sourcePath;
    }

    public void setIsMoving(boolean isMoving)
    {
        this.isMoving = isMoving;
    }

    public void setMakeDirs(boolean makeDirs)
    {
        this.makeDirs = makeDirs;
    }

    public void setSourceInputStream(InputStream sourceInputStream)
    {
        this.sourceInputStream = sourceInputStream;
    }

    public InputStream getSourceInputStream()
    {
        return sourceInputStream;
    }

    public void setDestinationOutputStream(OutputStream destinationOutputStream)
    {
        this.destinationOutputStream = destinationOutputStream;
    }

    public OutputStream getDestinationOutputStream()
    {
        return destinationOutputStream;
    }

    public static void main(String[] argv)
    {
      FileCopierMover cp = new FileCopierMover(true);
      cp.setInputSourcePath("/tmp/electio.jpg");
      cp.setInputDestinationPath("/opt/electio.jpg");
      cp.setReplaceIfPresent(true);
      FileActionErrorEvent act = cp.process();
      if (act != null)
        {
          System.out.println("Error: " + act.getReason());
        }
    }

}
