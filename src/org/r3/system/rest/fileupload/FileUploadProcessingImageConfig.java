package org.r3.system.rest.fileupload;


public class FileUploadProcessingImageConfig extends FileUploadProcessingConfig
{
	private String optionsName;
	
	private int maxWidth;
	private int maxHeight;

	public FileUploadProcessingImageConfig(ConfigParamClass optionClass, String aName, String csvOptions)
	{
		super(optionClass);

		optionsName = aName;
        
		if (csvOptions == null || csvOptions.trim().length() == 0)
			setDefaults();
		else
		{
			String[] optsArray = csvOptions.split(",");
			if (optsArray.length != 2)
				setDefaults();
			else
			{
				try
				{
					maxWidth = Integer.parseInt(optsArray[0]);
					maxHeight = Integer.parseInt(optsArray[1]);
				}
				catch (Exception e)
				{
					e.printStackTrace();
					setDefaults();
				}
			}
		}
	}

	private void setDefaults()
	{
		maxWidth = -1;
		maxHeight = -1;
	}

	public boolean isResizeRequired(int currentWidth, int currentHeight)
	{
		return maxWidth > 0 && maxHeight > 0 && (currentWidth > maxWidth || currentHeight > maxHeight);
	}

	public int getMaxWidth()
	{
		return maxWidth;
	}

	public int getMaxHeight()
	{
		return maxHeight;
	}
}
