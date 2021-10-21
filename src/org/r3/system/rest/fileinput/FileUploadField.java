package org.r3.system.rest.fileinput;

public class FileUploadField
{
    private String fieldName;
    private String fieldValue;
    
    public FileUploadField(String aName, String aValue)
    {
    	fieldName = aName;
    	fieldValue = aValue;
    }
        
    public String getName()    
    {
        return fieldName;
    }
    
    public String getValue()
    {
        return fieldValue;
    }
    
}
