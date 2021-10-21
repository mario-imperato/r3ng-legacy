
package org.r3.system.util;

import java.util.EventObject;

public class FileFoundEvent extends EventObject
{
    private String fileName = null;

    public FileFoundEvent(Object source, String fName)
    {
        super(source);
        this.fileName = fName;
    }

    public String getPathName()           { return fileName; }
}

