
package org.r3.system.util;

import java.util.EventListener;

public interface FileFoundListener
    extends EventListener
{
    public abstract void fileFound(FileFoundEvent filefoundevent);
}

