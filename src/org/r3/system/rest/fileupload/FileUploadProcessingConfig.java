package org.r3.system.rest.fileupload;

public abstract class FileUploadProcessingConfig
{	
     public enum ConfigParamClass { image, icon, file, businessobject }
     
     private ConfigParamClass optionClass;
     
     public FileUploadProcessingConfig(ConfigParamClass anOptionClass)
     {
    	 optionClass = anOptionClass;
     }
     
     public ConfigParamClass getOptionClass()
     {
    	 return optionClass;
     }
}
