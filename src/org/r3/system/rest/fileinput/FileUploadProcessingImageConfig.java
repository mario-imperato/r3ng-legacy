package org.r3.system.rest.fileinput;


public class FileUploadProcessingImageConfig 
{	
	private int maxWidth;
	private int maxHeight;

	public FileUploadProcessingImageConfig(String csvOptions)
	{		        
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
					maxWidth = Integer.parseInt(optsArray[0].trim());
					maxHeight = Integer.parseInt(optsArray[1].trim());
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
