package org.r3.system.storage;

import java.io.File;
import java.nio.file.Path;

import org.r3.db.dms.model.SimpleDMSConstants;
import org.r3.system.util.Codecs;

public abstract class StorageManager
{
	public enum StorageManagerType
	{
		unknown, dms, mongo, swift;

		public static StorageManagerType getStorageManagerType4(String s, StorageManagerType defaultValue)
		{
			StorageManagerType smt = defaultValue;

			if (s != null && !s.isEmpty())
			{

				try
				{
					smt = StorageManagerType.valueOf(s);
				}
				catch (Exception exc)
				{
					exc.printStackTrace();
				}
			}
			return smt;
		}
	};
	
	private StorageManagerConfig storageManagerConfig;
		
	public StorageManagerConfig getStorageManagerConfig()
	{
		return storageManagerConfig;
	}
	
	public void setStorageManagerConfig(StorageManagerConfig storageManagerConfig)
	{
		this.storageManagerConfig = storageManagerConfig;
	}
	
	public abstract StorageObject newStorageObjectInstance();	
	public abstract StorageObject put(Path aFolderPath, StorageObject anObject) throws StorageException;
	public abstract StorageObject get(StorageUrl aUrl) throws StorageException;
	
    final static 	public	String 			ENABLED_BASIC_CHARACTERS	= "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	final static 	public	String 			FOLDER_ENABLED_CHARACTERS	= ENABLED_BASIC_CHARACTERS+"\\/._-";

    protected static String wellFormFileName(String aFilename, boolean useForwardSlashes)
    {
        if (aFilename == null || aFilename.length() == 0)
            return "wellformfilename";
                        
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
        
        aFilename = stb.toString().toLowerCase();
        if (useForwardSlashes && File.separator.equalsIgnoreCase("\\"))
        {
        	aFilename = aFilename.replace('\\', '/');
        }
        	
        return aFilename;
    }
    
}
