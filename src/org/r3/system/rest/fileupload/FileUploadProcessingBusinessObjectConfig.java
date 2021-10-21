package org.r3.system.rest.fileupload;

public class FileUploadProcessingBusinessObjectConfig extends FileUploadProcessingConfig
{
    private Object businessObject;
    
	public FileUploadProcessingBusinessObjectConfig()
	{
		super(ConfigParamClass.businessobject);
	}

	public FileUploadProcessingBusinessObjectConfig(Object o)
	{
		super(ConfigParamClass.businessobject);
		businessObject = o;
	}
	
	public Object getBusinessObject()
	{
		return businessObject;
	}

	public void setBusinessObject(Object businessObject)
	{
		this.businessObject = businessObject;
	}

	
}
